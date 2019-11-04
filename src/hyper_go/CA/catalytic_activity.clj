(ns hyper-go.catalytic_activity
   (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny-go.go :as go]
            [clojure.java.io :as io]
            [clojure-csv.core :as cs]))


(ontology-to-namespace hyper-go.core/HyperGo)

(defn chemical-reaction [lis]
  (let [classname (str "ToCatalyse" (first lis))
        id (second lis)
        reactants (map symbol (map #(str "ch/" %)
                                   (remove empty? (drop 2 (take 13 lis)))))
        products (map symbol (map #(str "ch/" %)
                                  (remove empty? (drop 14 lis))))]
  `(defcatalyse ~(symbol classname)
     :comment ~ id
     :reactant
     ~(cond (false? (empty? reactants))
            `(owl-and ~(vec reactants)))
     :product
     ~(cond (false? (empty? products))
            `(owl-and ~(vec products)))
     )))

(defmacro read-csv
  [csv-file]
  `(do ~@(map chemical-reaction
              (doall (cs/parse-csv (try (slurp csv-file)
                         (catch Exception e (println (.getMessage e)))))))))

(def csv-data
  (read-csv "transferaseANDoxidoreductase.csv"))
