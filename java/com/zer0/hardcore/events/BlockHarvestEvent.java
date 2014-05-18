package com.zer0.hardcore.events;

import com.zer0.hardcore.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BlockHarvestEvent {
	
	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event)
	{
		if(event.block == Blocks.iron_ore)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(ModItems.ironNugget, 2));
		}
		else if(event.block == Blocks.gold_ore)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(Items.gold_nugget, 2));
		}
		else if(event.block == Blocks.diamond_ore)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(ModItems.diamondShard));
		}
		else if(event.block == Blocks.obsidian)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(ModItems.obsidianShard));
		}
	}

}
