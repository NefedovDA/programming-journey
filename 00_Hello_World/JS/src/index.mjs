import assert from "assert";
import {createInterface} from "node:readline/promises";
import {argv, stdin, stdout} from "process";

const $io = createInterface({input: stdin, output: stdout})


const sayHello = (name) => $io.write(`Hello, ${name}!`)

const printError = (msg) => {
    if (msg) {
        $io.write(msg)
    }
    $io.write(
        "Use                                                   \n" +
        "                                                      \n" +
        "  hello_world [...args]                               \n" +
        "                                                      \n" +
        "  without arguments, print \"Hello, World!\"          \n" +
        "                                                      \n" +
        "  -n <name> - print \"Hello, <name>!\"                \n" +
        "  -i        - ask <name> and print \"Hello, <name>!\" \n"
    )
}

const main = async () => {
    switch (argv.length) {
        case 0:
        case 1:
            assert.fail("invalid environment")
            break
        case 2:
            sayHello("World")
            break
        case 3:
            if (argv[2] !== "-i") {
                printError("Unexpected argument on first place, -i expected.")
                break
            }
            // noinspection JSVoidFunctionReturnValueUsed
            const name = await $io.question("Input your name: ")
            sayHello(name)
            break
        case 4:
            if (argv[2] !== "-n") {
                printError("Unexpected argument on first place, -n expected.")
                break
            }
            sayHello(argv[3])
            break
        default:
            printError("Invalid count of arguments!")
    }

    $io.close()
}

await main()
