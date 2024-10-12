(ns rich4clojure.elementary.problem-036
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Let it Be =
;; By 4Clojure user: amalloy
;; Difficulty: Elementary
;; Tags: [math syntax]
;; 
;; Can you bind x, y, and z so that these are all true?
;; 
;; Note: You can't redefine `__` to solve this problem.
;; You will need to replace `__` in the `(tests ...)`
;; form.

(def __ :tests-will-fail)

(comment
  
  )

(tests
  10 := (let __ (+ x y))
  4 := (let __ (+ y z))
  1 := (let __ z))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ed751b2bcfa34398e03ea9f77a4d12b6