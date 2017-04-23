package bc

/**
  * @author Chris Kimberley
  */
object ByteCodeParserImpl extends ByteCodeParser {
  val byteCodeFactory = ByteCodeFactoryImpl
  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * You should use [[ByteCodeValues.bytecode]] to help translate
    * the individual `Byte`s into a correponding [[ByteCode]].
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var byteCodes = Vector[ByteCode]()
    var iconstArgumentRequired = false
    for (i <- bc.indices) {
      if (iconstArgumentRequired) {
        byteCodes = byteCodes :+ byteCodeFactory.make(bytecode("iconst"), bc(i).toInt)
        iconstArgumentRequired = false
      }
      else {
        if (bc(i) == bytecode("iconst")) iconstArgumentRequired = true
        else byteCodes = byteCodes :+ byteCodeFactory.make(bc(i))
      }
    }
    byteCodes
  }
}