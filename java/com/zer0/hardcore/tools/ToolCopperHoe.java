package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolCopperHoe extends ItemHoe {
	
	public ToolCopperHoe(ToolMaterial material) {
		super(material);
		setUnlocalizedName("copperHoe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
