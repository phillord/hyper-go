(ns hyper-go.transferase_activity
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

     :enzyme Transferase)))

(defmacro read-csv
  [csv-file]
  `(do ~@(map chemical-reaction
              (doall (cs/parse-csv (try (slurp csv-file)
                         (catch Exception e (println (.getMessage e)))))))))

(def csv-data
  (read-csv "transferaseANDoxidoreductase.csv"))


(defcatalyse ToCatalyseGTP-DependentProteinSerineKinaseActivity
  :comment "GO:0034211"
  :reactant (owl-and ch/ATP_4-_ ch/L-serine_residue)
  :product (owl-and ch/ADP_3-_ ch/hydron ch/O-phospho-L-serine_2-__residue)
  :when ch/GTP_4-_
  :enzyme Transferase)


(defcatalyse ToCatalyseGTP-DependentProteinThreonineKinaseActivity
  :comment "GO:0034211"
  :reactant (owl-and ch/ATP_4-_ ch/L-threonine_residue)
  :product (owl-and ch/ADP_3-_ ch/hydron ch/O-phosphonato-L-threonine_2-__residue)
  :when ch/GTP_4-_
  :enzyme Transferase)


;;=======================================
;;======== Transferase general terms ====
;;=======================================

;;(defcatalyse ToCatalyseN-acetyltransferaseActivity
;;  :comment "GO:0008080"
;;  :reactant 

ch/carbon_dioxide
