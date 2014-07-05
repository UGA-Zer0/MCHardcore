package com.zer0.hardcore.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import com.zer0.hardcore.player.ExtendedPlayerProperties;

public class SetLevelCommand extends CommandBase {

	@Override
	public String getCommandName() 
	{
		return "setlevel";
	}

	@Override
	public String getCommandUsage(ICommandSender cs) 
	{
		return "Sets a user's level";
	}

	@Override
	public void processCommand(ICommandSender cs, String[] args) 
	{
		if(cs instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)cs;
			String username = player.getCommandSenderName();
			ExtendedPlayerProperties props = ExtendedPlayerProperties.fetchProperties(player);
			if(props == null) { return; }
			if(args[0] == null)
			{
				player.addChatMessage(new ChatComponentText("Invalid value for LEVEL"));
			}
			
			boolean isInt = true;
			
			try 
			{
				int level = Integer.parseInt(args[0]);
				System.out.println("Setting user "+username+"'s level to "+level);
			}
			catch(NumberFormatException e)
			{
				isInt = false;
			}
			
			if(isInt)
			{
				props.setLevel(Integer.parseInt(args[0]));
				System.out.println("Level set");
			}
			else
			{
				player.addChatMessage(new ChatComponentText("Invalid value for LEVEL"));
			}
		}
	}

}
