package com.zer0.hardcore.rendering;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.entities.VillagerSoldier;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.models.VillagerSoldierModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class VillagerSoldierRenderer extends RenderLiving {
	
	private VillagerSoldierModel model;
	private static final ResourceLocation texLoc = new ResourceLocation(Reference.MODID + ":" + "textures/models/villagerSoldier.png");
	
	public VillagerSoldierRenderer()
	{
		super(new VillagerSoldierModel(), 0.5F);
		this.model = (VillagerSoldierModel)super.mainModel;
		this.setRenderPassModel(this.model);
	}
	
	public void doRender(VillagerSoldier entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender((EntityLiving)entity, par2, par4, par6, par8, par9);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texLoc;
	}
	
	protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        super.renderEquippedItems(par1EntityLiving, par2);
        ItemStack itemstack = par1EntityLiving.getHeldItem();
        Item item;
        float f1;

        if (itemstack != null && itemstack.getItem() != null)
        {
            item = itemstack.getItem();
            GL11.glPushMatrix();

            if (this.mainModel.isChild)
            {
                f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f1, f1, f1);
            }

            this.model.rightarm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())))
            {
                f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f1 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f1, -f1, f1);
            }
            else if (item == Items.bow)
            {
                f1 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (item.isFull3D())
            {
                f1 = 0.625F;

                if (item.shouldRotateAroundWhenRendering())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f1 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            float f2;
            float f3;
            int i;

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                for (i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i)
                {
                    int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
                    f2 = (float)(j >> 16 & 255) / 255.0F;
                    f3 = (float)(j >> 8 & 255) / 255.0F;
                    float f4 = (float)(j & 255) / 255.0F;
                    GL11.glColor4f(f2, f3, f4, 1.0F);
                    this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, i);
                }
            }
            else
            {
                i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
                float f5 = (float)(i >> 16 & 255) / 255.0F;
                f2 = (float)(i >> 8 & 255) / 255.0F;
                f3 = (float)(i & 255) / 255.0F;
                GL11.glColor4f(f5, f2, f3, 1.0F);
                this.renderManager.itemRenderer.renderItem(par1EntityLiving, itemstack, 0);
            }

            GL11.glPopMatrix();
        }
    }
	
	protected void func_82422_c()
    {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderEquippedItems((VillagerSoldier)par1EntityLivingBase, par2);
    }

}
