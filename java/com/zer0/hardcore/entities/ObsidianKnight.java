package com.zer0.hardcore.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.zer0.hardcore.armour.ModArmour;
import com.zer0.hardcore.items.ModItems;
import com.zer0.hardcore.tools.ModTools;

public class ObsidianKnight extends EntityMob {

	public ObsidianKnight(World world) {
		super(world);
		
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, true));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 20.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 1, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		
		this.isImmuneToFire = true;
		this.experienceValue = 78;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(180.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public boolean isValidLightLevel()
	{
		return true;
	}
	
	protected Item getDropItem()
	{
		return ModItems.obsidianShard;
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
		
		super.onLivingUpdate();
	}

    protected String getHurtSound()
    {
        return "game.player.hurt";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    protected String getSwimSound()
    {
        return "game.player.swim";
    }

    protected String getSplashSound()
    {
        return "game.player.swim.splash";
    }
    
    protected String getDeathSound()
    {
        return "game.hostile.die";
    }

    protected String func_146067_o(int p_146067_1_)
    {
        return p_146067_1_ > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
    }

}
