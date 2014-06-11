package com.zer0.hardcore.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.zer0.hardcore.MCHardcore;

public class OpenGuiPacket extends AbstractPacket
{
	private int id;

	public OpenGuiPacket() {}

	public OpenGuiPacket(int id) {
		this.id = id;
	}	

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(id);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		id = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		player.openGui(MCHardcore.modInstance, id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
}
}