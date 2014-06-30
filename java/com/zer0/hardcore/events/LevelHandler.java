package com.zer0.hardcore.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

import com.zer0.hardcore.ServerProxy;
import com.zer0.hardcore.player.ExtendedPlayerProperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class LevelHandler {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if(event.entity instanceof EntityPlayer && ExtendedPlayerProperties.fetchProperties((EntityPlayer)event.entity) == null)
		{
			ExtendedPlayerProperties.register((EntityPlayer)event.entity);
		}
	}
	
	@SubscribeEvent
	public void joinEvent(EntityJoinWorldEvent event)
	{
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = ServerProxy.getEntityData(((EntityPlayer)event.entity).getCommandSenderName());
			if(playerData != null)
			{
				((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROPERTY_NAME))).loadNBTData(playerData);
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROPERTY_NAME))).saveNBTData(playerData);
			ServerProxy.storeEntityData(((EntityPlayer)event.entity).getCommandSenderName(), playerData);
			
		}
		
		
		Entity entity = event.entity;
		DamageSource sauce = event.source;
		
		if(sauce.getSourceOfDamage() instanceof EntityPlayer)
		{
			
			if(ExtendedPlayerProperties.fetchProperties((EntityPlayer)sauce.getSourceOfDamage()) != null)
			{
				EntityPlayer player = (EntityPlayer)sauce.getSourceOfDamage();
				
				ExtendedPlayerProperties playerProperties = ExtendedPlayerProperties.fetchProperties(player);
				
				double mobHP = ((EntityLivingBase)event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
				
				int expValue = 0;
				
				if(entity instanceof EntityMob)
				{
					expValue = (int)((mobHP*5)/4);
				}
				else if(entity instanceof EntityAnimal)
				{
					expValue = (int)((mobHP*3)/2);
				}
				else if(entity instanceof EntityPlayer)
				{
					ExtendedPlayerProperties mobProps = ExtendedPlayerProperties.fetchProperties((EntityPlayer)entity);
					int mobLevel = mobProps.getLevel();
					int base = 30;
					int modifier = (int) Math.floor(Math.pow((double)mobLevel, 2.5));
					
					expValue = 30 + modifier;
				}
				
				playerProperties.addExp(expValue);
				
			}
		}
	}
	
	@SubscribeEvent
	public void nameFormat(NameFormat event)
	{
		
		if(ExtendedPlayerProperties.fetchProperties(event.entityPlayer) != null)
		{
			ExtendedPlayerProperties props = ExtendedPlayerProperties.fetchProperties(event.entityPlayer);
			int level = props.getLevel();
			event.displayname = event.username + " \u00A7a(Lvl " + level + ")";
		}
	}

}
