(ns rich4clojure.medium.problem-078
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Reimplement Trampoline =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [core-functions]
;;
;; Reimplement the function described in "Intro to
;; Trampoline" .
;; The trampoline function takes a function f and a
;; variable number of parameters. Trampoline calls f with
;; any parameters that were supplied. If f returns a
;; function, trampoline calls that function with no
;; arguments. This is repeated, until the return value is
;; not a function, and then trampoline returns that
;; non-function value. This is useful for implementing
;; mutually recursive algorithms in a way that won't
;; consume the stack.

(def restricted [trampoline])

(defn reimplement-trampoline [f & args]
  (let [result (apply f args)]
    (if (fn? result)
      (recur result nil)
      result)))

(defn my-trampoline [f & args]
  (try
    (my-trampoline (apply f args))
    (catch ClassCastException _
      (apply f args))))

(def __ my-trampoline)

(comment
  (apply dec nil))

(tests
 (letfn [(triple [x] #(sub-two (* 3 x)))
         (sub-two [x] #(stop? (- x 2)))
         (stop? [x] (if (> x 50) x #(triple x)))]
   (__ triple 2)) :=
 82
 (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
         (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
   (map (partial __ my-even?) (range 6))) :=
 [true false true false true false])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/1849f2788191d83171adfe7d10b9294e