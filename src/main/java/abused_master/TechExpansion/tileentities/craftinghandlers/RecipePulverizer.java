package abused_master.TechExpansion.tileentities.craftinghandlers;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import abused_master.TechExpansion.registry.ModBlocks;
import com.google.common.collect.Maps;

import abused_master.TechExpansion.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class RecipePulverizer {
	
	private static final RecipePulverizer PULVERIZING_BASE = new RecipePulverizer();
    private final Map<ItemStack, ItemStack> pulvList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static RecipePulverizer instance()
    {
        return PULVERIZING_BASE;
    }

    private RecipePulverizer()
    {
    	addPulverizingRecipeForBlock(Blocks.COBBLESTONE, new ItemStack(Blocks.GRAVEL), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.GRAVEL, new ItemStack(Blocks.SAND), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.STONE, new ItemStack(Blocks.GRAVEL), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(ModItems.IronDust, 2), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(ModItems.GoldDust, 2), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.COAL_ORE, new ItemStack(ModItems.CoalDust, 2), 1.0F);
    	addPulverizingRecipeForBlock(Blocks.DIAMOND_ORE, new ItemStack(ModItems.DiamondDust, 2), 1.0F);
    	
    	addPulverizingRecipeForItem(Items.IRON_INGOT, new ItemStack(ModItems.IronDust), 1.0F);
    	addPulverizingRecipeForItem(Items.COAL, new ItemStack(ModItems.CoalDust), 1.0F);
    	addPulverizingRecipeForItem(Items.GOLD_INGOT, new ItemStack(ModItems.CoalDust), 1.0F);
    	addPulverizingRecipeForItem(Items.DIAMOND, new ItemStack(ModItems.DiamondDust), 1.0F);
    	
    	addPulverizingRecipeForItem(ModItems.CopperIngot, new ItemStack(ModItems.CopperDust), 1.0F);
    	addPulverizingRecipeForItem(ModItems.TinIngot, new ItemStack(ModItems.TinDust), 1.0F);
    	addPulverizingRecipeForItem(ModItems.SilverIngot, new ItemStack(ModItems.SilverDust), 1.0F);
    	addPulverizingRecipeForItem(ModItems.LeadIngot, new ItemStack(ModItems.LeadDust), 1.0F);

        addPulverizingRecipeForBlock(ModBlocks.CopperOre, new ItemStack(ModItems.CopperDust, 2), 1.0F);
        addPulverizingRecipeForBlock(ModBlocks.TinOre, new ItemStack(ModItems.TinDust, 2), 1.0F);
        addPulverizingRecipeForBlock(ModBlocks.LeadOre, new ItemStack(ModItems.LeadDust, 2), 1.0F);
        addPulverizingRecipeForBlock(ModBlocks.SilverOre, new ItemStack(ModItems.SilverDust, 2), 1.0F);

        addPulverizingRecipeForBlock(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, 12, 4), 1.0F);
        addPulverizingRecipeForBlock(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD, 2), 1.0F);
        addPulverizingRecipeForBlock(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ, 4), 1.0F);
        addPulverizingRecipeForBlock(Blocks.GLOWSTONE, new ItemStack(Items.GLOWSTONE_DUST, 4), 1.0F);
        addPulverizingRecipeForBlock(Blocks.WOOL, new ItemStack(Items.STRING, 4), 1.0F);


    }

    public void addPulverizingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addPulverizingRecipeForItem(Item.getItemFromBlock(input), stack, experience);
    }

    public void addPulverizingRecipeForItem(Item input, ItemStack stack, float experience)
    {
        this.addPulverizingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }
    
    public void addPulverizingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getPulverizingResult(input) != ItemStack.field_190927_a) { net.minecraftforge.fml.common.FMLLog.info("Ignored pulverizing recipe with conflicting input: " + input + " = " + stack); return; }
        this.pulvList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    
    @Nullable
    public ItemStack getPulverizingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.pulvList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
            }
        }

        return ItemStack.field_190927_a;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.pulvList;
    }

    public float getPulverizingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
	
}
