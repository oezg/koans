(ns rich4clojure.easy.problem-039
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Interleave Two Seqs =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;;
;; Write a function which takes two sequences and returns
;; the first item from each, then the second item from
;; each, then the third, etc.

(def restricted [interleave])

(defn __
  ([c1 c2] (__ [] c1 c2))
  ([acc [h1 & t1] [h2 & t2]]
   (if (or (nil? h1) (nil? h2))
     acc
     (recur (conj acc h1 h2) t1 t2))))

(comment
  (__ [4 5 6 7] [0 9 8])
  (mapcat vector [4 5 6 7] [0 9 8]))

(tests
 (__ [1 2 3] [:a :b :c]) := '(1 :a 2 :b 3 :c)
 (__ [1 2] [3 4 5 6]) := '(1 3 2 4)
 (__ [1 2 3 4] [5]) := [1 5]
 (__ [30 20] [25 15]) := [30 25 20 15])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/65d3ee0ffa567e78927bbebbb9d9cc89