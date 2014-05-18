package com.zer0.hardcore;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.zer0.hardcore.blocks.ModBlocks;
import com.zer0.hardcore.events.BlockHarvestEvent;
import com.zer0.hardcore.events.EntityUpdateEvent;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.recipes.ItemRecipes;
import com.zer0.hardcore.recipes.ToolRecipes;
import com.zer0.hardcore.tools.ModTools;
import com.zer0.hardcore.worldgen.HCWorld;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MCHardcore {
	
	@SidedProxy(clientSide = "com.zer0.hardcore.ClientProxy", serverSide = "com.zer0.hardcore.ServerProxy")
	public static ServerProxy proxy;
	
//PRE-INIT
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.registerRenderer();
		
	//REGISTER EVENT LISTENERS
		FMLCommonHandler.instance().bus().register(new EntityUpdateEvent());
		MinecraftForge.EVENT_BUS.register(new BlockHarvestEvent());
		
	//REGISTER BLOCKS, ITEMS & TOOLS
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModTools.registerTools();
		
	//INITIALIZE RECIPES
		ToolRecipes.initRecipes();
		ItemRecipes.initRecipes();
		
	//INITIALISE WORLD GEN
		HCWorld.mainRegistry();
	}
}