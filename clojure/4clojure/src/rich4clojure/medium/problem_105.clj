(ns rich4clojure.medium.problem-105
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Identify keys and values =
;; By 4Clojure user: amalloy
;; Difficulty: Medium
;; Tags: [maps seqs]
;;
;; Given an input sequence of keywords and numbers, create
;; a map such that each key in the map is a keyword, and
;; the value is a sequence of all the numbers (if any)
;; between it and the next keyword in the sequence.

(defn identify-keys [s]
  (loop [acc {}
         [h & t] s
         vs []
         old nil]
    (let [nex (if old (assoc acc old vs) acc)]
      (cond
        (nil? h) nex
        (keyword? h) (recur nex t [] h)
        :else (recur acc t (conj vs h) old)))))

(defn keys-to-nums
  "Return a map with each keyword from the given sequence as key
   and numbers between it and the next keyword as value."
  ([s] (if (empty? s) {} (keys-to-nums {} s nil [])))
  ([acc [h & t] ky nums]
   (let [res (if ky (assoc acc ky nums) acc)]
     (cond
       (keyword? h) (recur res t h [])
       h (recur acc t ky (conj nums h))
       :else res))))

(def __ keys-to-nums)

(comment
  (identify-keys [])
  (identify-keys [:a 1])
  (assoc {} nil [])
  (identify-keys [:a 1 2 3 :b :c 4]))

(tests
 {} := (__ [])
 {:a [1]} := (__ [:a 1])
 {:a [1], :b [2]} := (__ [:a 1, :b 2])
 {:a [1 2 3], :b [], :c [4]} := (__ [:a 1 2 3 :b :c 4]))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/da9a4c4197dc581cb9635fe8358bc62d