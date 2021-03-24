(ns hyper-go.TA.active_transporter
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny-go.go :as go]))


(ontology-to-namespace hyper-go.core/HyperGo)

;; Requires energy to transports molecules.
;; Move molecules against thier concentration gradient
(deftransport ToTransportSoluteByActiveTransmembraneTransporter
  :annotation (goid "GO:0022804")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or PrimaryEnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

;; active ion transmembrane transporter activity
(deftransport ToTransportIonByActiveTransmembraneTransporter
  :annotation (goid "GO:0022853")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-or PrimaryEnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

;; 2-aminoethylphosphonate transmembrane transporter activity
(deftransport ToTransport2-aminoethylphosphonateByActiveTransmembraneTransporter
  :annotation (goid "GO:0033224")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/_2-aminoethyl_phosphonic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-or PrimaryEnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))


;; monoamine transmembrane transporter activity
(deftransport ToTransportMonoamineByActiveTransmembraneTransporter
  :annotation (goid "GO:0008504")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/monoamine (owl-some hasConcentration LowConcentration))
  :driven (owl-or PrimaryEnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

(deftransport ToTransportSorbitolByActiveTransmembraneTransporter
  :annotation (goid "GO:0015576")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucitol (owl-some hasConcentration LowConcentration))
  :driven (owl-or PrimaryEnergySource (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration))))

(deftransport ToTransportBorateByActiveTransmembraneTransporter
  :annotation (goid "GO:0046715")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/borate (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-or PrimaryEnergySource
                   (owl-and ch/chemical_entity
                            (owl-some hasConcentration HighConcentration))))

;; =====================================================
;;============== Primary Active transporters =========
;;======================================================

;; Requires energy to transports molecules.
(deftransport ToTransportSoluteByPrimaryActiveTransmembrane
  :annotation (goid "GO:0015399")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-or ATP_Hydrolysis Oxidoreduction Decarboxylation MethylTransferReaction Light))

(deftransport ToTransportSoluteByPrimaryActiveTransmembraneDrivenByDecarboxylation
  :annotation (goid "GO:0015451")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven Decarboxylation)

;; methyl transfer-driven active transmembrane transporter
(deftransport ToTransportSoluteByPrimaryActiveTransmembraneDrivenByMethyltransfer
  :annotation (goid "GO:0015452")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven  MethylTransferReaction)

;; oxidoreduction-driven active transmembrane transporter activity
(deftransport ToTransportSoluteByPrimaryActiveTransmembraneDrivenByOxidoreduction
  :annotation (goid "GO:0015453")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven Oxidoreduction)

;; light-driven active transmembrane transporter 
(deftransport ToTransportSoluteByPrimaryActiveTransmembraneDrivenByLight
  :annotation (goid "GO:0015454")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven Light)

(deftransport ToTransportSubstanceDrivenByMembranePotentialDifference
  :annotation (goid "GO:0022810")
  :across go/membrane
  :driven ElectricalPotentialDifference
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportPotassiumIonDrivenByMembranePotentialDifference
  :annotation (goid "GO:0022819")
  :across go/membrane
  :driven ElectricalPotentialDifference
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration)))

(deftransport ToTransportSodiumIonDrivenByMembranePotentialDifference
  :annotation (goid "GO:0022818")
  :across go/membrane
  :driven ElectricalPotentialDifference
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration)))

;;=====================================================
;;============== Secondary Active transporters =========
;;======================================================
;;#A substance or substances transported according to the reaction:
;;Solute (out) + n[ion or molecualr] (out) → Solute (in) + n[ion or molecualr] (in)
;; Driven by sodium symporter
(defn secondary-substance-transporters [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "BySecondaryActiveTransport"))
     :annotation (goid ~(second lis))
     :across go/membrane
     :system Active
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
            :else (println "Class data out of the range"))
     :driven (owl-and (owl-or ch/ion ch/chemical_entity)
                      (owl-some hasConcentration HighConcentration))
     :direction (owl-or SameDirection OppositeDirection)))


;; macro function to do the classes mapping 
(defmacro defsecondary-substance-transporters [& lis]
  `(do ~@(map secondary-substance-transporters lis)))

(defsecondary-substance-transporters
  ["Substance"                  "GO:0015291"            ch/chemical_entity]
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
  ["Bilirubin"			"GO:0015351"		ch/bilirubin_IXalpha]
  ["Nucleoside"		"GO:0010174"		ch/nucleoside] ;; http://www.tcdb.org/search/result.php?tc=2.a.31
  ["Cyanate"			"GO:0015541"		ch/cyanate]
  ["Pyruvate"			"GO:0005477"		ch/pyruvate]
  ["OrganicCation"		"GO:0008513"		ch/organic_cation]
  ["MonocarboxylicAcid"         "GO:0015355"            ch/monocarboxylic_acid]
  ["NeutralL-AminoAcid"         "GO:0005294"            ch/L-alpha-amino_acid  hasAcidity Neutral   hasEnantiomerism L-Enantiomer]
  ["L-methionine"               "GO:0000102"            ch/L-methionine hasAcidity Neutral has-application-role ch/drug]
  )


(deftransport ToTransportHighAffinityNitriteBySecondaryActiveTransmembrane
  :annotation (goid "GO:0015513")
  :across go/membrane
  :system Active
  :transporterAffinity HighAffinity
  :cargo (owl-and ch/nitrite (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/ion ch/chemical_entity)(owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportHighAffinitySulfateBySecondaryActiveTransmembrane
  :annotation (goid "GO:0015381")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/ion ch/chemical_entity)(owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportHighAffinityAmmoniumBySecondaryActiveTransmembrane
  :annotation (goid "GO:0015398")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/ammonium (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/ion ch/chemical_entity)(owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportLowAffinityAmmoniumBySecondaryActiveTransmembrane
  :annotation (goid "GO:0015400")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/ammonium (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/ion ch/chemical_entity)(owl-some hasConcentration HighConcentration))
  :transporterAffinity LowAffinity
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportPeptideBySecondaryActiveTransmembrane
  :annotation (goid "GO:0022897")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/peptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

(deftransport ToTransportOligopeptideBySecondaryActiveTransmembrane
  :annotation (goid "GO:0005427")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/oligopeptide (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))

;; http://www.tcdb.org/search/result.php?tc=2.A.41
(deftransport ToTransportZincIonEffluxBySecondaryActiveTransmembrane
  :annotation (goid "GO:0015341")
  :across go/membrane
  :system Active
  :from go/intracellular
  :to go/extracellular_region
  :cargo (owl-and ch/zinc_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))


;; classified in GO as primary and secondary active transporter.!!
(deftransport ToTransportProteinBySecondaryActiveTransmembraneTransporter
  :annotation (goid "GO:0009977")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction (owl-or SameDirection OppositeDirection))


;; =====================================================
;; ===== Symporter Secondary Active transporters =======
;; =====================================================

(defn secondary-substance-symporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis)(second lis)"Symporter"))
     :label (str"ToTransport" ~(first lis) ":" ~(second lis)"Symporter")
     :annotation (goid ~(nth lis 2))
     :across go/membrane
     :system Active
     :driven (owl-and ~(nth lis 3) (owl-some hasConcentration HighConcentration))
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
            :else (println "Class data out of the range"))
     :direction SameDirection))


;; macro function to do the classes mapping
(defmacro defsecondary-substance-symporter [& lis]
  `(do ~@(map secondary-substance-symporter lis)))

(defsecondary-substance-symporter
;;["Driven Solute"-- "Driving Solute"--"GO ID" ---- "Driving solute from Chebi"---"Driven solute from Chebi"]
  ["Solute"          "Ion"           "GO:0015293"       ch/ion                    ch/chemical_entity]
  ["Solute"          "Cation"        "GO:0015294"       ch/inorganic_cation       ch/chemical_entity]
  ["Acetate"	     "Cation"	     "GO:0043893"       ch/inorganic_cation       ch/acetate]
  ["Anion"           "Cation"        "GO:0015296"       ch/inorganic_cation       ch/inorganic_anion]
  ["Chloride"        "Cation"        "GO:0015377"       ch/inorganic_cation       ch/chloride]
  ["Chloride"        "Potassium"     "GO:0015379"       ch/potassium_1+_          ch/chloride]
  ["Carbohydrate"    "Cation"        "GO:0005402"       ch/inorganic_cation       ch/carbohydrate]
  ["Melibiose"       "Cation"        "GO:0015487"       ch/inorganic_cation       ch/melibiose]
  ["Glucuronate"     "Cation"        "GO:0015488"       ch/inorganic_cation       ch/glucuronate]
  ["Sucrose"         "Cation"        "GO:0009669"       ch/inorganic_cation       ch/sucrose]
  ["AminoAcid"       "Cation"        "GO:0005416"       ch/inorganic_cation       ch/amino_acid]
  ["Nucleobase"      "Cation"        "GO:0015391"       ch/inorganic_cation       ch/nucleobase]
  ["Uracil"          "Cation"        "GO:0015505"       ch/inorganic_cation       ch/uracil  has-application-role ch/drug]
  ["Hexuronate"      "Cation"        "GO:0015539"       ch/inorganic_cation       ch/hexuronate]
  ["SialicAcid"      "Cation"        "GO:0015306"       ch/inorganic_cation       ch/N-acetylneuraminic_acid has-biological-role ch/antimicrobial_drug]
  ["AminoAcid"       "Potassium"     "GO:0017032"       ch/potassium_1+_          ch/amino_acid]
  ["Solute"          "Bicarbonate"   "GO:0140410"      ch/hydrogencarbonate       ch/chemical_entity]
  ["zinc"            "Bicarbonate"   "GO:0140412"      ch/hydrogencarbonate       ch/zinc_cation]
  )

(deftransport ToTransportSeleniteZincBicarbonateSymporter
  :label "ToTransportSelenite:ZincBicarbonateSymporter"
  :annotation (goid "GO:0140413")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/selenic_acid (owl-some hasConcentration LowConcentration))
  :driven  (owl-and ch/hydrogencarbonate (owl-some hasConcentration HighConcentration))
           (owl-and ch/zinc_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportGlycoside-Pentoside-HexuronideCationSymporter
  :label "ToTransportGlycoside-Pentoside-Hexuronide:CationSymporter"
  :annotation (goid "GO:0015486")
  :across go/membrane
  :system Active
  :cargo (owl-or (owl-and ch/glycoside (owl-some hasConcentration LowConcentration))
                 (owl-and ch/pentoside (owl-some hasConcentration LowConcentration))
                 (owl-and ch/hexuronate (owl-some hasConcentration LowConcentration)))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;;=====================================================
;;==== Sodium symporter Secondary Active transporters =
;;======================================================
;;#A substance or substances transported according to the reaction:
;;solute(out) + Na+(out) = solute(in) + Na+(in).
;; Driven by sodium symporter
(defn substance-drivenby-sodium-symporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "SodiumSymporter"))
     :label (str"ToTransport" ~(first lis) ":SodiumSymporter")
     :annotation (goid ~(second lis))
     :across go/membrane
     :system Active
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
            :else (println "Class data out of the range"))
     :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
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
  ["Lysophospholipid"           "GO:0051978"    ch/monoacylglycerol_phosphate]
  ["OrganicAnion"               "GO:0043250"    ch/organic_anion]
  ["Creatine"                   "GO:0005309"    ch/creatine has-application-role ch/drug has-biological-role ch/cofactor]
  ["Pantothenate"               "GO:0015498"    ch/pantothenate  has-biological-role ch/cofactor ch/vitamin]
  ["L-ascorbate"                "GO:0008520"    ch/L-ascorbate  hasEnantiomerism L-Enantiomer   has-biological-role ch/vitamin ch/coenzyme]
  ["Neurotransmitter"           "GO:0005328"    ch/chemical_entity has-biological-role ch/neurotransmitter]
  )

;; neutral, basic amino acid:sodium:chloride symporter activity GO:0015374
(deftransport ToTransportNeutral-BasicAminoAcidChlorideSodiumSymporter
  :label "ToTransportNeutral-BasicAminoAcid:ChlorideSodiumSymporter"
  :annotation (goid "GO:0015374")
  :across go/membrane
  :system Active
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
(deftransport ToTransportMultivitaminSodiumSymporter
  :label "ToTransportMultivitamin:SodiumSymporter"
  :annotation (goid "GO:0008523")
  :across go/membrane
  :system Active
  :cargo (owl-and (owl-or ch/pantothenate ch/biotin ch/lipoate)
                  (owl-some has-biological-role ch/B_vitamin)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycineSodiumSymporter
  :label "ToTransportGlycine:SodiumSymporter"
  :annotation (goid "GO:0015375")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glycine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral)
                  (owl-some has-biological-role ch/neurotransmitter)
                  (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportPyrimidine-And-AdenineNucleobaseSodiumSymporter
  :label "ToTransportPyrimidine-And-AdenineNucleobase:SodiumSymporter"
  :annotation (goid "GO:0015389")
  :across go/membrane
  :system Active
  :cargo (owl-or (owl-and ch/pyrimidine_nucleoside (owl-some hasConcentration LowConcentration))
                 (owl-and ch/adenine (owl-some hasConcentration LowConcentration)))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; http://www.tcdb.org/search/result.php?tc=2.a.30
;; {(Na+ and K+) + Cl-} (out) ⇌ {(Na+ and K+) + Cl-} (in).
(deftransport ToTransportChloridePotassiumSodiumSymporter
  :label "ToTransportChloridePotassium:SodiumSymporter"
  :annotation (goid "GO:0008511")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
         (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_
                   (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportSerotoninChlorideSodiumSymporter
  :label "ToTransportSerotonin:ChlorideSodiumSymporter"
  :annotation (goid "GO:0005335")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/serotonin (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportDopamineChlorideSodiumSymporter
  :label "ToTransportDopamine:ChlorideSodiumSymporter"
  :annotation (goid "GO:0005330")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/dopamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportNorepinephrineChlorideSodiumSymporter
  :label "ToTransportNorepinephrine:ChlorideSodiumSymporter"
  :annotation (goid "GO:0005334")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/noradrenaline (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
          (owl-and ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportLowAffinityGlucoseSodiumSymporter
  :label "ToTransportLowAffinityGlucose:SodiumSymporter"
  :annotation (goid "GO:0005362")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transporterAffinity LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityInorganicPhosphateSodiumSymporter
  :label "ToTransportHighAffinityInorganicPhosphate:SodiumSymporter"
  :annotation (goid "GO:0005316")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/inorganic_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction SameDirection)

(deftransport ToTransportLowAffinityDicarboxylateSodiumSymporter
  :label "ToTransportLowAffinityDicarboxylate:SodiumSymporter"
  :annotation (goid "GO:0015361")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transporterAffinity LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityDicarboxylateSodiumSymporter
  :label "ToTransportHighAffinityDicarboxylate:SodiumSymporter"
  :annotation (goid "GO:0015362")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction SameDirection)


;;=====================================================
;;==== Proton symporter Secondary Active transporters =
;;======================================================

;;#A substance or substances transported according to the reaction:
;;solute(out) + H+(out) = solute(in) + H+(in).
;; Driven by proton symporter
(defn substance-drivenby-proton-symporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ProtonSymporter"))
     :label (str "ToTransport" ~(first lis)":ProtonSymporter")
     :annotation (goid ~(second lis))
     :across go/membrane
     :system Active
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
           :else (println "Class data out of the range"))
     :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration)) 
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
  ["Auxin"			"GO:0009672"		ch/chemical_entity	          has-biological-role ch/auxin]
  ["Myo-inositol"		"GO:0005366"		ch/myo-inositol]
  ["Alpha-glucoside"		"GO:0005352"		ch/alpha-glucoside]
  ["Allantoin"			"GO:0005274"		ch/allantoin has-application-role ch/drug]
  ["Thiamine"                   "GO:0034215"            ch/thiamine  has-application-role ch/drug  has-biological-role ch/vitamin]
  )


(deftransport ToTransportGlucoseProtonSymporterInResponseToStimulusByInsulin
  :label "ToTransportGlucose:ProtonSymporterInResponseToStimulusByInsulin"
  :annotation (goid "GO:0005360")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  (owl-some hasStimulus go/response_to_insulin)
  :direction SameDirection)

(deftransport ToTransportLowAffinityGlucoseProtonSymporter
  :label "ToTransportLowAffinityGlucose:ProtonSymporter"
  :annotation (goid "GO:0005359")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transporterAffinity LowAffinity
  :direction SameDirection)

(deftransport ToTransportLowAffinitySulfateProtonSymporter
  :label "ToTransportLowAffinitySulfate:ProtonSymporter"
  :annotation (goid "GO:0009676")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transporterAffinity LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinitySulfateProtonSymporter
  :label "ToTransportHighAffinitySulfate:ProtonSymporter"
  :annotation (goid "GO:0009675")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityGlucoseProtonSymporter
  :label "ToTransportHighAffinityGlucose:ProtonSymporter"
  :annotation (goid "GO:0005358")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction SameDirection)


(deftransport ToTransportHighAffinityThiamineProtonSymporter
  :label "ToTransportHighAffinityThiamine:ProtonSymporter"
  :annotation (goid "GO:0034216")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/thiamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/vitamin))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transporterAffinity HighAffinity
  :direction SameDirection)


;;=====================================================
;;==== Antiporter Secondary Active transporters =
;;======================================================

(defn substance-drivenby-ion-antiporter [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis)(second lis)"Antiporter"))
     :label (str "ToTransport" ~(first lis) ":" ~(second lis)"Antiporter")
     :annotation (goid ~(nth lis 2))
     :across go/membrane
     :system Active
     :driven (owl-and ~(nth lis 3) (owl-some hasConcentration HighConcentration))
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
            :else (println "Class data out of the range"))
     :direction OppositeDirection))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-ion-antiporter [& lis]
  `(do ~@(map substance-drivenby-ion-antiporter lis)))

(deftransporters-drivenby-ion-antiporter
  ["Solute"	  "Ion"	    "GO:0015297"  ch/ion                ch/chemical_entity]
  ["Solute"       "Cation"    "GO:0015298"        ch/cation             ch/chemical_entity]
  ["PotassiumIon" "Anion"   "GO:0022821"          ch/anion    ch/potassium_1+_]
  ["Calcium"      "Sodium"    "GO:0005432"        ch/sodium_1+_         ch/calcium_2+_]
  ["Solute"       "Anion"     "GO:0140323"        ch/anion              ch/chemical_entity]
  ["Anion"      "Anion"     "GO:0015301"          ch/anion              ch/anion]
  ["InorganicAnion" "InorganicAnion"               "GO:0005452"  ch/inorganic_anion ch/inorganic_anion]
  ["Organophosphate"        "InorganicPhosphate"   "GO:0015315"       ch/inorganic_phosphate     ch/organic_phosphate]
  ["TriosePhosphate"        "InorganicPhosphate"   "GO:0009670"       ch/inorganic_phosphate     ch/aldotriose_phosphate]
  ["Glyceraldehyde3Phosphate""InorganicPhosphate"  "GO:0051408"       ch/inorganic_phosphate     ch/glyceraldehyde_3-phosphate]
  ["Phosphoenolpyruvate"    "InorganicPhosphate"   "GO:0015121"       ch/inorganic_phosphate     ch/phosphoenolpyruvic_acid]
  ["GlyceronePhosphate"     "InorganicPhosphate"   "GO:0051407"       ch/inorganic_phosphate     ch/glycerone_phosphates]
  ["Glucose6Phosphate"      "InorganicPhosphate"   "GO:0061513"       ch/inorganic_phosphate     ch/D-glucose_6-phosphate]
  ["HexosePhosphate"        "InorganicPhosphate"   "GO:0015526"       ch/inorganic_phosphate     ch/hexose_phosphate]
  ["Dicarboxylate"          "InorganicPhosphate"   "GO:0015364"       ch/inorganic_phosphate     ch/dicarboxylic_acid]
  ["GlycerolPhosphate"      "InorganicPhosphate"   "GO:0015527"       ch/inorganic_phosphate     ch/glycerol_phosphate]
  ["FolicAcid"   "Anion"    "GO:0008518"     ch/anion   ch/folic_acid   has-application-role  ch/drug   has-biological-role	ch/vitamin]
  ["Cation"      "Cation"   "GO:0015491"     ch/cation  ch/cation]
  ["Calcium"     "Cation"   "GO:0015368"     ch/cation  ch/calcium_2+_]
  ["Tartrate"    "Succinate""GO:0015516"     ch/succinate_2-_ ch/tartrate_salt has-part	ch/anion	ch/cation]
  ["Magnesium"   "Sodium"    "GO:0061768"    ch/sodium_1+_ ch/magnesium_2+_]
  ["R-Carnitine" "gamma-butyrobetaine"   "GO:0044667"      ch/_R_-carnitine ch/_4-_trimethylammonio_butanoate]
  ["Arginine"    "Agmatine"   "GO:0043862"    ch/agmatine ch/arginine hasAcidity	Alkaline]
  ["Arginine"    "Ornithine"  "GO:0043858"    ch/ornithine ch/arginine  hasAcidity	Alkaline]
  ["Agmatine"   "Putrescine" "GO:0043861"  ch/putrescine  ch/agmatine]
  ["Solute"	 "Proton"		"GO:0015299"	ch/proton	ch/chemical_entity]
  ["Acridine"	 "Proton"		"GO:0042962"	ch/proton	ch/acridine]
  ["Polyamine"	 "Proton"		"GO:0015312"	ch/proton	ch/polyamine]
  ["Monoamine"	 "Proton"		"GO:0015311"	ch/proton	ch/monoamine]
  ["Drug"	 "Proton"		"GO:0015307"	ch/proton	ch/chemical_entity has-application-role ch/drug]
  ["Tetracycline""Proton"		"GO:0015520"	ch/proton	ch/tetracycline has-biological-role ch/antimicrobial_drug]
  ["Cycloheximide""Proton"		"GO:0015309"	ch/proton	ch/cycloheximide has-biological-role ch/antimicrobial_drug]
  ["Amiloride"	  "Proton"	"GO:0015308"		ch/proton       ch/amiloride has-application-role ch/drug]
  ["Azole"	  "Proton"		"GO:0045119"	ch/proton	ch/azole has-application-role ch/drug]
  ["Aminotriazole""Proton"		"GO:0015314"	ch/proton	ch/amitrole has-application-role ch/drug]
  ["MonovalentCation""Proton"	"GO:0005451"		ch/proton       ch/monovalent_inorganic_cation]
  ["Sodium"	 "Proton"		"GO:0015385"	ch/proton	ch/sodium_1+_]
  ["Potassium"	"Proton"		"GO:0015386"	ch/proton	ch/potassium_1+_]
  ["Lithium"	"Proton"		"GO:0010348"	ch/proton	ch/lithium_1+_]
  ["MetalIon"	"Proton"		"GO:0051139"	ch/proton	ch/metal_cation]
  ["Calcium"	"Proton"		"GO:0015369"	ch/proton	ch/calcium_2+_]
  ["Manganese"	"Proton"		"GO:0010486"	ch/proton	ch/manganese_2+_]
  ["Putrescine" "Ornithine"             "GO:0015496"    ch/L-ornithine  ch/putrescine]
  ["Citrate"    "Succinate"             "GO:0015515"    ch/succinate_2-_ ch/citrate_3-_]
  ["Fumarate"   "Succinate"             "GO:0005469"    ch/succinate_2-_ ch/fumarate_2-_]
  ["Benomyl"    "Proton"                "GO:0015310"    ch/proton        ch/benomyl  has-biological-role ch/antimicrobial_drug ch/xenobiotic]
  ["Acetylcholine" "Proton"             "GO:0005278"    ch/proton        ch/acetylcholine has-application-role ch/drug has-biological-role ch/neurotransmitter]
  )

(deftransport ToTransportIonAntiporter
  :label "ToTransportIon:IonAntiporter"
  :annotation (goid "GO:0099580")
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across go/membrane
  :system Active
  :occurs go/postsynaptic_membrane
  :involved go/regulation_of_postsynaptic_membrane_potential
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportIonInvolvedInRegulationOfpresynapticMembranePotentialAntiporter
  :label "ToTransportIon:IonAntiporterInRegulationOfpresynapticMembranePotentialAntiporter"
  :annotation (goid "GO:0099520")
  :comment "Involved in regulation of presynaptic membrane potential"
  :across go/membrane
  :system Active
  :occurs go/presynaptic_membrane
  :involved go/regulation_of_presynaptic_membrane_potential
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;;https://www.jbc.org/content/256/11/5597.full.pdf
;;https://www.sciencedirect.com/science/article/pii/S0005272807002010?via%3Dihub
(deftransport ToTransportAcylcarnitineCarnitineAntiporter
  :label "ToTransportAcylcarnitine:CarnitineAntiporter"
  :annotation (goid "GO:0005476")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/O-acylcarnitine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/carnitine (owl-some hasConcentration HighConcentration))
  :from go/cytoplasm
  :to go/mitochondrial_matrix
  :direction OppositeDirection)


;; ATP (out) + ADP (in) (+ energy?) ⇌ ATP (in) + ADP (out)
;;Energy is Not known 
;;http://www.tcdb.org/search/result.php?tc=2.A.12
;; It was shown that ADP/ATP exchange is controlled by the
;; proton electrochemical gradient.
;; ref: https://www.sciencedirect.com/science/article/pii/S0167488916300684#bb0045
(deftransport ToTransportATPADPAntiporter
  :label "ToTransportATP:ADPAntiporter"
  :annotation (goid "GO:0005471")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/ATP (owl-some hasConcentration LowConcentration))
         (owl-and ch/ADP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Energy is Not known 
;; http://www.tcdb.org/search/result.php?tc=2.A.12.5
;; https://jb.asm.org/content/188/17/6261.long
(deftransport ToTransportGTPGDPAntiporter
  :label "ToTransportGTP:GDPAntiporter"
  :annotation (goid "GO:0010292")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/GTP (owl-some hasConcentration LowConcentration))
         (owl-and ch/GDP (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://www.tcdb.org/search/result.php?tc=2.A.3.7#2.A.3.7.1
;; https://www.nature.com/articles/nature10917
;; https://www.uniprot.org/uniprot/P63235
(deftransport ToTransportGlutamateGamma-aminobutyricAcidAntiporter
  :label "ToTransportGlutamate:Gamma-aminobutyricAcidAntiporter"
  :annotation (goid "GO:0070909")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glutamate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/gamma-aminobutyric_acid (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; https://www.ncbi.nlm.nih.gov/pubmed/14982633
;; https://link.springer.com/article/10.1007%2Fs00726-011-0989-9
;;lysine(out) + cadaverine(in) = lysine(in) + cadaverine(out). 
(deftransport ToTransportLysineCadaverineProtonAntiporter
  :label "ToTransportLysineCadaverine:ProtonAntiporter"
  :annotation (goid "GO:0043872")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/lysine (owl-some hasConcentration LowConcentration))
         (owl-and ch/cadaverine (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportXoglutarateMalateProtonAntiporter
  :label "ToTransportXoglutarateMalate:ProtonAntiporter"
  :annotation (goid "GO:0015367")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/_2-oxoglutaric_acid (owl-some hasConcentration LowConcentration))
         (owl-and ch/malate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Ref: http://www.tcdb.org/search/result.php?tc=2.A.81
(deftransport ToTransportAspartateAlanineProtonAntiporter
  :label "ToTransportAspartateAlanine:ProtonAntiporter"
  :annotation (goid "GO:0070906")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/alanine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral))
         (owl-and ch/L-aspartate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportCystine:GlutamateProtonAntiporter
  :label "ToTransportCystineGlutamate:ProtonAntiporter"
  :annotation (goid "GO:0015327")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/cystine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Neutral))
         (owl-and ch/glutamate_2-_ (owl-some hasConcentration LowConcentration)
                   (owl-some hasAcidity Acidic) (owl-some has-application-role ch/drug)
                   (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; https://www.x-mol.com/paper/1313197114640273408?recommendPaper=888130
(deftransport ToTransportFumarateL-aspartateAntiporter
  :label "ToTransportFumarate:L-aspartateAntiporter"
  :annotation (goid "GO:0062057")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/fumarate_2-_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/L-aspartate_2-_ (owl-some hasConcentration HighConcentration)
                   (owl-some hasAcidity Acidic) (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/neurotransmitter))
  :direction OppositeDirection)


;;https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1428153/
(deftransport ToTransportTyrosineTyramineIonAntiporter
  :label "ToTransportTyrosineTyramine:IonAntiporter"
  :annotation (goid "GO:0070908")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/tyrosine (owl-some hasConcentration LowConcentration))
         (owl-and ch/tyramine (owl-some hasConcentration LowConcentration)
                              (owl-some has-application-role ch/neurotransmitter))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;;https://jb.asm.org/content/175/10/2864?ijkey=406fa4de435f1936d566cb632c3aecfefeddbe1e&keytype2=tf_ipsecsha
(deftransport ToTransportHistidineHistamineIonAntiporter
  :label "ToTransportHistidineHistamine:IonAntiporter"
  :annotation (goid "GO:0070907")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/histidine (owl-some hasConcentration LowConcentration))
         (owl-and ch/histamine (owl-some hasConcentration LowConcentration)
                               (owl-some has-application-role ch/neurotransmitter))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; Need review
(deftransport ToTransportCalciumCationAntiporterInvolvedInRegulationOfPostsynapticCytosolicCalciumIonConcentration
  :label "ToTransportCalcium:CationAntiporterInvolvedInRegulationOfPostsynapticCytosolicCalciumIonConcentration"
  :annotation (goid "GO:1905060")
  :comment "Involved in regulation of postsynaptic cytosolic calcium ion concentration"
  :across go/membrane
  :system Active
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
  :direction OppositeDirection)

(deftransport ToTransportCalciumCationAntiporterInvolvedInRegulationOfPresynapticCytosolicCalciumIonConcentration
  :label "ToTransportCalcium:CationAntiporterInvolvedInRegulationOfPresynapticCytosolicCalciumIonConcentration"
  :annotation (goid "GO:1905055")
  :comment "Involved in regulation of presynaptic cytosolic calcium ion concentration"
  :across go/membrane
  :system Active
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_presynaptic_cytosolic_calcium_ion_concentration
  :direction OppositeDirection)

(deftransport ToTransportSodiumProtonAntiporterInvolvedInRegulationOfCardiacMuscleCellMembranePotential
  :label "ToTransportSodium:ProtonAntiporterInvolvedInRegulationOfCardiacMuscleCellMembranePotential"
  :annotation (goid "GO:0086040")
  :comment "Involved in regulation of cardiac muscle cell membrane potential"
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :direction OppositeDirection)
  
(deftransport ToTransportCalciumSodiumAntiporterInvolvedInRegulationOfCardiacMuscleCellMembranePotential
  :label "ToTransportCalcium:SodiumAntiporterInvolvedInRegulationOfCardiacMuscleCellMembranePotential"
  :annotation (goid "GO:0086038")
  :comment "Involved in regulation of cardiac muscle cell membrane potential"
  :across go/membrane
  :system Active
  :cargo (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :involved go/regulation_of_cardiac_muscle_cell_membrane_potential
  :direction OppositeDirection)

;;http://www.ebi.ac.uk/interpro/entry/InterPro/IPR004817/
;; http://www.ebi.ac.uk/interpro/entry/IPR004817
(deftransport ToTransportPotassiumCalciumSodiumAntiporter
  :label "ToTransportPotassiumCalcium:SodiumAntiporter"
  :annotation (goid "GO:0008273")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
         (owl-and ch/calcium_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; https://onlinelibrary.wiley.com/doi/pdf/10.1002/%28SICI%291097-010X%2819990701%29284%3A2%3C158%3A%3AAID-JEZ5%3E3.0.CO%3B2-S
(deftransport ToTransportSulfateBicarbonateProtonAntiporter
  :label "ToTransportSulfateBicarbonateProtonAntiporter"
  :annotation (goid "GO:0015383")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sulfate (owl-some hasConcentration LowConcentration))
         (owl-and ch/hydrogencarbonate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


;;; ===========================================
;; ======  Active transport driven by PEP =====
;;;============================================

;;https://www.sciencedirect.com/science/article/pii/002196739500457X
;;http://europepmc.org/abstract/MED/8246840
(deftransport ToTransportGlucoseDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090564")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/glucose_phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



;;https://www.sciencedirect.com/science/article/pii/002196739500457X
;;http://europepmc.org/abstract/MED/8246840
(deftransport ToTransportMannitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090565")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/mannitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/D-mannitol_1-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


;;https://www.sciencedirect.com/science/article/pii/002196739500457X
(deftransport ToTransportNN-diacetylchitobioseDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090566")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N_N'-diacetylchitobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/diacetylchitobiose-6'-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



;;https://www.sciencedirect.com/science/article/pii/002196739500457X
(deftransport ToTransportMannosylglycerateDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090581")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/D-mannosyl-D-glyceric_acid (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/_2-O-_6-phospho-alpha-D-mannosyl_-D-glycerate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportD-fructoseDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090582")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/D-fructose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/D-fructose_1-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportD-sorbitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090583")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/D-glucitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/D-glucitol_3-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportGalactitolDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090584")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/galactitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/galactitol_1-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))



(deftransport ToTransportL-ascorbateDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090585")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/L-ascorbate (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/L-ascorbate_6-phosphate_3-_
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportN-acetylglucosamineDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090586")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N-acetylglucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/N-acetyl-D-galactosamine_6-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportGlucosamineDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090587")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  (owl-and ch/D-glucosamine_6-phosphate
           (owl-some transports-from go/intracellular)
           (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


(deftransport ToTransportN-acetylmuramateDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090588")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N-acetylmuramate (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/N-acetylmuramate_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven Phosphoenolpyruvate)

(deftransport ToTransportTrehaloseDrivenByPhosphocysteinePhosphoenolpyruvate
  :annotation (goid "GO:0090589")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/trehalose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/alpha_alpha-trehalose_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/S-phospho-L-cysteine_residue)))


;; https://www.sciencedirect.com/science/article/pii/S0959440X97801480
(deftransport ToTransportD-glucosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0090590")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/D-glucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/D-glucosamine_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

;; https://www.sciencedirect.com/science/article/pii/S0959440X97801480
(deftransport ToTransportN-acetyl-mannosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0090591")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N-acetylmannosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/aldehydo-N-acetyl-D-mannosamine_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportGlucoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022855")
  :across go/plasma_membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region )
                  (owl-some transports-to go/intracellular))
         (owl-and ch/glucose_phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on
                             ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportNN-diacetylchitobioseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0090562")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N_N'-diacetylchitobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/diacetylchitobiose-6'-phosphate 
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportGlucitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022856")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/glucitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/glucitol_phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportLactoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022869")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/lactose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/lactose_6'-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportMannoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022870")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/mannose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/mannose_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportSorboseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022871")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sorbose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/sorbose_1-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportMannitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022872")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/mannitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/D-mannitol_1-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportMaltoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022873")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/maltose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/maltose_6'-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportCellobioseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022874")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/cellobiose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
  (owl-and ch/_6-phospho-beta-D-glucosyl-_1->4_-D-glucose
           (owl-some transports-to go/intracellular)
           (owl-some transports-from go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportGalactitolDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022875")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/galactitol (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/galactitol_1-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportGalactosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022876")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/galactosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/galactosamine_phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportFructoseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022877")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/fructose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/fructose_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportSucroseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022878")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/sucrose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/sucrose_6_F_-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportTrehaloseDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022879")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/trehalose (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/trehalose_phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))


(deftransport ToTransportN-acetylglucosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022880")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N-acetylglucosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/N-acetyl-D-glucosamine_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportN-acetylgalactosamineDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022881")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/N-acetylgalactosamine (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/N-acetyl-D-galactosamine_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))

(deftransport ToTransportBeta-glucosideDrivenByPhosphohistidinePhosphoenolpyruvate
  :annotation (goid "GO:0022882")
  :across go/membrane
  :system Active
  :cargo (owl-and ch/beta-glucoside (owl-some hasConcentration LowConcentration)
                  (owl-some transports-from go/extracellular_region)
                  (owl-some transports-to go/intracellular))
         (owl-and ch/_2-nitrophenyl_beta-D-glucoside_6-phosphate
                  (owl-some transports-from go/intracellular)
                  (owl-some transports-to go/intracellular))
  :driven (owl-and Phosphoenolpyruvate
                   (owl-some dependent-on ch/N_pros_-phospho-L-histidine_residue)))
