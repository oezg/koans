(ns rich4clojure.medium.problem-074
  (:require [clojure.string :as string])
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Filter Perfect Squares =
;; By 4Clojure user: dbyrne
;; Difficulty: Medium
;;
;; Given a string of comma separated integers, write a
;; function which returns a new comma separated string
;; that only contains the numbers which are perfect
;; squares.

(defn perfect-square? [n]
  (zero? (rem (Math/sqrt n) 1)))

(defn filter-perfect-square [s]
  (->> (string/split s #",")
       (map #(Long/parseLong %))
       (filter perfect-square?)
       (string/join ",")))

(def __ filter-perfect-square)

(comment
  (zero? (rem 7.0 1)))

(tests
 (__ "4,5,6,7,8,9") := "4,9"
 (__ "15,16,25,36,37") := "16,25,36")

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/b90fcac09b35c74a07228dea603ddc73