(ns leiningen.new.simple-app
  (:require
    [leiningen.new.templates :as t]
    [leiningen.core.main :as main]))

(def render (t/renderer "simple_app"))

(defn simple-app
  [name]
  (let [data {:name         name
              :sanitized    (t/sanitize name)
              :root-ns      (t/sanitize-ns name)
              :root-ns-path (t/name-to-path name)}]
    (main/info (str "Creating new project via net.gered/simple-app called \"" name "\" ..."))
    (t/->files
      data
      "env/dev/resources"
      "env/dev/src"
      "env/prod/resources"
      "env/prod/src"
      ["resources/logback.xml"               (render "resources/logback.xml" data)]
      ["src/{{root-ns-path}}/core.clj"       (render "src/root_ns/core.clj" data)]
      ["test/{{root-ns-path}}/core_test.clj" (render "test/root_ns/core_test.clj" data)]
      [".gitignore"                          (render "gitignore" data)]
      ["config.edn"                          (render "config.edn" data)]
      ["project.clj"                         (render "project.clj" data)])))
