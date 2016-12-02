package abused_master.TechExpansion.gui;

import abused_master.TechExpansion.gui.generators.GuiCoalGen;
import abused_master.TechExpansion.gui.machine.GuiMetalBender;
import abused_master.TechExpansion.gui.machine.GuiPulverizer;
import abused_master.TechExpansion.gui.machine.GuiRFFurnace;
import abused_master.TechExpansion.tileentities.container.generators.CoalGenContainer;
import abused_master.TechExpansion.tileentities.container.machine.MetalBenderContainer;
import abused_master.TechExpansion.tileentities.container.machine.PulverizerContainer;
import abused_master.TechExpansion.tileentities.container.machine.RFFurnaceContainer;
import abused_master.TechExpansion.tileentities.generators.TileCoalGen;
import abused_master.TechExpansion.tileentities.machine.TileMetalBender;
import abused_master.TechExpansion.tileentities.machine.TilePulverizer;
import abused_master.TechExpansion.tileentities.machine.TileRFFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_PULVERIZER = 0;
	public static final int GUI_RFFURNACE = 1;
	public static final int GUI_METALBENTER = 2;
	public static final int GUI_COALGEN = 3;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		 BlockPos pos = new BlockPos(x, y, z);
	        TileEntity te = world.getTileEntity(pos);
		if( ID == GUI_PULVERIZER) {
			if (te instanceof TilePulverizer) {
				return new PulverizerContainer(player.inventory, (TilePulverizer) te);
			}
		}
		if(ID == GUI_RFFURNACE) {
			if (te instanceof TileRFFurnace) {
				return new RFFurnaceContainer(player.inventory, (TileRFFurnace) te);
			}
		}
		if(ID == GUI_METALBENTER) {
			if (te instanceof TileMetalBender) {
				return new MetalBenderContainer(player.inventory, (TileMetalBender) te);
			}
		}
		if(ID == GUI_COALGEN) {
			if (te instanceof TileCoalGen) {
				return new CoalGenContainer(player.inventory, (TileCoalGen) te);
			}
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
		if( ID == GUI_PULVERIZER) {
			if (te instanceof TilePulverizer) {
				TilePulverizer containerTileEntity = (TilePulverizer) te;
				return new GuiPulverizer(containerTileEntity, new PulverizerContainer(player.inventory, containerTileEntity), te);
			}
		}
		if( ID == GUI_RFFURNACE) {
			if (te instanceof TileRFFurnace) {
				TileRFFurnace containerTileEntity = (TileRFFurnace) te;
				return new GuiRFFurnace(containerTileEntity, new RFFurnaceContainer(player.inventory, containerTileEntity), te);
			}
		}

		if( ID == GUI_METALBENTER) {
			if (te instanceof TileMetalBender) {
				TileMetalBender containerTileEntity = (TileMetalBender) te;
				return new GuiMetalBender(containerTileEntity, new MetalBenderContainer(player.inventory, containerTileEntity), te);
			}
		}
		if( ID == GUI_COALGEN) {
			if (te instanceof TileCoalGen) {
				TileCoalGen containerTileEntity = (TileCoalGen) te;
				return new GuiCoalGen(containerTileEntity, new CoalGenContainer(player.inventory, containerTileEntity), te);
			}
		}
		return null;
	}
}