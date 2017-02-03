package annotation

import org.springframework.beans.factory.annotation.Autowired

class StandardOutMessageRenderer extends MessageRenderer {
  @Autowired private val messageProvider: MessageProvider = null

  override def render {
    if (messageProvider == null) {
      throw new RuntimeException("You must set the property messageProvider of class:" + classOf[StandardOutMessageRenderer].getName)
    }
    println(messageProvider.getMessage)
  }
}