(ns idiomata.range)

; #TODO: explain purpose & zero-padding feature
(defn reindex [start-at count-up]
  {:pre [(not (neg? start-at))
         (pos? count-up)]}
  (let [to (+ start-at count-up)
        f (str "%0" (count (str (dec to))) "d")]
    (->> (range start-at to)
         (map #(format f %)))))