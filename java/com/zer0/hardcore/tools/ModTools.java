package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.RegisterHelper;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModTools {
	
	//TOOLS
		public static Item bronzePickaxe;
		public static Item bronzeAxe;
		public static Item bronzeHoe;
		public static Item bronzeShovel;
		public static Item bronzeSword;
		
		public static Item copperPickaxe;
		public static Item copperAxe;
		public static Item copperHoe;
		public static Item copperShovel;
		public static Item copperSword;
		
		public static Item obsidianPickaxe;
		public static Item obsidianAxe;
		public static Item obsidianHoe;
		public static Item obsidianShovel;
		public static Item obsidianSword;
		
		public static Item ironPickaxe;
		public static Item ironAxe;
		public static Item ironHoe;
		public static Item ironShovel;
		public static Item ironSword;
		
		public static Item diamondPickaxe;
		public static Item diamondAxe;
		public static Item diamondHoe;
		public static Item diamondShovel;
		public static Item diamondSword;
		
	//MATERIALS
		static ToolMaterial copperMaterial = EnumHelper.addToolMaterial("copperMaterial", 2, 150, 5.0F, 2.0F, 12);
		static ToolMaterial bronzeMaterial = EnumHelper.addToolMaterial("bronzeMaterial", 3, 170, 5.0F, 2.0F, 13);
		static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianMaterial", 7, 9999, 16.0F, 12.0F, 20);
		
		static ToolMaterial hardcoreIronMaterial = EnumHelper.addToolMaterial("hardcoreIronMaterial", 4, 250, 6.0F, 2.0F, 14);
		static ToolMaterial hardcoreDiamondMaterial = EnumHelper.addToolMaterial("hardcoreDiamondMaterial", 5, 1561, 8.0F, 3.0F, 10);
		
		public static void registerTools()
		{
			//TOOL INITIALISATION
			//BRONZE
			bronzePickaxe = new ToolBronzePickaxe(bronzeMaterial);
			bronzeAxe = new ToolBronzeAxe(bronzeMaterial);
			bronzeHoe = new ToolBronzeHoe(bronzeMaterial);
			bronzeShovel = new ToolBronzeShovel(bronzeMaterial);
			bronzeSword = new ToolBronzeSword(bronzeMaterial);
			RegisterHelper.registerItem(bronzePickaxe);
			RegisterHelper.registerItem(bronzeAxe);
			RegisterHelper.registerItem(bronzeHoe);
			RegisterHelper.registerItem(bronzeShovel);
			RegisterHelper.registerItem(bronzeSword);
			
			//COPPER
			copperPickaxe = new ToolCopperPickaxe(copperMaterial);
			copperAxe = new ToolCopperAxe(copperMaterial);
			copperHoe = new ToolCopperHoe(copperMaterial);
			copperShovel = new ToolCopperShovel(copperMaterial);
			copperSword = new ToolCopperSword(copperMaterial);
			RegisterHelper.registerItem(copperPickaxe);
			RegisterHelper.registerItem(copperAxe);
			RegisterHelper.registerItem(copperHoe);
			RegisterHelper.registerItem(copperShovel);
			RegisterHelper.registerItem(copperSword);
			
			//IRON
			ironPickaxe = new ToolIronPickaxe(hardcoreIronMaterial);
			ironAxe = new ToolIronAxe(hardcoreIronMaterial);
			ironHoe = new ToolIronHoe(hardcoreIronMaterial);
			ironShovel = new ToolIronShovel(hardcoreIronMaterial);
			ironSword = new ToolIronSword(hardcoreIronMaterial);
			RegisterHelper.registerItem(ironPickaxe);
			RegisterHelper.registerItem(ironAxe);
			RegisterHelper.registerItem(ironHoe);
			RegisterHelper.registerItem(ironShovel);
			RegisterHelper.registerItem(ironSword);
			
			//DIAMOND
			diamondPickaxe = new ToolDiamondPickaxe(hardcoreDiamondMaterial);
			diamondAxe = new ToolDiamondAxe(hardcoreDiamondMaterial);
			diamondHoe = new ToolDiamondHoe(hardcoreDiamondMaterial);
			diamondShovel = new ToolDiamondShovel(hardcoreDiamondMaterial);
			diamondSword = new ToolDiamondSword(hardcoreDiamondMaterial);
			RegisterHelper.registerItem(diamondPickaxe);
			RegisterHelper.registerItem(diamondAxe);
			RegisterHelper.registerItem(diamondHoe);
			RegisterHelper.registerItem(diamondShovel);
			RegisterHelper.registerItem(diamondSword);
			
			//OBSIDIAN
			obsidianPickaxe = new ToolObsidianPickaxe(obsidianMaterial);
			obsidianAxe = new ToolObsidianAxe(obsidianMaterial);
			obsidianHoe = new ToolObsidianHoe(obsidianMaterial);
			obsidianShovel = new ToolObsidianShovel(obsidianMaterial);
			obsidianSword = new ToolObsidianSword(obsidianMaterial);
			RegisterHelper.registerItem(obsidianPickaxe);
			RegisterHelper.registerItem(obsidianAxe);
			RegisterHelper.registerItem(obsidianHoe);
			RegisterHelper.registerItem(obsidianShovel);
			RegisterHelper.registerItem(obsidianSword);
		}

}
