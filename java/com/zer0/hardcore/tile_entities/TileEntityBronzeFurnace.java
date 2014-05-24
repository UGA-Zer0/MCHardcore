package com.zer0.hardcore.tile_entities;

import com.zer0.hardcore.blocks.BronzeFurnace;
import com.zer0.hardcore.blocks.GrindingMachine;
import com.zer0.hardcore.recipes.GrindingMachineRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBronzeFurnace extends TileEntity implements ISidedInventory {
	
	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBottom = new int[]{2,1};
	private static final int[] slotsSides = new int[]{1};
	
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	
	public int furnaceBurnTime;
	public int currentBurnTime;
	public int cookTime;
	
	private String furnaceName;
	
	@Override
	public int getSizeInventory() 
	{
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return this.furnaceItemStacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) 
	{
		if(this.furnaceItemStacks[var1] != null)
		{
			ItemStack itemstack;
			if(this.furnaceItemStacks[var1].stackSize <= var2)
			{
				itemstack = this.furnaceItemStacks[var1];
				this.furnaceItemStacks[var1] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.furnaceItemStacks[var1].splitStack(var2);
				if(this.furnaceItemStacks[var1].stackSize == 0)
				{
					this.furnaceItemStacks[var1] = null;
				}
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) 
	{
		if(this.furnaceItemStacks[slot] != null)
		{
			ItemStack itemstack = this.furnaceItemStacks[slot];
			this.furnaceItemStacks[slot] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) 
	{
		this.furnaceItemStacks[slot] = itemstack;
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() 
	{
		return this.hasCustomInventoryName() ? this.furnaceName : "Bronze Furnace";
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return this.furnaceName!= null && this.furnaceName.length() > 0;
	}
	
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < tagList.tagCount(); ++i)
		{
			NBTTagCompound tagComp1 = tagList.getCompoundTagAt(i);
			byte byte0 = tagComp1.getByte("Slot");
			
			if(byte0 >= 0 && byte0 < this.furnaceItemStacks.length)
			{
				this.furnaceItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagComp1);
			}
		}
		
		this.furnaceBurnTime = tagCompound.getShort("BurnTime");
		this.cookTime = tagCompound.getShort("CookTime");
		this.currentBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
		
		if(tagCompound.hasKey("CustomName", 8))
		{
			this.furnaceName = tagCompound.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound tagComp)
	{
		super.writeToNBT(tagComp);
		
		tagComp.setShort("BurnTime", (short)this.furnaceBurnTime);
		tagComp.setShort("CookTime", (short)this.cookTime);
		NBTTagList tagList = new NBTTagList();
		
		for(int i = 0; i < this.furnaceItemStacks.length; ++i)
		{
			if(this.furnaceItemStacks[i] != null)
			{
				NBTTagCompound tagComp1 = new NBTTagCompound();
				tagComp1.setByte("Slot", (byte)i);
				this.furnaceItemStacks[i].writeToNBT(tagComp1);
				tagList.appendTag(tagComp1);
			}
		}
		
		tagComp.setTag("Items", tagList);
		if(this.hasCustomInventoryName())
		{
			tagComp.setString("CustomName", this.furnaceName);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return this.cookTime * par1 / 150;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1)
	{
		if(this.currentBurnTime == 0)
		{
			this.currentBurnTime = 150;
		}
		return this.furnaceBurnTime * par1 / this.currentBurnTime;
	}
	
	public boolean isBurning()
	{
		return this.furnaceBurnTime > 0;
	}
	
	public void updateEntity()
	{
		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;
		
		if(this.furnaceBurnTime > 0)
		{
			--this.furnaceBurnTime;
		}
		
		if(!this.worldObj.isRemote)
		{
			if(this.furnaceBurnTime == 0 && this.canSmelt())
			{
				this.currentBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
				
				if(this.furnaceBurnTime > 0)
				{
					flag1 = true;
					if(this.furnaceItemStacks[1] != null)
					{
						--this.furnaceItemStacks[1].stackSize;
						
						if(this.furnaceItemStacks[1].stackSize == 0)
						{
							this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem
									(this.furnaceItemStacks[1]);
						}
					}
				}
			}
			
			if(this.isBurning() && this.canSmelt())
			{
				++this.cookTime;
				if(this.cookTime == 150)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
		}
		if(flag != this.furnaceBurnTime > 0)
		{
			flag1 = true;
			BronzeFurnace.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		if(flag1)
		{
			this.markDirty();
		}
	}
	
	private boolean canSmelt()
	{
		if(this.furnaceItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if(itemstack == null) return false;
			if(this.furnaceItemStacks[2] == null) return true;
			if(!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
			int result = furnaceItemStacks[2].stackSize+itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
		}
	}
	
	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if(this.furnaceItemStacks[2] == null)
			{
				this.furnaceItemStacks[2] = itemstack.copy();
			}
			else if(this.furnaceItemStacks[2].getItem() == itemstack.getItem())
			{
				this.furnaceItemStacks[2].stackSize += itemstack.stackSize;
			}
			--this.furnaceItemStacks[0].stackSize;
			if(this.furnaceItemStacks[0].stackSize == 0)
			{
				this.furnaceItemStacks[0] = null;
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack itemstack)
	{
		if(itemstack == null)
		{
			return 0;
		}
		else
		{
			Item item = itemstack.getItem();
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
			{
				Block block = Block.getBlockFromItem(item);
				if(block.getMaterial() == Material.wood) return 200; 
			}
			if(item == Items.coal) return 1600;
			if(item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 150;
			if(item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if(item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if(item == Items.stick) return 100;
            if(item == Items.coal) return 1600;
            if(item == Items.lava_bucket) return 20000;
            if(item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if(item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
		}
		
	}
	
	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemBurnTime(itemstack) > 0;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this
				? false
						:player.getDistanceSq
						((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D) <=64.0D;
	}

	@Override
	public void openInventory() 
	{
		
	}

	@Override
	public void closeInventory() 
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack itemstack) 
	{
		return var1 == 2 ? false : (var1 == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) 
	{
		return var1 == 0 ? slotsBottom : (var1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack itemstack, int var3) 
	{
		return this.isItemValidForSlot(var1, itemstack);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack itemstack, int var3) 
	{
		return var3 != 0 || var1 != 1 || itemstack.getItem() == Items.bucket;
	}
	
	public void furnaceName(String string)
	{
		this.furnaceName = string;
	}

}
