module Koans09AboutLists exposing (testSuite)

import Expect
import Utils.Blank exposing (..)
import Utils.Test exposing (describe, test)


testSuite =
    describe "About Lists"
        [ test "list literals are denoted by brackets" <|
            \() ->
                [ 1, 2, 3 ]
                    |> Expect.equal [ 1, 2, 3 ]
        , test "length gives the length of a list" <|
            \() ->
                3
                    |> Expect.equal (List.length [ 1, 2, 3 ])
        , test "isEmpty determines if a list is empty" <|
            \() ->
                True
                    |> Expect.equal (List.isEmpty [])
        , test "reverse revereses a list" <|
            \() ->
                [ 3, 2, 1 ]
                    |> Expect.equal (List.reverse [ 1, 2, 3 ])
        , test "member tests if a list includes a value" <|
            \() ->
                True
                    |> Expect.equal (List.member 2 [ 1, 2, 3 ])
        , test "head returns the first item in a list" <|
            \() ->
                Just 1
                    |> Expect.equal (List.head [ 1, 2, 3 ])
        , test "minimum returns the minimum of a list of comparables" <|
            \() ->
                Just 1
                    |> Expect.equal (List.minimum [ 1, 2, 3 ])
        , test "maximum returns the maximum of a list of comparables" <|
            \() ->
                Just 'c'
                    |> Expect.equal (List.maximum [ 'a', 'b', 'c' ])
        , test "take returns the first n items in a list" <|
            \() ->
                [ 1, 2 ]
                    |> Expect.equal (List.take 2 [ 1, 2, 3 ])
        , test "drop returns the list without the first n items" <|
            \() ->
                [ 3 ]
                    |> Expect.equal (List.drop 2 [ 1, 2, 3 ])
        , test "filter returns the elements that return true for a predicate function" <|
            \() ->
                [ 2, 4 ]
                    |> Expect.equal (List.filter (\x -> modBy 2 x == 0) [ 1, 2, 3, 4 ])
        , test "all tests whether all elements of a list return true for a predicate function" <|
            \() ->
                True
                    |> Expect.equal (List.all (\x -> modBy 2 x == 0) [ 2, 4 ])
        , test "any tests whether any elements of a list return true for a predicate function" <|
            \() ->
                True
                    |> Expect.equal (List.any (\x -> modBy 2 x == 0) [ 1, 2, 3 ])
        , test "repeat returns a list with n copies of a value" <|
            \() ->
                [ 1, 1, 1, 1 ]
                    |> Expect.equal (List.repeat 4 1)
        , test "sum returns the sum of a list of numbers" <|
            \() ->
                6
                    |> Expect.equal (List.sum [ 1, 2, 3 ])
        , test "product returns the product of a list of numbers" <|
            \() ->
                6
                    |> Expect.equal (List.product [ 1, 2, 3 ])
        , test "sort sorts a list of comparables" <|
            \() ->
                [ 'a', 'b', 'c' ]
                    |> Expect.equal (List.sort [ 'c', 'a', 'b' ])
        , test "sortBy sorts using a function that returns a comparable" <|
            \() ->
                [ 6, 10, 8 ]
                    |> Expect.equal (List.sortBy (\x -> modBy 3 x) [ 10, 6, 8 ])
        , test ":: is the cons operator" <|
            \() ->
                [ 1, 2, 3 ]
                    |> Expect.equal (1 :: [ 2, 3 ])
        , test "append puts 2 lists together" <|
            \() ->
                [ 1, 2, 3, 4 ]
                    |> Expect.equal (List.append [ 1, 2 ] [ 3, 4 ])
        , test "for appending you may use the append operator (++)" <|
            \() ->
                [ 1, 2, 3, 4 ]
                    |> Expect.equal ([ 1, 2 ] ++ [ 3, 4 ])
        , test "concat appends the elements in a list of lists" <|
            \() ->
                [ 1, 2, 3, 4 ]
                    |> Expect.equal (List.concat [ [ 1, 2 ], [ 3, 4 ] ])
        , test "intersperse puts a value between all elements of a list" <|
            \() ->
                [ 2, 1, 3, 1, 4 ]
                    |> Expect.equal (List.intersperse 1 [ 2, 3, 4 ])
        , test "map applies a function to every element of a list" <|
            \() ->
                [ 2, 4, 6 ]
                    |> Expect.equal (List.map (\x -> 2 * x) [ 1, 2, 3 ])
        , test "map2 applies a function to elements from 2 lists" <|
            -- corresponding functions exist up to map6
            \() ->
                [ 4, 10, 18 ]
                    |> Expect.equal (List.map2 (\x y -> x * y) [ 1, 2, 3 ] [ 4, 5, 6 ])
        , test "indexedMap applies a function to the index of an element and that element" <|
            \() ->
                [ 1, 1, 1 ]
                    |> Expect.equal (List.indexedMap (\x y -> y - x) [ 1, 2, 3 ])
        , test "foldl reduces a list from the left" <|
            \() ->
                "dcba"
                    |> Expect.equal (List.foldl (\x y -> x ++ y) "a" [ "b", "c", "d" ])
        , test "foldr reduces a list from the right" <|
            \() ->
                "bcda"
                    |> Expect.equal (List.foldr (\x y -> x ++ y) "a" [ "b", "c", "d" ])
        ]
