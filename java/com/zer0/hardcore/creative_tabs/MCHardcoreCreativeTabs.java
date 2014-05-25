package com.zer0.hardcore.creative_tabs;

import com.zer0.hardcore.blocks.ModBlocks;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.tools.ModTools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MCHardcoreCreativeTabs {
	
	   public static CreativeTabs hcToolTab = new CreativeTabs("hcToolTab") 
	   {
	      @Override
	      public Item getTabIconItem() 
	      {
	         return ModTools.obsidianAxe;
	      }
	   };
	   
	   public static CreativeTabs hcItemTab = new CreativeTabs("hcItemTab")
	   {
		   @Override
		   public Item getTabIconItem()
		   {
			   return ModItems.obsidianIngot;
		   }
	   };
	   
	   public static CreativeTabs hcCombatTab = new CreativeTabs("hcCombatTab")
	   {
		   @Override
		   public Item getTabIconItem()
		   {
			   return ModTools.obsidianSword;
		   }
	   };
	   
	   public static CreativeTabs hcBlockTab = new CreativeTabs("hcBlockTab")
	   {
		   public Item getTabIconItem()
		   {
			   return Item.getItemFromBlock(ModBlocks.copperOre);
		   }
	   };

}
