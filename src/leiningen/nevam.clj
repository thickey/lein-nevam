(ns leiningen.nevam
  (:require [clojure.java.io :as io])
  (:use [leiningen.nevam.pom2proj :only [process-pom]]))

(defn ^:no-project-needed nevam
  "Reverse engineer your maven pom.xml files."
  [project & args]
  (if-not (seq project)
    (println "project.clj file already exists") ;; TODO accept :force
    (let [dir (System/getProperty "user.dir")
          f (io/file (str dir "/pom.xml"))]
      (if (.exists f)
        (do
          (process-pom f dir)
          (println "Your new project.clj awaits"))
        (println "pom.xml file does not exist")))))
