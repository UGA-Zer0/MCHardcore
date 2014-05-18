package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolDiamondHoe extends ItemHoe {
	
	public ToolDiamondHoe(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("diamondHoe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
