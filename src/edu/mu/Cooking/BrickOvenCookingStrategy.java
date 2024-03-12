package edu.mu.Cooking;

import edu.mu.pizza.AbstractPizza;

public class BrickOvenCookingStrategy implements ICookingStrategy {
	public static final double cookingPrice = 10.0;
    @Override
    public boolean cook(AbstractPizza pizza) {
			if (pizza.getCookingStrategy() == null) {
			    pizza.setCookingPrice(cookingPrice); 
			    pizza.setCookingStrategy(this);
			    pizza.updatePizzaPrice();
			    
			    return true;
			}
			return false;
    }

}