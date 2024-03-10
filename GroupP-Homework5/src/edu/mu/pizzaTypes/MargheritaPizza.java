/**
 * 
 */
package edu.mu.pizzaTypes;

import java.util.List;

import edu.mu.Cooking.ICookingStrategy;
import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

/**
 * 
 */
public class MargheritaPizza extends AbstractPizza{
	
	/**
	 * @param toppingList
	 * @param priceWithoutToppings
	 * @param pizzaOrderID
	 */
	public MargheritaPizza(double priceWithoutToppings) {
		super(2.50);
		// TODO Auto-generated constructor stub
		addToppingsToPrice(getPriceWithoutToppings());
        addTopping(Toppings.TOMATO);
        addTopping(Toppings.CHEESE);
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
