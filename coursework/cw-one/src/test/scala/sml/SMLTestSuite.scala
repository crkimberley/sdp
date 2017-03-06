package sml

import org.scalatest.{FlatSpec, GivenWhenThen}

import scala.util.Random

/**
  * @author Chris Kimberley
  */
class SMLTestSuite extends FlatSpec with GivenWhenThen {
  val random = Random
  val reg0 = 0
  val reg1 = 1
  val reg2 = 2

  behavior of "AddInstruction"

  it should "add the contents of 2 registers and store the result in a " +
    "register" in {

    for (i <- 1 to 10000) {
      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val add = AddInstruction("x03", reg0, reg1, reg2)
      val instructions = Vector(store1, store2, add)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(int1 + int2, int1, int2))
    }
  }

  it should "return 'label: opcode op1 + op2 to result\\n' when calling" +
    " toString" in {
    val int1 = random.nextInt(1000000) - 500000
    val int2 = random.nextInt(1000000) - 500000
    val store1 = LinInstruction("x01", reg1, int1)
    val store2 = LinInstruction("x02", reg2, int2)
    val add = AddInstruction("x03", reg0, reg1, reg2)
    assert(add.toString() === s"x03: add $reg1 + $reg2 to $reg0\n")
  }


  behavior of "SubInstruction"

  it should "subtract the contents of one register from another and store " +
    "the result in a register" in {
    for (i <- 1 to 10000) {
      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val sub = SubInstruction("x03", reg0, reg1, reg2)
      val instructions = Vector(store1, store2, sub)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(int1 - int2, int1, int2))
    }
  }

  it should "return 'label: opcode op1 - op2 to result\\n' when calling" +
    " toString" in {
    var int1 = random.nextInt(1000000) - 500000
    var int2 = random.nextInt(1000000) - 500000
    val store1 = LinInstruction("x01", reg1, int1)
    val store2 = LinInstruction("x02", reg2, int2)
    val sub = SubInstruction("x03", reg0, reg1, reg2)
    assert(sub.toString() === s"x03: sub $reg1 - $reg2 to $reg0\n")
  }

  behavior of "MulInstruction"

  it should "multiply the contents of 2 registers and store the result in " +
    "a register" in {
    for (i <- 1 to 10000) {
      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val mul = MulInstruction("x03", reg0, reg1, reg2)
      val instructions = Vector(store1, store2, mul)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(int1 * int2, int1, int2))
    }
  }

  it should "return 'label: opcode op1 op2 to result\\n' when calling " +
    "toString" in {
    val int1 = random.nextInt(1000000) - 500000
    val int2 = random.nextInt(1000000) - 500000
    val store1 = LinInstruction("x01", 1, int1)
    val store2 = LinInstruction("x02", 2, int2)
    val mul = MulInstruction("x03", 0, 1, 2)
    assert(mul.toString() === s"x03: mul $reg1 * $reg2 to $reg0\n")
  }

  behavior of "DivInstruction"

  it should "divide the contents of one register by another and store the " +
    "result in a register" in {
    for (i <- 1 to 10000) {
      val int1 = random.nextInt(1000000) - 500000
      val randomDenominator = random.nextInt(1000000) - 500000
      var int2 = if (randomDenominator != 0) randomDenominator else
        randomDenominator + 1
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val div = DivInstruction("x03", reg0, reg1, reg2)
      val instructions = Vector(store1, store2, div)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(int1 / int2, int1, int2))
    }
  }

  it should "perform Java integer division, eg. 5 / 2 = 2" in {
    val int1 = 5
    val int2 = 2
    val store1 = LinInstruction("x01", reg1, int1)
    val store2 = LinInstruction("x02", reg2, int2)
    val div = DivInstruction("x03", reg0, reg1, reg2)
    val instructions = Vector(store1, store2, div)
    val machine = Machine(Labels(), instructions)
    machine.execute()
    assert(machine.regs.registers.slice(0, 3) === Array(2, 5, 2))
  }

  it should "return 'label: opcode op1 / op2 to result\\n' when calling " +
    "toString" in {
    val int1 = random.nextInt(1000000) - 500000
    val int2 = random.nextInt(1000000) - 500000
    val store1 = LinInstruction("x01", reg1, int1)
    val store2 = LinInstruction("x02", reg2, int2)
    val div = DivInstruction("x03", reg0, reg1, reg2)
    assert(div.toString() === s"x03: div $reg1 / $reg2 to $reg0\n")
  }

  behavior of "OutInstruction"

  ignore should "print the contents of a register on the Java console" in {
    var instructions = Vector[Instruction]()
    for (i <- 0 to 31) instructions = instructions :+
      LinInstruction("x", i, i * 2)
    for (i <- 0 to 31) instructions = instructions :+ OutInstruction("x", i)
    val machine = Machine(Labels(), instructions)
    println("Printing contents of the 32 registers with 32 OutInstructions:-")
    machine.execute()
  }

  it should "return 'label: opcode prints contents of register\\n' " +
    "when calling toString" in {
    val out = OutInstruction("x01", reg0)
    assert(out.toString() === s"x01: out prints contents of $reg0\n")
  }

  behavior of "BnzInstruction"

  it should ", if the contents of a register is not zero, make a statement " +
    "with a particular label the next one to execute" in {
    Given("a register with the initial value of 10")
    val store1 = LinInstruction("x01", reg0, 10)
    val store2 = LinInstruction("x02", reg1, 1)
    When("1 is repeatedly subtracted under control of a bnz branch instruction")
    val sub = SubInstruction("x03", reg0, reg0, reg1)
    val branch = "x03"
    val bnz = BnzInstruction("x04", reg0, branch)
    Then("the final value of the register will be zero")
    val instructions = Vector(store1, store2, sub, bnz)
    val labels = Labels()
    labels.labels = Seq("x01", "x02", "x03", "x04")
    val machine = Machine(labels, instructions)
    machine.execute()
    assert(machine.regs(reg0) == 0)
  }

  it should "return 'label1: opcode branch to label2 if register" +
    " is not zero\\n'" in {
    val branch = "x03"
    val bnz = BnzInstruction("x04", reg0, branch)
    assert(bnz.toString() === s"x04: bnz branch to $branch if register " +
      s"$reg0 is not zero\n")
  }
}