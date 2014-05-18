package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolDiamondSword extends ItemSword {
	
	public ToolDiamondSword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("diamondSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
