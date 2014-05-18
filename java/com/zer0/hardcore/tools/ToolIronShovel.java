package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolIronShovel extends ItemSpade {
	
	public ToolIronShovel(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("ironShovel");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}