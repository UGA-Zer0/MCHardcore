package com.zer0.hardcore.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.inventory.ContainerBronzeFurnace;
import com.zer0.hardcore.tile_entities.TileEntityBronzeFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BronzeFurnaceGUI extends GuiContainer {
	
	private static final ResourceLocation GMGuiTexture = new ResourceLocation(Reference.MODID + ":textures/gui/container/bronzeFurnaceGUI.png");
	private TileEntityBronzeFurnace tileBF;

	public BronzeFurnaceGUI(InventoryPlayer invPlayer, TileEntityBronzeFurnace tile) {
		super(new ContainerBronzeFurnace(invPlayer, tile));
		this.tileBF = tile;
	}
	
	protected void drawGuiContainerForegroundLayer(int var1, int var2)
	{
		String string = this.tileBF.hasCustomInventoryName() ? this.tileBF.getInventoryName()
				:I18n.format(this.tileBF.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(string, this.xSize/2 - 
				this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GMGuiTexture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if(this.tileBF.isBurning())
		{
			i1 = this.tileBF.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k+56, l+36+12-i1, 176, 12-i1, 14, i1+2);
		}
		
		i1 = this.tileBF.getCookProgressScaled(24);
		this.drawTexturedModalRect(k+79, l+34, 176, 14, i1+1, 16);
	}


}
