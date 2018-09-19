(ns hyper-go.active_transporter
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]))


(ontology-to-namespace hyper-go.core/hyper-go)


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

;; classified in GO as primary and secondary active transporter. !!
(deftransport ToTransportProteinActive
  :comment "GO:0009977"
  :across Membrane
  :cargo (owl-and ch/protein (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration)))


;; ==== Next is GO:0008504

;; =====================================================
;;============== Primary Active transporters =========
;;======================================================



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




;; =====================================================
;;============== Secondary Active transporters =========
;;======================================================

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

(deftransport ToTransportZincIonEffluxActive
  :comment "GO:0015341"
  :across Membrane
  :cargo (owl-and ch/zinc_2+_ (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :from Intracellular
  :to ExtracellularRegion)

(deftransport ToTransportNeutralL-AminoAcidSecondaryActive
  :comment "GO:0005294"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral) (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportActiveBorate
  :comment "GO:0046715"
  :across Membrane
  :cargo (owl-and ch/borate (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportL-methionineSecondaryActiveTransmembrane
  :comment "GO:0000102"
  :across Membrane
  :cargo (owl-and ch/L-methionine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))




;; =====================================================
;;============== Symporter Secondary Active transporters =========
;;======================================================

;;solute(out) + cation(out) = solute(in) + cation(in).
;; The cation is Na+, Li+ or H+. 
(deftransport ToTransportSolute:CationSymporter
  :comment "GO:0015294"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAcetate:CationSymporter
  :comment "GO:0043893"
  :across Membrane
  :cargo (owl-and ch/acetate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAnion:CationSymporter
  :comment "GO:0043893"
  :across Membrane
  :cargo (owl-and ch/inorganic_anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportChloride:CationSymporter
  :comment "GO:0015377"
  :across Membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportChloride:PotassiumSymporter
  :comment "GO:0015379"
  :across Membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportCarbohydrate:CationSymporter
  :comment "GO:0005402"
  :across Membrane
  :cargo (owl-and ch/carbohydrate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportMelibiose:CationSymporter
  :comment "GO:0015487"
  :across Membrane
  :cargo (owl-and ch/melibiose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycoside-Pentoside-Hexuronide:CationSymporter
  :comment "GO:0015487"
  :across Membrane
  :cargo (owl-and (owl-or ch/glycoside ch/pentoside ch/hexuronate
                          (owl-some hasConcentration LowConcentration)))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlucuronate:CationSymporter
  :comment "GO:0015488"
  :across Membrane
  :cargo (owl-and ch/glucuronate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportSucrose:CationSymporter
  :comment "GO:0009669"
  :across Membrane
  :cargo (owl-and ch/sucrose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAminoAcid:CationSymporter
  :comment "GO:0005416"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportNucleobase:CationSymporter
  :comment "GO:0015391"
  :across Membrane
  :cargo (owl-and ch/nucleobase (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportUracil:CationSymporter
  :comment "GO:0015505"
  :across Membrane
  :cargo (owl-and ch/uracil (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportAminoAcid:PotassiumSymporter
  :comment "GO:0017032"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


;;=====================================================
;;==== Sodium symporter Secondary Active transporters =
;;======================================================

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
     :across Membrane
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
  )


;; neutral, basic amino acid:sodium:chloride symporter activity GO:0015374

(deftransport ToTransportCreatine:SodiumSymporter
  :comment "GO:0005309"
  :across Membrane
  :cargo (owl-and ch/creatine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug)
                  (owl-some has-biological-role ch/cofactor))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportGlycine:SodiumSymporter
  :comment "GO:0015375"
  :across Membrane
  :cargo (owl-and ch/glycine (owl-some hasConcentration LowConcentration) (owl-some hasAcidity Neutral)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportPantothenate:SodiumSymporter
  :comment "GO:0015498"
  :across Membrane
  :cargo (owl-and ch/pantothenate (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/cofactor ch/vitamin))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

(deftransport ToTransportL-ascorbate:SodiumSymporter
  :comment "GO:0008520"
  :across Membrane
  :cargo (owl-and ch/L-ascorbate (owl-some hasConcentration LowConcentration)
                  (owl-some hasEnantiomerism L-Enantiomer)
                  (owl-some has-biological-role ch/vitamin ch/coenzyme))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportPyrimidine-And-AdenineNucleobase:SodiumSymporter
  :comment "GO:0015389"
  :across Membrane
  :cargo (owl-and (owl-or ch/pyrimidine_nucleoside ch/adenine (owl-some hasConcentration LowConcentration)))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)



;;=============================================================================

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportNeurotransmitter:SodiumSymporter
  :comment "GO:0005328"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; Need Review
;; http://www.tcdb.org/search/result.php?tc=2.a.30
;; {Na+ or K+ + Cl-} (out) ⇌ {Na+ or K+ + Cl-} (in).
(deftransport ToTransportChloride:Potassium:SodiumSymporter
  :comment "GO:0008511"
  :across Membrane
  :cargo (owl-and ch/chloride (owl-some hasConcentration LowConcentration))
  :driven (owl-and (owl-or ch/potassium_1+_ ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportSerotonin:Chloride:SodiumSymporter
  :comment "GO:0005335"
  :across Membrane
  :cargo (owl-and ch/serotonin (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/sodium_1+_ ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportDopamine:Chloride:SodiumSymporter
  :comment "GO:0005330"
  :across Membrane
  :cargo (owl-and ch/dopamine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug))
  :driven (owl-and ch/sodium_1+_ ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)

;; https://link.springer.com/article/10.1007%2Fs00424-003-1064-5
(deftransport ToTransportNorepinephrine:Chloride:SodiumSymporter
  :comment "GO:0005334"
  :across Membrane
  :cargo (owl-and ch/noradrenaline (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ ch/chloride (owl-some hasConcentration HighConcentration))
  :direction SameDirection)


(deftransport ToTransportLowAffinityGlucose:SodiumSymporter
  :comment "GO:0005362"
  :across Membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)


(deftransport ToTransportHighAffinityInorganicPhosphate:SodiumSymporter
  :comment "GO:0005316"
  :across Membrane
  :cargo (owl-and ch/inorganic_phosphate (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)

(deftransport ToTransportLowAffinityDicarboxylate:SodiumSymporter
  :comment "GO:0015361"
  :across Membrane
  :cargo (owl-and ch/dicarboxylic_acid (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)

(deftransport ToTransportHighAffinityDicarboxylate:SodiumSymporter
  :comment "GO:0015362"
  :across Membrane
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
     :across Membrane
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
  )


;; GO:0005360 insulin-responsive glucose:proton symporter 

(deftransport ToTransportLowAffinityGlucose:ProtonSymporter
  :comment "GO:0005359"
  :across Membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with LowAffinity
  :direction SameDirection)



(deftransport ToTransportHighAffinityGlucose:ProtonSymporter
  :comment "GO:0005358"
  :across Membrane
  :cargo (owl-and ch/glucose (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :transports-with HighAffinity
  :direction SameDirection)








;;=====================================================
;;==== Antiporter Secondary Active transporters =
;;======================================================



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
     :across Membrane
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


;; ion A(out) + ion B(in) = ion A(in) + ion B(out) where ion A and ion B are different types of ion. 
(deftransport ToTransportIonAntiporter
  :comment "GO:0099516"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportIonInvolvedInRegulationOfPostsynapticMembranePotentialAntiporter
  :comment "GO:0099580"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :involved PostsynapticMembrane
  :occurs PostsynapticMembrane
  :direction OppositeDirection)

(deftransport ToTransportIonInvolvedInRegulationOfPresynapticMembranePotentialAntiporter
  :comment "GO:0099520"
  :across Membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/ion (owl-some hasConcentration HighConcentration))
  :involved PresynapticMembrane
  :occurs PresynapticMembrane
  :direction OppositeDirection)




;; http://www.tcdb.org/search/result.php?tc=2.A.31
(deftransport ToTransportAnion:AnionAntiporter
  :comment "GO:0015301"
  :across Membrane
  :cargo (owl-and ch/anion (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/anion (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

;; http://europepmc.org/abstract/MED/21568705
;; http://www.tcdb.org/search/result.php?tc=2.A.48
;;RFC is an organic anion antiporter that utilizes the high
;;transmembrane organic phosphate gradient to achieve uphill folate transport into cel
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






;;lysine(out) + cadaverine(in) = lysine(in) + cadaverine(out). 
;; (deftransport ToTransportLysine:CadaverineAntiporter
;;   :comment "GO:0043872"
;;   :across Membrane
;;   :cargo 





;;=======================

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
  :cargo (owl-and ch/citrate_3-_ (owl-some has-biological-role ch/antimicrobial_drug)
                  (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/succinate_2-_ (owl-some has-application-role ch/drug)
                 (owl-some hasConcentration LowConcentration))
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
                  (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportBenomyl:ProtonAntiporter
  :comment "GO:0015310"
  :across Membrane
  :cargo (owl-and ch/benomyl (owl-some hasConcentration LowConcentration)
                  (owl-some has-biological-role ch/antimicrobial_drug ch/xenobiotic))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)

(deftransport ToTransportAcetylcholine:ProtonAntiporter
  :comment "GO:0005278"
  :across Membrane
  :cargo (owl-and ch/acetylcholine (owl-some hasConcentration LowConcentration)
                  (owl-some has-application-role ch/drug) (owl-some has-biological-role ch/neurotransmitter))
  :driven (owl-and ch/proton (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)
