package com.zer0.hardcore.packets;

import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class LevelSyncHandler implements IMessageHandler<LevelSyncPacket, IMessage> 
{
	
	@Override
	public IMessage onMessage(LevelSyncPacket message, MessageContext ctx) 
	{
		NBTTagCompound data = message.tagComp;
		System.out.println(message.name + " reached level " + data.getInteger("CurrentLevel"));
		return null;
	}

}
