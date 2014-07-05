package com.zer0.hardcore.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class LevelSyncMP implements IMessage {
	
	public int level, entityId;
	
	public LevelSyncMP() {}
	
	public LevelSyncMP(int level, int entityId)
	{
		this.level = level;
		this.entityId = entityId;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.level = buf.readInt();
		this.entityId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(level);
		buf.writeInt(entityId);
	}

}
