(ns rich4clojure.easy.problem-120
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Sum of square of digits =
;; By 4Clojure user: danilo
;; Difficulty: Easy
;; Tags: [math]
;;
;; Write a function which takes a collection of integers
;; as an argument. Return the count of how many elements
;; are smaller than the sum of their squared component
;; digits. For example: 10 is larger than 1 squared plus 0
;; squared; whereas 15 is smaller than 1 squared plus 5
;; squared.

(defn count-smaller-than-sum-squared-digits
  "Return the count of how many elements are smaller than the sum of their squared component digits."
  [coll]
  (letfn [(sum [coll] (apply + coll))
          (squared [coll] (map #(* % %) coll))
          (digits [n] (map #(Character/digit % 10) (str n)))]
    (count (filter #(< % (sum (squared (digits %)))) coll))))

(def __ count-smaller-than-sum-squared-digits)

(comment
  (range 9)
  (count-smaller-than-sum-squared-digits (range 10)))

(tests
 8 := (__ (range 10))
 19 := (__ (range 30))
 50 := (__ (range 100))
 50 := (__ (range 1000)))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/80b83817f6c63ee546a5d05e0972a7ea