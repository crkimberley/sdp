package decorator

trait RomaTomatoes extends Pizza with PizzaDecorator {
  abstract override def getDesc: String = super.getDesc + " + Roma Tomatoes"

  abstract override def getPrice: Double = super.getPrice + 0.70
}