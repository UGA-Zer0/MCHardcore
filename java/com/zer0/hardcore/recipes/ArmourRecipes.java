package com.zer0.hardcore.recipes;

import net.minecraft.item.ItemStack;

import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ArmourRecipes {
	
	public static void initRecipes()
	{
		//OBSIDIAN
		GameRegistry.addRecipe(new ItemStack(ModArmour.obsidianHelm), new Object[]
				{
					"XXX",
					"X X",
					'X', ModItems.obsidianIngot
				});
		GameRegistry.addRecipe(new ItemStack(ModArmour.obsidianChestplate), new Object[]
				{
					"X X",
					"XXX",
					"XXX",
					'X', ModItems.obsidianIngot
				});
		GameRegistry.addRecipe(new ItemStack(ModArmour.obsidianLegs), new Object[]
				{
					"XXX",
					"X X",
					"X X",
					'X', ModItems.obsidianIngot
				});
		GameRegistry.addRecipe(new ItemStack(ModArmour.obsidianBoots), new Object[]
				{
					"X X",
					"X X",
					'X', ModItems.obsidianIngot
				});
	}

}
