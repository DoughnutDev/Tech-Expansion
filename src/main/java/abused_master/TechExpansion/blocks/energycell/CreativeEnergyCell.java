package abused_master.TechExpansion.blocks.energycell;

import abused_master.TechExpansion.TechExpansion;
import abused_master.TechExpansion.tileentities.energycell.TileCreativeEnergyCell;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class CreativeEnergyCell extends BlockContainer {

	public CreativeEnergyCell(Material material) {
		super(material);
		this.setCreativeTab(TechExpansion.TechExpansion);
		this.setHardness(1.0F);
		this.setUnlocalizedName("creative_energy_cell");
	}
	
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileCreativeEnergyCell();
	}

}
