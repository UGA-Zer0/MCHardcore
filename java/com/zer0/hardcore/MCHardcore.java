package com.zer0.hardcore;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.reflect.Reflection;
import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.blocks.ModBlocks;
import com.zer0.hardcore.blocks.VanillaBlocks;
import com.zer0.hardcore.entities.ObsidianKnight;
import com.zer0.hardcore.entities.SpawnHandler;
import com.zer0.hardcore.events.BlockHarvestEvent;
import com.zer0.hardcore.events.PlayerTickEvent;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.help.RegisterHelper;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.recipes.ArmourRecipes;
import com.zer0.hardcore.recipes.BlockRecipes;
import com.zer0.hardcore.recipes.ItemRecipes;
import com.zer0.hardcore.recipes.ToolRecipes;
import com.zer0.hardcore.tools.ModTools;
import com.zer0.hardcore.tools.VanillaTools;
import com.zer0.hardcore.worldgen.HCWorld;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MCHardcore {
	
	@SidedProxy(clientSide = "com.zer0.hardcore.ClientProxy", serverSide = "com.zer0.hardcore.ServerProxy")
	public static ServerProxy proxy;
	
	@Instance(Reference.MODID)
	public static MCHardcore modInstance;
	
//PRE-INIT
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	//REGISTER EVENT LISTENERS		
		MinecraftForge.EVENT_BUS.register(new BlockHarvestEvent());
		FMLCommonHandler.instance().bus().register(new PlayerTickEvent());
		
	//MODIFY VANILLA FILES
		Reflection.initialize(ForgeHooks.class);
		VanillaBlocks.modifyBlocks();
		VanillaTools.modifyTools();
		
	//REGISTER BLOCKS, ITEMS & TOOLS
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModTools.registerTools();
		ModArmour.registerArmour();
		
	//INITIALIZE RECIPES
		ToolRecipes.initRecipes();
		ItemRecipes.initRecipes();
		ArmourRecipes.initRecipes();
		BlockRecipes.initRecipes();
		
	//INITIALISE WORLD GEN
		HCWorld.mainRegistry();
		
	//REGISTER ENTITIES
		RegisterHelper.registerEntity(ObsidianKnight.class, "obsidianKnight", 0x800080, 0x808000);
		
		proxy.registerRenderer();
		proxy.registerTileEntities();
		
		SpawnHandler.registerMobSpawns();
	}
	
	@EventHandler
	public static void load(FMLInitializationEvent event)
	{
		proxy.registerNetwork();
	}
}