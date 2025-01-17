(ns rich4clojure.medium.problem-050
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Split by Type =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;; Tags: [seqs]
;;
;; Write a function which takes a sequence consisting of
;; items with different types and splits them up into a
;; set of homogeneous sub-sequences. The internal order of
;; each sub-sequence should be maintained, but the
;; sub-sequences themselves can be returned in any order
;; (this is why 'set' is used in the test cases).

(defn split-by-type
  "Split a collection of items with different types into a
   set of its homogeneous sub-sequences.
   The internal order of each sub-sequence is maintained."
  [coll]
  (->> coll
       (group-by type)
       vals))

(def __ split-by-type)

(comment
  (sort-by type [[1 2] :a [3 4] 5 6 :b])
  (vals (group-by type [1 :a 2 :b 3 :c]))
  (group-by type [:a "foo"  "bar" :b])
  (group-by type [[1 2] :a [3 4] 5 6 :b]))


(tests
 (set (__ [1 :a 2 :b 3 :c])) := #{[1 2 3] [:a :b :c]}
 (set (__ [:a "foo"  "bar" :b])) := #{[:a :b] ["foo" "bar"]}
 (set (__ [[1 2] :a [3 4] 5 6 :b])) := #{[[1 2] [3 4]] [:a :b] [5 6]})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/56425d809382d4b9f773a2d379cc26e0