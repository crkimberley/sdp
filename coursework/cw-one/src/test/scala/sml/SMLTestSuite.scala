package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

import scala.util.Random

/**
  * @author Chris Kimberley
  */
class SMLTestSuite extends FunSpec with BeforeAndAfter {
  val random = Random

  before { }

  describe("AddInstruction") {
    it ("should return the sum of 2 integers") {

      for (i <- 1 to 10000) {
        var int1 = random.nextInt(1000000) - 500000
        var int2 = random.nextInt(1000000) - 500000
        val store1 = LinInstruction("x01", 1, int1)
        val store2 = LinInstruction("x02", 2, int2)
        val add = AddInstruction("x03", 0, 1, 2)
        val instructions = Vector(store1, store2, add)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(int1 + int2, int1, int2))
      }
    }

    it ("toString should return 'label: opcode op1 + op2 to result \\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val add = AddInstruction("x03", 0, 1, 2)
      assert(add.toString() === "x03: add 1 + 2 to 0\n")
    }
  }

  describe("SubInstruction") {
    it ("should return the difference of 2 integers") {

      for (i <- 1 to 10000) {
        var int1 = random.nextInt(1000000) - 500000
        var int2 = random.nextInt(1000000) - 500000
        val store1 = LinInstruction("x01", 1, int1)
        val store2 = LinInstruction("x02", 2, int2)
        val sub = SubInstruction("x03", 0, 1, 2)
        val instructions = Vector(store1, store2, sub)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(int1 - int2, int1, int2))
      }
    }

    it ("toString should return 'label: opcode op1 - op2 to result \\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val sub = SubInstruction("x03", 0, 1, 2)
      assert(sub.toString() === "x03: sub 1 - 2 to 0\n")
    }
  }

  describe("MulInstruction") {
    it ("should return the product of 2 integers") {

      for (i <- 1 to 10000) {
        var int1 = random.nextInt(1000000) - 500000
        var int2 = random.nextInt(1000000) - 500000
        val store1 = LinInstruction("x01", 1, int1)
        val store2 = LinInstruction("x02", 2, int2)
        val mul = MulInstruction("x03", 0, 1, 2)
        val instructions = Vector(store1, store2, mul)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(int1 * int2, int1, int2))
      }
    }

    it ("toString should return 'label: opcode op1 op2 to result \\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val mul = MulInstruction("x03", 0, 1, 2)
      assert(mul.toString() === "x03: mul 1 * 2 to 0\n")
    }
  }

  describe("DivInstruction") {
    it ("should return the quotient of 2 integers") {

      for (i <- 1 to 10000) {
        var int1 = random.nextInt(1000000) - 500000
        var int2 = random.nextInt(1000000) - 500000
        val store1 = LinInstruction("x01", 1, int1)
        val store2 = LinInstruction("x02", 2, int2)
        val div = DivInstruction("x03", 0, 1, 2)
        val instructions = Vector(store1, store2, div)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(int1 / int2, int1, int2))
      }
    }

    it ("should perform integer division, eg. 5 / 2 = 2") {
      var int1 = 5
      var int2 = 2
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val div = DivInstruction("x03", 0, 1, 2)
      val instructions = Vector(store1, store2, div)
      val machine = Machine(Labels(), instructions)
      machine.execute()
      assert(machine.regs.registers.slice(0, 3) ===
        Array(2, 5, 2))

    }

    it ("toString should return 'label: opcode op1 / op2 to result \\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val div = DivInstruction("x03", 0, 1, 2)
      assert(div.toString() === "x03: div 1 / 2 to 0\n")
    }
  }


}
