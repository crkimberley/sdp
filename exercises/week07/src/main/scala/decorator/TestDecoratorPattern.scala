package decorator

import java.text.DecimalFormat

object TestDecoratorPattern {
  private var dformat: DecimalFormat = new DecimalFormat("#.##")

  def main(args: Array[String]) {
    var pizza: Pizza = new SimplyVegPizza
    print(pizza)
    pizza = new SimplyVegPizza with RomaTomatoes
    print(pizza)
    pizza = new SimplyVegPizza with GreenOlives
    print(pizza)
    pizza = new SimplyVegPizza with Spinach
    print(pizza)
    pizza = new SimplyNonVegPizza
    print(pizza)
    pizza = new SimplyNonVegPizza with Meat
    print(pizza)
    pizza = new SimplyNonVegPizza with Cheese
    print(pizza)
    pizza = new SimplyNonVegPizza with Ham
    print(pizza)
    pizza = new SimplyNonVegPizza with Ham with Cheese with GreenOlives
    print(pizza)

    /*
    var pizza: Pizza = new SimplyVegPizza
    pizza = new RomaTomatoes(pizza)
    print(pizza)
    pizza = new GreenOlives(pizza)
    print(pizza)
    pizza = new Spinach(pizza)
    print(pizza)
    pizza = new SimplyNonVegPizza
    print(pizza)
    pizza = new Meat(pizza)
    print(pizza)
    pizza = new Cheese(pizza)
    print(pizza)
    pizza = new Ham(pizza)
    print(pizza)
     */
  }

  private def print(pizza: Pizza) {
    System.out.println("Desc: " + pizza.getDesc)
    System.out.println("Price: " + dformat.format(pizza.getPrice))
  }
}
