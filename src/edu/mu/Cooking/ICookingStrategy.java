package edu.mu.Cooking;

import edu.mu.pizza.AbstractPizza;

public interface ICookingStrategy {
	public boolean cook(AbstractPizza pizza);
}
