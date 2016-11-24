package abused_master.TechExpansion.tileentities;

import abused_master.TechExpansion.tileentities.conduits.TileDeFluxedEnergyConduit;
import abused_master.TechExpansion.tileentities.energycell.TileCreativeEnergyCell;
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
		GameRegistry.registerTileEntity(TileQuarry.class, "tile_quarry");


	}
	
}
