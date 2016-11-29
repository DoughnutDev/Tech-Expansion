package abused_master.TechExpansion.registry;

import abused_master.TechExpansion.items.ResourceBase;
import abused_master.TechExpansion.items.Wrench;
import abused_master.TechExpansion.items.armor.jetpack.LeadJetpack;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item CoalDust;
	public static Item IronDust;
	public static Item GoldDust;
	public static Item DiamondDust;
	public static Item CopperDust;
	public static Item TinDust;
	public static Item SilverDust;
	public static Item LeadDust;
	
	public static Item CopperIngot;
	public static Item TinIngot;
	public static Item SilverIngot;
	public static Item LeadIngot;

	public static Item ElectrumIngot;
	public static Item InvarIngot;
	public static Item PlatinumIngot;

	public static Item IronPlate;
 	public static Item CopperPlate;
 	public static Item LeadPlate;
 	public static Item ElectrumPlate;
 	public static Item InvarPlate;
 	public static Item PlatinumPlate;

	public static Item ElectrumDust;
	public static Item NickelIngot;
	public static Item NickelDust;
	
	public static Item Wrench = new Wrench();

	public static ItemArmor.ArmorMaterial LeadJetpackMaterial = EnumHelper.addArmorMaterial("LeadJetpackMaterial", "techexpansion:lead_jetpack", -1, new int[]{2, 6, 5, 2}, 0, null, 0);
	public static ItemArmor LeadJetpack = new LeadJetpack(LeadJetpackMaterial, 0, EntityEquipmentSlot.CHEST);

	public static void init() {
		
		GameRegistry.register(Wrench.setRegistryName("wrench"));
		GameRegistry.register(LeadJetpack.setRegistryName("lead_jetpack"));

		CoalDust = regResource("coal_dust");
		IronDust = regResource("iron_dust");
		GoldDust = regResource("gold_dust");
		DiamondDust = regResource("diamond_dust");
		CopperDust = regResource("copper_dust");
		TinDust = regResource("tin_dust");
		SilverDust = regResource("silver_dust");
		LeadDust = regResource("lead_dust");
		
		CopperIngot = regResource("copper_ingot");
		TinIngot = regResource("tin_ingot");
		SilverIngot = regResource("silver_ingot");
		LeadIngot = regResource("lead_ingot");

		ElectrumIngot = regResource("electrum_ingot");
		InvarIngot = regResource("invar_ingot");
		PlatinumIngot = regResource("platinum_ingot");

		IronPlate = regResource("iron_plate");
		CopperPlate = regResource("copper_plate");
		LeadPlate = regResource("lead_plate");
		ElectrumPlate = regResource("electrum_plate");
		InvarPlate = regResource("invar_plate");
		PlatinumPlate = regResource("platinum_plate");

		ElectrumDust = regResource("electrum_dust");
		NickelIngot = regResource("nickel_ingot");
		NickelDust = regResource("nickel_dust");
		
	}
	
	private static Item regResource(String regName) {     
		final Item resource = new ResourceBase(regName);     
		return regItemResource(regName, resource);
		}
	
	private static Item regItemResource(String regName, Item item) {     
		item.setRegistryName(regName);     
		GameRegistry.register(item);
		return item;
		}
	
	public static void RegisterRender() {
		
		reg(Wrench);
		reg(IronDust);
		reg(CoalDust);
		reg(GoldDust);
		reg(DiamondDust);
		reg(CopperDust);
		reg(TinDust);
		reg(SilverDust);
		reg(LeadDust);
		reg(CopperIngot);
		reg(TinIngot);
		reg(LeadIngot);
		reg(SilverIngot);
		reg(ElectrumIngot);
		reg(InvarIngot);
		reg(PlatinumIngot);

		reg(IronPlate);
		reg(CopperPlate);
		reg(LeadPlate);
		reg(ElectrumPlate);
		reg(InvarPlate);
		reg(PlatinumPlate);

		reg(ElectrumDust);
		reg(NickelIngot);
		reg(NickelDust);
		reg(LeadJetpack);
	}
	
	public static void reg(Item item) {
        ModelResourceLocation res = new ModelResourceLocation(item.getRegistryName().toString(), "inventory");

        ModelLoader.setCustomModelResourceLocation(item, 0, res);
    }
	
}
