(ns hyper-go.core
    (:use [tawny.pattern])
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))


(owl-import tawny-chebi.chebi/chebi)

(owl-import tawny-go.go/go)

(defontology HyperGo
  :iri "http://purl.obolibrary.org/obo/HyperGo")

;; =====================================================
;; =========== Define Properties for TA and CA =========
;; =====================================================

(defaproperty go_Id
  :comment "GO Id, following the OBO-Format for ontology identifiers")
(def goid (annotator go_Id))
(defaproperty identitas_Id
  :comment "Identitas Id: semantic-free and human readable identifer")
(def identitasId (annotator identitas_Id))
(defaproperty definition
  :comment "GO class definition")
(def Def (annotator definition))
(defaproperty has_exact_synonym
  :comment "GO class exact synonym")
(def synon (annotator has_exact_synonym))
(defaproperty database_across_reference
  :comment "reference to related source: an ontology or database")
(def database (annotator database_across_reference))

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
  :comment "transports solute through a channel or pore")
(defoproperty involved_in
  :comment "a molecular activity that involved in a biological process"
  :annotation (database "RO_0002331"))

(defoproperty involved_in_positive
  :super involved_in
  :comment "a molecular activity that positively involved in a biological process")
(defoproperty involved_in_negative
  :super involved_in
  :comment "a molecular activity that negatively involved in a biological process")
(defoproperty occurs_in
  :label "occurs in"
  :comment "a molecular activity that occurs in a specific cellular location")
(defoproperty contributes-to
  :comment "a molecular activity that contributes to a biological process"
  :annotation (database "RO_0002326"))
(defoproperty established-by
  :comment "a molecular activity established by a biological activity.")
(defoproperty during
  :comment "a molecular activity during a biological activity.")


(defclass ValuePartition)

(defpartition BindingAffinity
  [LowAffinity HighAffinity]
  :comment "Transports a substance with high/low affinity. 
       Affinity is a property for the transporter not the thing being transported"
  :super ValuePartition)

(defpartition Mechanism
  [Rotational Phosphorylative Facilitated_diffusion]
  :comment "some chemical entities transported with a specific type of mechanism"
  :super ValuePartition)

(defpartition Acidity
  [Acidic Neutral Alkaline]
  :comment "Amino acid, Basic, acidic and neutral amino-acid have different PH scale"
  :super ValuePartition)

(deftier Concentration
  [Low High]
  :comment "In Active transporter: Particles or solutes moves from an area with high number 
      of particles to an area of lower number of particles."
  :super ValuePartition
  :suffix true
  :functional false)

(defpartition Direction
  [SameDirection OppositeDirection]
  :comment "In secondary active transporters substances moves either by Symporter and Antiporter mechanism"
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

;; some of these valuepartitions is a Biological Process such as "phosphorylation GO:0016310", dephosphorylation GO:0016311".
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

(defpartition ChannelType
  [small-conductance intermediate-conductance large-conductance]
  :comment "There are three types of Ca2+-activated K+ channel have been characterisedsmall-conductance (SK), intermediate conductance (IK) and large conductance (BK)")
(declare-classes Gap-junction Porins
  :super WidePore)
(defclass hemi-channel
  :super Gap-junction)


(defoproperty hasReactant
  :comment "every chemical reaction has reactants substrates on the left-hand side of a chemical reaction")
(defoproperty hasProduct
  :comment "every chemical reaction has a product a substrates on the right-hand side of a chemical reaction")

(defpartition EnzymeClass
  [Transferase Oxidoreductase Hydrolase Lyase Ligase Isomerase Cyclase Demethylase]
  :comment "The eight classes of enzymes defined in the catalytic activity which catalyse different biochemical reactions. "
  :super ValuePartition)





(defn with-property [frames frame-maybe property]
  (when-let [frame (frame-maybe frames)]
    (owl-some property frame)))

(defn function-explicit [o clazz frames]
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
                       (with-property frames :when dependent-on)
                       (with-property frames :mechanism hasMechanism)
                       (with-property frames :direction hasDirection)
                       (with-property frames :involved involved_in)
                       (with-property frames :occurs occurs_in)
                       (with-property frames :via transports-through) 
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
   [:from :to :cargo :role :when :driven :linked :transports-with
    :mechanism :across :direction :involved :occurs :via :results]))

(defentity deftransport "" 'transport)

;;===========================
;;==== Catalytic activity ===
;;==== GO:0003824 ===========

(def catalyse
  (extend-frameify
   owl-class
   function-explicit
   [:reactant :product :when :enzyme]))

(defentity defcatalyse "" 'catalyse)


;; =====================================================
;; === Classes not exist in Chebi or other ontologies ==
;; =====================================================

(defclass Adhesin
  :super ch/chemical_entity
  :comment "Adhesin class not found in Chebi")

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
  :annotation (goid "GO:0052908")

(defclass N_6_-dimethyladenine_1518_or_N_6_-dimethyladenine_1519__in_16S_rRNA
  :super ch/N_6__N_6_-dimethyladenosine_5'-monophosphate_1-__residue)
  :annotation (goid "GO:0052908")

(defclass Adenine_1779_or_adenine_1780__in_18S_rRNA
  :super ch/adenosine_5'-monophosphate_1-__residue)
  :annotation (goid "GO:0052909")

(defclass N_6_-dimethyladenine_1779_or_N_6_-dimethyladenine_1780__in_18S_rRNA
  :super ch/N_6__N_6_-dimethyladenosine_5'-monophosphate_1-__residue)
  :annotation (goid "GO:0052909")

;; =====================================================
;; ================ Classes from Other Ontologies ======
;; =====================================================
(defclass Hepatocyte
  :annotation (database "CL:0000182"))

(defclass CardiacMuscleCell
  :annotation (database "CL:0000746"))
