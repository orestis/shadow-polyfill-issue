(ns polyfill-issue.core
  (:require [hx.react :as hx :refer [defnc]]
            ["react-dom" :as react-dom]
            ["react-bootstrap" :as bootstrap]))


(defnc Main []
  [:div
   [:h1 "Main div"]
   [:div "Button here"
    [bootstrap/Button "button?"]]
   [:h3 "Fragment follows"]
   [:<>
    [:div "fragment content 1"]
    [:div "fragment content 2"]]])


(defn ^:dev/after-load render []
  (react-dom/render
   (hx/f [Main])
   (js/document.getElementById "main")))
