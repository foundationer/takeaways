(ns takeaways.services.test-data-access
  (:require [clojure.test :refer :all]
            [takeaways.services.data-access :refer :all]
            [mount.core :as mount]))

(use-fixtures :once (fn [test-fn]
                      (mount/start)
                      (test-fn)))

(deftest add-a-takeaway
  (is (contains? (do
                   (add-takeaway "the title")
                   (get-takeaways))
                 "the title")))