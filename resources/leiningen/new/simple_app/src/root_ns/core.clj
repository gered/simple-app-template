(ns {{root-ns}}.core
  (:gen-class)
  (:require
    [clojure.tools.logging :as log]
    [cprop.core :refer [load-config]]
    [mount.core :as mount :refer [defstate]]
    [nrepl.server :as nrepl]))

;;
;; TODO: other app stuff goes here ...
;;

(defstate ^{:on-reload :noop} config
  :start
  (do
    (log/info "Loading config.edn")
    (load-config :file "config.edn")))

(defstate ^{:on-reload :noop} repl-server
  :start
  (let [{:keys [port bind socket]} (:nrepl config)
        server (nrepl/start-server :port port :bind bind :socket socket)]
    (log/info "Started nREPL server:" (:server-socket server))
    server)
  :stop
  (when repl-server
    (log/info "Stopping nREPL server")
    (nrepl/stop-server repl-server)))

(defn -main
  [& args]
  (log/info "{{name}} is starting up ...")
  (mount/start-with-args args)
  (log/info "Ready!"))
