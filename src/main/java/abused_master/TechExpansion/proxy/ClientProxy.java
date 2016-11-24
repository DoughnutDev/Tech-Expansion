package abused_master.TechExpansion.proxy;

import abused_master.TechExpansion.Info;
import abused_master.TechExpansion.registry.ModBlocks;
import abused_master.TechExpansion.registry.ModItems;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ModItems.RegisterRender();
		ModBlocks.RegisterRender();
	    OBJLoader.INSTANCE.addDomain(Info.MODID);
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
}
