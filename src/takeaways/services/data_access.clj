(ns takeaways.services.data-access
  (:require [mount.core :as mount :refer [defstate]]
            [takeaways.services.data-access.in-memory-storage :as ims]))

(defrecord Takeaway [id title])

(defn- get-new-id [] 42)

(defstate add-takeaway :start
          (fn [title]
            (ims/add-takeaway (->Takeaway (get-new-id) title))) )
(defstate get-takeaways :start
          (fn []
            (map :title (ims/get-takeaways))))
