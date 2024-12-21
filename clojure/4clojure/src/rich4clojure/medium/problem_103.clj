(ns rich4clojure.medium.problem-103
  (:require
   [clojure.set :as set]
   [hyperfiddle.rcf :refer [tests]]))

;; = Generating k-combinations =
;; By 4Clojure user: patsp
;; Difficulty: Medium
;; Tags: [seqs combinatorics]
;;
;; Given a sequence S consisting of n elements generate
;; all k-combinations of S, i. e. generate all possible
;; sets consisting of k distinct elements taken from S.
;;
;; The number of k-combinations for a sequence is equal
;; to the binomial coefficient .

(defn k-combinations [k [h & t :as s]]
  (cond
    (zero? k) #{#{}}
    (> k (count s)) #{}
    (empty? s) #{}
    :else (set/union (k-combinations k t)
                     (set (map #(conj % h) (k-combinations (dec k) t))))))

(def __ k-combinations)

(comment
  (k-combinations 2 #{3 4 5})
  (k-combinations 1 #{-1 1 999})
  (set/union #{7 8 9} #{1 2 3 7})
  (set (concat #{1 2 3} #{5 6 1 7}))
  (set/union #{1 2 3} #{5 6 1 7})
  (set/union #{7 8} nil)
  (k-combinations 2 #{6 3 1 4})
  (into #{} #{})
  #{#{}})


(tests
 (__ 1 #{4 5 6}) := #{#{4} #{5} #{6}}
 (__ 10 #{4 5 6}) := #{}
 (__ 2 #{0 1 2}) := #{#{0 1} #{0 2} #{1 2}}
 (__ 3 #{0 1 2 3 4}) := #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                          #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}
 (__ 4 #{[1 2 3] :a "abc" "efg"}) := #{#{[1 2 3] :a "abc" "efg"}}
 (__ 2 #{[1 2 3] :a "abc" "efg"}) := #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                       #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/59cc791bc18d235646673dd8b8b8b66f