package sml

import scala.util.control.Exception._

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"
  private final val DIV = "div"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.nonEmpty) {
        labels.add(fields(0))
      }
      val qualifiedClassname = "sml." + fields(1).toLowerCase().capitalize + "Instruction"
      val reflectedClassConstructor = Class.forName(qualifiedClassname).getConstructors()(0)
      val args = fields.slice(0, 2) ++ parseFields(fields.slice(2, fields.length))
      program = program :+ reflectedClassConstructor.newInstance(args: _*).asInstanceOf[Instruction]
    }
    new Machine(labels, program)
  } 

  private def parseFields(fields: Array[String]) = fields.map(str => toInt(str).getOrElse(str))

  private def toInt(field: String): Option[Integer] = catching(classOf[NumberFormatException]) opt field.toInt
}

object Translator {
  def apply(file: String) = new Translator(file)
}

/*fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case x =>
            println(s"Unknown instruction $x")
        }*/