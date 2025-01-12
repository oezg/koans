(ns rich4clojure.medium.problem-177
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Balancing Brackets =
;; By 4Clojure user: daowen
;; Difficulty: Medium
;; Tags: [parsing]
;;
;; When parsing a snippet of code it's often a good idea
;; to do a sanity check to see if all the brackets match
;; up. Write a function that takes in a string and returns
;; truthy if all square [] round () and curly {} brackets
;; are properly paired and legally nested, or returns
;; falsey otherwise.

(defn brackets [[h & t :as stack] br]
  (case br
    (\( \{ \[) (cons br stack)
    (\) \} \]) (case (str h br) ("()" "[]" "{}") t (reduced [h]))
    stack))

(defn balanced? [s]
  (->> s (reduce brackets '()) empty?))

(def __ balanced?)

(comment
  (empty? (reduce #(cond
                     (#{\( \{ \[} %2) (cons %2 %1)
                     (#{\) \} \]} %2) (if (#{[\( \)] [\{ \}] [\[ \]]} [(first %1) %2]) (rest %1) (reduced [:unbalanced]))
                     :else %1) '() "367[]]"))
  :rcf)

(tests
 (__ "This string has no brackets.") := true
 (__ "class Test {
        public static void main(String[] args) {
          System.out.println(\"Hello world.\");
        }
      }") := true
 (__ "(start, end]") := false
 (__ "())") := false
 (__ "[ { ] } ") := false
 (__ "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))") := true
 (__ "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))") := false
 (__ "[") := false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/6b8d50ee0811042bdc646dc9060037e8