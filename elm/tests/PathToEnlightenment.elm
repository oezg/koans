module PathToEnlightenment exposing (koans, suite)

import Koans01AboutExpects
import Koans02AboutLiterals
import Koans03AboutComparisonOperators
import Koans04AboutLogicalOperators
import Koans05AboutMathematicalOperators
import Koans06AboutNumberConversions
import Koans07AboutFunctions
import Koans08AboutMaybe
import Koans09AboutLists
import Koans10AboutArrays
import Koans11AboutTuples
import Koans12AboutDictionaries
import Koans13AboutResults
import Koans14AboutStrings
import Koans15AboutRegexes
import Koans16AboutTime
import Koans17AboutSets
import Koans18AboutRecords
import Koans19AboutUnionTypes
import Koans20AboutTypeVariables
import Koans21AboutPatternMatching
import Test as ElmTest
import Utils.Test as KoansTest


{-|


# Welcome, to the Elm Koans!

    If you're looking for the actual exercises, you'll want to start with

        tests/Koans01AboutExpects.elm

    If you're adding a new koan, just add it to the list below!

-}
koans : List KoansTest.Test
koans =
    [ Koans01AboutExpects.testSuite
    , Koans02AboutLiterals.testSuite
    , Koans03AboutComparisonOperators.testSuite
    , Koans04AboutLogicalOperators.testSuite
    , Koans05AboutMathematicalOperators.testSuite
    , Koans06AboutNumberConversions.testSuite
    , Koans07AboutFunctions.testSuite
    , Koans08AboutMaybe.testSuite
    , Koans09AboutLists.testSuite
    , Koans10AboutArrays.testSuite
    , Koans11AboutTuples.testSuite
    , Koans12AboutDictionaries.testSuite
    , Koans13AboutResults.testSuite
    , Koans14AboutStrings.testSuite
    , Koans15AboutRegexes.testSuite
    , Koans16AboutTime.testSuite
    , Koans17AboutSets.testSuite
    , Koans18AboutRecords.testSuite
    , Koans19AboutUnionTypes.testSuite
    , Koans20AboutTypeVariables.testSuite
    , Koans21AboutPatternMatching.testSuite
    ]


{-|

    Exposed for [elm-test](https://github.com/rtfeldman/node-test-runner)

-}
suite : ElmTest.Test
suite =
    ElmTest.describe "The Elm Koans"
        (List.map KoansTest.asCanonical koans)
