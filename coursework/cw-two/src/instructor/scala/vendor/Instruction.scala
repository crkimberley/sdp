package vendor

/**
  * Represents an exception that could be thrown if an invalid instruction
  * format is encountered. You might consider using this when you implement
  * [[ProgramParser]].
  *
  * @param msg an exception message
  */
class InvalidInstructionFormatException(msg: String) extends Exception(msg)

/**
  * Represents an instruction from the *vendor*'s perspective. The vendor
  * views an instruction as a (`String`, `Vector[Int]`) pair. In fact, its
  * [[ProgramParser]] implementation expects it to return a
  * `Vector[Instruction]` after it parses a file containing bytecode.
  *
  * Unfortunately, this does not work out so well for our virtual machine
  * implementation. That is ok - we know how to use adapters! More on
  * that in a different file.
  *
  * @param name name of the instruction
  * @param args arguments of the instruction
  */
class Instruction(val name: String, val args: Vector[Int]) {
  override def toString: String = name + " " + args.mkString(" ")
}
