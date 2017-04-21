package vm
import bc.{ByteCode, ByteCodeParserImpl, ByteCodeValues, InvalidBytecodeException}
import vendor.{Instruction, ProgramParserImpl}

/**
  * @author Chris Kimberley
  */
class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {
  val programParser = new ProgramParserImpl
  val byteCodeParser = new ByteCodeParserImpl

  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a file into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program file correctly.
    *
    * @param file the file containing a program
    * @return a vector of bytecodes
    */
  override def parse(file: String): Vector[ByteCode] =
    byteCodeParser.parse(instructionsToBytes(programParser.parse(file)))


  /**
    * Returns a vector of [[bc.ByteCode]].
    *
    * This method parses a string into a vector of bytecode objects.
    * Note, this method should throw a [[bc.InvalidBytecodeException]]
    * if it fails to parse a program string correctly.
    *
    * @param str a string containing a program
    * @return a vector of bytecodes
    */
  override def parseString(str: String): Vector[ByteCode] =
    byteCodeParser.parse(instructionsToBytes(programParser.parseString(str)))

  def instructionsToBytes(instructions: Vector[Instruction]) = {
    var bytes = Vector[Byte]()
    for (instruction <- instructions) {
      if (!bytecode.contains(instruction.name)) throw new InvalidBytecodeException("Invalid byte code")
      bytes = bytes :+ bytecode(instruction.name)
      if (instruction.name == "iconst") bytes = bytes :+ instruction.args(0).toByte
    }
    bytes
  }
}