(ns rich4clojure.medium.problem-144
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Oscilrate =
;; By 4Clojure user: bloop
;; Difficulty: Medium
;; Tags: [sequences]
;;
;; Write an oscillating iterate: a function that takes an
;; initial value and a variable number of functions. It
;; should return a lazy sequence of the functions applied
;; to the value in order, restarting from the first
;; function after it hits the end.

(defn oscilrate
  "Oscillating iterate: given an initial value and a variable number of functions,
  return a lazy sequence of the results of the functions applied to the value in order."
  [value & functions]
  (->> (range)
       (map #(reverse (take % (cycle functions))))
       (map (partial apply comp))
       (map #(% value))))

(def __ oscilrate)

(comment
  (take 17 (cycle [8 9 0 7 6 5]))
  (let [[h & t] (cycle [1 4 8])])
  (let [z (list inc (partial * 2))
        u (apply comp z)] (u 6.0))
  (Math/signum 8.0)
  ((apply comp []) 5)
  (double 3)
  (take 6 (oscilrate 3.14 int double))
  ((comp double int) 3.14)

  (first (drop 1500 (oscilrate 1 #(+ 4 %) #(* 2 %) #(- % 6))))
  :rcf)

(tests
 (take 3 (__ 3.14 int double)) := [3.14 3 3.0]
 (take 6 (__ 3 #(- % 3) #(+ 5 %))) := [3 0 5 2 7 4]
 (take 12 (__ 0 inc dec inc dec inc)) := [0 1 0 1 0 1 2 1 2 1 2 3])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/91327b30de4e44c5f3b17d0c17a50e3e