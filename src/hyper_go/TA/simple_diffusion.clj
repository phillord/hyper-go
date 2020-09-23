(ns hyper-go.simple_diffusion
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [hyper-go.core :refer :all]
            [tawny.emacs  :refer :all]
            [tawny.query  :refer :all]
            [tawny-chebi.chebi :as ch]
            [tawny-go.go :as go]))


(ontology-to-namespace hyper-go.core/HyperGo)

(deftransport ToTransport
  :annotation (goid "GO:0005215")
  :annotation (identitasId (identitas ""))
  :cargo ch/chemical_entity)

(deftransport ToTransportLipid
  :annotation (goid "GO:0005319")
  :cargo ch/lipid)

(deftransport ToTransportPhospholipid
  :annotation (goid "GO:0005548")
  :annotation (identitasId (identitas ""))
  :cargo ch/phospholipid)

(deftransport ToTransportPhosphatidylinositol
  :annotation (goid "GO:0008526")
  :annotation (identitasId (identitas ""))
  :cargo ch/phosphatidylinositol)

(deftransport ToTransportPhosphatidylethanolamine
  :annotation (goid "GO:1904121")
  :annotation (identitasId (identitas ""))
  :cargo ch/phosphatidylethanolamine)

(deftransport ToTransportPhosphatidylcholine
  :annotation (goid "GO:0008525")
  :annotation (identitasId (identitas ""))
  :cargo ch/phosphatidylcholine)


(deftransport ToTransportSphingolipid
  :annotation (goid "GO:0046624")
  :annotation (identitasId (identitas ""))
  :cargo ch/sphingolipid)

(deftransport ToTransportSterol
  :annotation (goid "GO:0015248")
  :annotation (identitasId (identitas ""))
  :cargo ch/sterol)

;;Transmembrane transporter activity
(defn substance-transporting-across-membrane [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "Transmembrane"))
     :annotation (goid ~(second lis))
     :annotation (identitasId ~(identitas ""))
     :across go/plasma_membrane
     :cargo
     ~(cond (= 3 (count lis)) (nth lis 2)
            (= 5 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4)))
            (= 6 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4) ~(nth lis 5)))
            (= 7 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6)))
            (= 8 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6) ~(nth lis 7)))
            (= 9 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8)))
            (= 10 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8) ~(nth lis 9)))
            (= 11 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8))
                      (owl-some ~(nth lis 9)~(nth lis 10)))
            (= 12 (count lis))
            `(owl-and ~(nth lis 2)
                      (owl-some ~(nth lis 3) ~(nth lis 4))
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8))
                      (owl-some ~(nth lis 9)~(nth lis 10)~(nth lis 11)))

            :else (println "Values of the ranges"))))

;; macro function to do the classes mapping  
(defmacro deftransporters-simple-diffusion-transmembrane [& lis]
  `(do ~@(map substance-transporting-across-membrane lis)))

;; List of the substances transport by simple diffusion across plasma membrane
(deftransporters-simple-diffusion-transmembrane
  ["Substance"	                   "GO:0022857"	ch/chemical_entity]
  ["Drug"	                   "GO:0015238"	ch/chemical_entity	                 has-application-role	ch/drug]
  ["Vitamin"	                   "GO:0090482"	ch/chemical_entity	                 has-biological-role	ch/vitamin]
  ["Cofactor"	                   "GO:0051184"	ch/chemical_entity	                 has-biological-role	ch/cofactor]
  ["Siderophore"	           "GO:0015343"	ch/chemical_entity	                 has-biological-role	ch/siderophore]
  ["Neurotransmitter"	           "GO:0005326"	ch/chemical_entity	                 has-biological-role	ch/neurotransmitter]
  ["Antibiotic"	           "GO:0042895"	ch/chemical_entity	                 has-biological-role	ch/antimicrobial_drug]
  ["Xenobiotic"	           "GO:0042910"	ch/chemical_entity	                 has-biological-role	ch/xenobiotic]
  ["Auxin"	                   "GO:0080161"	ch/chemical_entity	                 has-biological-role	ch/auxin]
  ["Coenzyme"	                   "GO:0051185"	ch/chemical_entity	                 has-biological-role	ch/coenzyme]
  ["Toxin"	                   "GO:0019534"	ch/toxin]
  ["CarbonDioxide"	           "GO:0035379"	ch/carbon_dioxide	                 has-application-role	ch/drug]
  ["Poly-beta-1_6-N-acetyl-D-glucosamine""GO:1901515"	ch/poly-beta-1_6-N-acetyl-D-glucosamine]
  ["Lipo-chitinOligosaccharide"    "GO:1901513"	ch/lipo-chitin_oligosaccharide]
  ["AcetateEster"	           "GO:1901375"	ch/acetate_ester]
  ["Glucose6-Phosphate"	   "GO:0015152"	ch/D-glucose_6-phosphate]
  ["Amine"	                   "GO:0005275"	ch/amine]
  ["Nucleobase"	           "GO:0015205"	ch/nucleobase]
  ["PyrimidineNucleobase"	   "GO:0005350"	ch/pyrimidine_nucleobase]
  ["Uracil"	                   "GO:0015210"	ch/uracil	                                      has-application-role	ch/drug]
  ["Cytosine"	                   "GO:0015209"	ch/cytosine]
  ["PurineNucleobase"	           "GO:0005345"	ch/purine_nucleobase]
  ["AdenineNucleobase"	           "GO:0015207"	ch/adenine]
  ["GuanineNucleobase"	           "GO:0015208"	ch/guanine]
  ["Xanthine"	                   "GO:0042907"	ch/xanthine]
  ["NucleobaseContainingCompound"  "GO:0015932"	ch/nucleobase-containing_molecular_entity]
  ["Nucleotide"	           "GO:0015215"	ch/nucleotide]
  ["FlavinAdenineDinucleotide"	   "GO:0015230"	ch/flavin_adenine_dinucleotide	                      has-biological-role	ch/cofactor]
  ["NicotinamideAdenineDinucleotide"	"GO:0051724"	ch/NAD	                                              has-biological-role	ch/coenzyme]
  ["Deoxynucleotide"	           "GO:0030233"	ch/deoxyribonucleotide]
  ["NicotinamideMononucleotide"    "GO:0015663"	ch/nicotinamide_mononucleotide	                      has-biological-role	ch/cofactor]
  ["PurineNucleotide"	           "GO:0015216"	ch/purine_nucleotide]
  ["GuanineNucleotide"	           "GO:0001409"	ch/guanyl_nucleotide]
  ["AdenineNucleotide"	           "GO:0000295"	ch/adenyl_nucleotide]
  ["3Phosphoadenosine-5Phosphosulfate""GO:0046964"	ch/_3'-phospho-5'-adenylyl_sulfate]
  ["AdenosineTriphosphate"	   "GO:0005347"	ch/ATP	                                              has-application-role	ch/drug]
  ["5AdenylylSulfate"	           "GO:1902557"	ch/_5'-adenylyl_sulfate]
  ["AdenosineMonophosphate"	   "GO:0080122"	ch/adenosine_5'-monophosphate]
  ["AdenosineDiphosphate"	   "GO:0015217"	ch/ADP]
  ["Adenosine_3-5-bisphosphate"    "GO:0071077"	ch/adenosine_3'_5'-bisphosphate]
  ["FattyAcyl-CoA"	           "GO:0015607"	ch/fatty_acyl-CoA	                              derived-from	ch/fatty_acid]
  ["Coenzyme-A"	           "GO:0015228"	ch/coenzyme_A	                                      has-biological-role	ch/coenzyme]
  ["Acetyl-CoA"	           "GO:0008521"	ch/acetyl-CoA	                                      has-biological-role	ch/coenzyme]
  ["PurineRibonucleotide"	   "GO:0005346"	ch/purine_ribonucleotide]
  ["NucleotideSulfate"	           "GO:0005340"	ch/nucleotide-sulfate]
  ["FlavineMononucleotide"	   "GO:0044610"	ch/FMN	                                              has-biological-role	ch/coenzyme]
  ["PyrimidineNucleotide"	   "GO:0015218"	ch/pyrimidine_nucleotide]
  ["NucleotideSugar"	           "GO:0005338"	ch/nucleotide-sugar]
  ["PyrimidineNucleotideSugar"	   "GO:0015165"	ch/pyrimidine_nucleotide-sugar]
  ["UDP-N-Acetylgalactosamine"	   "GO:0005463"	ch/UDP-N-acetylgalactosamine-5_6-ene]
  ["UDP-N-Acetylglucosamine"	   "GO:0005462"	ch/UDP-N-acetyl-alpha-D-glucosamine]
  ["UDP-Xylose"	           "GO:0005464"	ch/UDP-alpha-D-xylose]
  ["CMP-N-Acetylneuraminate"	   "GO:0005456"	ch/CMP-N-acetyl-beta-neuraminic_acid]
  ["UDP-Galactose"	           "GO:0005459"	ch/UDP-D-galactose]
  ["UDP-GlucuronicAcid"	   "GO:0005461"	ch/UDP-alpha-D-glucuronic_acid]
  ["UDP-Glucose"	           "GO:0005460"	ch/UDP-D-glucose]
  ["PurineNucleotideSugar"	   "GO:0036080"	ch/purine_nucleotide-sugar]
  ["GDP-Fucose"	           "GO:0005457"	ch/GDP-fucose]
  ["GDP-Mannose"	           "GO:0005458"	ch/GDP-mannose]
  ["NucleicAcid"	           "GO:0051032"	ch/nucleic_acid]
  ["DeoxyriboNucleicAcid"	   "GO:0051035"	ch/deoxyribonucleic_acid]
  ["RiboNucleicAcid"	           "GO:0051033"	ch/ribonucleic_acid]
  ["TransferRNA"	           "GO:0051034"	ch/transfer_RNA]
  ["Protein-DNA-Complex"	   "GO:0015219"	ch/macromolecule	                               has-part	ch/protein	ch/deoxyribonucleic_acid]
  ["Nucleoside"	           "GO:0005337"	ch/nucleoside]
  ["PyrimidineNucleoside"	   "GO:0015214"	ch/pyrimidine_nucleoside]
  ["Cytidine"	                   "GO:0015212"	ch/cytidine]
  ["Uridine"	                   "GO:0015213"	ch/uridine]
  ["PurineNucleoside"	           "GO:0015211"	ch/purine_nucleoside]
  ["Xanthosine"	           "GO:0015553"	ch/xanthosine]
  ["NicotinamideRiboside"	   "GO:0034257"	ch/N-ribosylnicotinamide]
  ["ChlorophyllCatabolite"	   "GO:0010290"	ch/primary_fluorescent_chlorophyll_catabolite]
  ["Azole"	                   "GO:1901474"	ch/azole]
  ["Fluconazole"	           "GO:0015244"	ch/fluconazole	                                       has-biological-role	ch/antimicrobial_drug	ch/xenobiotic]
  ["Acadesine"	                   "GO:1903089"	ch/acadesine	                                       has-application-role	ch/drug]
  ["ThiaminePyrophosphate"	   "GO:0090422"	ch/thiamine_1+__diphosphate_1-_                        has-biological-role	ch/vitamin]
  ["Sulfathiazole"	           "GO:0015546"	ch/sulfathiazole	                               has-biological-role	ch/antimicrobial_drug	ch/xenobiotic]
  ["Thiamine"	                   "GO:0015234"	ch/thiamine	                                       has-application-role	ch/drug	   has-biological-role	ch/vitamin]
  ["Aminotriazole"	           "GO:1901478"	ch/amitrole]
  ["SulfurMolecularEntity"	   "GO:1901682"	ch/sulfur_molecular_entity]
  ["S-adenosyl-L-methionine"	   "GO:0000095"	ch/S-adenosyl-L-methionine	                       has-application-role	ch/drug     has-biological-role	ch/coenzyme]
  ["Sulfite"	                   "GO:0000319"	ch/sulfite]
  ["Thiosulfate"	           "GO:0015117"	ch/thiosulfate]
  ["Sulfate"	                   "GO:0015116"	ch/sulfate]
  ["CarbohydrateDerivative"	   "GO:1901505"	ch/carbohydrate_derivative]
  ["N-acetylglucosamine"	   "GO:0015572"	ch/N-acetylglucosamine]
  ["Methylgalactoside"	           "GO:0015592"	ch/methyl_galactoside]
  ["Galactosamine"	           "GO:0019196"	ch/galactosamine]
  ["N-acetylgalactosamine"	   "GO:0015571"	ch/N-acetylgalactosamine]
  ["Glucoside"	                   "GO:0042947"	ch/glucoside]
  ["Alpha-Glucoside"	           "GO:0015151"	ch/alpha-glucoside]
  ["Beta-Glucoside"	           "GO:0015573"	ch/beta-glucoside]
  ["Arbutin"	                   "GO:0042951"	ch/hydroquinone_O-beta-D-glucopyranoside]
  ["AbscisicAcidGlucosylEster"	   "GO:1902417"	ch/_+_-abscisic_acid_D-glucopyranosyl_ester]
  ["FerricTriacetylfusarinineC"    "GO:0015621"	ch/N'_N''_N'''-triacetylfusarinine_C]
  ["Carbohydrate"	           "GO:0015144"	ch/carbohydrate]
  ["Oligosaccharide"	           "GO:0015157"	ch/oligosaccharide]
  ["Raffinose"	                   "GO:0015158"	ch/raffinose]
  ["Disaccharide"	           "GO:0015154"	ch/disaccharide]
  ["Trehalose"	                   "GO:0015574"	ch/trehalose]
  ["Sucrose"	                   "GO:0008515"	ch/sucrose]
  ["Melibios"	                   "GO:0015156"	ch/melibiose]
  ["Lactose"	                   "GO:0015155"	ch/lactose]
  ["Cellobiose"	           "GO:0019191"	ch/cellobiose]
  ["Maltose"	                   "GO:0005363"	ch/maltose]
  ["Oligogalacturonide"	   "GO:0033155"	ch/oligogalacturonide]
  ["Aldarate"	                   "GO:0042876"	ch/aldaric_acid_anion]
  ["D-glucarate"	           "GO:0042878"	ch/D-glucarate_2-_	                 hasEnantiomerism	D-Enantiomer	                 has-application-role	ch/drug]
  ["Galactarate"	           "GO:1902301"	ch/galactaric_acid_anion]
  ["Galactitol"	           "GO:0015577"	ch/galactitol]
  ["Macromolecule"	           "GO:0022884"	ch/biomacromolecule]
  ["TeichoicAcid"	           "GO:0015162"	ch/teichoic_acid]
  ["Lipopolysaccharide"	   "GO:0015221"	ch/lipopolysaccharide]
  ["Polysaccharide"	           "GO:0015159"	ch/polysaccharide]
  ["Beta-glucan"	           "GO:0015160"	ch/beta-D-glucan]
  ["CapsularPolysaccharide"	   "GO:0015161"	ch/polysaccharide]
  ["Arabinan"	                   "GO:0042901"	ch/arabinan]
  ["Maltodextrin"	           "GO:0042958"	ch/maltodextrin]
  ["Dextrin"	                   "GO:0042957"	ch/dextrin]
  ["Peptidoglycan"	           "GO:0015647"	ch/peptidoglycan]
  ["PeptidoglycanPeptide"	   "GO:0015640"	PeptidoglycanPeptide]
  ["Lipid-linkedPeptidoglycan"	   "GO:0015648"	ch/lipid-linked_peptidoglycan]
  ["Monosaccharide"	           "GO:0015145"	ch/monosaccharide]
  ["Hexose"	                   "GO:0015149"	ch/hexose]
  ["Rhamnose"	                   "GO:0015153"	ch/rhamnose]
  ["Mannose"	                   "GO:0015578"	ch/mannose]
  ["Glucose"	                   "GO:0005355"	ch/glucose]
  ["D-Glucose"	                   "GO:0055056"	ch/D-glucose	                         hasEnantiomerism	D-Enantiomer]
  ["Galactose"	                   "GO:0005354"	ch/galactose]
  ["Fructose"	                   "GO:0005353"	ch/fructose]
  ["Allose"	                   "GO:0015593"	ch/allose]
  ["Sorbose"	                   "GO:0019194"	ch/sorbose]
  ["Fucose"	                   "GO:0015150"	ch/fucose]
  ["Pentose"	                   "GO:0015146"	ch/pentose]
  ["D-ribose"	                   "GO:0015591"	ch/D-ribose	                         hasEnantiomerism	D-Enantiomer]
  ["D-xylose"	                   "GO:0015148"	ch/D-xylose	                         hasEnantiomerism	D-Enantiomer]
  ["Arabinose"	                   "GO:0042900"	ch/arabinose]
  ["L-arabinose"	           "GO:0015147"	ch/L-arabinose	                         hasEnantiomerism	L-Enantiomer]
  ["L-ascorbicAcid"	           "GO:0015229"	ch/L-ascorbic_acid	                 hasEnantiomerism	L-Enantiomer	                 has-biological-role	ch/vitamin	ch/coenzyme]
  ["UronicAcid"	           "GO:0015133"	ch/uronic_acid]
  ["Hexuronate"	           "GO:0015134"	ch/hexuronate]
  ["Glucuronate"	           "GO:0015135"	ch/glucuronate]
  ["D-Glucuronate"	           "GO:0042880"	ch/D-glucuronate	                 hasEnantiomerism	D-Enantiomer]
  ["Galacturonate"	           "GO:0015550"	ch/galacturonate]
  ["AminoAcidDerivative"	   "GO:0072349"	ch/amino_acid_derivative]
  ["FolicAcid"	                   "GO:0008517"	ch/folic_acid	                         has-application-role	ch/drug	                 has-biological-role	ch/vitamin]
  ["Creatine"	                   "GO:0005308"	ch/creatine	                         has-application-role	ch/drug	                 has-biological-role	ch/cofactor]
  ["S-methylmethionine"	   "GO:0000100"	ch/S-methyl-L-methionine]
  ["Carnitine"	                   "GO:0015226"	ch/carnitine]
  ["R-Carnitine"	           "GO:1901235"	ch/_R_-carnitine	                 has-application-role	ch/drug	                 has-biological-role	ch/vitamin]
  ["L-hydroxyproline"	           "GO:0034590"	ch/_4-hydroxy-L-proline	         hasEnantiomerism	L-Enantiomer]
  ["5-formyltetrahydrofolicAcid"   "GO:0015231"	ch/_5-formyltetrahydrofolic_acid	 has-biological-role	ch/cofactor]
  ["Carcinine"	                   "GO:1905131"	ch/carcinine]
  ["Glutathione"	           "GO:0034634"	ch/glutathione	                          has-biological-role	ch/cofactor]
  ["L-cystine"	                   "GO:0015184"	ch/L-cystine	                          hasEnantiomerism	L-Enantiomer]
  ["4-TrimethylammonioButanoate"   "GO:1901236"	ch/_4-_trimethylammonio_butanoate]
  ["AminoAcidBetaine"	           "GO:0015199"	ch/glycine_betaine]
  ["Amide"	                   "GO:0042887"	ch/amide]
  ["Fosmidomycin"	           "GO:0042898"	ch/fosmidomycin	                 has-biological-role	ch/antimicrobial_drug]
  ["Benomyl"	                   "GO:1901479"	ch/benomyl	                         has-biological-role	ch/antimicrobial_drug	ch/xenobiotic]
  ["Methotrexate"	           "GO:0015350"	ch/methotrexate	                 has-application-role	ch/drug]
  ["Dethiobiotin"	           "GO:1901604"	ch/dethiobiotin]
  ["Urea"	                   "GO:0015204"	ch/urea]
  ["Allantoate"	           "GO:0015124"	ch/allantoate]
  ["Peptide"	                   "GO:1904680"	ch/peptide]
  ["Protein"	                   "GO:0008320"	ch/protein]
  ["Bacteriocin"	           "GO:0022885"	ch/bacteriocin	                 has-application-role	ch/antimicrobial_drug]
  ["Colicin"	                   "GO:0042912"	ch/colicin	                 has-application-role	ch/antimicrobial_drug]
  ["Microcin"	                   "GO:0015638"	ch/microcin	                 has-biological-role	ch/antimicrobial_drug]
  ["Oligopeptide"	           "GO:0035673"	ch/oligopeptide]
  ["Tetrapeptide"	           "GO:1901584"	ch/tetrapeptide]
  ["Tripeptide"	           "GO:0042937"	ch/tripeptide]
  ["Dipeptide"	                   "GO:0071916"	ch/dipeptide]
  ["InorganicMolecularEntity"	   "GO:0015318"	ch/inorganic_molecular_entity]
  ["Water"	                   "GO:0005372"	ch/water]
  ["Arcidine"	                   "GO:0042911"	ch/acridine	                         has-biological-role	ch/xenobiotic]
  ["InorganicCation"	           "GO:0022890"	ch/inorganic_cation]
  ["TrivalentInorganicCation"	   "GO:0072510"	ch/trivalent_inorganic_cation]
  ["DivalentInorganicCation"	   "GO:0072509"	ch/divalent_inorganic_cation]
  ["FerrousIron"	           "GO:0015093"	ch/iron_2+_]
  ["ZincIon"	                   "GO:0005385"	ch/zinc_2+_]
  ["FerricIron"	           "GO:0015091"	ch/iron_3+_]
  ["MonovalentInorganicCation"	   "GO:0015077"	ch/monovalent_inorganic_cation]
  ["Proton"	                   "GO:0015078"	ch/proton]
  ["SodiumIon"	                   "GO:0015081"	ch/sodium_1+_]
  ["PotassiumIon"	           "GO:0015079"	ch/potassium_1+_]
  ["Alkane"	                   "GO:0015567"	ch/alkane]
  ["Cyanate"	                   "GO:0015110"	ch/cyanate]
  ["AminoAcid"	                   "GO:0015171"	ch/amino_acid]
  ["L-AminoAcid"	           "GO:0015179"	ch/L-alpha-amino_acid	                 hasEnantiomerism	L-Enantiomer]
  ["D-AminoAcid"	           "GO:0042943"	ch/D-alpha-amino_acid	                 hasEnantiomerism	D-Enantiomer]
  ["D-methionine"	           "GO:0048474"	ch/D-methionine	                 hasEnantiomerism	D-Enantiomer]
  ["D-aspartate"	           "GO:0140010"	ch/D-aspartate_2-_	                 hasEnantiomerism	D-Enantiomer]
  ["D-alanine"	                   "GO:0042944"	ch/D-alanine	                         hasEnantiomerism	D-Enantiomer	                 hasAcidity	Neutral]
  ["L-tyrosine"	           "GO:0005302"	ch/L-tyrosine	                         has-application-role	ch/drug	                 hasEnantiomerism	L-Enantiomer]
  ["L-alanine"	                   "GO:0015180"	ch/L-alanine	                         hasAcidity	Neutral	                         hasEnantiomerism	L-Enantiomer]
  ["L-serine"	                   "GO:0015194"	ch/L-serine	                         hasEnantiomerism	L-Enantiomer	                 hasAcidity	Neutral]
  ["Homoserine"	           "GO:0042970"	ch/homoserine	                         hasAcidity	Neutral]
  ["L-phenylalanine"	           "GO:0015192"	ch/L-phenylalanine	                 hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["L-leucine"	                   "GO:0015190"	ch/L-leucine	                         hasEnantiomerism	L-Enantiomer	                 hasAcidity	Neutral]
  ["L-diaminopimelate"	           "GO:0015626"	ch/LL-2_6-diaminopimelic_acid	         hasEnantiomerism	L-Enantiomer]
  ["L-ornithine"	           "GO:0000064"	ch/L-ornithine	                         hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["L-isoleucine"	           "GO:0015188"	ch/L-isoleucine	                 hasAcidity	Neutral	                         hasEnantiomerism	L-Enantiomer]
  ["AromaticAminoAcid"	           "GO:0015173"	ch/aromatic_amino_acid]
  ["BranchedChainAminoAcid"	   "GO:0015658"	ch/branched-chain_amino_acid]
  ["SulfurAminoAcid"	           "GO:0000099"	ch/sulfur-containing_amino_acid]
  ["Methionine"	           "GO:0043865"	ch/methionine]
  ["Cysteine"	                   "GO:0033229"	ch/cysteine	                          hasAcidity	Neutral]
  ["Bicarbonate"	           "GO:0015106"	ch/hydrogencarbonate]
  ["NeutralAminoAcid"	           "GO:0015175"	ch/amino_acid	                          hasAcidity	Neutral]
  ["Serine"	                   "GO:0022889"	ch/serine	                          hasAcidity	Neutral]
  ["Alanine"	                   "GO:0022858"	ch/alanine	                          hasAcidity	Neutral]
  ["L-glutamine"	           "GO:0015186"	ch/L-glutamine	                          hasAcidity	Neutral	       hasEnantiomerism	L-Enantiomer        has-application-role	ch/drug]
  ["BasicAminoAcid"	           "GO:0015174"	ch/amino_acid	                          hasAcidity	Alkaline]
  ["L-histidine"	           "GO:0005290"	ch/L-histidine	                          hasAcidity	Alkaline	       has-application-role	ch/drug]
  ["Arginine"	                   "GO:0015181"	ch/arginine	                          hasAcidity	Alkaline]
  ["AcidicAminoAcid"	           "GO:0015172"	ch/amino_acid	                          hasAcidity	Acidic]
  ["Alkanesulfonate"	           "GO:0042959"	ch/_1_1-diunsubstituted_alkanesulfonate   has-application-role	ch/xenobiotic]
  ["Ion"	                   "GO:0015075"	ch/ion]
  ["TriosePhosphate"	           "GO:0071917"	ch/glyceraldehyde_3-phosphate]
  ["Acriflavine"	           "GO:0015566"	ch/_3_6-diamino-10-methylacridinium_chloride	                 has-application-role	ch/drug          has-biological-role	ch/xenobiotic]
  ["Tetracycline"	           "GO:0008493"	ch/tetracycline	                  has-biological-role	ch/antimicrobial_drug]
  ["AluminumIon"	           "GO:0015083"	ch/aluminium_ion]
  ["Cation"	                   "GO:0008324"	ch/cation]
  ["OrganicCation"	           "GO:0015101"	ch/organic_cation]
  ["Cadaverine"	           "GO:0015490"	ch/cadaverine]
  ["Amiloride"	                   "GO:0015240"	ch/amiloride	                          has-application-role	ch/drug]
  ["QuaternaryAmmoniumCompound"    "GO:0015651"	ch/quaternary_nitrogen_compound]
  ["N-methylnicotinat"	           "GO:0090417"	ch/N-methylnicotinate]
  ["AcylCarnitine"	           "GO:0015227"	ch/O-acylcarnitine]
  ["OrganophosphateEster"	   "GO:0015605"	ch/organic_phosphate]
  ["Glycerol-3-phosphate"	   "GO:0015169"	ch/sn-glycerol_3-phosphate]
  ["AminoPhospholipid"	           "GO:0015247"	ch/aminophospholipid]
  ["HexosePhosphate"	           "GO:0015119"	ch/hexose_phosphate]
  ["Anion"	                   "GO:0008509"	ch/anion]
  ["OrganicAnion"	           "GO:0008514"	ch/organic_anion]
  ["Riboflavin"	           "GO:0032217"	ch/riboflavin	                          has-application-role	ch/drug	                 has-biological-role	ch/vitamin]
  ["DehydroascorbicAcid"	   "GO:0033300"	ch/L-dehydroascorbic_acid	          has-biological-role	ch/vitamin]
  ["InorganicAnion"	           "GO:0015103"	ch/inorganic_anion]
  ["Arsenite"	                   "GO:0015105"	ch/arsenite_3-_]
  ["Chromate"	                   "GO:0015109"	ch/chromate_2-_]
  ["MolybdateIon"	           "GO:0015098"	ch/molybdate]
  ["Chlorate"	                   "GO:0015107"	ch/chlorate]
  ["Antimonite"	           "GO:0015104"	ch/antimonite]
  ["Tungstate"	                   "GO:1901237"	ch/tungstate]
  ["Tellurite"	                   "GO:0015654"	ch/tellurite]
  ["Iodide"	                   "GO:0015111"	ch/iodide]
  ["Nitrate"	                   "GO:0015112"	ch/nitrate]
  ["Nitrite"	                   "GO:0015113"	ch/nitrite]
  ["InorganicDiphosphate"	   "GO:0030504"	ch/diphosphate_ion]
  ["PhosphateIon"	           "GO:0015114"	ch/phosphate_ion]
  ["Silicate"	                   "GO:0015115"	ch/silicate_ion]
  ["Fluoride"	                   "GO:1903425"	ch/fluoride]
  ["ChromiumIon"	           "GO:0070835"	ch/chromium_ion]
  ["LeadIon"	                   "GO:0015094"	ch/lead_ion]
  ["L-tryptophan"	           "GO:0015196"	ch/L-tryptophan	                 hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["Salt"	                   "GO:1901702"	ch/salt	                         has-part	ch/anion	ch/cation]
  ["Tartrate"	                   "GO:0015554"	ch/tartrate_salt	                 has-part	ch/anion	ch/cation]
  ["Urate"	                   "GO:0015143"	ch/urate_salt	                         has-part	ch/anion	ch/cation]
  ["OrganicHydroxyCompound"	   "GO:1901618"	ch/organic_hydroxy_compound]
  ["3-HydroxyphenylPropanoate"	   "GO:0015551"	ch/_3-hydroxyphenyl_propanoate]
  ["Polyol"	                   "GO:0015166"	ch/polyol]
  ["Mannitol"	                   "GO:0015575"	ch/mannitol]
  ["Propanediol"	           "GO:0015170"	ch/propanediol]
  ["Myo-inositol"	           "GO:0005365"	ch/myo-inositol]
  ["Glucosylglycerol"	           "GO:0051474"	ch/glucosylglycerol]
  ["Glucitol"	                   "GO:0015576"	ch/glucitol]
  ["Arabinitol"	           "GO:0015167"	ch/arabinitol]
  ["Glycerol"	                   "GO:0015168"	ch/glycerol]
  ["Chloramphenicol"	           "GO:0042896"	ch/chloramphenicol	                 has-biological-role	ch/antineoplastic_agent]
  ["Alchohol"	                   "GO:0015665"	ch/alcohol]
  ["Retinol"	                   "GO:0034632"	ch/retinol	                         has-biological-role	ch/vitamin]
  ["Salicin"	                   "GO:0042950"	ch/salicin	                         has-application-role	ch/drug]
  ["Cycloheximide"	           "GO:0015243"	ch/cycloheximide	                 has-biological-role	ch/antimicrobial_drug]
  ["AmmoniumIon"	           "GO:0008519"	ch/ammonium_ion_derivative]
  ["Ethanolamine"	           "GO:0034228"	ch/ethanolamine]
  ["Spermidine"	           "GO:0015606"	ch/spermidine]
  ["Sphingosine"	           "GO:0010175"	ch/sphingosine]
  ["Putrescine"	           "GO:0015489"	ch/putrescine]
  ["Acetylcholine"	           "GO:0005277"	ch/acetylcholine	                 has-application-role	ch/drug	                 has-biological-role	ch/neurotransmitter]
  ["Methylammonium"	           "GO:0015200"	ch/methylammonium]
  ["Choline"	                   "GO:0015220"	ch/choline	                         has-biological-role	ch/neurotransmitter]
  ["L-methionine"	           "GO:0015191"	ch/L-methionine	                 hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["Glycerophosphodiester"	   "GO:0001406"	ch/glycerol_1-phosphodiester]
  ["BetaAlanine"	           "GO:0001761"	ch/beta-alanine	                 hasAcidity	Neutral	has-biological-role	ch/neurotransmitter]
  ["NitricOxide"	           "GO:0030184"	ch/nitric_oxide	                 has-application-role	ch/drug	      has-biological-role	ch/neurotransmitter]
  ["GammaAminobutyricAcid"	   "GO:0015185"	ch/gamma-aminobutyric_acid	         has-biological-role	ch/neurotransmitter]
  ["OrganicAcid"	           "GO:0005342"	ch/organic_acid]
  ["Taurine"	                   "GO:0005368"	ch/taurine	                         has-biological-role	ch/xenobiotic]
  ["ArsenateIon"	           "GO:1901683"	ch/arsenate_ion]
  ["CarboxylicAcid"	           "GO:0046943"	ch/carboxylic_acid]
  ["Gibberellin"	           "GO:1905201"	ch/gibberellin]
  ["SialicAcid"	           "GO:0015136"	ch/sialic_acid]
  ["DicarboxylicAcid"	           "GO:0005310"	ch/dicarboxylic_acid]
  ["AlphaKetoglutarate"	   "GO:0015139"	ch/_2-oxoglutarate_2-_	                 has-biological-role	ch/cofactor]
  ["Bilirubin"	                   "GO:0015127"	ch/bilirubin_IXalpha]
  ["C4-dicarboxylate"	           "GO:0015556"	ch/C4-dicarboxylate]
  ["Malate"	                   "GO:0015140"	ch/malate_2-_]
  ["Fumarate"	                   "GO:0015138"	ch/fumarate_2-_]
  ["Succinate"	                   "GO:0015141"	ch/succinate_2-_	                 has-application-role	ch/drug]
  ["Oxaloacetate"	           "GO:0015131"	ch/oxaloacetate_2-_]
  ["IronChelate"	           "GO:0015603"	ch/iron_chelate]
  ["Ferrichrome"	           "GO:0042929"	ch/ferrichrome]
  ["IronNicotianamine"	           "GO:0051980"	ch/nicotianamine]
  ["FerricVibriobactin"            "GO:0019535"	ch/ferric-vibriobactin]
  ["Chrysobactin"	           "GO:0042933"	ch/chrysobactin	                 has-biological-role	ch/siderophore]
  ["Achromobactin"	           "GO:0042934"	ch/achromobactin	                 has-biological-role	ch/siderophore]
  ["Enterobactin"	           "GO:0042931"	ch/enterobactin	                 has-biological-role	ch/siderophore]
  ["FerricEnterobactin"	   "GO:0015620"	ch/ferrienterobactin]
  ["SiderophoreIronFerrioxamine"   "GO:0015344"	ch/ferrioxamine_B]
  ["FerricHydroxamate"	           "GO:0015622"	ch/iron_III__hydroxamate]
  ["Malonate_1-"	           "GO:1901239"	ch/malonate_1-_]
  ["Isopropylmalate"	           "GO:0034658"	ch/_2-isopropylmalate_2-_]
  ["Oxalate"	                   "GO:0019531"	ch/oxalate]
  ["TricarboxylicAcid"	           "GO:0015142"	ch/tricarboxylic_acid]
  ["Citrate"	                   "GO:0015137"	ch/citrate_3-_	                         has-biological-role	ch/antimicrobial_drug]
  ["Icosanoid"	                   "GO:0071714"	ch/icosanoid]
  ["Prostaglandin"	           "GO:0015132"	ch/prostaglandin]
  ["Arachidonate"	           "GO:1903962"	ch/arachidonate]
  ["Glucuronoside"	           "GO:0015164"	ch/glucosiduronic_acid]
  ["MonocarboxylicAcid"	   "GO:0008028"	ch/monocarboxylic_acid]
  ["Pyruvate"	                   "GO:0050833"	ch/pyruvate]
  ["Hydroxyectoine"	           "GO:0033287"	ch/_5-hydroxyectoine]
  ["Benzoate"	                   "GO:0042925"	ch/benzoate	                         has-biological-role	ch/antimicrobial_drug	ch/human_xenobiotic_metabolite]
  ["Aldonate"	                   "GO:0042879"	ch/aldonate]
  ["Phosphoglycerate"	           "GO:0015120"	ch/phosphoglycerate]
  ["D-Galactonate"	           "GO:0042881"	ch/D-galactonate	                 hasEnantiomerism	D-Enantiomer]
  ["L-idonate"	                   "GO:0015568"	ch/L-idonate	                         hasEnantiomerism	L-Enantiomer	derived-from	ch/L-idose]
  ["Glycerate"	                   "GO:1901974"	ch/glycerate]
  ["Gluconate"	                   "GO:0015128"	ch/gluconate	                         derived-from	ch/glucose]
  ["3-HydroxyphenylpropionicAcid"  "GO:0042926"	ch/_3-_3-hydroxyphenyl_propanoic_acid	 has-biological-role	ch/human_xenobiotic_metabolite]
  ["AbscisicAcid"	           "GO:0090440"	ch/abscisic_acids]
  ["Phosphoenolpyruvate"	   "GO:0089721"	ch/phosphoenolpyruvate]
  ["3-PhenylpropionicAcid"	   "GO:0042890"	ch/_3-phenylpropionic_acid	         has-biological-role	ch/antimicrobial_drug]
  ["NalidixicAcid"	           "GO:0015547"	ch/nalidixic_acid	                 has-biological-role	ch/antimicrobial_drug	ch/xenobiotic]
  ["GlycolicAcid"	           "GO:0043879"	ch/glycolic_acid	                 has-application-role	ch/drug]
  ["Acetate"	                   "GO:0015123"	ch/acetate	                         has-biological-role	ch/antimicrobial_drug]
  ["BileAcid"	                   "GO:0015125"	ch/bile_acid]
  ["Nicotine"	                   "GO:0090416"	ch/nicotine	                         has-application-role	ch/drug	                 has-biological-role	ch/vitamin]
  ["Lactate"	                   "GO:0015129"	ch/lactate]
  ["Biotin"	                   "GO:0015225"	ch/biotin	                          has-application-role	ch/drug        has-biological-role	ch/coenzyme	ch/B_vitamin]
  ["Biopterin"	                   "GO:0015224"	ch/biopterin	                         has-biological-role	ch/coenzyme]
  ["FattyAcid"	                   "GO:0015245"	ch/fatty_acid]
  ["R-3-hydroxybutyrate"	   "GO:0097253"	ch/_R_-3-hydroxybutyrate	         has-application-role	ch/drug]
  ["ShortChainFattyAcid"	   "GO:0015636"	ch/short-chain_fatty_acid]
  ["PropionicAcid"	           "GO:0015552"	ch/propionic_acid	                 has-biological-role	ch/antimicrobial_drug]
  ["LongChainFattyAcid"	   "GO:0005324"	ch/long-chain_fatty_acid]
  ["Oleate"	                   "GO:1901480"	ch/oleate]
  ["Formate"	                   "GO:0015499"	ch/formate	                         has-biological-role	ch/antimicrobial_drug]
  ["Ectoine"	                   "GO:0051471"	ch/ectoine]
  ["Shikimate"	                   "GO:0015530"	ch/shikimate]
  ["4-Hydroxyphenylacetate"	   "GO:1901241"	ch/_4-hydroxyphenylacetate]
  ["Mevalonate"	           "GO:0015130"	ch/mevalonate]
  ["Mannosylglycerate"	           "GO:0051477"	ch/D-mannosyl-D-glyceric_acid]
  ["Lactone"	                   "GO:0042971"	ch/lactone]
  ["OrganicPhosphonate"	   "GO:0015604"	ch/organic_phosphonate]
  ["Alkylphosphonate"	           "GO:0042917"	ch/alkylphosphonate]
  ["MetalIon"	                   "GO:0046873"	ch/metal_cation]
  ["MagnesiumIon"	           "GO:0015095"	ch/magnesium_cation]
  ["CalciumIon"	           "GO:0015085"	ch/calcium_ion]
  ["TransitionMetalIon"            "GO:0046915"	ch/transition_element_cation]
  ["VanadiumIon"	           "GO:0015100"	ch/vanadium_cation]
  ["IronIon"	                   "GO:0005381"	ch/iron_2+_]
  ["ManganeseIon"	           "GO:0005384"	ch/manganese_2+_]
  ["MolybdenumIon"	           "GO:0042888"	ch/molybdenum_cation]
  ["SilverIon"	                   "GO:0015080"	ch/silver_cation]
  ["CadmiumIon"	           "GO:0015086"	ch/cadmium_cation]
  ["NickelCation"	           "GO:0015099"	ch/nickel_cation]
  ["CobaltIon"	                   "GO:0015087"	ch/cobalt_cation]
  ["MercuryIon"	           "GO:0015097"	ch/mercury_cation]
  ["CopperIon"	                   "GO:0005375"	ch/copper_cation]
  ["CopperChelate"	           "GO:0051981"	CopperChelate]
  ["Copper-nicotianamine"          "GO:0051982"	Copper-nicotianamine]
  ["Polyamine"	                   "GO:0015203"	ch/polyamine]
  ["Spermine"	                   "GO:0000297"	ch/spermine	                 has-application-role	ch/drug]
  ["Chloride"	                   "GO:0015108"	ch/chloride]
  ["Bicozamycin"	           "GO:0015545"	ch/bicozamycin	                 has-biological-role	ch/bicozamycin]
  ["CCCP"	                   "GO:0015549"	ch/CCCP]
  ["Organomercurial"	           "GO:0015548"	ch/organomercury_compound]
  ["Heme"	                   "GO:0015232"	ch/heme	                 has-biological-role	ch/cofactor]
  ["Lactoferrin"	           "GO:0033570"	Lactoferrin]
  ["L-lysine"	                   "GO:0015189"	ch/L-lysine	                          hasAcidity	Alkaline	       hasEnantiomerism	L-Enantiomer	    has-application-role	ch/drug]
  ["L-proline"	                   "GO:0015193"	ch/L-proline	                          hasAcidity	Neutral	       hasEnantiomerism	L-Enantiomer	    has-application-role	ch/drug]
  ["Glycine"	                   "GO:0015187"	ch/glycine	                          hasAcidity	Neutral                hasEnantiomerism	L-Enantiomer	 has-application-role	ch/drug  has-biological-role	ch/neurotransmitter]
  ["L-glutamate"	           "GO:0005313"	ch/L-glutamate_2-_	                  hasAcidity	Acidic	               hasEnantiomerism	L-Enantiomer	 has-application-role	ch/drug   has-biological-role	ch/neurotransmitter]
  ["L-asparagine"	           "GO:0015182"	ch/L-asparagine	                  hasEnantiomerism  L-Enantiomer       hasAcidity	Neutral	      has-application-role	ch/drug]
  ["L-aspartate"	           "GO:0015183"	ch/L-aspartate_2-_	                  hasAcidity	Acidic                 hasEnantiomerism	L-Enantiomer	 has-biological-role	ch/neurotransmitter]
  ["VitaminB6"	                   "GO:0031924"	ch/vitamin_B6	                  has-application-role	ch/drug        has-biological-role	ch/vitamin]
  ["Pyridoxal"	                   "GO:0031925"	ch/pyridoxal	                  has-application-role	ch/drug        has-biological-role	ch/vitamin	ch/cofactor]
  ["PyridoxalPhosphate"	   "GO:0031926"	ch/pyridoxal_5'-phosphate	          has-application-role	ch/vitamin_B6  has-biological-role	ch/vitamin	ch/coenzyme]
  ["Pyridoxamine"	           "GO:0031927"	ch/pyridoxamine	                  has-application-role	ch/drug        has-biological-role	ch/vitamin]
  ["Pyridoxine"	           "GO:0031928"	ch/pyridoxine	                          has-application-role	ch/drug        has-biological-role	ch/vitamin	ch/cofactor]
  ["L-threonine"	           "GO:0015195"	ch/L-threonine	                          hasAcidity	Neutral	       hasEnantiomerism	L-Enantiomer	        has-application-role	ch/drug]
  ["D-serine"	                   "GO:0042945"	ch/D-serine	                  hasEnantiomerism	D-Enantiomer	                 hasAcidity	Neutral	                 has-application-role	ch/drug]
  ["L-arginine"	           "GO:0061459"	ch/L-arginine	                          hasAcidity	Alkaline	                         hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["L-valine"	                   "GO:0005304"	ch/L-valine	                  hasAcidity	Neutral	                         hasEnantiomerism	L-Enantiomer	                 has-application-role	ch/drug]
  ["R-PantothenicAcid"	           "GO:0015233"	ch/_R_-pantothenate	                 has-application-role	ch/drug	                 has-biological-role	ch/coenzyme	ch/vitamin]
  ["Polymyxin"                     "GO:0042897"         ch/polymyxin                      has-biological-role ch/antimicrobial_drug])

;; (deftransport ToTransportGlycolipid :annotation (goid"GO:0034202") :cargo ch/glycolipid)

;;High/Low affinity Transmembrane transporter activity
(defn substance-transporting-across-membrane-affinity [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "TransmembraneWith" (nth lis 2)))
     :annotation (goid ~(second lis))
     :annotation (identitasId ~(identitas ""))
     :across go/plasma_membrane
     :transports-with ~(nth lis 2) 
     :cargo
     ~(cond (= 4 (count lis)) (nth lis 3)
            (= 6 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5)))
            (= 7 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5) ~(nth lis 6)))
            (= 8 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5))
                      (owl-some ~(nth lis 6) ~(nth lis 7)))
            (= 9 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5))
                      (owl-some ~(nth lis 6) ~(nth lis 7) ~(nth lis 8)))
            (= 10 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5))
                      (owl-some ~(nth lis 6) ~(nth lis 7))
                      (owl-some ~(nth lis 8) ~(nth lis 9)))
            (= 11 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5))
                      (owl-some ~(nth lis 6) ~(nth lis 7))
                      (owl-some ~(nth lis 8) ~(nth lis 9) ~(nth lis 10)))
            (= 12 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 4) ~(nth lis 5))
                      (owl-some ~(nth lis 6) ~(nth lis 7))
                      (owl-some ~(nth lis 8) ~(nth lis 9))
                      (owl-some ~(nth lis 10)~(nth lis 11)))
            :else (println "Values of the ranges"))))


;; macro function to do the classes mapping 
(defmacro deftransporters-simple-diffusion-transmembrane-affinity [& liss]
  `(do ~@(map substance-transporting-across-membrane-affinity liss)))

;; List of the substances transport by simple diffusion across plasma membrane
(deftransporters-simple-diffusion-transmembrane-affinity
  ["Oligopeptide"   "GO:0015334"    HighAffinity   ch/oligopeptide]
  ["Tryptophan"     "GO:0022893"    LowAffinity    ch/tryptophan]
  ["NickelCation"   "GO:0044750"    HighAffinity   ch/nickel_cation]
  ["Phosphate"      "GO:0048249"    HighAffinity   ch/phosphate_ion]
  ["Fructose"       "GO:0061486"    HighAffinity   ch/fructose]
  ["Nitrate"        "GO:0080054"    LowAffinity    ch/nitrate]
  ["ZincIon"        "GO:0000006"    HighAffinity   ch/zinc_2+_]
  ["ZincIon"        "GO:0000007"    LowAffinity    ch/zinc_2+_]
  ["Phosphate"      "GO:0009673"    LowAffinity    ch/phosphate_ion]
  ["CopperIon"      "GO:0015089"    HighAffinity   ch/copper_2+_]
  ["FerricIronIon"  "GO:0015090"    LowAffinity    ch/iron_2+_]
  ["FerricIronIon"  "GO:0015092"    HighAffinity   ch/iron_3+_]
  ["Glucose"        "GO:0140108"    HighAffinity   ch/glucose]
  ["PotassiumIon"   "GO:0140107"    HighAffinity   ch/potassium_1+_]
  ["Arginine"       "GO:0005289"    HighAffinity   ch/arginine      hasAcidity Alkaline]
  ["BasicAminoAcid" "GO:0097625"    LowAffinity    ch/amino_acid    hasAcidity Alkaline]
  ["Lysine"         "GO:0005292"    HighAffinity   ch/lysine        hasAcidity Alkaline]
  ["BasicAminoAcid" "GO:0005287"    HighAffinity   ch/amino_acid    hasAcidity Alkaline]
  ["L-histidine"    "GO:0005291"    HighAffinity   ch/L-histidine   hasAcidity Alkaline   has-application-role ch/drug]
  ["L-arginine"     "GO:0097626"    LowAffinity    ch/L-arginine    has-application-role  ch/drug]
  ["GlutamateWith"  "GO:0005314"    HighAffinity   ch/glutamate_2-_ hasAcidity Acidic     hasEnantiomerism L-Enantiomer  has-application-role ch/drug has-biological-role ch/neurotransmitter]
  ["Glutamine"      "GO:0015330"    HighAffinity   ch/glutamine     hasAcidity Neutral    hasEnantiomerism L-Enantiomer  has-application-role ch/drug]
  ["L-ornithine"    "GO:0097627"    HighAffinity   ch/L-ornithine   hasEnantiomerism L-Enantiomer  has-application-role  ch/drug]
  ["L-tryptophan"   "GO:0005300"    HighAffinity   ch/L-tryptophan  hasEnantiomerism L-Enantiomer  has-application-role  ch/drug]
  ["L-tryptophan"   "GO:0022893"    LowAffinity    ch/L-tryptophan  hasEnantiomerism L-Enantiomer  has-application-role  ch/drug])


;;Influx/Efflux Transmembrane transporter activity
(defn substance-transporting-across-membrane-loca [lis]
  `(deftransport ~(symbol (str "ToTransport" (first lis) "Transmembrane"))
     :annotation (goid ~(second lis))
     :annotation (identitasId ~(identitas ""))
     :across go/plasma_membrane
     :from ~(nth lis 2)
     :to ~(nth lis 3)
     :cargo
     ~(cond (= 5 (count lis)) (nth lis 4)
            (= 7 (count lis))
            `(owl-and ~(nth lis 4)
                      (owl-some ~(nth lis 5) ~(nth lis 6)))
            (= 8 (count lis))
            `(owl-and ~(nth lis 4)
                      (owl-some ~(nth lis 5) ~(nth lis 6) ~(nth lis 7)))
            (= 9 (count lis))
            `(owl-and ~(nth lis 4)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8)))
            (= 10 (count lis))
            `(owl-and ~(nth lis 4)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8) ~(nth lis 9)))
            (= 11 (count lis))
            `(owl-and ~(nth lis 4)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8))
                      (owl-some ~(nth lis 9) ~(nth lis 10)))
            (= 12 (count lis))
            `(owl-and ~(nth lis 3)
                      (owl-some ~(nth lis 5) ~(nth lis 6))
                      (owl-some ~(nth lis 7) ~(nth lis 8))
                      (owl-some ~(nth lis 9) ~(nth lis 10) ~(nth lis 11)))
            :else (println "Values of the ranges"))))

;; macro function to do the classes mapping 
(defmacro deftransporters-simple-diffusion-transmembrane-location [& lis]
  `(do ~@(map substance-transporting-across-membrane-loca lis)))

;; List of the substances transport by simple diffusion across plasma membrane
(deftransporters-simple-diffusion-transmembrane-location
  ["AuxinEfflux"  "GO:0010329"  go/intracellular         go/extracellular_region ch/chemical_entity has-biological-role ch/auxin]
  ["AuxinInflux"  "GO:0010328"  go/extracellular_region  go/intracellular        ch/chemical_entity has-biological-role ch/auxin]
  ["ProtonInflux" "GO:0017077"  go/mitochondrial_intermembrane_space go/mitochondrial_matrix  ch/proton established-by go/electron_transport_chain during go/oxidative_phosphorylation]
  ["SubstanceEfflux" "GO:0015562"   go/intracellular    go/extracellular_region  ch/chemical_entity]
  ["ZincIonEfflux"   "GO:0022883"   go/intracellular    go/extracellular_region  ch/zinc_2+_]
  ["L-AminoAcidEfflux" "GO:0034639" go/intracellular    go/extracellular_region  ch/L-alpha-amino_acid  hasEnantiomerism L-Enantiomer]
  ["L-lysineEfflux" "GO:0015661"    go/intracellular    go/extracellular_region  ch/L-lysine hasAcidity Alkaline has-application-role ch/drug]
  ["SiliconEfflux"  "GO:0032523"    go/intracellular    go/extracellular_region  ch/silicon_4+_]
  ["CationEfflux"   "GO:0046583"    go/intracellular    go/extracellular_region  ch/cation]
  ["BorateEfflux"   "GO:0080139"    go/intracellular    go/extracellular_region  ch/borate  has-application-role ch/drug]
  ["NitriteEfflux"  "GO:0015514"    go/intracellular    go/extracellular_region  ch/nitrite]
  ["NitrateEfflux"  "GO:0010542"    go/intracellular    go/extracellular_region  ch/nitrate]
  ["L-threonineEfflux" "GO:0015565" go/intracellular    go/extracellular_region  ch/L-threonine hasAcidity Neutral hasEnantiomerism L-Enantiomer  has-application-role ch/drug] ;;threonine not subclass of L-threonine (see nizal_notes.org)
  ["CanalicularBileAcidInflux" "GO:0015126" Hepatocyte  go/intracellular_canaliculus  ch/bile_acid]
  ["FormateEfflux" "GO:0015660"     go/intracellular    go/extracellular_region  ch/formate  has-biological-role ch/antimicrobial_drug]
  ["PhospholipidScramblase"  "GO:0017128"  go/leaflet_of_membrane_bilayer go/leaflet_of_membrane_bilayer ch/phospholipid])



;; The following classes have been changed to carrier recently,
;; that is thay are not simple transport but facilitated diffusion)
;; carrier
(deftransport ToTransportPhosphatidicAcid
  :annotation (goid "GO:1990050")
  :cargo ch/phosphatidic_acid)

;; carrier
(deftransport ToTransportCeramide
  :annotation (goid "GO:0035620")
  :cargo ch/ceramide)

;; carrier
(deftransport ToTransportCeramide1-Phosphate
  :annotation (goid "GO:1902388")
  :cargo ch/ceramide_1-phosphate)

;;carrier
(deftransport ToTransportCholesterol
  :annotation (goid "GO:0017127")
  :cargo ch/cholesterol)


;; carrier
(deftransport ToTransportIntermembranePhosphatidylinositol
  :annotation (goid "GO:0120018")
  :cargo ch/phosphatidylinositol
  :from go/leaflet_of_membrane_bilayer
  :to go/leaflet_of_membrane_bilayer)

;; carrier
(deftransport ToTransportGlycolipid
  :annotation (goid "GO:0017089")
  :cargo ch/glycolipid)
