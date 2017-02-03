package dixml

import org.springframework.context.support.ClassPathXmlApplicationContext

object HelloWorldSpringWithDIXMLFile extends App {
  @throws(classOf[Exception])
  val factory = new ClassPathXmlApplicationContext("dixml.xml")
  val mr = factory.getBean("renderer").asInstanceOf[MessageRenderer]
  mr.render
}
