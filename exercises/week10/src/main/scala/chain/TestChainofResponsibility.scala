package chain

object TestChainofResponsibility extends App {
		var file:File = null
		val textHandler: Handler = TextFileHandler("Text Handler");
		val docHandler: Handler = DocFileHandler("Doc Handler");
		val excelHandler: Handler = ExcelFileHandler("Excel Handler");
		val audioHandler: Handler = AudioFileHandler("Audio Handler");
		val videoHandler: Handler = VideoFileHandler("Video Handler");
		val imageHandler: Handler = ImageFileHandler("Image Handler");
		
		textHandler.setHandler(docHandler)
		docHandler.setHandler(excelHandler)
		excelHandler.setHandler(audioHandler)
		audioHandler.setHandler(videoHandler)
		videoHandler.setHandler(imageHandler)
		
		
		
		file = File("Abc.mp3", "audio", "C:");
		textHandler.process(file)
		
		println("---------------------------------")
		
		file = File("Abc.jpg", "video", "C:")
		textHandler.process(file)
		
		println("---------------------------------")
		
		file = File("Abc.doc", "doc", "C:")
		textHandler.process(file)
		
		println("---------------------------------")
		
		file = File("Abc.bat", "bat", "C:")
		textHandler.process(file)
}
