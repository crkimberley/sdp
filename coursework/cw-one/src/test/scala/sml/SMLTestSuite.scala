package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

import scala.util.Random

/**
  * @author Chris Kimberley
  */
class SMLTestSuite extends FunSpec with BeforeAndAfter {
  val random = Random
  val reg0 = 0
  val reg1 = 1
  val reg2 = 2


  before { }

  describe("AddInstruction") {
    it ("should return the sum of 2 integers") {

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

    it ("toString should return 'label: opcode op1 + op2 to result\\n'") {

      val int1 = random.nextInt(1000000) - 500000
      val int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val add = AddInstruction("x03", reg0, reg1, reg2)
      assert(add.toString() === s"x03: add $reg1 + $reg2 to $reg0\n")
    }
  }

  describe("SubInstruction") {
    it ("should return the difference of 2 integers") {

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

    it ("toString should return 'label: opcode op1 - op2 to result\\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val sub = SubInstruction("x03", reg0, reg1, reg2)
      assert(sub.toString() === s"x03: sub $reg1 - $reg2 to $reg0\n")
    }
  }

  describe("MulInstruction") {
    it ("should return the product of 2 integers") {

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

    it ("toString should return 'label: opcode op1 op2 to result\\n'") {

      val int1 = random.nextInt(1000000) - 500000
      val int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val mul = MulInstruction("x03", 0, 1, 2)
      assert(mul.toString() === s"x03: mul $reg1 * $reg2 to $reg0\n")
    }
  }

  describe("DivInstruction") {
    it ("should return the quotient of 2 integers") {

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

    it ("should perform integer division, eg. 5 / 2 = 2") {
      val int1 = 5
      val int2 = 2
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val div = DivInstruction("x03", reg0, reg1, reg2)
      val instructions = Vector(store1, store2, div)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(2, 5, 2))

    }

    it ("toString should return 'label: opcode op1 / op2 to result\\n'") {

      val int1 = random.nextInt(1000000) - 500000
      val int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", reg1, int1)
      val store2 = LinInstruction("x02", reg2, int2)
      val div = DivInstruction("x03", reg0, reg1, reg2)
      assert(div.toString() === s"x03: div $reg1 / $reg2 to $reg0\n")
    }
  }

  describe("OutInstruction") {
    ignore ("should print register contents to the console") {

      for (i <- 0 to 31) {
        val machine = Machine(Labels(), Vector(OutInstruction("x01", i)))
        machine.execute()
      }
    }

    it ("toString should return 'label: opcode prints contents of register\\n'") {

      val out = OutInstruction("x01", reg0)
      assert(out.toString() === s"x01: out prints contents of $reg0\n")
    }
  }




}
