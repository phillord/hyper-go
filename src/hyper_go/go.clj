(ns hyper-go.go
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

(owl-import tawny-chebi.chebi/chebi)


;; Stuff from other ontologies
(declare-classes Location Membrane ATPase)
(defoproperty bearer-of)

(declare-classes Mitochondrion Chloroplast Cell Intracellular ExtracellularRegion PresynapticMembrane PostsynapticMembrane
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

(deftransport ToTransport
  :cargo ch/chemical_entity)

;;Transmembrane transporter activity
(deftransport ToTransportTransmembrane
  :comment "GO:0022857"
  :across Membrane
  :cargo ch/chemical_entity)

;; Requires energy to transports molecules.
;; The energy derived directly from the breakdown of ATP.
(deftransport ToTransportPrimaryActiveTransmembrane
  :comment "GO:0015399"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven ATPase)

(deftransport ToTransportP-P-bond-hydrolysis-driven
  :comment "GO:0015405"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATPase ch/nucleoside_triphosphate))

;; chemical role
(deftransport ToTransportDrug
  :comment "GO:0015238"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-application-role ch/drug)))

;; chemical roley
(deftransport ToTransportVitamin
  :comment "GO:0090482"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/vitamin)))

;; chemical role
(deftransport ToTransportCofactor
  :comment "GO:0051184"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/cofactor)))

;; chemical role
(deftransport ToTransportSiderophore
  :comment "GO:0015343"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/siderophore)))

;; Neurotransmitters are any chemical substance that is capable of transmitting a nerve impulse from a neuron to another cell. 
(deftransport ToTransportNeurotransmitter
  :comment "GO:0005326"
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/neurotransmitter)))

;; chemical role
(deftransport ToTransportAntibiotic
  :comment "GO:0042895"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/antimicrobial_drug)))

;; chemical role
(deftransport ToTransportAuxin
  :comment "GO:0080161"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin)))

;; chemical role
(deftransport ToTransportAuxinEfflux
  :comment "GO:0010329"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin))
  :from Intracellular
  :to ExtracellularRegion)

;; chemical role
(deftransport ToTransportAuxinInflux
  :comment "GO:0010328"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin))
  :from ExtracellularRegion
  :to Intracellular)

(deftransport ToTransportAcetateEster
  :comment "GO:1901375"
  :across Membrane
  :cargo ch/acetate_ester)

;; Diff between GO and chebi
(deftransport ToTransportGlucose6-Phosphate
  :comment "GO:0015152"
  :across Membrane
  :cargo ch/D-glucose_6-phosphate)

(deftransport ToTransportAmine
  :comment "GO:0005275"
  :across Membrane
  :cargo ch/amine)

(deftransport ToTransportNucleobase
  :comment "GO:0015205"
  :across Membrane
  :cargo ch/nucleobase)

(deftransport ToTransportPyrimidineNucleobase
  :comment "GO:0005350"
  :across Membrane
  :cargo ch/pyrimidine_nucleobase)

(deftransport ToTransportUracil
  :comment "GO:0015210"
  :across Membrane
  :cargo (owl-and ch/uracil (owl-some has-application-role ch/drug)))

(deftransport ToTransportCytosine
  :comment "GO:0015209"
  :across Membrane
  :cargo ch/cytosine)

(deftransport ToTransportPurineNucleobase
  :comment "GO:0005345"
  :across Membrane
  :cargo ch/purine_nucleobase)

(deftransport ToTransportAdenineNucleobase
  :comment "GO:0015207"
  :across Membrane
  :cargo ch/adenine)

(deftransport ToTransportGuanineNucleobase
  :comment "GO:0015208"
  :across Membrane
  :cargo ch/guanine)

(deftransport ToTransportXanthine
  :comment "GO:0042907"
  :across Membrane
  :cargo ch/xanthine)

(deftransport ToTransportNucleobaseContainingCompound
  :comment "GO:0015932"
  :across Membrane
  :cargo ch/nucleobase-containing_molecular_entity)

(deftransport ToTransportNucleotide
  :comment "GO:0015215"
  :across Membrane
  :cargo ch/nucleotide)

(deftransport ToTransportFlavinAdenineDinucleotide
  :comment "GO:0015230"
  :across Membrane
  :cargo (owl-and ch/flavin_adenine_dinucleotide (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportNicotinamideAdenineDinucleotide
  :comment "GO:0051724"
  :across Membrane
  :cargo (owl-and ch/NAD (owl-some has-biological-role ch/coenzyme)))

;;Need review
(deftransport ToTransportDeoxynucleotide
  :comment "GO:0030233"
  :across Membrane
  :cargo ch/deoxyribonucleotide)

(deftransport ToTransportNicotinamideMononucleotide
  :comment "GO:0015663"
  :across Membrane
  :cargo (owl-and ch/nicotinamide_mononucleotide (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportPurineNucleotide
  :comment "GO:0015216"
  :across Membrane
  :cargo ch/purine_nucleotide)

(deftransport ToTransportGuanineNucleotide
  :comment "GO:0001409"
  :across Membrane
  :cargo ch/guanyl_nucleotide)

(deftransport ToTransportAdenineNucleotide
  :comment "GO:0000295"
  :across Membrane
  :cargo ch/adenyl_nucleotide)

(deftransport ToTransport3Phosphoadenosine-5Phosphosulfate
  :comment "GO:0046964"
  :across Membrane
  :cargo ch/_3'-phospho-5'-adenylyl_sulfate)

(deftransport ToTransportAdenosineTriphosphate
  :comment "GO:0005347"
  :across Membrane
  :cargo (owl-and ch/ATP (owl-some has-application-role ch/drug)))

(deftransport ToTransport5AdenylylSulfate
  :comment "GO:1902557"
  :across Membrane
  :cargo ch/_5'-adenylyl_sulfate)

;; (deftransport ToTransportAdenosineMonophosphate
;;   :comment "GO:0080122"
;;   :across Membrane
;;   :cargo (owl-and ch/adenosine_5'-monophosphate (owl-some has-application-role ch/drug)))

(deftransport ToTransportAdenosineDiphosphate
  :comment "GO:0015217"
  :across Membrane
  :cargo ch/ADP)

(deftransport ToTransportAdenosine_3-5-bisphosphate
  :comment "GO:0071077"
  :across Membrane
  :cargo ch/adenosine_3'_5'-bisphosphate)

(deftransport ToTransportFattyAcyl-CoA
  :comment "GO:0015607"
  :across Membrane
  :cargo (owl-and ch/fatty_acyl-CoA (owl-some derived-from ch/fatty_acid)))

(deftransport ToTransportCoenzyme-A
  :comment "GO:0015228"
  :across Membrane
  :cargo (owl-and ch/coenzyme_A (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportAcetyl-CoA
  :comment "GO:0008521"
  :across Membrane
  :cargo (owl-and ch/acetyl-CoA (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportPurineRibonucleotide
  :comment "GO:0005346"
  :across Membrane
  :cargo ch/purine_ribonucleotide)

(deftransport ToTransportNucleotideSulfate
  :comment "GO:0005340"
  :across Membrane
  :cargo ch/nucleotide-sulfate)

(deftransport ToTransportFlavineMononucleotide
  :comment "GO:0044610"
  :across Membrane
  :cargo (owl-and ch/FMN (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportPyrimidineNucleotide
  :comment "GO:0015218"
  :across Membrane
  :cargo ch/pyrimidine_nucleotide)

(deftransport ToTransportNucleotideSugar
  :comment "GO:0005338"
  :across Membrane
  :cargo ch/nucleotide-sugar)

(deftransport ToTransportPyrimidineNucleotideSugar
  :comment "GO:0015165"
  :across Membrane
  :cargo ch/pyrimidine_nucleotide-sugar)

(deftransport ToTransportUDP-N-Acetylgalactosamine
  :comment "GO:0005463"
  :across Membrane
  :cargo ch/UDP-N-acetylgalactosamine-5_6-ene)

(deftransport ToTransportUDP-N-Acetylglucosamine
  :comment "GO:0005462"
  :across Membrane
  :cargo ch/UDP-N-acetyl-alpha-D-glucosamine)

(deftransport ToTransportUDP-Xylose
  :comment "GO:0005464"
  :across Membrane
  :cargo ch/UDP-alpha-D-xylose)

(deftransport ToTransportCMP-N-Acetylneuraminate
  :comment "GO:0005456"
  :across Membrane
  :cargo ch/CMP-N-acetyl-beta-neuraminic_acid)

(deftransport ToTransportUDP-Galactose
  :comment "GO:0005459"
  :across Membrane
  :cargo ch/UDP-D-galactose)

(deftransport ToTransportUDP-GlucuronicAcid
  :comment "GO:0005461"
  :across Membrane
  :cargo ch/UDP-alpha-D-glucuronic_acid)

(deftransport ToTransportUDP-Glucose
  :comment "GO:0005460"
  :across Membrane
  :cargo ch/UDP-D-glucose)

(deftransport ToTransportPurineNucleotideSugar
  :comment "GO:0036080"
  :across Membrane
  :cargo ch/purine_nucleotide-sugar)

(deftransport ToTransportGDP-Fucose
  :comment "GO:0005457"
  :across Membrane
  :cargo ch/GDP-fucose)

(deftransport ToTransportGDP-Mannose
  :comment "GO:0005458"
  :across Membrane
  :cargo ch/GDP-mannose)

;; Nucleic acids are single or double-stranded polynucleotides involved in the storage, transmission and transfer of genetic information. 
(deftransport ToTransportNucleicAcid
  :comment "GO:0051032"
  :across Membrane
  :cargo ch/nucleic_acid)

(deftransport ToTransportDeoxyriboNucleicAcid
  :comment "GO:0051035"
  :across Membrane
  :cargo ch/deoxyribonucleic_acid)

(deftransport ToTransportRiboNucleicAcid
  :comment "GO:0051033"
  :across Membrane
  :cargo ch/ribonucleic_acid)

(deftransport ToTransportTransferRNA
  :comment "GO:0051034"
  :across Membrane
  :cargo ch/transfer_RNA)

;; Need review
(deftransport ToTransportProtein-DNA-Complex
  :comment "GO:0015219"
  :across Membrane
  :cargo (owl-and ch/macromolecule (owl-some has-part ch/protein ch/deoxyribonucleic_acid)))

(deftransport ToTransportNucleoside
  :comment "GO:0005337"
  :across Membrane
  :cargo ch/nucleoside)

(deftransport ToTransportPyrimidineNucleoside
  :comment "GO:0015214"
  :across Membrane
  :cargo ch/pyrimidine_nucleoside)

(deftransport ToTransportCytidine
  :comment "GO:0015212"
  :across Membrane
  :cargo ch/cytidine)

(deftransport ToTransportUridine
  :comment "GO:0015213"
  :across Membrane
  :cargo ch/uridine)

(deftransport ToTransportPurineNucleoside
  :comment "GO:0015211"
  :across Membrane
  :cargo ch/purine_nucleoside)

(deftransport ToTransportXanthosine
  :comment "GO:0015553"
  :across Membrane
  :cargo ch/xanthosine)

(deftransport ToTransportNicotinamideRiboside
  :comment "GO:0034257"
  :across Membrane
  :cargo ch/N-ribosylnicotinamide)

(deftransport ToTransportChlorophyllCatabolite
  :comment "GO:0010290"
  :across Membrane
  :cargo ch/primary_fluorescent_chlorophyll_catabolite)

(deftransport ToTransportAzole
  :comment "GO:1901474"
  :across Membrane
  :cargo ch/azole)

(deftransport ToTransportFluconazole
  :comment "GO:0015244"
  :across Membrane
  :cargo (owl-and ch/fluconazole (owl-some has-biological-role ch/antimicrobial_agent ch/xenobiotic)))

(deftransport ToTransportAcadesine
  :comment "GO:1903089"
  :across Membrane
  :cargo (owl-and ch/acadesine (owl-some has-application-role ch/drug)))

(deftransport ToTransportThiaminePyrophosphate
  :comment "GO:0090422"
  :across Membrane
  :cargo (owl-and ch/thiamine_1+__diphosphate_1-_ (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportSulfathiazole
  :comment "GO:0015546"
  :across Membrane
  :cargo (owl-and ch/sulfathiazole (owl-some has-biological-role ch/antimicrobial_agent ch/xenobiotic)))

(deftransport ToTransportThiamine
  :comment "GO:0015234"
  :across Membrane
  :cargo (owl-and ch/thiamine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportAminotriazole
  :comment "GO:1901478"
  :across Membrane
  :cargo ch/amitrole)

(deftransport ToTransportSulfurMolecularEntity
  :comment "GO:1901682"
  :across Membrane
  :cargo ch/sulfur_molecular_entity)

(deftransport ToTransportS-adenosyl-L-methionine
  :comment "GO:0000095"
  :across Membrane
  :cargo (owl-and ch/S-adenosyl-L-methionine (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportSulfite
  :comment "GO:0000319"
  :across Membrane
  :cargo ch/sulfite)

(deftransport ToTransportThiosulfate
  :comment "GO:0015117"
  :across Membrane
  :cargo ch/thiosulfate)

(deftransport ToTransportSulfate
  :comment "GO:0015116"
  :across Membrane
  :cargo ch/sulfate)

;; Requires energy to transports molecules.
;; Move molecules against thier concentration gradient
(deftransport ToTransportActiveTransmembrane
  :comment "GO:0022804"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATPase (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

(deftransport ToTransportActiveIonTransmembrane
  :comment "GO:0022853"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATPase (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

(deftransport ToTransportIonInvolvedInRegulationOfPresynapticMembranePotential
  :comment "GO:0099521"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATPase (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))
  :involved PresynapticMembrane
  :occurs PresynapticMembrane)

(deftransport ToTransportIonInvolvedInRegulationOfPostsynapticMembranePotential
  :comment "GO:0099581"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATPase (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))
  :involved PostsynapticMembrane
  :occurs PostsynapticMembrane)


;;Enables the transfer of a specific substance or related group of substances from the outside of the cell to the inside of the cell across a membrane.
(deftransport ToTransportInfluxTransmembrane
  :comment ""
  :cargo ch/chemical_entity
  :across Membrane
  :from ExtracellularRegion
  :to Intracellular)

;;Enables the transfer of a specific substance or related group of substances from the inside of the cell to the outside of the cell across a membrane.
(deftransport ToTransportEffluxTransmembrane
  :comment "GO:0015562"
  :cargo ch/chemical_entity
  :across Membrane
  :from Intracellular
  :to ExtracellularRegion)

;;#A substance or substances transported from the inside of the cell to the outside.
;; Driven by ATPase
(defn substance-exporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ExportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo (owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration))
     :driven ATPase
     :across Membrane
     :from Intracellular
     :to ExtracellularRegion))

;; macro function to do the classes mapping 
(defmacro defexporters-drivenby-ATPase [& lis]
  `(do ~@(map substance-exporting-ATPase lis)))

;;#A substance or substances transported from outside of the cell to the inside.
;; Driven by ATPase
(defn substance-importing-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ImportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo (owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration))
     :driven ATPase
     :across Membrane
     :from ExtracellularRegion
     :to Intracellular))

;; macro function to do the classes mapping 
(defmacro defimporters-drivenby-ATPase [& lis]
  `(do ~@(map substance-importing-ATPase lis)))


;;Enables the transfer of a solute from one side of a membrane to the other, up its concentration gradient.
;;Transport works equally well in either direction and is driven by a chemiosmotic source of energy, not direct ATP coupling.
;;Secondary active transporters include symporters and antiporters.
(deftransport ToTransportSecondaryActiveTransmembrane
  :comment "GO:0015291"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))


;;Solute A(out) + solute B(in) = solute A(in) + solute B(out).
(deftransport ToTransportAntiporterActivity
  :comment "GO:0015297"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportSymporterActivity
  :comment "GO:0015293"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven  (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportNucleosideSecondaryActiveTransmembrane
  :comment "GO:0010174"
  :across Membrane
  :cargo (owl-and ch/nucleoside (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPeptideSecondaryActiveTransmembrane
  :comment "GO:0022897"
  :across Membrane
  :cargo (owl-and ch/peptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportOligopeptideSecondaryActiveTransmembrane
  :comment "GO:0005427"
  :across Membrane
  :cargo (owl-and ch/oligopeptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportFerricTriacetylfusarinineC
  :comment "GO:0015621"
  :across Membrane
  :cargo ch/N'_N''_N'''-triacetylfusarinine_C)

(deftransport ToTransportCarbohydrate
  :comment "GO:0015144"
  :across Membrane
  :cargo ch/carbohydrate)

(deftransport ToTransportAldarate
  :comment "GO:0042876"
  :across Membrane
  :cargo ch/aldaric_acid_anion)

;; Different between GO and Chebi 
(deftransport ToTransportD-glucarate
  :comment "GO:0042878"
  :across Membrane
  :cargo (owl-and ch/D-glucarate_2-_ (owl-some hasEnantiomerism D-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportGalactarate
  :comment "GO:1902301"
  :across Membrane
  :cargo ch/galactaric_acid_anion)

(deftransport ToTransportGalactitol
  :comment "GO:0015577"
  :across Membrane
  :cargo ch/galactitol)

;; (deftransport ToTransportSugar
;;   :comment "GO:0051119"
;;   :across Membrane
;;   :cargo ch/sugar)


(deftransport ToTransportMacromolecule
  :comment "GO:0022884"
  :across Membrane
  :cargo ch/biomacromolecule)

(deftransport ToTransportTeichoicAcid
  :comment "GO:0015162"
  :across Membrane
  :cargo ch/teichoic_acid)

(deftransport ToTransportLipopolysaccharide
  :comment "GO:0015221"
  :across Membrane
  :cargo ch/lipopolysaccharide)

(deftransport ToTransportLipopolysaccharideExporter
  :comment "GO:0015634"
  :across Membrane
  :cargo ch/lipopolysaccharide
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportPolysaccharide
  :comment "GO:0015159"
  :across Membrane
  :cargo ch/polysaccharide)

(deftransport ToTransportBeta-glucan
  :comment "GO:0015160"
  :across Membrane
  :cargo ch/beta-D-glucan)

(deftransport ToTransportCapsularPolysaccharide
  :comment "GO:0015161"
  :across Membrane
  :cargo ch/polysaccharide)

(deftransport ToTransportArabinan
  :comment "GO:0042901"
  :across Membrane
  :cargo ch/arabinan)

(deftransport ToTransportMaltodextrin
  :comment "GO:0042958"
  :across Membrane
  :cargo ch/maltodextrin)

(deftransport ToTransportDextrin
  :comment "GO:0042957"
  :across Membrane
  :cargo ch/dextrin)

(deftransport ToTransportPeptidoglycan
  :comment "GO:0015647"
  :across Membrane
  :cargo ch/peptidoglycan)


(deftransport ToTransportLipid-linkedPeptidoglycan
  :comment "GO:0015648"
  :across Membrane
  :cargo ch/lipid-linked_peptidoglycan)


(deftransport ToTransportMonosaccharide
  :comment "GO:0015145"
  :across Membrane
  :cargo ch/monosaccharide)

(deftransport ToTransportPentose
  :comment "GO:0015146"
  :across Membrane
  :cargo ch/pentose)

(deftransport ToTransportD-ribose
  :comment "GO:0015591"
  :across Membrane
  :cargo (owl-and ch/D-ribose (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-xylose
  :comment "GO:0015148"
  :across Membrane
  :cargo (owl-and ch/D-xylose (owl-some hasEnantiomerism D-Enantiomer)))

;; A pentose monosaccharide that occurs in both D and L configurations, and as a polymer
(deftransport ToTransportArabinose
  :comment "GO:0042900"
  :across Membrane
  :cargo ch/arabinose)

(deftransport ToTransportL-arabinose
  :comment "GO:0015147"
  :across Membrane
  :cargo (owl-and ch/L-arabinose (owl-some hasEnantiomerism L-Enantiomer)))

;; Need review
(deftransport ToTransportL-ascorbicAcid
  :comment "GO:0015229"
  :across Membrane
  :cargo (owl-and ch/L-ascorbate (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/vitamin ch/coenzyme)))


(deftransport ToTransportUronicAcid
  :comment "GO:0015133"
  ;:annotation "Uronic acids are any monocarboxylic acid formally derived by oxidizing to a carboxyl group the terminal hydroxymethylene group of either an aldose with four or more carbon atoms in the molecule, or of any glycoside derived from such an aldose."
  :across Membrane
  :cargo ch/uronic_acid)

;; (deftransport ToTransportHexuronate
;;   :comment "GO:0015134"
;;   :across Membrane)

(deftransport ToTransportAminoAcidDerivative
  :comment "GO:0072349"
  :across Membrane
  :cargo ch/amino_acid_derivative)

(deftransport ToTransportFolicAcid
  :comment "GO:0008517"
  :across Membrane
  :cargo (owl-and ch/folic_acid (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))


(deftransport ToTransportCreatine
  :comment "GO:0005308"
  :across Membrane
  :cargo (owl-and ch/creatine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportS-methylmethionine
  :comment "GO:0000100"
  :across Membrane
  :cargo ch/S-methyl-L-methionine)


(deftransport ToTransportCarnitine
  :comment "GO:0015226"
  :across Membrane
  :cargo ch/carnitine)

(deftransport ToTransportR-Carnitine
  :comment "GO:1901235"
  :across Membrane
  :cargo (owl-and ch/_R_-carnitine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportR-PantothenicAcid
  :comment "GO:0015233"
  :across Membrane
  :cargo (owl-and ch/_R_-pantothenate (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/coenzyme ch/vitamin)))


(deftransport ToTransportL-hydroxyproline
  :comment "GO:0034590"
  :across Membrane
  :cargo (owl-and ch/_4-hydroxy-L-proline (owl-some hasEnantiomerism L-Enantiomer)))


(deftransport ToTransport5-formyltetrahydrofolicAcid
  :comment "GO:0015231"
  :across Membrane
  :cargo (owl-and ch/_5-formyltetrahydrofolic_acid (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportCarcinine
  :comment "GO:1905131"
  :across Membrane
  :cargo ch/carcinine)

(deftransport ToTransportGlutathione
  :comment "GO:0034634"
  :across Membrane
  :cargo (owl-and ch/glutathione (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportL-cystine
  :comment "GO:0015184"
  :across Membrane
  :cargo (owl-and ch/L-cystine (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransport4-TrimethylammonioButanoate
  :comment "GO:1901236"
  :across Membrane
  :cargo ch/_4-_trimethylammonio_butanoate)

(deftransport ToTransportAminoAcidBetaine
  :comment "GO:0015199"
  :across Membrane
  :cargo ch/glycine_betaine)

;;Any compound containing one, two, or three acyl groups attached to a nitrogen atom
(deftransport ToTransportAmide
  :comment "GO:0042887"
  :across Membrane
  :cargo ch/amide)


;; need review
;; Not sure what type of antibiotic.!!
;; In Chebi Benomyl does not have role xenobiotic !!!
(deftransport ToTransportBenomyl
  :comment "GO:1901479"
  :across Membrane
  :cargo (owl-and ch/benomyl (owl-some has-biological-role ch/antimicrobial_agent ch/xenobiotic)))

(deftransport ToTransportMethotrexate
  :comment "GO:0015350"
  :across Membrane
  :cargo (owl-and ch/methotrexate (owl-some has-application-role ch/drug)))


(deftransport ToTransportDethiobiotin
  :comment "GO:1901604"
  :across Membrane
  :cargo ch/dethiobiotin)

(deftransport ToTransportUrea
  :comment "GO:0015204"
  :across Membrane
  :cargo ch/urea)

(deftransport ToTransportAllantoate
  :comment "GO:0015124"
  :across Membrane
  :cargo ch/allantoate)

(deftransport ToTransportPeptide
  :comment "GO:1904680"
  :across Membrane
  :cargo ch/peptide)

(deftransport ToTransportProtein
  :comment "GO:0008320"
  :across Membrane
  :cargo ch/protein)

(deftransport ToTransportProteinActive
  :comment "GO:0009977"
  :across Membrane
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

;; (deftransport ToTransportProtein-DNAComplex
;;   :comment ""
;;   :across Membrane
;;   :cargo ....................................................)

(deftransport ToTransportMicrocin
  :comment "GO:0015638"
  :across Membrane
  :cargo (owl-and ch/microcin (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportOligopeptide
  :comment "GO:0035673"
  :across Membrane
  :cargo ch/oligopeptide)

(deftransport ToTransportTetrapeptide
  :comment "GO:1901584"
  :across Membrane
  :cargo ch/tetrapeptide)

(deftransport ToTransportTripeptide
  :comment "GO:0042937"
  :across Membrane
  :cargo ch/tripeptide)

(deftransport ToTransportDipeptide
  :comment "GO:0071916"
  :across Membrane
  :cargo ch/dipeptide)


;; Transfer of an inorganic molecular entity from the outside of a cell to the inside of the cell across a membrane.
;; An inorganic molecular entity is a molecular entity that contains no carbon. 
(deftransport ToTransportInorganicMolecularEntity
  :comment "GO:0015318"
  :across Membrane
  :cargo ch/inorganic_molecular_entity)


(deftransport ToTransportInorganicCation
  :comment "GO:0022890"
  :across Membrane
  :cargo ch/inorganic_cation)

(deftransport ToTransportTrivalentInorganicCation
  :comment "GO:0072510"
  :across Membrane
  :cargo ch/trivalent_inorganic_cation)

(deftransport ToTransportDivalentInorganicCation
  :comment "GO:0072509"
  :across Membrane
  :cargo ch/divalent_inorganic_cation)

(deftransport ToTransportFerrousIron
  :comment "GO:0015093"
  :across Membrane
  :cargo ch/iron_2+_)

(deftransport ToTransportZincIon
  :comment "GO:0005385"
  :across Membrane
  :cargo ch/zinc_2+_)

(deftransport ToTransportZincIonEfflux
  :comment "GO:0022883"
  :across Membrane
  :cargo ch/zinc_2+_
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportZincIonEffluxActive
  :comment "GO:0015341"
  :across Membrane
  :cargo (owl-and ch/zinc_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :from Intracellular
  :to ExtracellularRegion)


(deftransport ToTransportFerricIron
  :comment "GO:0015091"
  :across Membrane
  :cargo ch/iron_3+_)

;; (deftransport ToTransportTransferrin
;;   :comment "GO:0033570"
;;   :across Membrane
;;   :

(deftransport ToTransportMonovalentInorganicCation
  :comment "GO:0015077"
  :across Membrane
  :cargo ch/monovalent_inorganic_cation)

(deftransport ToTransportProton
  :comment "GO:0015078"
  :across Membrane
  :cargo ch/proton)

(deftransport ToTransportSodiumIon
  :comment "GO:0015081"
  :across Membrane
  :cargo ch/sodium_1+_)

(deftransport ToTransportPotassiumIon
  :comment "GO:0015079"
  :across Membrane
  :cargo ch/potassium_1+_)


(deftransport ToTransportAlkane
  :comment "GO:0015567"
  :across Membrane
  :cargo ch/alkane)

(deftransport ToTransportCyanate
  :comment "GO:0015110"
  :across Membrane
  :cargo ch/cyanate)

(deftransport ToTransportAminoAcid
  :comment "GO:0015171"
  :across Membrane
  :cargo ch/amino_acid)

(deftransport ToTransportL-AminoAcid
  :comment "GO:0015179"
  :across Membrane
  :cargo (owl-and ch/L-alpha-amino_acid (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-AminoAcidEfflux
  :comment "GO:0034639"
  :across Membrane
  :cargo (owl-and ch/L-alpha-amino_acid (owl-some hasEnantiomerism L-Enantiomer))
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportD-AminoAcid
  :comment "GO:0042943"
  :across Membrane
  :cargo (owl-and ch/D-alpha-amino_acid (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-methionine
  :comment "GO:0048474"
  :across Membrane
  :cargo (owl-and ch/D-methionine (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-aspartate
  :comment "GO:0140010"
  :across Membrane
  :cargo (owl-and ch/D-aspartate_2-_ (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-serine
  :comment "GO:0042945"
  :across Membrane
  :cargo (owl-and ch/D-serine (owl-some hasEnantiomerism D-Enantiomer) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportD-alanine
  :comment "GO:0042944"
  :across Membrane
  :cargo (owl-and ch/D-alanine (owl-some hasEnantiomerism D-Enantiomer) (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-tyrosine
  :comment "GO:0005302"
  :across Membrane
  :cargo (owl-and ch/L-tyrosine (owl-some has-application-role ch/drug) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-arginine
  :comment "GO:0061459"
  :across Membrane
  :cargo (owl-and ch/L-arginine (owl-some hasAcidity Alkaline) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-alanine
  :comment "GO:0015180"
  :across Membrane
  :cargo (owl-and ch/L-alanine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-valine
  :comment "GO:0005304"
  :across Membrane
  :cargo (owl-and ch/L-valine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-serine
  :comment "GO:0015194"
  :across Membrane
  :cargo (owl-and ch/L-serine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)))

(deftransport ToTransportHomoserine
  :comment "GO:0042970"
  :across Membrane
  :cargo (owl-and ch/homoserine (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-phenylalanine
  :comment "GO:0015192"
  :across Membrane
  :cargo (owl-and ch/L-phenylalanine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-proline
  :comment "GO:0015193"
  :across Membrane
  :cargo (owl-and ch/L-proline (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-leucine
  :comment "GO:0015190"
  :across Membrane
  :cargo (owl-and ch/L-leucine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)))

;; (deftransport ToTransportL-diaminopimelate
;;   :comment "GO:0015626"
;;   :across Membrane
;;   :cargo (owl-and ch/L-diaminopimelate (owl-some

(deftransport ToTransportL-ornithine
  :comment "GO:0000064"
  :across Membrane
  :cargo (owl-and ch/L-ornithine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-isoleucine
  :comment "GO:0015188"
  :across Membrane
  :cargo (owl-and ch/L-isoleucine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportAromaticAminoAcid
  :comment "GO:0015173"
  :across Membrane
  :cargo ch/aromatic_amino_acid)

(deftransport ToTransportBranchedChainAminoAcid
  :comment "GO:0015658"
  :across Membrane
  :cargo ch/branched-chain_amino_acid)

(deftransport ToTransportSulfurAminoAcid
  :comment "GO:0000099"
  :across Membrane
  :cargo ch/sulfur-containing_amino_acid)

(deftransport ToTransportMethionine
  :comment "GO:0043865"
  :across Membrane
  :cargo ch/methionine)

(deftransport ToTransportCysteine
  :comment "GO:0033229"
  :across Membrane
  :cargo (owl-and ch/cysteine (owl-some hasAcidity Neutral)))




;; AminoAcid secondary: symporters
(deftransport ToTransportSolute:SodiumSymporter
  :comment "GO:0015370"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportOrganicAcid:SodiumSymporter
  :comment "GO:0005343"
  :across Membrane
  :cargo (owl-and ch/organic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportDicarboxylate:SodiumSymporter
  :comment "GO:0017153"
  :across Membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportMalonate:SodiumSymporter
  :comment "GO:0044668"
  :across Membrane
  :cargo (owl-and ch/malonate_1-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportMalate:SodiumSymporter
  :comment "GO:0043882"
  :across Membrane
  :cargo (owl-and ch/malate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlutamate:SodiumSymporter
  :comment "GO:0015501"
  :across Membrane
  :cargo (owl-and ch/glutamate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportDicarboxylicAcidWithLowAffinity:SodiumSymporter
  :comment "GO:0015361"
  :across Membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportDicarboxylicAcidWithHighAffinity:SodiumSymporter
  :comment "GO:0015362"
  :across Membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAminoAcid:SodiumSymporter
  :comment "GO:0005283"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportProline:SodiumSymporter
  :comment "GO:0005298"
  :across Membrane
  :cargo (owl-and ch/proline (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportBranchedChainAminoAcid:SodiumSymporter
  :comment "GO:0015657"
  :across Membrane
  :cargo (owl-and ch/branched-chain_amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportCreatine:SodiumSymporter
  :comment "GO:0005309"
  :across Membrane
  :cargo (owl-and ch/creatine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAlanine:SodiumSymporter
  :comment "GO:0015655"
  :across Membrane
  :cargo (owl-and ch/alanine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGammaAminobutyricAcid:SodiumSymporter
  :comment "GO:0005332"
  :across Membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportNeutralAminoAcid:SodiumSymporter
  :comment "GO:0005295"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycine:SodiumSymporter
  :comment "GO:0015375"
  :across Membrane
  :cargo (owl-and ch/glycine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportMonocarboxylicAcid:SodiumSymporter
  :comment "GO:0015375"
  :across Membrane
  :cargo (owl-and ch/monocarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportPantothenate:SodiumSymporter
  :comment "GO:0015498"
  :across Membrane
  :cargo (owl-and ch/pantothenate (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/cofactor ch/vitamin))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportBileAcid:SodiumSymporter
  :comment "GO:0008508"
  :across Membrane
  :cargo (owl-and ch/bile_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportL-ascorbate:SodiumSymporter
  :comment "GO:0008520"
  :across Membrane
  :cargo (owl-and ch/L-ascorbate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportL-ascorbateWithSodiumCondition
  :comment "GO:0070890"
  :across Membrane
  :cargo ch/L-ascorbate
  :when ch/sodium_1+_)

(deftransport ToTransportTaurine:SodiumSymporter
  :comment "GO:0005369"
  :across Membrane
  :cargo (owl-and ch/taurine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportNucleoside:SodiumSymporter
  :comment "GO:0005415"
  :across Membrane
  :cargo (owl-and ch/nucleoside (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportPyrimidine-And-AdenineNucleobase:SodiumSymporter
  :comment "GO:0005415"
  :across Membrane
  :cargo (owl-and (owl-or ch/pyrimidine_nucleoside ch/adenine (owl-some hasConcentration LowConcentration)))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportMyo-inositol:SodiumSymporter
  :comment "GO:0005367"
  :across Membrane
  :cargo (owl-and ch/myo-inositol (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportBicarbonate:SodiumSymporter
  :comment "GO:0008510"
  :across Membrane
  :cargo (owl-and ch/hydrogencarbonate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; ==== Next is GO:0009674 =====


(deftransport ToTransportBicarbonate
  :comment "GO:0015106"
  :across Membrane
  :cargo ch/hydrogencarbonate)


(deftransport ToTransportNeutralAminoAcid
  :comment "GO:0015175"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral)))

(deftransport ToTransportAlanine
  :comment "GO:0022858"
  :across Membrane
  :cargo (owl-and ch/alanine (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-glutamine
  :comment "GO:0015186"
  :across Membrane
  :cargo (owl-and ch/L-glutamine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportNeutralL-AminoAcidSecondaryActive
  :comment "GO:0005294"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral) (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportBasicAminoAcid
  :comment "GO:0015174"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline)))

(deftransport ToTransportL-lysine
  :comment "GO:0015189"
  :across Membrane
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-histidine
  :comment "GO:0005290"
  :across Membrane
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug)))

(deftransport ToTransportBasicAminoAcidWithLowAffinity
  :comment "GO:0097625"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with LowAffinity)

(deftransport ToTransportArginine
  :comment "GO:0015181"
  :across Membrane
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline)))

(deftransport ToTransportBasicAminoAcidWithHighAffinity
  :comment "GO:0005287"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)


(deftransport ToTransportL-lysineEffluxTransmembrane
  :comment "GO:0015661"
  :across Membrane
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug))
  :from Intracellular
  :to ExtracellularRegion)

;;lysine(out) + cadaverine(in) = lysine(in) + cadaverine(out). 
;; (deftransport ToTransportLysine:CadaverineAntiporter
;;   :comment "GO:0043872"
;;   :across Membrane
;;   :cargo 


(deftransport ToTransportAcidicAminoAcid
  :comment "GO:0015172"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Acidic)))


 ;; substances transported with high and low affinities

(deftransport ToTransportPotassiumIonWithHighAffinity
  :comment "GO:0140107"
  :across Membrane
  :cargo ch/potassium_1+_
  :transports-with HighAffinity)

(deftransport ToTransportArginineWithHighAffinity
  :comment "GO:0005289"
  :across Membrane
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportL-histidineWithHighAffinity
  :comment "GO:0005291"
  :across Membrane
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportLysineWithHighAffinity
  :comment "GO:0005292"
  :across Membrane
  :cargo (owl-and ch/lysine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithHighAffinity
  :comment "GO:0000006"
  :across Membrane
  :cargo ch/zinc_2+_
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithLowAffinity
  :comment "GO:0000007"
  :across Membrane
  :cargo ch/zinc_2+_
  :transports-with LowAffinity)

(deftransport ToTransportGlutamateWithHighAffinity
  :comment "GO:0005314"
  :across Membrane
  :cargo (owl-and ch/glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter))
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithLowAffinity
  :comment "GO:0009673"
  :across Membrane
  :cargo ch/phosphate_ion
  :transports-with LowAffinity)

(deftransport ToTransportCopperIonWithHighAffinity
  :comment "GO:0015089"
  :across Membrane
  :cargo ch/copper_2+_
  :transports-with HighAffinity)

(deftransport ToTransportFerricIronIonWithLowAffinity
  :comment "GO:0015090"
  :across Membrane
  :cargo ch/iron_2+_
  :transports-with LowAffinity)

(deftransport ToTransportFerricIronIonWithHighAffinity
  :comment "GO:0015092"
  :across Membrane
  :cargo ch/iron_3+_
  :transports-with HighAffinity)

(deftransport ToTransportGlutamineWithHighAffinity
  :comment "GO:0015330"
  :across Membrane
  :cargo (owl-and ch/glutamine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportOligopeptideWithHighAffinity
  :comment "GO:0015334"
  :across Membrane
  :cargo ch/oligopeptide
  :transports-with HighAffinity)

(deftransport ToTransportTryptophanWithLowAffinity
  :comment "GO:0022893"
  :across Membrane
  :cargo ch/tryptophan
  :transports-with LowAffinity)

(deftransport ToTransportNickelCationWithHighAffinity
  :comment "GO:0044750"
  :across Membrane
  :cargo ch/nickel_cation
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithHighAffinity
  :comment "GO:0048249"
  :across Membrane
  :cargo ch/phosphate_ion
  :transports-with HighAffinity)

(deftransport ToTransportFructoseWithHighAffinity
  :comment "GO:0061486"
  :across Membrane
  :cargo ch/fructose
  :transports-with HighAffinity)

(deftransport ToTransportNitrateWithLowAffinity
  :comment "GO:0080054"
  :across Membrane
  :cargo ch/nitrate
  :transports-with LowAffinity)

(deftransport ToTransportL-arginineWithLowAffinity
  :comment "GO:0097626"
  :across Membrane
  :cargo (owl-and ch/L-arginine (owl-some has-application-role ch/drug))
  :transports-with LowAffinity)

(deftransport ToTransportL-ornithineWithHighAffinity
  :comment "GO:0097627"
  :across Membrane
  :cargo (owl-and ch/L-ornithine (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithHighAffinity
  :comment "GO:0005300"
  :across Membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithLowAffinity
  :comment "GO:0022893"
  :across Membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug))
  :transports-with LowAffinity)



(deftransport ToTransportIon
  :comment "GO:0015075"
  :across Membrane
  :cargo ch/ion)

;; ion A(out) + ion B(in) = ion A(in) + ion B(out) where ion A and ion B are different types of ion. 
(deftransport ToTransportIonAntiporter
  :comment "GO:0099516"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportAnion:AnionAntiporter
  :comment "GO:0015301"
  :across Membrane
  :cargo (owl-and ch/anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportFolate:AnionAntiporter
  :comment "GO:0008518"
  :across Membrane
  :cargo (owl-and ch/folic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportATP:ADPAntiporter
  :comment "GO:0005471"
  :across Membrane
  :cargo (owl-and ch/ATP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ADP (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGTP:GDPAntiporter
  :comment "GO:0010292"
  :across Membrane
  :cargo (owl-and ch/GTP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/GDP (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlutamate:Gamma-aminobutyricAcidAntiporter
  :comment "GO:0070909"
  :across Membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/glutamate_2-_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportTriosePhosphate:PhosphateAntiporter
  :comment "GO:0009670"
  :across Membrane
  :cargo (owl-and ch/glyceraldehyde_3-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportTriosePhosphate
  :comment "GO:0071917"
  :across Membrane
  :cargo ch/glyceraldehyde_3-phosphate)

(deftransport ToTransportOrganophosphate:InorganicPhosphateAntiporter
  :comment "GO:0015315"
  :across Membrane
  :cargo (owl-and ch/organic_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; need review
(deftransport ToTransportGlyceronePhosphate:InorganicPhosphateAntiporter
  :comment "GO:0051407"
  :across Membrane
  :cargo (owl-and ch/glycerone_phosphates (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlyceraldehyde3Phosphate:InorganicPhosphateAntiporter
  :comment "GO:0051408"
  :across Membrane
  :cargo (owl-and ch/glyceraldehyde_3-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlucose6Phosphate:PhosphateAntiporter
  :comment "GO:0008524"
  :across Membrane
  :cargo (owl-and ch/D-glucose_6-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportHexosePhosphate:InorganicPhosphateAntiporter
  :comment "GO:0015526"
  :across Membrane
  :cargo (owl-and ch/hexose_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlucose6Phosphate:InorganicPhosphateAntiporter
  :comment "GO:0061513"
  :across Membrane
  :cargo (owl-and ch/D-glucose_6-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlycerolPhosphate:InorganicPhosphateAntiporter
  :comment "GO:0015527"
  :across Membrane
  :cargo (owl-and ch/glycerol_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; maybe need review
(deftransport ToTransportXoglutarate:MalateAntiporter
  :comment "GO:0015367"
  :across Membrane
  :cargo (owl-and ch/_2-oxoglutaric_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/malate_2-_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Ref: http://europepmc.org/abstract/MED/21719707
;; need review
(deftransport ToTransportAspartate:AlanineAntiporter
  :comment "GO:0070906"
  :across Membrane
  :cargo (owl-and ch/alanine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral))
  :driven (owl-and ch/L-aspartate_2-_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; need review
(deftransport ToTransportCystine:GlutamateAntiporter
  :comment "GO:0015327"
  :across Membrane
  :cargo (owl-and ch/cystine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral))
  :driven (owl-and ch/glutamate_2-_ (owl-some hasConcentration HighConcentration)
                   (owl-some hasAcidity Acidic) (owl-some has-application-role ch/drug)
                   (owl-some has-biological-role ch/neurotransmitter))
  :direction OppositeDirection)

(deftransport ToTransportCitrate:SuccinateAntiporter
  :comment "GO:0015515"
  :across Membrane
  :cargo (owl-and ch/citrate_3-_ (owl-some has-biological-role ch/antimicrobial_agent)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)
                 (owl-some hasConcentration LowConcentration))
  :direction OppositeDirection)


(deftransport ToTransportIonInvolvedInRegulationOfPresynapticMembranePotentialAntiporter
  :comment "GO:0099520"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :involved PresynapticMembrane
  :occurs PresynapticMembrane
  :direction OppositeDirection)

(deftransport ToTransportIonInvolvedInRegulationOfPostsynapticMembranePotentialAntiporter
  :comment "GO:0099580"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :involved PostsynapticMembrane
  :occurs PostsynapticMembrane
  :direction OppositeDirection)

(deftransport ToTransportTetracycline:ProtonAntiporter
  :comment "GO:0015520"
  :across Membrane
  :cargo (owl-and ch/tetracycline (owl-some has-biological-role ch/antimicrobial_agent)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; cation A(out) + cation B(in) = cation A(in) + cation B(out). 
(deftransport ToTransportCationCationAntiporter
  :comment "GO:0015491"
  :across Membrane
  :cargo (owl-and ch/cation (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportFluconazole:ProtonAntiporter
  :comment "GO:0015313"
  :across Membrane
  :cargo (owl-and ch/fluconazole (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/antimicrobial_agent ch/xenobiotic))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;; ==== Next is GO:0044667 ====

(deftransport ToTransportTetracycline
  :comment "GO:0008493"
  :across Membrane
  :cargo (owl-and ch/tetracycline (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportAluminumIon
  :comment "GO:0015083"
  :across Membrane
  :cargo ch/aluminium_ion)

;; Positivel charged ions --> Cation
(deftransport ToTransportCation
  :comment "GO:0008324"
  :across  Membrane
  :cargo ch/cation)

(deftransport ToTransportOrganicCation
  :comment "GO:0015101"
  :across Membrane
  :cargo ch/organic_cation)

(deftransport ToTransportCadaverine
  :comment "GO:0015490"
  :across Membrane
  :cargo ch/cadaverine)

(deftransport ToTransportAmiloride
  :comment "GO:0015240"
  :across Membrane
  :cargo (owl-and ch/amiloride (owl-some has-application-role ch/drug)))

(deftransport ToTransportQuaternaryAmmoniumCompound
  :comment "GO:0015651"
  :across Membrane
  :cargo ch/quaternary_nitrogen_compound)

(deftransport ToTransportN-methylnicotinat
  :comment "GO:0090417"
  :across Membrane
  :cargo ch/N-methylnicotinate)

(deftransport ToTransportAcylCarnitine
  :comment "GO:0015227"
  :across Membrane
  :cargo ch/O-acylcarnitine)

(deftransport ToTransportOrganophosphateEster
  :comment "GO:0015605"
  :across Membrane
  :cargo ch/organic_phosphate)

(deftransport ToTransportGlycerol-3-phosphate
  :comment "GO:0015169"
  :across Membrane
  :cargo ch/sn-glycerol_3-phosphate)

(deftransport ToTransportAminoPhospholipid
  :comment "GO:0015247"
  :across Membrane
  :cargo ch/aminophospholipid)

(deftransport ToTransportHexosePhosphate
  :comment "GO:0015119"
  :across Membrane
  :cargo ch/hexose_phosphate)

;; Negatively charged ions --> Anion
(deftransport ToTransportAnion
  :comment "GO:0008509"
  :across Membrane
  :cargo ch/anion)

(deftransport ToTransportOrganicAnion
  :comment "GO:0008514"
  :across Membrane
  :cargo ch/organic_anion)

(deftransport ToTransportInorganicAnion
  :comment "GO:0015103"
  :across Membrane
  :cargo ch/inorganic_anion)

(deftransport ToTransportChromate
  :comment "GO:0015109"
  :across Membrane
  :cargo ch/chromate_2-_)

(deftransport ToTransportMolybdateIon
  :comment "GO:0015098"
  :across Membrane
  :cargo ch/molybdate)

(deftransport ToTransportChlorate
  :comment "GO:0015107"
  :across Membrane
  :cargo ch/chlorate)

(deftransport ToTransportAntimonite
  :comment "GO:0015104"
  :across Membrane
  :cargo ch/antimonite)

(deftransport ToTransportBorateEfflux
  :comment "GO:0080139"
  :across Membrane
  :cargo (owl-and ch/borate (owl-some has-application-role ch/drug))
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportTungstate
  :comment "GO:1901237"
  :across Membrane
  :cargo ch/tungstate)

(deftransport ToTransportTellurite
  :comment "GO:0015654"
  :across Membrane
  :cargo ch/tellurite)

(deftransport ToTransportIodide
  :comment "GO:0015111"
  :across Membrane
  :cargo ch/iodide)

(deftransport ToTransportNitrate
  :comment "GO:0015112"
  :across Membrane
  :cargo ch/nitrate)

(deftransport ToTransportNitrite
  :comment "GO:0015113"
  :across Membrane
  :cargo ch/nitrite)

(deftransport ToTransportNitriteEfflux
  :comment "GO:0015514"
  :across Membrane
  :cargo ch/nitrite
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportInorganicDiphosphate
  :comment "GO:0030504"
  :across Membrane
  :cargo ch/diphosphate_ion)

(deftransport ToTransportPhosphateIon
  :comment "GO:0015114"
  :across Membrane
  :cargo ch/phosphate_ion)

(deftransport ToTransportSilicate
  :comment "GO:0015115"
  :across Membrane
  :cargo ch/silicate_ion)

(deftransport ToTransportActiveBorate
  :comment "GO:0046715"
  :across Membrane
  :cargo (owl-and ch/borate (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportFluoride
  :comment "GO:1903425"
  :across Membrane
  :cargo ch/fluoride)

(deftransport ToTransportChromiumIon
  :comment "GO:0070835"
  :across Membrane
  :cargo ch/chromium_ion)

(deftransport ToTransportLeadIon
  :comment "GO:0015094"
  :across Membrane
  :cargo ch/lead_ion)

(deftransport ToTransportL-tryptophan
  :comment "GO:0015196"
  :across Membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportSalt
  :comment "GO:1901702"
  :across Membrane
  :cargo (owl-and ch/salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportTartrate
  :comment "GO:0015554"
  :across Membrane
  :cargo (owl-and ch/tartrate_salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportUrate
  :comment "GO:0015143"
  :across Membrane
  :cargo (owl-and ch/urate_salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportL-threonine
  :comment "GO:0015195"
  :across Membrane
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

;; I changed threonine to L-threonine
;; threonine not subclass of L-threonine (see nizal_notes.org)
(deftransport ToTransportL-threonineEfflux
  :comment "GO:0015565"
  :across Membrane
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportOrganicHydroxyCompound
  :comment "GO:1901618"
  :across Membrane
  :cargo ch/organic_hydroxy_compound)


(deftransport ToTransport3-HydroxyphenylPropanoate
  :comment "GO:0015551"
  :across Membrane
  :cargo  ch/_3-hydroxyphenyl_propanoate)

(deftransport ToTransportPolyol
  :comment "GO:0015166"
  :across Membrane
  :cargo ch/polyol)

(deftransport ToTransportMannitol
  :comment "GO:0015575"
  :across Membrane
  :cargo ch/mannitol)

(deftransport ToTransportPropanediol
  :comment "GO:0015170"
  :across Membrane
  :cargo ch/propanediol)

(deftransport ToTransportMyo-inositol
  :comment "GO:0005365"
  :across Membrane
  :cargo ch/myo-inositol)

(deftransport ToTransportGlucosylglycerol
  :comment "GO:0051474"
  :across Membrane
  :cargo ch/glucosylglycerol)

(deftransport ToTransportGlucitol
  :comment "GO:0015576"
  :across Membrane
  :cargo ch/glucitol)

(deftransport ToTransportArabinitol
  :comment "GO:0015167"
  :across Membrane
  :cargo ch/arabinitol)

(deftransport ToTransportGlycerol
  :comment "GO:0015168"
  :across Membrane
  :cargo ch/glycerol)

(deftransport ToTransportChloramphenicol
  :comment "GO:0042896"
  :across Membrane
  :cargo (owl-and ch/chloramphenicol (owl-some has-biological-role ch/antineoplastic_agent)))


(deftransport ToTransportAlchohol
  :comment "GO:0015665"
  :across Membrane
  :cargo  ch/alcohol)

(deftransport ToTransportRetinol
  :comment "GO:0034632"
  :across Membrane
  :cargo (owl-and ch/retinol (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportSalicin
  :comment "GO:0042950"
  :across Membrane
  :cargo (owl-and ch/salicin (owl-some has-application-role ch/drug)))

(deftransport ToTransportCycloheximide
  :comment "GO:0015243"
  :across Membrane
  :cargo (owl-and ch/cycloheximide (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportAmmoniumIon
  :comment "GO:0008519"
  :across Membrane
  :cargo ch/ammonium_ion)

(deftransport ToTransportEthanolamine
  :comment "GO:0034228"
  :across Membrane
  :cargo ch/ethanolamine)

(deftransport ToTransportSpermidine
  :comment "GO:0015606"
  :across Membrane
  :cargo ch/spermidine)

;; vitamin B6 compounds, pyridoxal, pyridoxamine and pyridoxine and the active form, pyridoxal phosphate
(deftransport ToTransportVitaminB6
  :comment "GO:0031924"
  :across Membrane
  :cargo (owl-and ch/vitamin_B6 (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportPyridoxal
  :comment "GO:0031925"
  :across Membrane
  :cargo (owl-and ch/pyridoxal (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin ch/cofactor)))

(deftransport ToTransportPyridoxalPhosphate
  :comment "GO:0031926"
  :across Membrane
  :cargo (owl-and ch/pyridoxal_5'-phosphate (owl-some has-application-role ch/vitamin_B6) (owl-some has-biological-role ch/vitamin ch/coenzyme)))

(deftransport ToTransportPyridoxamine
  :comment "GO:0031927"
  :across Membrane
  :cargo (owl-and ch/pyridoxamine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportPyridoxine
  :comment "GO:0031928"
  :across Membrane
  :cargo (owl-and ch/pyridoxine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin ch/cofactor)))

(deftransport ToTransportSphingosine
  :comment "GO:0010175"
  :across Membrane
  :cargo ch/sphingosine)

(deftransport ToTransportPutrescine
  :comment "GO:0015489"
  :across Membrane
  :cargo ch/putrescine)

(deftransport ToTransportAcetylcholine
  :comment "GO:0005277"
  :across Membrane
  :cargo (owl-and ch/acetylcholine (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportAcetylcholineProtonAntiporter
  :comment "GO:0005278"
  :across Membrane
  :cargo (owl-and ch/acetylcholine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportMethylammonium
  :comment "GO:0015200"
  :across Membrane
  :cargo ch/methylammonium)

(deftransport ToTransportCholine
  :comment "GO:0015220"
  :across Membrane
  :cargo (owl-and ch/choline (owl-some has-biological-role ch/neurotransmitter)))


(deftransport ToTransportL-methionine
  :comment "GO:0015191"
  :across Membrane
  :cargo (owl-and ch/L-methionine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-methionineSecondaryActiveTransmembrane
  :comment "GO:0000102"
  :across Membrane
  :cargo (owl-and ch/L-methionine (owl-some hasConcentration LowConcentration)  (owl-some hasAcidity Neutral) (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportGlycerophosphodiester
  :comment "GO:0001406"
  :across Membrane
  :cargo ch/glycerol_1-phosphodiester)

(deftransport ToTransportBetaAlanine
  :comment "GO:0001761"
  :across Membrane
  :cargo (owl-and ch/beta-alanine (owl-some hasAcidity Neutral) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportGlycine
  :comment "GO:0015187"
  :across Membrane
  :cargo (owl-and ch/glycine (owl-some hasAcidity Neutral) (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/neurotransmitter)))
  
(deftransport ToTransportNitricOxide
  :comment "GO:0030184"
  :across Membrane
  :cargo (owl-and ch/nitric_oxide (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportGammaAminobutyricAcid
  :comment "GO:0015185"
  :across Membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportL-glutamate
  :comment "GO:0005313"
  :across Membrane
  :cargo (owl-and ch/L-glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportL-aspartate
  :comment "GO:0015183"
  :across Membrane
  :cargo (owl-and ch/L-aspartate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportOrganicAcid
  :comment "GO:0005342"
  :across Membrane
  :cargo ch/organic_acid)

(deftransport ToTransportTaurine
  :comment "GO:0005368"
  :across Membrane
  :cargo (owl-and ch/taurine (owl-some has-biological-role ch/xenobiotic)))

(deftransport ToTransportArsenateIon
  :comment "GO:1901683"
  :across Membrane
  :cargo ch/arsenate_ion)

(deftransport ToTransportCarboxylicAcid
  :comment "GO:0046943"
  :across Membrane
  :cargo ch/carboxylic_acid)

(deftransport ToTransportGibberellin
  :comment "GO:1905201"
  :across Membrane
  :cargo ch/gibberellin)

(deftransport ToTransportSialicAcid
  :comment "GO:0015136"
  :across Membrane
  :cargo ch/sialic_acid)

(deftransport ToTransportDicarboxylicAcid
  :comment "GO:0005310"
  :across Membrane
  :cargo ch/dicarboxylic_acid)

(deftransport ToTransportAlphaKetoglutarate
  :comment "GO:0015139"
  :across Membrane
  :cargo (owl-and ch/_2-oxoglutarate_2-_ (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportBilirubin
  :comment "GO:0015127"
  :across Membrane
  :cargo ch/bilirubin)

(deftransport ToTransportC4-dicarboxylate
  :comment "GO:0015556"
  :across Membrane
  :cargo ch/C4-dicarboxylate)

(deftransport ToTransportMalate
  :comment "GO:0015140"
  :across Membrane
  :cargo ch/malate_2-_)

(deftransport ToTransportFumarate
  :comment "GO:0015138"
  :across Membrane
  :cargo ch/fumarate_2-_)

(deftransport ToTransportSuccinate
  :comment "GO:0015141"
  :across Membrane
  :cargo (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)))

(deftransport ToTransportOxaloacetate
  :comment "GO:0015131"
  :across Membrane
  :cargo ch/oxaloacetate_2-_)

(deftransport ToTransportIronChelate
  :comment "GO:0015603"
  :across Membrane
  :cargo ch/iron_chelate)

(deftransport ToTransportFerrichrome
  :comment "GO:0042929"
  :across Membrane
  :cargo ch/ferrichrome)

;; need review
(deftransport ToTransportIronNicotianamine
  :comment "GO:0051980"
  :across Membrane
  :cargo ch/nicotianamine)

(deftransport ToTransportFerricVibriobactin
  :comment "GO:0019535"
  :across Membrane
  :cargo ch/ferric-vibriobactin)

(deftransport ToTransportChrysobactin
  :comment "GO:0042933"
  :across Membrane
  :cargo (owl-and ch/chrysobactin (owl-some has-biological-role ch/siderophore)))

(deftransport ToTransportAchromobactin
  :comment "GO:0042934"
  :across Membrane
  :cargo (owl-and ch/achromobactin (owl-some has-biological-role ch/siderophore)))

(deftransport ToTransportEnterobactin
  :comment "GO:0042931"
  :across Membrane
  :cargo (owl-and ch/enterobactin (owl-some has-biological-role ch/siderophore)))

(deftransport ToTransportFerricEnterobactin:ProtonSymporter
  :comment "GO:0015345"
  :across Membrane
  :cargo (owl-and ch/ferrienterobactin (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportFerricEnterobactin
  :comment "GO:0015620"
  :across Membrane
  :cargo ch/ferrienterobactin)

;; need review
(deftransport ToTransportSiderophoreIronFerrioxamine
  :comment "GO:0015344"
  :across Membrane
  :cargo ch/ferrioxamine_B)

(deftransport ToTransportFerricHydroxamate
  :comment "GO:0015622"
  :across Membrane
  :cargo ch/iron_III__hydroxamate)

(deftransport ToTransportmalonate_1-
  :comment "GO:1901239"
  :across Membrane
  :cargo ch/malonate_1-_)

;; (deftransport ToTransportIsopropylmalate
;;   :comment "GO:0034658"
;;   :across Membrane
;;   :cargo 

(deftransport ToTransportOxalate
  :comment "GO:0019531"
  :across Membrane
  :cargo ch/oxalate)

(deftransport ToTransportTricarboxylicAcid
  :comment "GO:0015142"
  :across Membrane
  :cargo ch/tricarboxylic_acid)

(deftransport ToTransportCitrate
  :comment "GO:0015137"
  :across Membrane
  :cargo (owl-and ch/citrate_3-_ (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportIcosanoid
  :comment "GO:0071714"
  :across Membrane
  :cargo ch/icosanoid)

(deftransport ToTransportProstaglandin
  :comment "GO:0015132"
  :across Membrane
  :cargo ch/prostaglandin)

(deftransport ToTransportArachidonate
  :comment "GO:1903962"
  :across Membrane
  :cargo ch/arachidonate)

(deftransport ToTransportGlucuronoside
  :comment "GO:0015164"
  :across Membrane
  :cargo ch/glucosiduronic_acid)

(deftransport ToTransportMonocarboxylicAcid
  :comment "GO:0008028"
  :across Membrane
  :cargo ch/monocarboxylic_acid)

(deftransport ToTransportPyruvate
  :comment "GO:0050833"
  :across Membrane
  :cargo ch/pyruvate)

(deftransport ToTransportHydroxyectoine
  :comment "GO:0033287"
  :across Membrane
  :cargo ch/_5-hydroxyectoine)

(deftransport ToTransportBenzoate
  :comment "GO:0042925"
  :across Membrane
  :cargo (owl-and ch/benzoate (owl-some has-biological-role  ch/antimicrobial_agent   ch/human_xenobiotic_metabolite)))

(deftransport ToTransportAldonate
  :comment "GO:0042879"
  :across Membrane
  :cargo ch/aldonate)

(deftransport ToTransportPhosphoglycerate
  :comment "GO:0015120"
  :across Membrane
  :cargo ch/phosphoglycerate)

(deftransport ToTransportD-Galactonate
  :comment "GO:0042881"
  :across Membrane
  :cargo (owl-and ch/D-galactonate (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportL-idonate
  :comment "GO:0015568"
  :across Membrane
  :cargo (owl-and ch/L-idonate (owl-some hasEnantiomerism L-Enantiomer) (owl-some derived-from ch/L-idose)))

(deftransport ToTransportGlycerate
  :comment "GO:1901974"
  :across Membrane
  :cargo ch/glycerate)

(deftransport ToTransportGluconate
  :comment "GO:0015128"
  :across Membrane
  :cargo (owl-and ch/gluconate (owl-some derived-from ch/glucose)))

(deftransport ToTransport3-HydroxyphenylpropionicAcid
  :comment "GO:0042926"
  :across Membrane
  :cargo (owl-and ch/_3-_3-hydroxyphenyl_propanoic_acid (owl-some has-biological-role ch/human_xenobiotic_metabolite)))

(deftransport ToTransportAbscisicAcid
  :comment "GO:0090440"
  :across Membrane
  :cargo ch/abscisic_acids)

(deftransport ToTransportL-asparagine
  :comment "GO:0015182"
  :across Membrane
  :cargo (owl-and ch/L-asparagine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportPhosphoenolpyruvate
  :comment " GO:0089721"
  :across Membrane
  :cargo ch/phosphoenolpyruvate)

(deftransport ToTransport3-PhenylpropionicAcid
  :comment "GO:0042890"
  :across Membrane
  :cargo (owl-and ch/_3-phenylpropionic_acid (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportNalidixicAcid
  :comment "GO:0015547"
  :across Membrane
  :cargo (owl-and ch/nalidixic_acid (owl-some has-biological-role ch/antimicrobial_agent ch/xenobiotic)))

(deftransport ToTransportGlycolicAcid
  :comment "GO:0043879"
  :across Membrane
  :cargo (owl-and ch/glycolic_acid (owl-some has-application-role ch/drug)))

(deftransport ToTransportAcetate
  :comment "GO:0015123"
  :across Membrane
  :cargo (owl-and ch/acetate (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportBileAcid
  :comment "GO:0015125"
  :across Membrane
  :cargo ch/bile_acid)

(deftransport ToTransportNicotine
  :comment "GO:0090416"
  :across Membrane
  :cargo (owl-and ch/nicotine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportLactate
  :comment "GO:0015129"
  :across Membrane
  :cargo ch/lactate)

(deftransport ToTransportBiotin
  :comment "GO:0015225"
  :across Membrane
  :cargo (owl-and ch/biotin (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/coenzyme ch/B_vitamin)))

(deftransport ToTransportFattyAcid
  :comment "GO:0015245"
  :across Membrane
  :cargo ch/fatty_acid)

(deftransport ToTransportR-3-hydroxybutyrate
  :comment "GO:0097253"
  :across Membrane
  :cargo (owl-and ch/_R_-3-hydroxybutyrate (owl-some has-application-role ch/drug)))


;; Passive transport (not complete)
(deftransport ToTransportLongChainFattyAcidPorin
  :comment "GO:0015483"
  :across Membrane
  :cargo ch/long-chain_fatty_acid)

(deftransport ToTransportShortChainFattyAcid
  :comment "GO:0015636"
  :across Membrane
  :cargo ch/short-chain_fatty_acid)

(deftransport ToTransportLongChainFattyAcid
  :comment "GO:0005324"
  :across Membrane
  :cargo ch/long-chain_fatty_acid)

(deftransport ToTransportOleate
  :comment "GO:1901480"
  :across Membrane
  :cargo ch/oleate)

(deftransport ToTransportFormate
  :comment "GO:0015499"
  :across Membrane
  :cargo (owl-and ch/formate (owl-some has-biological-role ch/antimicrobial_agent)))

(deftransport ToTransportFormateEfflux
  :comment "GO:0015660"
  :across Membrane
  :cargo (owl-and ch/formate (owl-some has-biological-role ch/antimicrobial_agent))
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportEctoine
  :comment "GO:0051471"
  :across Membrane
  :cargo ch/ectoine)

(deftransport ToTransportShikimate
  :comment "GO:0015530"
  :across Membrane
  :cargo ch/shikimate)

(deftransport ToTransport4-Hydroxyphenylacetate
  :comment "GO:1901241"
  :across Membrane
  :cargo ch/_4-hydroxyphenylacetate)

(deftransport ToTransportMevalonate
  :comment "GO:0015130"
  :across Membrane
  :cargo ch/mevalonate)

(deftransport ToTransportMannosylglycerate
  :comment "GO:0051477"
  :across Membrane
  :cargo ch/D-mannosyl-D-glyceric_acid)

(deftransport ToTransportLactone
  :comment "GO:0042971"
  :across Membrane
  :cargo ch/lactone)

(deftransport ToTransportOrganicPhosphonate
  :comment "GO:0015604"
  :across Membrane
  :cargo ch/organic_phosphonate)

(deftransport ToTransportAlkylphosphonate
  :comment "GO:0042917"
  :across Membrane
  :cargo ch/alkylphosphonate)

;; There is no metal ion in CHEBI
(deftransport ToTransportMetalIon
  :comment "GO:0046873"
  :across Membrane
  :cargo ch/metal_cation)

(deftransport ToTransportCalciumIon
  :comment "GO:0015085"
  :across Membrane
  :cargo ch/calcium_ion)

(deftransport ToTransportTransitionMetalIon
  :comment "GO:0046915"
  :across Membrane
  :cargo ch/transition_element_cation)

(deftransport ToTransportVanadiumIon
  :comment "GO:0015100"
  :across Membrane
  :cargo ch/vanadium_cation)

(deftransport ToTransportIronIon
  :comment "GO:0005381"
  :across Membrane
  :cargo ch/iron_2+_)

(deftransport ToTransportManganeseIon
  :comment "GO:0005384"
  :across Membrane
  :cargo ch/manganese_2+_)

(deftransport ToTransportMolybdenumIon
  :comment "GO:0042888"
  :across Membrane
  :cargo ch/molybdenum_cation)

(deftransport ToTransportSilverIon
  :comment "GO:0015080"
  :across Membrane
  :cargo ch/silver_cation)

;; === Next is 

(deftransport ToTransportPolyamine
  :comment "GO:0015203"
  :across Membrane
  :cargo ch/polyamine)

(deftransport ToTransportPolyamine:ProtonAntiporter
  :comment "GO:0015312"
  :across Membrane
  :cargo (owl-and ch/polyamine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportSpermine
  :comment "GO:0000297"
  :across Membrane
  :cargo (owl-and ch/spermine (owl-some has-application-role ch/drug)))

(deftransport ToTransportChloride
  :comment "GO:0015108"
  :across Membrane
  :cargo ch/chloride)

(deftransport ToTransportWithChemicalCondition
  :across Membrane
  :cargo ch/chemical_entity
  :when ch/chemical_entity)

(deftransport ToTransportPhosphateWithSodiumCondition
  :comment "GO:0015321"
  :across Membrane
  :cargo ch/phosphate_ion
  :when ch/sodium_1+_)

 

(deftransport ToTransportBicozamycin
  :comment "GO:0015545"
  :across Membrane
  :cargo (owl-and ch/bicozamycin (owl-some has-biological-role ch/bicozamycin)))






;; A substance or substances transported either from the inside of the cell to the outside and and vice versa.
;; Driven by ATPase
(defn substance-transporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some ~(nth lis 3) ~(nth lis 4)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven ATPase
     :across Membrane
     :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular)))))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-ATPase [& lis]
  `(do ~@(map substance-transporting-ATPase lis)))

;; Substances driven by ATPase (transporting)
(deftransporters-drivenby-ATPase
  [""                       	"GO:0042626"    ch/chemical_entity]
  ["Thiamine"			"GO:0048502"	ch/thiamine]
  ["Beta-glucan"		"GO:0015441"	ch/beta-D-glucan]
  ["Ion"			"GO:0042625"	ch/ion]
  ["Cation"                 	"GO:0019829"    ch/cation]
  ["Ferric"                 	"GO:0015408"    ch/iron_3+_]
  ["Calcium"                	"GO:0005388"    ch/calcium_2+_ ]
  ["Potassium"              	"GO:0008556"    ch/potassium_1+_ ]
  ["Copper"                 	"GO:0043682"    ch/copper_2+_ ]
  ["Cobalt"			"GO:0032778"	ch/cobalt_cation]
  ["Arsenite"			"GO:0015446"	ch/arsenate_ion]
  ["Manganese"              	"GO:0015410"    ch/manganese_2+_]
  ["Nickel"			"GO:0015413"	ch/nickel_2+_]
  ["Lipid"			"GO:0034040"	ch/lipid]
  ["Lipopolysaccharide"	"GO:0015437"	ch/lipopolysaccharide]
  ["Sterol"			"GO:0034041"	ch/sterol]
  ["3-5CyclicGMP"		"GO:1905948"	ch/_3'_5'-cyclic_GMP] 
  ["Anion"			"GO:0043225"	ch/anion]
  ["Antimonite"		"GO:0042961"	ch/antimonite]
  ["Sulfate"			"GO:0015419"	ch/sulfate]
  ["Molybdate"			"GO:0015412"	ch/molybdate]
  ["Tungstate"			"GO:1901238"	ch/tungstate]
  ["OrganicPhosphonate"	"GO:0015416"	ch/organic_phosphonate]
  ["Alkylphosphonate"		"GO:0102017"	ch/alkylphosphonate]
  ["Chloride"               	"GO:0008555"    ch/chloride]
  ["Nitrate"			"GO:0015414"	ch/nitrate]
  ["PhosphateIon"		"GO:0015415"	ch/phosphate_ion]
  ["FerricDicitrate"		"GO:0102026"	ch/iron_III__dicitrate]
  ["ProtohemeIX"		"GO:0103115"	ch/heme_b]
  ["Alpha-D-Galactofuranose"	"GO:0103116"	ch/UDP-alpha-D-galactofuranose] 	;; Not entirely sure
  ["Phospholipid"           	"GO:0004012"    ch/phospholipid ]
  ["Glycerol-3Phosphate"	"GO:0015430"	ch/sn-glycerol_3-phosphate]
  ["GlutathioneS-conjugate" 	"GO:0071997"	ch/glutathione_conjugate]		;; linked to broad term in ChEBI
  ["Glycerol-2-phosphate"	"GO:0070812"	ch/glycerol_2-phosphate]
  ["LipoChitinOligosaccharide" "GO:1901514" 	ch/lipo-chitin_oligosaccharide]
  ["QuaternaryAmine"		"GO:0102908"	ch/quaternary_ammonium_ion]		;; are they the same?
  ["QuaternaryAmmoniumCompound" "GO:0015418"	ch/quaternary_ammonium_salt]
  ["Choline"			"GO:0033266"	ch/choline		has-biological-role ch/neurotransmitter]
  ["Guanine"                	"GO:0008558"    ch/guanine]
  ["Heme"			"GO:0015439"	ch/heme		has-biological-role ch/cofactor]
  ["Carbohydrate"		"GO:0043211"	ch/carbohydrate]
  ["Oligosaccharide"		"GO:0015422"	ch/oligosaccharide]
  ["Oligogalacturonide"	"GO:0033154"	ch/oligogalacturonide]
  ["Maltose"			"GO:0015423"	ch/maltose]
  ["Monosaccharide"         	"GO:0015407"    ch/monosaccharide]
  ["Rhamnose"			"GO:0033297"	ch/rhamnose]
  ["Polyamine"			"GO:0015417"	ch/polyamine]
  ["Amide"			"GO:0033220"	ch/amide]
  ["Peptide"			"GO:0015440"	ch/peptide]
  ["Oligopeptide"		"GO:0015421"	ch/oligopeptide]
  ["OrganicAcid"		"GO:0033283"	ch/organic_acid]
  ["Taurine"                	"GO:0015411"    ch/taurine 		has-biological-role ch/xenobiotic]   ;; xenobiotic or  EC_3.6.3.44  is it a drug?
  ["CarboxylicAcid"		"GO:0033284"	ch/carboxylic_acid]
  ["AminoAcid"			"GO:0015424"	ch/amino_acid]
  ["NonpolarAminoAcid"		"GO:0015425"	ch/nonpolar_amino_acid]
  ["PolarAminoAcid"		"GO:0015426"	ch/polar_amino_acid]
  ["Urea"			"GO:0033221"	ch/urea]
  ["Doxorubicin"		"GO:1901242"	ch/doxorubicin		has-biological-role ch/antimicrobial_agent]
  ["Daunorubicin"		"GO:0043216"	ch/daunorubicin	has-application-role ch/drug]
  ["PeptideAntigen"		"GO:0015433"	ch/peptide 		has-biological-role ch/antigen]
  ["Xenobiotic"		"GO:0008559"	ch/chemical_entity	has-biological-role ch/xenobiotic]
  ["QuaternaryAmmoniumIon"  	"GO:0015418"	ch/quaternary_ammonium_ion]
  ["Cadmium"			"GO:0015434"	ch/cadmium_cation]
  ["CapsularPolysaccharide" 	"GO:0015436"	ch/polysaccharide]
  ["TeichoicAcid"		"GO:0015438"	ch/teichoic_acid]
  ["Protein"			"GO:0015462"	ch/protein]
  ["ThiaminePyrophosphate"	"GO:0015619"	ch/thiamine_1+__diphosphate_1-_]
  ["iron-chelate"		"GO:0015623"	ch/iron_chelate]
  ["FerricEnterobactin"	"GO:0015624"	ch/ferrienterobactin]
  ["FerricHydroxamate"		"GO:0015625"	ch/iron_III__hydroxamate]
  ["Zinc"			"GO:0015633"	ch/zinc_2+_]
  ["Amine"			"GO:0031263"	ch/amine]
  ["Betaine"			"GO:0031458"	ch/glycine_betaine]
  ["GlycineBetaine"		"GO:0031459"	ch/glycine_betaine]
  ["Thiosulfate"		"GO:0102025"	ch/thiosulfate]
  ["2-aminoethylphosphonate"	"GO:0033225"	ch/_2-aminoethyl_phosphonic_acid]
  ["Cysteine"			"GO:0033230"	ch/cysteine]
  ["D-methionine"		"GO:0033232"	ch/D-methionine]
  ["MonocarboxylicAcid"	"GO:0033285"	ch/monocarboxylic_acid]
  ["Ectoine"			"GO:0033286"	ch/ectoine]
  ["Hydroxyectoine"		"GO:0033288"	ch/_5-hydroxyectoine]
  ["Bacteriocin"		"GO:0043214"	ch/bacteriocin]
  ["Methionine"		"GO:1901243"	ch/methionine])


;; ATP + H2O + cob(III)alamin(out) = ADP + phosphate + cob(III)alamin(in).
;; Cobalamin is also known as vitamin B12. 
(deftransport ToTransportCobalaminTransportingDrivenWithATPase
  :comment "GO:0015420"
  :cargo (owl-and ch/cobalamin (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin ch/cofactor))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))


;; ATP + H2O + ion(in) = ADP + phosphate + ion(out), by a rotational mechanism. 
(deftransport ToTransportIonsTransportingDrivenWithATPaseViaRotationalMechanism.
  :comment "GO:0044769"
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))

(deftransport ToTransportIonsTransportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0015662"
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Phosphorylative
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))


(deftransport ToTransportProtonTransportingDrivenWithATPaseViaRotationalMechanism.
  :comment "GO:0046961"
  :cargo (owl-and ch/proton (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))


(deftransport ToTransportSodiumTransportingDrivenWithATPase
  :comment "GO:0046962"
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))

;; ATP(4-) + cob(I)alamin + H2O <=> ADP(3-) + hydrogenphosphate + cob(I)alamin + H+
(deftransport ToTransportCobIalaminDrivenWithATPase
  :comment "GO:0102023"
  :cargo (owl-and ch/cob_I_alamin (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/B_vitamin))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))

(deftransport ToTransportProteinIntoMitochondrionDrivenWithATPase
  :comment "GO:0008566"
  :cargo ch/protein
  :driven ATPase
  :from ExtracellularRegion
  :to Intracellular Mitochondrion)

(deftransport ToTransportProteinIntoChloroplastStromaDrivenWithATPase
  :comment "GO:0016464"
  :cargo ch/protein
  :driven ATPase
  :from ExtracellularRegion
  :to Intracellular Chloroplast)

;; ATP + H2O + Na+(in) + K+(out) = ADP + phosphate + Na+(out) + K+(in). 
(deftransport ToTransportSodiumPotassiumExchangingDrivenWithATPase
  :comment "GO:0005391"
  :cargo (owl-and ch/sodium_1+_ ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))

(deftransport ToTransportPotassiumProtonExchangingDrivenWithATPase
  :comment "GO:0008900"
  :cargo (owl-and ch/potassium_1+_ ch/proton (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))



; map values
(defexporters-drivenby-ATPase
      ["Copper"			"GO:0004008"	ch/copper_2+_]
      ["Cadmium"			"GO:0008551"    ch/cadmium_2+_]
      ["Proton"			"GO:0036442"	ch/proton]
      ["Protein"			"GO:0008564"	ch/protein]
      ["GlutathioneS-conjugate" 	"GO:0071997"	ch/glutathione_conjugate]
      ["BileAcid"			"GO:0015432"	ch/bile_acid]
      ["Silver"			"GO:0015445"	ch/silver_1+_]
      ["Zinc"				"GO:0016463"	ch/zinc_2+_]
      ["AminoAcid"			"GO:0032518"	ch/amino_acid]
      ["Cysteine"			"GO:0032519"	ch/cysteine]
      ["D-methionine"			"GO:0032521"	ch/D-methionine]
      ["Carbohydrate"			"GO:0043212"	ch/carbohydrate]
      ["GlucosylOleandomycin"		"GO:0103113"	ch/oleandomycin]  ;; Not entirely sure
      )

(deftransport ToTransportProtonExportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0008553"
  :cargo ch/proton
  :driven ATPase
  :across Membrane
  :from Intracellular
  :to ExtracellularRegion
  :mechanism Phosphorylative)

(deftransport ToTransportSodiumExportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0008554"
  :cargo ch/sodium_1+_
  :driven ATPase
  :from Intracellular
  :to ExtracellularRegion
  :mechanism Phosphorylative)

; map values
(defimporters-drivenby-ATPase
      ["Magnesium"			"GO:0015444"	ch/magnesium_2+_ ]
      ["Putrescine"			"GO:0015594"	ch/putrescine]
      ["Spermidine"			"GO:0015595"	ch/spermidine]
      ["Carbohydrate"			"GO:0015608"	ch/carbohydrate]
      ["Maltooligosaccharide"		"GO:0015609"	ch/maltooligosaccharide]
      ["GlycerolPhosphate"		"GO:0015610"	ch/sn-glycerol_3-phosphate]
      ["D-allose"			"GO:0015615"	ch/D-allose]
      ["AminoAcid"			"GO:0032520"	ch/amino_acid]
      ["D-methionine"			"GO:0032522"	ch/D-methionine]
      ["L-glutamate"			"GO:0102013"	ch/L-glutamate_1-_]
      ["Beta-D-galactose"		"GO:0102014"	ch/beta-D-galactoside])



(deftransport ToTransportGlutamineImportingDrivenWithATPase
  :comment "GO:0015599"
  :driven ATPase
  :across Membrane
  :cargo (owl-and ch/glutamine (owl-some hasConcentration LowConcentration) (owl-some has-application-role ch/drug)
                  (owl-some hasAcidity Neutral))
  :from ExtracellularRegion
  :to Intracellular)


(deftransport ToTransportArginineImportingDrivenWithATPase
  :comment "GO:0015598"
  :cargo (owl-and ch/arginine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Alkaline))
  :driven ATPase
  :across Membrane
  :from ExtracellularRegion
  :to Intracellular)

(deftransport ToTransportL-arginineImportingDrivenWithATPase
  :comment "GO:0102022"
  :cargo (owl-and ch/L-arginine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug))
  :driven ATPase
  :across Membrane
  :from ExtracellularRegion
  :to Intracellular)

(deftransport ToTransportD-riboseImportingDrivenWithATPase
  :comment "GO:0015611"
  :cargo (owl-and ch/D-ribose (owl-some hasConcentration LowConcentration)
                  (owl-some hasEnantiomerism D-Enantiomer))
  :driven ATPase
  :across Membrane
  :from ExtracellularRegion
  :to Intracellular)


(deftransport ToTransportD-xyloseImportingDrivenWithATPase
  :comment "GO:0015614"
  :cargo (owl-and ch/D-xylose (owl-some hasConcentration LowConcentration)
                  (owl-some hasEnantiomerism D-Enantiomer))
  :driven ATPase
  :across Membrane
  :from ExtracellularRegion
  :to Intracellular)

(deftransport ToTransportL-arabinoseImportingDrivenWithATPase
  :comment "GO:0015612"
  :cargo (owl-and ch/L-arabinose (owl-some  hasConcentration LowConcentration)
                  (owl-some hasEnantiomerism L-Enantiomer))
  :driven ATPase
  :across Membrane
  :from  ExtracellularRegion
  :to  Intracellular)



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


(save-ontology "hyper-go.owl" :owl)

;; ;; (require 'tawny.reasoner)
;; ;; (tawny.reasoner/reasoner-factory :hermit)
;; ;; (tawny.reasoner/reasoner-factory :elk)

;; ;; (subclass? ToTransport ToTransportCation)
;; ;; (subclass? ToTransportCation ToTransport)

;; ;; (tawny.reasoner/isubclass? ToTransportCation ToTransportCationDrivenWithATPase)
;; ;; (tawny.reasoner/isubclass? ToTransportCation ToTransport)


;; ;; (tawny.reasoner/isubclass? ToTransportChloride ToTransportAnion)
;; ;; (tawny.reasoner/isubclass? ToTransportAnion ToTransportChloride)

;; ;; (subclass? ch/chloride ch/cation)
