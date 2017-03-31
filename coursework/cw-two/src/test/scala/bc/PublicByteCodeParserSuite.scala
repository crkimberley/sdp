package bc

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicByteCodeParserSuite extends FunSuite with ByteCodeValues {
  val bcp = VirtualMachineFactory.byteCodeParser

  test("[2] byte code parser should parse a single bytecode") {
    val code = Vector(bytecode("iadd"))
    val bc = bcp.parse(code)
    assert(bc.length == 1, "did not parse one bytecode")
    assert(bc(0).code == bytecode("iadd"), "did not have the correct code")
  }

  test("[5] byte code parser should parse a sequence of bytecode") {
    val code = Vector(bytecode("iconst"), 4.toByte, bytecode("iconst"), 5.toByte, bytecode("iadd"))
    val bc = bcp.parse(code)
    assert(bc.length == 3, "did not parse four bytecodes")
    assert(bc(0).code == bytecode("iconst"))
    assert(bc(1).code == bytecode("iconst"))
    assert(bc(2).code == bytecode("iadd"))
  }
}
