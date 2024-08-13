#lang racket

(require rackunit)


;; Create a path to data/1thru10.
(define path-to-1thru10 "?")

;; Using your new path, write an expression that sums the integers in data/1thru10.
(if (path? path-to-1thru10)
  (check-eqv? (call-with-input-file path-to-1thru10 "?") 55)
  (fail "Define a path"))
