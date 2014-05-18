package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ToolCopperAxe extends ItemAxe {
	
	public ToolCopperAxe(ToolMaterial material) {
		super(material);
		setUnlocalizedName("copperAxe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
