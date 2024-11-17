(ns rich4clojure.medium.problem-060
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Sequence Reductions =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [seqs core-functions]
;;
;; Write a function which behaves like reduce, but returns
;; each intermediate value of the reduction. Your function
;; must accept either two or three arguments, and the
;; return sequence must be lazy.

(def restricted [reductions])

(defn redux
  "Return a lazy sequence of each intermediate value of the reduction."
  ([f [head & tail]] (reduce #(conj %1 (f (peek %1) %2)) [(f head)] tail))
  ([f init coll] (reduce #(conj %1 (f (peek %1) %2)) [init] coll)))

(defn redx
  ([f [head & tail]] (redx f head tail))
  ([f init coll]
   (lazy-seq
    (loop [output (list init)
           state init
           [head & tail] coll]
      (if (nil? head)
        output
        (recur (cons (f state head) output) (f state head) tail))))))

(defn map-reduce
  ([f coll] (if (empty? coll) [] (lazy-seq (map-reduce f (first coll) (rest coll)))))
  ([f init coll] (lazy-seq (map #(reduce f init (take % coll)) (range)))))


(def __ map-reduce)

(comment
  (reductions conj [2 3 4])
  (if (empty? '(1)) :ok :nok)
  (rest (range))
  (redx conj [1] [2 3 4]))

(tests
 (take 5 (__ + (range))) := [0 1 3 6 10]
 (__ conj [1] [2 3 4]) := [[1] [1 2] [1 2 3] [1 2 3 4]]
 (last (__ * 2 [3 4 5])) := (reduce * 2 [3 4 5]) 120)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4688fc26154649a2735f14264938fa3b