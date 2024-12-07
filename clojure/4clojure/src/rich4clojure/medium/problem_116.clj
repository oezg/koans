(ns rich4clojure.medium.problem-116
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.math :as math]))

;; = Prime Sandwich =
;; By 4Clojure user: amcnamara
;; Difficulty: Medium
;; Tags: [math]
;;
;; A balanced prime is a prime number which is also the
;; mean of the primes directly before and after it in the
;; sequence of valid primes. Create a function which takes
;; an integer n, and returns true iff it is a balanced
;; prime.

(defn prime?
  "Return true if a (n)umber is prime."
  [n]
  (cond
    (< n 2) false
    (= n 2) true
    (even? n) false
    (some #(zero? (rem n %)) (range 3 (inc (math/sqrt n)) 2)) false
    :else true))

(defn first-prime
  "Return the first prime number after the (n)umber in the di(r)ection + or -."
  [n r]
  (first (filter prime? (map (partial r n 1) (range)))))

(defn balanced?
  "Is a (p)rime number the mean of the primes directly before and after it?"
  [p]
  (if (= p 2) false (= (* p 2) (+ (first-prime p -) (first-prime p +)))))

(defn balanced-prime?
  "Is a (n)umber prime and also the mean of the primes directly before and after it?"
  [n]
  (and (prime? n) (balanced? n)))

(def __ balanced-prime?)

(comment
  (take 16 (filter balanced-prime? (range 3 1000000 2)))
  (nth (filter balanced-prime? (range)) 77)
  (balanced-prime? 2))

(tests
 false := (__ 4)
 true := (__ 563)
 1103 := (nth (filter __ (range)) 15))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/286f071c259fb6861c10beb7411bde48