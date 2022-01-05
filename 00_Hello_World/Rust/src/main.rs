use indoc::indoc;
use std::env;
use std::io::Write;

fn say_hello(name: &str) {
    println!("Hello, {}!", name);
}

fn print_error(msg: Option<&str>) {
    if let Some(msg) = msg {
        println!("{}", msg);
    }
    print!(
        indoc! {r#"
            Use:
               hello_world [...args]

               without arguments, print "Hello, World!"

               -n <name> - print "Hello, <name>!"
               -i        - ask <name> and print "Hello, <name>!"
        "#}
    )
}

fn read_line(prefix: Option<&str>) -> String {
    if let Some(prefix) = prefix {
        print!("{}", prefix);
        std::io::stdout().flush().unwrap();
    }
    let mut input = String::new();
    std::io::stdin().read_line(&mut input).unwrap();
    input.trim().to_string()
}

fn main() {
    let args: Vec<String> = env::args().collect();
    if args.is_empty() {
        panic!("Undefined OS, expect that first argument is my path")
    }
    match args[1..] {
        [] =>
            {
                say_hello("World");
            }
        [ref key] =>
            {
                if *key != "-i" {
                    print_error(Some("Unexpected argument on first place, -i expected."));
                    return;
                }
                let name = read_line(Some("Input your name: "));
                say_hello(name.as_str());
            }
        [ref key, ref name] =>
            {
                if *key != "-n" {
                    print_error(Some("Unexpected argument on first place, -n expected."));
                    return;
                }
                say_hello(name.as_str());
            }
        _ =>
            {
                print_error(Some("Unexpected count of arguments."));
                return;
            }
    }
}
