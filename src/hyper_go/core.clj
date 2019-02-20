(ns hyper-go.core
    (:use [tawny.pattern])
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))


;;(owl-import tawny-chebi.chebi/chebi)

(defontology HyperGo
  :iri "http://purl.obolibrary.org/obo/HyperGo")


;; Stuff from other ontologies
(declare-classes Location Membrane Channel)

(defoproperty bearer-of)

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

(defoproperty bound-by
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

(defoproperty established-by)
(defoproperty during)

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
  [Light Decarboxylation Oxidoreduction
   Methyl_transfer_reaction ATP_Hydrolysis 
   ATP_Synthesis pH-dependent Phosphoenolpyruvate]
  :comment "In Primary Active transporter: transport works equally well in either direction and is driven by a primary energy source "
  :super ValuePartition)

;; some of these valuepartition is a Biological Process such as "phosphorylation GO:0016310", dephosphorylation GO:0016311".
(defpartition Stimulus
  [Osmolarity MechanicalStress Voltage
   HighVoltage LowVoltage IntermediateVoltage
   Light volume-sensitive Phosphorylation
   Dephosphorylation inward-rectification temperature]
  :comment "Gate channel: enables the transmembrane transfer of solute by a channel that opens in response to a specific stimulus."
  :super ValuePartition)

(defdproperty hasDaSize 
  :comment "Porin activity: enables the transfer of substances, sized less than 1000 Da, from one side of a membrane to the other."
  :range :XSD_INTEGER )

(defpartition PoreSize
  [WidePore NarrowPore]
  :comment "Pore channel: enables the transport of a solute across a membrane via a large pore, un-gated channel"
  :super ValuePartition)

(declare-classes Gap-junction Porins
  :super WidePore)

(defclass hemi-channel
  :super Gap-junction)

(defpartition ChannelType
  [small-conductance intermediate-conductance large-conductance]
  :comment "There are three types of Ca2+-activated K+ channel have been characterisedsmall-conductance (SK), intermediate conductance (IK) and large conductance (BK)")


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



;;============ Not exist in Chebi or other ontologies ==========

(defclass Adhesin
  :super ch/chemical_entity
  :comment "Class not found in Chebi")

(defclass Transferrin
  :super ch/iron_3+_
  :comment "Class not found in Chebi")

(defclass Lactoferrin
  :super ch/protein
  :comment "Class not found in Chebi")

(defclass CopperChelate
  :super ch/copper_cation
  :comment "Class not found in Chebi")

(defclass Copper-nicotianamine
  :super CopperChelate
  :comment "Class not found in Chebi")


;; ==================== Exist in Other Ontology ================

(defclass Hepatocyte
  :comment "CL:0000182")

(defclass MembranePotential
  :comment "OBA:0000099")

(defclass CardiacMuscleCell
  :comment "CL:0000746")
