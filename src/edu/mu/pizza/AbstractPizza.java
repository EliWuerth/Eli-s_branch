package edu.mu.pizza;

import java.util.ArrayList;

import java.util.List;

import edu.mu.Cooking.ICookingStrategy;

//Abstract class representing a generic pizza

public abstract class AbstractPizza {
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int orderID;
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
	//Constructor
	public AbstractPizza(double priceWithoutToppings) {
		toppingList = new ArrayList<>();
        this.priceWithoutToppings = priceWithoutToppings;
        totalPrice = getTotalPrice();
        orderID = ++orderIDCounter;
        
	}
	
	//GETTERS and SETTERS

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
		this.orderID = pizzaOrderID;
	}

	//Abstract method for adding topping price
	protected abstract double addToppingsToPrice(double priceWithoutToppings);

	//Abstract method for updating the pizzaPrice
    public abstract double updatePizzaPrice();

    //Adds toppings
    public void addTopping(Toppings topping) {
        toppingList.add(topping);
    }

    //Sets the cooking strategy
    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
        this.cookingStrategy = cookingStrategy;
    }

    //Gets the list of toppings on a pizza
    public List<Toppings> getToppingList() {
        return toppingList;
    }

    //Gets a pizza based off of the orderID
    public int getPizzaOrderID() {
        return orderID;
    }

    // Default prices for each pizza type
    public double getPriceWithoutToppings() {
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

    //Prints the pizza information
    @Override
	public String toString() {
		return "Topping List: " + toppingList + ", Price Without Toppings: " + priceWithoutToppings
				+ ", Total Price: " + totalPrice + ", Pizza Order ID: " + orderID + ", Cooking Strategy: "
				+ cookingStrategy.getClass().getSimpleName() + ", Cooking Price: " + getCookingPrice() + ", Pizza Type: " + this.getClass().getSimpleName();
	}
    
}