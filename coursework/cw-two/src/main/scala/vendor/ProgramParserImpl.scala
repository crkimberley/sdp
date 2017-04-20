package vendor

import scala.io.Source

/**
  * @author Chris Kimberley
  */
class ProgramParserImpl extends ProgramParser {
  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList =
    parseString(Source.fromFile(file).getLines.mkString("\n"))

  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param string the string to parse
    * @return an instruction list
    */
  override def parseString(string: String): InstructionList = {
    var instructions = Vector[Instruction]()
    val lines = string.trim.split("\n").map(_.trim)
    for (line <- lines) {
      var argument = Vector[Int]()
      val splitLine = line.split("\\s+")
      if (splitLine.length > 1) argument = argument :+ splitLine(1).toInt
      instructions = instructions :+ new Instruction(splitLine(0), argument)
    }
    instructions
  }
}