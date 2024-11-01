(ns rich4clojure.easy.problem-040
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Interpose a Seq =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;;
;; Write a function which separates the items of a
;; sequence by an arbitrary value.

(def restricted [interpose])

(defn separate-by [value coll]
  (letfn [(add [head tail acc]
            (if (empty? tail)
              (conj acc head)
              (conj acc head value)))]
    (loop [acc []
           [head & tail] coll]
      (if (nil? head)
        acc
        (recur
         (add head tail acc)
         tail)))))

(defn hv [v c]
  (conj (into [] (mapcat vector (butlast c) (repeat (dec (count c)) v))) (peek c)))

(defn sep-by [v c]
  (reduce #(conj %1 v %2)  [(first c)] (rest c)))

(def __ sep-by)

(comment
  (separate-by 0 [1 2 3])
  (conj [] 6 nil)
  (hv 0 [8 9 6 4])
  (sep-by 0 [5 6 7 8 9]))

(tests
 (__ 0 [1 2 3]) := [1 0 2 0 3]
 (apply str (__ ", " ["one" "two" "three"])) := "one, two, three"
 (__ :z [:a :b :c :d]) := [:a :z :b :z :c :z :d])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4f5ffbf020d90a968db4f99478cf358e