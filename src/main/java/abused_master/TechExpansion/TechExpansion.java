package abused_master.TechExpansion;

import abused_master.TechExpansion.config.Config;
import abused_master.TechExpansion.dimension.TeleportCommand;
import abused_master.TechExpansion.proxy.CommonProxy;
import abused_master.TechExpansion.registry.MobDrops;
import abused_master.TechExpansion.registry.ModBlocks;
import abused_master.TechExpansion.registry.ModItems;
import abused_master.TechExpansion.tileentities.machine.TileQuarry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Info.MODID, version = Info.VERSION, name = Info.MODNAME)
public class TechExpansion {
	
    @Instance
    public static TechExpansion instance;
	
	@SidedProxy(clientSide="abused_master.TechExpansion.proxy.ClientProxy", serverSide="abused_master.TechExpansion.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Config.init(e);
		this.proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		this.proxy.init(e);
		MinecraftForge.EVENT_BUS.register(new MobDrops());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
	}

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }

    public static CreativeTabs TechExpansion = new CreativeTabs("TechExpansion")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModItems.Wrench);
        }
        
    };	
    
    public static CreativeTabs Conduits = new CreativeTabs("Conduits")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(Item.getItemFromBlock(ModBlocks.RFConduit));
        }
        
    };
	
}
