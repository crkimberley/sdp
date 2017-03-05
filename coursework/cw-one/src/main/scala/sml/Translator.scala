package sml

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
      }
      for (field <- fields) println("field: " + field)
      val qualifiedClassname = "sml." + fields(1).toLowerCase().capitalize + "Instruction"
      println("qualifiedClassname = " + qualifiedClassname)
      val reflectedClass = Class.forName(qualifiedClassname)
      println("reflectedClass = " + reflectedClass)
      val constructors = reflectedClass.getConstructors
      val constructor = constructors(0)
      println("constructor: " + constructor)
      for (parType <- constructor.getParameterTypes) println("constructor ParameterType: " + parType)
      val argFields = fields.slice(2, fields.length)
      for (field <- argFields) println("argField: " + field)
      val convertedArguments = fieldsToArgs(argFields)
      for (arg <- convertedArguments) println("convertedArguments: " + arg)
      //val allArguments: Array[Object] = fields(0) ++ convertedArguments
      //println("length of args = " + allArguments.length)
      var argArray = new Array[AnyRef](fields.length)
      argArray = fields.slice(0, 2) ++ convertedArguments
      println("argArray length = " + argArray.length)
      val instructionInstance = constructor.newInstance(argArray: _*).asInstanceOf[Instruction]
      program = program :+ instructionInstance
    }
    new Machine(labels, program)
  }

  def fieldsToArgs(fields: Array[String]): Array[AnyRef] = {
    var args = new Array[AnyRef](fields.length)
    for (i <- fields.indices) {
      val optionalInt: Option[Integer] = toIntIfNumber(fields(i))
      args(i) = if (optionalInt.isEmpty) fields(i) else optionalInt.get
    }
    args
  }

  import scala.util.control.Exception._
  def toIntIfNumber(field: String): Option[Integer] =
    catching(classOf[NumberFormatException]) opt field.toInt
}

object Translator {
  def apply(file: String) = new Translator(file)
}
