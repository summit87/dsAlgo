package designPattern;

public abstract class PizzaStore {

  protected Pizza orderPizza(String pizzaType) {
    Pizza pizza = createPizza(pizzaType);
    pizza.prepare();
    pizza.baking();
    pizza.cut();
    return pizza;
  }

  abstract Pizza createPizza(String pizzaType);
}
