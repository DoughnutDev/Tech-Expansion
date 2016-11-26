package abused_master.TechExpansion.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	private static final String MOD_JATMA = "TechExpansion";
	
	public static String configpath;
	public static Configuration config;
	
	public static boolean Pulverizer;
	
	
	public static int CrystalRate;

    public static void init(FMLPreInitializationEvent event) {

		configpath = event.getModConfigurationDirectory().getAbsolutePath() + File.separator;
		config = new Configuration(new File(configpath + "TechExpansion.cfg"));
		try {
			config.load();
			Config.configure(config);
		} catch (Exception e1) {
			System.out.println("Error Loading Config File: TechExpansion.cfg");
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}

	public static void configure(Configuration config) {
		
		/**
		 * useless atm until i get to actually using the config
		config.addCustomCategoryComment(MOD_JATMA, "TechExpansion Config");
		Pulverizer = config.getBoolean("Pulverizer", MOD_JATMA, true, "Set to false if you want the Pulverizer to be Disabled");
		
		
		CrystalRate = config.getInt("CrystalRate", MOD_JATMA, 10, 0, 100, "Set to change the Crystal Spawn rate, 0 = no spawning");
		*/
	}	
}
