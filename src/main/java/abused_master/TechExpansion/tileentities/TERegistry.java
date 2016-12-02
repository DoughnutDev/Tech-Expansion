package abused_master.TechExpansion.tileentities;

import abused_master.TechExpansion.tileentities.conduits.TileDeFluxedEnergyConduit;
import abused_master.TechExpansion.tileentities.energybank.TileCreativeEnergyCell;
import abused_master.TechExpansion.tileentities.energybank.TileElectrumEnergyBank;
import abused_master.TechExpansion.tileentities.energybank.TileLeadEnergyBank;
import abused_master.TechExpansion.tileentities.generators.TileCoalGen;
import abused_master.TechExpansion.tileentities.machine.TileMetalBender;
import abused_master.TechExpansion.tileentities.machine.TilePulverizer;
import abused_master.TechExpansion.tileentities.machine.TileQuarry;
import abused_master.TechExpansion.tileentities.machine.TileRFFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TERegistry {
	
	public static void RegisterTE() {
		GameRegistry.registerTileEntity(TilePulverizer.class, "tile_pulverizer");
		GameRegistry.registerTileEntity(TileRFFurnace.class, "tile_rf_furnace");
		GameRegistry.registerTileEntity(TileMetalBender.class, "tile_metalbender");
		GameRegistry.registerTileEntity(TileDeFluxedEnergyConduit.class, "tile_defluxed_energy_conduit");
		GameRegistry.registerTileEntity(TileCreativeEnergyCell.class, "tile_creative_energy_cell");
		GameRegistry.registerTileEntity(TileLeadEnergyBank.class, "tile_lead_energy_bank");
		GameRegistry.registerTileEntity(TileElectrumEnergyBank.class, "tile_electrum_energy_bank");
		GameRegistry.registerTileEntity(TileQuarry.class, "tile_quarry");
		GameRegistry.registerTileEntity(TileCoalGen.class, "tile_coal_gen");


	}
	
}
