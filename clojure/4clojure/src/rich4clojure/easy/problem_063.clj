(ns rich4clojure.easy.problem-063
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Group a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [core-functions]
;;
;; Given a function f and a sequence s, write a function
;; which returns a map. The keys should be the values of f
;; applied to each item in s. The value at each key should
;; be a vector of corresponding items in the order they
;; appear in s.

(def restricted [group-by])

(defn group-according-to
  [function collection]
  (letfn [(triage
            [state current]
            (letfn [(append
                      [group]
                      (vec (conj group current)))]
              (update state (function current) append)))]
    (reduce triage {} collection)))

(def __ group-according-to)

(comment
  (group-according-to even? [1 2 3 4 5 6 7])
  (conj nil 7))

(tests
 (__ #(> % 5) [1 3 6 8]) := {false [1 3], true [6 8]}
 (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) :=
 {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}
 (__ count [[1] [1 2] [3] [1 2 3] [2 3]]) :=
 {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b49b9b1171a0d8340f94893a614a43ec