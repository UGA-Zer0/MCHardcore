package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolDiamondPickaxe extends ItemPickaxe {
	
	public ToolDiamondPickaxe(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("diamondPickaxe");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
