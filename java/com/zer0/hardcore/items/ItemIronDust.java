package com.zer0.hardcore.items;

import net.minecraft.item.Item;

import com.zer0.hardcore.creative_tabs.MCHardcoreCreativeTabs;
import com.zer0.hardcore.help.Reference;

public class ItemIronDust extends Item {
	
	public ItemIronDust()
	{
		super();
		setUnlocalizedName("ironDust");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(MCHardcoreCreativeTabs.hcItemTab);
	}

}
