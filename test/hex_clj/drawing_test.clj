(ns hex-clj.core-test
  (:require [clojure.test :refer :all]
            [hex-clj.drawing :refer :all]))

(deftest test-hex-to-pixel
  (testing "Origin"
    (is (= [0 0] (hex-to-pixel 1 [0 0])))
    (is (= [0 0] (hex-to-pixel 10 [0 0]))))
  (testing "q"
    (is (= [17 0] (hex-to-pixel 10 [1 0])))
    (is (= [-17 0] (hex-to-pixel 10 [-1 0]))))
  (testing "r"
    (is (= [9 15] (hex-to-pixel 10 [0 1])))
    (is (= [-9 15])) (hex-to-pixel 10 [-1 1])))
