package com.zer0.hardcore.blocks;

import java.util.Random;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.tile_entities.TileEntityBronzeFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BronzeFurnace extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;
	
	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();

	protected BronzeFurnace(boolean isActive) {
		super(Material.rock);
		isBurning2 = isActive;
		
		if(isBurning2)
		{
			this.setLightLevel(0.5F);
		}
		
		this.setHardness(10.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":bronzeFurnaceSide");
		this.front = iconRegister.registerIcon(this.isBurning2 ? Reference.MODID + ":bronzeFurnaceActive"
												: Reference.MODID + ":bronzeFurnaceInactive");
		
		this.top = iconRegister.registerIcon(Reference.MODID + ":bronzeFurnaceTop");
	}
	
	public IIcon getIcon(int side, int meta)
	{
		if(side == 1)
		{
			return top;
		}
		else if(side == meta)
		{
			return front;
		}
		else
		{
			return this.blockIcon;
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		player.openGui(MCHardcore.modInstance, 0, world, x, y, z);
		return true;
	}
	
	public Item getItemDropped(int par1, Random random, int par3)
	{
		return Item.getItemFromBlock(ModBlocks.bronzeFurnace);
	}
	
	public Item getItem(World world, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(ModBlocks.bronzeFurnace);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
		byte b0 = 3;
		b0=rotateBlock(b0, entity);
		world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    }
	
	public byte rotateBlock(byte b0, EntityLivingBase entity)
	{
		
		if((entity.rotationYaw >= 135 && entity.rotationYaw <= 181) || (entity.rotationYaw <= -135 && entity.rotationYaw >= -181))
		{
			b0 = 3;
		}
		else if(entity.rotationYaw > -135 && entity.rotationYaw < -45)
		{
			b0 = 4;
		}
		else if(entity.rotationYaw >= -45 && entity.rotationYaw <= 45)
		{
			b0 = 2;
		}
		else if(entity.rotationYaw > 45 && entity.rotationYaw < 135)
		{
			b0 = 5;

		}
		else if(entity.rotationYaw >= 181)
		{
			entity.rotationYaw = entity.rotationYaw - 360;
			b0 = rotateBlock(b0, entity);
		}
		else if(entity.rotationYaw <= -181)
		{
			entity.rotationYaw = entity.rotationYaw + 360;
			b0 = rotateBlock(b0, entity);
		}
		return b0;
	}
	
	public static void updateBlockState(boolean burning, World world, int x, int y, int z)
	{
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		isBurning = true;
		
		if(burning)
		{
			world.setBlock(x, y, z, ModBlocks.bronzeFurnaceActive);
		}
		else
		{
			world.setBlock(x, y, z, ModBlocks.bronzeFurnace);
		}
		
		isBurning = false;
		
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
		
		if(tileEntity != null)
		{
			tileEntity.validate();
			world.setTileEntity(x, y, z, tileEntity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		if(!isBurning)
		{
			TileEntityBronzeFurnace tileEntityBronzeFurnace = (TileEntityBronzeFurnace)world.getTileEntity(x, y, z);
			
			if(tileEntityBronzeFurnace != null)
			{
				for(int i = 0; i < tileEntityBronzeFurnace.getSizeInventory(); ++i)
				{
					ItemStack itemstack = tileEntityBronzeFurnace.getStackInSlot(i);
					
					if(itemstack != null)
					{
						float f = this.random.nextFloat()*0.6F + 0.1F;
						float f1 = this.random.nextFloat()*0.6F + 0.1F;
						float f2 = this.random.nextFloat()*0.6F + 0.1F;
						
						while(itemstack.stackSize > 0)
						{
							int j = this.random.nextInt(21)+10;
							if(j > itemstack.stackSize)
							{
								j = itemstack.stackSize;
							}
							
							itemstack.stackSize -= j;
							EntityItem entItem = new EntityItem(world, (double)((float)x+f), 
									(double)((float)y+f1), (double)((float)z+f2), 
									new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							if(itemstack.hasTagCompound())
							{
								entItem.getEntityItem().setTagCompound(((NBTTagCompound)itemstack.getTagCompound().copy()));
							}
							
							float f3 = 0.025F;
							entItem.motionX = (double)((float)this.random.nextGaussian()*f3);
							entItem.motionY = (double)((float)this.random.nextGaussian()*f3 + 0.1F);
							entItem.motionZ = (double)((float)this.random.nextGaussian()*f3);
							
							world.spawnEntityInWorld(entItem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isBurning2)
        {
            int direction = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (direction == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityBronzeFurnace();
	}

}
