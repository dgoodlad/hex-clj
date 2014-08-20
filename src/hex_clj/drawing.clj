(ns hex-clj.drawing
  (:require [hex-clj.coords :as c]
            [clojure.math.numeric-tower :as math]))

(def sqrt3 (math/sqrt 3))

(defn hex-to-pixel
  "Returns the x,y pixel location of a hex"
  [size [q r :as hex]]
  (let [q-basis (* size sqrt3)
        r-basis (* size 3/2)]
    [(math/round (* (+ q (/ r 2)) q-basis))
     (math/round (* r r-basis))]))
