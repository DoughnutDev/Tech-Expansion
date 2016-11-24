package abused_master.TechExpansion.registry;

import abused_master.TechExpansion.items.ChargedCrystal;
import abused_master.TechExpansion.items.ResourceBase;
import abused_master.TechExpansion.items.Wrench;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
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
	
	public static Item Wrench = new Wrench();
	public static Item ChargedCrystal = new ChargedCrystal();
	
	public static void init() {
		
		GameRegistry.register(Wrench.setRegistryName("wrench"));
		GameRegistry.register(ChargedCrystal.setRegistryName("charged_crystal"));
		
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
		reg(ChargedCrystal);
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
	}
	
	public static void reg(Item item) {
        ModelResourceLocation res = new ModelResourceLocation(item.getRegistryName().toString(), "inventory");

        ModelLoader.setCustomModelResourceLocation(item, 0, res);
    }
	
}
