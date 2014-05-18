package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolIronHoe extends ItemHoe {
	
	public ToolIronHoe(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("ironHoe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}