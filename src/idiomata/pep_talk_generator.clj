(ns idiomata.pep-talk-generator
  (:require
   [clojure.string :as str]
   [idiomata.matrix :as mat]))

(def pep [["Champ,"            "the mere idea of you"     "has serious game"           "24/7."]
          ["Fact:"             "your soul"                "rains magic"                "can I get an amen?"]
          ["Everybody says"    "your hair today"          "deserves the Nobel Prize"   "and that's a fact."]
          ["Dang…"             "everything you do"        "raises the roof"            "so treat yourself."]
          ["Check it:"         "your personal style"      "breeds miracles"            "you feel me?"]
          ["Just saying…"      "every thought you have"   "is paying off big time"     "that's just science!"]
          ["Superstar,"        "that sparkle in your eye" "shows mad skills"           "would I lie?"]
          ["Tiger,"            "your presence here"       "just shimmers"              "fo realz!"]
          ["Self,"             "what you got going on"    "has this sheen to it"       "mic drop."]
          ["You know,"         "the essence of you"       "gets the party hopping"     "you hidden gem."]
          ["News flash:"       "your life's journey"      "is the next big thing"      "snuggle bear."]
          ["Girl,"             "that saucy personality"   "roars like a lion"          "period."]
          ["Ace,"              "your DNA"                 "is a rainbow factory"       "know what I'm sayin'?"]
          ["Excuse me but"     "that brain of yours"      "is made of diamonds"        "now let's dance."]
          ["Experts agree:"    "your choice of attire"    "makes birds sing"           "high five!"]
          ["In my opinion,"    "the way you roll"         "should be taught in school" "say it again!"]
          ["Hear ye, hear ye:" "whatever your secret is"  "makes my world go'round"    "according to CNN."]
          ["Okay, listen up:"  "all of y'all"             "is 100% legit"              "so get used to it."]])

(defn pep-talk []
  (as-> pep x
    (mat/pivot-⤢ x)
    (mapv rand-nth x)
    (update x 2 #(str % \,))
    (str/join \space x)))

(pep-talk)