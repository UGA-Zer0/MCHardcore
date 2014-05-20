package com.zer0.hardcore.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.zer0.hardcore.blocks.ModBlocks;
import com.zer0.hardcore.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRecipes {
	
	public static void initRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ModBlocks.grindingMachine), new Object[]
				{
					"XXX",
					"XYX",
					"XXX",
					'X', Items.brick,
					'Y', Items.flint
				});
	}

}
