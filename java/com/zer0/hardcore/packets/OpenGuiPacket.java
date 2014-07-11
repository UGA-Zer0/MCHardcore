package com.zer0.hardcore.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.zer0.hardcore.MCHardcore;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class OpenGuiPacket implements IMessage
{
	public int id;

	public OpenGuiPacket() {}

	public OpenGuiPacket(int id) {
		this.id = id;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(id);
	}	
}