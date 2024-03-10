package edu.mu.pizzaTypes;

import java.util.List;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

public class SupremePizza extends AbstractPizza{

	/**
	 * @param toppingList
	 * @param priceWithoutToppings
	 * @param pizzaOrderID
	 */
	public SupremePizza(double priceWithoutToppings) {
		super(3.50);
		// TODO Auto-generated constructor stub
		addToppingsToPrice(getPriceWithoutToppings());
        addTopping(Toppings.TOMATO);
        addTopping(Toppings.CHEESE);
        addTopping(Toppings.BELL_PEPPER);
        addTopping(Toppings.ITALIAN_SAUSAGE);
        addTopping(Toppings.PEPPERONI);
        addTopping(Toppings.BLACK_OLIVE);
        addTopping(Toppings.MUSHROOM);
        
	}

	@Override
	public double addToppingsToPrice(double priceWithoutToppings) {
		double toppingsPrice = 0;
        for (Toppings topping : toppingList) {
        	priceWithoutToppings += topping.getToppingPrice();
        }
        totalPrice = toppingsPrice + cookingPrice;
        return totalPrice;
	}

	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
