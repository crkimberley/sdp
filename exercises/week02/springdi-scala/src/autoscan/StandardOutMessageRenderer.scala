package autoscan

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("renderer")
class StandardOutMessageRenderer extends MessageRenderer {
  @Autowired private val messageProvider: MessageProvider = null

  override def render {
    if (messageProvider == null) {
      throw new RuntimeException(
        "You must set the property messageProvider of class:"
          + classOf[StandardOutMessageRenderer].getName)
    }
    println(messageProvider.getMessage)
  }
}
