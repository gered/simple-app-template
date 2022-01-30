(ns {{root-ns}}.core
  (:gen-class)
  (:require
    [clojure.tools.logging :as log]
    [aero.core :refer [read-config]]
    [mount.core :as mount :refer [defstate]]
    [nrepl.server :as nrepl]))

;;
;; TODO: other app stuff goes here ...
;;

(defstate ^{:on-reload :noop} config
  :start
  (do
    (log/info "Loading config.edn")
    (read-config "config.edn")))

(defstate ^{:on-reload :noop} repl-server
  :start
  (let [{:keys [port bind]
         :or   {port 7000
                bind "127.0.0.1"}} (:nrepl config)
        server (nrepl/start-server :port port :bind bind)]
    (log/info (format "Starting nREPL server listening on %s:%d" bind port))
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
