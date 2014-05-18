package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolBronzeSword extends ItemSword {
	
	public ToolBronzeSword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("bronzeSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
