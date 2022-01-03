#ifdef __STDC_LIB_EXT1__
#define __STDC_WANT_LIB_EXT1__ 1
#include <stddef.h>
#endif
#include <stdio.h>
#include <string.h>
#include <assert.h>

void hw_say_hello(const char* name)
{
    if (name == NULL) { assert(0 && "arg `name` is `null`!"); }
    printf("Hello, %s!", name);
}


void hw_print_error(const char* msg)
{
    if (msg) {
        printf("%s\n", msg);
    }
    printf(
        "Use:\n"
        "  hello_world [...args]                               \n"
        "                                                      \n"
        "  without arguments, print \"Hello, World!\"          \n"
        "                                                      \n"
        "  -n <name> - print \"Hello, <name>!\"                \n"
        "  -i        - ask <name> and print \"Hello, <name>!\" \n"
    );
}


void hw_say_hello_interactive()
{
    char name[128] = {};
    printf("Input your name: ");
#ifdef __STDC_LIB_EXT1__
    scanf_s("%s", name, (rsize_t)size_of(name));
#else
    scanf("%s", name);
#endif
    hw_say_hello(name);
}


/// hello_world [...args]
///
/// without arguments, print "Hello, World!"
///
/// -n <name> - print "Hello, <name>!"
/// -i        - ask <name> and print "Hello, <name>!"
int main(int argc, char* argv[])
{
    switch (argc) {
        case 0:
            assert(0 && "Undefined OS, expect that first argument is my path");
        case 1:
            hw_say_hello("World");
            break;
        case 2:
            if (strcmp(argv[1], "-i") != 0) {
                hw_print_error("Unexpected argument on first place, -i expected.");
                break;
            }
            hw_say_hello_interactive();
            break;
        case 3:
            if (strcmp(argv[1], "-n") != 0) {
                hw_print_error("Unexpected argument on first place, -n expected.");
                break;
            }
            hw_say_hello(argv[2]);
            break;
        default:
            hw_print_error("Unexpected count of arguments.");
            break;
    }
}

