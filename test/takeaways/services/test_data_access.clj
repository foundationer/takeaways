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

(deftest dups
  (let [title "t"
        ts (do (add-takeaway title)
               (add-takeaway title)
               (filter #(= title %) (get-takeaways)))]
    (is (<= 2 (count ts)))))


;; currently add-takeaway returns the takeaways.
;; that does not seem right. It is a behavior that's
;; not required at the moment.