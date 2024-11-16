(ns rich4clojure.medium.problem-046
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Flipping out =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [higher-order-functions]
;;
;; Write a higher-order function which flips the order of
;; the arguments of an input function.

(defn flip
  "Flips the order of the arguments of an input function."
  [f]
  #(f %2 %1))

(def __ flip)

(comment)

(tests
 3 := ((__ nth) 2 [1 2 3 4 5])
 true := ((__ >) 7 8)
 4 := ((__ quot) 2 8)
 [1 2 3] := ((__ take) [1 2 3 4 5] 3))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ab7a1d0a03feaaa8189a5ab386ad216c