package abused_master.TechExpansion.registry;

import abused_master.TechExpansion.blocks.BlockBase;
import abused_master.TechExpansion.blocks.Crystal;
import abused_master.TechExpansion.blocks.FluxedGrass;
import abused_master.TechExpansion.blocks.MainItemBlock;
import abused_master.TechExpansion.blocks.conduits.RFConduitDeFluxed;
import abused_master.TechExpansion.blocks.energycell.CreativeEnergyCell;
import abused_master.TechExpansion.blocks.machine.Pulverizer;
import abused_master.TechExpansion.blocks.machine.RFFurnace;
import abused_master.TechExpansion.blocks.machine.MetalBender;
import abused_master.TechExpansion.blocks.machine.Quarry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
		
	public static Block Crystal = new Crystal(Material.ROCK);
	public static Block Pulverizer = new Pulverizer(Material.ROCK);
	public static Block RFFurnace = new RFFurnace((Material.ROCK));
	public static Block FluxedGrass = new FluxedGrass(Material.GRASS);
	public static Block RFConduit = new RFConduitDeFluxed(Material.ROCK);
	public static Block CreativeEnergyCell = new CreativeEnergyCell(Material.ROCK);
	public static Block Quarry = new Quarry(Material.ROCK);
	public static Block MetalBender = new MetalBender(Material.ROCK);


	public static Block CopperOre;
	public static Block TinOre;
	public static Block LeadOre;
	public static Block SilverOre;

	public static Block CopperBlock;
	public static Block TinBlock;
	public static Block LeadBlock;
	public static Block SilverBlock;

	public static Block ElectrumBlock;
	public static Block InvarBlock;
	public static Block PlatinumBlock;
	public static Block PlatinumOre;

	public static void init() {
		
	GameRegistry.register(Crystal.setRegistryName("crystal"));
	GameRegistry.register(new MainItemBlock(Crystal).setRegistryName(Crystal.getRegistryName()));
	
	GameRegistry.register(FluxedGrass.setRegistryName("fluxed_grass"));
	GameRegistry.register(new MainItemBlock(FluxedGrass).setRegistryName(FluxedGrass.getRegistryName()));
	
	GameRegistry.register(RFConduit.setRegistryName("rf_conduit_defluxed"));
	GameRegistry.register(new MainItemBlock(RFConduit).setRegistryName(RFConduit.getRegistryName()));
	
	GameRegistry.register(CreativeEnergyCell.setRegistryName("creative_energy_cell"));
	GameRegistry.register(new MainItemBlock(CreativeEnergyCell).setRegistryName(CreativeEnergyCell.getRegistryName()));
	
	GameRegistry.register(Pulverizer.setRegistryName("pulverizer"));
	GameRegistry.register(new MainItemBlock(Pulverizer).setRegistryName(Pulverizer.getRegistryName()));

		GameRegistry.register(RFFurnace.setRegistryName("rf_furnace"));
		GameRegistry.register(new MainItemBlock(RFFurnace).setRegistryName(RFFurnace.getRegistryName()));

		GameRegistry.register(Quarry.setRegistryName("quarry"));
		GameRegistry.register(new MainItemBlock(Quarry).setRegistryName(Quarry.getRegistryName()));

		GameRegistry.register(MetalBender.setRegistryName("metalbender"));
		GameRegistry.register(new MainItemBlock(MetalBender).setRegistryName(MetalBender.getRegistryName()));

		CopperOre = regBlock(Material.GROUND, "copper_ore", 1.0F, 1);
		TinOre = regBlock(Material.GROUND, "tin_ore", 1.0F, 1);
		SilverOre = regBlock(Material.IRON, "silver_ore", 2.0F, 2);
		LeadOre = regBlock(Material.IRON, "lead_ore", 1.5F, 2);

		CopperBlock = regBlock((Material.GROUND), "copper_block", 1.0F, 2);
		TinBlock = regBlock((Material.GROUND), "tin_block", 1.0F, 2);
		SilverBlock = regBlock((Material.IRON), "silver_block", 2.0F, 2);
		LeadBlock = regBlock((Material.IRON), "lead_block", 1.5F, 2);

		ElectrumBlock = regBlock((Material.ROCK), "electrum_block", 1.5F, 2);
		InvarBlock = regBlock((Material.ROCK), "invar_block", 1.5F, 1);
		PlatinumBlock = regBlock((Material.IRON), "platinum_block", 2.0F, 2);
		PlatinumOre = regBlock((Material.IRON), "platinum_ore", 2.0F, 3);
	}

	private static Block regBlock(Material material, String regName, float hardness, int level) {
		final Block block = new BlockBase(material, regName, hardness, level);
		final ItemBlock itemBlock = new ItemBlock(block);
		return regBlockRes(regName, itemBlock, block);
	}

	private static Block regBlockRes(String regName, ItemBlock itemBlock, Block block) {
		block.setRegistryName(regName);
		GameRegistry.register(block);
		itemBlock.setRegistryName(regName);
		GameRegistry.register(itemBlock);
		return block;
	}

	public static void RegisterRender() {
		reg(CreativeEnergyCell);
		reg(RFConduit);
		reg(Crystal);
		reg(FluxedGrass);
		reg(Pulverizer);
		reg(RFFurnace);
		reg(MetalBender);

		reg(CopperOre);
		reg(TinOre);
		reg(LeadOre);
		reg(SilverOre);

		reg(CopperBlock);
		reg(TinBlock);
		reg(LeadBlock);
		reg(SilverBlock);

		reg(ElectrumBlock);
		reg(InvarBlock);
		reg(PlatinumBlock);
		reg(PlatinumOre);

        reg(Quarry);
	}
	
	 public static void reg(Block block) {
		
		 ModelResourceLocation res = new
				 ModelResourceLocation(block.getRegistryName().toString(), "inventory");
		 ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, res);
	 
	 }
}