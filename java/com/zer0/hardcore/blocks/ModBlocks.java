package com.zer0.hardcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.zer0.hardcore.creative_tabs.MCHardcoreCreativeTabs;
import com.zer0.hardcore.help.RegisterHelper;

public class ModBlocks {
	
	public static Block copperOre;
	public static Block tinOre;
	
	public static Block grindingMachine;
	public static Block grindingMachineActive;
	
	public static Block bronzeGrindingMachine;
	public static Block bronzeGrindingMachineActive;
	
	public static Block bronzeFurnace;
	public static Block bronzeFurnaceActive;
	
	public static void registerBlocks()
	{
		
	//BLOCK INITIALISATION
		copperOre = new BlockCopperOre();
		tinOre = new BlockTinOre();
		
		grindingMachine = new GrindingMachine(false).setBlockName("grindingMachine")
				.setCreativeTab(MCHardcoreCreativeTabs.hcBlockTab);
		grindingMachineActive = new GrindingMachine(true).setBlockName("grindingMachineActive");
		
		bronzeGrindingMachine = new BronzeGrindingMachine(false).setBlockName("bronzeGrindingMachine")
				.setCreativeTab(MCHardcoreCreativeTabs.hcBlockTab);
		bronzeGrindingMachineActive = new BronzeGrindingMachine(true).setBlockName("bronzeGrindingMachingActive");
		
		bronzeFurnace = new BronzeFurnace(false).setBlockName("bronzeFurnace")
				.setCreativeTab(MCHardcoreCreativeTabs.hcBlockTab);
		bronzeFurnaceActive = new BronzeFurnace(true).setBlockName("bronzeFurnaceActive");
				
	//REGISTER BLOCKS
		RegisterHelper.registerBlock(copperOre);
		RegisterHelper.registerBlock(tinOre);
		
		RegisterHelper.registerBlock(grindingMachine);
		RegisterHelper.registerBlock(grindingMachineActive);
		
		RegisterHelper.registerBlock(bronzeGrindingMachine);
		RegisterHelper.registerBlock(bronzeGrindingMachineActive);
		
		RegisterHelper.registerBlock(bronzeFurnace);
		RegisterHelper.registerBlock(bronzeFurnaceActive);
	}

}
