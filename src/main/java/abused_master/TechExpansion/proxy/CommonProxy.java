package abused_master.TechExpansion.proxy;

import abused_master.TechExpansion.TechExpansion;
import abused_master.TechExpansion.dimension.ModDimensions;
import abused_master.TechExpansion.gui.GuiHandler;
import abused_master.TechExpansion.registry.JATMAGeneration;
import abused_master.TechExpansion.registry.ModBlocks;
import abused_master.TechExpansion.registry.ModCrafting;
import abused_master.TechExpansion.registry.ModItems;
import abused_master.TechExpansion.tileentities.TERegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public static CommonProxy proxy;

	public void preInit(FMLPreInitializationEvent e) {
		ModItems.init();
		ModBlocks.init();
	}
	
	public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new JATMAGeneration(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(TechExpansion.instance, new GuiHandler());
		TERegistry.RegisterTE();
		ModCrafting.regRecipes();
		ModDimensions.init();
}
	
	public void postInit(FMLPostInitializationEvent e) {
	}

}
