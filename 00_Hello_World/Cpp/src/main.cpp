#include <iostream>
#include <string>
#include <cassert>


namespace {
void SayHello(const std::string& name) {
    std::cout << "Hello, " << name << "!" << std::endl;
}


void SayHelloInteractive() {
    std::string name;
    std::cout << "Input your name: " << std::flush;
    std::cin >> name;

    SayHello(name);
}


void PrintError(const std::string& msg = "") {
    if (not msg.empty()) {
        std::cout << msg << std::endl;
    }
    std::cout << "Use:                                                  \n"
                 "  hello_world [...args]                               \n"
                 "                                                      \n"
                 "  without arguments, print \"Hello, World!\"          \n"
                 "                                                      \n"
                 "  -n <name> - print \"Hello, <name>!\"                \n"
                 "  -i        - ask <name> and print \"Hello, <name>!\" \n"
              << std::flush;
}
} // namespace _


/// hello_world [...args]
///
/// without arguments, print "Hello, World!"
///
/// -n <name> - print "Hello, <name>!"
/// -i        - ask <name> and print "Hello, <name>!"
int main(int argc, char* argv[]) {
    switch (argc) {
        case 0:
            assert(false && "");
        case 1:
            SayHello("World");
            break;
        case 2:
            if (argv[1] != std::string{"-i"}) {
                PrintError("Unexpected argument on first place, -i expected.");
                break;
            }
            SayHelloInteractive();
            break;
        case 3:
            if (argv[1] != std::string{"-n"}) {
                PrintError("Unexpected argument on first place, -n expected.");
                break;
            }
            SayHello(argv[2]);
            break;
        default:
            PrintError("Unexpected count of arguments.");
            break;
    }
    return 0;
}
