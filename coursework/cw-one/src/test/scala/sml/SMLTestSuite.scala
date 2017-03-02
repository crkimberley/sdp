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
        var integer1 = random.nextInt(1000000)
        var integer2 = random.nextInt(1000000)
        val storeInteger1 = LinInstruction("A0", 0, integer1)
        val storeInteger2 = LinInstruction("A1", 1, integer2)
        val add2Integers = AddInstruction("A2", 2, 0, 1)
        val instructions = Vector(storeInteger1, storeInteger2, add2Integers)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(integer1, integer2, integer1 + integer2))
      }
    }

    it ("toString should return 'label: opcode op1 op2 to result +\\n'") {
      var integer1 = random.nextInt(1000000) - 500000
      var integer2 = random.nextInt(1000000) - 500000
      val storeInteger1 = LinInstruction("A0", 0, integer1)
      val storeInteger2 = LinInstruction("A1", 1, integer2)
      val add2Integers = AddInstruction("A2", 2, 0, 1)
      assert(add2Integers.toString() === "A2: add 0 + 1 to 2\n")
    }
  }

  describe("SubInstruction") {
    it ("should return the difference of 2 integers") {
      for (i <- 1 to 10000) {
        var integer1 = random.nextInt(1000000) - 500000
        var integer2 = random.nextInt(1000000) - 500000
        val storeInteger1 = LinInstruction("A0", 0, integer1)
        val storeInteger2 = LinInstruction("A1", 1, integer2)
        val add2Integers = SubInstruction("A2", 2, 0, 1)
        val instructions = Vector(storeInteger1, storeInteger2, add2Integers)
        val machine = Machine(Labels(), instructions)
        machine.execute()
        assert(machine.regs.registers.slice(0, 3) ===
          Array(integer1, integer2, integer1 - integer2))
      }
    }

    it ("toString should return 'label: opcode op1 op2 to result +\\n'") {
      var integer1 = random.nextInt(1000000) - 500000
      var integer2 = random.nextInt(1000000) - 500000
      val storeInteger1 = LinInstruction("A0", 0, integer1)
      val storeInteger2 = LinInstruction("A1", 1, integer2)
      val add2Integers = AddInstruction("A2", 2, 0, 1)
      assert(add2Integers.toString() === "A2: add 0 + 1 to 2\n")
    }
  }


}
