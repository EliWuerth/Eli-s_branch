/**
 * 
 */
package edu.mu.pizzaTypes;

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
        addTopping(Toppings.CANADIAN_BACON);
        addTopping(Toppings.CHEESE);
        addTopping(Toppings.PINEAPPLE);
        addToppingsToPrice(priceWithoutToppings);
	}

	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
		
		//set toppingPrice to 0
		double toppingPrice = 0;
		
		//go through toppingList and add up the dollar values associated with each topping on pizza
		for(Toppings topping: toppingList) {
			toppingPrice = toppingPrice + topping.getToppingPrice();
		}
		//calculate totalPrice of pizza and toppings & return value
		//should this be this.?
		totalPrice = priceWithoutToppings + toppingPrice + cookingPrice;
		return totalPrice;
	}

	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		totalPrice += cookingPrice;
		return totalPrice;
	}
}
