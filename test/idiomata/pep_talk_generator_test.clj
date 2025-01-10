(ns idiomata.pep-talk-generator-test
  (:require [clojure.test :refer [is testing with-test]]
            [idiomata.pep-talk-generator :as t]))

(with-test
  (def pep (t/pep-talk))
  (testing "sanity check"
    (is (string? pep))))