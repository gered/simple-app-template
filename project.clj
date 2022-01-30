(defproject net.gered/lein-template.simple-app "0.2.0-SNAPSHOT"
  :description         "Simple Clojure CLI app or tool project template."
  :url                 "https://github.com/gered/simple-app-template"
  :license             {:name "MIT License"
                        :url  "http://opensource.org/licenses/MIT"}

  :eval-in-leiningen   true

  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]

  :release-tasks       [["vcs" "assert-committed"]
                        ["change" "version" "leiningen.release/bump-version" "release"]
                        ["vcs" "commit"]
                        ["vcs" "tag" "v" "--no-sign"]
                        ["deploy"]
                        ["change" "version" "leiningen.release/bump-version"]
                        ["vcs" "commit" "bump to next snapshot version for future development"]
                        ["vcs" "push"]]

  )
