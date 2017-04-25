package chain

case class ImageFileHandler(s: String) extends Handler {
  var nextHandler: Handler = _

  override def setHandler(handler: Handler): Unit = nextHandler = handler

  override def process(file: File): Unit = {
    if (file.fileType == "image")
      println(s"Process and handling image file... by $s")
    else if (nextHandler != null) {
      println(s"$s forwards request to ${nextHandler.getHandlerName()}")
      nextHandler.process(file)
    }
    else println("File not supported")
  }

  override def getHandlerName(): String = s
}
