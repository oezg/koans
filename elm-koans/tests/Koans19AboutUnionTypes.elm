module Koans19AboutUnionTypes exposing (testSuite)

import Expect
import Utils.Blank exposing (..)
import Utils.Test exposing (describe, test)


type Nucleotide
    = A
    | C
    | G
    | T


type DNA
    = Base Nucleotide
    | Strand (List Nucleotide)


testSuite =
    describe "About UnionTypes"
        [ test "simple types are similar to enums in other languages" <|
            \() ->
                x____replace me____x
                    |> Expect.equal C
        , test "more complex types can be built with a 'tag' and additional data" <|
            \() ->
                Base (x____replace me____x)
                    |> Expect.equal (Base C)

        -- These are obviously different values, but they're the same type so it still compiles.
        -- Don't overthink this one!
        , test "all types in the union type are the same type" <|
            \() ->
                Strand [ A, T, C, G ]
                    |> Expect.equal (Base A)
        , test "case statements may be used to extract the data from the type" <|
            case Base A of
                Strand nucleotides ->
                    \() ->
                        [ x____replace me____x ]
                            |> Expect.equal nucleotides

                Base nucleotide ->
                    \() ->
                        x____replace me____x
                            |> Expect.equal nucleotide
        ]
