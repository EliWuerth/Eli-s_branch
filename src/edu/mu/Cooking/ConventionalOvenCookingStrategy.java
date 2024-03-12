package edu.mu.Cooking;

import edu.mu.pizza.AbstractPizza;

public class ConventionalOvenCookingStrategy implements ICookingStrategy {
	private static final double cookingPrice = 8.0;

    @Override
    public boolean cook(AbstractPizza pizza) {
    	if (pizza.getCookingStrategy() == null) {
            pizza.setCookingPrice(cookingPrice);
            pizza.updatePizzaPrice();
            pizza.setCookingStrategy(this);

            return true;
        }
        return false;
    }
}