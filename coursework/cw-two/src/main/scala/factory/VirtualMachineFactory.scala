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

  def byteCodeFactory: ByteCodeFactory = ByteCodeFactoryImpl

  def vendorParser: ProgramParser = ProgramParserImpl

  def byteCodeParser: ByteCodeParser = ByteCodeParserImpl

  def virtualMachineParser: VirtualMachineParser = VirtualMachineParserImpl

  def virtualMachine: VirtualMachine = new VirtualMachineImpl
}
