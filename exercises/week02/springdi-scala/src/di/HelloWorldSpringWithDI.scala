package di

import java.io.FileInputStream
import java.util.Properties

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.support.{DefaultListableBeanFactory, PropertiesBeanDefinitionReader}

object HelloWorldSpringWithDI extends App {
  @throws(classOf[Exception])
  val factory: BeanFactory = getBeanFactory
  val mr: MessageRenderer = factory.getBean("renderer").asInstanceOf[MessageRenderer]
  mr.render

  @throws(classOf[Exception])
  private def getBeanFactory: BeanFactory = {
    val factory = new DefaultListableBeanFactory
    val rdr = new PropertiesBeanDefinitionReader(factory)
    val props = new Properties
    props.load(new FileInputStream("springdi-scala/src/di/beans.properties"))
    rdr.registerBeanDefinitions(props)
    factory
  }
}
