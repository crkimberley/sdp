package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImpl, ByteCodeParser, ByteCodeParserImpl}
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineImpl, VirtualMachineParser, VirtualMachineParserImpl}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = ByteCodeFactoryImpl

  // TODO
  def vendorParser: ProgramParser = ProgramParserImpl

  // TODO
  def byteCodeParser: ByteCodeParser = ByteCodeParserImpl

  // TODO
  def virtualMachineParser: VirtualMachineParser = VirtualMachineParserImpl

  // TODO
  def virtualMachine: VirtualMachine = new VirtualMachineImpl
}
