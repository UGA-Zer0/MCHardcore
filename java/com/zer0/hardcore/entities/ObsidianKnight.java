package com.zer0.hardcore.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.tools.ModTools;

public class ObsidianKnight extends EntityMob {

	public ObsidianKnight(World world) {
		super(world);
		
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 20.0F));
		
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	}
	
	public boolean canDespawn()
	{
		return false;
	}
	
	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	protected Item getDropItem()
	{
		return ModItems.obsidianUnref;
	}
	
	public void onLivingUpdate()
	{
		//ADD SWORD
		this.setCurrentItemOrArmor(0, new ItemStack(ModTools.obsidianSword));
		
		//ADD ARMOUR
		this.setCurrentItemOrArmor(1, new ItemStack(ModArmour.obsidianBoots));
		this.setCurrentItemOrArmor(2, new ItemStack(ModArmour.obsidianLegs));
		this.setCurrentItemOrArmor(3, new ItemStack(ModArmour.obsidianChestplate));
		this.setCurrentItemOrArmor(4, new ItemStack(ModArmour.obsidianHelm));
		
		this.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 100, 1));
		
		super.onLivingUpdate();
	}

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.blaze.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }

}
