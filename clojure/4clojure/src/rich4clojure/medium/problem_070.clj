(ns rich4clojure.medium.problem-070
  (:require
   [clojure.string :as string]
   [hyperfiddle.rcf :refer [tests]]))

;; = Word Sorting =
;; By 4Clojure user: fotland
;; Difficulty: Medium
;; Tags: [sorting]
;;
;; Write a function that splits a sentence up into a
;; sorted list of words. Capitalization should not affect
;; sort order and punctuation should be ignored.

(defn sorted-words [s]
  (->> s
       (re-seq #"[A-Za-z]+")
       (sort-by string/lower-case)))

(def __ sorted-words)

(comment
  (sort-by string/lower-case '("abc" "Abd" "aBca"))
  (compare "1234" "1234"))

(tests
 (__  "Have a nice day.") :=
 ["a" "day" "Have" "nice"]
 (__  "Clojure is a fun language!") :=
 ["a" "Clojure" "fun" "is" "language"]
 (__  "Fools fall for foolish follies.") :=
 ["fall" "follies" "foolish" "Fools" "for"])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ede095348d09c012bb17854de2c26690