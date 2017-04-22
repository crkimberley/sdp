package vm
import bc.ByteCode

/**
  * @author Chris Kimberley
  */
class VirtualMachineImpl extends VirtualMachine {
  var stack = List[Int]()

  /**
    * Executes a vector of bytecodes.
    *
    * Note, that this is an "immutable" object. That is, it
    * will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = {
    var virtualMachine: VirtualMachine = this
    for (byteCode <- bc) {
      virtualMachine = byteCode.execute(virtualMachine)
    }
    virtualMachine
  }

  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) =
    (bc.tail, bc.head.execute(this))
  
  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = {
    val virtualMachine = new VirtualMachineImpl
    virtualMachine.stack = value :: stack
    virtualMachine
  }

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, virtualMachine), where i is the integer popped and virtualMachine is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("Empty stack")
    val virtualMachine = new VirtualMachineImpl
    virtualMachine.stack = stack.tail
    (stack.head, virtualMachine)
  }

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = stack.toVector
}