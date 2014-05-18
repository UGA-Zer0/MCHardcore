package com.zer0.hardcore.blocks;

import net.minecraft.block.Block;

import com.zer0.hardcore.help.RegisterHelper;

public class ModBlocks {
	
	public static Block copperOre;
	public static Block tinOre;
	
	public static void registerBlocks()
	{
		
	//BLOCK INITIALISATION
		copperOre = new BlockCopperOre();
		tinOre = new BlockTinOre();
				
	//REGISTER BLOCKS
		RegisterHelper.registerBlock(copperOre);
		RegisterHelper.registerBlock(tinOre);
	}

}
