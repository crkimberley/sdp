package bc
import vm.VirtualMachine

/**
  * @author Chris Kimberley
  */
class IsubByteCode extends ByteCode {
  /**
    * A unique byte value representing the bytecode. An implementation
    * will set this to the bytecode corresponding to the name of the
    * bytecode in [[ByteCodeValues]]
    */
  override val code: Byte = bytecode("isub")

  /**
    * Returns a new [[VirtualMachine]] after executing this bytecode operation.
    *
    * @param vm the initial virtual machine
    * @return a new virtual machine
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val (x, vm1) = vm.pop()
    val (y, vm2) = vm1.pop()
    vm2.push(x - y)
  }
}
