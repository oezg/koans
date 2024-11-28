(ns rich4clojure.medium.problem-085
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Power Set =
;; By 4Clojure user: peteris
;; Difficulty: Medium
;; Tags: [set-theory]
;;
;; Write a function which generates the power set of a
;; given set. The power set of a set x is the set of all
;; subsets of x, including the empty set and x itself.

;; Start with the given set S.
;; Initialize the power set P with an empty set {}.
;; For each element e in S:
;; a. Create a new set by adding e to each existing set in P.
;; b. Add these new sets to P.
;; The resulting P is the power set of S.

(defn add-to-each-set
  "Add elem to each existing set in (p)ower set."
  [p elem]
  (map #(conj % elem) p))

(defn add-to-power-set
  "Add new sets to (p)ower set"
  [p elem]
  (into p (add-to-each-set p elem)))

(defn power-set
  "Generate the power set of a given (s)et."
  [s]
  (reduce add-to-power-set #{#{}} s))


(def __ power-set)

(comment
  (let [[a & b] #{3 4 6}] b)
  (power-set #{:ö :t :k :s}))

(tests
 (__ #{1 :a}) := #{#{1 :a} #{:a} #{} #{1}}
 (__ #{}) := #{#{}}
 (__ #{1 2 3}) :=
 #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}
 (count (__ (into #{} (range 10)))) := 1024)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ace16b73b8ec73ae84d8c83ceff9e568