package bridge

case class GearLocking(s: String) extends Product {

  override def productName: String = s

  override def produce: Unit = println("Producing Gear Locking System")
}
