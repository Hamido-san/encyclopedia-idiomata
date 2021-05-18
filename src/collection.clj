(ns idiomata.collection)

(defn rotate [n coll]
  (let [size (count coll)]
    (if (zero? size)
      coll
      (->> (cycle coll)
           (drop (- size (rem n size)))
           (take size)))))
