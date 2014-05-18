package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolObsidianSword extends ItemSword {
	
	public ToolObsidianSword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("obsidianSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
