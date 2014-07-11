package com.zer0.hardcore.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.packets.OpenGuiPacket;
import com.zer0.hardcore.packets.UpgradeStatPacket;
import com.zer0.hardcore.player.ExtendedPlayerProperties;

public class GuiSkills extends GuiScreen {
	
	public GuiSkills() {}
	
	public final int bgWidth = 176;
	public final int bgHeight = 166;
	
	public ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/skillsGui.png");
	
	@Override
	public void drawScreen(int i, int j, float f)
	{
		
		EntityPlayer player = this.mc.thePlayer;
		String username = player.getCommandSenderName();
		ExtendedPlayerProperties props = ExtendedPlayerProperties.fetchProperties(player);
		if(props == null)
		{
			return;
		}
		
		int level = props.getLevel();
		int nextLevel = level+1;
		
		int currentHealth = (int)player.getHealth(), maxHealth = (int)player.getMaxHealth();
		
		int skillpoints = props.getSkillpoints();
		
		if(skillpoints == 0)
		{
			initGui();
		}
		
		int k = (this.width - this.bgWidth) / 2;
		int l = (this.height - this.bgHeight) / 2;
		
		int str = props.getStat("str"), att = props.getStat("att"), def = props.getStat("def"), dex = props.getStat("dex");
		
		int totalLevelXp = props.calculateNewExpToLevel(props.getLevel());
		int currentXp = props.getCurrentXp();
		
		int xpRemaining = totalLevelXp-currentXp;
		
		int xpBarWidth = (int)(((float)currentXp/totalLevelXp)*165);
		
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(background);
		
		this.drawTexturedModalRect(k, l, 0, 0, this.bgWidth, this.bgHeight);
		this.drawTexturedModalRect(k+4, l+25, 0, 177, 167, 13);
		this.drawTexturedModalRect(k+5, l+26, 0, 166, xpBarWidth, 11);
		
		this.drawCenteredString(this.mc.fontRenderer, "\u00A77"+username, k+(this.bgWidth/2), l+5, 0xffffffff);
		this.drawCenteredString(this.mc.fontRenderer, "\u00A77Level\u00A7a "+level, k+(this.bgWidth/2), l+15, 0xffffffff);
		this.drawCenteredString(this.mc.fontRenderer, currentXp+"/"+totalLevelXp, k+(this.bgWidth/2), l+28, 0xffffffff);
		this.drawCenteredString(this.mc.fontRenderer, "\u00A77XP to level "+nextLevel+": \u00A76"+xpRemaining, k+(this.bgWidth/2), l+40, 0xffffffff);
		
		this.drawString(this.mc.fontRenderer, "Health: \u00A76"+currentHealth+"\u00A7f/\u00A76"+maxHealth, k+6, l+56, 0xffffffff);
		
		this.drawCenteredString(this.mc.fontRenderer, "\u00A77Skills", k+(this.bgWidth/2), l+75, 0xffffffff);
		this.drawString(this.mc.fontRenderer, "Skill points: \u00A76"+skillpoints, k+6, l+85, 0xffffffff);
		
		this.drawString(this.mc.fontRenderer, "\u00A7lATT \u00A76"+att, k+6, l+105, 0xffffffff);
		this.drawString(this.mc.fontRenderer, "\u00A7lSTR \u00A76"+str, k+6, l+145, 0xffffffff);
		this.drawString(this.mc.fontRenderer, "\u00A7lDEF \u00A76"+def, k+(this.bgWidth/2)+6, l+105, 0xffffffff);
		this.drawString(this.mc.fontRenderer, "\u00A7lDEX \u00A76"+dex, k+(this.bgWidth/2)+6, l+145, 0xffffffff);
		
		super.drawScreen(i, j, f);
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
	
	@Override
	public  void initGui()
	{
		EntityPlayer player = this.mc.thePlayer;
		String username = player.getCommandSenderName();
		ExtendedPlayerProperties props = ExtendedPlayerProperties.fetchProperties(player);
		if(props == null)
		{
			return;
		}
		
		int skillpoints = props.getSkillpoints();
		
		int k = (this.width - this.bgWidth) / 2;
		int l = (this.height - this.bgHeight) / 2;
		
		if(skillpoints > 0)
		{
			buttonList.add(new GuiButton(1, k+56, l+99, 20, 20, "+"));
			buttonList.add(new GuiButton(2, k+56, l+139, 20, 20, "+"));
			buttonList.add(new GuiButton(3, k+144, l+99, 20, 20, "+"));
			buttonList.add(new GuiButton(4, k+144, l+139, 20, 20, "+"));
		}
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			MCHardcore.network.sendToServer(new UpgradeStatPacket("att"));
		}
		else if(button.id == 2)
		{
			MCHardcore.network.sendToServer(new UpgradeStatPacket("str"));
		}
		else if(button.id == 3)
		{
			MCHardcore.network.sendToServer(new UpgradeStatPacket("def"));
		}
		else if(button.id == 4)
		{
			MCHardcore.network.sendToServer(new UpgradeStatPacket("dex"));
		}
		
	}

}
