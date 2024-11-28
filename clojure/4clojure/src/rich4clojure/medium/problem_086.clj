(ns rich4clojure.medium.problem-086
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Happy numbers =
;; By 4Clojure user: daviddavis
;; Difficulty: Medium
;; Tags: [math]
;;
;; Happy numbers are positive integers that follow a
;; particular formula: take each individual digit, square
;; it, and then sum the squares to get a new number.
;; Repeat with the new number and eventually, you might
;; get to a number whose squared sum is 1. This is a happy
;; number. An unhappy number (or sad number) is one that
;; loops endlessly. Write a function that determines if a
;; number is happy or not.

(defn digits
  ([n] (if (zero? n) '(0) (digits '() n)))
  ([acc n] (if (zero? n)
             acc
             (recur (conj acc (rem n 10))
                    (quot n 10)))))

(defn happy [n]
  (->> n
       digits
       (map #(* % %))
       (reduce +)))

(defn happy?
  ([n] (happy? #{} n))
  ([acc n] (cond
             (= 1 n) true
             (acc n) false
             :else (recur (conj acc n)
                          (happy n)))))

(def __ happy?)

(comment)

(tests
 (__ 7) := true
 (__ 986543210) := true
 (__ 2) := false
 (__ 3) := false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b921948244dc0417fc716fe31cecb359