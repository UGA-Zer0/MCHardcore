package com.zer0.hardcore.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class OrcModel extends ModelBase
{

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer jaw;
    ModelRenderer tooth1;
    ModelRenderer tooth2;
    ModelRenderer leftshoulderpad;
    ModelRenderer rightshoulderpad;
    ModelRenderer hammerhandle;
    ModelRenderer hammerhead;
  
  public OrcModel()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 9, 8, 9);
      head.setRotationPoint(-0.5F, -3F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      
      body = new ModelRenderer(this, 37, 0);
      body.addBox(-4F, 0F, -2F, 12, 15, 7);
      body.setRotationPoint(-2F, -3F, -1F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      
      rightarm = new ModelRenderer(this, 76, 0);
      rightarm.addBox(-5F, -2F, -2F, 5, 14, 5);
      rightarm.setRotationPoint(-6F, -1F, 0F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      
      leftarm = new ModelRenderer(this, 97, 0);
      leftarm.addBox(0F, -2F, -2F, 5, 14, 5);
      leftarm.setRotationPoint(6F, -1F, 0F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      
      rightleg = new ModelRenderer(this, 0, 27);
      rightleg.addBox(-2.5F, 0F, -2.5F, 6, 12, 6);
      rightleg.setRotationPoint(-3.5F, 12F, 0F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      
      leftleg = new ModelRenderer(this, 25, 27);
      leftleg.addBox(-2.5F, 0F, -2.5F, 6, 12, 6);
      leftleg.setRotationPoint(2.5F, 12F, 0F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      
      jaw = new ModelRenderer(this, 12, 23);
      jaw.addBox(-4.5F, -1.5F, -1F, 9, 2, 1);
      jaw.setRotationPoint(0.5F, -0.5F, -3.5F);
      jaw.setTextureSize(128, 128);
      jaw.mirror = true;
      setRotation(jaw, 0.2268928F, 0F, 0F);
      head.addChild(jaw);
      
      tooth1 = new ModelRenderer(this, 23, 19);
      tooth1.addBox(0F, 0F, 0F, 1, 2, 1);
      tooth1.setRotationPoint(2F, -2.5F, -1.5F);
      tooth1.setTextureSize(128, 128);
      tooth1.mirror = true;
      setRotation(tooth1, 0.2268928F, -0.122173F, -0.1396263F);
      jaw.addChild(tooth1);
      
      tooth2 = new ModelRenderer(this, 17, 19);
      tooth2.addBox(0F, 0F, 0F, 1, 2, 1);
      tooth2.setRotationPoint(-3F, -2.5F, -1.5F);
      tooth2.setTextureSize(128, 128);
      tooth2.mirror = true;
      setRotation(tooth2, 0.4014257F, 0.2792527F, 0.0698132F);
      jaw.addChild(tooth2);
      
      leftshoulderpad = new ModelRenderer(this, 97, 25);
      leftshoulderpad.addBox(0F, -2F, -2F, 7, 7, 7);
      leftshoulderpad.setRotationPoint(-1F, -1F, -1F);
      leftshoulderpad.setTextureSize(128, 128);
      leftshoulderpad.mirror = true;
      setRotation(leftshoulderpad, 0F, 0F, 0F);
      leftarm.addChild(leftshoulderpad);
      
      rightshoulderpad = new ModelRenderer(this, 66, 25);
      rightshoulderpad.addBox(0F, -2F, -2F, 7, 7, 7);
      rightshoulderpad.setRotationPoint(-6F, -1F, -1F);
      rightshoulderpad.setTextureSize(128, 128);
      rightshoulderpad.mirror = true;
      setRotation(rightshoulderpad, 0F, 0F, 0F);
      rightarm.addChild(rightshoulderpad);
      
      
      hammerhandle = new ModelRenderer(this, 51, 41);
      hammerhandle.addBox(-5F, -2F, -2F, 2, 2, 34);
      hammerhandle.setRotationPoint(1F, 11F, -15F);
      hammerhandle.setTextureSize(128, 128);
      hammerhandle.mirror = true;
      setRotation(hammerhandle, 0F, 0F, 0F);
      rightarm.addChild(hammerhandle);
      
      hammerhead = new ModelRenderer(this, 76, 79);
      hammerhead.addBox(-5F, -2F, -2F, 6, 10, 6);
      hammerhead.setRotationPoint(-2F, -4F, 1F);
      hammerhead.setTextureSize(128, 128);
      hammerhead.mirror = true;
      setRotation(hammerhead, 0F, 0F, 0F);
      hammerhandle.addChild(hammerhead);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);

    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.rightarm.rotateAngleZ = 0.0F;
    this.leftarm.rotateAngleZ = 0.0F;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightleg.rotateAngleY = 0.0F;
    this.leftleg.rotateAngleY = 0.0F;
    
    float f6;
    float f7;

    if (this.onGround > -9990.0F)
    {
        f6 = this.onGround;
        this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
        this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
        this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
        this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
        this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
        this.rightarm.rotateAngleY += this.body.rotateAngleY;
        this.leftarm.rotateAngleY += this.body.rotateAngleY;
        this.leftarm.rotateAngleX += this.body.rotateAngleY;
        f6 = 1.0F - this.onGround;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * (float)Math.PI);
        float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
        this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
        this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
    }
    
    this.rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    this.rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    this.leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
  }

}
