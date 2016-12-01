package abused_master.TechExpansion.blocks.energybank;

import abused_master.TechExpansion.TechExpansion;
import abused_master.TechExpansion.tileentities.energybank.TileCreativeEnergyCell;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class CreativeEnergyBank extends BlockContainer {

	public CreativeEnergyBank(Material material) {
		super(material);
		this.setCreativeTab(TechExpansion.TechExpansion);
		this.setHardness(1.0F);
		this.setUnlocalizedName("creative_energy_bank");
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

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}
}
