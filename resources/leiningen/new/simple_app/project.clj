(defproject {{name}} "0.1.0-SNAPSHOT"

  :description  "FIXME: write description"
  :url          "http://example.com/FIXME"
  :license      {:name "MIT License"
                 :url  "http://opensource.org/licenses/MIT"}

  :dependencies [[ch.qos.logback/logback-classic "1.2.7"]
                 [cprop "0.1.19"]
                 [mount "0.1.16"]
                 [nrepl "0.9.0"]
                 [org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.logging "1.2.1"]]

  :main         {{root-ns}}.core

  :repl-options {:init-ns {{root-ns}}.core}

  :profiles     {:dev     {:source-paths   ["env/dev/src"]
                           :resource-paths ["env/dev/resources"]
                           :dependencies   [[pjstadig/humane-test-output "0.11.0"]]
                           :injections     [(require 'pjstadig.humane-test-output)
                                            (pjstadig.humane-test-output/activate!)]}

                 :uberjar {:source-paths   ["env/prod/src"]
                           :resource-paths ["env/prod/resources"]
                           :omit-source    true
                           :aot            :all}}

  :aliases      {"uberjar" ["do" ["clean"] ["uberjar"]]})
