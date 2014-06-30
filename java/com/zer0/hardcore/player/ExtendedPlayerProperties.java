package com.zer0.hardcore.player;

import java.io.Console;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.zer0.hardcore.MCHardcore;
import com.zer0.hardcore.ServerProxy;
import com.zer0.hardcore.packets.LevelSyncPacket;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {
	
	public static final String EXT_PROPERTY_NAME = "MCHC-PlayerLevelProperties";
	public static final int LEVEL_WATCHER = 20;
	public static final int XP_WATCHER = 21;
	
	private final EntityPlayer player;
	public int expToLevel, expOverflow, startingLevel, startingXp;
	
	private int base;
	private double exponent, multiplier;
	
	public ExtendedPlayerProperties(EntityPlayer player)
	{
		this.player = player;
		this.startingLevel = 1;
		this.expOverflow = 0;
		this.startingXp = 0;
		
		this.base = 2000;
		this.multiplier = 0.1;
		this.exponent = 3;
		
		this.expToLevel = (int)(this.multiplier*((Math.pow((double)this.startingLevel, this.exponent))+this.base));
		
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
	}
	
	@Override
	public void loadNBTData(NBTTagCompound tagComp)
	{
		NBTTagCompound properties = (NBTTagCompound) tagComp.getTag(EXT_PROPERTY_NAME);
		
		this.player.getDataWatcher().updateObject(LEVEL_WATCHER, properties.getInteger("CurrentLevel"));
		this.player.getDataWatcher().updateObject(XP_WATCHER, properties.getInteger("CurrentExp"));
		this.expToLevel = properties.getInteger("ExpRemaining");
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
		
		if(expToLevel <= 0)
		{
			if(expToLevel == 0)
			{
				this.player.getDataWatcher().updateObject(XP_WATCHER, 0);
				
				levelUp();
				MCHardcore.network.sendTo(new LevelSyncPacket(player), (EntityPlayerMP)this.player);
			}
			else if(expToLevel < 0)
			{
				this.expOverflow = expToLevel;
				
				this.player.getDataWatcher().updateObject(XP_WATCHER, expToLevel*-1);
				
				levelUp();
				MCHardcore.network.sendTo(new LevelSyncPacket(player), (EntityPlayerMP)this.player);
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
		
		int newLevel = level+1;
		
		this.player.getDataWatcher().updateObject(LEVEL_WATCHER, newLevel);
		
		expToLevel = calculateNewExpToLevel(this.player.getDataWatcher().getWatchableObjectInt(LEVEL_WATCHER));
		this.expOverflow = 0;
		
		if(!this.player.worldObj.isRemote)
		{
			
			ItemStack stack = new ItemStack(Items.fireworks);
			ItemStack stack2 = new ItemStack(Items.fireworks);
			ItemStack stack3 = new ItemStack(Items.fireworks);
			ItemStack stack4 = new ItemStack(Items.fireworks);
			
			NBTTagCompound rocketTagPre1 = new NBTTagCompound();
			NBTTagCompound rocketTagPre2 = new NBTTagCompound();
			NBTTagCompound rocketTagPre3 = new NBTTagCompound();
			NBTTagCompound rocketTagPre4 = new NBTTagCompound();
			
			byte type = 2;
			rocketTagPre1.setByte("Type", type);
			rocketTagPre2.setByte("Type", type);
			rocketTagPre3.setByte("Type", type);
			rocketTagPre4.setByte("Type", type);
			
			int[] colours = new int[1];
			colours[0] = 5;
			rocketTagPre1.setIntArray("Colors", colours);
			
			int[] colours2 = new int[1];
			colours2[0] = 11;
			rocketTagPre2.setIntArray("Colors", colours2);
			
			int[] colours3 = new int[1];
			colours3[0] = 14;
			rocketTagPre3.setIntArray("Colors", colours3);
			
			int[] colours4 = new int[1];
			colours4[0] = 2;
			rocketTagPre3.setIntArray("Colors", colours4);
			
			NBTTagCompound rocketTag1 = new NBTTagCompound();
			NBTTagCompound rocketTag2 = new NBTTagCompound();
			NBTTagCompound rocketTag3 = new NBTTagCompound();
			NBTTagCompound rocketTag4 = new NBTTagCompound();
			
			rocketTag1.setTag("Explosion", rocketTagPre1);
			rocketTag2.setTag("Explosion", rocketTagPre2);
			rocketTag3.setTag("Explosion", rocketTagPre3);
			rocketTag4.setTag("Explosion", rocketTagPre4);
			
			stack.setTagCompound(rocketTag1);
			stack2.setTagCompound(rocketTag2);
			stack3.setTagCompound(rocketTag3);
			stack4.setTagCompound(rocketTag4);
			
			EntityFireworkRocket firework = new EntityFireworkRocket(this.player.worldObj, this.player.posX, this.player.posY+1, this.player.posZ, stack);
			EntityFireworkRocket firework2 = new EntityFireworkRocket(this.player.worldObj, this.player.posX, this.player.posY+1, this.player.posZ, stack2);
			EntityFireworkRocket firework3 = new EntityFireworkRocket(this.player.worldObj, this.player.posX, this.player.posY+1, this.player.posZ, stack3);
			EntityFireworkRocket firework4 = new EntityFireworkRocket(this.player.worldObj, this.player.posX, this.player.posY+1, this.player.posZ, stack4);
			
			firework.setPosition(this.player.posX, this.player.posY+1, this.player.posZ);
			firework2.setPosition(this.player.posX+1.0D, this.player.posY+1, this.player.posZ-1.5D);
			firework3.setPosition(this.player.posX-0.5D, this.player.posY+1, this.player.posZ+0.5D);
			firework4.setPosition(this.player.posX+0.5D, this.player.posY+1, this.player.posZ-0.5D);
			
			this.player.worldObj.spawnEntityInWorld(firework);
			this.player.worldObj.spawnEntityInWorld(firework2);
			this.player.worldObj.spawnEntityInWorld(firework3);
			this.player.worldObj.spawnEntityInWorld(firework4);
		}
		
		this.player.refreshDisplayName();
		this.player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20 + Math.floor((level+1)/2));

		this.player.addChatMessage(new ChatComponentText("\u00A7aCongratulations, you reached level "+newLevel));

	}
	
	public int calculateNewExpToLevel(int level)
	{
		return (int)(this.multiplier*((Math.pow((double)level, this.exponent))+this.base)) + this.expOverflow;
	}
	
	public int getCurrentXp()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(XP_WATCHER);
	}

}
