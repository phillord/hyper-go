(ns hyper-go.go
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny.pattern :as p]))


(defontology hyper-go
  :iri "http://example.com/hyper-go")

;; Stuff from other ontologies
(declare-classes Location Membrane ATPase)
(defoproperty bearer-of)


;; Transporters
(defclass ToTransport)
(defoproperty transports)
(defoproperty transports-from)
(defoproperty transports-to)
(defoproperty has-part)
(defoproperty transports-across)
(defoproperty dependent-on)
(defoproperty driven-by)
(defoproperty linked-to
  :comment "One activity which happens at the same time as another and
  which can only occur because the other does.")

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
                       (with-property frames :driven driven-by)
                       (with-property frames :linked linked-to)]))))

(def transport
  (p/extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven]))

(defentity deftransport "" 'transport)

(defclass ToTransport
  :super
  (owl-some transports ch/chemical_entity)
  (owl-some transports-from Location)
  (owl-some transports-to Location))

(defclass ToTransportTransmembrane
  :equivalent
  (owl-and ToTransport
           (owl-some transports-across Membrane)))

;; Pattern 1: transport of some chemical
;; need to macro this
(defn transporter
  ([chemical]
   ;;{:pre (comment chemical is in ChEBI)}
   (transporter chemical ToTransport))
  ([chemical across]
   (owl-class (str "to-transport " chemical)
              :equivalent
              (owl-and across
                       (owl-some transports chemical)))))

;; Patttern 2: transport of some chemical role
(defn transporter-with-role
  ([chemical-role]
   (transporter chemical-role ToTransport))
  ([chemical-role across]
   (transporter
    (owl-and ch/chemical_entity
             (owl-some bearer-of chemical-role))
    across)))

(defn transporter-with-condition [chemical condition]
  (owl-class (str "to-transport " chemical " with " condition)
             :equivalent
             (owl-and (transporter chemical)
                      (owl-some dependent-on condition))))

(defn transporter-driven [chemical driver]
  (owl-class (str "to-transport " chemical " driven by " driver)
             :equivalent
             (owl-and (transporter chemical)
                      (owl-some driven-by driver))))

(def ToTransportIon
  (transporter ch/ion))

(def ToTransportCation
  (transporter ch/cation))

(def ToTransportAnion
  (transporter ch/anion))

(def ToTransportChloride
  (transporter ch/chloride))

(def ToTransportChromiumIon
  (transporter ch/chromium_ion))

(def ToTransportWithChemicalCondition
  (transporter-with-condition ch/chemical_entity ch/chemical_entity))

(def ToTransportOrganicAnionWithSodiumCondition
  (transporter-with-condition
   ch/organic_ion ch/sodium_1+_))

(def ToTransportDrug
  (transporter-with-role ch/drug))

(def ToTransportDrugTransmembrane
  (transporter-with-role ch/drug ToTransportTransmembrane))

(def ToTransportBiotinTransmembrane
  (transporter-with-role ch/biotin ToTransportTransmembrane))

(def ToTransportBicozamycin
  (transporter-with-role ch/bicozamycin))

(def ToTransportDrivenWithATPase
  (transporter-driven ch/chemical_entity ATPase))

(def ToTransportCationDrivenWithATPase
  (transporter-driven ch/cation ATPase))

(defn di-porter [from to]
  (let [first-transport
        (transporter from)
        second-transport
        (transporter to)]
    (owl-class (str "di-porter" from " " to)
               :equivalent
               (owl-and
                ToTransport
                (owl-some has-part first-transport)
                (owl-some has-part second-transport)))))



(owl-import tawny-chebi.chebi/chebi)

;; (require 'tawny.reasoner)
;; (tawny.reasoner/reasoner-factory :hermit)
;; (tawny.reasoner/reasoner-factory :elk)

;; (subclass? ToTransport ToTransportCation)
;; (subclass? ToTransportCation ToTransport)

;; (tawny.reasoner/isubclass? ToTransportCation ToTransportCationDrivenWithATPase)
;; (tawny.reasoner/isubclass? ToTransportCation ToTransport)




;; (tawny.reasoner/isubclass? ToTransportChloride ToTransportAnion)
;; (tawny.reasoner/isubclass? ToTransportAnion ToTransportChloride)

;; (subclass? ch/chloride ch/cation)
