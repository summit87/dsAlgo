package designPattern;

public class MainDecoratorPattern {
	public static void main(String[] args){

		PizzaStore pizzaStore = new NyPizzaStore();
		pizzaStore.orderPizza("Cheese");

	}
}
