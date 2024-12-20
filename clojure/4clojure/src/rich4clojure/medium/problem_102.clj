(ns rich4clojure.medium.problem-102
  (:require
   [clojure.string :as string]
   [hyperfiddle.rcf :refer [tests]]))

;; = intoCamelCase =
;; By 4Clojure user: amalloy
;; Difficulty: Medium
;; Tags: [strings]
;;
;; When working with java, you often need to create an
;; object with fieldsLikeThis, but you'd rather work with
;; a hashmap that has :keys-like-this until it's time to
;; convert. Write a function which takes lower-case
;; hyphen-separated strings and converts them to
;; camel-case strings.

(defn into-camel-case
  "Convert kebap case to camel case."
  [s]
  (let [[h & t] (string/split s #"-")]
    (string/join "" (conj (map string/capitalize t) h))))

(def __ into-camel-case)

(comment)

(tests
 (__ "something") := "something"
 (__ "multi-word-key") := "multiWordKey"
 (__ "leaveMeAlone") := "leaveMeAlone")

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/14f3b466feeed4d7c0e456762c042aa6