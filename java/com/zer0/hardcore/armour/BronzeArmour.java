package com.zer0.hardcore.armour;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.zer0.hardcore.help.Reference;

public class BronzeArmour extends ItemArmor {

	public BronzeArmour(ArmorMaterial material, int var1, int var2) {
		super(material, var1, var2);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModArmour.bronzeHelm || stack.getItem() == ModArmour.bronzeChestplate 
				|| stack.getItem() == ModArmour.bronzeBoots)
		{
			return Reference.MODID + ":textures/armour/bronzeArmour1.png";
		}
		else if(stack.getItem() == ModArmour.bronzeLegs)
		{
			return Reference.MODID + ":textures/armour/bronzeArmour2.png";
		}
		else
		{
			return null;
		}
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (player.getCurrentArmor(3) != null &&
			player.getCurrentArmor(2) != null &&
			player.getCurrentArmor(1) != null &&
			player.getCurrentArmor(0) != null)
		{
			ItemStack helm = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helm.getItem() == ModArmour.bronzeHelm &&
				chestplate.getItem() == ModArmour.bronzeChestplate &&
				legs.getItem() == ModArmour.bronzeLegs &&
				boots.getItem() == ModArmour.bronzeBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20, 1));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 20, 1));
			}
		}
	}
}