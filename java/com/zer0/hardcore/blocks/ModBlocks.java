package com.zer0.hardcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import com.zer0.hardcore.help.RegisterHelper;

public class ModBlocks {
	
	public static Block copperOre;
	public static Block tinOre;
	
	public static Block grindingMachine;
	public static Block grindingMachineActive;
	
	public static Block bronzeFurnace;
	public static Block bronzeFurnaceActive;
	
	public static void registerBlocks()
	{
		
	//BLOCK INITIALISATION
		copperOre = new BlockCopperOre();
		tinOre = new BlockTinOre();
		
		grindingMachine = new GrindingMachine(false).setBlockName("grindingMachine")
				.setCreativeTab(CreativeTabs.tabDecorations);
		grindingMachineActive = new GrindingMachine(true).setBlockName("grindingMachineActive");
		
		bronzeFurnace = new BronzeFurnace(false).setBlockName("bronzeFurnace")
				.setCreativeTab(CreativeTabs.tabDecorations);
		bronzeFurnaceActive = new BronzeFurnace(true).setBlockName("bronzeFurnaceActive");
				
	//REGISTER BLOCKS
		RegisterHelper.registerBlock(copperOre);
		RegisterHelper.registerBlock(tinOre);
		
		RegisterHelper.registerBlock(grindingMachine);
		RegisterHelper.registerBlock(grindingMachineActive);
		
		RegisterHelper.registerBlock(bronzeFurnace);
		RegisterHelper.registerBlock(bronzeFurnaceActive);
	}

}
