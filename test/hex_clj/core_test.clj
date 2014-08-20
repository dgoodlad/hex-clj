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

(deftest test-distance
  (testing "Distance from the origin"
    (let [origin [0 0 0]]
      (is (= 1 (distance origin (cube-neighbor 0 origin))))
      (is (= 2 (distance origin [2 0 -2])))
      (is (= 2 (distance origin [-1 2 -1])))
      (is (= 4 (distance origin [-2 4 -2])))))
  (testing "Axial coordinate distance"
    (let [origin [0 0]]
      (is (= 1 (axial-distance origin (cube-neighbor 0 origin))))
      (is (= 2 (distance origin [2 -2]))))))
