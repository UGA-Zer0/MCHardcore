package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolCopperPickaxe extends ItemPickaxe {
	
	public ToolCopperPickaxe(ToolMaterial material) {
		super(material);
		setUnlocalizedName("copperPickaxe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
