(ns leiningen.gentags
  (:require [clojure.java.shell :as shell])
  (:require [clojure.java.io :as io]))

(defn -clj-files
  [dir]
  (map #(.getAbsolutePath %)  (filter #(.endsWith (.getName %) ".clj") (file-seq (io/file dir)))))

(defn -update-tagfile
  [file]
  (let [{out :out err :err exit :exit} (shell/sh "etags" "-a" "--regex=/[ \t\\(]*def[a-z]* \\([a-z-!]+\\)/\\1/" "--regex=/[ \t\\(]*ns \\([a-z.]+\\)/\\1/" file)]
    (if (= exit 0)
      (println "Updating tags for" file)
      (println "Cannot update tags for" file ":" err))))

(defn gentags
  "Emit a pretty-printed representation of the project map."
  [project]
  (let [clj-files (-clj-files (:source-path project))]
    ;Blow the existing TAGS file away...
    (io/delete-file (io/file "TAGS") true)
    (dorun
      (map #(-update-tagfile %) clj-files))))
