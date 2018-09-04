package nc.tile.processor;

import java.util.List;

import nc.recipe.ProcessorRecipe;
import nc.recipe.ProcessorRecipeHandler;
import nc.recipe.ingredient.IItemIngredient;
import net.minecraft.item.ItemStack;

public interface IItemProcessor {
	
	public ProcessorRecipeHandler getRecipeHandler();
	
	public ProcessorRecipe getRecipe();
	
	public List<ItemStack> getItemInputs();
	
	public List<IItemIngredient> getItemIngredients();
	
	public List<IItemIngredient> getItemProducts();
	
	public List<Integer> getItemInputOrder();
}
