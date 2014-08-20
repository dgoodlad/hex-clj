(ns hex-clj.core
  (:require [hex-clj.coords :as c]
            [clojure.math.numeric-tower :as math]))

(def cube-neighbors
  [[ 1 -1 0] [ 1 0 -1] [0  1 -1]
   [-1  1 0] [-1 0  1] [0 -1  1]])

(def axial-neighbors
  [[ 1 0] [ 1 -1] [0 -1]
   [-1 0] [-1  1] [0  1]])

(defn cube-neighbor
  "Returns the neighboring hex using cube coordinates"
  [dir [x y z :as hex]]
  (let [neighbor (cube-neighbors dir)]
    (map + neighbor hex)))

(defn axial-neighbor
  "Returns the neighboring hex using axial coordinates"
  [dir [q r :as hex]]
  (let [neighbor (axial-neighbors dir)]
    (map + neighbor hex)))

(defn distance
  [[x1 y1 z1 :as a] [x2 y2 z2 :as b]]
  (/ (reduce + (map math/abs (map - a b))) 2))

(defn axial-distance
  [a b]
  (distance (apply c/axial-to-cube a)
            (apply c/axial-to-cube b)))

(defn- sample
  [a b]
  (let [n         (distance a b)
        inv-n     (/ 1 n)
        b-minus-a (map - b a)]
    (map (fn [i] (map (fn [a b-minus-a]
                        (+ a (* b-minus-a inv-n i))) a b-minus-a))
         (range (+ 1 n)))))

(defn line
  [a b]
  (map round (sample a b)))

(defn round
  "Rounds a cube coordinate to the nearest integer hex"
  [[x y z :as hex]]
  (let [[rx ry rz :as rounded] (map math/round hex)
        [dx dy dz :as diff]    (map - rounded hex)]
    (cond
      (and (> dx dy) (> dx dz)) [(- 0 ry rz) ry rz]
      (> dy dz)                 [rx (- 0 rx rz) rz]
      :else                     [rx ry (- 0 rx ry)])))
