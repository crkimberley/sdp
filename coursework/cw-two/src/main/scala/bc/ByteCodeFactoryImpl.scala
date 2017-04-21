package bc

/**
  * @author Chris Kimberley
  */
class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {
  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method should throw an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = byte match {
    case _ if byte == bytecode("iconst") => new IconstByteCode(args(0))
    case _ if byte == bytecode("iadd") => new IaddByteCode
    case _ if byte == bytecode("isub") => new IsubByteCode
    case _ if byte == bytecode("imul") => new ImulByteCode
    case _ if byte == bytecode("idiv") => new IdivByteCode
    case _ if byte == bytecode("irem") => new IremByteCode
    case _ if byte == bytecode("ineg") => new InegByteCode
    case _ if byte == bytecode("iinc") => new IincByteCode
    case _ if byte == bytecode("idec") => new IdecByteCode
    case _ if byte == bytecode("idup") => new IdupByteCode
    case _ if byte == bytecode("iswap") => new IswapByteCode
    case _ if byte == bytecode("print") => new PrintByteCode
    case _  => throw new InvalidBytecodeException("Not a valid byte for an instruction")
  }
}
