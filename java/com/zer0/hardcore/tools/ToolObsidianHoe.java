package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolObsidianHoe extends ItemHoe {
	
	public ToolObsidianHoe(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("obsidianHoe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
