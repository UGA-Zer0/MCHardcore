package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolIronSword extends ItemSword {
	
	public ToolIronSword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("ironSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}