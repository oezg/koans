(ns rich4clojure.medium.problem-131
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.set :as set]))

;; = Sum Some Set Subsets =
;; By 4Clojure user: amcnamara
;; Difficulty: Medium
;; Tags: [math]
;;
;; Given a variable number of sets of integers, create a
;; function which returns true iff all of the sets have a
;; non-empty subset with an equivalent summation.

(defn k-combinations
  "Given k and a collection, return all of its k-length subsets."
  [k [h & t :as s]]
  (cond
    (zero? k) #{#{}}
    (< (count s) k) #{}
    :else (set/union
           (k-combinations k t)
           (->> (k-combinations (dec k) t)
                (map #(conj % h))
                set))))


(defn subsets
  "Given a set, return the non-empty subsets."
  [s]
  (->> (k-combinations k s)
       (for [k (map inc (range (count s)))])
       (apply set/union)))


(defn all-have-a-subset-with-same-sum?
  "Given a variable number of sets of numbers, return true if all
   of the sets have a non-empty subset with an equivalent summation."
  [& sets]
  (->> sets
       (map subsets)
       (map #(set (map (partial apply  +) %)))
       (apply set/intersection)
       ((complement empty?))))

(def __ all-have-a-subset-with-same-sum?)

(comment
  (into #{} (for [x [1 2 3 4 5]] #{x (inc x)}))
  (apply set/intersection '(#{1 2 3 7} #{4 7} #{7 8 9}))
  (apply set/intersection (map set '((8 9 0) (7 6 5))))
  (map #(cons % '(3 4 5)) '(7 8 9))
  (seq '())
  (k-combinations 5 #{})
  (k-combinations -1 #{-1 1 999})
  (subsets #{-1 1 999})
  :rcf)

(tests
 true :=  (__ #{-1 1 99}
              #{-2 2 888}
              #{-3 3 7777})
 false := (__ #{1}
              #{2}
              #{3}
              #{4})
 true :=  (__ #{1})
 false := (__ #{1 -3 51 9}
              #{0}
              #{9 2 81 33})
 true :=  (__ #{1 3 5}
              #{9 11 4}
              #{-3 12 3}
              #{-3 4 -2 10})
 false := (__ #{-1 -2 -3 -4 -5 -6}
              #{1 2 3 4 5 6 7 8 9})
 true :=  (__ #{1 3 5 7}
              #{2 4 6 8})
 true :=  (__ #{-1 3 -5 7 -9 11 -13 15}
              #{1 -3 5 -7 9 -11 13 -15}
              #{1 -1 2 -2 4 -4 8 -8})
 true :=  (__ #{-10 9 -8 7 -6 5 -4 3 -2 1}
              #{10 -9 8 -7 6 -5 4 -3 2 -1}))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/208b537ca9e4b62751cfa7aa4fdc2461