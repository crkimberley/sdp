package decorator

class RomaTomatoes(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    return null
  }

  def getPrice: Double = {
    return 0
  }
}
