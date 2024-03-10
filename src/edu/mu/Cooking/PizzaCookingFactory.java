package edu.mu.Cooking;

import edu.mu.Orders.PizzaOrder;
import edu.mu.pizza.AbstractPizza;
import edu.mu.pizzaTypes.HawaiianPizza;
import edu.mu.pizzaTypes.MargheritaPizza;
import edu.mu.pizzaTypes.PizzaType;
import edu.mu.pizzaTypes.SupremePizza;
import edu.mu.pizzaTypes.VegetarianPizza;

//PizzaCookingFactory.java
public class PizzaCookingFactory {
 private static int orderIDCounter = 0;

 public AbstractPizza createPizza(PizzaType pizzaType) {
     AbstractPizza pizza;

     switch (pizzaType) {
         case MARGHERITA:
             pizza = new MargheritaPizza(2.50);
             break;
         case VEGETARIAN:
             pizza = new VegetarianPizza(1.50);
             break;
         case HAWAIIAN:
             pizza = new HawaiianPizza(3.00);
             break;
         case SUPREME:
             pizza = new SupremePizza(3.50);
             break;
         default:
             throw new IllegalArgumentException("Invalid pizza type: " + pizzaType);
     }

     pizza.setPizzaOrderID(++orderIDCounter);
     return pizza;
 }
}