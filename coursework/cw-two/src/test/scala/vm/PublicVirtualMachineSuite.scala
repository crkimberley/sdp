package vm

import factory.VirtualMachineFactory
import org.scalatest.FunSuite

class PublicVirtualMachineSuite extends FunSuite {
  val vmp = VirtualMachineFactory.virtualMachineParser
  val bcp = VirtualMachineFactory.byteCodeParser
  val vm  = VirtualMachineFactory.virtualMachine

  test("[10] a virtual machine should execute a program") {
    val bc  = vmp.parse("programs/p05.vm")
    val vm2 = vm.execute(bc)
  }

  test("[2] iconst should work correctly") {
    val bc  = vmp.parseString("iconst 1")
    val (bc2, vm2) = vm.executeOne(bc)
    assert(vm2.state.head == 1)
  }

  test("[2] iadd should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niadd")
    var next = vm.executeOne(bc)
    println("next._2.state.head should be 1, actual = " + next._2.state.head)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    println("next._2.state.head should be 2, actual = " + next._2.state.head)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    println("next._2.state.head should be 3, actual = " + next._2.state.head)
    assert(next._2.state.head == 3)
  }

  test("[2] isub should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\nisub")
    var next = vm.executeOne(bc)
    println("next._2.state.head should be 1, actual = " + next._2.state.head)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    println("next._2.state.head should be 2, actual = " + next._2.state.head)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    println("next._2.state.head should be 1, actual = " + next._2.state.head)
    assert(next._2.state.head == 1)
  }

  test("[2] iswap should work correctly") {
    val bc  = vmp.parseString("iconst 1\niconst 2\niswap")
    var next = vm.executeOne(bc)
    println("next._2.state.head should be 1, actual = " + next._2.state.head)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    println("next._2.state.head should be 2, actual = " + next._2.state.head)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    println("next._2.state(0) should be 1, actual = " + next._2.state(0))
    assert(next._2.state(0) == 1)
    println("next._2.state(1) should be 2, actual = " + next._2.state(1))
    assert(next._2.state(1) == 2)
  }
}
