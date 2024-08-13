module Koans07AboutFunctions exposing (testSuite)

import Expect
import Utils.Blank exposing (..)
import Utils.Test exposing (describe, test)


add1 x =
    x + 1


add : number -> number -> number
add x y =
    x + y


subtract =
    \x y -> x - y


subtractFrom4 : number -> number
subtractFrom4 =
    subtract 4


subtract4 : number -> number
subtract4 x =
    subtract x 4


always5 =
    always 5


multiplyBy2 x =
    2 * x


numberBiPredicate : number -> number -> Bool
numberBiPredicate =
    (<)


testSuite =
    describe "About Functions"
        [ test "the identity function returns whatever it is passed" <|
            \() ->
                x____replace me____x
                    |> Expect.equal (identity 4)
        , test "functions are defined as 'name args = implementation'" <|
            \() ->
                add1 (x____replace me____x)
                    |> Expect.equal 5
        , test "functions may have an optional type signature" <|
            \() ->
                add 3 (x____replace me____x)
                    |> Expect.equal 5
        , test "anonymous functions are defined with '\\args -> implementation'" <|
            \() ->
                subtract 8 (x____replace me____x)
                    |> Expect.equal 5
        , test "anonymous functions may be defined inline" <|
            \() ->
                (\x y -> x - y) 8 (x____replace me____x)
                    |> Expect.equal 5
        , test "functions passed some values return curried functions" <|
            \() ->
                subtractFrom4 (x____replace me____x)
                    |> Expect.equal 1
        , test "the always function returns its first argument, no matter what the second is" <|
            \() ->
                x____replace me____x
                    |> Expect.equal (always5 4)
        , test "f <| a applies the function f to the arg a" <|
            \() ->
                x____replace me____x
                    |> Expect.equal (subtract4 <| add 1 9)
        , test "a |> f applies the function f to the arg a" <|
            \() ->
                x____replace me____x
                    |> Expect.equal (add 1 9 |> subtract4)
        , test "g << f composes function g with function f" <|
            \() ->
                x____replace me____x
                    |> Expect.equal ((multiplyBy2 << subtract4) 9)
        , test "f >> g composes function g with function f" <|
            \() ->
                x____replace me____x
                    |> Expect.equal ((subtract4 >> multiplyBy2) 9)
        , test "operators can be used as functions, too" <|
            \() ->
                x____replace me____x
                    |> Expect.equal ((+) 6 4)
        , test "they are really functions" <|
            \() ->
                x____replace me____x
                    |> Expect.equal (numberBiPredicate 4 6)
        ]
