package bridge

object TestBridgePattern {
  def main(args: Array[String]) {
    val product: Product = CentralLocking("Central Locking System")
    val product2: Product = GearLocking("Gear Locking System")
    var car: Car = BigWheel(product, "BigWheel xz model")

    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = BigWheel(product2, "BigWheel xz model")
    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = Motoren(product, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
    println()

    car = Motoren(product2, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
  }
}
