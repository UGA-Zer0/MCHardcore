package com.zer0.hardcore.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.player.ExtendedPlayerProperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
		
		int xPos = 5;
		int yPos = 3;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(texLoc);
		this.drawTexturedModalRect(xPos, yPos+12, 0, 0, 51, 4);
		
		int totalLevelXp = properties.calculateNewExpToLevel(properties.getLevel());
		int currentXp = properties.getCurrentXp();
		
		int xpRemaining = totalLevelXp-currentXp;
		
		int xpBarWidth = (int)(((float)currentXp/totalLevelXp)*49);
		
		this.drawTexturedModalRect(xPos+1, yPos+13, 1, 4, xpBarWidth, 2);
		
		this.drawString(this.mc.fontRenderer, 
				"\u00A77Level: " + properties.getLevel() + " \u00A78(" + xpRemaining + " XP to level " + (properties.getLevel()+1) + ")",
				xPos, yPos, 0xffffffff);
	}
}
