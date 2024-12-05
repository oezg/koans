(ns rich4clojure.medium.problem-114
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Global take-while =
;; By 4Clojure user: amalloy
;; Difficulty: Medium
;; Tags: [seqs higher-order-functions]
;;
;; take-while is great for filtering sequences, but it
;; limited: you can only examine a single item of the
;; sequence at a time. What if you need to keep track of
;; some state as you go over the sequence?
;;
;;
;; Write a function which accepts an integer n, a
;; predicate p, and a sequence. It should return a lazy
;; sequence of items in the list up to, but not including,
;; the n th item that satisfies the predicate.

(defn global-take-while
  "Take until the (n)th item in the (s)equence
   that satisfies the (p)redicate."
  ([n p s] (reverse (global-take-while '() n p s)))
  ([acc n p [h & t]]
   (cond
     (nil? h) acc
     (and (= 1 n) (p h)) acc
     (p h) (recur (cons h acc) (dec n) p t)
     :else (recur (cons h acc) n p t))))

(defn take-until
  "Take until the (n)th item in the (s)equence
   that satisfies the (p)redicate."
  [n p [h & t :as s]]
  (when (seq s)
    (let [n' (if (p h) (dec n) n)]
      (when (pos? n')
        (lazy-seq (cons h (take-until n' p t)))))))

(def __ take-until)

(comment
  (cons 6 nil)
  (when-let [a (seq '(1 2 3))]
    (println a)))

(tests
 [2 3 5 7 11 13] :=
 (__ 4 #(= 2 (mod % 3))
     [2 3 5 7 11 13 17 19 23])
 ["this" "is" "a" "sentence"] :=
 (__ 3 #(some #{\i} %)
     ["this" "is" "a" "sentence" "i" "wrote"])
 ["this" "is"] :=
 (__ 1 #{"a"}
     ["this" "is" "a" "sentence" "i" "wrote"]))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/9d1067c73d424ab77b3b6f1941f3c7a9