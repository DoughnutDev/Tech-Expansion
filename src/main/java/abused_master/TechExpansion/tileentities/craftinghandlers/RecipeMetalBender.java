package abused_master.TechExpansion.tileentities.craftinghandlers;

import abused_master.TechExpansion.registry.ModItems;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Created by DoughnutDev on 11/23/2016.
 */
public class RecipeMetalBender {

    private static final RecipeMetalBender BENDING_BASE = new RecipeMetalBender();
    private final Map<ItemStack, ItemStack> bendList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static RecipeMetalBender instance() {return BENDING_BASE;}


    private RecipeMetalBender() {

        addBendingRecipeForItem(Items.IRON_INGOT, new ItemStack(ModItems.IronPlate), 1.0F);
        addBendingRecipeForItem(ModItems.LeadIngot, new ItemStack(ModItems.LeadPlate), 1.0F);
        addBendingRecipeForItem(ModItems.CopperIngot, new ItemStack(ModItems.CopperPlate), 1.0F);
        addBendingRecipeForItem(ModItems.ElectrumIngot, new ItemStack(ModItems.ElectrumPlate), 1.0F);
        addBendingRecipeForItem(ModItems.InvarIngot, new ItemStack(ModItems.InvarPlate), 1.0F);
        addBendingRecipeForItem(ModItems.PlatinumIngot, new ItemStack(ModItems.PlatinumPlate), 1.0F);

    }


    public void addBendingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addBendingRecipeForItem(Item.getItemFromBlock(input), stack, experience);
    }

    public void addBendingRecipeForItem(Item input, ItemStack stack, float experience)
    {
        this.addBendingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addBendingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getBendingResult(input) != ItemStack.field_190927_a) { net.minecraftforge.fml.common.FMLLog.info("Ignored bending recipe with conflicting input: " + input + " = " + stack); return; }
        this.bendList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }


    @Nullable
    public ItemStack getBendingResult(ItemStack stack)
    {
        for (Map.Entry<ItemStack, ItemStack> entry : this.bendList.entrySet())
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
        return this.bendList;
    }

    public float getBendingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}