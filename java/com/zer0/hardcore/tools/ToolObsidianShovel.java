package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolObsidianShovel extends ItemSpade {
	
	public ToolObsidianShovel(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("obsidianShovel");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
