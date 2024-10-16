(ns rich4clojure.easy.problem-022
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Count a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which returns the total number of
;; elements in a sequence.

(def restricted [count])

(defn number-of-elements
  "returns the total number of elements in a sequence"
  ([coll] (number-of-elements 0 coll))
  ([count coll]
   (if (seq coll)
     (recur (inc count) (rest coll))
     count)))

(def __ number-of-elements)

(comment)

(tests
 (__ '(1 2 3 3 1)) := 5
 (__ "Hello World") := 11
 (__ [[1 2] [3 4] [5 6]]) := 3
 (__ '(13)) := 1
 (__ '(:a :b :c)) := 3)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/d55eddc37d7a08a3440748ddb75c7ec4