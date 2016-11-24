package abused_master.TechExpansion.blocks.conduits;

import abused_master.TechExpansion.tileentities.conduits.TileDeFluxedEnergyConduit;
import cofh.api.energy.IEnergyConnection;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RFConduitDeFluxed extends RFConduitBase {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.3125D, 0.03D, 0.3125D, 0.6875D, 1D, 0.6875D);

	public RFConduitDeFluxed(Material material) {
		super(material);
		this.setUnlocalizedName("rf_conduit_defluxed");
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	    public boolean canConnectOnSide(IBlockAccess world, BlockPos thisBlock, EnumFacing side) {
	        return canConnectWithBlock(world, thisBlock.offset(side));
	    }
	 
	    public boolean canConnectWithBlock(IBlockAccess world, BlockPos blockPos) {
	        Block block = world.getBlockState(blockPos).getBlock();
	        TileEntity tile = world.getTileEntity(blockPos);
	        return (tile != null && tile instanceof IEnergyConnection) || block instanceof RFConduitDeFluxed;
	    }

	    @Override
	    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	        world.markBlockRangeForRenderUpdate(pos.add(-1, -1, -1), pos.add(1, 1, 1));
	    }
	    
	    
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileDeFluxedEnergyConduit();
	}
	
}
