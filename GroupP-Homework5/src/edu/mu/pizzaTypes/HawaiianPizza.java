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
public class HawaiianPizza extends AbstractPizza{
	
	/**
	 * @param toppingList
	 * @param priceWithoutToppings
	 * @param pizzaOrderID
	 */
	public HawaiianPizza(double priceWithoutToppings) {
		super(3.00);
		// TODO Auto-generated constructor stub
		addToppingsToPrice(getPriceWithoutToppings());
        addTopping(Toppings.CANADIAN_BACON);
        addTopping(Toppings.CHEESE);
        addTopping(Toppings.PINEAPPLE);
        
	}

	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		double toppingsPrice = 0;
        for (Toppings topping : toppingList) {
        	toppingsPrice = topping.getToppingPrice() + priceWithoutToppings;
        }
        totalPrice = toppingsPrice + cookingPrice;
        return totalPrice;
	}

	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		totalPrice = addToppingsToPrice(getPriceWithoutToppings()) + cookingPrice;
		return 0;
	}
	

}
