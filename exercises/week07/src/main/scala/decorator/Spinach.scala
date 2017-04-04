package decorator

trait Spinach extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Spinach"

  abstract override def getPrice: Double = super.getPrice + 0.65
}