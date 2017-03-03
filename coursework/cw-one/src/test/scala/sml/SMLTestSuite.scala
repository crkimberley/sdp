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

    it ("toString should return 'label: opcode op1 op2 to result +\\n'") {

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

    it ("toString should return 'label: opcode op1 op2 to result +\\n'") {

      var int1 = random.nextInt(1000000) - 500000
      var int2 = random.nextInt(1000000) - 500000
      val store1 = LinInstruction("x01", 1, int1)
      val store2 = LinInstruction("x02", 2, int2)
      val sub = SubInstruction("x03", 0, 1, 2)
      println(sub.toString())
      assert(sub.toString() === "x03: sub 1 - 2 to 0\n")
    }
  }

  /*describe("MulInstruction") {
    it ("should return the product of 2 integers") {

      for (i <- 1 to 10000) {
        var Int1 = random.nextInt(1000000) - 500000
        var Int2 = random.nextInt(1000000) - 500000
        val storeInt1 = LinInstruction("A0", 0, Int1)
        val storeInt2 = LinInstruction("x01", 1, Int2)
        val mul2Ints = MulInstruction("x02", 2, 0, 1)
        val instructions = Vector(storeInt1, storeInt2, mul2Ints)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(Int1, Int2, Int1 - Int2))
      }

    }
  }*/


}
