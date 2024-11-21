(ns rich4clojure.medium.problem-067
  (:require
   [clojure.math :as math]
   [hyperfiddle.rcf :refer [tests]]))

;; = Prime Numbers =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [primes]
;;
;; Write a function which returns the first x number of
;; prime numbers.

(defn prime?
  "Return true if n is prime for n larger than 2, otherwise false."
  [n]
  (not (or (zero? (rem n 2))
           (some #(zero? (rem n %)) (range 3 (inc (math/sqrt n)) 2)))))


(defn prime
  "Return the least prime number larger than n."
  [n]
  (first (filter prime? (map #(+ % n 1) (range)))))


(defn primes
  "Return the first x number of prime numbers."
  [x]
  (take x (iterate prime 2)))

(def __ primes)

(comment
  (if (some even? (range 3 2)) :ok :nok)
  (primes 7)
  (prime 2)
  (range (inc 2)))

(tests
 (__ 2) := [2 3]
 (__ 5) := [2 3 5 7 11]
 (last (__ 100)) := 541)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/024453db620369a2d32894f7b0940462