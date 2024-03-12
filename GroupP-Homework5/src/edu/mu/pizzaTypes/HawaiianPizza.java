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
        addTopping(Toppings.CANADIAN_BACON);
        addTopping(Toppings.CHEESE);
        addTopping(Toppings.PINEAPPLE);
        addToppingsToPrice(priceWithoutToppings);
      
	}
	double toppingsPrice;
	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
        for (Toppings topping : toppingList) {
        	toppingsPrice += topping.getToppingPrice();
        	//System.out.println("getToppingPrice(): " + topping.getToppingPrice());
        	
        	//System.out.println("priceWithoutToppings: " + priceWithoutToppings);
        }
        toppingsPrice += priceWithoutToppings;
        System.out.println("toppingsPrice: " + toppingsPrice);
        return toppingsPrice;
	}

	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		totalPrice = toppingsPrice + cookingPrice;

		System.out.println("getCookingPrice(): " + getCookingPrice());
		
		return totalPrice;
	}
	

}
