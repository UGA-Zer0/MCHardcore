package com.zer0.hardcore.events;

import com.zer0.hardcore.blocks.VanillaBlocks;
import com.zer0.hardcore.tools.VanillaTools;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EntityUpdateEvent {
	
	@SubscribeEvent
	public void EntityUpdate(PlayerEvent.PlayerLoggedInEvent event)
	{
		VanillaBlocks.modifyBlocks();
		VanillaTools.modifyTools();
	}

}
