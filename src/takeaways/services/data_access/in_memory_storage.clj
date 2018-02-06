(ns takeaways.services.data-access.in-memory-storage
  (:require [mount.core :as mount :refer [defstate]]))

(def ^:private default-takeaway (atom #{}))

(defstate add-takeaway :start (fn [title]
                                (swap! default-takeaway conj title)))

(defstate get-takeaways :start (fn [] @default-takeaway))
