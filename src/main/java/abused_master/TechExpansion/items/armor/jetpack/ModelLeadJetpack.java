package abused_master.TechExpansion.items.armor.jetpack;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeadJetpack extends ModelBiped
{

  public static final ModelLeadJetpack INSTANCE = new ModelLeadJetpack();

  ModelRenderer jetpack;
    ModelRenderer belt1;
    ModelRenderer beltside1;
    ModelRenderer beltfront;
  
  public ModelLeadJetpack()
  {
    textureWidth = 34;
    textureHeight = 32;
    
      jetpack = new ModelRenderer(this, 0, 0);
      jetpack.addBox(0F, 0F, 0F, 8, 10, 0);
      jetpack.setRotationPoint(-4F, 1F, 2F);
      jetpack.setTextureSize(34, 32);
      jetpack.mirror = true;
      setRotation(jetpack, 0F, 0F, 0F);
      belt1 = new ModelRenderer(this, 20, 0);
      belt1.addBox(0F, 0F, 0F, 0, 1, 4);
      belt1.setRotationPoint(4F, 6F, -2F);
      belt1.setTextureSize(34, 32);
      belt1.mirror = true;
      setRotation(belt1, 0F, 0F, 0F);
      beltside1 = new ModelRenderer(this, 20, 0);
      beltside1.addBox(0F, 0F, 0F, 0, 1, 4);
      beltside1.setRotationPoint(-4F, 6F, -2F);
      beltside1.setTextureSize(34, 32);
      beltside1.mirror = true;
      setRotation(beltside1, 0F, 0F, 0F);
      beltfront = new ModelRenderer(this, 21, 6);
      beltfront.addBox(0F, 0F, 0F, 8, 1, 0);
      beltfront.setRotationPoint(-4F, 6F, -2F);
      beltfront.setTextureSize(34, 32);
      beltfront.mirror = true;
      setRotation(beltfront, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    jetpack.render(f5);
    belt1.render(f5);
    beltside1.render(f5);
    beltfront.render(f5);
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
  }

}
