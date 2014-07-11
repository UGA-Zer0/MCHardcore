package com.zer0.hardcore.packets;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.player.ExtendedPlayerProperties;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class UpgradeStatPacketHandler implements IMessageHandler<UpgradeStatPacket, IMessage> {

	@Override
	public IMessage onMessage(UpgradeStatPacket message, MessageContext ctx) {
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ExtendedPlayerProperties stats = ExtendedPlayerProperties.fetchProperties(player);
		stats.upgradeSkill(message.stat);
		
		return null;
	}

}
