package com.zer0.hardcore.items;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBronzeUnref extends Item {
	
	public ItemBronzeUnref()
	{
		super();
		setUnlocalizedName("bronzeUnref");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}
