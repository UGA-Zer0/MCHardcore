package com.zer0.hardcore.tools;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.zer0.hardcore.recipes.VanillaRecipes;


public class VanillaTools {
	
	public static void modifyTools()
	{
		VanillaRecipes.removeRecipe(new ItemStack(Items.iron_pickaxe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.iron_axe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.iron_hoe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.iron_shovel));
		VanillaRecipes.removeRecipe(new ItemStack(Items.iron_sword));
		
		VanillaRecipes.removeRecipe(new ItemStack(Items.diamond_pickaxe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.diamond_axe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.diamond_hoe));
		VanillaRecipes.removeRecipe(new ItemStack(Items.diamond_shovel));
		VanillaRecipes.removeRecipe(new ItemStack(Items.diamond_sword));
	}

}
