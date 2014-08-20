(ns hex-clj.core
  (:require [hex-clj.coords :as c]))

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
