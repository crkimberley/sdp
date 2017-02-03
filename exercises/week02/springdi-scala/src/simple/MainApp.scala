import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

object MainApp extends App {
  val context: ApplicationContext = new ClassPathXmlApplicationContext("Beans.xml")
  val te: TextEditor = context.getBean("textEditor").asInstanceOf[TextEditor]
  te.spellCheck
}
