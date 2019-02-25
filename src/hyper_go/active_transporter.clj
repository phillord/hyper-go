(ns hyper-go.active_transporter
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny-go.go :as go]))


(ontology-to-namespace hyper-go.core/HyperGo)

;; Requires energy to transports molecules.
;; Move molecules against thier concentration gradient
(deftransport ToTransportSoluteByActiveTransmembraneTransporter
  :comment "GO:0022804"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or EnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

(deftransport ToTransportSoluteByActiveTransmembraneDrivenByDecarboxylation
  :comment "GO:0015451"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven Decarboxylation)

;; methyl transfer-driven active transmembrane transporter
(deftransport ToTransportSoluteByActiveTransmembraneDrivenByMethyltransfer
  :comment "GO:0015452"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and Methyl_transfer_reaction (owl-some hasConcentration HighConcentration)))

;; light-driven active transmembrane transporter 
(deftransport ToTransportSoluteByActiveTransmembraneDrivenByLight
  :comment "GO:0015454"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and Light (owl-some hasConcentration HighConcentration)))

;; active ion transmembrane transporter activity
(deftransport ToTransportIonByActiveTransmembraneTransporter
  :comment "GO:0022853"
  :across go/plasma_membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-or EnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

;; classified in GO as primary and secondary active transporter. !!classified in GO as primary and secondary active transporter. !!
(deftransport ToTransportProteinByActiveTransmembraneTransporterDivenByProton
  :comment "GO:0009977"
  :across go/plasma_membrane
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :driven (owl-and pH-dependent (owl-some hasConcentration HighConcentration)))

;; 2-aminoethylphosphonate transmembrane transporter activity
(deftransport ToTransport2-aminoethylphosphonateActiveTransmembrane
  :comment "GO:0033224"
  :across go/plasma_membrane
  :cargo (owl-and ch/_2-aminoethyl_phosphonic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-or EnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))


;; monoamine transmembrane transporter activity
(deftransport ToTransportMonoamineByActiveTransmembraneTransporter
  :comment "GO:0008504"
  :across go/plasma_membrane
  :cargo (owl-and ch/monoamine (owl-some hasConcentration LowConcentration))
  :driven (owl-or EnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

;;; ===========================================
;; ======  Active transport driven by PEP =====
;;;============================================

;;https://www.sciencedirect.com/science/article/pii/002196739500457X
;;http://europepmc.org/abstract/MED/8246840
(deftransport ToTransportGlucoseDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090564"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/glucose_phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


;;https://www.sciencedirect.com/science/article/pii/002196739500457X
;;http://europepmc.org/abstract/MED/8246840
(deftransport ToTransportMannitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090565"
  :across go/plasma_membrane
  :cargo (owl-and ch/mannitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-mannitol_1-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


;;https://www.sciencedirect.com/science/article/pii/002196739500457X
(deftransport ToTransportNN-diacetylchitobioseDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090566"
  :across go/plasma_membrane
  :cargo (owl-and ch/N_N'-diacetylchitobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/diacetylchitobiose-6'-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



;;https://www.sciencedirect.com/science/article/pii/002196739500457X
(deftransport ToTransportMannosylglycerateDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090581"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-mannosyl-D-glyceric_acid (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/_2-O-_6-phospho-alpha-D-mannosyl_-D-glycerate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportD-fructoseDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090582"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-fructose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-fructose_1-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportD-sorbitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090583"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-glucitol_3-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportGalactitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090584"
  :across go/plasma_membrane
  :cargo (owl-and ch/galactitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/galactitol_1-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportL-ascorbateDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090585"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-ascorbate (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/L-ascorbate_6-phosphate_3-_
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportN-acetylglucosamineDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090586"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylglucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/N-acetyl-D-galactosamine_6-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportGlucosamineDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090587"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-glucosamine_6-phosphate
           (owl-some transports-from go/extracellular_region)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportN-acetylmuramateDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090588"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylmuramate (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/N-acetylmuramate_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven Phosphoenolpyruvate)

(deftransport ToTransportTrehaloseDrivenByPhosphocysteinePhosphoenolpyruvate
  :comment "GO:0090589"
  :across go/plasma_membrane
  :cargo (owl-and ch/trehalose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/alpha_alpha-trehalose_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


;; https://www.sciencedirect.com/science/article/pii/S0959440X97801480
(deftransport ToTransportD-glucosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0090590"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-glucosamine_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

;; https://www.sciencedirect.com/science/article/pii/S0959440X97801480
(deftransport ToTransportN-acetyl-mannosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0090591"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylmannosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/aldehydo-N-acetyl-D-mannosamine_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportGlucoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022855"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/glucose_phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportNN-diacetylchitobioseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0090562"
  :across go/plasma_membrane
  :cargo (owl-and ch/N_N'-diacetylchitobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/diacetylchitobiose-6'-phosphate 
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportGlucoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022855"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/glucose_phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportGlucitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022856"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/glucitol_phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportLactoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022869"
  :across go/plasma_membrane
  :cargo (owl-and ch/lactose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/lactose_6'-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportMannoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022870"
  :across go/plasma_membrane
  :cargo (owl-and ch/mannose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/mannose_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportSorboseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022871"
  :across go/plasma_membrane
  :cargo (owl-and ch/sorbose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/sorbose_1-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportMannitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022872"
  :across go/plasma_membrane
  :cargo (owl-and ch/mannitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/D-mannitol_1-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportMaltoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022873"
  :across go/plasma_membrane
  :cargo (owl-and ch/maltose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/maltose_6'-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportCellobioseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022874"
  :across go/plasma_membrane
  :cargo (owl-and ch/cellobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/_6-phospho-beta-D-glucosyl-_1->4_-D-glucose (owl-some transports-to go/intracellular)
                  (owl-some transports-from go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportGalactitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022875"
  :across go/plasma_membrane
  :cargo (owl-and ch/galactitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/galactitol_1-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportGalactosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022876"
  :across go/plasma_membrane
  :cargo (owl-and ch/galactosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/galactosamine_phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportFructoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022877"
  :across go/plasma_membrane
  :cargo (owl-and ch/fructose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/fructose_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportSucroseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022878"
  :across go/plasma_membrane
  :cargo (owl-and ch/sucrose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/sucrose_6_F_-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportTrehaloseDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022879"
  :across go/plasma_membrane
  :cargo (owl-and ch/trehalose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/trehalose_phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportN-acetylglucosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022880"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylglucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/N-acetyl-D-glucosamine_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportN-acetylgalactosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022881"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylgalactosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/N-acetyl-D-galactosamine_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportBeta-glucosideDrivenByPhosphohistidinePhosphoenolpyruvate
  :comment "GO:0022882"
  :across go/plasma_membrane
  :cargo (owl-and ch/beta-glucoside (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/extracellular_region))
         (owl-and ch/_2-nitrophenyl_beta-D-glucoside_6-phosphate
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

;; =====================================================
;;============== Primary Active transporters =========
;;======================================================

;; Requires energy to transports molecules.
;; The energy derived directly from the breakdown of ATP.
(deftransport ToTransportSoluteByPrimaryActiveTransmembrane
  :comment "GO:0015399"
  :across go/plasma_membrane
  :driven (owl-or ATP_Hydrolysis ATP_Synthesis Oxidoreduction Decarboxylation Methyl_transfer_reaction Light)
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration)))

;; oxidoreduction-driven active transmembrane transporter activity
(deftransport ToTransportSoluteDrivenByOxidoreduction
  :comment "GO:0015453"
  :across go/plasma_membrane
  :driven Oxidoreduction
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportSoluteDrivenByHydrolysis
  :comment "GO:0015405"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATP_Hydrolysis ATP_Synthesis))

(deftransport ToTransportProteinDrivenByHydrolysis
  :comment "GO:0015450"
  :across go/plasma_membrane
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATP_Hydrolysis ATP_Synthesis))


;; =====================================================
;;============== Secondary Active transporters =========
;;======================================================

;;Enables the transfer of a solute from one side of a membrane to the other, up its concentration gradient.
;;Transport works equally well in either direction and is driven by a chemiosmotic source of energy, not direct ATP coupling.
;;Secondary active transporters include symporters and antiporters.
(deftransport ToTransportSecondaryActiveTransmembrane
  :comment "GO:0015291"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

;;#A substance or substances transported according to the reaction:
;;Solute (out) + n[H+ or Na+] (out) → Solute (in) + n[H+ or Na+] (in)
;; Driven by sodium symporter
(defn secondary-substance-transporters [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "SecondaryActiveTransmembrane"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some ~(nth lis 3) ~(nth lis 4)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
     :across go/plasma_membrane
     :direction (owl-or SameDirection OppositeDirection)))


;; macro function to do the classes mapping 
(defmacro defsecondary-substance-transporters [& lis]
  `(do ~@(map secondary-substance-transporters lis)))

(defsecondary-substance-transporters
  ["Antimonite"		"GO:0042960"		ch/antimonite]
  ["Tricarboxylate"		"GO:0005371"		ch/tricarboxylic_acid_trianion]
  ["Citrate"			"GO:0071913"		ch/citric_acid]
  ["SulfurContainingAminoAcid"	"GO:1901680"		ch/sulfur-containing_amino_acid]
  ["Cystine"			"GO:0015328"		ch/cystine hasAcidity Neutral]
  ["Peptide-acetyl-CoA"	"GO:0015324"		ch/acetyl-CoA]
  ["ThyroidHormone"		"GO:0015349"		ch/chemical_entity has-biological-role ch/thyroid_hormone]
  ["P-aminobenzoyl-Glutamate"	"GO:0015558"		ch/N-_4-aminobenzoyl_-L-glutamic_acid]
  ["Sulfate"			"GO:0008271"		ch/sulfate]
  ["Oligopeptide"		"GO:0015322"		ch/oligopeptide]
  ["Arsenite"			"GO:0008490"		ch/arsenate_3-_]
  ["InorganicPhosphate"	"GO:0005315"		ch/inorganic_phosphate]
  ["Oxaloacetate"		"GO:0000227"		ch/oxaloacetate_2-_]
  ["Sterol"			"GO:0015352"		ch/sterol]
  ["Bilirubin"			"GO:0015351"		ch/bilirubin]
  ["Nucleoside"		"GO:0010174"		ch/nucleoside] ;; http://www.tcdb.org/search/result.php?tc=2.a.31
  ["Cyanate"			"GO:0015541"		ch/cyanate]
  ["Pyruvate"			"GO:0005477"		ch/pyruvate]
  ["OrganicCation"		"GO:0008513"		ch/organic_cation]
  )

(deftransport ToTransportHighAffinityNitriteSecondaryActiveTransmembrane
  :comment "GO:0015513"
  :across go/plasma_membrane
  :cargo (owl-and ch/nitrite (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportMonocarboxylicAcidSecondaryActiveTransmembrane
  :comment "GO:0015355"
  :across go/plasma_membrane
  :cargo (owl-and ch/monocarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportHighAffinitySulfateSecondaryActiveTransmembrane
  :comment "GO:0015381"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction (owl-or SameDirection OppositeDirection))


(deftransport ToTransportHighAffinityAmmoniumSecondaryActiveTransmembrane
  :comment "GO:0015398"
  :across go/plasma_membrane
  :cargo (owl-and ch/ammonium (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction (owl-or SameDirection OppositeDirection))


(deftransport ToTransportLowAffinityAmmoniumSecondaryActiveTransmembrane
  :comment "GO:0015400"
  :across go/plasma_membrane
  :cargo (owl-and ch/ammonium (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction (owl-or SameDirection OppositeDirection))


(deftransport ToTransportPeptideSecondaryActiveTransmembrane
  :comment "GO:0022897"
  :across go/plasma_membrane
  :cargo (owl-and ch/peptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportOligopeptideSecondaryActiveTransmembrane
  :comment "GO:0005427"
  :across go/plasma_membrane
  :cargo (owl-and ch/oligopeptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportNeutralL-AminoAcidSecondaryActiveTransmembrane
  :comment "GO:0005294"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-alpha-amino_acid  (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral) (owl-some hasEnantiomerism L-Enantiomer))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton)(owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportL-methionineSecondaryActiveTransmembrane
  :comment "GO:0000102"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-methionine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton) (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

;; http://www.tcdb.org/search/result.php?tc=2.A.41
(deftransport ToTransportZincIonEffluxActive
  :comment "GO:0015341"
  :across go/plasma_membrane
  :cargo (owl-and ch/zinc_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :from go/intracellular
  :to go/extracellular_region)

(deftransport ToTransportActiveBorate
  :comment "GO:0046715"
  :across go/plasma_membrane
  :cargo (owl-and ch/borate (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; =====================================================
;;============== Symporter Secondary Active transporters =========
;;======================================================

;;solute(out) + cation(out) = solute(in) + cation(in).
;; The cation is Na+, Li+ or H+. 
(deftransport ToTransportSolute:CationSymporter
  :comment "GO:0015294"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAcetate:CationSymporter
  :comment "GO:0043893"
  :across go/plasma_membrane
  :cargo (owl-and ch/acetate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAnion:CationSymporter
  :comment "GO:0015296"
  :across go/plasma_membrane
  :cargo (owl-and ch/inorganic_anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportCalcium:CationAntiporter
  :comment "GO:0015368"
  :across go/plasma_membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportChloride:CationSymporter
  :comment "GO:0015377"
  :across go/plasma_membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportChloride:PotassiumSymporter
  :comment "GO:0015379"
  :across go/plasma_membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportCarbohydrate:CationSymporter
  :comment "GO:0005402"
  :across go/plasma_membrane
  :cargo (owl-and ch/carbohydrate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportMelibiose:CationSymporter
  :comment "GO:0015487"
  :across go/plasma_membrane
  :cargo (owl-and ch/melibiose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycoside-Pentoside-Hexuronide:CationSymporter
  :comment "GO:0015486"
  :across go/plasma_membrane
  :cargo (owl-and (owl-or ch/glycoside ch/pentoside ch/hexuronate)
                          (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlucuronate:CationSymporter
  :comment "GO:0015488"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucuronate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportSucrose:CationSymporter
  :comment "GO:0009669"
  :across go/plasma_membrane
  :cargo (owl-and ch/sucrose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAminoAcid:CationSymporter
  :comment "GO:0005416"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportNucleobase:CationSymporter
  :comment "GO:0015391"
  :across go/plasma_membrane
  :cargo (owl-and ch/nucleobase (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportUracil:CationSymporter
  :comment "GO:0015505"
  :across go/plasma_membrane
  :cargo (owl-and ch/uracil (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportHexuronate:CationSymporter
  :comment "GO:0015539"
  :across go/plasma_membrane
  :cargo (owl-and ch/hexuronate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportSialate:CationSymporter
  :comment "GO:0015306"
  :across go/plasma_membrane
  :cargo (owl-and ch/N-acetylneuraminic_acid (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/antimicrobial_drug))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAminoAcid:PotassiumSymporter
  :comment "GO:0017032"
  :across go/plasma_membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


;;=====================================================
;;==== Sodium symporter Secondary Active transporters =
;;======================================================


(deftransport ToTransportSymporterActivity
  :comment "GO:0015293"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven  (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;;#A substance or substances transported according to the reaction:
;;solute(out) + Na+(out) = solute(in) + Na+(in).
;; Driven by sodium symporter
(defn substance-drivenby-sodium-symporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) ":SodiumSymporter"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some ~(nth lis 3) ~(nth lis 4)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
     :across go/plasma_membrane
     :direction SameDirection))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-sodium-symporter [& lis]
  `(do ~@(map substance-drivenby-sodium-symporter lis)))

;; Substances driven by Sodium_ion 
(deftransporters-drivenby-sodium-symporter
  ["Solute"			"GO:0015370"	ch/chemical_entity]
  ["Galactoside"		"GO:0044669"	ch/galactoside]
  ["Anion"			"GO:0015373"	ch/inorganic_anion]
  ["Iodide"			"GO:0008507"	ch/iodide]
  ["Chloride"			"GO:0015378"	ch/chloride]
  ["Sulfate"			"GO:0015382"	ch/sulfate]
  ["Choline"			"GO:0005307"	ch/choline has-biological-role ch/neurotransmitter]
  ["Bicarbonate"		"GO:0008510"	ch/hydrogencarbonate]
  ["Melibiose"			"GO:0043887"	ch/melibiose]
  ["Glucose"			"GO:0005412"	ch/glucose]
  ["Phosphate"			"GO:0005436"	ch/phosphate]
  ["InorganicPhosphate"	"GO:0015319"	ch/inorganic_phosphate]
  ["Nucleoside"		"GO:0005415"	ch/nucleoside]
  ["Galactose"			"GO:0015371"	ch/galactose]
  ["Urea"			"GO:0015401"	ch/urea]
  ["Potassium"			"GO:0009674"	ch/potassium_1+_]
  ["OrganicAcid"		"GO:0005343"	ch/organic_acid]
  ["Dicarboxylate"		"GO:0017153"	ch/dicarboxylic_acid]
  ["Malonate"			"GO:0044668"	ch/malonate_1-_]
  ["Malate"			"GO:0043882"	ch/malate_2-_]
  ["Glutamate"			"GO:0015501"	ch/glutamate_2-_]
  ["Taurine"			"GO:0005369"	ch/taurine has-application-role ch/xenobiotic]
  ["Monocarboxylate"		"GO:0140161"	ch/monocarboxylic_acid]
  ["GammaAminobutyricAcid"	"GO:0005332"	ch/gamma-aminobutyric_acid has-biological-role ch/neurotransmitter]
  ["BileAcid"			"GO:0008508"	ch/bile_acid]
  ["AminoAcid"			"GO:0005283"	ch/amino_acid]
  ["Proline"			"GO:0005298"	ch/proline]
  ["BranchedChainAminoAcid"	"GO:0015657"	ch/branched-chain_amino_acid]
  ["NeutralAminoAcid"		"GO:0005295"	ch/amino_acid hasAcidity Neutral]
  ["Alanine"			"GO:0015655"	ch/alanine hasAcidity Neutral]
  ["Myo-inositol"		"GO:0005367"	ch/myo-inositol]
  ["Purine"			"GO:0015390"	ch/purine]
  )


;; neutral, basic amino acid:sodium:chloride symporter activity GO:0015374
(deftransport ToTransportNeutral-BasicAminoAcid:Chloride:SodiumSymporter
  :comment "GO:0015374"
  :across go/plasma_membrane
  :cargo (owl-or (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration)
                          (owl-some hasAcidity Neutral))
                 (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration)
                          (owl-some hasAcidity Alkaline)))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; sodium-dependent multivitamin transmembrane transporter activity
;; multivitamin as a term not found in chebi, but
;; pantothenate, biotin and lipoate exist in chebi
(deftransport ToTransportMultivitamin:SodiumSymporter
  :comment "GO:0008523"
  :across go/plasma_membrane
  :cargo (owl-and (owl-or ch/pantothenate ch/biotin ch/lipoate)
                  (owl-some has-biological-role ch/B_vitamin)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)
  
(deftransport ToTransportCreatine:SodiumSymporter
  :comment "GO:0005309"
  :across go/plasma_membrane
  :cargo (owl-and ch/creatine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/cofactor))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycine:SodiumSymporter
  :comment "GO:0015375"
  :across go/plasma_membrane
  :cargo (owl-and ch/glycine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportPantothenate:SodiumSymporter
  :comment "GO:0015498"
  :across go/plasma_membrane
  :cargo (owl-and ch/pantothenate (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/cofactor ch/vitamin))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportL-ascorbate:SodiumSymporter
  :comment "GO:0008520"
  :across go/plasma_membrane
  :cargo (owl-and ch/L-ascorbate (owl-some hasConcentration LowConcentration)
                  (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/vitamin ch/coenzyme))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportPyrimidine-And-AdenineNucleobase:SodiumSymporter
  :comment "GO:0015389"
  :across go/plasma_membrane
  :cargo (owl-and (owl-or ch/pyrimidine_nucleoside ch/adenine) (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)



;;=============================================================================

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportNeurotransmitter:SodiumSymporter
  :comment "GO:0005328"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; Need Review
;; http://www.tcdb.org/search/result.php?tc=2.a.30
;; {Na+ or K+ + Cl-} (out) ⇌ {Na+ or K+ + Cl-} (in).
(deftransport ToTransportChloride:Potassium:SodiumSymporter
  :comment "GO:0008511"
  :across go/plasma_membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/potassium_1+_ ch/sodium_1+_) (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportSerotonin:Chloride:SodiumSymporter
  :comment "GO:0005335"
  :across go/plasma_membrane
  :cargo (owl-and ch/serotonin (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportDopamine:Chloride:SodiumSymporter
  :comment "GO:0005330"
  :across go/plasma_membrane
  :cargo (owl-and ch/dopamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportNorepinephrine:Chloride:SodiumSymporter
  :comment "GO:0005334"
  :across go/plasma_membrane
  :cargo (owl-and ch/noradrenaline (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportLowAffinityGlucose:SodiumSymporter
  :comment "GO:0005362"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)


(deftransport ToTransportHighAffinityInorganicPhosphate:SodiumSymporter
  :comment "GO:0005316"
  :across go/plasma_membrane
  :cargo (owl-and ch/inorganic_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)

(deftransport ToTransportLowAffinityDicarboxylate:SodiumSymporter
  :comment "GO:0015361"
  :across go/plasma_membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityDicarboxylate:SodiumSymporter
  :comment "GO:0015362"
  :across go/plasma_membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)








;;=====================================================
;;==== Proton symporter Secondary Active transporters =
;;======================================================

;;#A substance or substances transported according to the reaction:
;;solute(out) + H+(out) = solute(in) + H+(in).
;; Driven by proton symporter
(defn substance-drivenby-proton-symporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) ":ProtonSymporter"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some ~(nth lis 3) ~(nth lis 4)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
     :across go/plasma_membrane
     :direction SameDirection))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-proton-symporter [& lis]
  `(do ~@(map substance-drivenby-proton-symporter lis)))

;; Substances driven by Proton 
(deftransporters-drivenby-proton-symporter
  ["Solute"			"GO:0015295"		ch/chemical_entity]
  ["Selenite"			"GO:0097079"		ch/selenite_2-_]  ;; evidence PMID:20861301
  ["Succinate"			"GO:0097434"		ch/succinate_2-_ has-application-role ch/drug]  ;; evidence PMID:1293882 
  ["Glucosinolate"		"GO:0090448"		ch/glucosinolate]
  ["FerricEnterobactin"	"GO:0015345"		ch/ferrienterobactin_3-_ has-biological-role ch/siderophore]
  ["Acetate"			"GO:0015360"		ch/acetate has-biological-role ch/antimicrobial_drug]
  ["Nitrate"			"GO:0009671"		ch/nitrate]
  ["Carbohydrate"		"GO:0005351"		ch/carbohydrate]
  ["Hexose"			"GO:0009679"		ch/hexose]
  ["Fucose"			"GO:0015535"		ch/fucose]
  ["Glucose"			"GO:0005356"		ch/glucose]
  ["D-glucose"			"GO:0055055"		ch/D-glucose]
  ["Fructose"			"GO:0055054"		ch/fructose]
  ["Rhamnose"			"GO:0015561"		ch/rhamnose]
  ["Mannose"			"GO:0055053"		ch/mannose]
  ["Galactose"			"GO:0015517"		ch/galactose]
  ["Raffinose"			"GO:0015529"		ch/raffinose]
  ["2-dehydro-3-deoxy-D-gluconate" "GO:0015649"	ch/_2-dehydro-3-deoxy-D-gluconate]
  ["D-xylose"			"GO:0015519"		ch/aldehydo-D-xylose]
  ["Arabinose"			"GO:0015518"		ch/arabinose]
  ["Lactose"			"GO:0015528"		ch/lactose]
  ["Sucrose"			"GO:0008506"		ch/sucrose]
  ["Maltose"			"GO:0005364"		ch/maltose]
  ["Trehalose"			"GO:0044693"		ch/trehalose]
  ["AminoAcid"			"GO:0005280"		ch/proton]
  ["AromaticAminoAcid"		"GO:0015494"		ch/aromatic_amino_acid]
  ["Phenylalanine"		"GO:0015492"		ch/phenylalanine]
  ["GammaAminobutyricAcid"	"GO:0015495"		ch/gamma-aminobutyric_acid has-biological-role ch/neurotransmitter]
  ["Proline"			"GO:0005297"		ch/proline]
  ["Lysine"			"GO:0015493"		ch/lysine]
  ["Cytosine"			"GO:0015504"		ch/cytosine]
  ["Shikimate"			"GO:0015533"		ch/shikimate]
  ["Lactate"			"GO:0015650"		ch/lactate]
  ["Citrate"			"GO:0015531"		ch/citrate_3-_]
  ["Sulfate"			"GO:0008512"		ch/sulfate]
  ["GlycineBetaine"		"GO:0015653"		ch/glycine_betaine]
  ["QuaternaryAmmoniumGroup"	"GO:0015652"		ch/quaternary_nitrogen_compound]
  ["3-hydroxyphenylPropiona"	"GO:0015540"		ch/_3-hydroxyphenyl_propanoate]
  ["SialicAcid"		"GO:0015538"		ch/sialic_acid]
  ["Xanthosine"		"GO:0015537"		ch/xanthosine]
  ["Alpha-ketoglutarate"	"GO:0015532"		ch/_2-oxoglutarate_2-_ has-biological-role ch/cofactor]
  ["Nucleoside"		"GO:0015506"		ch/nucleoside]
  ["Uridine"			"GO:0015394"		ch/uridine]
  ["Potassium"			"GO:0015387"		ch/potassium_1+_]
  ["Malate"			"GO:0015366"		ch/malate]
  ["FerricTriacetylfusarinineC" "GO:0015346"		ch/N'_N''_N'''-triacetylfusarinine_C has-biological-role ch/siderophore]
  ["Peptide"			"GO:0015333"		ch/peptide]
  ["Phosphate"			"GO:0015317"		ch/phosphate]
  ["Auxin"			"GO:0009672"		ch/auxin]
  ["Myo-inositol"		"GO:0005366"		ch/myo-inositol]
  ["Alpha-glucoside"		"GO:0005352"		ch/alpha-glucoside]
  ["Allantoin"			"GO:0005274"		ch/allantoin has-application-role ch/drug]
  )



;; what is exactly in resposne to stimulus?!
;; GO:0005360 insulin-responsive glucose:proton symporter 
(deftransport ToTransportGlucose:ProtonSymporterInResponseToStimulusByInsulin
  :comment "GO:0005360"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :results go/response_to_insulin
  :direction SameDirection)

(deftransport ToTransportLowAffinityGlucose:ProtonSymporter
  :comment "GO:0005359"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)

(deftransport ToTransportLowAffinitySulfate:ProtonSymporter
  :comment "GO:0009676"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinitySulfate:ProtonSymporter
  :comment "GO:0009675"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityGlucose:ProtonSymporter
  :comment "GO:0005358"
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)


(deftransport ToTransportHighAffinityThiamine:ProtonSymporter
  :comment "GO:0034216"
  :across go/plasma_membrane
  :cargo (owl-and ch/thiamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/vitamin))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)

(deftransport ToTransportThiamine:ProtonSymporter
  :comment "GO:0034215"
  :across go/plasma_membrane
  :cargo (owl-and ch/thiamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/vitamin))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction SameDirection)



;;=====================================================
;;==== Antiporter Secondary Active transporters =
;;======================================================

;;Solute A(out) + solute B(in) = solute A(in) + solute B(out).
(deftransport ToTransportAntiporterActivity
  :comment "GO:0015297"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportSolute:CationAntiporter
  :comment "GO:0015298"
  :across go/plasma_membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://www.ebi.ac.uk/interpro/entry/IPR004836
(deftransport ToTransportCalcium:SodiumAntiporter
  :comment "GO:0005432"
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportSulfateAntiporterByVoltageGatedChannel
  :comment "GO:0015297"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sulfate (owl-some hasConcentration HighConcentration))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :direction OppositeDirection)

;;#A substance or substances transported according to the reaction:
;; solute(out) + H+(in) = solute(in) + H+(out).
;; Driven by proton antiporter
(defn substance-drivenby-proton-antiporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) ":ProtonAntiporter"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 5 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some ~(nth lis 3) ~(nth lis 4)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
     :across go/plasma_membrane
     :direction OppositeDirection))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-proton-antiporter [& lis]
  `(do ~@(map substance-drivenby-proton-antiporter lis)))

(deftransporters-drivenby-proton-antiporter
  ["Solute"			"GO:0015299"		ch/chemical_entity]
  ["Acridine"			"GO:0042962"		ch/acridine]
  ["Polyamine"			"GO:0015312"		ch/polyamine]
  ["Monoamine"			"GO:0015311"		ch/monoamine]
  ["Drug"			"GO:0015307"		ch/chemical_entity has-application-role ch/drug]
  ["Tetracycline"		"GO:0015520"		ch/tetracycline has-biological-role ch/antimicrobial_drug]
  ["Cycloheximide"		"GO:0015309"		ch/cycloheximide has-biological-role ch/antimicrobial_drug]
  ["Amiloride"			"GO:0015308"		ch/amiloride has-application-role ch/drug]
  ["Azole"			"GO:0045119"		ch/azole has-application-role ch/drug]
  ["Aminotriazole"		"GO:0015314"		ch/amitrole has-application-role ch/drug]
  ["MonovalentCation"		"GO:0005451"		ch/monovalent_inorganic_cation]
  ["Sodium"			"GO:0015385"		ch/sodium_1+_]
  ["Potassium"			"GO:0015386"		ch/potassium_1+_]
  ["Lithium"			"GO:0010348"		ch/lithium_1+_]
  ["MetalIon"			"GO:0051139"		ch/metal_cation]
  ["Calcium"			"GO:0015369"		ch/calcium_2+_]
  ["Manganese"			"GO:0010486"		ch/manganese_2+_]
  )

(deftransport ToTransportHydrophobicUncoupler:ProtonAntiporter
  :comment "GO:0015522"
  :across go/plasma_membrane
  :cargo (owl-and (owl-or ch/CCCP ch/benzalkonium_chloride ch/sodium_dodecyl_sulfate)
                  (owl-some has-application-role ch/drug)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; ion A(out) + ion B(in) = ion A(in) + ion B(out) where ion A and ion B are different types of ion.
(deftransport ToTransportIonAntiporter
  :comment "GO:0099516"
  :across go/plasma_membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportIonAntiporter
  :comment "GO:0099580"
  :across go/plasma_membrane
  :occurs go/postsynaptic_membrane
  :involved go/regulation_of_postsynaptic_membrane_potential
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportIonInvolvedInRegulationOfpresynapticMembranePotentialAntiporter
  :comment "GO:0099520"
  :across go/plasma_membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :occurs go/presynaptic_membrane
  :involved go/regulation_of_presynaptic_membrane_potential
  :direction OppositeDirection)


;; http://www.tcdb.org/search/result.php?tc=2.A.31
(deftransport ToTransportAnion:AnionAntiporter
  :comment "GO:0015301"
  :across go/plasma_membrane
  :cargo (owl-and ch/anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/abstract/MED/21568705
;; http://www.tcdb.org/search/result.php?tc=2.A.48
;;RFC is an organic anion antiporter that utilizes the high
;;transmembrane organic phosphate gradient to achieve uphill folate transport into cells
(deftransport ToTransportFolate:AnionAntiporter
  :comment "GO:0008518"
  :across go/plasma_membrane
  :cargo (owl-and ch/folic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; ATP (out) + ADP (in) (+ energy?) ⇌ ATP (in) + ADP (out)
;;http://www.tcdb.org/search/result.php?tc=2.A.12.1#2.A.12.1.1
;;https://www.ncbi.nlm.nih.gov/pubmed/19001371
(deftransport ToTransportATP:ADPAntiporter
  :comment "GO:0005471"
  :across go/plasma_membrane
  :cargo (owl-and ch/ATP (owl-some hasConcentration LowConcentration))
         (owl-and ch/ADP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://www.tcdb.org/search/result.php?tc=2.A.12.5
;; https://jb.asm.org/content/188/17/6261.long
(deftransport ToTransportGTP:GDPAntiporter
  :comment "GO:0010292"
  :across go/plasma_membrane
  :cargo (owl-and ch/GTP (owl-some hasConcentration LowConcentration))
         (owl-and ch/GDP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://www.tcdb.org/search/result.php?tc=2.A.3.7#2.A.3.7.1
;; https://www.nature.com/articles/nature10917
(deftransport ToTransportGlutamate:Gamma-aminobutyricAcidAntiporter
  :comment "GO:0070909"
  :across go/plasma_membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some hasConcentration LowConcentration))
         (owl-and ch/glutamate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/abstract/MED/10839820
(deftransport ToTransportTriosePhosphate:PhosphateAntiporter
  :comment "GO:0009670"
  :across go/plasma_membrane
  :cargo (owl-and ch/glyceraldehyde_3-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/abstract/MED/10839820
(deftransport ToTransportTriosePhosphoenolpyruvate:PhosphateAntiporter
  :comment "GO:0015121"
  :across go/plasma_membrane
  :cargo (owl-and ch/phosphoenolpyruvate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;; https://www.ncbi.nlm.nih.gov/pubmed/14982633
;; https://link.springer.com/article/10.1007%2Fs00726-011-0989-9
;;lysine(out) + cadaverine(in) = lysine(in) + cadaverine(out). 
(deftransport ToTransportLysine:CadaverineAntiporter
  :comment "GO:0043872"
  :across go/plasma_membrane
  :cargo (owl-and ch/lysine (owl-some hasConcentration LowConcentration))
         (owl-and ch/cadaverine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;;=======================
;; http://www.tcdb.org/search/result.php?tc=2.A.1.4#2.A.1.4.1
(deftransport ToTransportOrganophosphate:InorganicPhosphateAntiporter
  :comment "GO:0015315"
  :across go/plasma_membrane
  :cargo (owl-and ch/organic_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; need review
(deftransport ToTransportGlyceronePhosphate:InorganicPhosphateAntiporter
  :comment "GO:0051407"
  :across go/plasma_membrane
  :cargo (owl-and ch/glycerone_phosphates (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlyceraldehyde3Phosphate:InorganicPhosphateAntiporter
  :comment "GO:0051408"
  :across go/plasma_membrane
  :cargo (owl-and ch/glyceraldehyde_3-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlucose6Phosphate:PhosphateAntiporter
  :comment "GO:0008524"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucose_6-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportHexosePhosphate:InorganicPhosphateAntiporter
  :comment "GO:0015526"
  :across go/plasma_membrane
  :cargo (owl-and ch/hexose_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportGlucose6Phosphate:InorganicPhosphateAntiporter
  :comment "GO:0061513"
  :across go/plasma_membrane
  :cargo (owl-and ch/D-glucose_6-phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportDicarboxylate:InorganicPhosphateAntiporter
  :comment "GO:0015364"
  :across go/plasma_membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportGlycerolPhosphate:InorganicPhosphateAntiporter
  :comment "GO:0015527"
  :across go/plasma_membrane
  :cargo (owl-and ch/glycerol_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_phosphate (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportXoglutarate:MalateAntiporter
  :comment "GO:0015367"
  :across go/plasma_membrane
  :cargo (owl-and ch/_2-oxoglutaric_acid (owl-some hasConcentration LowConcentration))
         (owl-and ch/malate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Ref: http://www.tcdb.org/search/result.php?tc=2.A.81
(deftransport ToTransportAspartate:AlanineAntiporter
  :comment "GO:0070906"
  :across go/plasma_membrane
  :cargo (owl-and ch/alanine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral))
         (owl-and ch/L-aspartate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportCystine:GlutamateAntiporter
  :comment "GO:0015327"
  :across go/plasma_membrane
  :cargo (owl-and ch/cystine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral))
         (owl-and ch/glutamate_2-_ (owl-some hasConcentration LowConcentration)
                   (owl-some hasAcidity Acidic) (owl-some has-application-role ch/drug)
                   (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; need review
(deftransport ToTransportCitrate:SuccinateAntiporter
  :comment "GO:0015515"
  :across go/plasma_membrane
  :cargo (owl-and ch/citrate_3-_ (owl-some has-biological-role ch/antimicrobial_drug)
                  (owl-some hasConcentration LowConcentration))
         (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; https://jb.asm.org/content/189/5/1597.long
(deftransport ToTransportTartrate:SuccinateAntiporter
  :comment "GO:0015516"
  :across go/plasma_membrane
  :cargo (owl-and ch/tartrate_salt (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/succinate_2-_ (owl-some hasConcentration LowConcentration)
                   (owl-some has-application-role ch/drug))
  :direction OppositeDirection)

(deftransport ToTransportfumarate:SuccinateAntiporter
  :comment "GO:0005469"
  :across go/plasma_membrane
  :cargo (owl-and ch/fumarate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)
                   (owl-some hasConcentration LowConcentration))
  :direction OppositeDirection)

(deftransport ToTransportfumarate:L-aspartateAntiporter
  :comment "GO:0062057"
  :across go/plasma_membrane
  :cargo (owl-and ch/fumarate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/L-aspartate_2-_ (owl-some hasConcentration HighConcentration)
                   (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/neurotransmitter))
  :direction OppositeDirection)


;; cation A(out) + cation B(in) = cation A(in) + cation B(out). 
(deftransport ToTransportCation:CationAntiporter
  :comment "GO:0015491"
  :across go/plasma_membrane
  :cargo (owl-and ch/cation (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;;https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1428153/
(deftransport ToTransportTyrosine:TyramineAntiporter
  :comment "GO:0070908"
  :across go/plasma_membrane
  :cargo (owl-and ch/tyrosine (owl-some hasConcentration LowConcentration))
         (owl-and ch/tyramine (owl-some hasConcentration LowConcentration)
                              (owl-some has-application-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;;https://jb.asm.org/content/175/10/2864?ijkey=406fa4de435f1936d566cb632c3aecfefeddbe1e&keytype2=tf_ipsecsha
(deftransport ToTransportHistidine:HistamineAntiporter
  :comment "GO:0070907"
  :across go/plasma_membrane
  :cargo (owl-and ch/histidine (owl-some hasConcentration LowConcentration))
         (owl-and ch/histamine (owl-some hasConcentration LowConcentration)
                               (owl-some has-application-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/abstract/MED/22031603
(deftransport ToTransportMagnesium:SodiumAntiporter
  :comment "GO:0061768"
  :across go/plasma_membrane
  :cargo (owl-and ch/magnesium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Need review
(deftransport ToTransportCalcium:CationAntiporter
  :comment "GO:1905060"
  :comment "Involved in regulation of postsynaptic cytosolic calcium ion concentration"
  :across go/plasma_membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
  :direction OppositeDirection)

(deftransport ToTransportCalcium:CationAntiporter
  :comment "GO:1905055"
  :comment "Involved in regulation of presynaptic cytosolic calcium ion concentration"
  :across go/plasma_membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_presynaptic_cytosolic_calcium_ion_concentration
  :direction OppositeDirection)


(deftransport ToTransportFluconazole:ProtonAntiporter
  :comment "GO:0015313"
  :across go/plasma_membrane
  :cargo (owl-and ch/fluconazole (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportBenomyl:ProtonAntiporter
  :comment "GO:0015310"
  :across go/plasma_membrane
  :cargo (owl-and ch/benomyl (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportAcetylcholine:ProtonAntiporter
  :comment "GO:0005278"
  :across go/plasma_membrane
  :cargo (owl-and ch/acetylcholine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportSodium:ProtonAntiporter
  :comment "GO:0086040"
  :comment "Involved in regulation of cardiac muscle cell membrane potential"
  :across go/plasma_membrane
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :direction OppositeDirection)
  
(deftransport ToTransportCalcium:SodiumAntiporter
  :comment "GO:0086038"
  :comment "Involved in regulation of cardiac muscle cell membrane potential"
  :across go/plasma_membrane
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :direction OppositeDirection)

;; http://www.jbc.org/content/277/42/39251.full.pdf
(deftransport ToTransportR-Carnitine:4-trimethylammonio-ButanoateAntiporter
  :comment "GO:0044667"
  :across go/plasma_membrane
  :cargo (owl-and ch/_4-_trimethylammonio_butanoate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/_R_-carnitine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;; http://www.jbc.org/content/282/1/176.full.pdf
;; http://www.tcdb.org/search/result.php?tc=3.B.1#ref1550
;; https://www.ncbi.nlm.nih.gov/pmc/articles/PMC211485/pdf/jbacter00188-0104.pdf
(deftransport ToTransportArginine:AgmatineAntiporter
  :comment "GO:0043862"
  :across go/plasma_membrane
  :cargo (owl-and ch/agmatine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/arginine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)  

;; https://www.ncbi.nlm.nih.gov/pmc/articles/PMC211485/pdf/jbacter00188-0104.pdf
(deftransport ToTransportAgmatine:PutrescineAntiporter
  :comment "GO:0043861"
  :across go/plasma_membrane
  :cargo (owl-and ch/agmatine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/putrescine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 

;; https://www.ncbi.nlm.nih.gov/pmc/articles/PMC211485/pdf/jbacter00188-0104.pdf
(deftransport ToTransportArginine:OrnithineAntiporter
  :comment "GO:0043858"
  :across go/plasma_membrane
  :cargo (owl-and ch/arginine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ornithine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 

;; http://www.ebi.ac.uk/interpro/entry/IPR004817
(deftransport ToTransportPotassiumIonAntiporter
  :comment "GO:0022821"
  :across go/plasma_membrane
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/sodium_1+_ ch/proton) (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://www.ebi.ac.uk/interpro/entry/IPR004817
(deftransport ToTransportPotassiumCalcium:SodiumAntiporter
  :comment "GO:0008273"
  :across go/plasma_membrane
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
         (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/articles/PMC49116
;; https://www.ncbi.nlm.nih.gov/pmc/articles/PMC211485/pdf/jbacter00188-0104.pdf
(deftransport ToTransportPutrescine:OrnithineAntiporter
  :comment "GO:0015496"
  :across go/plasma_membrane
  :cargo (owl-and ch/putrescine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ornithine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 

;; https://onlinelibrary.wiley.com/doi/pdf/10.1002/%28SICI%291097-010X%2819990701%29284%3A2%3C158%3A%3AAID-JEZ5%3E3.0.CO%3B2-S
(deftransport ToTransportSulfate:BicarbonateAntiporter
  :comment "GO:0015383"
  :across go/plasma_membrane
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/proton ch/hydrogencarbonate) (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 

;; http://www.farmacia.uniba.it/annuari/2011/1038.pdf
(deftransport ToTransportCarnitine:AcylcarnitineAntiporter
  :comment "GO:0005476"
  :across go/plasma_membrane
  :cargo (owl-and ch/O-acylcarnitine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/carnitine (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 

(deftransport ToTransportInorganicAnionAntiporter
  :comment "GO:0005452"
  :across go/plasma_membrane
  :cargo (owl-and ch/inorganic_anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection) 




;;=====================================================
;;============ Uniporter transporters =================
;;=====================================================

;; Uniporters (the preferred term), also
;; called single-species transporters or facilitated diffusion carriers
;; catalyze the transport of a single molecular species,
;; and transport therefore occurs independently of the movement of other molecular species.

;; (deftransport ToTransportUniporter
;;   :comment "GO:0015292"
;;   :across go/plasma_membrane
;;   :cargo ch/chemical_entity)



;;  GO:0015325
