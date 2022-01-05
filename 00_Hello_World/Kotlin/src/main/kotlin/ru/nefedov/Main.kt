package ru.nefedov

private fun sayHello(name: String) {
    println("Hello, $name!")
}

private fun printError(message: String? = null) {
    if (message != null) {
        println(message)
    }
    println(
        """
            |Use:
            |  hello_world [...args]
            |
            |  without arguments, print "Hello, World!"
            |
            |  -n <name> - print "Hello, <name>!"
            |  -i        - ask <name> and print "Hello, <name>!"
        """.trimMargin()
    )
}

fun main(args: Array<String>) {
    when (args.size) {
        0 -> {
            sayHello("World")
        }
        1 -> {
            if (args[0] != "-i") {
                printError("Unexpected argument on first place, -i expected.")
                return
            }
            print("Input your name: ")
            val name = readLine() ?: error("Cannot read input!")
            sayHello(name)
        }
        2 -> {
            if (args[0] != "-n") {
                printError("Unexpected argument on first place, -n expected.")
                return
            }
            sayHello(args[1])
        }
        else -> {
            printError("Unexpected count of arguments.")
        }
    }
}