(ns hyper-go.go
  (:require [tawny.owl :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny.pattern :as p]))


(defontology hyper-go
  :iri "http://example.com/hyper-go")

;; Stuff from other ontologies
(declare-classes Location Membrane ATPase)
(defoproperty bearer-of)

(declare-classes Mitochondrion Chloroplast
  :super Location)

;; Transporters
(defclass ToTransport)
(defoproperty transports)

;; transport some chemical entity usually from location to another
(defoproperty transports-from)
(defoproperty transports-to)

(defoproperty has-part)
(defoproperty transports-across :range Membrane)
(defoproperty dependent-on)
;; transport chemical entity which driven by some other chemical entity or enzyme
(defoproperty driven-by)
(defoproperty linked-to
  :comment "One activity which happens at the same time as another and
  which can only occur because the other does.")

;; transport chemical entities which has some role
(defoproperty hasRole)

;;Transporter transports some chemical entities with high or low affinity
;; The affinity is a property for the transporter not the thing being transported
(p/defpartition BindingAffinity
  [LowAffinity HighAffinity])

;; transports a substance or substances inside or outside the cell
(p/defpartition CellPosition
  [Inner Outer])

;; some chemical entities transported with a specific mechanism
(p/defpartition Mechanism
  [Rotational Phosphorylative])

;; Amino acid, Basic amino acid and acidic amino acid have different ph scale
(p/defpartition Acidity
  [Acidic Neutral Alkaline])

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
                       (with-property frames :mechanism hasMechanism)]))))

(def transport
  (p/extend-frameify
   owl-class
   transport-explicit
   [:from :to :cargo
    :role :when :driven :linked :transports-with :mechanism :across]))

(defentity deftransport "" 'transport)


;;A substance or substances transported either from the inside of the cell to the outside and and vice versa.
;; Driven by ATPase
(defn substance-transporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo ~(nth lis 2)
     :driven ATPase
     :across Membrane
     :from (owl-some hasCellPosition (owl-or Inner Outer))
     :to (owl-some hasCellPosition (owl-or Inner Outer))))

;; macro function to do the classes mapping 
(defmacro deftransporters-drivenby-ATPase [& lis]
  `(do ~@(map substance-transporting-ATPase lis)))


;;#A substance or substances transported from the inside of the cell to the outside.
;; Driven by ATPase
(defn substance-exporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ExportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo ~(nth lis 2)
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
     :cargo ~(nth lis 2)
     :driven ATPase
     :across Membrane
     :from (owl-some hasCellPosition Outer)
     :to (owl-some hasCellPosition Inner)))

;; macro function to do the classes mapping 
(defmacro defimporters-drivenby-ATPase [& lis]
  `(do ~@(map substance-importing-ATPase lis)))



(deftransport ToTransportBasicAminoAcid
  :comment "GO:0015174"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline)))

(deftransport ToTransportAcidicAminoAcid
  :comment "GO:0015172"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Acidic)))


;; substances transported with high and low affinities
(deftransport ToTransportZincIonWithHighAffinity
  :comment "GO:0000006"
  :cargo ch/zinc_2+_
  :transports-with HighAffinity)

(deftransport ToTransportZincIonWithLowAffinity
  :comment "GO:0000007"
  :cargo ch/zinc_2+_
  :transports-with LowAffinity)

(deftransport ToTransportBasicAminoAcidWithHighAffinity
  :comment "GO:0005287"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportBasicAminoAcidWithLowAffinity
  :comment "GO:0097625"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline))
  :transports-with LowAffinity)

(deftransport ToTransportArginineWithHighAffinity
  :comment "GO:0005289"
  :cargo (owl-and ch/arginine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportL-histidineWithHighAffinity
  :comment "GO:0005291"
  :cargo (owl-and ch/L-histidine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportLysineWithHighAffinity
  :comment "GO:0005292"
  :cargo (owl-and ch/lysine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)

(deftransport ToTransportTryptophanWithHighAffinity
  :comment "GO:0005300"
  :cargo ch/tryptophan
  :transports-with HighAffinity)

(deftransport ToTransportGlutamateWithHighAffinity
  :comment "GO:0005314"
  :cargo ch/glutamate_2-_
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
  :cargo ch/L-arginine
  :transports-with LowAffinity)

(deftransport ToTransportL-ornithineWithHighAffinity
  :comment "GO:0097627"
  :cargo (owl-and ch/L-ornithine (owl-some hasAcidity Alkaline))
  :transports-with HighAffinity)


;; A substance or substances transported across membrane
(defn transporters [trans]
  `(deftransport ~(symbol (str "ToTransport" (first trans)))
     :comment ~(second trans)
     :across Membrane
     :cargo
     ~(cond (= 4 (count trans))
           `(owl-and ~(nth trans 2) (owl-some hasRole ~(nth trans 3)))
           :else (nth trans 2))))


;; macro function to do the classes mapping 
(defmacro deftransporters [& def]
  `(do ~@(map transporters def)))

(deftransporters
  ["LongChainFattyAcid"				"GO:0005324"	ch/long-chain_fatty_acid]
  ["L-ornithine"					"GO:0000064"	ch/L-ornithine				ch/drug]
  ["S-adenosyL-methionine"				"GO:0000095"	ch/S-adenosyl-L-methionine		ch/drug]
  ["SulfurAminoAcid"					"GO:0000099"	ch/sulfur-containing_amino_acid]
  ["S-methylmethionine"				"GO:0000100"	ch/S-methyl-L-methionine]
  ["L-valine"						"GO:0005304"	ch/L-valine				ch/drug]
  ["L-isoleucine"					"GO:0015188"	ch/L-isoleucine]
  ["Nucleoside"					"GO:0005337"	ch/nucleoside]
  ["AdenineNucleotide"					"GO:0000295"	ch/adenyl_nucleotide]
  ["Spermine"						"GO:0000297"	ch/spermine				ch/drug]
  ["Sulfite"						"GO:0000319"	ch/sulfite]
  ["ZincIon"						"GO:0005385"	ch/zinc_ion]
  ["AminoAcid"						"GO:0015171"	ch/amino_acid]
  ["FattyAcid"						"GO:0015245"	ch/fatty_acid]
  ["ShortChainFattyAcid"				"GO:0015636"	ch/short-chain_fatty_acid]
  )


(deftransport ToTransportGlycerophosphodiester
  ;;"GO:0001406"
  :cargo ch/glycerol_1-phosphodiester)

(deftransport ToTransportGuanineNucleotide
  ;;"GO:0001409"
  :cargo ch/guanyl_nucleotide)

(deftransport ToTransportBetaAlanine
  ;;"GO:0001761"
  :role ch/beta-alanine)

;; There is no metal ion in CHEBI
(deftransport ToTransportMetalIon
  ;;"GO:0046873"
  :cargo ch/metal_cation)

;; There is no iron ion in CHEB
(deftransport ToTransportIronIon
  ;;"GO:0005381"
  :role ch/iron_2+_)

(deftransport ToTransportIon
  ;;"GO:0015075"
  :cargo ch/ion)

(deftransport ToTransportCation
  ;;"GO:0008324"
  :cargo ch/cation)

(deftransport ToTransportAnion
  ;;"GO:0008509"
  :cargo ch/anion)

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

(deftransport ToTransportDrug
  ;;"GO:0015238"
  :role ch/drug)

(deftransport ToTransportDrugTransmembrane
  ;;"GO:0015238"
  :role ch/drug)

(deftransport ToTransportBiotinTransmembrane
  ;;"GO:0015225"
  :role ch/biotin)

(deftransport ToTransportBicozamycin
  ;;"GO:0015545"
  :role ch/bicozamycin)

;; map values
(deftransporters-drivenby-ATPase
      [""                       "GO:0042626"    ch/chemical_entity ]
      ["Cation"                 "GO:0019829"    ch/cation ]
      ["Phospholipid"           "GO:0004012"    ch/phospholipid ]
      ["Calcium"                "GO:0005388"    ch/calcium_2+_ ]
      ["Chloride"               "GO:0008555"    ch/chloride]
      ["Potassium"              "GO:0008556"    ch/potassium_1+_ ]
      ["Guanine"                "GO:0008558"    ch/guanine ]
      ["Copper"                 "GO:0043682"    ch/copper_2+_ ]
      ["Monosaccharide"         "GO:0015407"    ch/monosaccharide]
      ["Ferric"                 "GO:0015408"    ch/iron_3+_]
      ["Manganese"              "GO:0015410"    ch/manganese_2+_]
      ["Taurine"                "GO:0015411"    ch/taurine]
      ["Molybdate"		"GO:0015412"	ch/molybdate]
      ["Nickel"		"GO:0015413"	ch/nickel_2+_]
      ["Nitrate"		"GO:0015414"	ch/nitrate]
      ["PhosphateIon"		"GO:0015415"	ch/phosphate_ion]
      ["OrganicPhosphonate"	"GO:0015416"	ch/organic_phosphonate]
      ["Polyamine"		"GO:0015417"	ch/polyamine]
      ["QuaternaryAmmoniumIon"  "GO:0015418"	ch/quaternary_ammonium_ion]
      ["Sulfate"		"GO:0015419"	ch/sulfate]
      ["Cobalamin"		"GO:0015420"	ch/cob_III_alamin]
      ["Oligopeptide"		"GO:0015421"	ch/oligopeptide]
      ["Oligosaccharide"	"GO:0015422"	ch/oligosaccharide]
      ["Maltose"		"GO:0015423"	ch/maltose]
      ["AminoAcid"		"GO:0015424"	ch/amino_acid]
      ["NonpolarAminoAcid"	"GO:0015425"	ch/nonpolar_amino_acid]
      ["PolarAminoAcid"	"GO:0015426"	ch/polar_amino_acid]
      ["Glycerol-3Phosphate"	"GO:0015430"	ch/sn-glycerol_3-phosphate]
      ["Cadmium"		"GO:0015434"	ch/cadmium_cation]
      ["CapsularPolysaccharide" "GO:0015436"	ch/polysaccharide]
      ["Lipopolysaccharide"	"GO:0015437"	ch/lipopolysaccharide]
      ["TeichoicAcid"		"GO:0015438"	ch/teichoic_acid]
      ["Heme"			"GO:0015439"	ch/heme]
      ["Peptide"		"GO:0015440"	ch/peptide]
      ["Beta-glucan"		"GO:0015441"	ch/beta-D-glucan]
      ["Arsenite"		"GO:0015446"	ch/arsenite_ion]
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
      ["Cobalt"		"GO:0032778"	ch/cobalt_cation]
      ["Oligogalacturonide"	"GO:0033154"	ch/oligogalacturonide]
      ["Amide"			"GO:0033220"	ch/amide]
      ["Urea"			"GO:0033221"	ch/urea]
      ["2-aminoethylphosphonate""GO:0033225"	ch/_2-aminoethyl_phosphonic_acid]
      ["Cysteine"		"GO:0033230"	ch/cysteine]
      ["D-methionine"		"GO:0033232"	ch/D-methionine]
      ["Choline"		"GO:0033266"	ch/choline]
      ["OrganicAcid"		"GO:0033283"	ch/organic_acid]
      ["CarboxylicAcid"	"GO:0033284"	ch/carboxylic_acid]
      ["MonocarboxylicAcid"	"GO:0033285"	ch/monocarboxylic_acid]
      ["Ectoine"		"GO:0033286"	ch/ectoine]
      ["Hydroxyectoine"	"GO:0033288"	ch/_5-hydroxyectoine]
      ["Rhamnose"		"GO:0033297"	ch/rhamnose]
      ["Lipid"			"GO:0034040"	ch/lipid]
      ["Sterol"		"GO:0034041"	ch/sterol]
      ["Ion"			"GO:0042625"	ch/ion]
      ["Antimonite"		"GO:0042961"	ch/antimonite]
      ["Carbohydrate"		"GO:0043211"	ch/carbohydrate]
      ["Bacteriocin"		"GO:0043214"	ch/bacteriocin]
      ["Daunorubicin"		"GO:0043216"	ch/daunorubicin]
      ["Anion"			"GO:0043225"	ch/anion]
      ["Thiamine"		"GO:0048502"	ch/thiamine]
      ["Glycerol-2-phosphate"	"GO:0070812"	ch/glycerol_2-phosphate]
      ["GlutathioneS-conjugate" "GO:0071997"	ch/glutathione_conjugate]
      ["Alkylphosphonate"	"GO:0102017"	ch/alkylphosphonate]
      ["Tungstate"		"GO:1901238"	ch/tungstate]
      ["Doxorubicin"		"GO:1901242"	ch/doxorubicin]
      ["Methionine"		"GO:1901243"	ch/methionine]
      ["LipoChitinOligosaccharide" "GO:1901514" ch/lipo-chitin_oligosaccharide]
      ["3-5CyclicGMP"		"GO:1905948"	ch/_3'_5'-cyclic_GMP] 
      )

(deftransport ToTransportIonsTransportingDrivenWithATPaseViaRotationalMechanism.
  :comment "GO:0044769"
  :cargo ch/ion
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer))
  :mechanism Rotational)

(deftransport ToTransportIonsTransportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0015662"
  :cargo ch/ion
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer))
  :mechanism Phosphorylative)

(deftransport ToTransportProtonTransportingDrivenWithATPase
  :comment "GO:0046961"
  :cargo ch/proton
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer))
  :mechanism Rotational)


(deftransport ToTransportSodiumTransportingDrivenWithATPase
  :comment "GO:0046962"
  :cargo ch/sodium_1+_
  :driven ATPase
  :from (owl-some hasCellPosition (owl-or Inner Outer))
  :to (owl-some hasCellPosition (owl-or Inner Outer))
  :mechanism Rotational)


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
      ["Proton"			"GO:0036442"	ch/proton]
      ["Carbohydrate"			"GO:0015608"	ch/carbohydrate]
      ;["GlucosylOleandomycin"		"GO:0103113"	]
      )

(deftransport ToTransportProtonExportingDrivenWithATPaseViaPhosphorylativeMechanism
  :comment "GO:0008553"
  :cargo ch/proton
  :driven ATPase
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
      ["Arginine"			"GO:0015598"	ch/arginine]
      ["Glutamine"			"GO:0015599"	ch/glutamine]
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
      ["Beta-D-galactose"		"GO:0102014"	ch/beta-D-galactoside]
      ["L-arginine"			"GO:0102022"	ch/L-argininium_1+_])


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

(owl-import tawny-chebi.chebi/chebi)

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
