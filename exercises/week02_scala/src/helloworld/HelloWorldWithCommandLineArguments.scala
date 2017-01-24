package helloworld

object HelloWorldWithCommandLineArguments extends App {
  if (args.length > 0) {
    args.foreach(arg => print(arg + " "))
  }
  else {
    print("Hello World!")
  }
  println()
}
