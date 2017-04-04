package decorator

trait Meat extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Meat"

  abstract override def getPrice: Double = super.getPrice + 0.99
}