package ru.nefedov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HelloWorld {
    public static void main(String[] args) {
        switch (args.length) {
            case 0 -> {
                sayHello("World");
            }
            case 1 -> {
                if (!args[0].equals("-i")) {
                    printError("Unexpected argument on first place, -i expected.");
                    return;
                }
                String name = readLine("Input your name: ");
                sayHello(name);
            }
            case 2 -> {
                if (!args[0].equals("-n")) {
                    printError("Unexpected argument on first place, -n expected.");
                    return;
                }
                sayHello(args[1]);
            }
            default -> {
                printError("Unexpected count of arguments.");
            }
        }
    }

    private static void sayHello(String name) {
        if (name == null) throw new IllegalArgumentException("arg name is null!");
        System.out.printf("Hello, %s!%n", name);
    }

    @SuppressWarnings("SameParameterValue")
    private static String readLine(String prefix) {
        if (prefix != null) {
            System.out.print(prefix);
            System.out.flush();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read input!", e);
        }
    }

    private static void printError(String message) {
        if (message != null) {
            System.out.println(message);
        }
        System.out.println(
                """
                        Use:
                          hello_world [...args]
                                        
                          without arguments, print "Hello, World!"
                                        
                          -n <name> - print "Hello, <name>!"
                          -i        - ask <name> and print "Hello, <name>!"
                        """
        );
    }
}