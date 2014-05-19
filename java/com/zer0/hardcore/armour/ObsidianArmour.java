package com.zer0.hardcore.armour;

import com.zer0.hardcore.help.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ObsidianArmour extends ItemArmor {
	
	public ObsidianArmour(ArmorMaterial material, int var1, int var2)
	{
		super(material, var1, var2);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModArmour.obsidianHelm || stack.getItem() == ModArmour.obsidianChestplate 
				|| stack.getItem() == ModArmour.obsidianBoots)
		{
			return Reference.MODID + ":textures/armour/obsidianArmour1.png";
		}
		else if(stack.getItem() == ModArmour.obsidianLegs)
		{
			return Reference.MODID + ":textures/armour/obsidianArmour2.png";
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
			
			if (helm.getItem() == ModArmour.obsidianHelm &&
				chestplate.getItem() == ModArmour.obsidianChestplate &&
				legs.getItem() == ModArmour.obsidianLegs &&
				boots.getItem() == ModArmour.obsidianBoots)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 100, 2));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 1));
				
				if(player.isBurning())
				{
					player.extinguish();
				}
			}
		}
	}

}
