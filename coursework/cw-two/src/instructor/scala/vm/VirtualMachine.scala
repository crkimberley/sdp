package vm

import bc.ByteCode

/**
  * Represents an exception that can be thrown if a virtual machine
  * encounters an *underflow*. Because the virtual machine that we
  * are implementing is stack-based, an invalid program could try
  * to `pop` two operands from its stack of only one operand.
  *
  * You should use this in your implementation of your virtual machine!
  *
  * @param msg an exception message
  */
class MachineUnderflowException(msg: String) extends Exception(msg)

/**
  * Represents a stack-based virtual machine.
  *
  * An implementation of a virtual machine is capable of executing
  * a vector of [[bc.ByteCode]] values. This is where the command
  * pattern comes into play! That is, we defer the execution of
  * each bytecode until it is executed by the virtual machine.
  *
  * You will need to implement one of these!
  */
trait VirtualMachine {
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
  def execute(bc: Vector[ByteCode]): VirtualMachine

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
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine)

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  def push(value: Int): VirtualMachine

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  def pop(): (Int, VirtualMachine)

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  def state: Vector[Int]
}
