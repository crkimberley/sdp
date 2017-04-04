package decorator

trait GreenOlives extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Green Olives"

  abstract override def getPrice: Double = super.getPrice + 0.55
}