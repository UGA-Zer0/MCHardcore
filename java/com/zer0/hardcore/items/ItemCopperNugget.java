package com.zer0.hardcore.items;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperNugget extends Item {
	
	public ItemCopperNugget()
	{
		super();
		setUnlocalizedName("copperNugget");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}
