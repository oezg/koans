(ns rich4clojure.medium.problem-150
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.math :as math]))

;; = Palindromic Numbers =
;; By 4Clojure user: maximental
;; Difficulty: Medium
;; Tags: [seqs math]
;;
;; A palindromic number is a number that is the same when
;; written forwards or backwards (e.g., 3, 99, 14341).
;;
;;
;; Write a function which takes an integer n, as its only
;; argument, and returns an increasing lazy sequence of
;; all palindromic numbers that are not less than n.
;;
;;
;; The most simple solution will exceed the time limit!

(defn digit
  "Return the sequence of the digits of the number."
  ([n] (if (zero? n) '(0) (digit '() n)))
  ([acc n] (if (zero? n) acc (digit (cons (rem n 10) acc) (quot n 10)))))

(defn undigit
  "Return the number corresponding to the sequence of digits."
  ([digits] (undigit 0 1 (reverse digits)))
  ([acc power [head & tail]]
   (if (nil? head)
     acc
     (undigit (+ acc (* power head)) (* power 10) tail))))

(defn significant
  "Return the first half of the given sequence of digits."
  [digits]
  (take (math/ceil (/ (count digits) 2)) digits))

(defn succeeding
  "Given a palindromic sequence of digits, return the next palindromic sequence of digits."
  [digits]
  (let [head (significant digits)
        head' #((if % drop-last identity) (digit (inc (undigit head))))]
    (concat (head' (odd? (count digits))) (reverse (head' (every? #(= % 9) head))))))

(defn round-to-palindrome
  "Given a sequence of digits, return the palindrome equal in length
  that starts with the same significant digits."
  [digits]
  (let [head (significant digits)
        tail ((if (odd? (count digits)) rest identity) (reverse head))]
    (concat head tail)))

(defn palindrome
  "Return the digits of the palindromic number that is not less than n."
  [n]
  (let [palindrome (round-to-palindrome (digit n))]
    ((if (> n (undigit palindrome)) succeeding identity) palindrome)))

(defn palindromes
  "Return an increasing lazy sequence of all palindromic numbers
  that are not less than n."
  [n]
  (map undigit (iterate succeeding (palindrome n))))

(def __ palindromes)

(comment
  ((if (even? 4) reverse identity)  '(8 9 0))
  (->> 5 ((fn [h] (+ 7 h))))
  (->> 5 (#(+ 7 %)))
  (= '(1 2 3 4) '(1 2 3 4))
  (take (math/ceil (/ 7 2)) '(1 2 3 4 5 6 7))
  (undigit '(0))
  (succeeding '(1 2 3))
  (undigit (digit 3450384570))
  (undigit '(1 2 3 0 4 5))
  (seq (str 123451))
  (reverse (str 123451))
  (= (seq (str 1234567654321)) (reverse (str 1234567654321)))
  (class (* 111111111 111111111))
  (= 12345678987654321 (first (palindromes 12345678987654321)))
  :rcf)

(tests
 (take 26 (__ 0)) :=
 [0 1 2 3 4 5 6 7 8 9
  11 22 33 44 55 66 77 88 99
  101 111 121 131 141 151 161]
 (take 16 (__ 162)) :=
 [171 181 191 202
  212 222 232 242
  252 262 272 282
  292 303 313 323]
 (take 6 (__ 1234550000)) :=
 [1234554321 1234664321 1234774321
  1234884321 1234994321 1235005321]
 (first (__ (* 111111111 111111111))) :=
 (* 111111111 111111111)
 (set (take 199 (__ 0))) :=
 (set (map #(first (__ %)) (range 0 10000)))
 true :=
 (apply < (take 6666 (__ 9999999)))
 (nth (__ 0) 10101) :=
 9102019)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/a8b9c97438851e16448c3133cfbb2c29