(ns hyper-go.TA.ATP_coupled
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny-go.go :as go]
            [tawny.emacs  :refer :all]))

(ontology-to-namespace hyper-go.core/HyperGo)

;; A substance or substances transported either from the inside of the cell to the outside and and vice versa.
;; Driven by ATP Hydrolysis
(defn substance-transporting-ATP_Hydrolysis [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransmembraneDrivenWithATPase"))
     :annotation (goid ~(second lis))
     :across go/membrane
     :system Active
     :driven ATP_Hydrolysis
     :cargo
     ~(cond (= 3 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration))
            (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 3) ~(nth lis 4)))
            (= 6 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 3) ~(nth lis 4) ~(nth lis 5)))
            (= 7 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6)))
            (= 8 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6) ~(nth lis 7)))
            :else (println "Class data out of the range"))))

;; macro function to do the classes mapping 
(defmacro deftransporters-driven-by-ATP_Hydrolysis [& lis]
  `(do ~@(map substance-transporting-ATP_Hydrolysis lis)))

;; Substances driven by ATP_Hydrolysis 
(deftransporters-driven-by-ATP_Hydrolysis
  ["Substance"                  "GO:0042626"    ch/chemical_entity]
  ["Thiamine"			"GO:0048502"	ch/thiamine]
  ["Beta-glucan"		"GO:0015441"	ch/beta-D-glucan]
  ["Ion"			"GO:0042625"	ch/ion]
  ["Cation"                 	"GO:0019829"    ch/cation]
  ["Ferric"                 	"GO:0015408"    ch/iron_3+_]
  ["Calcium"                	"GO:0005388"    ch/calcium_2+_ ]
  ["Copper"                 	"GO:0043682"    ch/copper_2+_]
  ["Cobalt"			"GO:0032778"	ch/cobalt_cation]
  ["Arsenite"			"GO:0015446"	ch/arsenate_ion]
  ["Manganese"              	"GO:0015410"    ch/manganese_2+_]
  ["Nickel"			"GO:0015413"	ch/nickel_2+_]
  ["Lipid"			"GO:0034040"	ch/lipid]
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
  ["ProtohemeIX"		"GO:0103115"	ch/heme_b]
  ["Alpha-D-Galactofuranose"	"GO:0103116"	ch/UDP-alpha-D-galactofuranose] 	;; Not entirely sure
  ["Phospholipid"           	"GO:0004012"    ch/phospholipid]
  ["Glycerol-3Phosphate"	"GO:0015430"	ch/sn-glycerol_3-phosphate]
  ["GlutathioneS-conjugate" 	"GO:0071997"	ch/glutathione_conjugate]		;; linked to broad term in ChEBI
  ["Glycerol-2-phosphate"	"GO:0070812"	ch/glycerol_2-phosphate]
  ["LipoChitinOligosaccharide" "GO:1901514" 	ch/lipo-chitin_oligosaccharide]
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
  ["Taurine"                	"GO:0015411"    ch/taurine              has-biological-role ch/xenobiotic]   ;; xenobiotic or  EC_3.6.3.44  is it a drug?
  ["CarboxylicAcid"		"GO:0033284"	ch/carboxylic_acid]
  ["AminoAcid"			"GO:0015424"	ch/amino_acid]
  ["NonpolarAminoAcid"		"GO:0015425"	ch/nonpolar_amino_acid]
  ["PolarAminoAcid"		"GO:0015426"	ch/polar_amino_acid]
  ["Urea"			"GO:0033221"	ch/urea]
  ["Doxorubicin"		"GO:1901242"	ch/doxorubicin]
  ["Daunorubicin"		"GO:0043216"	ch/daunorubicin	has-application-role ch/drug]
  ["PeptideAntigen"		"GO:0015433"	ch/peptide              has-biological-role ch/antigen]
  ["Xenobiotic"		"GO:0008559"	ch/chemical_entity	has-biological-role ch/xenobiotic]
  ["QuaternaryAmmoniumIon"  	"GO:0015418"	ch/quaternary_ammonium_ion]
  ["Cadmium"			"GO:0015434"	ch/cadmium_cation]
  ["CapsularPolysaccharide" 	"GO:0015436"	ch/polysaccharide]
  ["TeichoicAcid"		"GO:0015438"	ch/teichoic_acid]
  ["Protein"			"GO:0015462"	ch/protein]
  ["ThiaminePyrophosphate"	"GO:0015619"	ch/thiamine_1+__diphosphate_1-_]
  ["Iron-chelate"		"GO:0015623"	ch/iron_chelate]
  ["FerricEnterobactin"	"GO:0015624"	ch/ferrienterobactin]
  ["FerricHydroxamate"		"GO:0015625"	ch/iron_III__hydroxamate]
  ["Zinc"			"GO:0015633"	ch/zinc_2+_]
  ["Amine"			"GO:0031263"	ch/amine]
  ["Betaine"			"GO:0031458"	ch/betaine_aldehyde]
  ["GlycineBetaine"		"GO:0031459"	ch/glycine_betaine]
  ["Thiosulfate"		"GO:0102025"	ch/thiosulfate]
  ["2-aminoethylphosphonate"	"GO:0033225"	ch/_2-aminoethyl_phosphonic_acid]
  ["Cysteine"			"GO:0033230"	ch/cysteine]
  ["D-methionine"		"GO:0033232"	ch/D-methionine]
  ["MonocarboxylicAcid"	"GO:0033285"	ch/monocarboxylic_acid]
  ["Ectoine"			"GO:0033286"	ch/ectoine]
  ["Hydroxyectoine"		"GO:0033288"	ch/_5-hydroxyectoine]
  ["Bacteriocin"		"GO:0043214"	ch/bacteriocin         has-biological-role ch/antimicrobial_drug]
  ["Methionine"		"GO:1901243"	ch/methionine]
  ["Phytochelatin"		"GO:0044604"	ch/phytochelatin]
  ["Cobalamin"                  "GO:0015420"    ch/cobalamin          has-biological-role ch/vitamin])


(deftransport ToTransportLipidsIntramembraneDrivenWithATPase
  :annotation (goid "GO:0140326")
  :system Active
  :driven ATP_Hydrolysis
  :from go/leaflet_of_membrane_bilayer
  :to go/leaflet_of_membrane_bilayer
  :cargo (owl-and ch/lipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportLipidsIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140327")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/lipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportAminophospholipidIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0015247")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/aminophospholipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPhosphatidylserineIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140346")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/phosphatidyl-L-serine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportGlycosylceramideIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140351")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/glycosylceramide (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportGlycerophospholipidIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140333")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/glycerophospholipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportN-retinylidene-phosphatidylethanolamineIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140347")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/N-retinylidenephosphatidylethanolamine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportLysophosphatidylcholineIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140348")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/lysophosphatidylcholine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPhosphatidylethanolamineIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0090555")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/phosphatidylethanolamine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPhosphatidylcholineIntramembraneFlippaseDrivenWithATPase
  :annotation (goid "GO:0140345")
  :system Active
  :driven ATP_Hydrolysis
  :from go/ectoplasm
  :to go/cytoplasmic_side_of_endosome_membrane
  :cargo (owl-and ch/phosphatidylcholine (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportlipidIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0140328")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/lipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportSphingolipidIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:004662")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/sphingolipid (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportCeramideIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0099038")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/ceramide (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportLipopolysaccharideIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0015437")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/lipopolysaccharide (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPhosphatidylcholineIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0090554")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/phosphatidylcholine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPhosphatidylserineIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0090556")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/phosphatidyl-L-serine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportGlycolipidIntramembraneFloppaseDrivenWithATPase
  :annotation (goid "GO:0034202")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/glycolipid (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportPhosphatidylethanolamineIntramembraneFloppaseDrivenWithATPase
  :annotation (goid"GO:0140341")
  :system Active
  :driven ATP_Hydrolysis
  :from go/cytoplasmic_side_of_endosome_membrane
  :to  go/ectoplasm
  :cargo (owl-and ch/phosphatidylethanolamine (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportIonTransmembraneDrivenWithATPaseInvolvedInRegulationOfPresynapticMembranePotential
  :annotation (goid "GO:0099521")
  :comment "Involved in regulation of presynaptic membrane potential"
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :occurs go/presynaptic_membrane
  :involved go/regulation_of_presynaptic_membrane_potential
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportIonTransmembraneDrivenWithATPaseInvolvedInRegulationOfPostsynapticMembranePotential
  :annotation (goid "GO:0099581")
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :occurs go/postsynaptic_membrane
  :involved go/regulation_of_postsynaptic_membrane_potential
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration)))


;; ATP + H2O + ion(in) = ADP + phosphate + ion(out), by a rotational mechanism. 
(deftransport ToTransportIonsTransmembraneDrivenWithATPaseViaRotationalMechanism
  :annotation (goid "GO:0044769")
  :across go/membrane
  :system Active
  :ion-mechanism Rotational
  :driven ATP_Hydrolysis
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportIonsTransmembraneDrivenWithATPaseViaPhosphorylativeMechanism
  :annotation (goid "GO:0015662")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportProtonTransmembraneDrivenWithATPaseViaRotationalMechanism
  :annotation (goid "GO:0046961")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Rotational
  :cargo (owl-and ch/proton (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportProtonTransmembraneDrivenWithATPaseViaPhosphorylativeMechanism
  :annotation (goid "GO:0008553")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and ch/proton (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportSodiumTransmembraneDrivenWithATPaseViaRotationalMechanism
  :annotation (goid "GO:0046962")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Rotational
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportSodiumTransmembraneDrivenWithATPaseViaPhosphorylativeMechanism
  :annotation (goid "GO:0008554")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportProteinTransmembraneDrivenWithATPaseIntoMitochondrion
  :annotation (goid "GO:0008566")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :from go/extracellular_region
  :to go/intracellular go/mitochondrion)

(deftransport ToTransportProteinTransmembraneDrivenWithATPaseIntoChloroplast
  :annotation (goid "GO:0016464")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :from go/extracellular_region
  :to go/intracellular go/chloroplast)


(deftransport ToTransportCalciumTransmembraneDrivenWithATPaseInvolvedInRegulationOfPostsynapticCytosolicCalciumIonConcentration
  :annotation (goid "GO:1905059")
  :comment "Involved in regulation of postsynaptic cytosolic calcium ion concentration"
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :involved go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration 
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportCalciumTransmembraneDrivenWithATPaseInvolvedInRegulationOfPresynapticCytosolicCalciumIonConcentration
  :annotation (goid "GO:1905056")
  :comment "Involved in regulation of presynaptic cytosolic calcium ion concentration"
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :involved go/regulation_of_presynaptic_cytosolic_calcium_ion_concentration
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportCalciumTransmembraneDrivenWithATPaseInvolvedInRegulationOfCardiacMuscleCellMembranePotential
  :annotation (goid "GO:0086039")
  :comment "Involved In Regulation Of Cardiac Muscle Cell Membrane Potential"
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration)))


(deftransport ToTransportPotassiumTransmembraneDrivenWithATPaseViaPhosphorylativeMechanism
  :annotation (goid "GO:0008556")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration)))


;; Both Na+ and K+ are going against their concentration gradient
;; ATP + H2O + Na+(in) + K+(out) = ADP + phosphate + Na+(out) + K+(in). 
(deftransport ToTransportSodiumPotassiumExchangingTransmembraneDrivenWithATPase
  :annotation (goid "GO:0005391")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
                  (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))))


;; Both Na+ and H+ are going against their concentration gradient
(deftransport ToTransportPotassiumProtonExchangingTransmembraneDrivenWithATPas
  :annotation (goid "GO:0008900")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :cargo (owl-and (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
                  (owl-and ch/proton  (owl-some hasConcentration LowConcentration))))



;; Both Na+ and K+ are going against their concentration gradient
;; ATP + H2O + Na+(in) + K+(out) = ADP + phosphate + Na+(out) + K+(in).
(deftransport ToTransportSodiumPotassiumExchangingTransmembraneDrivenWithATPaseInvolvedInRegulationOfCardiacMuscleCellMembranePotential
  :annotation (goid "GO:0086037")
  :across go/membrane
  :system Active
  :driven ATP_Hydrolysis
  :ion-mechanism Phosphorylative
  :comment "Involved In Regulation Of Cardiac Muscle Cell Membrane Potential"
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :cargo (owl-and (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
                  (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))))



;; ;;Influx/Efflux Transmembrane transporter Driven by ATP_Hydrolysis
(defn substance-exporting-ATP_Hydrolysis [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransmembraneDrivenWithATPase"))
     :annotation (goid ~(second lis))
     :across go/membrane
     :system Active
     :driven ATP_Hydrolysis
     :from ~(nth lis 2)
     :to ~(nth lis 3)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration))
            (= 7 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 5) ~(nth lis 6)))
            (= 8 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 5) ~(nth lis 6) ~(nth lis 7)))
            (= 9 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8)))
            (= 10 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8) ~(nth lis 9)))
            (= 11 (count lis))
            `(owl-and ~(nth lis 4) (owl-some hasConcentration LowConcentration)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8))
                      (owl-some ~(nth lis 9) ~(nth lis 10)))
            :else (println "Class data out of the range"))))


;; macro function to do the classes mapping 
(defmacro defexporters-drivenby-ATP_Hydrolysis [& lis]
  `(do ~@(map substance-exporting-ATP_Hydrolysis lis)))


; map values
(defexporters-drivenby-ATP_Hydrolysis
  ["CopperEfflux"			"GO:0004008"	go/intracellular  go/extracellular_region ch/copper_2+_]
  ["CadmiumEfflux"			"GO:0008551"    go/intracellular  go/extracellular_region ch/cadmium_2+_]
  ["ProtonEfflux"			"GO:0036442"	go/intracellular  go/extracellular_region ch/proton]
  ["ProteinEfflux"			"GO:0008564"	go/intracellular  go/extracellular_region ch/protein]
  ["GlutathioneS-conjugateEfflux" 	"GO:0015431"	go/intracellular  go/extracellular_region ch/glutathione_conjugate]
  ["BileAcidEfflux"		        "GO:0015432"	go/intracellular  go/extracellular_region ch/bile_acid]
  ["SilverEfflux"			"GO:0015445"	go/intracellular  go/extracellular_region ch/silver_1+_]
  ["ZincEfflux"			"GO:0016463"	go/intracellular  go/extracellular_region ch/zinc_2+_]
  ["AminoAcidEfflux"		        "GO:0032518"	go/intracellular  go/extracellular_region ch/amino_acid]
  ["CysteineEfflux"		        "GO:0032519"	go/intracellular  go/extracellular_region ch/cysteine]
  ["D-methionineEfflux"		"GO:0032521"	go/intracellular  go/extracellular_region ch/D-methionine]
  ["CarbohydrateEfflux"		"GO:0043212"	go/intracellular  go/extracellular_region ch/carbohydrate]
  ["GlucosylOleandomycinEfflux"	"GO:0103113"	go/intracellular  go/extracellular_region ch/oleandomycin]  ;; Not entirely sure
  ["MagnesiumInflux"			"GO:0015444"	go/extracellular_region go/intracellular  ch/magnesium_2+_ ]
  ["PutrescineInflux"			"GO:0015594"	go/extracellular_region go/intracellular  ch/putrescine]
  ["SpermidineInflux"			"GO:0015595"	go/extracellular_region go/intracellular  ch/spermidine]
  ["CarbohydrateInflux"		"GO:0015608"	go/extracellular_region go/intracellular  ch/carbohydrate]
  ["MaltooligosaccharideInflux"	"GO:0015609"	go/extracellular_region go/intracellular  ch/maltooligosaccharide]
  ["GlycerolPhosphateInflux"		"GO:0015610"	go/extracellular_region go/intracellular  ch/sn-glycerol_3-phosphate]
  ["D-alloseInflux"			"GO:0015615"	go/extracellular_region go/intracellular  ch/D-allose]
  ["AminoAcidInflux"		        "GO:0032520"	go/extracellular_region go/intracellular  ch/amino_acid]
  ["D-methionineInflux"		"GO:0032522"	go/extracellular_region go/intracellular  ch/D-methionine]
  ["L-glutamateInflux"		        "GO:0102013"	go/extracellular_region go/intracellular  ch/L-glutamate_1-_]
  ["Beta-D-galactoseInflux"	        "GO:0102014"	go/extracellular_region go/intracellular  ch/beta-D-galactoside]
  ["Glutamine"                          "GO:0015599"    go/extracellular_region go/intracellular  ch/glutamine  hasEnantiomerism L-Enantiomer has-application-role ch/drug hasAcidity Neutral]
  ["Arginine"                           "GO:0015598"    go/extracellular_region go/intracellular  ch/arginine  hasAcidity Alkaline]
  ["L-arginine"                         "GO:0102022"    go/extracellular_region go/intracellular  ch/L-arginine hasAcidity Alkaline has-application-role ch/drug]
  ["D-ribose"                           "GO:0015611"    go/extracellular_region go/intracellular  ch/D-ribose   hasEnantiomerism D-Enantiomer]
  ["D-xylose"                           "GO:0015614"    go/extracellular_region go/intracellular  ch/D-xylose   hasEnantiomerism D-Enantiomer]
  ["L-arabinose"                        "GO:0015612"    go/extracellular_region go/intracellular  ch/L-arabinose  hasEnantiomerism L-Enantiomer])
