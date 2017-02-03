package annotation

import org.springframework.context.support.ClassPathXmlApplicationContext

object HelloWorldSpringWithAnnotation extends App {
  @throws(classOf[Exception])
  val factory = new ClassPathXmlApplicationContext("anno.xml")
  val mr = factory.getBean("renderer").asInstanceOf[MessageRenderer]
  mr.render
}
