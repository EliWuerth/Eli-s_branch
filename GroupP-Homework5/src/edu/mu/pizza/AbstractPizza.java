package edu.mu.pizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.Cooking.ICookingStrategy;

public abstract class AbstractPizza {
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter = 1; 
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	
	/**
	 * @param toppingList
	 * @param priceWithoutToppings
	 * @param totalPrice
	 * @param pizzaOrderID
	 * @param cookingStrategy
	 * @param cookingPrice
	 */
	public AbstractPizza(double priceWithoutToppings) {
		toppingList = new ArrayList<>();
        this.priceWithoutToppings = priceWithoutToppings;
        totalPrice = getTotalPrice();
        pizzaOrderID = ++orderIDCounter;
        
	}

	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public static int getOrderIDCounter() {
		return orderIDCounter;
	}


	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter++;
	}


	public double getCookingPrice() {
		return cookingPrice;
	}


	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}


	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}


	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}


	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}


	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}


	protected abstract double addToppingsToPrice(double priceWithoutToppings);

    public abstract double updatePizzaPrice();

    public void addTopping(Toppings topping) {
        toppingList.add(topping);
    }

    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
        this.cookingStrategy = cookingStrategy;

    }

    public List<Toppings> getToppingList() {
        return toppingList;
    }

    public int getPizzaOrderID() {
        return pizzaOrderID;
    }

    public double getPriceWithoutToppings() {
        // Default prices for each pizza type
        switch (this.getClass().getSimpleName()) {
            case "MARGHERITA":
                return 2.50;
            case "VEGETARIAN":
                return 1.50;
            case "HAWAIIAN":
                return 3.00;
            case "SUPREME":
                return 3.50;
            default:
                return 0;
        }
    }

    @Override
	public String toString() {
		return "Topping List: " + toppingList + ", Price Without Toppings: " + priceWithoutToppings
				+ ", Total Price: " + totalPrice + ", Pizza Order ID: " + pizzaOrderID + ", Cooking Strategy: "
				+ getCookingStrategy().getClass().getSimpleName() + ", Cooking Price: " + cookingPrice + ", Pizza Type: " + this.getClass().getSimpleName();
	}
    
}