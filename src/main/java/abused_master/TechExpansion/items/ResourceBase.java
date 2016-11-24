package abused_master.TechExpansion.items;

import abused_master.TechExpansion.TechExpansion;
import net.minecraft.item.Item;

public class ResourceBase extends Item {
	
	public ResourceBase(String regName) {
		super();
		this.setCreativeTab(TechExpansion.TechExpansion);
		this.setUnlocalizedName(regName);
		}
	
}
