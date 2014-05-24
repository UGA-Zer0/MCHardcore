package com.zer0.hardcore.armour;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.help.RegisterHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmour {

//ITEMS
	//COPPER
	public static Item copperHelm;
	public static Item copperChestplate;
	public static Item copperLegs;
	public static Item copperBoots;
	//BRONZE
	public static Item bronzeHelm;
	public static Item bronzeChestplate;
	public static Item bronzeLegs;
	public static Item bronzeBoots;
	//OBSIDIAN
	public static Item obsidianHelm;
	public static Item obsidianChestplate;
	public static Item obsidianLegs;
	public static Item obsidianBoots;
	
//MATERIALS
	//COPPER
	public static ArmorMaterial copperArmourMaterial = EnumHelper.addArmorMaterial
			("copperArmour", 11, new int[]{2, 4, 3, 1}, 16);
	//BRONZE
	public static ArmorMaterial bronzeArmourMaterial = EnumHelper.addArmorMaterial
			("bronzeArmour", 13, new int[]{2, 5, 4, 2}, 18);
	//OBSIDIAN
	public static ArmorMaterial obsidianArmourMaterial = EnumHelper.addArmorMaterial
			("obsidianArmour", 9999, new int[]{3, 8, 6, 3}, 70);
	
	public static void registerArmour()
	{
		//COPPER
		copperHelm = new CopperArmour(copperArmourMaterial, MCHardcore.proxy.addArmour("copperArmour"), 0)
		.setUnlocalizedName("copperHelm").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":copperHelm");
	
		copperChestplate = new CopperArmour(copperArmourMaterial, MCHardcore.proxy.addArmour("copperArmour"), 1)
		.setUnlocalizedName("copperChestplate").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":copperChestplate");
	
		copperLegs = new CopperArmour(copperArmourMaterial, MCHardcore.proxy.addArmour("copperArmour"), 2)
		.setUnlocalizedName("copperLegs").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":copperLegs");
	
		copperBoots = new CopperArmour(copperArmourMaterial, MCHardcore.proxy.addArmour("copperArmour"), 3)
		.setUnlocalizedName("copperBoots").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":copperBoots");
	
		GameRegistry.registerItem(copperHelm, copperHelm.getUnlocalizedName());
		GameRegistry.registerItem(copperChestplate, copperChestplate.getUnlocalizedName());
		GameRegistry.registerItem(copperLegs, copperLegs.getUnlocalizedName());
		GameRegistry.registerItem(copperBoots, copperBoots.getUnlocalizedName());
		
		//BRONZE
		bronzeHelm = new BronzeArmour(bronzeArmourMaterial, MCHardcore.proxy.addArmour("bronzeArmour"), 0)
		.setUnlocalizedName("bronzeHelm").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":bronzeHelm");
	
		bronzeChestplate = new BronzeArmour(bronzeArmourMaterial, MCHardcore.proxy.addArmour("bronzeArmour"), 1)
		.setUnlocalizedName("bronzeChestplate").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":bronzeChestplate");
	
		bronzeLegs = new BronzeArmour(bronzeArmourMaterial, MCHardcore.proxy.addArmour("bronzeArmour"), 2)
		.setUnlocalizedName("bronzeLegs").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":bronzeLegs");
	
		bronzeBoots = new BronzeArmour(bronzeArmourMaterial, MCHardcore.proxy.addArmour("bronzeArmour"), 3)
		.setUnlocalizedName("bronzeBoots").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":bronzeBoots");
	
		GameRegistry.registerItem(bronzeHelm, bronzeHelm.getUnlocalizedName());
		GameRegistry.registerItem(bronzeChestplate, bronzeChestplate.getUnlocalizedName());
		GameRegistry.registerItem(bronzeLegs, bronzeLegs.getUnlocalizedName());
		GameRegistry.registerItem(bronzeBoots, bronzeBoots.getUnlocalizedName());
		
		//OBSIDIAN
		obsidianHelm = new ObsidianArmour(obsidianArmourMaterial, MCHardcore.proxy.addArmour("obsidianArmour"), 0)
			.setUnlocalizedName("obsidianHelm").setCreativeTab(CreativeTabs.tabCombat)
			.setTextureName(Reference.MODID + ":obsidianHelm");
		
		obsidianChestplate = new ObsidianArmour(obsidianArmourMaterial, MCHardcore.proxy.addArmour("obsidianArmour"), 1)
			.setUnlocalizedName("obsidianChestplate").setCreativeTab(CreativeTabs.tabCombat)
			.setTextureName(Reference.MODID + ":obsidianChestplate");
		
		obsidianLegs = new ObsidianArmour(obsidianArmourMaterial, MCHardcore.proxy.addArmour("obsidianArmour"), 2)
			.setUnlocalizedName("obsidianLegs").setCreativeTab(CreativeTabs.tabCombat)
			.setTextureName(Reference.MODID + ":obsidianLegs");
		
		obsidianBoots = new ObsidianArmour(obsidianArmourMaterial, MCHardcore.proxy.addArmour("obsidianArmour"), 3)
			.setUnlocalizedName("obsidianBoots").setCreativeTab(CreativeTabs.tabCombat)
			.setTextureName(Reference.MODID + ":obsidianBoots");
		
		GameRegistry.registerItem(obsidianHelm, obsidianHelm.getUnlocalizedName());
		GameRegistry.registerItem(obsidianChestplate, obsidianChestplate.getUnlocalizedName());
		GameRegistry.registerItem(obsidianLegs, obsidianLegs.getUnlocalizedName());
		GameRegistry.registerItem(obsidianBoots, obsidianBoots.getUnlocalizedName());
		
	}

}
