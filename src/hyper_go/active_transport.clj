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
  ["Solute"		"GO:0015295"		ch/chemical_entity]
  ["Selenite"		"GO:0097079"		ch/selenite_2-_]  ;; evidence PMID:20861301
  ["Succinate"		"GO:0097434"		ch/succinate_2-_ has-application-role ch/drug]  ;; evidence PMID:1293882 
  ["Glucosinolate"	"GO:0090448"		ch/glucosinolate]
  ["FerricEnterobactin" "GO:0015345"		ch/ferrienterobactin_3-_ has-biological-role ch/siderophore]
  )
