package ru.nefedov

import scala.io.StdIn.readLine

private def sayHello(name: String): Unit = {
  println(s"Hello, $name!")
}

private def printError(message: String | Null = null): Unit = {
  if (message != null) {
    println(message)
  }
  println(
    """
      |Use:
      |
      |  hello_world [...args]
      |
      |  without arguments, print "Hello, World!"
      |
      |  -n <name> - print "Hello, <name>!"
      |  -i        - ask <name> and print "Hello, <name>!"
    """.stripMargin
  )
}

@main def main(args: String*): Unit = {
  val name: String = args.size match {
    case 0 =>
      "World"
    case 1 =>
      if (args(0) != "-i") {
        printError("Unexpected argument on first place, -i expected.")
        return
      }
      print("Input your name: ")
      readLine()
    case 2 =>
      if (args(0) != "-n") {
        printError("Unexpected argument on first place, -i expected.")
        return
      }
      args(1)
    case _ =>
      printError("Unexpected count of arguments.")
      return
  }
  sayHello(name)
}
