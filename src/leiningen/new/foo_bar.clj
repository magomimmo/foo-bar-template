(ns leiningen.new.foo-bar
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "foo-bar"))

(defn foo-bar
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' foo-bar project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
