(ns idiomata.fizzbuzz)

(defn play
  ([rules start end]
   (->> (range start (inc end))
        (map #(play rules %))))
  ([rules num]
   {:pre [(pos? num)]}
   #_(cond-> nil
       (zero? (rem num 3)) (str "Fizz")
       (zero? (rem num 5)) (str "Buzz")
       :always             (or num))
   (->> rules
        (filter #(zero? (rem num (key %))))
        (map val)
        (apply str)
        (#(if (empty? %) num %)))))