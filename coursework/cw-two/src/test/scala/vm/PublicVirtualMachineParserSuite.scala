package vm

import bc.{ByteCodeValues, InvalidBytecodeException}
import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineParserSuite extends FunSuite with ByteCodeValues {
  val vmp = VirtualMachineFactory.virtualMachineParser

  test("[8] vm parser should parse programs/p01.vm a file into bytecode") {
    val code = vmp.parse("programs/p01.vm")
    assert(code.length == 4)
    assert(code(0).code == bytecode("iconst"))
    assert(code(1).code == bytecode("iconst"))
    assert(code(2).code == bytecode("iadd"))
    assert(code(3).code == bytecode("print"))
  }

  test("[8] vm parser should parse programs/p03.vm a file into bytecode") {
    val code = vmp.parse("programs/p03.vm")
    assert(code.length == 20)
    val all = Vector("iconst", "iconst", "iswap", "iadd", "iconst", "iadd",
                     "iconst", "isub", "iconst", "imul", "iconst", "idiv",
                     "iconst", "irem", "ineg", "idec", "iinc", "idup", "print", "print")
    for (i <- code.indices) {
      assert(code(i).code == bytecode(all(i)), s"code did not match for ${all(i)}")
    }
  }

  test("[4] vm parser should detect a program with invalid bytecode") {
    intercept[InvalidBytecodeException] {
      val code = vmp.parse("programs/p04-bad-program.vm")
    }
  }
}
