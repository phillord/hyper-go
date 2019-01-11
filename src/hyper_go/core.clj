(ns hyper-go.core
    (:use [tawny.pattern])
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))

(defontology HyperGo
  :iri "http://purl.obolibrary.org/obo/HyperGo")

;;(owl-import tawny-chebi.chebi/chebi)

;; Stuff from other ontologies
(declare-classes Location Membrane Channel)
(defoproperty bearer-of)

;; From CC and Cell Ontologies
(declare-classes
                 LeafletOfMembraneBilayer cardiac_muscle_cell_action_potential ;;GO:0086001
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

(defoproperty opens-in
  :comment "A channel/pore opens in response to some to a specific stimulus")

(defoproperty bind-to
  :comment "A substance bind to a another substance to form larger complex or allwo some process such as ligand")

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

(defoproperty transports-through
  :comment "transports solute through a channel or pore"
  :range Channel)

(defoproperty involved_in)

(defoproperty involved_in_positive
  :super involved_in)

(defoproperty involved_in_negative
  :super involved_in)

(defoproperty occurs_in
  :comment "http://purl.obolibrary.org/obo/BFO_0000066")

(defoproperty contributes-to)

(defoproperty as-results-of)

(defclass ValuePartition)

(defpartition BindingAffinity
  [LowAffinity HighAffinity]
  :comment "Transports a substance with high/low affinity. Affinity is a property for the transporter not the thing being transported"
  :super ValuePartition)

(defpartition Mechanism
  [Rotational Phosphorylative Facilitated_diffusion]
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

(defpartition EnergySource
  [Light Decarboxylation Oxidoreduction Methyl_transfer_reaction ATP_Hydrolysis ATP_Synthesis pH-dependent]
  :comment "In Primary Active transporter: transport works equally well in either direction and is driven by a primary energy source "
  :super ValuePartition)

;; some of these valuepartition is a Biological Process such as "phosphorylation GO:0016310", dephosphorylation GO:0016311".
(defpartition Stimulus
  [Osmolarity MechanicalStress Voltage
   HighVoltage LowVoltage IntermediateVoltage
   Light volume-sensitive Phosphorylation
   Dephosphorylation inward-rectification]
  :comment "Gate channel: enables the transmembrane transfer of solute by a channel that opens in response to a specific stimulus."
  :super ValuePartition)

(defdproperty hasDaSize 
  :comment "Porin activity: enables the transfer of substances, sized less than 1000 Da, from one side of a membrane to the other."
  :range :XSD_INTEGER )

(defpartition PoreSize
  [Wide Narrow]
  :comment "Pore channel: enables the transport of a solute across a membrane via a large pore, un-gated channel"
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
                       (with-property frames :involved involved_in)
                       (with-property frames :occurs occurs_in)
                       (with-property frames :via transports-through)
                       (with-property frames :results as-results-of)]))))

(def transport
  (extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven :linked :transports-with :mechanism :across :direction :involved :occurs :via :results]))

(defentity deftransport "" 'transport)



;; ==== Biological Process ========

(defclass SinoatrialNodeCellActionPotential
  :comment "GO:0086015")

(defclass PurkinjeMyocyteActionPotential
  :comment "GO:0086017")

(defclass BundleOfHisCellActionPotential
  :comment "GO:0086043")

(defclass AtrioventricularNodeCellActionPotential
  :comment "GO:0086016")

(defclass ActionPotential
  :comment "GO:0001508")

(defclass VentricularCardiacMuscleCellMembraneRepolarization
  :comment "GO:0099625")

(defclass AtrialCardiacMuscleCellActionPotential
  :comment "GO:0086014")

(defclass CalciumIonHomeostasis
  :comment "GO:0055074")

(defclass CellCommunicationByElectricalCoupling
  :comment "GO:0010644")

(defclass CellularResponseTopH
  :comment "GO:0071467")

;; ================= Cellular Component ============

(defclass Cell
  :comment "GO:0005623")

(defclass Intracellular
  :comment "GO:0005622")

(defclass ExtracellularRegion
  :comment "GO:0005576")

(defclass Mitochondrion
  :comment "GO:0005739")

(defclass Chloroplast
  :comment "GO:0009507")

(defclass Cytosol
  :comment "GO:0005829")

(defclass PresynapticCytosol
  :comment "GO:0099523")

(defclass PostsynapticCytosol
  :comment "GO:0099524")

(defclass IntracellularCanaliculus
  :comment "GO:0046691")

(defclass PoreComplex
  :comment "GO:0046930")

(defclass PeriplasmicSpace
  :comment "GO:0042597")

(defclass PresynapticMembrane
  :comment "GO:0042734")

(defclass PostsynapticMembrane
  :comment "GO:0045211")

(defclass ReceptorComplex
  :comment "GO:0043235")

;;================ Not Exist in GO ======================

(defclass ResponseToPhosphorylation
  :super go/response_to_stimulus)

(defclass RresponseToDephosphorylation
  :super go/response_to_stimulus)

;; ==================== Other Ontology ================

(defclass Hepatocyte
  :comment "CL:0000182")

(defclass MembranePotential
  :comment "OBA:0000099")
