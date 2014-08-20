(ns hex-clj.coords-test
  (:require [clojure.test :refer :all]
            [hex-clj.coords :refer :all]))

(deftest test-cube-axial-conversions
  (testing "Conversion axial to cube coordinates"
    (is (= [0 0 0] (axial-to-cube 0 0)))
    (is (= [1 -2 1] (axial-to-cube 1 1)))
    (is (= [-1 1 0] (axial-to-cube -1 0))))
  (testing "Converting cube to axial coordinates"
    (is (= [0 0] (cube-to-axial 0 0 0)))
    (is (= [1 -1] (cube-to-axial 1 0 -1)))))

(deftest test-even-q-offset-conversions
  (testing "Converting cube to even-q offset"
    (is (= [0 0] (cube-to-even-q-offset 0 0 0)))
    (is (= [2 1] (cube-to-even-q-offset 2 -2 0)))
    (is (= [1 2] (cube-to-even-q-offset 1 -2 1)))))
