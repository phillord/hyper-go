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
                       (with-property frames :linked linked-to)
                       (with-property frames :role bearer-of)
                       (with-property frames :when dependent-on)]))))

(def transport
  (p/extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven]))

(defentity deftransport "" 'transport)

(deftransport ToTransportIon
  ;;"GO:0015075"
  :cargo ch/ion)

(deftransport ToTransportCation
  ;;"GO:0008324"
  :cargo ch/cation)

(deftransport ToTransportAnion
  ;;"GO:0008509"
  :cargo ch/anion)

(deftransport ToTransportChloride
  ;;"GO:0015108"
  :cargo ch/chloride)

(deftransport ToTransportChromiumIon
  ;;"GO:0070835"
  :cargo ch/chromium_ion)

(deftransport ToTransportWithChemicalCondition
  :when ch/chemical_entity ch/chemical_entity)

(deftransport ToTransportOrganicAnionWithSodiumCondition
  ;;"GO:0015347"
  :when ch/organic_ion ch/sodium_1+_)

(deftransport ToTransportDrug
  ;;"GO:0015238"
  :role ch/drug)

(deftransport ToTransportDrugTransmembrane
  ;;"GO:0015238"
  :role ch/drug)

(deftransport ToTransportBiotinTransmembrane
  ;;"GO:0015225"
  :role ch/biotin)

(deftransport ToTransportBicozamycin
  ;;"GO:0015545"
  :role ch/bicozamycin)

(deftransport ToTransportDrivenWithATPase
  :driven ch/chemical_entity ATPase)

(deftransport ToTransportCationDrivenWithATPase
  ;;"GO:0019829"
  :driven ch/cation ATPase)

(defn di-porter [from to]
  (let [first-transport
        (:cargo :from)
        second-transport
        (:carg :to)]
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
