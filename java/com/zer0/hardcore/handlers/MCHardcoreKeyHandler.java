package com.zer0.hardcore.handlers;


import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.packets.LevelSyncMP;
import com.zer0.hardcore.packets.OpenGuiPacket;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class MCHardcoreKeyHandler {
	
	public static final int SKILLS_GUI = 0;
	public static final String[] DESC = {"key.skillsgui.desc"};
	public static final int[] KEYVALUES = {Keyboard.KEY_P};
	
	private final KeyBinding[] KEYS;
	
	public MCHardcoreKeyHandler()
	{
		KEYS = new KeyBinding[DESC.length];
		for(int i = 0; i < DESC.length; ++i)
		{
			KEYS[i] = new KeyBinding(DESC[i], KEYVALUES[i], "key.mchardcore.category");
			ClientRegistry.registerKeyBinding(KEYS[i]);
		}
		
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event)
	{
		if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class))
		{
			int kb = Keyboard.getEventKey();
			boolean isDown = Keyboard.getEventKeyState();
			
			if(kb == KEYS[SKILLS_GUI].getKeyCode())
			{
				EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
				
				MCHardcore.network.sendToServer(new OpenGuiPacket(MCHardcore.SKILLS_GUI_ID));
			}
		}
	}

}
