package abused_master.TechExpansion.blocks;

import abused_master.TechExpansion.TechExpansion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Mohammad on 11/22/2016.
 */
public class BlockBase extends Block {

    public BlockBase(Material material, String regName, float hardness, int level) {
        super(material);
        this.setCreativeTab(TechExpansion.TechExpansion);
        this.setUnlocalizedName(regName);
        this.setHarvestLevel("Pickaxe", level);
        this.setHardness(hardness);
    }
}
