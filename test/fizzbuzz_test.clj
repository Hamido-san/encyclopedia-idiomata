(ns idiomata.fizzbuzz-test
  (:require [clojure.test :refer [is testing with-test]]
            [idiomata.fizzbuzz :as t]))

(with-test
  (def fizzbuzz {3 "Fizz"
                 5 "Buzz"})
  (testing "fizzbuzz"
    (testing "degen input"
      (is (thrown? Throwable (t/play fizzbuzz 0))
          "fizzbuzz of 0 is error")
      (is (thrown? Throwable (t/play fizzbuzz -15))
          "fizzbuzz of negative number is error"))
    (testing "single input"
      (is (= (t/play fizzbuzz 1) 1)
          "fizzbuzz of 1 is 1")
      (is (= (t/play fizzbuzz 3) "Fizz")
          "fizzbuzz of 3 is fizz")
      (is (= (t/play fizzbuzz 5) "Buzz")
          "fizzbuzz of 5 is buzz")
      (is (= (t/play fizzbuzz 15) "FizzBuzz")
          "fizzbuzz of 15 is fizzbuzz"))
    (testing "range input"
      (is (= (t/play fizzbuzz 1 15)
             [1 2 "Fizz" 4 "Buzz" "Fizz" 7 8 "Fizz" "Buzz" 11 "Fizz" 13 14 "FizzBuzz"])
          "fizzbuzz 1 to 15"))))

(with-test
  (def raindrops {3 "Pling"
                  5 "Plang"
                  7 "Plong"})
  (testing "raindrops"
    (is (= (t/play raindrops 1 15)
           [1 2 "Pling" 4 "Plang" "Pling" "Plong" 8 "Pling" "Plang" 11 "Pling" 13 "Plong" "PlingPlang"])
        "raindrops 1 to 15")))
