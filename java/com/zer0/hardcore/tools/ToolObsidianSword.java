package com.zer0.hardcore.tools;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;

import com.zer0.hardcore.help.Reference;

public class ToolObsidianSword extends ItemSword {
	
	public ToolObsidianSword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("obsidianSword");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
