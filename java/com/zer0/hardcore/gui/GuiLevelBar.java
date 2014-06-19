package com.zer0.hardcore.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.player.ExtendedPlayerProperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiLevelBar extends Gui 
{
	private Minecraft mc;
	private static final ResourceLocation texLoc = new ResourceLocation("mchardcore", "textures/gui/exp_bar.png");
	
	public GuiLevelBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onRenderExpBar(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		
		ExtendedPlayerProperties properties = ExtendedPlayerProperties.fetchProperties(this.mc.thePlayer);
		
		if(properties == null)
		{
			return;
		}
		
		int xPos = 4;
		int yPos = 3;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(texLoc);
		this.drawTexturedModalRect(1, 1, 0, 0, 74, 37);
		
		this.drawTexturedModalRect(xPos, yPos+25, 74, 0, 68, 4);
		
		int totalLevelXp = properties.calculateNewExpToLevel(properties.getLevel());
		int currentXp = properties.getCurrentXp();
		
		int xpRemaining = totalLevelXp-currentXp;
		
		int xpBarWidth = (int)(((float)currentXp/totalLevelXp)*66);
		
		this.drawTexturedModalRect(xPos+1, yPos+26, 74, 4, xpBarWidth, 2);
		
		this.drawCenteredString(this.mc.fontRenderer, "\u00A7fLevel:", 38, 6, 0xffffffff);
		this.drawCenteredString(this.mc.fontRenderer, "\u00A7a" + properties.getLevel(), 38, 16, 0xffffffff);
	}
}
