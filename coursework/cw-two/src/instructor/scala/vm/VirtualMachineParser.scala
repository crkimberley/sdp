package vm

import bc.ByteCode

/**
  * A `VirtualMachineParser` is used to parse a file of bytecode
  * instructions (as defined by [[vendor.ProgramParser]]). Note,
  * we will use the vendor's parser to parse a file and use the
  * adapter design pattern to write an adapter that will
  * translate a vector of [[vendor.Instruction]] into a
  * vector [[bc.ByteCode]].
  */
trait VirtualMachineParser {
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
  def parse(file: String): Vector[ByteCode]

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
  def parseString(str: String): Vector[ByteCode]
}
