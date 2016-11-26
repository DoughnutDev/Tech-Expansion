package abused_master.TechExpansion.dimension;

import abused_master.TechExpansion.Info;
import abused_master.TechExpansion.config.Config;
import abused_master.TechExpansion.dimension.biome.FluxBiome;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomePlains;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by Mohammad on 11/26/2016.
 */
public class ModDimensions {

    public static DimensionType FluxDimensionType;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        FluxDimensionType = DimensionType.register(Info.MODID, "_fluxdimension", 345, FluxWorldProvider.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(345, FluxDimensionType);
        Biome.registerBiome(168, "flux",  new FluxBiome(new Biome.BiomeProperties(("Flux")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
    }
}