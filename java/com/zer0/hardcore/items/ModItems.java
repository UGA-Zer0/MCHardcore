package com.zer0.hardcore.items;

import com.zer0.hardcore.help.RegisterHelper;

import net.minecraft.item.Item;

public class ModItems {
	
	//NUGGETS
		public static Item copperNugget;
		public static Item tinNugget;
		public static Item ironNugget;
		public static Item diamondShard;
		public static Item obsidianShard;
		
	//DUST
		public static Item bronzeDust;
		public static Item tinDust;
		public static Item copperDust;
		public static Item ironDust;
		public static Item goldDust;
		
	//UNREFINED
		public static Item bronzeUnref;
		public static Item copperUnref;
		public static Item ironUnref;
		public static Item goldUnref;
		public static Item diamondUnref;
		public static Item obsidianUnref;
		
	//INGOTS
		public static Item bronzeIngot;
		public static Item copperIngot;
		public static Item diamondIngot;
		public static Item obsidianIngot;
		
		public static void registerItems()
		{
		//ITEM INITIALISATION
			//NUGGETS
			copperNugget = new ItemCopperNugget();
			tinNugget = new ItemTinNugget();
			ironNugget = new ItemIronNugget();
			diamondShard = new ItemDiamondShard();
			obsidianShard = new ItemObsidianShard();
			
			//DUST
			bronzeDust = new ItemBronzeDust();
			tinDust = new ItemTinDust();
			copperDust = new ItemCopperDust();
			ironDust = new ItemIronDust();
			goldDust = new ItemGoldDust();
			
			//UNREFINED
			bronzeUnref = new ItemBronzeUnref();
			copperUnref = new ItemCopperUnref();
			ironUnref = new ItemIronUnref();
			goldUnref = new ItemGoldUnref();
			diamondUnref = new ItemDiamondUnref();
			obsidianUnref = new ItemObsidianUnref();
			
			//INGOTS
			bronzeIngot = new ItemBronzeIngot();
			copperIngot = new ItemCopperIngot();
			diamondIngot = new ItemDiamondIngot();
			obsidianIngot = new ItemObsidianIngot();
			
		//REGISTER ITEMS
			RegisterHelper.registerItem(copperNugget);
			RegisterHelper.registerItem(tinNugget);
			RegisterHelper.registerItem(ironNugget);
			RegisterHelper.registerItem(diamondShard);
			RegisterHelper.registerItem(obsidianShard);
			
			RegisterHelper.registerItem(bronzeDust);
			RegisterHelper.registerItem(tinDust);
			RegisterHelper.registerItem(copperDust);
			RegisterHelper.registerItem(ironDust);
			RegisterHelper.registerItem(goldDust);
			
			RegisterHelper.registerItem(bronzeUnref);
			RegisterHelper.registerItem(copperUnref);
			RegisterHelper.registerItem(ironUnref);
			RegisterHelper.registerItem(goldUnref);
			RegisterHelper.registerItem(diamondUnref);
			RegisterHelper.registerItem(obsidianUnref);
			
			RegisterHelper.registerItem(bronzeIngot);
			RegisterHelper.registerItem(copperIngot);
			RegisterHelper.registerItem(diamondIngot);
			RegisterHelper.registerItem(obsidianIngot);
		}

}
