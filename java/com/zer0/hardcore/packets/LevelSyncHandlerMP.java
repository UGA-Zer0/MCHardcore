package com.zer0.hardcore.packets;

import com.zer0.hardcore.ClientProxy;
import com.zer0.hardcore.player.ExtendedPlayerProperties;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class LevelSyncHandlerMP implements IMessageHandler<LevelSyncMP, IMessage> {

	@Override
	public IMessage onMessage(LevelSyncMP message, MessageContext ctx) {
		ClientProxy.levelUpdate(message.level, message.entityId);
		
		return null;
	}

}