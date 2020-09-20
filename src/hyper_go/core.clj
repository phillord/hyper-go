(ns hyper-go.core
    (:use [tawny.pattern])
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))


;;(owl-import tawny-chebi.chebi/chebi)

;;(owl-import tawny-go.go/go)

(defontology HyperGo
  :iri "http://purl.obolibrary.org/obo/HyperGo")



(declare-classes Location Channel)

;; =====================================================
;; =========== Define Properties for TA and CA =========
;; =====================================================

(defoproperty bearer-of)

(defaproperty go_Id
  :comment "GO Id, following the OBO-Format identifier")

(defaproperty identitas_Id
  :comment "Identitas Id")

(defaproperty definition
  :comment "GO class definition")

(defaproperty has_exact_synonym
  :comment "GO class exact synonym")

(defoproperty transports
  :comment "Transports a specific substance or a group of related substances ")

(defoproperty transports-from
  :comment "Transport a substance usually FROM location TO another")
(defoproperty transports-to
  :comment "Transport some chemical entity usually FROM location TO another")

(defoproperty has-part
  :comment "A substance such as SALT has part Anion and Cation")

(defoproperty transports-across
  :comment "Usually transport across Membrane")

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
  :label "occurs in"
  :comment "http://purl.obolibrary.org/obo/BFO_0000066")


(defoproperty contributes-to)

(defoproperty as-results-of)

(defoproperty established-by)
(defoproperty during)

(defoproperty activated-by)


(defoproperty hasReactant
  :comment "every chemical reaction has reactants substrates on the left-hand side of a chemical reaction")

(defoproperty hasProduct
  :comment "every chemical reaction has a product a substrates on the right-hand side of a chemical reaction")


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
   ATP_Synthesis pH-dependent Phosphoenolpyruvate MembranePotential]
  :comment "In Primary Active transporter: transport works equally well in either direction and is driven by a primary energy source "
  :super ValuePartition)

;; some of these valuepartition is a Biological Process such as "phosphorylation GO:0016310", dephosphorylation GO:0016311".
(defpartition Stimulus
  [Osmolarity MechanicalStress Voltage
   HighVoltage LowVoltage IntermediateVoltage
   Light volume-sensitive Phosphorylation
   Dephosphorylation inward-rectification temperature
   EmptyingOfIntracellularCalciumStores]
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

(defpartition EnzymeClass
  [Transferase Oxidoreductase Hydrolase Lyase Ligase Isomerase Cyclase Demethylase]
  :comment "The eight classes of enzymes defined in the catalytic activity which catalyse different biochemical reactions. "
  :super ValuePartition)

(defn with-property [frames frame-maybe property]
  (when-let [frame (frame-maybe frames)]
    (owl-some property frame)))

;;(defn with-aproperty [frames frame-maybe property]
;;  (when-let [frame (frame-maybe frames)]
;;     (::annotation property frame)))


(defn function-explicit [o clazz frames]
  (owl-class clazz
             :equivalent
             (owl-and
              (remove nil?
                      [;(with-aproperty frames :goid go_Id)
                       ;(with-aproperty frames :identId identitas_Id)
                       (with-property frames :from transports-from)
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
                       (with-property frames :results as-results-of)
                       (with-property frames :reactant hasReactant)
                       (with-property frames :product hasProduct)
                       (with-property frames :enzyme hasEnzymeClass)]))))


;;===========================
;;==== Transport Activity ===
;;==== GO:0003824 =========== 
(def transport
  (extend-frameify
   owl-class
   function-explicit
   [;:goid :identId
    :from :to :cargo :role :when :driven :linked :transports-with :mechanism :across :direction :involved :occurs :via :results]))

(defentity deftransport "" 'transport)

;;===========================
;;==== Catalytic activity ===
;;==== GO:0003824 ===========

(def catalyse
  (extend-frameify
   owl-class
   function-explicit
   [;:goid :identId
    :reactant :product :when :enzyme]))

(defentity defcatalyse "" 'catalyse)


;; =====================================================
;; === Classes not exist in Chebi or other ontologies ==
;; =====================================================

(defclass Adhesin
  :super ch/chemical_entity
  :comment "Adhesin class not found in Chebi")

(defclass Transferrin
  :super ch/iron_3+_
  :comment "Transferrin class not found in Chebi")

(defclass Lactoferrin
  :super ch/protein
  :comment "Lactoferrin class not found in Chebi")

(defclass CopperChelate
  :super ch/copper_cation
  :comment "Copper chelate class not found in Chebi")

(defclass Copper-nicotianamine
  :super CopperChelate
  :comment " Copper-nicotianamine class not found in Chebi")

(defclass PeptidoglycanPeptide
  :super ch/peptidoglycan
  :comment "peptidoglycan peptide class not found in Chebi")

(defclass FoldedProtein
  :super ch/protein
  :comment "folded protein class not found in Chebi")


(defclass Adenine_1518_or_adenine_1519__in_16S_rRNA
  :super ch/adenosine_5'-monophosphate_1-__residue)
  ;;goId "GO:0052908")

(defclass N_6_-dimethyladenine_1518_or_N_6_-dimethyladenine_1519__in_16S_rRNA
  :super ch/N_6__N_6_-dimethyladenosine_5'-monophosphate_1-__residue)
  ;;goId "GO:0052908")

(defclass Adenine_1779_or_adenine_1780__in_18S_rRNA
  :super ch/adenosine_5'-monophosphate_1-__residue)
  ;;goId "GO:0052909")

(defclass N_6_-dimethyladenine_1779_or_N_6_-dimethyladenine_1780__in_18S_rRNA
  :super ch/N_6__N_6_-dimethyladenosine_5'-monophosphate_1-__residue)
  ;;goId "GO:0052909")

;; =====================================================
;; ================ Classes from Other Ontologies ======
;; =====================================================
(defclass Hepatocyte
  :comment "CL:0000182")

(defclass CardiacMuscleCell
  :comment "CL:0000746")


(save-ontology "hyper-go.owl" :owl)
