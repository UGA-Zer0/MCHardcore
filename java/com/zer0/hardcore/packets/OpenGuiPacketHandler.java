package com.zer0.hardcore.packets;

import com.zer0.hardcore.MCHardcore;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class OpenGuiPacketHandler implements IMessageHandler<OpenGuiPacket, IMessage> {

	@Override
	public IMessage onMessage(OpenGuiPacket message, MessageContext ctx) {
		Minecraft minecraft = Minecraft.getMinecraft();
		EntityPlayer player = minecraft.thePlayer;
		
		player.openGui(MCHardcore.modInstance, message.id, player.worldObj, (int) player.posX, (int)player.posY, (int)player.posZ);
		return null;
	}

}
