package abused_master.TechExpansion.items.armor.jetpack;

import abused_master.TechExpansion.TechExpansion;
import abused_master.TechExpansion.registry.KeybindHandler;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Mohammad on 11/28/2016.
 */
public class LeadJetpack extends ItemArmor implements IEnergyContainerItem {

    public EnergyStorage storage = new EnergyStorage(100000);

    ModelLeadJetpack pack;

    public LeadJetpack(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setCreativeTab(TechExpansion.TechExpansion);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("lead_jetpack");
    }

    @SideOnly(Side.CLIENT)
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
        return ModelLeadJetpack.INSTANCE;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return super.getArmorTexture(stack, entity, slot, type);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if(KeybindHandler.keybind.isKeyDown() && storage.getEnergyStored() > 200) {
            storage.setEnergyStored(storage.getEnergyStored() - 50);
            player.addVelocity(0, 0.1, 0);
            player.fallDistance = 0;
        }
        super.onArmorTick(world, player, itemStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(storage.getEnergyStored() + "/100,000 RF");
        tooltip.add("Uses 200RF/Tick");
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return storage.getMaxEnergyStored();
    }
}
