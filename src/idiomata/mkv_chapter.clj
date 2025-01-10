(ns idiomata.mkv-chapter
  (:require [clojure.string :as str]))

(defn text->mkvChapter
  "read youtube video chapter list from `input` file path:
   ```
   00:00:00 Intro
   01:02:03 Baby rocks the house
   ```
   and create an `output` file with matroska (mkv) simple chapter format:
   ```ini
   CHAPTER01=00:00:00.000
   CHAPTER01NAME=Intro
   CHAPTER02=01:02:03.000
   CHAPTER02NAME=Baby rocks the house
   ```"
  [input output]
  (->> (slurp input)
       (str/split-lines)
       (map (partial re-seq #"(\d\d:\d\d:\d\d) (.*)"))
       (map-indexed (fn [i [[_ time name]]] (str "CHAPTER" i "=" time ".000\nCHAPTER" i "NAME=" name)))
       (str/join "\n")
       (spit output)))