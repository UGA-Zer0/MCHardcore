package com.zer0.hardcore.player;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.ServerProxy;
import com.zer0.hardcore.packets.SyncPlayerPropsPacket;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {
	
	public static final String EXT_PROPERTY_NAME = "ExtendedPlayer";
	public static final int LEVEL_WATCHER = 20;
	public static final int XP_WATCHER = 21;
	
	private final EntityPlayer player;
	public int expToLevel, expOverflow, startingLevel, startingXp;
	
	private int base, multiplier;
	
	public ExtendedPlayerProperties(EntityPlayer player)
	{
		this.player = player;
		this.startingLevel = 1;
		this.expOverflow = 0;
		this.startingXp = 0;
		
		this.base = 1000;
		this.multiplier = 20;
		
		this.expToLevel = this.base+(this.multiplier*this.startingLevel);
		
		this.player.getDataWatcher().addObject(LEVEL_WATCHER, this.startingLevel);
		this.player.getDataWatcher().addObject(XP_WATCHER, this.startingXp);
	}
	
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedPlayerProperties.EXT_PROPERTY_NAME, new ExtendedPlayerProperties(player));
	}
	
	public static final ExtendedPlayerProperties fetchProperties(EntityPlayer player)
	{
		return (ExtendedPlayerProperties)player.getExtendedProperties(EXT_PROPERTY_NAME);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound tagComp)
	{
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setInteger("CurrentLevel", this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER));
		properties.setInteger("CurrentExp", this.player.getDataWatcher().getWatchableObjectInt(XP_WATCHER));
		properties.setInteger("ExpRemaining", this.expToLevel);
		
		tagComp.setTag(EXT_PROPERTY_NAME, properties);
		
		System.out.println("(TEST) SAVING DATA");
	}
	
	@Override
	public void loadNBTData(NBTTagCompound tagComp)
	{
		NBTTagCompound properties = (NBTTagCompound) tagComp.getTag(EXT_PROPERTY_NAME);
		
		this.player.getDataWatcher().updateObject(LEVEL_WATCHER, properties.getInteger("CurrentLevel"));
		this.player.getDataWatcher().updateObject(XP_WATCHER, properties.getInteger("CurrentExp"));
		this.expToLevel = properties.getInteger("ExpRemaining");
		
		System.out.println("(TEST) Level: " +this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER)+ ", Exp to next level: " +this.expToLevel);
	}
	
	private static final String getSaveKey(EntityPlayer player)
	{
		return player.getCommandSenderName() + ":" + EXT_PROPERTY_NAME;
	}
	
	public static final void saveProxyData(EntityPlayer player)
	{
		ExtendedPlayerProperties playerData = ExtendedPlayerProperties.fetchProperties(player);
		NBTTagCompound savedData = new NBTTagCompound();
		playerData.saveNBTData(savedData);
		ServerProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static final void loadProxyData(EntityPlayer player)
	{
		ExtendedPlayerProperties playerData = ExtendedPlayerProperties.fetchProperties(player);
		NBTTagCompound savedData = ServerProxy.getEntityData(getSaveKey(player));
		
		if (savedData != null)
		{
			playerData.loadNBTData(savedData);	
		}
		
		MCHardcore.packetHandler.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
	}
	
	@Override
	public void init(Entity entity, World world)
	{

	}
	
	public void addExp(int amount)
	{
		expToLevel -= amount;
		int totalXpToLevel = calculateNewExpToLevel(getLevel());
		int currentXp = totalXpToLevel-expToLevel;
		
		this.player.getDataWatcher().updateObject(XP_WATCHER, currentXp);
		
		System.out.println("Exp: " +expToLevel);
		
		if(expToLevel <= 0)
		{
			if(expToLevel == 0)
			{
				this.player.getDataWatcher().updateObject(XP_WATCHER, 0);
				
				levelUp();
			}
			else if(expToLevel < 0)
			{
				this.expOverflow = expToLevel;
				
				this.player.getDataWatcher().updateObject(XP_WATCHER, expToLevel*-1);
				
				levelUp();
			}
		}
	}
	
	public int getLevel()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER);
	}
	
	public void levelUp()
	{
		int level = this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER);
		
		this.player.getDataWatcher().updateObject(LEVEL_WATCHER, level+1);
		
		expToLevel = calculateNewExpToLevel(this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER));
		this.expOverflow = 0;
		
		this.player.refreshDisplayName();
	}
	
	public int calculateNewExpToLevel(int level)
	{
		return this.base + (this.multiplier * level) + this.expOverflow;
	}
	
	public int getCurrentXp()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(XP_WATCHER);
	}

}
