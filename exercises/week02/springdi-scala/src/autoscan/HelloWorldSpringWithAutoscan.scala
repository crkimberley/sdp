package autoscan

import org.springframework.context.support.ClassPathXmlApplicationContext

object HelloWorldSpringWithAutoscan extends App {
  @throws(classOf[Exception])
  val factory = new ClassPathXmlApplicationContext("autoscan.xml")
  val mr = factory.getBean("renderer").asInstanceOf[MessageRenderer]
  mr.render
}
