(ns leiningen.debug
  (:require [clojure.pprint :as pprint]))

(defn debug
  "Emit a pretty-printed representation of the project map."
  [project]
  (pprint/pprint project))
