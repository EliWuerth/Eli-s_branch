package edu.mu;

import edu.mu.pizzaTypes.PizzaType;
import edu.mu.Cooking.*;
import edu.mu.pizza.PizzaOrder;

public class Main {

	public static void main(String[] args) {
		// Instantiate a pizza order
        PizzaOrder order = new PizzaOrder();
        
        
        // Add pizzas to the cart
        order.addPizzaToCart(PizzaType.MARGHERITA);
        order.addPizzaToCart(PizzaType.VEGETARIAN);
        order.addPizzaToCart(PizzaType.HAWAIIAN);
        order.addPizzaToCart(PizzaType.SUPREME);
	     
        // Select cooking strategies for the pizzas in the cart
        order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
        order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
        order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.MICROWAVE);
        order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.BRICK_OVEN);

        // Print pizza order cart
        order.printPizzaOrderCart(1);
        order.printPizzaOrderCart(2);
        order.printPizzaOrderCart(3);
        order.printPizzaOrderCart(4);

        // Calculate the bill
        try {
            double bill = order.checkout();
            System.out.printf("Total Bill: $%.2f%n", bill);
        } catch (Exception e) {
            System.err.println("Error calculating the bill: " + e.getMessage());
        }
	}

}
