module Main where

import System.Environment (getArgs)
import System.IO (hFlush, stdout)

main :: IO ()
main = do
  args <- getArgs
  case args of
    []           -> sayHello "World"
    ["-i"]       -> prompt "Input your name: " >>= sayHello
    [_]          -> printError $ Just "Unexpected argument on first place, -i expected"
    ["-n", name] -> sayHello name
    [_, _]       -> printError $ Just "Unexpected argument on first place, -n expected"
    _            -> printError $ Just "Invalid arguments."

  where
    sayHello :: String -> IO ()
    sayHello name = putStrLn $ "Hello, " ++ name ++ "!"
    
    prompt :: String -> IO String
    prompt text = do
        putStr text
        hFlush stdout
        getLine
    
    printError :: Maybe String -> IO ()
    printError (Just msg) = putStrLn msg >> printError Nothing
    printError Nothing    = putStr $
      "Use:                                                  \n" ++
      "                                                      \n" ++
      "  hello_world [...args]                               \n" ++
      "                                                      \n" ++
      "  without arguments, print \"Hello, World!\"          \n" ++
      "                                                      \n" ++
      "  -n <name> - print \"Hello, <name>!\"                \n" ++
      "  -i        - ask <name> and print \"Hello, <name>!\" \n"

