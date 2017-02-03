package decoupledwithfactory

import java.io.FileInputStream
import java.util.Properties

object MessageSupportFactory {
  private val instance: MessageSupportFactory = new MessageSupportFactory

  def getInstance: MessageSupportFactory = {
    instance
  }
}

class MessageSupportFactory private() {
  // The constructor is marked private in the class declaration

  private var props: Properties = null
  private var renderer: MessageRenderer = null
  private var provider: MessageProvider = null

  props = new Properties
  try {
    props.load(new FileInputStream(
      "di-scala/src/decoupledwithfactory/bean.properties"))

    val rendererClass: String = props.getProperty("renderer.class")
    val providerClass: String = props.getProperty("provider.class")

    renderer = Class.forName(rendererClass).newInstance
      .asInstanceOf[MessageRenderer]
    provider = Class.forName(providerClass).newInstance
      .asInstanceOf[MessageProvider]
  }
  catch {
    case ex: Exception => {
      System.err.println("Failed to create factory methods")
      ex.printStackTrace
    }
  }

  def getMessageRenderer: MessageRenderer = renderer

  def getMessageProvider: MessageProvider = provider
}
