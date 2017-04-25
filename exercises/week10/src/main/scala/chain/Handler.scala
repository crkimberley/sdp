package chain

trait Handler {
	def setHandler(handler: Handler)
	def process(file: File)
	def getHandlerName(): String
}
    