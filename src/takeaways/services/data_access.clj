(ns takeaways.services.data-access
  (:require [mount.core :as mount :refer [defstate]]
            [takeaways.services.data-access.in-memory-storage :as ims]))

(defstate add-takeaway :start ims/add-takeaway)
(defstate get-takeaways :start ims/get-takeaways)