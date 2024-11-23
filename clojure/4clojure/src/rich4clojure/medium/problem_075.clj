(ns rich4clojure.medium.problem-075
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Euler's Totient Function =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;;
;; Two numbers are coprime if their greatest common
;; divisor equals 1. Euler's totient function f(x) is
;; defined as the number of positive integers less than x
;; which are coprime to x. The special case f(1) equals 1.
;; Write a function which calculates Euler's totient
;; function.

(defn gcd [x y]
  (if (zero? y) x (recur y (rem x y))))

(defn euler-totient [x]
  (letfn [(coprime? [y] (= 1 (gcd x y)))]
    (if (= x 1)
      1
      (count (filter coprime? (range 1 x))))))


(def __ euler-totient)

(comment
  "If b is 0, the GCD is a.
Otherwise, replace a with b and b with the remainder of a divided by b (i.e., a mod b).
Repeat step 2 until b is 0.
The GCD is the last non-zero value of a."
  (__ 2)
  (gcd 77 6))

(tests
 (__ 1) := 1
 (__ 10) := (count '(1 3 7 9)) 4
 (__ 40) := 16
 (__ 99) := 60)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/da5e5c50f14f015708f967e20b450874