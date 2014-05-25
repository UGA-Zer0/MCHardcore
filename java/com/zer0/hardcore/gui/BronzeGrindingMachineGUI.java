package com.zer0.hardcore.gui;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.inventory.ContainerBronzeGM;
import com.zer0.hardcore.tile_entities.TileEntityBronzeGM;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class BronzeGrindingMachineGUI extends GuiContainer {
	
	private static final ResourceLocation GMGuiTexture = new ResourceLocation(Reference.MODID + ":textures/gui/container/grindingMachineGUI.png");
	private TileEntityBronzeGM tileBGM;

	public BronzeGrindingMachineGUI(InventoryPlayer invPlayer, TileEntityBronzeGM tile) {
		super(new ContainerBronzeGM(invPlayer, tile));
		this.tileBGM = tile;
	}
	
	protected void drawGuiContainerForegroundLayer(int var1, int var2)
	{
		String string = this.tileBGM.hasCustomInventoryName() ? this.tileBGM.getInventoryName()
				:I18n.format(this.tileBGM.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(string, (this.xSize - 48) - 
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
		
		if(this.tileBGM.isBurning())
		{
			i1 = this.tileBGM.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k+56, l+36+12-i1, 176, 12-i1, 14, i1+2);
		}
		
		i1 = this.tileBGM.getCookProgressScaled(24);
		this.drawTexturedModalRect(k+79, l+34, 176, 14, i1+1, 16);
	}

}
