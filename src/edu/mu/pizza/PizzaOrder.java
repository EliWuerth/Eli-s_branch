package edu.mu.pizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.Cooking.BrickOvenCookingStrategy;
import edu.mu.Cooking.ConventionalOvenCookingStrategy;
import edu.mu.Cooking.CookingStyleType;
import edu.mu.Cooking.ICookingStrategy;
import edu.mu.Cooking.MicrowaveCookingStrategy;
import edu.mu.Cooking.PizzaCookingFactory;
import edu.mu.pizzaTypes.PizzaType;

public class PizzaOrder {
	 private PizzaCookingFactory pizzaCookingFactory;
	 private ICookingStrategy cookingStrategy;
	 private List<AbstractPizza> pizzaOrderList;
	
	 
	
	 public PizzaOrder() {
	     pizzaCookingFactory = new PizzaCookingFactory();
	     pizzaOrderList = new ArrayList<>();
	 }
	
	 public void printListOfToppingsByPizzaOrderID(int orderID) {
	     AbstractPizza pizza = getPizzaByOrderID(orderID);
	     if (pizza != null) {
	         System.out.println("Toppings for Pizza Order ID " + orderID + ":");
	         for (Toppings topping : pizza.getToppingList()) {
	             System.out.println(topping);
	         }
	     } else {
	         System.out.println("Pizza Order ID " + orderID + " not found.");
	     }
	 }
	
	 
	
	 public AbstractPizza getPizzaByOrderID(int orderID) {
		 try {
			for (AbstractPizza pizza : pizzaOrderList) {
			     if (pizza.getPizzaOrderID() == orderID) {
			         
			    	 return pizza;
			     }
			     //return pizza;
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	 }
	
	 public boolean addPizzaToCart(PizzaType pizzaType) {
	     AbstractPizza pizza = pizzaCookingFactory.createPizza(pizzaType);
	     
	     return pizzaOrderList.add(pizza);
	 }
	
	 public boolean addNewToppingToPizza(int orderID, Toppings topping) {
	     AbstractPizza pizza = getPizzaByOrderID(orderID);
	     if (pizza != null) {
	         pizza.addTopping(topping);
	         //pizza.updatePizzaPrice();
	         return true;
	     }
	     return false;
	 }
	
	 public boolean removeToppingFromPizza(int orderID, Toppings topping) {
	     AbstractPizza pizza = getPizzaByOrderID(orderID);
	     if (pizza != null && pizza.getToppingList().contains(topping)) {
	         pizza.getToppingList().remove(topping);
	         pizza.setTotalPrice(pizza.addToppingsToPrice(pizza.getPriceWithoutToppings()));
	         pizza.updatePizzaPrice();
	         return true;
	     }
	     return false;
	 }
	
	 public boolean isThereAnyUncookedPizza() {
	     for (AbstractPizza pizza : pizzaOrderList) {
	         if (pizza.getCookingStrategy() == null) {
	        	 return true;
	         } 
	     }
	     return false;
	 }
	
	 public double checkout() throws Exception {
		 while(isThereAnyUncookedPizza() == true) {
			 throw new Exception("There are uncooked Pizzas");
		 }
	     
	     double totalPrice = 0.0;
	     for (AbstractPizza pizza : pizzaOrderList) {
	    	 
	    	 totalPrice += pizza.updatePizzaPrice();
	    	 //System.out.println(pizza.updatePizzaPrice());
	  
	     }
	     return totalPrice;
	 }
	
	 public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		 AbstractPizza pizza = getPizzaByOrderID(orderID);
		    if (pizza != null) {
		        switch (cookingStrategyType) {
		        case BRICK_OVEN:
	                cookingStrategy = new BrickOvenCookingStrategy();
	                break;
	            case CONVENTIONAL_OVEN:
	                cookingStrategy = new ConventionalOvenCookingStrategy();
	                break;
	            case MICROWAVE:
	                cookingStrategy = new MicrowaveCookingStrategy();
	                break;
	            default:
	                System.err.println("Error: Invalid cooking strategy type.");
	                return false;
		        }
		        try {
					cookingStrategy.cook(getPizzaByOrderID(orderID));
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return true;
		    } else {
		        System.err.println("Error: Pizza Order ID " + orderID + " not found.");
		        return false;
		    }
		}
	 
	 public void printPizzaOrderCart(int orderID) {
	     AbstractPizza pizza = getPizzaByOrderID(orderID);
	     if (pizza != null) {
	         System.out.println("Pizza Order ID " + orderID + ":");
	         System.out.println(pizza.toString());
	         
	     } else {
	         System.out.println("Pizza Order ID " + orderID + " not found.");
	     }
	 }
	 
}