package abused_master.TechExpansion.blocks.conduits;

import abused_master.TechExpansion.TechExpansion;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class RFConduitBase extends BlockContainer {
		
	public RFConduitBase(Material material) {
		super(material);
		this.setCreativeTab(TechExpansion.Conduits);
		this.setHardness(1.0F);
		this.setLightLevel(.5F);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
}
