package edu.mu.Cooking;

import edu.mu.pizza.AbstractPizza;

/**
 * This class implements the ICookingStrategy interface for cooking pizzas in a brick oven.
 * The cookingPrice is set to 10.0 and is applied to the pizza's price when the cook method is called.
 */
public class BrickOvenCookingStrategy implements ICookingStrategy {
	/**
     * The cookingPrice for a brick oven cooked pizza.
     */
	public static final double cookingPrice = 10.0;
	
	/**
     * Cooks the given pizza using a brick oven.
     *
     * @param pizza The pizza to cook.
     * @return True if the pizza was successfully cooked, false otherwise.
     */
	@Override
    public boolean cook(AbstractPizza pizza) {
		// If the pizza doesn't has a cooking strategy, it can be cooked in the brick oven.
			if (pizza.getCookingStrategy() == null) {
				// Set the cooking price for the pizza.
			    pizza.setCookingPrice(cookingPrice); 
			    // Set the cooking strategy for the pizza to this brick oven cooking strategy.
			    pizza.setCookingStrategy(this);
			    // Update the pizza's price to include the cooking price.
			    pizza.updatePizzaPrice();
			    // The pizza was successfully cooked.
			    return true;
			}
			return false;
    }

}