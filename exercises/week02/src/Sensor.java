public interface Sensor {
  boolean isTriggered();

  String getLocation();

  String getSensorType();

  double getBatteryPercentage();
}
