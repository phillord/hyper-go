(ns hyper-go.core
  (:use [tawny.pattern]
        [tawny.repl])
  (:require [tawny.owl :refer :all]
            [tawny.emacs :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))

(:import tawny-chebi.chebi/chebi)

(:import tawny-go.go/go)

(defontology HyperGo
  :iri "http://www.ncl.ac.uk/HyperGo"
  :comment "A hypernormnalised version of the Gene Ontology (GO) 
          written using the tawny-owl library")

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
(defoproperty contributeTo
  :comment "a molecular activity that contributes to a biological process"
  :annotation (database "RO_0002326"))
(defoproperty established-by
  :comment "a molecular activity established by a biological activity.")
(defoproperty during
  :comment "a molecular activity during a biological activity.")
(defoproperty hasPore
  :comment "pore membrane complex has narrow or wide pore size")
(defoproperty hasChannelType
  :comment "Wide and narrow pore channel proteins allow specific molecules cross the plasma membrane")


(defclass RefiningTypes)

(defpartition TransporterAffinity
  [LowAffinity HighAffinity]
  :comment "Transports a substance with high/low affinity. 
Affinity is a property for the transporter not the solute being transported"
  :super RefiningTypes)

(defpartition TransportSystem
  [Active Passive]
  :comment "A chemical entity transports with a transprt system at a single transport process."
  :super RefiningTypes)

(declare-classes
 SimpleDiffusion
 FacilitatedDiffusion 
   :comment "Passive transporter types are simple diffusion and facilitated diffusion"
   :super Passive)

(defpartition IonTransportMechanism
  [Rotational Phosphorylative]
  :comment "In some cases the movement of ions across a membrane occurs by the Rotational and Phosphorylative mechanisms"
  :super RefiningTypes)

(defpartition Acidity
  [Acidic Neutral Alkaline]
  :comment "Amino acid, Basic, Acidic and Neutral amino-acid have different PH scale"
  :super RefiningTypes)

(deftier Concentration
  [Low High]
  :comment "Concentration gradient is the difference in a solute concentration inside versus outside of a cell enviroment"
  :suffix true
  :super RefiningTypes)

(deftier Direction
  [Same Opposite]
  :comment "In secondary active transporters substances moves either by Symporter and Antiporter mechanism"
  :suffix true
  :functional true
  :super RefiningTypes)

(defpartition Enantiomerism
  [D-Enantiomer L-Enantiomer]
  :comment "D and L enantiomers refer to the configurational stereochemistry of the molecule."
  :super RefiningTypes)

(defpartition PrimaryEnergySource
  [Light Decarboxylation Oxidoreduction
   MethylTransferReaction ATP_Hydrolysis pyrophosphate_Hydrolysis
   pH-dependent Phosphoenolpyruvate ElectricalPotentialDifference]
  :comment "Active transporters use a primary source of energy to lead the 
active transport of a substance or a group of substances against a concentration gradient." 
  :super RefiningTypes)

(defpartition MembraneTransportProtein
  [Channel Carrier]
  :comment "Two primary modes of facilitated transport have been 
   recognized in biological systems: channel type and carrier type"
  :super RefiningTypes)

;; some of these valuepartitions is a Biological Process such as "phosphorylation GO:0016310", dephosphorylation GO:0016311".
(defpartition Stimulus
  [Osmolarity MechanicalStress Voltage
   IntermediateVoltage Light volume-sensitive
   Phosphorylation Dephosphorylation inward-rectification 
   temperature EmptyingOfIntracellularCalciumStores]
  :domain Channel
  :comment "Gate channel: enables the transmembrane transfer of solute by a channel 
               that opens in response to a specific stimulus."
  :super RefiningTypes)

(defpartition KCaTypeChannel
  [small-conductance intermediate-conductance large-conductance]
  :domain Channel
  :comment "There are three types of Ca2+-activated K+ channel have been 
     characterisedsmall-conductance (SK), intermediate conductance (IK) 
     and large conductance (BK)"
  :super Channel)

(defpartition Rate
  [High Low]
  :super RefiningTypes)

(defclass HighVoltage
  :super (owl-and Voltage (owl-some hasRate High)))
(defclass LowVoltage
  :super (owl-and Voltage (owl-some hasRate Low)))

(as-disjoint HighVoltage LowVoltage)

(defpartition Size
  [Wide Narrow]
  :super RefiningTypes)

(defclass Pore
  :comment "Any opening in a membrane that allows the passage of gases and/or liquids."
  :super RefiningTypes)

(defclass WidePore
  :super (owl-and Pore (owl-some hasSize Wide)))
(defclass NarrowPore
  :super (owl-and Pore (owl-some hasSize Narrow)))

(as-disjoint WidePore NarrowPore)

(defclass WidePoreChannel
  :super (owl-and Channel (owl-some hasPore WidePore)))

(defclass NarrowPoreChannel
  :super (owl-and Channel (owl-some hasPore NarrowPore)))

(as-disjoint WidePoreChannel NarrowPoreChannel)

(declare-classes Gap-junction Porin
                 :comment "Gap junctions and Porins are wide pore channels"
                 :super WidePoreChannel)

(as-disjoint Gap-junction Porin)

(defclass HemiChannel
  :comment "Two gap junction hemi-channels coupled together form a complete gap junction"
  :super Gap-junction)

(defdproperty hasDaSize
  :comment "Porin activity: enables the transfer of substances, sized less than 1000 Da, from one side of a membrane to the other."
  :range :XSD_INTEGER)

(defoproperty hasReaction
  :comment "")

(defoproperty hasReactant
  :comment "every chemical reaction has reactants substrates on the left-hand side of a chemical reaction")
(defoproperty hasProduct
  :comment "every chemical reaction has a product a substrates on the right-hand side of a chemical reaction")

(defpartition EnzymeClass
 [Transferase Oxidoreductase Hydrolase Lyase Ligase Isomerase Cyclase Demethylase]
 :comment "Eight classes of enzymes are defined in Catalytic Activity which catalyse different biochemical reactions. "
 :super RefiningTypes)


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
                       (with-property frames :transporterAffinity hasTransporterAffinity)
                       (with-property frames :across transports-across)
                       (with-property frames :driven driven-by)
                       (with-property frames :linked linked-to)
                       (with-property frames :when dependent-on)
                       (with-property frames :system hasTransportSystem)
                       (with-property frames :ion-mechanism hasIonTransportMechanism)
                       (with-property frames :direction hasDirection)
                       (with-property frames :involved involved_in)
                       (with-property frames :occurs occurs_in)
                       (with-property frames :via hasMembraneTransportProtein)
                       (with-property frames :contribute contributeTo)
                       (with-property frames :reaction hasReaction)
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
   [:from :to :cargo :role :when :driven :linked :transporterAffinity
    :system :across :direction :involved :occurs :via :results
    :contributes :ion-mechanism :enzyme :reactant :product]))

(defentity deftransport "" 'transport)

;;===========================
;;==== Catalytic activity ===
;;==== GO:0003824 ===========

(def catalyse
  (extend-frameify
   owl-class
   function-explicit
   [:reactant :product :when :enzyme :reaction :annotation]))

(defentity defcatalyse "" 'catalyse)


;; =====================================================
;; === Classes not exist in Chebi or other ontologies ==
;; =====================================================

(defclass Adhesin
  :super ch/chemical_entity
  :comment "Adhesin class not defined in Chebi, it is a protein, ChEBI only deals with small molecular entities")

(defclass Lactoferrin
  :super ch/protein
  :comment "Lactoferrin class not  in Chebi, it is a protein, ChEBI only deals with small molecular entities")

(defclass Colicin
  :super ch/protein
  :comment "Colicin class not found in Chebi, it is a protein, ChEBI only deals with small molecular entities ")

(defclass CopperChelate
  :super ch/copper_cation
  :comment "Copper chelate class not found in Chebi, it is a protein, ChEBI only deals with small molecular entities")

(defclass Copper-nicotianamine
  :super CopperChelate
  :comment " Copper-nicotianamine class not found in Chebi, it is a protein, ChEBI only deals with small molecular entities")

(defclass FoldedProtein
  :super ch/protein
  :comment "folded protein class not found in Chebi, it is a protein, ChEBI only deals with small molecular entities")


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

;; ;; =====================================================
;; ;; ================ Classes from Other Ontologies ======
;; ;; =====================================================
(defclass Hepatocyte
  :annotation (database "CL:0000182"))

(defclass CardiacMuscleCell
  :annotation (database "CL:0000746"))
