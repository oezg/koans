(ns rich4clojure.medium.problem-059
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Juxtaposition =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [higher-order-functions core-functions]
;;
;; Take a set of functions and return a new function that
;; takes a variable number of arguments and returns a
;; sequence containing the result of applying each
;; function left-to-right to the argument list.

(def restricted [juxt])

(defn juxtaposition
  "Given a variable number of functions, return a function that takes a variable
   number of arguments and returns a sequence of the results of applying each
   given function left-to-right to the arguments."
  [& fs]
  (fn [& args] (map #(apply % args) fs)))

(def __ juxtaposition)

(comment)

(tests
 [21 6 1] := ((__ + max min) 2 3 5 1 6 4)
 ["HELLO" 5] := ((__ #(.toUpperCase %) count) "hello")
 [2 6 4] := ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/a986cefdc820ca22996a1c74948785d2