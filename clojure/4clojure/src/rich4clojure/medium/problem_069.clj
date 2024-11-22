(ns rich4clojure.medium.problem-069
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Merge with a Function =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [core-functions]
;;
;; Write a function which takes a function f and a
;; variable number of maps. Your function should return a
;; map that consists of the rest of the maps conj-ed onto
;; the first. If a key occurs in more than one map, the
;; mapping(s) from the latter (left-to-right) should be
;; combined with the mapping in the result by calling (f
;; val-in-result val-in-latter)

(def restricted [merge-with])

;; (defn updater
;;   "Merge old and new maps. Apply f to values of common keys"
;;   [f old new]
;;   (into old (for [[k v] new]
;;               [k (if (contains? old k)
;;                    (f (get old k) v)
;;                    v)])))

(defn on-update
  "Apply the given function if the old map contains the key, otherwise return the new value."
  [func newval oldval]
  (if (nil? oldval)
    newval
    (func oldval newval)))

(defn how-to-update
  [f acc [k v]]
  (update acc k (partial on-update f v)))

(defn updater
  "Merge old and new maps. Apply f to values of common keys"
  [f old new]
  (reduce (partial how-to-update f) old new))

(defn conj-map [f m & ms]
  (reduce (partial updater f) m ms))

(def __ conj-map)
(def em {:a 2, :b 3, :c 4})

(comment
  (update em :e #(if (nil? %) 99 (inc %)))
  (into em {:a 123})
  (conj-map - em {:a 1})
  (conj-map - {1 10 2 20} {1 3 2 10 3 15}))

(tests
 (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}) :=
 {:a 4, :b 6, :c 20}
 (__ - {1 10, 2 20} {1 3, 2 10, 3 15}) :=
 {1 7, 2 10, 3 15}
 (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]}) :=
 {:a [3 4 5], :b [6 7], :c [8 9]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/3dde3e1ed83b73dfe2aca3a07b307a5d