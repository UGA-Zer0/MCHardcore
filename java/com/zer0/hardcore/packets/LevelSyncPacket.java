package com.zer0.hardcore.packets;

import io.netty.buffer.ByteBuf;

import com.zer0.hardcore.player.ExtendedPlayerProperties;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class LevelSyncPacket implements IMessage {
	
	public NBTTagCompound tagComp;
	public String name;
	
	public LevelSyncPacket() {}
	
	public LevelSyncPacket(EntityPlayer player)
	{
		tagComp = new NBTTagCompound();
		name = player.getCommandSenderName();
		ExtendedPlayerProperties.fetchProperties(player).saveNBTData(tagComp);
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		tagComp = ByteBufUtils.readTag(buf);
		name = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeTag(buf, tagComp);
		ByteBufUtils.writeUTF8String(buf, name);
	}
	
	

}
