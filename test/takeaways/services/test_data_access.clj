(ns takeaways.services.test-data-access
  (:require [clojure.test :refer :all]
            [takeaways.services.data-access :refer :all]
            [mount.core :as mount]))

(use-fixtures :once (fn [test-fn]
                      (mount/start)
                      (test-fn)))

(deftest add-a-takeaway
  (is (some #{"the title"}
            (do
              (add-takeaway "the title")
              (get-takeaways)))))

(deftest dups
  (let [title "t"
        ts (do (add-takeaway title)
               (add-takeaway title)
               (filter #(= title %) (get-takeaways)))]
    (is (<= 2 (count ts)))))

(deftest add-takeaway-returns-nil
  (is (nil? (add-takeaway "t"))))