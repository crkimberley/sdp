package decorator

trait Cheese extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Cheese"

  abstract override def getPrice: Double = super.getPrice + 0.50
}