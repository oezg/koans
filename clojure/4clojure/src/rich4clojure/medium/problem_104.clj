(ns rich4clojure.medium.problem-104
  (:require
   [hyperfiddle.rcf :refer [tests]]))

;; = Write Roman Numerals =
;; By 4Clojure user: 0x89
;; Difficulty: Medium
;; Tags: [strings math]
;;
;; This is the inverse of Problem 92, but much easier.
;; Given an integer smaller than 4000, return the
;; corresponding roman numeral in uppercase, adhering to
;; the subtractive principle .

(def romans
  {0 {1 "I" 2 "II" 3 "III" 4 "IV" 5 "V" 6 "VI" 7 "VII" 8 "VIII" 9 "IX"}
   1 {1 "X" 2 "XX" 3 "XXX" 4 "XL" 5 "L" 6 "LX" 7 "LXX" 8 "LXXX" 9 "XC"}
   2 {1 "C" 2 "CC" 3 "CCC" 4 "CD" 5 "D" 6 "DC" 7 "DCC" 8 "DCCC" 9 "CM"}
   3 {1 "M" 2 "MM" 3 "MMM"}})

(defn romanize [n]
  (when (and (pos-int? n) (< n 4000))
    (->> n
         str
         reverse
         (map-indexed #((romans %1) (Character/digit %2 10)))
         reverse
         (apply str))))

(def __ romanize)

(def g {:a {:b :c} :d {:e :f}})

(comment
  (map-indexed print "12345")
  (map-indexed (fn [a b] [a b]) (reverse (str 1200)))
  (romanize 1234)
  ((g :a) :b)
  (apply str '(1 2 nil 4 5))
  :rcf)

(tests
 "I" := (__ 1)
 "XXX" := (__ 30)
 "IV" := (__ 4)
 "CXL" := (__ 140)
 "DCCCXXVII" := (__ 827)
 "MMMCMXCIX" := (__ 3999)
 "XLVIII" := (__ 48))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/99336a4cfdbb80b30d640f4b51134a42