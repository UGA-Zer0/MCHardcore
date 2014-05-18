package com.zer0.hardcore.recipes;

import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.tools.ModTools;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;


import cpw.mods.fml.common.registry.GameRegistry;

public class ToolRecipes {
	
	public static void initRecipes()
	{
		
		//PICKAXES
		GameRegistry.addRecipe(new ItemStack(ModTools.bronzePickaxe), new Object[]
				{
					"XXX",
					" Y ",
					" Y ",
					'X', ModItems.bronzeIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.copperPickaxe), new Object[]
				{
					"XXX",
					" Y ",
					" Y ",
					'X', ModItems.copperIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.ironPickaxe), new Object[]
				{
					"XXX",
					" Y ",
					" Y ",
					'X', Items.iron_ingot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamondPickaxe), new Object[]
				{
					"XXX",
					" Y ",
					" Y ",
					'X', ModItems.diamondIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.obsidianPickaxe), new Object[]
				{
					"XXX",
					" Y ",
					" Y ",
					'X', ModItems.obsidianIngot,
					'Y', Items.stick
				});
		
		
		
		//AXES
		GameRegistry.addRecipe(new ItemStack(ModTools.bronzeAxe), new Object[]
				{
					"XX",
					"XY",
					" Y",
					'X', ModItems.bronzeIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.copperAxe), new Object[]
				{
					"XX",
					"XY",
					" Y",
					'X', ModItems.copperIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.ironAxe), new Object[]
				{
					"XX",
					"XY",
					" Y",
					'X', Items.iron_ingot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamondAxe), new Object[]
				{
					"XX",
					"XY",
					" Y",
					'X', ModItems.diamondIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.obsidianAxe), new Object[]
				{
					"XX",
					"XY",
					" Y",
					'X', ModItems.obsidianIngot,
					'Y', Items.stick
				});
		
		
		
		//HOES
		GameRegistry.addRecipe(new ItemStack(ModTools.bronzeHoe), new Object[]
				{
					"XX",
					" Y",
					" Y",
					'X', ModItems.bronzeIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.copperHoe), new Object[]
				{
					"XX",
					" Y",
					" Y",
					'X', ModItems.copperIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.ironHoe), new Object[]
				{
					"XX",
					" Y",
					" Y",
					'X', Items.iron_ingot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamondHoe), new Object[]
				{
					"XX",
					" Y",
					" Y",
					'X', ModItems.diamondIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.obsidianHoe), new Object[]
				{
					"XX",
					" Y",
					" Y",
					'X', ModItems.obsidianIngot,
					'Y', Items.stick
				});
		
		
		
		//SHOVELS
		GameRegistry.addRecipe(new ItemStack(ModTools.bronzeShovel), new Object[]
				{
					"X",
					"Y",
					"Y",
					'X', ModItems.bronzeIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.copperShovel), new Object[]
				{
					"X",
					"Y",
					"Y",
					'X', ModItems.copperIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.ironShovel), new Object[]
				{
					"X",
					"Y",
					"Y",
					'X', Items.iron_ingot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamondShovel), new Object[]
				{
					"X",
					"Y",
					"Y",
					'X', ModItems.diamondIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.obsidianShovel), new Object[]
				{
					"X",
					"Y",
					"Y",
					'X', ModItems.obsidianIngot,
					'Y', Items.stick
				});
		
		
		
		//SWORDS
		GameRegistry.addRecipe(new ItemStack(ModTools.bronzeSword), new Object[]
				{
					"X",
					"X",
					"Y",
					'X', ModItems.bronzeIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.copperSword), new Object[]
				{
					"X",
					"X",
					"Y",
					'X', ModItems.copperIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.ironSword), new Object[]
				{
					"X",
					"X",
					"Y",
					'X', Items.iron_ingot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamondSword), new Object[]
				{
					"X",
					"X",
					"Y",
					'X', ModItems.diamondIngot,
					'Y', Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(ModTools.obsidianSword), new Object[]
				{
					"X",
					"X",
					"Y",
					'X', ModItems.obsidianIngot,
					'Y', Items.stick
				});
	}

}
