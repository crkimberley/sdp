package helloworld

object HelloWorldWithCommandLineArguments extends App {
  //  def main(args: Array[String]) = {
  if (args.length > 0) {
    args.foreach(arg => print(arg + " "))
  }
  else {
    print("Hello World!")
  }
  println()
  //  }
}
