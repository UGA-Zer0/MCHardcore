package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolCopperSword extends ItemSword {
	
	public ToolCopperSword(ToolMaterial material) {
		super(material);
		setUnlocalizedName("copperSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
