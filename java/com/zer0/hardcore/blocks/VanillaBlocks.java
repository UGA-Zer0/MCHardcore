package com.zer0.hardcore.blocks;

import net.minecraft.init.Blocks;

public class VanillaBlocks {
	
	public static void modifyBlocks()
	{
		
		//HARVEST LEVELS
		Blocks.iron_ore.setHarvestLevel("pickaxe", 3);
		Blocks.gold_ore.setHarvestLevel("pickaxe", 4);
		Blocks.diamond_ore.setHarvestLevel("pickaxe", 4);
		
		Blocks.iron_block.setHarvestLevel("pickaxe", 3);
		Blocks.gold_block.setHarvestLevel("pickaxe", 4);
		Blocks.diamond_block.setHarvestLevel("pickaxe", 4);
		
		Blocks.obsidian.setHarvestLevel("pickaxe", 6);
	}

}
