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
    :role :when :driven :linked]))

(defentity deftransport "" 'transport)

(p/defpartition BindingAffinity
  [LowAfinity HighAfinity])

(deftransport ToTransportZincIonWithHighAfinity
  ;;"GO:0000006"
  :cargo ch/zinc_2+_
  :super (owl-some hasBindingAffinity HighAfinity))

(deftransport ToTransportZincIonWithLowAfinity
  ;;"GO:0000007"
  :cargo ch/zinc_2+_
  :super (owl-some hasBindingAffinity LowAfinity))

(deftransport ToTransportZincIon
  ;;"GO:0005385"
  :cargo ch/zinc_ion)


(deftransport ToTransportLongChainFattyAcid
  ;;"GO:0005324"
  :cargo ch/long-chain_fatty_acid)

(deftransport ToTransportFattyAcid
  ;;"GO:0015245"
  :cargo ch/fatty_acid)

(deftransport ToTransportShortChainFattyAcid
  ;;"GO:0015636"
  :cargo ch/short-chain_fatty_acid)

(deftransport ToTransportL-ornithine
  ;;"GO:0000064"
  :role ch/L-ornithine)

(deftransport ToTransportS-adenosyL-methionine
  ;;"GO:0000095"
  :role ch/S-adenosyl-L-methionine)

(deftransport ToTransportSulfurAminoAcid
  ;;"GO:0000099"
  :cargo ch/sulfur-containing_amino_acid)

(deftransport ToTransportS-methylmethionine
  ;;"GO:0000100"
  :role ch/S-methyl-L-methionine)

(deftransport ToTransportL-valine
  ;;"GO:0005304"
  :role ch/L-valine)

(deftransport ToTransportL-isoleucine
  ;;"GO:0015188"
  :role ch/L-isoleucine)

(deftransport ToTransportNucleoside
  ;;"GO:0005337"
  :cargo ch/nucleoside)

(deftransport ToTransportAdenineNucleotide
  ;;"GO:0000295"
  :cargo ch/adenyl_nucleotide)

(deftransport ToTransportSperminey
  ;;"GO:0000297" 
  :role ch/spermine)

(deftransport ToTransportSulfite
  ;;"GO:0000319"
  :cargo ch/sulfite)

(deftransport ToTransportGlycerophosphodiester
  ;;"GO:0001406"
  :cargo ch/glycerol_1-phosphodiester)

(deftransport ToTransportGuanineNucleotide
  ;;"GO:0001409"
  :cargo ch/guanyl_nucleotide)

(deftransport ToTransportBetaAlanine
  ;;"GO:0001761"
  :role ch/beta-alanine)

;; There is no metal ion in CHEBI
(deftransport ToTransportMetalIon
  ;;"GO:0046873"
  :cargo ch/metal_cation)

;; There is no iron ion in CHEB
(deftransport ToTransportIronIon
  ;;"GO:0005381"
  :role ch/iron_2+_)

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
