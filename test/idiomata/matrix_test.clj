(ns idiomata.matrix-test
  (:require [clojure.test :refer [is with-test]]
            [idiomata.matrix :as t]))

(with-test
  (def testrix [[1  2  3]
                [4  5  6]
                [7  8  9]
                [:* 0 :#]])
  (is (= (t/pivot-ne->sw testrix)
         (t/pivot-⤢ testrix)
         [[1 4 7 :*]
          [2 5 8 0]
          [3 6 9 :#]])
      "⤢ pivot")
  (is (= (t/pivot-nw->se testrix)
         (t/pivot-⤡ testrix)
         [[:# 9 6 3]
          [0  8 5 2]
          [:* 7 4 1]])
      "⤡ pivot")
  (is (= (t/rotate-cw testrix)
         (t/rotate-⟳ testrix)
         [[:* 7 4 1]
          [0  8 5 2]
          [:# 9 6 3]])
      "⟳ rotation")
  (is (= (t/rotate-ccw testrix)
         (t/rotate-⟲ testrix)
         [[3 6 9 :#]
          [2 5 8 0]
          [1 4 7 :*]])
      "⟲ rotation"))
