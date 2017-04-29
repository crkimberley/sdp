import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    SmokeSensor sensor = new SmokeSensor();
    boolean isTriggered = sensor.isTriggered();
    assertEquals(false, isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    SmokeSensor sensor = new SmokeSensor();
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    SmokeSensor sensor = new SmokeSensor();
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    SmokeSensor sensor = new SmokeSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }

}
