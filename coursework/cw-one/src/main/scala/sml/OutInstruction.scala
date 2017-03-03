package sml

/**
  * @author Chris Kimberley
  */
class OutInstruction(label: String, op: String, val register: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(register))
  }

  override def toString(): String = {
    super.toString + " prints contents of " + register + "\n"
  }
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}