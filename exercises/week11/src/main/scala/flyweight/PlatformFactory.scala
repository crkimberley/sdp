package flyweight

import java.util
import java.util.HashMap
import java.util.Map

import scala.collection.mutable

object PlatformFactory {

  private var map = new scala.collection.mutable.HashMap[String, Platform]()

  map += ("SCALA" -> ScalaPlatform(), "C" -> CPlatform(),
    "JAVA" -> JavaPlatform(), "RUBY" -> RubyPlatform())

  def getPlatformInstance(platformType: String): Platform = map(platformType)
  // this method will probably need to be synchronized
}
