(ns hyper-go.go
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [hyper-go.core :refer :all]
            [tawny.emacs  :refer :all]
            [tawny.query  :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))


(ontology-to-namespace hyper-go.core/HyperGo)

(deftransport ToTransport
  :comment "GO:0005215"
  :cargo ch/chemical_entity)

(deftransport ToTransportLipid
  :comment "GO:0005319"
  :cargo ch/lipid)

(deftransport ToTransportPhospholipid
  :comment "GO:0005548"
  :cargo ch/phospholipid)

(deftransport ToTransportPhosphatidylinositol
  :comment "GO:0008526"
  :cargo ch/phosphatidylinositol)

(deftransport ToTransportPhosphatidylethanolamine
  :comment "GO:1904121"
  :cargo ch/phosphatidylethanolamine)

(deftransport ToTransportPhosphatidicAcid
  :comment "GO:1990050"
  :cargo ch/phosphatidic_acid)

(deftransport ToTransportLysophospholipid
  :comment "GO:0051978"
  :across go/plasma_membrane
  :cargo ch/monoacylglycerol_phosphate)

(deftransport ToTransportPhosphatidylcholine
  :comment "GO:0008525"
  :cargo ch/phosphatidylcholine)

(deftransport ToTransportPolymyxin
  :comment "GO:0042897"
  :across go/plasma_membrane
  :cargo (owl-and ch/polymyxin (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportSphingolipid
  :comment "GO:0046624"
  :cargo ch/sphingolipid)

(deftransport ToTransportCeramide
  :comment "GO:0035620"
  :cargo ch/ceramide)

(deftransport ToTransportCeramide1-Phosphate
  :comment "GO:1902388"
  :cargo ch/ceramide_1-phosphate)

(deftransport ToTransportSterol
  :comment "GO:0015248"
  :cargo ch/sterol)

(deftransport ToTransportCholesterol
  :comment "GO:0017127"
  :cargo ch/cholesterol)

(deftransport ToTransportPhospholipidScramblase
  :comment "GO:0017128"
  :cargo ch/phospholipid
  :from go/leaflet_of_membrane_bilayer
  :to go/leaflet_of_membrane_bilayer)

(deftransport ToTransportIntermembranePhosphatidylinositol
  :comment "GO:0120018"
  :cargo ch/phosphatidylinositol
  :from go/leaflet_of_membrane_bilayer
  :to go/leaflet_of_membrane_bilayer)

(deftransport ToTransportGlycolipid
  :comment "GO:0017089"
  :cargo ch/glycolipid)

;;Transmembrane transporter activity
(deftransport ToTransportTransmembrane
  :comment "GO:0022857"
  :across go/plasma_membrane
  :cargo ch/chemical_entity)

;; chemical role
(deftransport ToTransportDrug
  :comment "GO:0015238"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-application-role ch/drug)))

;; chemical roley
(deftransport ToTransportVitamin
  :comment "GO:0090482"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/vitamin)))

;; chemical role
(deftransport ToTransportCofactor
  :comment "GO:0051184"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/cofactor)))

;; chemical role
(deftransport ToTransportSiderophore
  :comment "GO:0015343"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/siderophore)))

;; Neurotransmitters are any chemical substance that is capable of transmitting a nerve impulse from a neuron to another cell. 
(deftransport ToTransportNeurotransmitter
  :comment "GO:0005326"
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/neurotransmitter)))

;; chemical role
(deftransport ToTransportAntibiotic
  :comment "GO:0042895"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/antimicrobial_drug)))

;; chemical role
(deftransport ToTransportXenobiotic
  :comment "GO:0042910"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/xenobiotic)))

;; chemical role
(deftransport ToTransportAuxin
  :comment "GO:0080161"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin)))

;; chemical role
(deftransport ToTransportAuxinEfflux
  :comment "GO:0010329"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin))
  :from go/intracellular
  :to go/extracellular_region)

;; chemical role
(deftransport ToTransportAuxinInflux
  :comment "GO:0010328"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/auxin))
  :from go/extracellular_region
  :to go/intracellular)

;; chemical role
(deftransport ToTransportCoenzyme
  :comment "GO:0051185"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportProton
  :comment "GO:0017077"
  :across go/plasma_membrane
  :from go/mitochondrial_intermembrane_space
  :to go/mitochondrial_matrix
  :cargo (owl-and ch/proton
                  (owl-some established-by go/electron_transport_chain)
                  (owl-some during go/oxidative_phosphorylation)))

(deftransport ToTransportToxin
  :comment "GO:0019534"
  :across go/plasma_membrane
  :cargo ch/toxin)

(deftransport ToTransportCarbonDioxide
  :comment "GO:0035379"
  :across go/plasma_membrane
  :cargo (owl-and ch/carbon_dioxide (owl-some has-application-role ch/drug)))

(deftransport ToTransportPoly-beta-1_6-N-acetyl-D-glucosamine
  :comment "GO:1901515"
  :across go/plasma_membrane
  :cargo ch/poly-beta-1_6-N-acetyl-D-glucosamine)

(deftransport ToTransportLipo-chitinOligosaccharide
  :comment "GO:1901513"
  :across go/plasma_membrane
  :cargo ch/lipo-chitin_oligosaccharide)

(deftransport ToTransportAcetateEster
  :comment "GO:1901375"
  :across go/plasma_membrane
  :cargo ch/acetate_ester)

;; Diff between GO and chebi
(deftransport ToTransportGlucose6-Phosphate
  :comment "GO:0015152"
  :across go/plasma_membrane
  :cargo ch/D-glucose_6-phosphate)

(deftransport ToTransportAmine
  :comment "GO:0005275"
  :across go/plasma_membrane
  :cargo ch/amine)

(deftransport ToTransportNucleobase
  :comment "GO:0015205"
  :across go/plasma_membrane
  :cargo ch/nucleobase)

(deftransport ToTransportPyrimidineNucleobase
  :comment "GO:0005350"
  :across go/plasma_membrane
  :cargo ch/pyrimidine_nucleobase)

(deftransport ToTransportUracil
  :comment "GO:0015210"
  :across go/plasma_membrane
  :cargo (owl-and ch/uracil (owl-some has-application-role ch/drug)))

(deftransport ToTransportCytosine
  :comment "GO:0015209"
  :across go/plasma_membrane
  :cargo ch/cytosine)

(deftransport ToTransportPurineNucleobase
  :comment "GO:0005345"
  :across go/plasma_membrane
  :cargo ch/purine_nucleobase)

(deftransport ToTransportAdenineNucleobase
  :comment "GO:0015207"
  :across go/plasma_membrane
  :cargo ch/adenine)

(deftransport ToTransportGuanineNucleobase
  :comment "GO:0015208"
  :across go/plasma_membrane
  :cargo ch/guanine)

(deftransport ToTransportXanthine
  :comment "GO:0042907"
  :across go/plasma_membrane
  :cargo ch/xanthine)

(deftransport ToTransportNucleobaseContainingCompound
  :comment "GO:0015932"
  :across go/plasma_membrane
  :cargo ch/nucleobase-containing_molecular_entity)

(deftransport ToTransportNucleotide
  :comment "GO:0015215"
  :across go/plasma_membrane
  :cargo ch/nucleotide)

(deftransport ToTransportFlavinAdenineDinucleotide
  :comment "GO:0015230"
  :across go/plasma_membrane
  :cargo (owl-and ch/flavin_adenine_dinucleotide (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportNicotinamideAdenineDinucleotide
  :comment "GO:0051724"
  :across go/plasma_membrane
  :cargo (owl-and ch/NAD (owl-some has-biological-role ch/coenzyme)))

;;Need review
(deftransport ToTransportDeoxynucleotide
  :comment "GO:0030233"
  :across go/plasma_membrane
  :cargo ch/deoxyribonucleotide)

(deftransport ToTransportNicotinamideMononucleotide
  :comment "GO:0015663"
  :across go/plasma_membrane
  :cargo (owl-and ch/nicotinamide_mononucleotide (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportPurineNucleotide
  :comment "GO:0015216"
  :across go/plasma_membrane
  :cargo ch/purine_nucleotide)

(deftransport ToTransportGuanineNucleotide
  :comment "GO:0001409"
  :across go/plasma_membrane
  :cargo ch/guanyl_nucleotide)

(deftransport ToTransportAdenineNucleotide
  :comment "GO:0000295"
  :across go/plasma_membrane
  :cargo ch/adenyl_nucleotide)

(deftransport ToTransport3Phosphoadenosine-5Phosphosulfate
  :comment "GO:0046964"
  :across go/plasma_membrane
  :cargo ch/_3'-phospho-5'-adenylyl_sulfate)

(deftransport ToTransportAdenosineTriphosphate
  :comment "GO:0005347"
  :across go/plasma_membrane
  :cargo (owl-and ch/ATP (owl-some has-application-role ch/drug)))

(deftransport ToTransport5AdenylylSulfate
  :comment "GO:1902557"
  :across go/plasma_membrane
  :cargo ch/_5'-adenylyl_sulfate)

;; (deftransport ToTransportAdenosineMonophosphate
;;   :comment "GO:0080122"
;;   :across go/plasma_membrane
;;   :cargo (owl-and ch/adenosine_5'-monophosphate (owl-some has-application-role ch/drug)))

(deftransport ToTransportAdenosineDiphosphate
  :comment "GO:0015217"
  :across go/plasma_membrane
  :cargo ch/ADP)

(deftransport ToTransportAdenosine_3-5-bisphosphate
  :comment "GO:0071077"
  :across go/plasma_membrane
  :cargo ch/adenosine_3'_5'-bisphosphate)

(deftransport ToTransportFattyAcyl-CoA
  :comment "GO:0015607"
  :across go/plasma_membrane
  :cargo (owl-and ch/fatty_acyl-CoA (owl-some derived-from ch/fatty_acid)))

(deftransport ToTransportCoenzyme-A
  :comment "GO:0015228"
  :across go/plasma_membrane
  :cargo (owl-and ch/coenzyme_A (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportAcetyl-CoA
  :comment "GO:0008521"
  :across go/plasma_membrane
  :cargo (owl-and ch/acetyl-CoA (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportPurineRibonucleotide
  :comment "GO:0005346"
  :across go/plasma_membrane
  :cargo ch/purine_ribonucleotide)

(deftransport ToTransportNucleotideSulfate
  :comment "GO:0005340"
  :across go/plasma_membrane
  :cargo ch/nucleotide-sulfate)

(deftransport ToTransportFlavineMononucleotide
  :comment "GO:0044610"
  :across go/plasma_membrane
  :cargo (owl-and ch/FMN (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportPyrimidineNucleotide
  :comment "GO:0015218"
  :across go/plasma_membrane
  :cargo ch/pyrimidine_nucleotide)

(deftransport ToTransportNucleotideSugar
  :comment "GO:0005338"
  :across go/plasma_membrane
  :cargo ch/nucleotide-sugar)

(deftransport ToTransportPyrimidineNucleotideSugar
  :comment "GO:0015165"
  :across go/plasma_membrane
  :cargo ch/pyrimidine_nucleotide-sugar)

(deftransport ToTransportUDP-N-Acetylgalactosamine
  :comment "GO:0005463"
  :across go/plasma_membrane
  :cargo ch/UDP-N-acetylgalactosamine-5_6-ene)

(deftransport ToTransportUDP-N-Acetylglucosamine
  :comment "GO:0005462"
  :across go/plasma_membrane
  :cargo ch/UDP-N-acetyl-alpha-D-glucosamine)

(deftransport ToTransportUDP-Xylose
  :comment "GO:0005464"
  :across go/plasma_membrane
  :cargo ch/UDP-alpha-D-xylose)

(deftransport ToTransportCMP-N-Acetylneuraminate
  :comment "GO:0005456"
  :across go/plasma_membrane
  :cargo ch/CMP-N-acetyl-beta-neuraminic_acid)

(deftransport ToTransportUDP-Galactose
  :comment "GO:0005459"
  :across go/plasma_membrane
  :cargo ch/UDP-D-galactose)

(deftransport ToTransportUDP-GlucuronicAcid
  :comment "GO:0005461"
  :across go/plasma_membrane
  :cargo ch/UDP-alpha-D-glucuronic_acid)

(deftransport ToTransportUDP-Glucose
  :comment "GO:0005460"
  :across go/plasma_membrane
  :cargo ch/UDP-D-glucose)

(deftransport ToTransportPurineNucleotideSugar
  :comment "GO:0036080"
  :across go/plasma_membrane
  :cargo ch/purine_nucleotide-sugar)

(deftransport ToTransportGDP-Fucose
  :comment "GO:0005457"
  :across go/plasma_membrane
  :cargo ch/GDP-fucose)

(deftransport ToTransportGDP-Mannose
  :comment "GO:0005458"
  :across go/plasma_membrane
  :cargo ch/GDP-mannose)

;; Nucleic acids are single or double-stranded polynucleotides involved in the storage, transmission and transfer of genetic information. 
(deftransport ToTransportNucleicAcid
  :comment "GO:0051032"
  :across go/plasma_membrane
  :cargo ch/nucleic_acid)

(deftransport ToTransportDeoxyriboNucleicAcid
  :comment "GO:0051035"
  :across go/plasma_membrane
  :cargo ch/deoxyribonucleic_acid)

(deftransport ToTransportRiboNucleicAcid
  :comment "GO:0051033"
  :across go/plasma_membrane
  :cargo ch/ribonucleic_acid)

(deftransport ToTransportTransferRNA
  :comment "GO:0051034"
  :across go/plasma_membrane
  :cargo ch/transfer_RNA)

;; Need review
(deftransport ToTransportProtein-DNA-Complex
  :comment "GO:0015219"
  :across go/plasma_membrane
  :cargo (owl-and ch/macromolecule (owl-some has-part ch/protein ch/deoxyribonucleic_acid)))

(deftransport ToTransportNucleoside
  :comment "GO:0005337"
  :across go/plasma_membrane
  :cargo ch/nucleoside)

(deftransport ToTransportPyrimidineNucleoside
  :comment "GO:0015214"
  :across go/plasma_membrane
  :cargo ch/pyrimidine_nucleoside)

(deftransport ToTransportCytidine
  :comment "GO:0015212"
  :across go/plasma_membrane
  :cargo ch/cytidine)

(deftransport ToTransportUridine
  :comment "GO:0015213"
  :across go/plasma_membrane
  :cargo ch/uridine)

(deftransport ToTransportPurineNucleoside
  :comment "GO:0015211"
  :across go/plasma_membrane
  :cargo ch/purine_nucleoside)

(deftransport ToTransportXanthosine
  :comment "GO:0015553"
  :across go/plasma_membrane
  :cargo ch/xanthosine)

(deftransport ToTransportNicotinamideRiboside
  :comment "GO:0034257"
  :across go/plasma_membrane
  :cargo ch/N-ribosylnicotinamide)

(deftransport ToTransportChlorophyllCatabolite
  :comment "GO:0010290"
  :across go/plasma_membrane
  :cargo ch/primary_fluorescent_chlorophyll_catabolite)

(deftransport ToTransportAzole
  :comment "GO:1901474"
  :across go/plasma_membrane
  :cargo ch/azole)

(deftransport ToTransportFluconazole
  :comment "GO:0015244"
  :across go/plasma_membrane
  :cargo (owl-and ch/fluconazole (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic)))

(deftransport ToTransportAcadesine
  :comment "GO:1903089"
  :across go/plasma_membrane
  :cargo (owl-and ch/acadesine (owl-some has-application-role ch/drug)))

(deftransport ToTransportThiaminePyrophosphate
  :comment "GO:0090422"
  :across go/plasma_membrane
  :cargo (owl-and ch/thiamine_1+__diphosphate_1-_ (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportSulfathiazole
  :comment "GO:0015546"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfathiazole (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic)))

(deftransport ToTransportThiamine
  :comment "GO:0015234"
  :across go/plasma_membrane
  :cargo (owl-and ch/thiamine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportAminotriazole
  :comment "GO:1901478"
  :across go/plasma_membrane
  :cargo ch/amitrole)

(deftransport ToTransportSulfurMolecularEntity
  :comment "GO:1901682"
  :across go/plasma_membrane
  :cargo ch/sulfur_molecular_entity)

(deftransport ToTransportS-adenosyl-L-methionine
  :comment "GO:0000095"
  :across go/plasma_membrane
  :cargo (owl-and ch/S-adenosyl-L-methionine (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportSulfite
  :comment "GO:0000319"
  :across go/plasma_membrane
  :cargo ch/sulfite)

(deftransport ToTransportThiosulfate
  :comment "GO:0015117"
  :across go/plasma_membrane
  :cargo ch/thiosulfate)

(deftransport ToTransportSulfate
  :comment "GO:0015116"
  :across go/plasma_membrane
  :cargo ch/sulfate)


;;Enables the transfer of a specific substance or related group of substances from the outside of the cell to the inside of the cell across a membrane.
(deftransport ToTransportInfluxTransmembrane
  :comment ""
  :cargo ch/chemical_entity
  :across go/plasma_membrane
  :from go/extracellular_region
  :to go/intracellular)

;;Enables the transfer of a specific substance or related group of substances from the inside of the cell to the outside of the cell across a membrane.
(deftransport ToTransportEffluxTransmembrane
  :comment "GO:0015562"
  :cargo ch/chemical_entity
  :across go/plasma_membrane
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportCarbohydrateDerivative
  :comment "GO:1901505"
  :across go/plasma_membrane
  :cargo ch/carbohydrate_derivative)
 
(deftransport ToTransportN-acetylglucosamine
  :comment "GO:0015572"
  :across go/plasma_membrane
  :cargo ch/N-acetylglucosamine)

(deftransport ToTransportMethylgalactoside
  :comment "GO:0015592"
  :across go/plasma_membrane
  :cargo ch/methyl_galactoside)

(deftransport ToTransportGalactosamine
  :comment "GO:0019196"
  :across go/plasma_membrane
  :cargo ch/galactosamine)

(deftransport ToTransportN-acetylgalactosamine
  :comment "GO:0015571"
  :across go/plasma_membrane
  :cargo ch/N-acetylgalactosamine)

(deftransport ToTransportGlucoside
  :comment "GO:0042947"
  :across go/plasma_membrane
  :cargo ch/glucoside)

(deftransport ToTransportAlpha-Glucoside
  :comment "GO:0015151"
  :across go/plasma_membrane
  :cargo ch/alpha-glucoside)

(deftransport ToTransportBeta-Glucoside
  :comment "GO:0015573"
  :across go/plasma_membrane
  :cargo ch/beta-glucoside)

(deftransport ToTransportArbutin
  :comment "GO:0042951"
  :across go/plasma_membrane
  :cargo ch/hydroquinone_O-beta-D-glucopyranoside)

(deftransport ToTransportAbscisicAcidGlucosylEster
  :comment "GO:1902417"
  :across go/plasma_membrane
  :cargo ch/_+_-abscisic_acid_D-glucopyranosyl_ester)

(deftransport ToTransportFerricTriacetylfusarinineC
  :comment "GO:0015621"
  :across go/plasma_membrane
  :cargo ch/N'_N''_N'''-triacetylfusarinine_C)


(deftransport ToTransportCarbohydrate
  :comment "GO:0015144"
  :across go/plasma_membrane
  :cargo ch/carbohydrate)

(deftransport ToTransportOligosaccharide
  :comment "GO:0015157"
  :across go/plasma_membrane
  :cargo ch/oligosaccharide)

(deftransport ToTransportRaffinose
  :comment "GO:0015158"
  :across go/plasma_membrane
  :cargo ch/raffinose)

(deftransport ToTransportDisaccharide
  :comment "GO:0015154"
  :across go/plasma_membrane
  :cargo ch/disaccharide)

(deftransport ToTransportTrehalose
  :comment "GO:0015574"
  :across go/plasma_membrane
  :cargo ch/trehalose)

(deftransport ToTransportSucrose
  :comment "GO:0008515"
  :across go/plasma_membrane
  :cargo ch/sucrose)

(deftransport ToTransportMelibios
  :comment "GO:0015156"
  :across go/plasma_membrane
  :cargo ch/melibiose)

(deftransport ToTransportLactose
  :comment "GO:0015155"
  :across go/plasma_membrane
  :cargo ch/lactose)

(deftransport ToTransportCellobiose
  :comment "GO:0019191"
  :across go/plasma_membrane
  :cargo ch/cellobiose)

(deftransport ToTransportMaltose
  :comment "GO:0005363"
  :across go/plasma_membrane
  :cargo ch/maltose)

(deftransport ToTransportOligogalacturonide
  :comment "GO:0033155"
  :across go/plasma_membrane
  :cargo ch/oligogalacturonide)

(deftransport ToTransportAldarate
  :comment "GO:0042876"
  :across go/plasma_membrane
  :cargo ch/aldaric_acid_anion)

;; Different between GO and Chebi 
(deftransport ToTransportD-glucarate
  :comment "GO:0042878"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucarate_2-_ (owl-some hasEnantiomerism D-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportGalactarate
  :comment "GO:1902301"
  :across go/plasma_membrane
  :cargo ch/galactaric_acid_anion)

(deftransport ToTransportGalactitol
  :comment "GO:0015577"
  :across go/plasma_membrane
  :cargo ch/galactitol)

;; (deftransport ToTransportSugar
;;   :comment "GO:0051119"
;;   :across go/plasma_membrane
;;   :cargo ch/sugar)


(deftransport ToTransportMacromolecule
  :comment "GO:0022884"
  :across go/plasma_membrane
  :cargo ch/biomacromolecule)

(deftransport ToTransportTeichoicAcid
  :comment "GO:0015162"
  :across go/plasma_membrane
  :cargo ch/teichoic_acid)

(deftransport ToTransportLipopolysaccharide
  :comment "GO:0015221"
  :across go/plasma_membrane
  :cargo ch/lipopolysaccharide)

(deftransport ToTransportLipopolysaccharideExporter
  :comment "GO:0015634"
  :across go/plasma_membrane
  :cargo ch/lipopolysaccharide
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportPolysaccharide
  :comment "GO:0015159"
  :across go/plasma_membrane
  :cargo ch/polysaccharide)

(deftransport ToTransportBeta-glucan
  :comment "GO:0015160"
  :across go/plasma_membrane
  :cargo ch/beta-D-glucan)

(deftransport ToTransportCapsularPolysaccharide
  :comment "GO:0015161"
  :across go/plasma_membrane
  :cargo ch/polysaccharide)

(deftransport ToTransportArabinan
  :comment "GO:0042901"
  :across go/plasma_membrane
  :cargo ch/arabinan)

(deftransport ToTransportMaltodextrin
  :comment "GO:0042958"
  :across go/plasma_membrane
  :cargo ch/maltodextrin)

(deftransport ToTransportDextrin
  :comment "GO:0042957"
  :across go/plasma_membrane
  :cargo ch/dextrin)

(deftransport ToTransportPeptidoglycan
  :comment "GO:0015647"
  :across go/plasma_membrane
  :cargo ch/peptidoglycan)

(deftransport ToTransportPeptidoglycanPeptide
  :comment "GO:0015640"
  :across go/plasma_membrane
  :cargo PeptidoglycanPeptide)

(deftransport ToTransportLipid-linkedPeptidoglycan
  :comment "GO:0015648"
  :across go/plasma_membrane
  :cargo ch/lipid-linked_peptidoglycan)


(deftransport ToTransportMonosaccharide
  :comment "GO:0015145"
  :across go/plasma_membrane
  :cargo ch/monosaccharide)

(deftransport ToTransportHexose
  :comment "GO:0015149"
  :across go/plasma_membrane
  :cargo ch/hexose)

(deftransport ToTransportRhamnose
  :comment "GO:0015153"
  :across go/plasma_membrane
  :cargo ch/rhamnose)

(deftransport ToTransportMannose
  :comment "GO:0015578"
  :across go/plasma_membrane
  :cargo ch/mannose)

(deftransport ToTransportGlucose
  :comment "GO:0005355"
  :across go/plasma_membrane
  :cargo ch/glucose)

(deftransport ToTransportGlucoseWithHighAffinity
  :comment "GO:0140108"
  :across go/plasma_membrane
  :cargo ch/glucose
  :transports-with HighAffinity)

(deftransport ToTransportD-Glucose
  :comment "GO:0055056"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucose (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportGalactose
  :comment "GO:0005354"
  :across go/plasma_membrane
  :cargo ch/galactose)

(deftransport ToTransportFructose
  :comment "GO:0005353"
  :across go/plasma_membrane
  :cargo ch/fructose)

(deftransport ToTransportAllose
  :comment "GO:0015593"
  :across go/plasma_membrane
  :cargo ch/allose)

(deftransport ToTransportSorbose
  :comment "GO:0019194"
  :across go/plasma_membrane
  :cargo ch/sorbose)

(deftransport ToTransportFucose
  :comment "GO:0015150"
  :across go/plasma_membrane
  :cargo ch/fucose)

(deftransport ToTransportPentose
  :comment "GO:0015146"
  :across go/plasma_membrane
  :cargo ch/pentose)

(deftransport ToTransportD-ribose
  :comment "GO:0015591"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-ribose (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-xylose
  :comment "GO:0015148"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-xylose (owl-some hasEnantiomerism D-Enantiomer)))

;; A pentose monosaccharide that occurs in both D and L configurations, and as a polymer
(deftransport ToTransportArabinose
  :comment "GO:0042900"
  :across go/plasma_membrane
  :cargo ch/arabinose)

(deftransport ToTransportL-arabinose
  :comment "GO:0015147"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-arabinose (owl-some hasEnantiomerism L-Enantiomer)))

;; Need review
(deftransport ToTransportL-ascorbicAcid
  :comment "GO:0015229"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-ascorbic_acid (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/vitamin ch/coenzyme)))


(deftransport ToTransportUronicAcid
  :comment "GO:0015133"
  ;:annotation "Uronic acids are any monocarboxylic acid formally derived by oxidizing to a carboxyl group the terminal hydroxymethylene group of either an aldose with four or more carbon atoms in the molecule, or of any glycoside derived from such an aldose."
  :across go/plasma_membrane
  :cargo ch/uronic_acid)

(deftransport ToTransportHexuronate
  :comment "GO:0015134"
  :across go/plasma_membrane
  :cargo ch/hexuronate)

(deftransport ToTransportGlucuronate
  :comment "GO:0015135"
  :across go/plasma_membrane
  :cargo ch/glucuronate)

(deftransport ToTransportD-Glucuronate
  :comment "GO:0042880"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucuronate (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportGalacturonate
  :comment "GO:0015550"
  :across go/plasma_membrane
  :cargo ch/galacturonate)


(deftransport ToTransportAminoAcidDerivative
  :comment "GO:0072349"
  :across go/plasma_membrane
  :cargo ch/amino_acid_derivative)

(deftransport ToTransportFolicAcid
  :comment "GO:0008517"
  :across go/plasma_membrane
  :cargo (owl-and ch/folic_acid (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))


(deftransport ToTransportCreatine
  :comment "GO:0005308"
  :across go/plasma_membrane
  :cargo (owl-and ch/creatine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportS-methylmethionine
  :comment "GO:0000100"
  :across go/plasma_membrane
  :cargo ch/S-methyl-L-methionine)


(deftransport ToTransportCarnitine
  :comment "GO:0015226"
  :across go/plasma_membrane
  :cargo ch/carnitine)

(deftransport ToTransportR-Carnitine
  :comment "GO:1901235"
  :across go/plasma_membrane
  :cargo (owl-and ch/_R_-carnitine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportR-PantothenicAcid
  :comment "GO:0015233"
  :across go/plasma_membrane
  :cargo (owl-and ch/_R_-pantothenate (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/coenzyme ch/vitamin)))


(deftransport ToTransportL-hydroxyproline
  :comment "GO:0034590"
  :across go/plasma_membrane
  :cargo (owl-and ch/_4-hydroxy-L-proline (owl-some hasEnantiomerism L-Enantiomer)))


(deftransport ToTransport5-formyltetrahydrofolicAcid
  :comment "GO:0015231"
  :across go/plasma_membrane
  :cargo (owl-and ch/_5-formyltetrahydrofolic_acid (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportCarcinine
  :comment "GO:1905131"
  :across go/plasma_membrane
  :cargo ch/carcinine)

(deftransport ToTransportGlutathione
  :comment "GO:0034634"
  :across go/plasma_membrane
  :cargo (owl-and ch/glutathione (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportL-cystine
  :comment "GO:0015184"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-cystine (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransport4-TrimethylammonioButanoate
  :comment "GO:1901236"
  :across go/plasma_membrane
  :cargo ch/_4-_trimethylammonio_butanoate)

(deftransport ToTransportAminoAcidBetaine
  :comment "GO:0015199"
  :across go/plasma_membrane
  :cargo ch/glycine_betaine)

;;Any compound containing one, two, or three acyl groups attached to a nitrogen atom
(deftransport ToTransportAmide
  :comment "GO:0042887"
  :across go/plasma_membrane
  :cargo ch/amide)

(deftransport ToTransportFosmidomycin
  :comment "GO:0042898"
  :across go/plasma_membrane
  :cargo (owl-and ch/fosmidomycin (owl-some has-biological-role ch/antimicrobial_drug)))


;; need review
;; Not sure what type of antibiotic.!!
;; In Chebi Benomyl does not have role xenobiotic !!!
(deftransport ToTransportBenomyl
  :comment "GO:1901479"
  :across go/plasma_membrane
  :cargo (owl-and ch/benomyl (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic)))

(deftransport ToTransportMethotrexate
  :comment "GO:0015350"
  :across go/plasma_membrane
  :cargo (owl-and ch/methotrexate (owl-some has-application-role ch/drug)))


(deftransport ToTransportDethiobiotin
  :comment "GO:1901604"
  :across go/plasma_membrane
  :cargo ch/dethiobiotin)

(deftransport ToTransportUrea
  :comment "GO:0015204"
  :across go/plasma_membrane
  :cargo ch/urea)

(deftransport ToTransportAllantoate
  :comment "GO:0015124"
  :across go/plasma_membrane
  :cargo ch/allantoate)

(deftransport ToTransportPeptide
  :comment "GO:1904680"
  :across go/plasma_membrane
  :cargo ch/peptide)

(deftransport ToTransportProtein
  :comment "GO:0008320"
  :across go/plasma_membrane
  :cargo ch/protein)

(deftransport ToTransportFoldedProtein
  :comment "GO:0015557"
  :across go/plasma_membrane
  :cargo FoldedProtein
  :when go/TAT_protein_transport_complex)

(deftransport ToTransportBacteriocin
  :comment "GO:0022885"
  :across go/plasma_membrane
  :cargo (owl-and ch/bacteriocin (owl-some has-application-role ch/antimicrobial_drug)))

(deftransport ToTransportColicin
  :comment "GO:0042912"
  :across go/plasma_membrane
  :cargo (owl-and ch/colicin (owl-some has-application-role ch/antimicrobial_drug)))



;; (deftransport ToTransportProtein-DNAComplex
;;   :comment ""
;;   :across go/plasma_membrane
;;   :cargo ....................................................)

(deftransport ToTransportMicrocin
  :comment "GO:0015638"
  :across go/plasma_membrane
  :cargo (owl-and ch/microcin (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportOligopeptide
  :comment "GO:0035673"
  :across go/plasma_membrane
  :cargo ch/oligopeptide)

(deftransport ToTransportTetrapeptide
  :comment "GO:1901584"
  :across go/plasma_membrane
  :cargo ch/tetrapeptide)

(deftransport ToTransportTripeptide
  :comment "GO:0042937"
  :across go/plasma_membrane
  :cargo ch/tripeptide)

(deftransport ToTransportDipeptide
  :comment "GO:0071916"
  :across go/plasma_membrane
  :cargo ch/dipeptide)


;; Transfer of an inorganic molecular entity from the outside of a cell to the inside of the cell across a membrane.
;; An inorganic molecular entity is a molecular entity that contains no carbon. 
(deftransport ToTransportInorganicMolecularEntity
  :comment "GO:0015318"
  :across go/plasma_membrane
  :cargo ch/inorganic_molecular_entity)

(deftransport ToTransportWater
  :comment "GO:0005372"
  :across go/plasma_membrane
  :cargo ch/water)

;; Need review
;; acridine has no role xenobiotic in ChEBI
(deftransport ToTransportArcidine
  :comment "GO:0042911"
  :across go/plasma_membrane
  :cargo (owl-and ch/acridine (owl-some has-biological-role ch/xenobiotic)))


(deftransport ToTransportInorganicCation
  :comment "GO:0022890"
  :across go/plasma_membrane
  :cargo ch/inorganic_cation)

(deftransport ToTransportTrivalentInorganicCation
  :comment "GO:0072510"
  :across go/plasma_membrane
  :cargo ch/trivalent_inorganic_cation)

(deftransport ToTransportDivalentInorganicCation
  :comment "GO:0072509"
  :across go/plasma_membrane
  :cargo ch/divalent_inorganic_cation)

(deftransport ToTransportFerrousIron
  :comment "GO:0015093"
  :across go/plasma_membrane
  :cargo ch/iron_2+_)

(deftransport ToTransportZincIon
  :comment "GO:0005385"
  :across go/plasma_membrane
  :cargo ch/zinc_2+_)

(deftransport ToTransportZincIonEfflux
  :comment "GO:0022883"
  :across go/plasma_membrane
  :cargo ch/zinc_2+_
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportFerricIron
  :comment "GO:0015091"
  :across go/plasma_membrane
  :cargo ch/iron_3+_)

;; transferrin not exist in Chebi
(deftransport ToTransportTransferrin
  :comment "GO:0033570"
  :across go/plasma_membrane
  :cargo Transferrin)

;; Lactoferrin not exist in Chebi
(deftransport ToTransportLactoferrin
  :comment "GO:0033570"
  :across go/plasma_membrane
  :cargo Lactoferrin)


(deftransport ToTransportMonovalentInorganicCation
  :comment "GO:0015077"
  :across go/plasma_membrane
  :cargo ch/monovalent_inorganic_cation)

(deftransport ToTransportProton
  :comment "GO:0015078"
  :across go/plasma_membrane
  :cargo ch/proton)

(deftransport ToTransportSodiumIon
  :comment "GO:0015081"
  :across go/plasma_membrane
  :cargo ch/sodium_1+_)

(deftransport ToTransportPotassiumIon
  :comment "GO:0015079"
  :across go/plasma_membrane
  :cargo ch/potassium_1+_)


(deftransport ToTransportAlkane
  :comment "GO:0015567"
  :across go/plasma_membrane
  :cargo ch/alkane)

(deftransport ToTransportCyanate
  :comment "GO:0015110"
  :across go/plasma_membrane
  :cargo ch/cyanate)

(deftransport ToTransportAminoAcid
  :comment "GO:0015171"
  :across go/plasma_membrane
  :cargo ch/amino_acid)

(deftransport ToTransportL-AminoAcid
  :comment "GO:0015179"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-alpha-amino_acid (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-AminoAcidEfflux
  :comment "GO:0034639"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-alpha-amino_acid (owl-some hasEnantiomerism L-Enantiomer))
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportD-AminoAcid
  :comment "GO:0042943"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-alpha-amino_acid (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-methionine
  :comment "GO:0048474"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-methionine (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-aspartate
  :comment "GO:0140010"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-aspartate_2-_ (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportD-serine
  :comment "GO:0042945"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-serine (owl-some hasEnantiomerism D-Enantiomer) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportD-alanine
  :comment "GO:0042944"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-alanine (owl-some hasEnantiomerism D-Enantiomer) (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-tyrosine
  :comment "GO:0005302"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-tyrosine (owl-some has-application-role ch/drug) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-arginine
  :comment "GO:0061459"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-arginine (owl-some hasAcidity Alkaline) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-alanine
  :comment "GO:0015180"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-alanine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-valine
  :comment "GO:0005304"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-valine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-serine
  :comment "GO:0015194"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-serine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)))

(deftransport ToTransportHomoserine
  :comment "GO:0042970"
  :across go/plasma_membrane
  :cargo (owl-and ch/homoserine (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-phenylalanine
  :comment "GO:0015192"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-phenylalanine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-proline
  :comment "GO:0015193"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-proline (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-leucine
  :comment "GO:0015190"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-leucine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-diaminopimelate
  :comment "GO:0015626"
  :across go/plasma_membrane
  :cargo (owl-and ch/LL-2_6-diaminopimelic_acid (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportL-ornithine
  :comment "GO:0000064"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-ornithine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-isoleucine
  :comment "GO:0015188"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-isoleucine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)))

(deftransport ToTransportAromaticAminoAcid
  :comment "GO:0015173"
  :across go/plasma_membrane
  :cargo ch/aromatic_amino_acid)

(deftransport ToTransportBranchedChainAminoAcid
  :comment "GO:0015658"
  :across go/plasma_membrane
  :cargo ch/branched-chain_amino_acid)

(deftransport ToTransportSulfurAminoAcid
  :comment "GO:0000099"
  :across go/plasma_membrane
  :cargo ch/sulfur-containing_amino_acid)

(deftransport ToTransportMethionine
  :comment "GO:0043865"
  :across go/plasma_membrane
  :cargo ch/methionine)

(deftransport ToTransportCysteine
  :comment "GO:0033229"
  :across go/plasma_membrane
  :cargo (owl-and ch/cysteine (owl-some hasAcidity Neutral)))


(deftransport ToTransportL-ascorbateWithSodiumCondition
  :comment "GO:0070890"
  :across go/plasma_membrane
  :cargo ch/L-ascorbate
  :when ch/sodium_1+_)

(deftransport ToTransportBicarbonate
  :comment "GO:0015106"
  :across go/plasma_membrane
  :cargo ch/hydrogencarbonate)


(deftransport ToTransportNeutralAminoAcid
  :comment "GO:0015175"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral)))

(deftransport ToTransportSerine
  :comment "GO:0022889"
  :across go/plasma_membrane
  :cargo (owl-and ch/serine (owl-some hasAcidity Neutral)))

(deftransport ToTransportAlanine
  :comment "GO:0022858"
  :across go/plasma_membrane
  :cargo (owl-and ch/alanine (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-glutamine
  :comment "GO:0015186"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-glutamine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportBasicAminoAcid
  :comment "GO:0015174"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline)))

(deftransport ToTransportL-lysine
  :comment "GO:0015189"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportL-histidine
  :comment "GO:0005290"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug)))

(deftransport ToTransportBasicAminoAcidWithLowAffinity
  :comment "GO:0097625"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with LowAffinity)

(deftransport ToTransportArginine
  :comment "GO:0015181"
  :across go/plasma_membrane
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline)))

(deftransport ToTransportBasicAminoAcidWithHighAffinity
  :comment "GO:0005287"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)


(deftransport ToTransportL-lysineEfflux
  :comment "GO:0015661"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline)
                  (owl-some has-application-role ch/drug))
  :from go/intracellular
  :to go/extracellular_region)


(deftransport ToTransportAcidicAminoAcid
  :comment "GO:0015172"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Acidic)))


 ;; substances transported with high and low affinities

(deftransport ToTransportPotassiumIonWithHighAffinity
  :comment "GO:0140107"
  :across go/plasma_membrane
  :cargo ch/potassium_1+_
  :transports-with HighAffinity)

(deftransport ToTransportArginineWithHighAffinity
  :comment "GO:0005289"
  :across go/plasma_membrane
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportL-histidineWithHighAffinity
  :comment "GO:0005291"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportLysineWithHighAffinity
  :comment "GO:0005292"
  :across go/plasma_membrane
  :cargo (owl-and ch/lysine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithHighAffinity
  :comment "GO:0000006"
  :across go/plasma_membrane
  :cargo ch/zinc_2+_
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithLowAffinity
  :comment "GO:0000007"
  :across go/plasma_membrane
  :cargo ch/zinc_2+_
  :transports-with LowAffinity)

(deftransport ToTransportGlutamateWithHighAffinity
  :comment "GO:0005314"
  :across go/plasma_membrane
  :cargo (owl-and ch/glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter))
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithLowAffinity
  :comment "GO:0009673"
  :across go/plasma_membrane
  :cargo ch/phosphate_ion
  :transports-with LowAffinity)

(deftransport ToTransportCopperIonWithHighAffinity
  :comment "GO:0015089"
  :across go/plasma_membrane
  :cargo ch/copper_2+_
  :transports-with HighAffinity)

(deftransport ToTransportFerricIronIonWithLowAffinity
  :comment "GO:0015090"
  :across go/plasma_membrane
  :cargo ch/iron_2+_
  :transports-with LowAffinity)

(deftransport ToTransportFerricIronIonWithHighAffinity
  :comment "GO:0015092"
  :across go/plasma_membrane
  :cargo ch/iron_3+_
  :transports-with HighAffinity)

(deftransport ToTransportGlutamineWithHighAffinity
  :comment "GO:0015330"
  :across go/plasma_membrane
  :cargo (owl-and ch/glutamine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportOligopeptideWithHighAffinity
  :comment "GO:0015334"
  :across go/plasma_membrane
  :cargo ch/oligopeptide
  :transports-with HighAffinity)

(deftransport ToTransportTryptophanWithLowAffinity
  :comment "GO:0022893"
  :across go/plasma_membrane
  :cargo ch/tryptophan
  :transports-with LowAffinity)

(deftransport ToTransportNickelCationWithHighAffinity
  :comment "GO:0044750"
  :across go/plasma_membrane
  :cargo ch/nickel_cation
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithHighAffinity
  :comment "GO:0048249"
  :across go/plasma_membrane
  :cargo ch/phosphate_ion
  :transports-with HighAffinity)

(deftransport ToTransportFructoseWithHighAffinity
  :comment "GO:0061486"
  :across go/plasma_membrane
  :cargo ch/fructose
  :transports-with HighAffinity)

(deftransport ToTransportNitrateWithLowAffinity
  :comment "GO:0080054"
  :across go/plasma_membrane
  :cargo ch/nitrate
  :transports-with LowAffinity)

(deftransport ToTransportL-arginineWithLowAffinity
  :comment "GO:0097626"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-arginine (owl-some has-application-role ch/drug))
  :transports-with LowAffinity)

(deftransport ToTransportL-ornithineWithHighAffinity
  :comment "GO:0097627"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-ornithine (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithHighAffinity
  :comment "GO:0005300"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithLowAffinity
  :comment "GO:0022893"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug))
  :transports-with LowAffinity)


(deftransport ToTransportAlkanesulfonate
  :comment "GO:0042959"
  :across go/plasma_membrane
  :cargo (owl-and ch/_1_1-diunsubstituted_alkanesulfonate (owl-some has-application-role ch/xenobiotic)))


(deftransport ToTransportIon
  :comment "GO:0015075"
  :across go/plasma_membrane
  :cargo ch/ion)

(deftransport ToTransportTriosePhosphate
  :comment "GO:0071917"
  :across go/plasma_membrane
  :cargo ch/glyceraldehyde_3-phosphate)

;; Acriflavine has no role Xenobiotic in ChEBI
(deftransport ToTransportAcriflavine
  :comment "GO:0015566"
  :across go/plasma_membrane
  :cargo (owl-and ch/_3_6-diamino-10-methylacridinium_chloride (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/xenobiotic)))

(deftransport ToTransportTetracycline
  :comment "GO:0008493"
  :across go/plasma_membrane
  :cargo (owl-and ch/tetracycline (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportAluminumIon
  :comment "GO:0015083"
  :across go/plasma_membrane
  :cargo ch/aluminium_ion)

;; Positivel charged ions --> Cation
(deftransport ToTransportCation
  :comment "GO:0008324"
  :across go/plasma_membrane
  :cargo ch/cation)

(deftransport ToTransportSiliconEfflux
  :comment "GO:0032523"
  :across go/plasma_membrane
  :cargo ch/silicon_4+_
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportCationEfflux
  :comment "GO:0046583"
  :across go/plasma_membrane
  :cargo ch/cation
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportOrganicCation
  :comment "GO:0015101"
  :across go/plasma_membrane
  :cargo ch/organic_cation)

(deftransport ToTransportCadaverine
  :comment "GO:0015490"
  :across go/plasma_membrane
  :cargo ch/cadaverine)

(deftransport ToTransportAmiloride
  :comment "GO:0015240"
  :across go/plasma_membrane
  :cargo (owl-and ch/amiloride (owl-some has-application-role ch/drug)))

(deftransport ToTransportQuaternaryAmmoniumCompound
  :comment "GO:0015651"
  :across go/plasma_membrane
  :cargo ch/quaternary_nitrogen_compound)

(deftransport ToTransportN-methylnicotinat
  :comment "GO:0090417"
  :across go/plasma_membrane
  :cargo ch/N-methylnicotinate)

(deftransport ToTransportAcylCarnitine
  :comment "GO:0015227"
  :across go/plasma_membrane
  :cargo ch/O-acylcarnitine)

(deftransport ToTransportOrganophosphateEster
  :comment "GO:0015605"
  :across go/plasma_membrane
  :cargo ch/organic_phosphate)

(deftransport ToTransportGlycerol-3-phosphate
  :comment "GO:0015169"
  :across go/plasma_membrane
  :cargo ch/sn-glycerol_3-phosphate)

(deftransport ToTransportAminoPhospholipid
  :comment "GO:0015247"
  :across go/plasma_membrane
  :cargo ch/aminophospholipid)

(deftransport ToTransportHexosePhosphate
  :comment "GO:0015119"
  :across go/plasma_membrane
  :cargo ch/hexose_phosphate)

;; Negatively charged ions --> Anion
(deftransport ToTransportAnion
  :comment "GO:0008509"
  :across go/plasma_membrane
  :cargo ch/anion)

(deftransport ToTransportOrganicAnion
  :comment "GO:0008514"
  :across go/plasma_membrane
  :cargo ch/organic_anion)

(deftransport ToTransportRiboflavin
  :comment "GO:0032217"
  :across go/plasma_membrane
  :cargo (owl-and ch/riboflavin (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))


(deftransport ToTransportDehydroascorbicAcid
  :comment "GO:0033300"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-dehydroascorbic_acid (owl-some has-biological-role ch/vitamin)))

;; https://www.sciencedirect.com/science/article/pii/S0006291X0400292X?via%3Dihub
(deftransport ToTransportOrganicAnion
  :comment "GO:0043250"
  :across go/plasma_membrane
  :cargo ch/organic_anion
  :when ch/sodium_1+_)

(deftransport ToTransportInorganicAnion
  :comment "GO:0015103"
  :across go/plasma_membrane
  :cargo ch/inorganic_anion)

(deftransport ToTransportArsenite
  :comment "GO:0015105"
  :across go/plasma_membrane
  :cargo ch/arsenite_3-_)

(deftransport ToTransportChromate
  :comment "GO:0015109"
  :across go/plasma_membrane
  :cargo ch/chromate_2-_)

(deftransport ToTransportMolybdateIon
  :comment "GO:0015098"
  :across go/plasma_membrane
  :cargo ch/molybdate)

(deftransport ToTransportChlorate
  :comment "GO:0015107"
  :across go/plasma_membrane
  :cargo ch/chlorate)

(deftransport ToTransportAntimonite
  :comment "GO:0015104"
  :across go/plasma_membrane
  :cargo ch/antimonite)

(deftransport ToTransportBorateEfflux
  :comment "GO:0080139"
  :across go/plasma_membrane
  :cargo (owl-and ch/borate (owl-some has-application-role ch/drug))
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportTungstate
  :comment "GO:1901237"
  :across go/plasma_membrane
  :cargo ch/tungstate)

(deftransport ToTransportTellurite
  :comment "GO:0015654"
  :across go/plasma_membrane
  :cargo ch/tellurite)

(deftransport ToTransportIodide
  :comment "GO:0015111"
  :across go/plasma_membrane
  :cargo ch/iodide)

(deftransport ToTransportNitrate
  :comment "GO:0015112"
  :across go/plasma_membrane
  :cargo ch/nitrate)

(deftransport ToTransportNitrateEfflux
  :comment "GO:0010542"
  :across go/plasma_membrane
  :cargo ch/nitrate
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportNitrite
  :comment "GO:0015113"
  :across go/plasma_membrane
  :cargo ch/nitrite)

(deftransport ToTransportNitriteEfflux
  :comment "GO:0015514"
  :across go/plasma_membrane
  :cargo ch/nitrite
  :from go/intracellular
  :to go/extracellular_region)


(deftransport ToTransportInorganicDiphosphate
  :comment "GO:0030504"
  :across go/plasma_membrane
  :cargo ch/diphosphate_ion)

(deftransport ToTransportPhosphateIon
  :comment "GO:0015114"
  :across go/plasma_membrane
  :cargo ch/phosphate_ion)

(deftransport ToTransportSilicate
  :comment "GO:0015115"
  :across go/plasma_membrane
  :cargo ch/silicate_ion)


(deftransport ToTransportFluoride
  :comment "GO:1903425"
  :across go/plasma_membrane
  :cargo ch/fluoride)

(deftransport ToTransportChromiumIon
  :comment "GO:0070835"
  :across go/plasma_membrane
  :cargo ch/chromium_ion)

(deftransport ToTransportLeadIon
  :comment "GO:0015094"
  :across go/plasma_membrane
  :cargo ch/lead_ion)

(deftransport ToTransportL-tryptophan
  :comment "GO:0015196"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))

(deftransport ToTransportSalt
  :comment "GO:1901702"
  :across go/plasma_membrane
  :cargo (owl-and ch/salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportTartrate
  :comment "GO:0015554"
  :across go/plasma_membrane
  :cargo (owl-and ch/tartrate_salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportUrate
  :comment "GO:0015143"
  :across go/plasma_membrane
  :cargo (owl-and ch/urate_salt (owl-some has-part ch/anion ch/cation)))

(deftransport ToTransportL-threonine
  :comment "GO:0015195"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug)))

;; I changed threonine to L-threonine
;; threonine not subclass of L-threonine (see nizal_notes.org)
(deftransport ToTransportL-threonineEfflux
  :comment "GO:0015565"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportOrganicHydroxyCompound
  :comment "GO:1901618"
  :across go/plasma_membrane
  :cargo ch/organic_hydroxy_compound)


(deftransport ToTransport3-HydroxyphenylPropanoate
  :comment "GO:0015551"
  :across go/plasma_membrane
  :cargo  ch/_3-hydroxyphenyl_propanoate)

(deftransport ToTransportPolyol
  :comment "GO:0015166"
  :across go/plasma_membrane
  :cargo ch/polyol)

(deftransport ToTransportMannitol
  :comment "GO:0015575"
  :across go/plasma_membrane
  :cargo ch/mannitol)

(deftransport ToTransportPropanediol
  :comment "GO:0015170"
  :across go/plasma_membrane
  :cargo ch/propanediol)

(deftransport ToTransportMyo-inositol
  :comment "GO:0005365"
  :across go/plasma_membrane
  :cargo ch/myo-inositol)

(deftransport ToTransportGlucosylglycerol
  :comment "GO:0051474"
  :across go/plasma_membrane
  :cargo ch/glucosylglycerol)

(deftransport ToTransportGlucitol
  :comment "GO:0015576"
  :across go/plasma_membrane
  :cargo ch/glucitol)

(deftransport ToTransportArabinitol
  :comment "GO:0015167"
  :across go/plasma_membrane
  :cargo ch/arabinitol)

(deftransport ToTransportGlycerol
  :comment "GO:0015168"
  :across go/plasma_membrane
  :cargo ch/glycerol)

(deftransport ToTransportChloramphenicol
  :comment "GO:0042896"
  :across go/plasma_membrane
  :cargo (owl-and ch/chloramphenicol (owl-some has-biological-role ch/antineoplastic_agent)))


(deftransport ToTransportAlchohol
  :comment "GO:0015665"
  :across go/plasma_membrane
  :cargo  ch/alcohol)

(deftransport ToTransportRetinol
  :comment "GO:0034632"
  :across go/plasma_membrane
  :cargo (owl-and ch/retinol (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportSalicin
  :comment "GO:0042950"
  :across go/plasma_membrane
  :cargo (owl-and ch/salicin (owl-some has-application-role ch/drug)))

(deftransport ToTransportCycloheximide
  :comment "GO:0015243"
  :across go/plasma_membrane
  :cargo (owl-and ch/cycloheximide (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportAmmoniumIon
  :comment "GO:0008519"
  :across go/plasma_membrane
  :cargo ch/ammonium_ion)

(deftransport ToTransportEthanolamine
  :comment "GO:0034228"
  :across go/plasma_membrane
  :cargo ch/ethanolamine)

(deftransport ToTransportSpermidine
  :comment "GO:0015606"
  :across go/plasma_membrane
  :cargo ch/spermidine)

;; vitamin B6 compounds, pyridoxal, pyridoxamine and pyridoxine and the active form, pyridoxal phosphate
(deftransport ToTransportVitaminB6
  :comment "GO:0031924"
  :across go/plasma_membrane
  :cargo (owl-and ch/vitamin_B6 (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportPyridoxal
  :comment "GO:0031925"
  :across go/plasma_membrane
  :cargo (owl-and ch/pyridoxal (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin ch/cofactor)))

(deftransport ToTransportPyridoxalPhosphate
  :comment "GO:0031926"
  :across go/plasma_membrane
  :cargo (owl-and ch/pyridoxal_5'-phosphate (owl-some has-application-role ch/vitamin_B6) (owl-some has-biological-role ch/vitamin ch/coenzyme)))

(deftransport ToTransportPyridoxamine
  :comment "GO:0031927"
  :across go/plasma_membrane
  :cargo (owl-and ch/pyridoxamine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportPyridoxine
  :comment "GO:0031928"
  :across go/plasma_membrane
  :cargo (owl-and ch/pyridoxine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin ch/cofactor)))

(deftransport ToTransportSphingosine
  :comment "GO:0010175"
  :across go/plasma_membrane
  :cargo ch/sphingosine)

(deftransport ToTransportPutrescine
  :comment "GO:0015489"
  :across go/plasma_membrane
  :cargo ch/putrescine)

(deftransport ToTransportAcetylcholine
  :comment "GO:0005277"
  :across go/plasma_membrane
  :cargo (owl-and ch/acetylcholine (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/neurotransmitter)))



(deftransport ToTransportMethylammonium
  :comment "GO:0015200"
  :across go/plasma_membrane
  :cargo ch/methylammonium)

(deftransport ToTransportCholine
  :comment "GO:0015220"
  :across go/plasma_membrane
  :cargo (owl-and ch/choline (owl-some has-biological-role ch/neurotransmitter)))


(deftransport ToTransportL-methionine
  :comment "GO:0015191"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-methionine (owl-some hasEnantiomerism L-Enantiomer) (owl-some has-application-role ch/drug)))


(deftransport ToTransportGlycerophosphodiester
  :comment "GO:0001406"
  :across go/plasma_membrane
  :cargo ch/glycerol_1-phosphodiester)

(deftransport ToTransportBetaAlanine
  :comment "GO:0001761"
  :across go/plasma_membrane
  :cargo (owl-and ch/beta-alanine (owl-some hasAcidity Neutral) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportGlycine
  :comment "GO:0015187"
  :across go/plasma_membrane
  :cargo (owl-and ch/glycine (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter)))
  
(deftransport ToTransportNitricOxide
  :comment "GO:0030184"
  :across go/plasma_membrane
  :cargo (owl-and ch/nitric_oxide (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportGammaAminobutyricAcid
  :comment "GO:0015185"
  :across go/plasma_membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportL-glutamate
  :comment "GO:0005313"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportL-aspartate
  :comment "GO:0015183"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-aspartate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/neurotransmitter)))

(deftransport ToTransportOrganicAcid
  :comment "GO:0005342"
  :across go/plasma_membrane
  :cargo ch/organic_acid)

(deftransport ToTransportTaurine
  :comment "GO:0005368"
  :across go/plasma_membrane
  :cargo (owl-and ch/taurine (owl-some has-biological-role ch/xenobiotic)))

(deftransport ToTransportArsenateIon
  :comment "GO:1901683"
  :across go/plasma_membrane
  :cargo ch/arsenate_ion)

(deftransport ToTransportCarboxylicAcid
  :comment "GO:0046943"
  :across go/plasma_membrane
  :cargo ch/carboxylic_acid)

(deftransport ToTransportGibberellin
  :comment "GO:1905201"
  :across go/plasma_membrane
  :cargo ch/gibberellin)

(deftransport ToTransportSialicAcid
  :comment "GO:0015136"
  :across go/plasma_membrane
  :cargo ch/sialic_acid)

(deftransport ToTransportDicarboxylicAcid
  :comment "GO:0005310"
  :across go/plasma_membrane
  :cargo ch/dicarboxylic_acid)

(deftransport ToTransportAlphaKetoglutarate
  :comment "GO:0015139"
  :across go/plasma_membrane
  :cargo (owl-and ch/_2-oxoglutarate_2-_ (owl-some has-biological-role ch/cofactor)))

(deftransport ToTransportBilirubin
  :comment "GO:0015127"
  :across go/plasma_membrane
  :cargo ch/bilirubin)

(deftransport ToTransportC4-dicarboxylate
  :comment "GO:0015556"
  :across go/plasma_membrane
  :cargo ch/C4-dicarboxylate)

(deftransport ToTransportMalate
  :comment "GO:0015140"
  :across go/plasma_membrane
  :cargo ch/malate_2-_)

(deftransport ToTransportFumarate
  :comment "GO:0015138"
  :across go/plasma_membrane
  :cargo ch/fumarate_2-_)

(deftransport ToTransportSuccinate
  :comment "GO:0015141"
  :across go/plasma_membrane
  :cargo (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)))

(deftransport ToTransportOxaloacetate
  :comment "GO:0015131"
  :across go/plasma_membrane
  :cargo ch/oxaloacetate_2-_)

(deftransport ToTransportIronChelate
  :comment "GO:0015603"
  :across go/plasma_membrane
  :cargo ch/iron_chelate)

(deftransport ToTransportFerrichrome
  :comment "GO:0042929"
  :across go/plasma_membrane
  :cargo ch/ferrichrome)

;; need review
(deftransport ToTransportIronNicotianamine
  :comment "GO:0051980"
  :across go/plasma_membrane
  :cargo ch/nicotianamine)

(deftransport ToTransportFerricVibriobactin
  :comment "GO:0019535"
  :across go/plasma_membrane
  :cargo ch/ferric-vibriobactin)

(deftransport ToTransportChrysobactin
  :comment "GO:0042933"
  :across go/plasma_membrane
  :cargo (owl-and ch/chrysobactin (owl-some has-biological-role ch/siderophore)))

(deftransport ToTransportAchromobactin
  :comment "GO:0042934"
  :across go/plasma_membrane
  :cargo (owl-and ch/achromobactin (owl-some has-biological-role ch/siderophore)))

(deftransport ToTransportEnterobactin
  :comment "GO:0042931"
  :across go/plasma_membrane
  :cargo (owl-and ch/enterobactin (owl-some has-biological-role ch/siderophore)))


(deftransport ToTransportFerricEnterobactin
  :comment "GO:0015620"
  :across go/plasma_membrane
  :cargo ch/ferrienterobactin)

;; need review
(deftransport ToTransportSiderophoreIronFerrioxamine
  :comment "GO:0015344"
  :across go/plasma_membrane
  :cargo ch/ferrioxamine_B)

(deftransport ToTransportFerricHydroxamate
  :comment "GO:0015622"
  :across go/plasma_membrane
  :cargo ch/iron_III__hydroxamate)

(deftransport ToTransportMalonate_1-
  :comment "GO:1901239"
  :across go/plasma_membrane
  :cargo ch/malonate_1-_)

(deftransport ToTransportIsopropylmalate
  :comment "GO:0034658"
  :across go/plasma_membrane
  :cargo ch/_2-isopropylmalate_2-_)

(deftransport ToTransportOxalate
  :comment "GO:0019531"
  :across go/plasma_membrane
  :cargo ch/oxalate)

(deftransport ToTransportTricarboxylicAcid
  :comment "GO:0015142"
  :across go/plasma_membrane
  :cargo ch/tricarboxylic_acid)

(deftransport ToTransportCitrate
  :comment "GO:0015137"
  :across go/plasma_membrane
  :cargo (owl-and ch/citrate_3-_ (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportIcosanoid
  :comment "GO:0071714"
  :across go/plasma_membrane
  :cargo ch/icosanoid)

(deftransport ToTransportProstaglandin
  :comment "GO:0015132"
  :across go/plasma_membrane
  :cargo ch/prostaglandin)

(deftransport ToTransportArachidonate
  :comment "GO:1903962"
  :across go/plasma_membrane
  :cargo ch/arachidonate)

(deftransport ToTransportGlucuronoside
  :comment "GO:0015164"
  :across go/plasma_membrane
  :cargo ch/glucosiduronic_acid)

(deftransport ToTransportMonocarboxylicAcid
  :comment "GO:0008028"
  :across go/plasma_membrane
  :cargo ch/monocarboxylic_acid)

(deftransport ToTransportPyruvate
  :comment "GO:0050833"
  :across go/plasma_membrane
  :cargo ch/pyruvate)

(deftransport ToTransportHydroxyectoine
  :comment "GO:0033287"
  :across go/plasma_membrane
  :cargo ch/_5-hydroxyectoine)

(deftransport ToTransportBenzoate
  :comment "GO:0042925"
  :across go/plasma_membrane
  :cargo (owl-and ch/benzoate (owl-some has-biological-role  ch/antimicrobial_drug   ch/human_xenobiotic_metabolite)))

(deftransport ToTransportAldonate
  :comment "GO:0042879"
  :across go/plasma_membrane
  :cargo ch/aldonate)

(deftransport ToTransportPhosphoglycerate
  :comment "GO:0015120"
  :across go/plasma_membrane
  :cargo ch/phosphoglycerate)

(deftransport ToTransportD-Galactonate
  :comment "GO:0042881"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-galactonate (owl-some hasEnantiomerism D-Enantiomer)))

(deftransport ToTransportL-idonate
  :comment "GO:0015568"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-idonate (owl-some hasEnantiomerism L-Enantiomer) (owl-some derived-from ch/L-idose)))

(deftransport ToTransportGlycerate
  :comment "GO:1901974"
  :across go/plasma_membrane
  :cargo ch/glycerate)

(deftransport ToTransportGluconate
  :comment "GO:0015128"
  :across go/plasma_membrane
  :cargo (owl-and ch/gluconate (owl-some derived-from ch/glucose)))

(deftransport ToTransport3-HydroxyphenylpropionicAcid
  :comment "GO:0042926"
  :across go/plasma_membrane
  :cargo (owl-and ch/_3-_3-hydroxyphenyl_propanoic_acid (owl-some has-biological-role ch/human_xenobiotic_metabolite)))

(deftransport ToTransportAbscisicAcid
  :comment "GO:0090440"
  :across go/plasma_membrane
  :cargo ch/abscisic_acids)

(deftransport ToTransportL-asparagine
  :comment "GO:0015182"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-asparagine (owl-some hasEnantiomerism L-Enantiomer) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug)))

(deftransport ToTransportPhosphoenolpyruvate
  :comment " GO:0089721"
  :across go/plasma_membrane
  :cargo ch/phosphoenolpyruvate)

(deftransport ToTransport3-PhenylpropionicAcid
  :comment "GO:0042890"
  :across go/plasma_membrane
  :cargo (owl-and ch/_3-phenylpropionic_acid (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportNalidixicAcid
  :comment "GO:0015547"
  :across go/plasma_membrane
  :cargo (owl-and ch/nalidixic_acid (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic)))

(deftransport ToTransportGlycolicAcid
  :comment "GO:0043879"
  :across go/plasma_membrane
  :cargo (owl-and ch/glycolic_acid (owl-some has-application-role ch/drug)))

(deftransport ToTransportAcetate
  :comment "GO:0015123"
  :across go/plasma_membrane
  :cargo (owl-and ch/acetate (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportBileAcid
  :comment "GO:0015125"
  :across go/plasma_membrane
  :cargo ch/bile_acid)

(deftransport ToTransportCanalicularBileAcid
  :comment "GO:0015126"
  :across go/plasma_membrane
  :cargo ch/bile_acid
  :from Hepatocyte
  :to go/intracellular_canaliculus)

(deftransport ToTransportNicotine
  :comment "GO:0090416"
  :across go/plasma_membrane
  :cargo (owl-and ch/nicotine (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/vitamin)))

(deftransport ToTransportLactate
  :comment "GO:0015129"
  :across go/plasma_membrane
  :cargo ch/lactate)

(deftransport ToTransportBiotin
  :comment "GO:0015225"
  :across go/plasma_membrane
  :cargo (owl-and ch/biotin (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/coenzyme ch/B_vitamin)))

(deftransport ToTransportBiopterin
  :comment "GO:0015224"
  :across go/plasma_membrane 
  :cargo (owl-and ch/biopterin (owl-some has-biological-role ch/coenzyme)))

(deftransport ToTransportFattyAcid
  :comment "GO:0015245"
  :across go/plasma_membrane
  :cargo ch/fatty_acid)

(deftransport ToTransportR-3-hydroxybutyrate
  :comment "GO:0097253"
  :across go/plasma_membrane
  :cargo (owl-and ch/_R_-3-hydroxybutyrate (owl-some has-application-role ch/drug)))

(deftransport ToTransportShortChainFattyAcid
  :comment "GO:0015636"
  :across go/plasma_membrane
  :cargo ch/short-chain_fatty_acid)

;; Propanoate has no role antibiotic, but propionic acid does.
(deftransport ToTransportPropionicAcid
  :comment "GO:00155522"
  :across go/plasma_membrane
  :cargo (owl-and ch/propionic_acid (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportLongChainFattyAcid
  :comment "GO:0005324"
  :across go/plasma_membrane
  :cargo ch/long-chain_fatty_acid)

(deftransport ToTransportOleate
  :comment "GO:1901480"
  :across go/plasma_membrane
  :cargo ch/oleate)

(deftransport ToTransportFormate
  :comment "GO:0015499"
  :across go/plasma_membrane
  :cargo (owl-and ch/formate (owl-some has-biological-role ch/antimicrobial_drug)))

(deftransport ToTransportFormateEfflux
  :comment "GO:0015660"
  :across go/plasma_membrane
  :cargo (owl-and ch/formate (owl-some has-biological-role ch/antimicrobial_drug))
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportEctoine
  :comment "GO:0051471"
  :across go/plasma_membrane
  :cargo ch/ectoine)

(deftransport ToTransportShikimate
  :comment "GO:0015530"
  :across go/plasma_membrane
  :cargo ch/shikimate)

(deftransport ToTransport4-Hydroxyphenylacetate
  :comment "GO:1901241"
  :across go/plasma_membrane
  :cargo ch/_4-hydroxyphenylacetate)

(deftransport ToTransportMevalonate
  :comment "GO:0015130"
  :across go/plasma_membrane
  :cargo ch/mevalonate)

(deftransport ToTransportMannosylglycerate
  :comment "GO:0051477"
  :across go/plasma_membrane
  :cargo ch/D-mannosyl-D-glyceric_acid)

(deftransport ToTransportLactone
  :comment "GO:0042971"
  :across go/plasma_membrane
  :cargo ch/lactone)

(deftransport ToTransportOrganicPhosphonate
  :comment "GO:0015604"
  :across go/plasma_membrane
  :cargo ch/organic_phosphonate)

(deftransport ToTransportAlkylphosphonate
  :comment "GO:0042917"
  :across go/plasma_membrane
  :cargo ch/alkylphosphonate)

;; There is no metal ion in CHEBI
(deftransport ToTransportMetalIon
  :comment "GO:0046873"
  :across go/plasma_membrane
  :cargo ch/metal_cation)

(deftransport ToTransportMagnesiumIon
  :comment "GO:0015095"
  :across go/plasma_membrane
  :cargo ch/magnesium_cation)

(deftransport ToTransportCalciumIon
  :comment "GO:0015085"
  :across go/plasma_membrane
  :cargo ch/calcium_ion)

(deftransport ToTransportTransitionMetalIon
  :comment "GO:0046915"
  :across go/plasma_membrane
  :cargo ch/transition_element_cation)

(deftransport ToTransportVanadiumIon
  :comment "GO:0015100"
  :across go/plasma_membrane
  :cargo ch/vanadium_cation)

(deftransport ToTransportIronIon
  :comment "GO:0005381"
  :across go/plasma_membrane
  :cargo ch/iron_2+_)

(deftransport ToTransportManganeseIon
  :comment "GO:0005384"
  :across go/plasma_membrane
  :cargo ch/manganese_2+_)

(deftransport ToTransportMolybdenumIon
  :comment "GO:0042888"
  :across go/plasma_membrane
  :cargo ch/molybdenum_cation)

(deftransport ToTransportSilverIon
  :comment "GO:0015080"
  :across go/plasma_membrane
  :cargo ch/silver_cation)

(deftransport ToTransportCadmiumIon
  :comment "GO:0015086"
  :across go/plasma_membrane
  :cargo ch/cadmium_cation)

(deftransport ToTransportNickelCation
  :comment "GO:0015099"
  :across go/plasma_membrane
  :cargo ch/nickel_cation)

(deftransport ToTransportCobaltIon
  :comment "GO:0015087"
  :across go/plasma_membrane
  :cargo ch/cobalt_cation)

(deftransport ToTransportMercuryIon
  :comment "GO:0015097"
  :across go/plasma_membrane
  :cargo ch/mercury_cation)

(deftransport ToTransportCopperIon
  :comment "GO:0005375"
  :across go/plasma_membrane
  :cargo ch/copper_cation)

(deftransport ToTransportCopperChelate
  :comment "GO:0051981"
  :across go/plasma_membrane
  :cargo CopperChelate)

(deftransport ToTransportCopper-nicotianamine
  :comment "GO:0051982"
  :across go/plasma_membrane
  :cargo Copper-nicotianamine)

(deftransport ToTransportPolyamine
  :comment "GO:0015203"
  :across go/plasma_membrane
  :cargo ch/polyamine)

(deftransport ToTransportSpermine
  :comment "GO:0000297"
  :across go/plasma_membrane
  :cargo (owl-and ch/spermine (owl-some has-application-role ch/drug)))

(deftransport ToTransportChloride
  :comment "GO:0015108"
  :across go/plasma_membrane
  :cargo ch/chloride)

(deftransport ToTransportWithChemicalCondition
  :across go/plasma_membrane
  :cargo ch/chemical_entity
  :when ch/chemical_entity)

(deftransport ToTransportPhosphateWithSodiumCondition
  :comment "GO:0015321"
  :across go/plasma_membrane
  :cargo ch/phosphate_ion
  :when ch/sodium_1+_)

(deftransport ToTransportBicozamycin
  :comment "GO:0015545"
  :across go/plasma_membrane
  :cargo (owl-and ch/bicozamycin (owl-some has-biological-role ch/bicozamycin)))

(deftransport ToTransportCCCP
  :comment "GO:0015549"
  :comment "carbonyl cyanide m-chlorophenylhydrazone transmembrane transporter"
  :across go/plasma_membrane
  :cargo ch/CCCP)

(deftransport ToTransportOrganomercurial
  :comment "GO:0015548"
  :across go/plasma_membrane
  :cargo ch/organomercury_compound)

(deftransport ToTransportHeme
  :comment "GO:0015232"
  :across go/plasma_membrane
  :cargo (owl-and ch/heme (owl-some has-biological-role ch/cofactor)))

;; Enables the directed movement of proteins into, out of or within a cell, or between cells. 
(deftransport ToTransportProtein
  :comment "GO:0008565"
  :cargo ch/protein)

(deftransport ToTransportLipoprotein
  :comment "GO:0042954"
  :cargo ch/lipoprotein)

(deftransport ToTransportGlycoprotein
  :comment "GO:0034437"
  :cargo ch/glycoprotein)

(deftransport ToTransportGlycolipid
  :comment "GO:0034202"
  :cargo ch/glycolipid)
