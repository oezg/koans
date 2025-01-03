(ns rich4clojure.medium.problem-148
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = The Big Divide =
;; By 4Clojure user: goranjovic
;; Difficulty: Medium
;; Tags: [math]
;;
;; Write a function which calculates the sum of all
;; natural numbers under n (first argument) which are
;; evenly divisible by at least one of a and b (second and
;; third argument). Numbers a and b are guaranteed to be
;; coprimes.
;;
;;
;; Note: Some test cases have a very large n, so the most
;; obvious solution will exceed the time limit.

(defn sum-divisible
  "Return the sum of all natural numbers under n (first argument)
   which are evenly divisible by at least one of a and b (second and
   third argument). Numbers a and b are guaranteed to be coprimes."
  [n a b]
  (letfn [(multiples [x] (let [m (quot (dec n) x)] (* (bigint x) m (inc m) (/ 2))))]
    (+ (multiples a) (multiples b) (- (multiples (* a b))))))

(def __ sum-divisible)

(comment
  (sum-divisible 1000 3 5)
  (int? (* 10000 10000 10000))
  :rcf)

(tests
 0 := (__ 3 17 11)
 23 := (__ 10 3 5)
 233168 := (__ 1000 3 5)
 "2333333316666668" := (str (__ 100000000 3 5))
 "110389610389889610389610" :=
 (str (__ (* 10000 10000 10000) 7 11))
 "1277732511922987429116" :=
 (str (__ (* 10000 10000 10000) 757 809))
 "4530161696788274281" :=
 (str (__ (* 10000 10000 1000) 1597 3571)))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/03f17b792f88ed2b870a15ab1f47fa04