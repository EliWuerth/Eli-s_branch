/**
 * 
 */
package edu.mu.pizzaTypes;


import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

/**
 * 
 */
public class VegetarianPizza extends AbstractPizza{

	/**
	 * @param toppingList
	 * @param priceWithoutToppings
	 * @param pizzaOrderID
	 */
	public VegetarianPizza(double priceWithoutToppings) {
		super(1.50);
		// TODO Auto-generated constructor stub
		
        addTopping(Toppings.TOMATO);
        addTopping(Toppings.CHEESE);
        addTopping(Toppings.BELL_PEPPER);
        addTopping(Toppings.BLACK_OLIVE);
        addTopping(Toppings.MUSHROOM);
        addToppingsToPrice(priceWithoutToppings);
	}

	@Override
	public double addToppingsToPrice(double priceWithoutToppings) {
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
		totalPrice += cookingPrice;
		return totalPrice;
	}

}
