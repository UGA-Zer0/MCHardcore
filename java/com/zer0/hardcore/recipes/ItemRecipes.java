package com.zer0.hardcore.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.zer0.hardcore.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRecipes {
	
	public static void initRecipes()
	{
		//COPPER
		GameRegistry.addRecipe(new ItemStack(ModItems.copperUnref), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', ModItems.copperDust
				});
		GameRegistry.addSmelting(new ItemStack(ModItems.copperUnref), new ItemStack(ModItems.copperIngot), 10);
		
		//BRONZE
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bronzeDust), new Object[]
				{
					ModItems.tinDust,
					ModItems.copperDust
				});
		GameRegistry.addRecipe(new ItemStack(ModItems.bronzeUnref), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', ModItems.bronzeDust
				});
		GameRegistry.addSmelting(new ItemStack(ModItems.bronzeUnref), new ItemStack(ModItems.bronzeIngot), 20);
		
		//IRON
		GameRegistry.addRecipe(new ItemStack(ModItems.ironUnref), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', ModItems.ironDust
				});
		GameRegistry.addSmelting(new ItemStack(ModItems.ironUnref), new ItemStack(Items.iron_ingot), 30);
		
		//DIAMOND
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondUnref), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', ModItems.diamondShard
				});
		GameRegistry.addSmelting(new ItemStack(ModItems.diamondUnref), new ItemStack(Items.diamond), 100);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.diamondIngot), new Object[]
				{
					Items.diamond, Items.diamond,
					Items.diamond, Items.diamond
				});
		
		//OBSIDIAN
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianUnref), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', ModItems.obsidianShard
				});
		GameRegistry.addSmelting(new ItemStack(ModItems.obsidianUnref), new ItemStack(ModItems.obsidianIngot), 500);
	}

}
