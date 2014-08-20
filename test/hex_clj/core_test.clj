(ns hex-clj.core-test
  (:require [clojure.test :refer :all]
            [hex-clj.core :refer :all]))

(deftest test-neighbors
  (testing "Neighbors in cube coordinates"
    (let [hex [2 3 -7]]
      (is (= [3 2 -7] (cube-neighbor 0 hex)))
      (is (= [3 3 -8] (cube-neighbor 1 hex)))))
  (testing "Neighbors in axial coordinates"
    (let [hex [2 -7]]
      (is (= [3 -7] (axial-neighbor 0 hex))))))
