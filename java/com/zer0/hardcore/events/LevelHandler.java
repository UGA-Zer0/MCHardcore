package com.zer0.hardcore.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;

import com.zer0.hardcore.player.ExtendedPlayerProperties;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
	public void onEntityDeath(LivingDeathEvent event)
	{
		Entity entity = event.entity;
		DamageSource sauce = event.source;
		
		if(sauce.getSourceOfDamage() instanceof EntityPlayer)
		{
			
			if(ExtendedPlayerProperties.fetchProperties((EntityPlayer)sauce.getSourceOfDamage()) != null)
			{
				EntityPlayer player = (EntityPlayer)sauce.getSourceOfDamage();
				
				ExtendedPlayerProperties playerProperties = ExtendedPlayerProperties.fetchProperties(player);
				
				double mobHP = ((EntityLivingBase)event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
				
				int expValue = (int)(((int)mobHP*10));
				
				System.out.println("Adding EXP value: "+expValue);
				
				playerProperties.addExp(expValue);
				
			}
		}
	}
	
	@SubscribeEvent
	public void nameFormat(NameFormat event)
	{
		
		if(ExtendedPlayerProperties.fetchProperties(event.entityPlayer) != null)
		{
			System.out.println("[MCHardcore] Reformatting name for "+event.username);
			ExtendedPlayerProperties props = ExtendedPlayerProperties.fetchProperties(event.entityPlayer);
			int level = props.getLevel();
			event.displayname = event.username + " \u00A7a(Lvl " + level + ")";
		}
	}

}
