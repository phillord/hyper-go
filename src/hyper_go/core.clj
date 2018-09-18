(ns hyper-go.core
    (:use [tawny.pattern])
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]))

(defontology hyper-go
  :iri "http://example.com/hyper-go")


;; (defn get-go-ontology []
;;   (tawny.owl/remove-ontology-maybe
;;    (OWLOntologyID. (IRI/create "http://purl.obolibrary.org/obo/go.owl")))
;;   (.loadOntologyFromOntologyDocument
;;    (tawny.owl/owl-ontology-manager)
;;    (IRI/create  "http://purl.obolibrary.org/obo/go.owl")))

;; (owl-import (get-go-ontology))

;;(owl-import tawny-chebi.chebi/chebi)


;; Stuff from other ontologies
(declare-classes Location Membrane ATPase)
(defoproperty bearer-of)

;; From CC and Cell Ontologies
(declare-classes Mitochondrion Chloroplast Cell Intracellular ExtracellularRegion
                 PresynapticMembrane PostsynapticMembrane Hepatocyte  IntracellularCanaliculus 
  :super Location)

;; Transporters
;(defclass ToTransport)
(defoproperty transports
  :comment "Transports a specific substance or a group of related substances ")

(defoproperty transports-from
  :comment "Transport a substance usually FROM location TO another")
(defoproperty transports-to
  :comment "Transport some chemical entity usually FROM location TO another")

(defoproperty has-part
  :comment "A substance such as SALT has part Anion and Cation")
(defoproperty transports-across
  :comment "Usually transport across Membrane"
  :range Membrane)

(defoproperty dependent-on
  :comment "A substance depend on other molecule to be transported")
(defoproperty driven-by
  :comment "A substance not ransported till driven by some other chemical entity, ion and enzyme")
(defoproperty derived-from
  :comment "A substance derived from other molecule")

(defoproperty linked-to
  :comment "One activity which happens at the same time as another and
  which can only occur because the other does.")

(defoproperty has-role
  :comment "Transport a substance which has some role such as drug, vitamin, neurotransmitter and cofactor")

(defoproperty has-biological-role
  :comment "Transport a substance which has some role such as coenzyme, vitamin, neurotransmitter and cofactor"
  :super has-role)

(defoproperty has-chemical-role
  :comment "Transport a substance which has some role such as antioxidant"
  :super has-role)

(defoproperty has-application-role
  :comment "Transport a substance which has some role such as drug"
  :super has-role)

(defoproperty involved_in_regulation_of
  :comment "http://purl.obolibrary.org/obo/RO_0002428")

(defoproperty involved_in_positive_regulation_of
  :comment "http://purl.obolibrary.org/obo/RO_0002429"
  :super involved_in_regulation_of)

(defoproperty involved_in_negative_regulation_of
  :comment "http://purl.obolibrary.org/obo/RO_0002430"
  :super involved_in_regulation_of)

(defoproperty occurs_in
  :comment "http://purl.obolibrary.org/obo/BFO_0000066")

(defclass ValuePartition)

(defpartition BindingAffinity
  [LowAffinity HighAffinity]
  :comment "Transports a substance with high/low affinity. Affinity is a property for the transporter not the thing being transported"
  :super ValuePartition)

(defpartition Mechanism
  [Rotational Phosphorylative]
  :comment "some chemical entities transported with a specific type of mechanism"
  :super ValuePartition)

(defpartition Acidity
  [Acidic Neutral Alkaline]
  :comment "Amino acid, Basic, acidic and neutral amino-acid have different ph scale"
  :super ValuePartition)

(deftier Concentration
  [Low High]
  :comment "In Active transporter: Particles or solutes moves from an area with high number of particles to an area of lower number of particles."
  :super ValuePartition
  :suffix true
  :functional false)

(defpartition Direction
  [SameDirection OppositeDirection]
  :comment "In Active transporter: Symporter and Antiporters"
  :super ValuePartition)

(defpartition Enantiomerism
  [D-Enantiomer L-Enantiomer]
  :super ValuePartition)


(defn with-property [frames frame-maybe property]
  (when-let [frame (frame-maybe frames)]
    (owl-some property frame)))


(defn transport-explicit [o clazz frames]
  (owl-class clazz
             :equivalent
             (owl-and
              (remove nil?
                      [(with-property frames :from transports-from)
                       (with-property frames :to transports-to)
                       (with-property frames :cargo transports)
                       (with-property frames :transports-with hasBindingAffinity)
                       (with-property frames :across transports-across)
                       (with-property frames :driven driven-by)
                       (with-property frames :linked linked-to) 
                       (with-property frames :role bearer-of)
                       (with-property frames :when dependent-on)
                       (with-property frames :mechanism hasMechanism)
                       (with-property frames :direction hasDirection)
                       (with-property frames :involved involved_in_regulation_of)
                       (with-property frames :occurs occurs_in)]))))

(def transport
  (extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven :linked :transports-with :mechanism :across :direction :involved :occurs]))

(defentity deftransport "" 'transport)
