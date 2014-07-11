package com.zer0.hardcore.packets;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class UpgradeStatPacket implements IMessage {
	
	public String stat;
	
	public UpgradeStatPacket() {}
	
	public UpgradeStatPacket(String stat)
	{
		this.stat = stat;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.stat = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.stat);
	}

}
