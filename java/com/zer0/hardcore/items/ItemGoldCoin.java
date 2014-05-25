package com.zer0.hardcore.items;

import com.zer0.hardcore.creative_tabs.MCHardcoreCreativeTabs;
import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGoldCoin extends Item {
	
	public ItemGoldCoin()
	{
		super();
		setUnlocalizedName("goldCoin");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(MCHardcoreCreativeTabs.hcItemTab);
	}

}
