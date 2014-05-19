package com.zer0.hardcore.armour;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.help.RegisterHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModArmour {

//ITEMS
	//THIEF ARMOUR
	/*public static Item thiefHelm;
	public static Item thiefChest;
	public static Item thiefLegs;
	public static Item thiefBoots;*/
	
	//OBSIDIAN
	public static Item obsidianHelm;
	public static Item obsidianChestplate;
	public static Item obsidianLegs;
	public static Item obsidianBoots;
	
//MATERIALS
	//OBSIDIAN
	public static ArmorMaterial obsidianArmourMaterial = EnumHelper.addArmorMaterial
			("obsidianArmour", 9999, new int[]{3, 8, 6, 3}, 70);
	
	public static void registerArmour()
	{
		//THIEF ARMOUR
		/*thiefHelm = new ThiefArmour(ArmorMaterial.CLOTH, MCHardcore.proxy.addArmour("thiefHelm"), 0)
			.setUnlocalizedName("thiefHelm").setCreativeTab(CreativeTabs.tabCombat)
			.setTextureName(Reference.MODID + ":thiefHelm");
		
		thiefChest = new ThiefArmour(ArmorMaterial.CLOTH, MCHardcore.proxy.addArmour("thiefChest"), 1)
		.setUnlocalizedName("thiefChest").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":thiefChest");
		
		thiefLegs = new ThiefArmour(ArmorMaterial.CLOTH, MCHardcore.proxy.addArmour("thiefLegs"), 2)
		.setUnlocalizedName("thiefLegs").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":thiefLegs");
		
		thiefBoots = new ThiefArmour(ArmorMaterial.CLOTH, MCHardcore.proxy.addArmour("thiefBoots"), 3)
		.setUnlocalizedName("thiefBoots").setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(Reference.MODID + ":thiefBoots");
		
		RegisterHelper.registerItem(thiefHelm);
		RegisterHelper.registerItem(thiefChest);
		RegisterHelper.registerItem(thiefLegs);
		RegisterHelper.registerItem(thiefBoots);
		*/
		
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
