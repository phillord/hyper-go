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
(defoproperty transports-from)
(defoproperty transports-to)
(defoproperty has-part)
(defoproperty transports-across)
(defoproperty dependent-on)
(defoproperty driven-by)
(defoproperty linked-to
  :comment "One activity which happens at the same time as another and
  which can only occur because the other does.")
(defoproperty hasRole)

(defoproperty transports-with-high-affinity :super transports)
(defoproperty transports-with-low-affinity  :super transports)


;;
(p/defpartition BindingAffinity
  [LowAfinity HighAfinity])

(p/defpartition CellPosition
  [Inner Outer])

(p/defpartition Mechanism
  [Rotational Phosphorylative])

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
    :role :when :driven :linked :mechanism]))

(defentity deftransport "" 'transport)


;;A substance or substances transported either from the inside of the cell to the outside and and vice versa.
(defn substance-transporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo ~(nth lis 2)
     :driven ATPase
     :from (owl-some hasCellPosition (owl-or Inner Outer))
     :to (owl-some hasCellPosition (owl-or Inner Outer))))

;; macro function to do the classes mapping 
(defmacro deftransporters [& lis]
  `(do ~@(map substance-transporting-ATPase lis)))


;;#A substance or substances transported from the inside of the cell to the outside.
(defn substance-exporting-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ExportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo ~(nth lis 2)
     :driven ATPase
     :from (owl-some hasCellPosition  Inner)
     :to (owl-some hasCellPosition Outer)))

;; macro function to do the classes mapping 
(defmacro defexporters [& lis]
  `(do ~@(map substance-exporting-ATPase lis)))

;;#A substance or substances transported from outside of the cell to the inside.
(defn substance-importing-ATPase [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "ImportingDrivenWithATPase"))
     :comment ~(second lis)
     :cargo ~(nth lis 2)
     :driven ATPase
     :from (owl-some hasCellPosition Outer)
     :to (owl-some hasCellPosition Inner)))

;; macro function to do the classes mapping 
(defmacro defimporters [& lis]
  `(do ~@(map substance-importing-ATPase lis)))


(deftransport ToTransportZincIonWithHighAfinity
  :comment "GO:0000006"
  :cargo (owl-and ch/zinc_2+_ (owl-some hasBindingAffinity HighAfinity)))

(deftransport ToTransportZincIonWithLowAfinity
  :comment "GO:0000007"
  :cargo (owl-and ch/zinc_2+_ (owl-some hasBindingAffinity LowAfinity)))

(deftransport ToTransportAminoAcid
  :cargo ch/amino_acid)

(deftransport ToTransportBasicAminoAcid
  :comment "GO:0015174"
  :cargo (owl-and ch/amino_acid (owl-some hasAcidity Alkaline)))

(deftransport ToTransportBasicAminoAcidWithHighAfinity
  :comment "GO:0005287"
  :cargo (owl-and ch/amino_acid (owl-some hasBindingAffinity HighAfinity) (owl-some hasAcidity Alkaline)))

(deftransport ToTransportBasicAminoAcidWithLowAfinity
  :comment "GO:0005287"
  :cargo (owl-and ch/amino_acid (owl-some hasBindingAffinity LowAfinity) (owl-some hasAcidity Alkaline)))


(deftransport ToTransportArginineWithHighAfinity
  :comment "GO:0005289"
  :cargo (owl-and ch/arginine (owl-some hasBindingAffinity HighAfinity) (owl-some hasAcidity Alkaline)))


(deftransport ToTransportZincIony
  ;;"GO:0005385"
  :cargo ch/zinc_ion)

(deftransport ToTransportLongChainFattyAcid
  ;;"GO:0005324"
  :cargo ch/long-chain_fatty_acid)

(deftransport ToTransportFattyAcid
  ;;"GO:0015245"
  :cargo ch/fatty_acid)

(deftransport ToTransportShortChainFattyAcid
  ;;"GO:0015636"
  :cargo ch/short-chain_fatty_acid)

(deftransport ToTransportL-ornithine
  ;;"GO:0000064"
  :role ch/L-ornithine)

(deftransport ToTransportS-adenosyL-methionine
  ;;"GO:0000095"
  :role ch/S-adenosyl-L-methionine)

(deftransport ToTransportSulfurAminoAcid
  ;;"GO:0000099"
  :cargo ch/sulfur-containing_amino_acid)

(deftransport ToTransportS-methylmethionine
  ;;"GO:0000100"
  :role ch/S-methyl-L-methionine)

(deftransport ToTransportL-valine
  ;;"GO:0005304"
  :role ch/L-valine)

(deftransport ToTransportL-isoleucine
  ;;"GO:0015188"
  :role ch/L-isoleucine)

(deftransport ToTransportNucleoside
  ;;"GO:0005337"
  :cargo ch/nucleoside)

(deftransport ToTransportAdenineNucleotide
  ;;"GO:0000295"
  :cargo ch/adenyl_nucleotide)

(deftransport ToTransportSperminey
  ;;"GO:0000297" 
  :role ch/spermine)

(deftransport ToTransportSulfite
  ;;"GO:0000319"
  :cargo ch/sulfite)

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

(deftransport ToTransportDrivenWithATPase
  :driven ch/chemical_entity ATPase)

(deftransport ToTransportCationDrivenWithATPase
  ;;"GO:0019829"
  :driven ch/cation ATPase)


; map values
(deftransporters
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
      ["peptide"		"GO:0015440"	ch/peptide]
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
      ["carbohydrate"		"GO:0043211"	ch/carbohydrate]
      ["Bacteriocin"		"GO:0043214"	ch/bacteriocin]
      ["Daunorubicin"		"GO:0043216"	ch/daunorubicin]
      ["Anion"			"GO:0043225"	ch/anion]
      ["thiamine"		"GO:0048502"	ch/thiamine]
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
(defexporters
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
(defimporters
      ["Magnesium"			"GO:0015444"	ch/magnesium_2+_]
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
