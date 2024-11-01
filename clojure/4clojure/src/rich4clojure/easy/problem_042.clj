(ns rich4clojure.easy.problem-042
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Factorial Fun =
;; By 4Clojure user: amalloy
;; Difficulty: Easy
;; Tags: [math]
;;
;; Write a function which calculates factorials.

(defn fact [n]
  (apply * (range 1 (inc n))))

(def __ fact)

(comment)

(tests
 (__ 1) := 1
 (__ 3) := 6
 (__ 5) := 120
 (__ 8) := 40320)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/850039024c0d503cce2b2e98ca1803c5