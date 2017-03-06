package sml

/**
  * @author Chris Kimberley
  */
class BnzInstruction(label: String, op: String, register: Int, branch: String)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    if (m.regs(register) != 0) m.pc = m.labels.labels.indexOf(branch)
  }

  override def toString(): String = {
    super.toString + s" branch to $branch if register $register is not zero\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, branch: String) =
    new BnzInstruction(label, "bnz", register, branch)
}