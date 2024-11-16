(ns rich4clojure.easy.problem-173
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Intro to Destructuring 2 =
;; By 4Clojure user: hangkous
;; Difficulty: Easy
;; Tags: [Destructuring]
;;
;; Sequential destructuring allows you to bind symbols to
;; parts of sequential things (vectors, lists, seqs,
;; etc.): (let [bindings*] exprs*)
;;
;; Complete the bindings so all let-parts evaluate to 3.

(def __ :tests-will-fail)

(comment)

(tests
 3 :=
 (let [[x y] [+ (range 3)]] (apply x y))
 (let [[[x y] b] [[+ 1] 2]] (x y b))
 (let [[x y] [inc 2]] (x y)))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/3b66d5ad0242a7fbbb163a14c2df96f2