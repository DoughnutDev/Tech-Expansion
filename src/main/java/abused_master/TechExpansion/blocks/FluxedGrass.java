package abused_master.TechExpansion.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import abused_master.TechExpansion.TechExpansion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class FluxedGrass extends Block {

	public FluxedGrass(Material material) {
		super(material);
		this.setCreativeTab(TechExpansion.TechExpansion);
		this.setHardness(1.0F);
		this.setUnlocalizedName("fluxed_grass");
		this.canSilkHarvest();
	}
	
	 @Nullable
	    public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getItemFromBlock(Blocks.DIRT);
	    }
	
}
