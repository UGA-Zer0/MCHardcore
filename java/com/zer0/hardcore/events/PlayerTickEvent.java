package com.zer0.hardcore.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.zer0.hardcore.tools.ModTools;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class PlayerTickEvent {
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		
		ItemStack itemstack = player.getCurrentEquippedItem();
		if(itemstack != null && itemstack.getItem() == ModTools.obsidianSword)
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 1));
		}
	}

}
