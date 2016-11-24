package abused_master.TechExpansion.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Mohammad on 11/22/2016.
 */
public class ModCrafting {

    public static void regRecipes() {

        GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.CopperIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.TinIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.LeadOre, new ItemStack(ModItems.LeadIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 1.0F);

        GameRegistry.addSmelting(ModItems.CopperDust, new ItemStack(ModItems.CopperIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.TinDust, new ItemStack(ModItems.TinIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.LeadDust, new ItemStack(ModItems.LeadIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.SilverDust, new ItemStack(ModItems.SilverIngot), 1.0F);

        GameRegistry.addSmelting(ModItems.CoalDust, new ItemStack(Items.COAL), 1.0F);
        GameRegistry.addSmelting(ModItems.IronDust, new ItemStack(Items.IRON_INGOT), 1.0F);
        GameRegistry.addSmelting(ModItems.GoldDust, new ItemStack(Items.GOLD_INGOT), 1.0F);
        GameRegistry.addSmelting(ModItems.DiamondDust, new ItemStack(Items.DIAMOND), 1.0F);


    }

}
