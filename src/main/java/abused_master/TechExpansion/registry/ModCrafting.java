package abused_master.TechExpansion.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Mohammad on 11/22/2016.
 */
public class ModCrafting {

    public static void regRecipes() {

        /**
         * Smelting Recipes
         */

        GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.CopperIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.TinIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.LeadOre, new ItemStack(ModItems.LeadIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.NickelBlock, new ItemStack(ModItems.NickelIngot), 1.0F);
        GameRegistry.addSmelting(ModBlocks.PlatinumOre, new ItemStack(ModItems.PlatinumIngot), 1.0F);

        GameRegistry.addSmelting(ModItems.CopperDust, new ItemStack(ModItems.CopperIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.TinDust, new ItemStack(ModItems.TinIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.LeadDust, new ItemStack(ModItems.LeadIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.SilverDust, new ItemStack(ModItems.SilverIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.NickelDust, new ItemStack(ModItems.NickelIngot), 1.0F);
        GameRegistry.addSmelting(ModItems.ElectrumDust, new ItemStack(ModItems.ElectrumIngot), 1.0F);

        GameRegistry.addSmelting(ModItems.CoalDust, new ItemStack(Items.COAL), 1.0F);
        GameRegistry.addSmelting(ModItems.IronDust, new ItemStack(Items.IRON_INGOT), 1.0F);
        GameRegistry.addSmelting(ModItems.GoldDust, new ItemStack(Items.GOLD_INGOT), 1.0F);
        GameRegistry.addSmelting(ModItems.DiamondDust, new ItemStack(Items.DIAMOND), 1.0F);

        /**
         * Crafting Recipes
         */

        GameRegistry.addRecipe(new ItemStack(ModBlocks.CopperBlock), "XXX","XXX","XXX", 'X', ModItems.CopperIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.TinBlock), "XXX","XXX","XXX", 'X', ModItems.TinIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.LeadBlock), "XXX","XXX","XXX", 'X', ModItems.LeadIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.SilverBlock), "XXX","XXX","XXX", 'X', ModItems.SilverIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ElectrumBlock), "XXX","XXX","XXX", 'X', ModItems.ElectrumIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.InvarBlock), "XXX","XXX","XXX", 'X', ModItems.InvarIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.PlatinumBlock), "XXX","XXX","XXX", 'X', ModItems.PlatinumIngot);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.NickelBlock), "XXX","XXX","XXX", 'X', ModItems.NickelIngot);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.InvarIngot, 2), new ItemStack(ModItems.IronDust), new ItemStack(ModItems.NickelDust), new ItemStack(ModItems.NickelDust));


    }

}
