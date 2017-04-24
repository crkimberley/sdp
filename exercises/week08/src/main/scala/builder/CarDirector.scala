package builder

case class CarDirector(carBuilder: CarBuilder) {
  def build = {
    carBuilder.buildBodyStyle
    carBuilder.buildPower
    carBuilder.buildEngine
    carBuilder.buildBreaks
    carBuilder.buildSeats
    carBuilder.buildWindows
    carBuilder.buildFuelType
  }
}