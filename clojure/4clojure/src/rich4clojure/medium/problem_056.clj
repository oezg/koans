(ns rich4clojure.medium.problem-056
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Find Distinct Items =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [seqs core-functions]
;;
;; Write a function which removes the duplicates from a
;; sequence. Order of the items must be maintained.

(def restricted [distinct])


(defn deduplicate-reduce
  "Removes the duplicates from a sequence. Order of the items must be maintained."
  [coll]
  (reduce #(if (some #{%2} %1) %1 (conj %1 %2)) [] coll))


(defn deduplicate-recur
  ([coll] (deduplicate-recur #{} coll))
  ([visited [head & tail :as coll]]
   (when (seq coll)
     (if (visited head)
       (recur visited tail)
       (lazy-seq (cons head (deduplicate-recur (conj visited head) tail)))))))


(defn deduplicate-loop [coll]
  (loop [visited #{}
         distincts []
         [head & tail :as coll] coll]
    (cond
      (empty? coll) distincts
      (visited head) (recur visited distincts tail)
      :else (recur (conj visited head) (conj distincts head) tail))))


(def __ deduplicate-loop)

(comment)

(tests
 (__ [1 2 1 3 1 2 4]) := [1 2 3 4]
 (__ [:a :a :b :b :c :c]) := [:a :b :c]
 (__ '([2 4] [1 2] [1 3] [1 3])) := '([2 4] [1 2] [1 3])
 (__ (range 50)) := (range 50))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/a509841669465f47ccd96fe847387b3e