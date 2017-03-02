package sml

/**
  * The machine language interpreter
  */
case class Machine(labels: Labels, prog: Vector[Instruction]) {
  private final val NUMBER_OF_REGISTERS = 32

  // The program counter - start at zero
  var pc = 0

  // The registers of the SML machine
  val regs: Registers = new Registers(NUMBER_OF_REGISTERS)

  override def toString(): String = {
    prog.foldLeft("")(_ + _)
  }

  // Execute the program in prog, beginning at instruction 0.
  // Precondition: the program and its labels have been store properly.
  def execute(): Unit = {
    while (pc < prog.length) {
      val ins = prog(pc)
      pc += 1
      ins execute this
    }
  }
//  start.until(prog.length).foreach(x => prog(x) execute this)
}

object Machine {
  def main(args: Array[String]) {
    if (args.length == 0) {
      println("Machine: args should be sml code file to execute")
    } else {
      println("SML interpreter - Scala version")

      val m = Translator(args(0)).readAndTranslate(new Machine(Labels(), Vector()))

      println("Here is the program; it has " + m.prog.size + " instructions.")
      println(m)
      println("Beginning program execution.")
      m.execute()
      println("Ending program execution.")
      println("Values of registers at program termination:")
      println(m.regs + ".")
    }
  }
}
