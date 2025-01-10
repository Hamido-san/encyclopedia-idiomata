(ns idiomata.range-test
  (:require [clojure.test :refer [is testing with-test]]
            [idiomata.range :as t]))

(with-test
  (testing "degen input"
    (is (thrown? Throwable (t/reindex -7 5))
        "no counting up from below zero")
    (is (thrown? Throwable (t/reindex 7 -5))
        "no counting down")
    (is (thrown? Throwable (t/reindex 7 0))
        "cannot count up 0 times!"))
  (testing "usual input"
    (is (= (t/reindex 0 5) ["0" "1" "2" "3" "4"])
        "count up from 0")
    (is (= (t/reindex 7 5) ["07" "08" "09" "10" "11"])
        "zero-padding"))
  #_(testing "unusual input"
      (is (= (t/reindex (+ 1e6M 7) 5) ["1000007" "1000008" "1000009" "1000010" "1000011"])
          "handling bigger nums")))