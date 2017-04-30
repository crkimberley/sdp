package alarm

import notification.{AlarmNotification, CallOwnersPhone, DefaultWarning}

abstract class Sensor(location: String, warning: AlarmNotification) {

  def isTriggered: Boolean

  def getLocation = location

  def getSensorType: String

  def getSensorCategory: String

  def alarm = warning.notification(location)

  //def getBatteryPercentage: Double
}
