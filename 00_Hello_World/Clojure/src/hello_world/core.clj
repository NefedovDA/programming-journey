(ns hello-world.core)

(defn- say-hello [name]
  (println (str "Hello, " name "!")))

(defn- get-name
  ([] (read-line))
  ([prompt] (do (print prompt) (flush) (get-name))))

(defn- print-error
  ([] (print (str "Use                                                   \n"
                  "                                                      \n"
                  "  hello_world [...args]                               \n"
                  "                                                      \n"
                  "  without arguments, print \"Hello, World!\"          \n"
                  "                                                      \n"
                  "  -n <name> - print \"Hello, <name>!\"                \n"
                  "  -i        - ask <name> and print \"Hello, <name>!\" \n")))
  ([msg] (do (println msg) (print-error))))

(defn -main
  ([] (say-hello "World"))
  ([key] (if (= key "-i")
           (say-hello (get-name "Input your name: "))
           (print-error "Unexpected argument on first place, -i expected.")))
  ([key name] (if (= key "-n")
                (say-hello name)
                (print-error "Unexpected argument on first place, -n expected.")))
  ([_ _ & _] (print-error "Invalid arguments!")))
