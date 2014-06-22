package com.zer0.hardcore.gui;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.player.ExtendedPlayerProperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHealthBar extends Gui 
{
	private Minecraft mc;
	private static final ResourceLocation healthBarTexture = new ResourceLocation("mchardcore", "textures/gui/health_bar.png");
	private static final ResourceLocation hungerBarTexture = new ResourceLocation("mchardcore", "textures/gui/hunger_bar.png");
	private static final ResourceLocation armourBarTexture = new ResourceLocation("mchardcore", "textures/gui/armour_bar.png");
	private static final ResourceLocation airBarTexture = new ResourceLocation("mchardcore", "textures/gui/air_bar.png");
	
	public GuiHealthBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onRenderHealthBar(RenderGameOverlayEvent.Pre event)
	{
		if(event.type.equals(ElementType.HEALTH))
		{
			event.setCanceled(true);
			
			EntityPlayer player = this.mc.thePlayer;
			
			ExtendedPlayerProperties properties = ExtendedPlayerProperties.fetchProperties(player);
			
			if(properties == null)
			{
				return;
			}
			//SET BAR WIDTHS
			float health = player.getHealth();
			float maxHealth = player.getMaxHealth();
			int stamina = player.getFoodStats().getFoodLevel();
			int armour = player.getTotalArmorValue();
			
			int hungerBarWidth = (int)(((float)stamina/20)*79);
			
			int armourBarWidth = (int)(((float)armour/20)*79);
			
			int healthBarWidth = (int)(((float)health/maxHealth)*79);
			
			//SET SCREEN POSITION
			
			int xPos = event.resolution.getScaledWidth() / 2 - 91;
			int yPos = event.resolution.getScaledHeight() - 40;
			
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			
			//DRAW BARS
			
			this.mc.getTextureManager().bindTexture(healthBarTexture);
			
			this.drawTexturedModalRect(xPos, yPos, 0, 0, 81, 9);
			this.drawTexturedModalRect(xPos+1, yPos+1, 0, 9, healthBarWidth, 7);
			
			if(armour > 0)
			{
				this.mc.getTextureManager().bindTexture(armourBarTexture);
				
				this.drawTexturedModalRect(xPos, yPos-10, 0, 0, 81, 9);
				this.drawTexturedModalRect(xPos+1, yPos-9, 0, 9, armourBarWidth, 7);
			}
			
			Entity mount = player.ridingEntity;
			
			if(mount == null)
			{
				this.mc.getTextureManager().bindTexture(hungerBarTexture);
				
				this.drawTexturedModalRect(xPos+101, yPos, 0, 0, 81, 9);
				this.drawTexturedModalRect(xPos+102, yPos+1, 0, 9, hungerBarWidth, 7);
			}
			
			if(player.isInsideOfMaterial(Material.water))
			{
				int air = player.getAir();
				int airBarWidth = (int)Math.floor((((float)air/300)*79));
				
				this.mc.getTextureManager().bindTexture(airBarTexture);
				
				this.drawTexturedModalRect(xPos+101, yPos-10, 0, 0, 81, 9);
				this.drawTexturedModalRect(xPos+102, yPos-9, 0, 9, airBarWidth, 7);
			}
			
		}
		else
		{
			event.setCanceled(false);
		}
	}
}
