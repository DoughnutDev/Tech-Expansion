package abused_master.TechExpansion.dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;

/**
 * Created by Mohammad on 11/26/2016.
 */
public class FluxWorldProvider extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.FluxDimensionType;
    }

    @Override
    public String getSaveFolder() {
        return "FluxDimension";
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new FluxChunkGenerator(worldObj);
    }

}
