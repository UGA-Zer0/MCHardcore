package com.zer0.hardcore.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.zer0.hardcore.items.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrindingMachineRecipes {
	
	private static final GrindingMachineRecipes SMELTING_BASE = new GrindingMachineRecipes();
	
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	
	public static GrindingMachineRecipes smelting()
	{
		return SMELTING_BASE;
	}
	
	private GrindingMachineRecipes()
	{
		this.addRecipe(ModItems.copperNugget, new ItemStack(ModItems.copperDust), 0.8F);
		this.addRecipe(ModItems.tinNugget, new ItemStack(ModItems.tinDust), 0.8F);
		this.addRecipe(ModItems.ironNugget, new ItemStack(ModItems.ironDust), 0.8F);
		//this.addRecipe(Items.gold_nugget, new ItemStack(ModItems.goldDust), 0.8F); <--TO BE ADDED - NEED TO FIGURE OUT HOW GOLD WILL BE IMPLEMENTED
	}
	
	public ItemStack getSmeltingResult(ItemStack itemstack)
	{
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;
		do
		{
			if(!iterator.hasNext())
			{
				return null;
			}
			entry = (Entry) iterator.next();
		}
		while(!canBeSmelted(itemstack, (ItemStack)entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeSmelted(ItemStack itemstack, ItemStack key) 
	{
		return key.getItem() == itemstack.getItem() && (key.getItemDamage() == 32767 || key.getItemDamage() == itemstack.getItemDamage());
	}
	
	public void addRecipe(Item item, ItemStack itemstack, float experience)
	{
		this.addLists(item, itemstack, experience);
	}

	public void addLists(Item item, ItemStack itemstack, float experience)
	{
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}

	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience)
	{
		this.smeltingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack2, Float.valueOf(experience));
	}
	
	public float giveExperience(ItemStack itemstack)
	{
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do
		{
			if(!iterator.hasNext())
			{
				return 0.0f;
			}

			entry = (Entry) iterator.next();
		}
		while(!this.canBeSmelted(itemstack, (ItemStack) entry.getKey()));

		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1)
		{
				return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}

}
