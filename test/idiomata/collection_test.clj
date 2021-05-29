(ns idiomata.collection-test
  (:require [clojure.test :refer [is testing with-test]]
            [idiomata.collection :as t]))

(with-test
  (def a-coll [1 2 3 4 5])
  (testing "degen input"
    (is (= (t/rotate 1 '()) '())
        "empty seq will not rotate")
    (is (= (t/rotate 1 []) [])
        "empty vec will not rotate")
    (is (= (t/rotate 0 a-coll) a-coll)
        "rotate 0 steps"))
  (testing "usual input"
    (is (= (t/rotate 1 a-coll) [5 1 2 3 4])
        "rotate 1 step right")
    (is (= (t/rotate 3 a-coll) [3 4 5 1 2])
        "rotate 3 steps right")
    (is (= (t/rotate -1 a-coll) [2 3 4 5 1])
        "rotate 1 step left")
    (is (= (t/rotate -3 a-coll) [4 5 1 2 3])
        "rotate 3 steps left"))
  (testing "unusual input"
    (is (= (t/rotate 8 a-coll) [3 4 5 1 2])
        "rotate right longer than coll count")
    (is (= (t/rotate -8 a-coll) [4 5 1 2 3])
        "rotate left longer than coll count")))
