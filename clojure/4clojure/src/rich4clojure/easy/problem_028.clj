(ns rich4clojure.easy.problem-028
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Flatten a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;;
;; Write a function which flattens a sequence.

(def restricted [flatten])

(defn unnest
  "flattens a sequence"
  ([coll] (unnest () coll))
  ([acc [head & tail :as coll]]
   (cond
     (empty? coll) (reverse acc)
     (coll? head) (concat (unnest head) (unnest tail))
     :else (conj (unnest tail) head))))

(def __ unnest)

(comment)

(tests
 (__ '((1 2) 3 [4 [5 6]])) := '(1 2 3 4 5 6)
 (__ ["a" ["b"] "c"]) := '("a" "b" "c")
 (__ '((((:a))))) := '(:a))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/0c6e3c48cac7434882ca4b2c71ebfce1