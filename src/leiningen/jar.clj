(ns leiningen.jar
  (:require [leiningen.compile :as compile]
            [lancet]))

(defn jar [project & args]
  (compile/compile project)
  (let [jarfile (str (:root project) "/" (:name project) ".jar")]
    ;; TODO: add manifest
    ;; TODO: add project.clj to the jar
    (lancet/jar {:jarfile jarfile}
                ;; TODO: add src/ but support slim, etc.
                (lancet/fileset {:dir *compile-path*}))
    jarfile))