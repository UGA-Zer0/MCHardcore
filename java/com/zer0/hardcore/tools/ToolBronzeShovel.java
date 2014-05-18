package com.zer0.hardcore.tools;

import com.zer0.hardcore.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolBronzeShovel extends ItemSpade {
	
	public ToolBronzeShovel(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("bronzeShovel");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabTools);
	}

}
