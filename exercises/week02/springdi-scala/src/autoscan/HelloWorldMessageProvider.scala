package autoscan

import org.springframework.stereotype.Component

@Component class HelloWorldMessageProvider extends MessageProvider {
  override def getMessage: String = {
    "Hello World! --- with Autoscan! How does that work?"
  }
}