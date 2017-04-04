package decorator

trait Ham extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Ham"

  abstract override def getPrice: Double = super.getPrice + 0.75
}