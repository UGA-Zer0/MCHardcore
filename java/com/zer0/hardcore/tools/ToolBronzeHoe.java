package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;


public class ToolBronzeHoe extends ItemHoe {
	
	public ToolBronzeHoe(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("bronzeHoe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
