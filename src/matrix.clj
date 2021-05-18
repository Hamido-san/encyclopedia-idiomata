(ns idiomata.matrix)

;; note that (map) takes the first of each input collection, then seconds, thirds and so on... effectively acting like (interleave) without unboxing the result
(def pivot-ne->sw (partial apply map list))
(def pivot-⤢ pivot-ne->sw)

(def pivot-nw->se #(->> % reverse pivot-⤢ reverse))
(def pivot-⤡ pivot-nw->se)

(def rotate-cw #(->> % pivot-⤢ (map reverse)))
(def rotate-⟳ rotate-cw)

(def rotate-ccw #(->> % pivot-⤢ reverse))
(def rotate-⟲ rotate-ccw)
