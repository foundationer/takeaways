(ns takeaways.services.data-access.in-memory-storage
  (:require [mount.core :as mount :refer [defstate]]))

(def ^:private default-takeaways (atom #{}))

(defstate add-takeaway :start
          (fn [takeaway]
            (swap! default-takeaways conj takeaway)
            nil))

(defstate get-takeaways :start (fn [] @default-takeaways))
