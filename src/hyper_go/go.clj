(ns hyper-go.go
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny.pattern :as p]))


(defontology hyper-go
  :iri "http://example.com/hyper-go")

(owl-import tawny-chebi.chebi/chebi)

;; Stuff from other ontologiesy
(declare-classes Location Membrane ATPase ATP)
(defoproperty bearer-of)

(declare-classes Mitochondrion Chloroplast 
  :super Location)

;; Transporters
;(defclass ToTransport)
(defoproperty transports)

;; transport some chemical entity usually from location to another
(defoproperty transports-from)
(defoproperty transports-to)
(defoproperty has-part)
(defoproperty transports-across)
(defoproperty dependent-on)
;; transport chemical entity which driven by some other chemical entity or enzyme
(defoproperty driven-by)
(defoproperty linked-to
  :comment "One activity which happens at the same time as another and
  which can only occur because the other does.")

;; transport chemical entities which has some role
(defoproperty hasRole)

(defclass ValuePartition)

;;Transporter transports some chemical entities with high or low affinity
;; The affinity is a property for the transporter not the thing being transported
(p/defpartition BindingAffinity
  [LowAffinity HighAffinity]
  :super ValuePartition)

;; transports a substance or substances inside or outside the cell
(p/defpartition CellPosition
  [Inner Outer]
  :super ValuePartition)

;; some chemical entities transported with a specific mechanism
(p/defpartition Mechanism
  [Rotational Phosphorylative]
  :super ValuePartition)

;; Amino acid, Basic amino acid and acidic amino acid have different ph scale
(p/defpartition Acidity
  [Acidic Neutral Alkaline]
  :super ValuePartition)

;; Particles or solutes moves from an area with high number of particles an area of lower number of particles  
(p/defpartition Concentration
  [LowConcentration HighConcentration]
  :super ValuePartition)

;; Symporter and Antiporters
(p/defpartition Direction
  [SameDirection OppositeDirection]
  :super ValuePartition)

(p/defpartition Enantiomer
  [D-Enantiomer L-Enantiomer])


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
                       (with-property frames :direction hasDirection)
                       (with-property frames :across transports-across)
                       (with-property frames :driven driven-by)
                       (with-property frames :linked linked-to) 
                       (with-property frames :role bearer-of)
                       (with-property frames :when dependent-on)
                       (with-property frames :mechanism hasMechanism)]))))

(def transport
  (p/extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven :linked :transports-with :mechanism :across :direction]))

(defentity deftransport "" 'transport)

(deftransport ToTransport
  :cargo ch/chemical_entity)

;; Requires energy to transports molecules.
;; Move molecules against thier concentration gradient
(deftransport ToTransportActiveTransmembrane
  :comment "GO:0022804"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and  ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; Requires energy to transports molecules.
;; The energy derived directly from the breakdown of ATP.
(deftransport ToTransportPrimaryActiveTransmembrane
  :comment "GO:0015399"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration LowConcentration))
  :driven (owl-and ATPase (owl-some hasConcentration HighConcentration)))


;; chemical role
(deftransport ToTransportDrug
  :comment "GO:0015238"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasRole ch/drug)))

;; chemical role
(deftransport ToTransportVitamin
  :comment "GO:0090482"
  :across Membrane
  :cargo (owl-and ch/chemical_entity (owl-some hasRole ch/vitamin)))

;; chemical role
(deftransport ToTransportCofactor
  :comment "GO:0051184"
  :across Membrane
  :cargo (owl-and ch/cofactor (owl-some hasRole ch/cofactor)))

;; Neurotransmitters are any chemical substance that is capable of transmitting a nerve impulse from a neuron to another cell. 
(deftransport ToTransportNeurotransmitter
  :comment "GO:0005326"
  :cargo (owl-and ch/chemical_entity (owl-some hasRole ch/neurotransmitter)))


;;Enables the transfer of a specific substance or related group of substances from the outside of the cell to the inside of the cell across a membrane.
(deftransport ToTransportInfluxTransmembrane
  :comment ""
  :cargo ch/chemical_entity
  :across Membrane
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner))

;;Enables the transfer of a specific substance or related group of substances from the inside of the cell to the outside of the cell across a membrane.
(deftransport ToTransportEffluxTransmembrane
  :comment "GO:0015562"
  :cargo ch/chemical_entity
  :across Membrane
  :from (owl-some hasCellPosition Inner)
  :to (owl-some hasCellPosition Outer))

;;#A substance or substances transported from the inside of the cell to the outside.
;; Driven by ATPase
(defn substance-exporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ExportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo (owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration))
     :driven ATPase
     :across Membrane
     :from (owl-some hasCellPosition  Inner)
     :to (owl-some hasCellPosition Outer)))

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
     :from (owl-some hasCellPosition Outer)
     :to (owl-some hasCellPosition Inner)))

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


;;Transmembrane transporter activity
(deftransport ToTransportTransmembrane
  :comment "GO:0022857"
  :across Membrane
  :cargo ch/chemical_entity
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))




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

;; 
(deftransport ToTransportD-glucarate
  :comment "GO:0042878"
  :across Membrane
  :cargo (owl-and ch/D-glucarate_2-_ (owl-some hasEnantiomer D-Enantiomer)
                  (owl-some hasRole ch/drug)))

(deftransport ToTransportGalactarate
  :comment "GO:1902301"
  :across Membrane
  :cargo ch/galactaric_acid_anion)

(deftransport ToTransportGalactitol
  :comment "GO:0015577"
  :across Membrane
  :cargo ch/galactitol)

(deftransport ToTransportSugar
  :comment "GO:0051119"
  :across Membrane
  :cargo ch/sugar)

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
  :cargo (owl-and ch/D-ribose (owl-some hasEnantiomer D-Enantiomer)))

;; Transfer of an inorganic molecular entity from the outside of a cell to the inside of the cell across a membrane.
;; An inorganic molecular entity is a molecular entity that contains no carbon. 
(deftransport ToTransportInorganicMolecularEntityTransmembrane
  :comment "GO:0015318"
  :across Membrane
  :cargo ch/inorganic_molecular_entity)

(deftransport ToTransportAminoAcidTransmembrane
  :comment "GO:0015171"
  :across Membrane
  :cargo ch/amino_acid)

(deftransport ToTransportL-AminoAcidTransmembrane
  :comment "GO:0015179"
  :across Membrane
  :cargo (owl-and ch/L-alpha-amino_acid (owl-some hasEnantiomer L-Enantiomer)))

(deftransport ToTransportBranchedChainAminoAcidTransmembrane
  :comment "GO:0015658"
  :across Membrane
  :cargo ch/branched-chain_amino_acid)

(deftransport ToTransportSulfurAminoAcidTransmembrane
  :comment "GO:0000099"
  :across Membrane
  :cargo ch/sulfur-containing_amino_acid)

(deftransport ToTransportNeutralAminoAcidTransmembrane
  :comment "GO:0015175"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral)))

(deftransport ToTransportL-glutamineTransmembrane
  :comment "GO:0015186"
  :across Membrane
  :cargo (owl-and ch/L-glutamine (owl-some hasAcidity Neutral) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug)))

(deftransport ToTransportNeutralL-AminoAcidSecondaryActiveTransmembrane
  :comment "GO:0005294"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Neutral) (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportBasicAminoAcidTransmembrane
  :comment "GO:0015174"
  :across Membrane
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline)))

(deftransport ToTransportL-lysineTransmembrane
  :comment "GO:0015189"
  :across Membrane
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline) (owl-some hasRole ch/drug)))

(deftransport ToTransportL-histidine
  :comment "GO:0005290"
  :across Membrane
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some hasRole ch/drug)))

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
  :cargo (owl-and ch/L-lysine (owl-some hasAcidity Alkaline) (owl-some hasRole ch/drug))
  :from (owl-some hasCellPosition Inner)
  :to (owl-some hasCellPosition Outer))

;;lysine(out) + cadaverine(in) = lysine(in) + cadaverine(out). 
;; (deftransport ToTransportLysine:CadaverineAntiporter
;;   :comment "GO:0043872"
;;   :across Membrane
;;   :cargo 




(deftransport ToTransportAcidicAminoAcid
  :comment "GO:0015172"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Acidic)))


;; substances transported with high and low affinities
(deftransport ToTransportArginineWithHighAffinity
  :comment "GO:0005289"
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportL-histidineWithHighAffinity
  :comment "GO:0005291"
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline) (owl-some hasRole ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportLysineWithHighAffinity
  :comment "GO:0005292"
  :cargo (owl-and ch/lysine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)




(deftransport ToTransportZincIonWithHighAffinity
  :comment "GO:0000006"
  :cargo ch/zinc_2+_
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithLowAffinity
  :comment "GO:0000007"
  :cargo ch/zinc_2+_
  :transports-with LowAffinity)

(deftransport ToTransportTryptophanWithHighAffinity
  :comment "GO:0005300"
  :cargo ch/tryptophan
  :transports-with HighAffinity)

(deftransport ToTransportGlutamateWithHighAffinity
  :comment "GO:0005314"
  :cargo (owl-and ch/glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug ch/neurotransmitter))
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithLowAffinity
  :comment "GO:0009673"
  :cargo ch/phosphate_ion
  :transports-with LowAffinity)

(deftransport ToTransportCopperIonWithHighAffinity
  :comment "GO:0015089"
  :cargo ch/copper_2+_
  :transports-with HighAffinity)

(deftransport ToTransportFerricIronIonWithLowAffinity
  :comment "GO:0015090"
  :cargo ch/iron_2+_
  :transports-with LowAffinity)

(deftransport ToTransportFerricIronIonWithHighAffinity
  :comment "GO:0015092"
  :cargo ch/iron_3+_
  :transports-with HighAffinity)

(deftransport ToTransportGlutamineWithHighAffinity
  :comment "GO:0015330"
  :cargo ch/glutamine
  :transports-with HighAffinity)

(deftransport ToTransportOligopeptideWithHighAffinity
  :comment "GO:0015334"
  :cargo ch/oligopeptide
  :transports-with HighAffinity)

(deftransport ToTransportTryptophanWithLowAffinity
  :comment "GO:0022893"
  :cargo ch/tryptophan
  :transports-with LowAffinity)

(deftransport ToTransportNickelCationWithHighAffinity
  :comment "GO:0044750"
  :cargo ch/nickel_cation
  :transports-with HighAffinity)

(deftransport ToTransportPhosphateWithHighAffinity
  :comment "GO:0048249"
  :cargo ch/phosphate_ion
  :transports-with HighAffinity)

(deftransport ToTransportFructoseWithHighAffinity
  :comment "GO:0061486"
  :cargo ch/fructose
  :transports-with HighAffinity)

(deftransport ToTransportNitrateWithLowAffinity
  :comment "GO:0080054"
  :cargo ch/nitrate
  :transports-with LowAffinity)

(deftransport ToTransportL-arginineWithLowAffinity
  :comment "GO:0097626"
  :cargo (owl-and ch/L-arginine (owl-some hasRole ch/drug))
  :transports-with LowAffinity)

(deftransport ToTransportL-ornithineWithHighAffinity
  :comment "GO:0097627"
  :cargo (owl-and ch/L-ornithine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithHighAffinity
  :comment "GO:0005300"
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomer L-Enantiomer) (owl-some hasRole ch/drug))
  :transports-with HighAffinity)

(deftransport ToTransportL-tryptophanWithLowAffinity
  :comment "GO:0022893"
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomer L-Enantiomer) (owl-some hasRole ch/drug))
  :transports-with LowAffinity)




;; ;; A substance or substances transported across membrane
;; (defn transporters [trans]
;;   `(deftransport ~(symbol (str "ToTransport" (first trans)))
;;      :comment ~(second trans)
;;      :across Membrane
;;      :cargo
;;      ~(cond (= 4 (count trans))
;;            `(owl-and ~(nth trans 2) (owl-some hasRole ~(nth trans 3)))
;;            :else (nth trans 2))))


;; ;; macro function to do the classes mapping 
;; (defmacro deftransporters [& def]
;;   `(do ~@(map transporters def)))

;; (deftransporters
;;   ["LongChainFattyAcid"				"GO:0005324"	ch/long-chain_fatty_acid]
;;   ["L-ornithine"					"GO:0000064"	ch/L-ornithine				ch/drug]
;;   ["S-adenosyL-methionine"				"GO:0000095"	ch/S-adenosyl-L-methionine		ch/drug]
;;   ["SulfurAminoAcid"					"GO:0000099"	ch/sulfur-containing_amino_acid]
;;   ["S-methylmethionine"				"GO:0000100"	ch/S-methyl-L-methionine]
;;   ["L-valine"						"GO:0005304"	ch/L-valine				ch/drug]
;;   ["L-isoleucine"					"GO:0015188"	ch/L-isoleucine]
;;   ["Nucleoside"					"GO:0005337"	ch/nucleoside]
;;   ["AdenineNucleotide"					"GO:0000295"	ch/adenyl_nucleotide]
;;   ["Spermine"						"GO:0000297"	ch/spermine				ch/drug]
;;   ["Sulfite"						"GO:0000319"	ch/sulfite]
;;   ["Glycerophosphodiester"				"GO:0001406"	ch/glycerol_1-phosphodiester]
;;   ["GuanineNucleotide"					"GO:0001409"	ch/guanyl_nucleotide]
;;   ["ZincIon"						"GO:0005385"	ch/zinc_ion]
;;   ["AminoAcid"						"GO:0015171"	ch/amino_acid]
;;   ["FattyAcid"						"GO:0015245"	ch/fatty_acid]
;;   ["ShortChainFattyAcid"				"GO:0015636"	ch/short-chain_fatty_acid]
;;   )

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

(deftransport ToTransportAluminumIon
  :comment "GO:0015083"
  :across Membrane
  :cargo ch/aluminium_ion)

;; Positivel charged ions --> Cation
(deftransport ToTransportCation
  :comment "GO:0008324"
  :across  Membrane
  :cargo ch/cation)

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

(deftransport ToTransportChromiumIon
  :comment "GO:0070835"
  :across Membrane
  :cargo ch/chromium_ion)

(deftransport ToTransportLeadIon
  :comment "GO:0015094"
  :across Membrane
  :cargo ch/lead_ion)

;; ===== not 100% correct
;; cation A(out) + cation B(in) = cation A(in) + cation B(out). 
(deftransport ToTransportCationCationAntiporter
  :comment "GO:0015491"
  :across Membrane
  :cargo (owl-and ch/cation (owl-some hasConcentration LowConcentration))
  :driven (owl-and ch/cation (owl-some hasConcentration HighConcentration))
  :direction OppositeDirection)


(deftransport ToTransportL-tryptophan
  :comment "GO:0015196"
  :across Membrane
  :cargo (owl-and ch/L-tryptophan (owl-some hasEnantiomer L-Enantiomer) (owl-some hasRole ch/drug)))

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
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug)))

;; I changed threonine to L-threonine
;; threonine not subclass of L-threonine (see nizal_notes.org)
(deftransport ToTransportL-threonineEfflux
  :comment "GO:0015565"
  :across Membrane
  :cargo (owl-and ch/L-threonine (owl-some hasAcidity Neutral) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug))
  :from (owl-some hasCellPosition Inner)
  :to (owl-some hasCellPosition Outer))


(deftransport ToTransportAmmonium
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
(deftransport ToTransportvitaminB6
  :comment "GO:0031924"
  :across Membrane
  :cargo (owl-and ch/vitamin_B6 (owl-some hasRole ch/drug ch/vitamin)))

(deftransport ToTransportPyridoxal
  :comment "GO:0031925"
  :across Membrane
  :cargo (owl-and ch/pyridoxal (owl-some hasRole ch/drug ch/vitamin ch/cofactor)))

(deftransport ToTransportPyridoxalPhosphate
  :comment "GO:0031926"
  :across Membrane
  :cargo (owl-and ch/pyridoxal_5'-phosphate (owl-some hasRole ch/drug ch/vitamin ch/coenzyme)))

(deftransport ToTransportPyridoxamine
  :comment "GO:0031927"
  :across Membrane
  :cargo (owl-and ch/pyridoxamine (owl-some hasRole ch/drug ch/vitamin)))

(deftransport ToTransportPyridoxine
  :comment "GO:0031928"
  :across Membrane
  :cargo (owl-and ch/pyridoxine (owl-some hasRole ch/drug ch/vitamin ch/cofactor)))

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
  :cargo (owl-and ch/acetylcholine (owl-some hasRole ch/drug ch/neurotransmitter)))

(deftransport ToTransportMethylammonium
  :comment "GO:0015200"
  :across Membrane
  :cargo (owl-and ch/methylammonium))

(deftransport ToTransportCholine
  :comment "GO:0015220"
  :across Membrane
  :cargo (owl-and ch/choline (owl-some hasRole ch/neurotransmitter)))


(deftransport ToTransportL-methionine
  :comment "GO:0015191"
  :across Membrane
  :cargo (owl-and ch/L-methionine (owl-some hasEnantiomer L-Enantiomer) (owl-some hasRole ch/drug)))

(deftransport ToTransportL-methionineSecondaryActiveTransmembrane
  :comment "GO:0000102"
  :across Membrane
  :cargo (owl-and ch/L-methionine (owl-some hasConcentration LowConcentration)  (owl-some hasAcidity Neutral) (owl-some hasRole ch/drug))
  :driven (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))



(deftransport ToTransportGlycerophosphodiester
  ;;"GO:0001406"
  :cargo ch/glycerol_1-phosphodiester)

(deftransport ToTransportGuanineNucleotide
  ;;"GO:0001409"
  :cargo ch/guanyl_nucleotide)

(deftransport ToTransportBetaAlanine
  :comment "GO:0001761"
  :across Membrane
  :cargo (owl-and ch/beta-alanine (owl-some hasAcidity Neutral) (owl-some hasRole ch/neurotransmitter)))

(deftransport ToTransportGlycine
  :comment "GO:0015187"
  :across Membrane
  :cargo (owl-and ch/glycine (owl-some hasAcidity Neutral) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug ch/neurotransmitter)))

(deftransport ToTransportNitricOxide
  :comment "GO:0030184"
  :across Membrane
  :cargo (owl-and ch/nitric_oxide (owl-some hasRole ch/drug ch/neurotransmitter)))

(deftransport ToTransportGammaAminobutyricAcid
  :comment "GO:0015185"
  :across Membrane
  :cargo (owl-and ch/gamma-aminobutyric_acid (owl-some hasRole ch/neurotransmitter)))

(deftransport ToTransportL-glutamate
  :comment "GO:0005313"
  :across Membrane
  :cargo (owl-and ch/L-glutamate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug ch/neurotransmitter)))

(deftransport ToTransportL-aspartate
  :comment "GO:0015183"
  :across Membrane
  :cargo (owl-and ch/L-aspartate_2-_ (owl-some hasAcidity Acidic) (owl-some hasEnantiomer L-Enantiomer)
                  (owl-some hasRole ch/drug ch/neurotransmitter)))


;; There is no metal ion in CHEBI
(deftransport ToTransportMetalIon
  ;;"GO:0046873"
  :cargo ch/metal_cation)

;; There is no iron ion in CHEB
(deftransport ToTransportIronIon
  ;;"GO:0005381"
  :role ch/iron_2+_)




(deftransport ToTransportChloride
  ;;"GO:0015108"
  :cargo ch/chloride)

(deftransport ToTransportChromiumIon
  ;;"GO:0070835"
  :cargo ch/chromium_ion)

(deftransport ToTransportWithChemicalCondition
  :when ch/chemical_entity ch/chemical_entity)

(deftransport ToTransportOrganicAnionWithSodiumCondition
  ;;"GO:0015347"
  :when ch/organic_ion ch/sodium_1+_)


(deftransport ToTransportBiotinTransmembrane
  :comment "GO:0015225"
  :across Membrane
  :cargo (owl-and ch/biotin (owl-some hasRole ch/drug ch/coenzyme ch/vitamin)))

(deftransport ToTransportBicozamycin
  ;;"GO:0015545"
  :role ch/bicozamycin)



;; A substance or substances transported either from the inside of the cell to the outside and and vice versa.
;; Driven by ATPase
(defn substance-transporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo
     ~(cond (= 4 (count lis))
            `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration) (owl-some hasRole ~(nth lis 3)))
            :else `(owl-and ~(nth lis 2) (owl-some hasConcentration LowConcentration)))
     :driven ATPase
     :across Membrane
     :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner))))))

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
  ["Arsenite"			"GO:0015446"	ch/arsenite_ion]
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
  ["Glutathione S-conjugate" 	"GO:0071997"	ch/glutathione_conjugate]		;; linked to broad term in ChEBI
  ["Glycerol-2-phosphate"	"GO:0070812"	ch/glycerol_2-phosphate]
  ["LipoChitinOligosaccharide" "GO:1901514" 	ch/lipo-chitin_oligosaccharide]
  ["QuaternaryAmine"		"GO:0102908"	ch/quaternary_ammonium_ion]		;; are they the same?
  ["QuaternaryAmine"		"GO:0015418"	ch/quaternary_ammonium_ion]
  ["Choline"			"GO:0033266"	ch/choline			ch/neurotransmitter]
  ["Guanine"                	"GO:0008558"    ch/guanine]
  ["Heme"			"GO:0015439"	ch/heme			ch/cofactor]
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
  ["Taurine"                	"GO:0015411"    ch/taurine ch/xenobiotic]   ;; xenobiotic or  EC_3.6.3.44  is it a drug?
  ["CarboxylicAcid"		"GO:0033284"	ch/carboxylic_acid]
  ["AminoAcid"			"GO:0015424"	ch/amino_acid]
  ["NonpolarAminoAcid"		"GO:0015425"	ch/nonpolar_amino_acid]
  ["PolarAminoAcid"		"GO:0015426"	ch/polar_amino_acid]
  
      ["QuaternaryAmmoniumIon"  "GO:0015418"	ch/quaternary_ammonium_ion]
      
      
      
      ["Cadmium"		"GO:0015434"	ch/cadmium_cation]
      ["CapsularPolysaccharide" "GO:0015436"	ch/polysaccharide]
      ["TeichoicAcid"		"GO:0015438"	ch/teichoic_acid]
      ["Protein"		"GO:0015462"	ch/protein]
      ["ThiaminePyrophosphate"	"GO:0015619"	ch/thiamine_1+__diphosphate_1-_]
      ["iron-chelate"		"GO:0015623"	ch/iron_chelate]
      ["FerricEnterobactin"	"GO:0015624"	ch/ferrienterobactin]
      ["FerricHydroxamate"	"GO:0015625"	ch/iron_III__hydroxamate]
      ["Zinc"			"GO:0015633"	ch/zinc_2+_]
      ["Amine"			"GO:0031263"	ch/amine]
      ["Betaine"		"GO:0031458"	ch/amino-acid_betaine]
      ["GlycineBetaine"	"GO:0031459"	ch/glycine_betaine]
      ["Thiosulfate"		"GO:0102025"	ch/thiosulfate]
      ["Urea"			"GO:0033221"	ch/urea]
      ["2-aminoethylphosphonate""GO:0033225"	ch/_2-aminoethyl_phosphonic_acid]
      ["Cysteine"		"GO:0033230"	ch/cysteine]
      ["D-methionine"		"GO:0033232"	ch/D-methionine]
      ["MonocarboxylicAcid"	"GO:0033285"	ch/monocarboxylic_acid]
      ["Ectoine"		"GO:0033286"	ch/ectoine]
      ["Hydroxyectoine"	"GO:0033288"	ch/_5-hydroxyectoine]
      ["Bacteriocin"		"GO:0043214"	ch/bacteriocin]
      ["Methionine"		"GO:1901243"	ch/methionine])

;;Atp + H2o + daunorubicin(in) = ADP + phosphate + daunorubicin(out). 
(deftransport ToTransportDaunorubicinTransportingDrivenWithATPase
  :comment "GO:0043216"
  :cargo (owl-and ch/daunorubicin (owl-some hasConcentration LowConcentration) (owl-some hasRole ch/drug))
  :driven ATPase
  :across Membrane
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))

;; ATP + H2O + cob(III)alamin(out) = ADP + phosphate + cob(III)alamin(in).
;; Cobalamin is also known as vitamin B12. 
(deftransport ToTransportCobalaminTransportingDrivenWithATPase
  :comment "GO:0015420"
  :cargo (owl-and ch/cobalamin (owl-some hasConcentration LowConcentration)
                  (owl-some hasRole ch/drug ch/vitamin ch/cofactor))
  :driven ATPase
  :across Membrane
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))


;; ATP + H2O + ion(in) = ADP + phosphate + ion(out), by a rotational mechanism. 
(deftransport ToTransportIonsTransportingDrivenWithATPaseViaRotationalMechanism.
  :comment "GO:0044769"
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))

(deftransport ToTransportIonsTransportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0015662"
  :cargo (owl-and ch/ion (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Phosphorylative
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))


(deftransport ToTransportProtonTransportingDrivenWithATPaseViaRotationalMechanism.
  :comment "GO:0046961"
  :cargo (owl-and ch/proton (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))


(deftransport ToTransportSodiumTransportingDrivenWithATPase
  :comment "GO:0046962"
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :mechanism Rotational
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))

;; ATP(4-) + cob(I)alamin + H2O <=> ADP(3-) + hydrogenphosphate + cob(I)alamin + H+
(deftransport ToTransportCobIalaminDrivenWithATPase
  :comment "GO:0102023"
  :cargo (owl-and ch/cob_I_alamin (owl-some hasConcentration LowConcentration) (owl-some hasRole ch/B_vitamin))
  :driven ATPase
  :across Membrane
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))

(deftransport ToTransportProteinIntoMitochondrionDrivenWithATPase
  :comment "GO:0008566"
  :cargo ch/protein
  :driven ATPase
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner) Mitochondrion)

(deftransport ToTransportProteinIntoChloroplastStromaDrivenWithATPase
  :comment "GO:0016464"
  :cargo ch/protein
  :driven ATPase
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner) Chloroplast)

(deftransport ToTransportPeptideAntigenTransportingDrivenWithATPase
  :comment "GO:0015433"
  :cargo (owl-and ch/peptide (owl-some hasRole ch/antigen)) 
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer)))


(deftransport ToTransportXenobioticTransportingDrivenWithATPase
  :comment "GO:0008559"
  :cargo (owl-and ch/chemical_entity (owl-some hasRole ch/xenobiotic))
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer)))

;; ATP + H2O + Na+(in) + K+(out) = ADP + phosphate + Na+(out) + K+(in). 
(deftransport ToTransportSodiumPotassiumExchangingDrivenWithATPase
  :comment "GO:0005391"
  :cargo (owl-and ch/sodium_1+_ ch/potassium_1+_ (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))

(deftransport ToTransportPotassiumProtonExchangingDrivenWithATPase
  :comment "GO:0008900"
  :cargo (owl-and ch/potassium_1+_ ch/proton (owl-some hasConcentration LowConcentration))
  :driven ATPase
  :across Membrane
  :equivalent (owl-or (owl-and (owl-some transports-from (owl-some hasCellPosition Inner))
                               (owl-some transports-to (owl-some hasCellPosition Outer)))
                      (owl-and (owl-some transports-from (owl-some hasCellPosition Outer))
                               (owl-some transports-to (owl-some hasCellPosition Inner)))))



;; ;; Not Complete
;; ["Doxorubicin"		"GO:1901242"	ch/doxorubicin]
;; (deftransport ToTransportDoxorubicinTransportingDrivenWithATPase
;;   :comment "GO:1901242"
;;   :cargo (owl-and ch/doxorubicin (owl-some hasRole ch/antibiotic_antifungal_drug)))





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
  :from (owl-some hasCellPosition Inner)
  :to (owl-some hasCellPosition Outer)
  :mechanism Phosphorylative)

(deftransport ToTransportSodiumExportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0008554"
  :cargo ch/sodium_1+_
  :driven ATPase
  :from (owl-some hasCellPosition Inner)
  :to (owl-some hasCellPosition Outer)
  :mechanism Phosphorylative)

; map values
(defimporters-drivenby-ATPase
      ["Magnesium"			"GO:0015444"	ch/magnesium_2+_ ]
      ["Putrescine"			"GO:0015594"	ch/putrescine]
      ["Spermidine"			"GO:0015595"	ch/spermidine]
      ["Carbohydrate"			"GO:0015608"	ch/carbohydrate]
      ["Maltooligosaccharide"		"GO:0015609"	ch/maltooligosaccharide]
      ["GlycerolPhosphate"		"GO:0015610"	ch/glycerol_phosphate]
      ["D-ribose"			"GO:0015611"	ch/D-ribose]
      ["L-arabinose"			"GO:0015612"	ch/L-arabinose]
      ["D-xylose"			"GO:0015614"	ch/D-xylose]
      ["D-allose"			"GO:0015615"	ch/D-allose]
      ["AminoAcid"			"GO:0032520"	ch/amino_acid]
      ["D-methionine"			"GO:0032522"	ch/D-methionine]
      ["L-glutamate"			"GO:0102013"	ch/L-glutamate_1-_]
      ["Beta-D-galactose"		"GO:0102014"	ch/beta-D-galactoside])



(deftransport ToTransportGlutamineImportingDrivenWithATPase
  :comment "GO:0015599"
  :driven ATPase
  :across Membrane
  :cargo (owl-and ch/glutamine (owl-some hasConcentration LowConcentration) (owl-some hasRole ch/drug)
                  (owl-some hasAcidity Alkaline))
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner))


(deftransport ToTransportArginineImportingDrivenWithATPase
  :comment "GO:0015598"
  :cargo (owl-and ch/arginine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Alkaline))
  :driven ATPase
  :across Membrane
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner))

(deftransport ToTransportL-arginineImportingDrivenWithATPase
  :comment "GO:0102022"
  :cargo (owl-and ch/L-arginine (owl-some hasConcentration LowConcentration)
                  (owl-some hasAcidity Alkaline) (owl-some hasRole ch/drug))
  :driven ATPase
  :across Membrane
  :from (owl-some hasCellPosition Outer)
  :to (owl-some hasCellPosition Inner))





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


;; (require 'tawny.reasoner)
;; (tawny.reasoner/reasoner-factory :hermit)
;; (tawny.reasoner/reasoner-factory :elk)

;; (subclass? ToTransport ToTransportCation)
;; (subclass? ToTransportCation ToTransport)

;; (tawny.reasoner/isubclass? ToTransportCation ToTransportCationDrivenWithATPase)
;; (tawny.reasoner/isubclass? ToTransportCation ToTransport)


;; (tawny.reasoner/isubclass? ToTransportChloride ToTransportAnion)
;; (tawny.reasoner/isubclass? ToTransportAnion ToTransportChloride)

;; (subclass? ch/chloride ch/cation)
