(ns hex-clj.coords)

(defn cube-to-axial
  "convert cube coordinates to axial"
  [x y z]
  [x z])

(defn axial-to-cube
  "convert axial coordinates to cube"
  [q r]
  (let [x q
        z r
        y (- (- x) z)]
    [x y z]))

(defn cube-to-even-q-offset
  "convert cube coordinates to even-q offset"
  [x y z]
  (let [q x
        r (+ z (/ (+ x (bit-and x 1)) 2))]
    [q r]))

(defn even-q-offset-to-cube
  "convert even-q offset coordinates to cube"
  [q r]
  (let [x q
        z (- r (/ (+ q (bit-and q 1)) 2))
        y (- (- x) z)]
    [x y z]))

(defn cube-to-odd-q-offset
  "convert cube coordinates to odd-q offset"
  [x y z]
  (let [q x
        r (+ z (/ (- x (bit-and x 1)) 2))]
    [q r]))

(defn odd-q-offset-to-cube
  "convert odd-q offset coordinates to cube"
  [q r]
  (let [x q
        z (- r (/ (- q (bit-and q 1)) 2))
        y (- (- x) z)]
    [x y z]))

(defn cube-to-even-r-offset
  "convert cube coordinates to even-r offset"
  [x y z]
  (let [q (+ x (/ (+ z (bit-and z 1)) 2))
        r z]
    [q r]))

(defn even-r-offset-to-cube
  "convert even-r offset coordinates to cube"
  [q r]
  (let [x (- q (/ (+ r (bit-and r 1)) 2))
        z r
        y (- (- x) z)]
    [x y z]))

(defn cube-to-odd-r-offset
  "convert cube coordinates to odd-r offset"
  [x y z]
  (let [q (+ x (/ (- z (bit-and 1)) 2))
        r z]
    [q r]))

(defn odd-r-offset-to-cube
  "convert odd-r offset coordinates to cube"
  [q r]
  (let [x (- q (/ (- r (bit-and r 1)) 2))
        z r
        y (- (- x) z)]
    [x y z]))
