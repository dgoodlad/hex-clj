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

(deftest test-round
  (testing "Rounding to the nearest hex"
    (is (= [0 0 0] (round [0.1 0 -0.1])))
    (is (= [1 0 -1] (round [1 0.9 -1])))))

(deftest test-line
  (testing "Drawing a line"
    (is (= [[0 0 0] [1 -1 0] [2 -1 -1] [3 -2 -1] [4 -3 -1]]
           (line [0 0 0] [4 -3 -1])))))

(deftest test-in-range
  (testing "Hexes in range of origin"
    (is (= [[0 0 0]] (in-range 0 [0 0 0])))
    (is (= 7 (count (in-range 1 [0 0 0]))))
    (is (= [[-1 0 1] [-1 1 0] [0 -1 1]
            [0 0 0]
            [0 1 -1] [1 -1 0] [1 0 -1]]
           (in-range 1 [0 0 0])))
    (is (= 19 (count (in-range 2 [0 0 0]))))))
