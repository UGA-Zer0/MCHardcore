package com.zer0.hardcore;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.reflect.Reflection;
import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.blocks.ModBlocks;
import com.zer0.hardcore.blocks.VanillaBlocks;
import com.zer0.hardcore.entities.EntityOrc;
import com.zer0.hardcore.entities.Goblin;
import com.zer0.hardcore.entities.ObsidianKnight;
import com.zer0.hardcore.entities.SpawnHandler;
import com.zer0.hardcore.entities.VillagerSoldier;
import com.zer0.hardcore.events.BlockHarvestEvent;
import com.zer0.hardcore.events.LevelHandler;
import com.zer0.hardcore.events.PlayerTickEvent;
import com.zer0.hardcore.help.Reference;
import com.zer0.hardcore.help.RegisterHelper;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.packets.LevelSyncHandler;
import com.zer0.hardcore.packets.LevelSyncHandlerMP;
import com.zer0.hardcore.packets.LevelSyncMP;
import com.zer0.hardcore.packets.LevelSyncPacket;
import com.zer0.hardcore.packets.OpenGuiPacket;
import com.zer0.hardcore.packets.OpenGuiPacketHandler;
import com.zer0.hardcore.packets.UpgradeStatPacket;
import com.zer0.hardcore.packets.UpgradeStatPacketHandler;
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
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MCHardcore {
	
	@SidedProxy(clientSide = "com.zer0.hardcore.ClientProxy", serverSide = "com.zer0.hardcore.ServerProxy")
	public static ServerProxy proxy;
	
	@Instance(Reference.MODID)
	public static MCHardcore modInstance;
	
	public static SimpleNetworkWrapper network;
	
	//REGISTER GUI IDS
	private static int guiIndex = 0;
	public static final int SKILLS_GUI_ID = guiIndex++;
	
//PRE-INIT
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	//REGISTER NETWORK WRAPPER
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
		
	//REGISTER PACKETS
		network.registerMessage(LevelSyncHandler.class, LevelSyncPacket.class, 0, Side.CLIENT);
		network.registerMessage(LevelSyncHandlerMP.class, LevelSyncMP.class, 1, Side.CLIENT);
		network.registerMessage(OpenGuiPacketHandler.class, OpenGuiPacket.class, 2, Side.SERVER);
		network.registerMessage(UpgradeStatPacketHandler.class, UpgradeStatPacket.class, 3, Side.SERVER);
		
	//REGISTER EVENT LISTENERS		
		MinecraftForge.EVENT_BUS.register(new BlockHarvestEvent());
		MinecraftForge.EVENT_BUS.register(new LevelHandler());
		
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
		RegisterHelper.registerEntity(VillagerSoldier.class, "villagerSoldier", 0x006600, 0xCCCCCC);
		RegisterHelper.registerEntity(Goblin.class, "goblin", 0x006600, 0xCCCCCC);
		RegisterHelper.registerEntity(EntityOrc.class, "orc", 0x006600, 0xCCCCCC);
		
		proxy.registerRenderer();
		proxy.registerTileEntities();
		
		SpawnHandler.registerMobSpawns();
	}
	
	@EventHandler
	public static void load(FMLInitializationEvent event)
	{
		proxy.registerNetwork();
		proxy.registerKeybinds();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		 MinecraftServer server = MinecraftServer.getServer();
	     ICommandManager command = server.getCommandManager();
	     ServerCommandManager manager = (ServerCommandManager) command;
	}
}