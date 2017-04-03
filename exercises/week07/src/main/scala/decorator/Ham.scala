package decorator

class Ham(val pizza: Pizza) extends Pizza {
  def getDesc: String = {
    return null
  }

  def getPrice: Double = {
    return 0
  }
}
