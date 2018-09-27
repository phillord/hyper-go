(ns hyper-go.ATPase_coupled
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]))


(ontology-to-namespace hyper-go.core/hyper-go)

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
  ["Copper"                 	"GO:0043682"    ch/copper_2+_]
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
  ["Phospholipid"           	"GO:0004012"    ch/phospholipid]
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
  ["Methionine"		"GO:1901243"	ch/methionine]
  ["Sphingolipid"		"GO:0046623"	ch/sphingolipid]
  ["Ceramide"			"GO:0099038"	ch/ceramide]   ;;Need Review
  ["Phosphatidylserine"	"GO:0090556"	ch/phosphatidyl-L-serine]
  ["Phosphatidylethanolamine"	"GO:0090555"	ch/phosphatidylethanolamine]
  ["Phosphatidylcholine"	"GO:0090554"	ch/phosphatidylcholine]
  ["Phytochelatin"		"GO:0044604"	ch/phytochelatin]
  )


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



(deftransport ToTransportCalciumTransportingDrivenWithATPase
  :comment "GO:1905059"
  :comment "InvolvedInRegulationOfPostsynapticCytosolicCalciumIonConcentration"
  :across Membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :involved PostsynapticCytosolic
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                          (owl-some transports-to ExtracellularRegion))
                 (owl-and (owl-some transports-from ExtracellularRegion)
                          (owl-some transports-to Intracellular))))


(deftransport ToTransportCalciumTransportingDrivenWithATPase
  :comment "GO:1905056"
  :comment "InvolvedInRegulationOfPresynapticCytosolicCalciumIonConcentration"
  :across Membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :involved PresynapticCytosolic
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                          (owl-some transports-to ExtracellularRegion))
                 (owl-and (owl-some transports-from ExtracellularRegion)
                          (owl-some transports-to Intracellular))))


(deftransport ToTransportCalciumTransportingDrivenWithATPase
  :comment "GO:0086039"
  :comment "InvolvedInRegulationOfCardiacMuscleCellMembranePotential"
  :across Membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :involved CardiacMuscleCellMembranePotential
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                          (owl-some transports-to ExtracellularRegion))
                 (owl-and (owl-some transports-from ExtracellularRegion)
                          (owl-some transports-to Intracellular))))



;; Both Na+ and K+ are going against their concentration gradient
;; ATP + H2O + Na+(in) + K+(out) = ADP + phosphate + Na+(out) + K+(in). 
(deftransport ToTransportSodiumPotassiumExchangingDrivenWithATPase
  :comment "GO:0005391"
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
         (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))

(deftransport ToTransportSodiumPotassiumExchangingDrivenWithATPase
  :comment "GO:0086037"
  :comment "InvolvedInRegulationOfCardiacMuscleCellMembranePotential"
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
         (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :involved CardiacMuscleCellMembranePotential
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))


;; Both Na+ and H+ are going against their concentration gradient
(deftransport ToTransportPotassiumProtonExchangingDrivenWithATPase
  :comment "GO:0008900"
  :cargo (owl-and ch/potassium_1+_  (owl-some hasConcentration LowConcentration))
         (owl-and ch/proton  (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :super (owl-or (owl-and (owl-some transports-from Intracellular)
                               (owl-some transports-to ExtracellularRegion))
                      (owl-and (owl-some transports-from ExtracellularRegion)
                               (owl-some transports-to Intracellular))))







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

(save-ontology "hyper-go.owl" :owl)
