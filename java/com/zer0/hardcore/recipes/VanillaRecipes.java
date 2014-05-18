package com.zer0.hardcore.recipes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class VanillaRecipes {
	
	public static void removeRecipe(ItemStack resultItem)
	{
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		
		for (int scan = 0; scan < recipes.size(); scan++)
		{
			IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			recipeResult = tmpRecipe.getRecipeOutput();
			if (recipeResult != null)
			{
				if(recipeResult.getItem() == resultItem.getItem() && recipeResult.getItemDamage() == resultItem.getItemDamage())
				{
					System.out.println("Removed vanilla recipe: " + recipes.get(scan) + " -> " + recipeResult);
					recipes.remove(scan);
					scan--;
				}
			}
		}
	}

}
