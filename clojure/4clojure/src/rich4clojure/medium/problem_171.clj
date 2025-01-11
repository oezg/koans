(ns rich4clojure.medium.problem-171
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Intervals =
;; By 4Clojure user: aiba
;; Difficulty: Medium
;;
;; Write a function that takes a sequence of integers and
;; returns a sequence of "intervals". Each interval is a a
;; vector of two integers, start and end, such that all
;; integers between start and end (inclusive) are
;; contained in the input sequence.

(defn enrange
  "Given a sequence of ascendingly sorted distinct integers,
  return a sequence of ranges. Each range is a vector of two
  integers, start and end, such that all integers between start
  and end (inclusive) are contained in the input sequence."
  ([[head & tail]] (enrange [head head] tail))
  ([[start end] [head & tail :as nums]]
   (cond
     (empty? nums) (if (nil? start) () (list [start end]))
     (= head (inc end)) (recur [start head] tail)
     :else (lazy-seq (cons [start end] (enrange nums))))))

(defn intervals [nums]
  (->> nums sort distinct enrange))

(def __ intervals)

(comment
  (enrange [1 5 6 7 11])
  (enrange [10 9 8 1 2 3])
  (enrange [1 2 3 7 11])
  (enrange [1 4 5 6 9 11])
  (intervals [1 2 3 4 7 8 13 15])
  (partition 2 1  [1 2])
  (let [x (partition 2 1 [:end] '(1 2 3 5 7 8))]
    (reduce (fn [[[start end] acc] [a b]]
              (if (= b :end) 3 4)) [(first x) []] (rest x)))
  (let [x (sort (distinct [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11]))]
    (partition 2 1 x)))

(tests
 (__ [1 2 3]) := [[1 3]]
 (__ [10 9 8 1 2 3]) := [[1 3] [8 10]]
 (__ [1 1 1 1 1 1 1]) := [[1 1]]
 (__ []) := []
 (__ [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11]) :=
 [[1 4] [6 6] [9 11] [13 17] [19 19]])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/d795ad3f1a7bf7867cb9fde2b0e464fb