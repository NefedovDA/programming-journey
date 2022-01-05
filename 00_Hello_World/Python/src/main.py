import sys


def say_hello(name):
    print(f"Hello, {name}!")


def print_error(msg):
    if msg is not None:
        print(msg)

    print(
        'Use:                                                \n'
        '  hello_world [...args]                             \n'
        '                                                    \n'
        '  without arguments, print "Hello, World!"          \n'
        '                                                    \n'
        '  -n <name> - print "Hello, <name>!"                \n'
        '  -i        - ask <name> and print "Hello, <name>!" \n'
    )


def main():
    argv = sys.argv
    argc = len(argv)
    if argc == 0:
        assert False, "Invalid environment"
    elif argc == 1:
        say_hello("World")
    elif argc == 2:
        if argv[1] != "-i":
            print_error("Unexpected argument on first place, -i expected.")
        else:
            name = input("Input your name: ")
            say_hello(name)
    elif argc == 3:
        if argv[1] != "-n":
            print_error("Unexpected argument on first place, -n expected.")
        else:
            say_hello(argv[2])
    else:
        print_error("Incorrect count of arguments")


if __name__ == '__main__':
    main()
