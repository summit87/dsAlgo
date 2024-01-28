package designPattern;

public class NyPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String pizzaType) {
    if ("Cheese".equals(pizzaType)) {
      return new NyCheesePizza(pizzaType, "Tomato", "vinaigrette");
    }
    return null;
  }
}
