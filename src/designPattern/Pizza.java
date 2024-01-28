package designPattern;

public abstract class Pizza {

  protected String name;
  protected String dough;
  protected String sauce;

  protected void prepare() {
    System.out.println("Pizza Name : " + name);
    System.out.println("Dough : " + dough);
    System.out.println("Sauce : " + sauce);
  }

  protected void baking() {
    System.out.println("Baking will take some 15 minutes");
  }

  protected void cut() {
    System.out.println("Cutting will take some 10 minutes");
  }


}
