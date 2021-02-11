(ns hyper-go.transferase_activity
   (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny.polyglot :refer :all]
            [tawny-go.go :as go]
            [clojure.java.io :as io]
            [clojure-csv.core :as cs]))

(ontology-to-namespace hyper-go.core/HyperGo)


(defclass ToCatalyseTransferaseActivity-TransferringAcylGroups 
 :annotation (goid "GO:0016746") 
 :annotation (Def "Catalysis of the transfer of an acyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseProtein-CysteineS-MyristoyltransferaseActivity 
 :annotation (goid "GO:0019705") 
 :annotation (Def "Catalysis of the transfer of a myristoyl group to a sulfur atom on a cysteine residue of a protein molecule."))

(defclass ToCatalyseSulfotransferaseActivity 
 :annotation (goid "GO:0008146") 
 :annotation (Def "Catalysis of the transfer of a sulfate group from 3'-phosphoadenosine 5'-phosphosulfate to the hydroxyl group of an acceptor, producing the sulfated derivative and 3'-phosphoadenosine 5'-phosphate."))

(defclass ToCatalyseN-AcetyltransferaseActivity 
 :annotation (goid "GO:0008080") 
 :annotation (Def "Catalysis of the transfer of an acetyl group to a nitrogen atom on the acceptor molecule."))

(defclass ToCatalyseNedd8LigaseActivity 
 :annotation (goid "GO:0061663") 
 :annotation (Def "Catalysis of the transfer of NEDD8 to a substrate protein via the reaction X-NEDD8 + S --> X + S-NEDD8, where X is either an E2 or E3 enzyme, the X-NEDD8 linkage is a thioester bond, and the S-NEDD8 linkage is an isopeptide bond between the C-terminal amino acid of NEDD8 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseLipidKinaseActivity 
 :annotation (goid "GO:0001727") 
 :annotation (Def "Catalysis of the phosphorylation of a simple or complex lipid."))

(defclass ToCatalyseSpermidineCaffeoylCoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0080074") 
 :annotation (Def "Catalysis of the transfer of a caffeoyl group to a nitrogen atom on the spermidine molecule."))

(defclass ToCatalyseAlpha-_1-6_-FucosyltransferaseActivity 
 :annotation (goid "GO:0046921") 
 :annotation (Def "Catalysis of the transfer of an L-fucosyl group from GDP-beta-L-fucose to an acceptor molecule to form an alpha-(1->6) linkage."))

(defclass ToCatalyseXyloglucan6-XylosyltransferaseActivity 
 :annotation (goid "GO:0033843") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-xylosyl residue from UDP-D-xylose to a glucose residue in xyloglucan, forming an alpha-1,6-D-xylosyl-D-glucose linkage."))

(defclass ToCatalyseCarboxyl-O-MethyltransferaseActivity 
 :annotation (goid "GO:0010340") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the carboxyl group of an acceptor molecule to form a methyl ester."))

(defclass ToCatalyseGalactosylBeta-1-3N-AcetylgalactosamineBeta-1-3-GlucuronosyltransferaseActivity 
 :annotation (goid "GO:0046989") 
 :annotation (Def "Catalysis of the transfer, in a beta 1,3 linkage, of D-glucuronic acid (GlcUA) from UDP-GlcUA to the disaccharide galactosyl beta-1,3 N-acetylgalactosamine, a common component of glycoproteins and glycolipids."))

(defclass ToCatalysePupLigaseActivity 
 :annotation (goid "GO:0061664") 
 :annotation (Def "Catalysis of the transfer of Pup to a substrate protein via the reaction X-Pup + S --> X + S-Pup, where X is either an E2 or E3 enzyme, the X-Pup linkage is a thioester bond, and the S-Pup linkage is an isopeptide bond between the C-terminal amino acid of Pup and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseCoa-TransferaseActivity 
 :annotation (goid "GO:0008410") 
 :annotation (Def "Catalysis of the transfer of a coenzyme A (CoA) group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseDolichyl-PyrophosphateMan7Glcnac2Alpha-1-6-MannosyltransferaseActivity 
 :annotation (goid "GO:0052824") 
 :annotation (Def "Catalysis of the addition of mannose to dolichyl-pyrophosphate Man7GlcNAc2 (also written as Man7GlcNAc2-PP-Dol) in alpha-(1->6) linkage, producing Man8GlcNAc2-PP-Dol."))

(defclass ToCatalyseTransferaseActivity-TransferringAlkylOrAryl_OtherThanMethyl_Groups 
 :annotation (goid "GO:0016765") 
 :annotation (Def "Catalysis of the transfer of an alkyl or aryl (but not methyl) group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseProteinKinaseActivityInvolvedInRegulationOfProteinLocalizationToCellDivisionSiteInvolvedInCytokinesis 
 :annotation (goid "GO:1901916") 
 :annotation (Def  "Any protein kinase activity that is involved in regulation of protein localization to cell division site involved in cytokinesis. ")) 

(defclass ToCatalyseXylosyltransferaseActivity 
 :annotation (goid "GO:0042285") 
 :annotation (Def "Catalysis of the transfer of a xylosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseQuercetin3-O-GlucosyltransferaseActivity 
 :annotation (goid "GO:0080043") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group from UDP-glucose to the 3-hydroxy group of a quercetin molecule."))

(defclass ToCatalyseUfm1ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061657") 
 :annotation (Def  "Isoenergetic transfer of UFM1 from one protein to another via the reaction X-UFM1 + Y -> Y-UFM1 + X, where both the X-UFM1 and Y-UFM1 linkages are thioester bonds between the C-terminal amino acid of UFM1 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseAlpha-_1-2_-FucosyltransferaseActivity 
 :annotation (goid "GO:0031127") 
 :annotation (Def "Catalysis of the transfer of an L-fucosyl group from GDP-beta-L-fucose to an acceptor molecule to form an alpha-(1->2) linkage."))

(defclass ToCatalyseUfm1TransferaseActivity 
 :annotation (goid "GO:0071568") 
 :annotation (Def "Catalysis of the transfer of UFM1 from one protein to another via the reaction X-UFM1 + Y --> Y-UFM1 + X, where both X-UFM1 and Y-UFM1 are covalent linkages."))

(defclass ToCatalyse_S_-3-O-GeranylgeranylglycerylPhosphateSynthaseActivity 
 :annotation (goid "GO:0043889") 
 :annotation (Def "Catalysis of the alkylation of the primary hydroxyl group in (S)-glyceryl phosphate by geranylgeranyl diphosphate to form (S)-3-O-geranylgeranylglyceryl phosphate."))

(defclass ToCatalyseC-AcetyltransferaseActivity 
 :annotation (goid "GO:0016453") 
 :annotation (Def "Catalysis of the transfer of an acetyl group to a carbon atom on the acceptor molecule."))

(defclass ToCatalyseSinapoylSpermidineSinapoylCoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0080089") 
 :annotation (Def "Catalysis of the transfer of a sinapoyl group to a nitrogen atom on a sinapoyl spermidine molecule resulting in the formation of a disinapoyl spermidine derivative."))

(defclass ToCatalyseRnaTrimethylguanosineSynthaseActivity 
 :annotation (goid "GO:0071164") 
 :annotation (Def "Catalysis of two successive methyl transfer reactions from AdoMet to the N-2 atom of guanosine, thereby converting 7-methylguanosine in an RNA cap to 2,2,7 trimethylguanosine. "))

(defclass ToCatalyseHigh-Mannose-OligosaccharideBeta-1-4-N-AcetylglucosaminyltransferaseActivity 
 :annotation (goid "GO:0033827") 
 :annotation (Def "Catalysis of the transfer of an N-acetyl-D-glucosamine residue from UDP-N-acetyl-D-glucosamine to the 4-position of a mannose linked alpha-1,6 to the core mannose of high-mannose oligosaccharides produced by Dictyostelium discoideum."))

(defclass ToCatalyseButanoyltransferaseActivity 
 :annotation (goid "GO:0034326") 
 :annotation (Def "Catalysis of the transfer of a butanoyl (CH3-[CH2]2-CO-) group to an acceptor molecule."))

(defclass ToCatalyseNf-Kappab-InducingKinaseActivity 
 :annotation (goid "GO:0004704") 
 :annotation (Def "Catalysis of the phosphorylation of the alpha or beta subunit of the inhibitor of kappaB kinase complex (IKK)."))

(defclass ToCatalyseQuercetin7-O-GlucosyltransferaseActivity 
 :annotation (goid "GO:0080044") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group from UDP-glucose to the 7-hydroxy group of a quercetin molecule."))

(defclass ToCatalyseUrm1ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061658") 
 :annotation (Def  "Isoenergetic transfer of URM1 from one protein to another via the reaction X-URM1 + Y -> Y-URM1 + X, where both the X-URM1 and Y-URM1 linkages are thioester bonds between the C-terminal amino acid of URM1 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseMolybdopterinSynthaseActivity 
 :annotation (goid "GO:0030366") 
 :annotation (Def "Catalysis of the conversion of precursor Z to molybdopterin, the final step in molybdopterin biosynthesis."))

(defclass ToCatalyseHistoneKinaseActivity_H3-Y41Specific_ 
 :annotation (goid "GO:0035401") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the tyrosine-41 residue of histone H3."))

(defclass ToCatalyseTricaffeoylSpermidineS-Adenosyl-L-MethionineO-MethyltransferaseActivity 
 :annotation (goid "GO:0080078") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the oxygen atom of a tricaffeoyl spermidine molecule."))

(defclass ToCatalyseTransferaseActivity-TransferringAmino-AcylGroups 
 :annotation (goid "GO:0016755") 
 :annotation (Def "Catalysis of the transfer of an amino-acyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseUbiquitin-LikeProteinConjugatingEnzymeActivity 
 :annotation (goid "GO:0061650") 
 :annotation (Def  "Isoenergetic transfer of a ubiquitin-like protein (ULP) from one protein to another via the reaction X-SCP + Y -> Y-SCP + X, where both the X-SCP and Y-SCP linkages are thioester bonds between the C-terminal amino acid of SCP and a sulfhydryl side group of a cysteine residue. "))

(defclass ToCatalyseProtein-ArginineOmega-NAsymmetricMethyltransferaseActivity 
 :annotation (goid "GO:0035242") 
 :annotation (Def "Catalysis of the addition of a second methyl group to methylated peptidyl-arginine. Methylation is on the same terminal nitrogen (omega nitrogen) residue that was previously methylated, resulting in asymmetrical peptidyl-N(omega),N(omega)-dimethylated arginine residues.|Note that type I protein arginine N-methyltransferase enzymes possess 'protein-arginine omega-N monomethyltransferase activity 
 GO:0035241' and 'protein-arginine omega-N asymmetric methyltransferase activity 
 GO:0035242'."))

(defclass ToCatalyseCdp-AlcoholPhosphotransferaseActivity 
 :annotation (goid "GO:0008414") 
 :annotation (Def "Catalysis of the transfer of a CDP-alcohol group from one compound to another."))

(defclass ToCatalyseUbiquitin-ProteinTransferaseActivity 
 :annotation (goid "GO:0004842") 
 :annotation (Def "Catalysis of the transfer of ubiquitin from one protein to another via the reaction X-Ub + Y --> Y-Ub + X, where both X-Ub and Y-Ub are covalent linkages."))

(defclass ToCatalyseSuccinyltransferaseActivity 
 :annotation (goid "GO:0016748") 
 :annotation (Def "Catalysis of the transfer of a succinyl (3-carboxypropanoyl) group to an acceptor molecule."))

(defclass ToCatalyseTrna_Uracil_MethyltransferaseActivity 
 :annotation (goid "GO:0016300") 
 :annotation (Def "Catalysis of the transfer of a methyl group from a donor to a uracil residue in a tRNA molecule.|Note that the methyl donor is usually S-adenosyl-L-methionine, but there is at least one exception (see GO:0030698)."))

(defclass ToCatalyseHistoneKinaseActivity_H4-S1Specific_ 
 :annotation (goid "GO:0044023") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-1 residue of the N-terminal tail of histone H4. "))

(defclass ToCatalyseSapKinaseActivity 
 :annotation (goid "GO:0016909") 
 :annotation (Def "Catalysis of the phosphorylation of proteins. A family of protein kinases that perform a crucial step in relaying signals from the plasma membrane to the nucleus. Strongly activated by stress signals such as heat or osmotic shock, DNA-damaging agents, inhibitors of protein synthesis and pro-inflammatory cytokines. "))

(defclass ToCatalyseN-SuccinyltransferaseActivity 
 :annotation (goid "GO:0016749") 
 :annotation (Def "Catalysis of the transfer of a succinyl group to a nitrogen atom on the acceptor molecule."))

(defclass ToCatalyseS-Adenosylmethionine-DependentMethyltransferaseActivity 
 :annotation (goid "GO:0008757") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to a substrate. "))

(defclass ToCatalyseQuinoneCofactorMethyltransferaseActivity 
 :annotation (goid "GO:0030580") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosylmethionine during the synthesis of quinone cofactors such as ubiquinone (coenzyme Q), menaquinone (vitamin K2), plastoquinone and phylloquinone (vitamin K1)."))

(defclass ToCatalyseAlpha-_1-3_-FucosyltransferaseActivity 
 :annotation (goid "GO:0046920") 
 :annotation (Def "Catalysis of the transfer of an L-fucosyl group from GDP-beta-L-fucose to an acceptor molecule to form an alpha-(1->3) linkage."))

(defclass ToCatalyseO-LinoleoyltransferaseActivity 
 :annotation (goid "GO:0032576") 
 :annotation (Def "Catalysis of the transfer of a linoleoyl ((9Z,12Z)-octadeca-9,12-dienoyl) group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseOximinotransaminaseActivity 
 :annotation (goid "GO:0016770") 
 :annotation (Def "Catalysis of the reversible transfer of an oxime group to an acceptor."))

(defclass ToCatalyseTrnaA64-2'-O-RibosylphosphateTransferaseActivity 
 :annotation (goid "GO:0043399") 
 :annotation (Def "Catalysis of the transfer of a phosphoribosyl group from 5'-phosphoribosyl-1'-pyrophosphate to position 64 of initiator tRNA."))

(defclass ToCatalyseKynurenineAminotransferaseActivity 
 :annotation (goid "GO:0036137") 
 :annotation (Def "Catalysis of the transfer of an amino group from kynurenine to an acceptor, usually a 2-oxo acid. "))

(defclass ToCatalysePhosphatidylcholine:CardiolipinO-LinoleoyltransferaseActivity 
 :annotation (goid "GO:0032577") 
 :annotation (Def "Catalysis of the transfer of a linoleoyl ((9Z,12Z)-octadeca-9,12-dienoyl) group from phosphatidylcholine to an oxygen atom on a cardiolipin molecule."))

(defclass ToCatalyseMannose-EthanolaminePhosphotransferaseActivity 
 :annotation (goid "GO:0051377") 
 :annotation (Def "Catalysis of the transfer of ethanolamine phosphate to a mannose residue in the GPI lipid precursor. "))

(defclass ToCatalyseAcetylglucosaminyltransferaseActivity 
 :annotation (goid "GO:0008375") 
 :annotation (Def "Catalysis of the transfer of an N-acetylglucosaminyl residue from UDP-N-acetyl-glucosamine to a sugar."))

(defclass ToCatalyseN-MethyltransferaseActivity 
 :annotation (goid "GO:0008170") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the nitrogen atom of an acceptor molecule."))

(defclass ToCatalyseMalonyltransferaseActivity 
 :annotation (goid "GO:0016420") 
 :annotation (Def "Catalysis of the transfer of a malonyl (HOOC-CH2-CO-) group to an acceptor molecule."))

(defclass ToCatalyseHistoneKinaseActivity_H2A-S121Specific_ 
 :annotation (goid "GO:0072371") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-121 residue of the N-terminal tail of histone H2A."))

(defclass ToCatalyseHydroxycinnamoyltransferaseActivity 
 :annotation (goid "GO:0050734") 
 :annotation (Def "Catalysis of the transfer of a hydroxycinnamoyl group to an acceptor molecule."))

(defclass ToCatalyseN-AcetyllactosamineBeta-1-3-GlucuronosyltransferaseActivity 
 :annotation (goid "GO:0046987") 
 :annotation (Def "Catalysis of the transfer, in a beta 1,3 linkage, of D-glucuronic acid (GlcUA) from UDP-D-glucuronic acid to N-acetyllactosamine (galactosyl beta-1,4-N-acetylglucosamine)."))

(defclass ToCatalyseRrna_Pseudouridine_MethyltransferaseActivity 
 :annotation (goid "GO:0070037") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to a pseudouridine residue in an rRNA molecule."))

(defclass ToCatalyseTelluriteMethyltransferaseActivity 
 :annotation (goid "GO:0035797") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to tellurite [TeO3(2-)]. Methylated derivatives of tellurite include Te(CH3)2 (dimethyltelluride) and Te2(CH3)2 (dimethylditelluride)."))

(defclass ToCatalyseMethyltransferaseActivity 
 :annotation (goid "GO:0008168") 
 :annotation (Def "Catalysis of the transfer of a methyl group to an acceptor molecule."))

(defclass ToCatalyseAsioloorosomucoidBeta-1-3-GlucuronosyltransferaseActivity 
 :annotation (goid "GO:0046988") 
 :annotation (Def "Catalysis of the transfer, in a beta 1,3 linkage, of D-glucuronic acid (GlcUA) from UDP-GlcUA to asioloorosomucoid."))

(defclass ToCatalyseDna-MethyltransferaseActivity 
 :annotation (goid "GO:0009008") 
 :annotation (Def "Catalysis of the transfer of a methyl group to a DNA molecule."))

(defclass ToCatalyseS-MalonyltransferaseActivity 
 :annotation (goid "GO:0016419") 
 :annotation (Def "Catalysis of the transfer of a malonyl group to a sulfur atom on the acceptor molecule."))

(defclass ToCatalyseRrna_Adenine-N6-N6-_-DimethyltransferaseActivity 
 :annotation (goid "GO:0000179") 
 :annotation (Def "Catalysis of the dimethylation two adjacent A residues in the loop closing the 3'-terminal stem of the 18S rRNA, using S-adenosyl-L-methionine as a methyl donor."))

(defclass ToCatalysePhosphatidylglycerol-ProlipoproteinDiacylglycerylTransferaseActivity 
 :annotation (goid "GO:0008961") 
 :annotation (Def "Catalysis of the transfer of the diacylglyceryl group from phosphatidylglycerol to the sulfhydryl group of the prospective N-terminal cysteine residue in an unmodified prolipoprotein."))

(defclass ToCatalyseHistoneKinaseActivity_H3-T3Specific_ 
 :annotation (goid "GO:0072354") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the threonine-3 residue of the N-terminal tail of histone H3."))

(defclass ToCatalyseAsparticAcidMethylthiotransferaseActivity 
 :annotation (goid "GO:0035599") 
 :annotation (Def "Catalysis of the methylthiolation (-SCH3 addition) of the beta-carbon of peptidyl-aspartic acid to form peptidyl-L-beta-methylthioaspartic acid."))

(defclass ToCatalyse_S_-2-3-Di-O-GeranylgeranylglycerylPhosphateSynthaseActivity 
 :annotation (goid "GO:0043888") 
 :annotation (Def "Catalysis of the transfer of a geranylgeranyl group from geranylgeranyl diphosphate to (S)-3-O-geranylgeranylglyceryl phosphate to form (S)-2,3-di-O-geranylgeranylglyceryl phosphate.|This function is involved in archaeal lipid synthesis."))

(defclass ToCatalyseNucleobase-ContainingCompoundKinaseActivity 
 :annotation (goid "GO:0019205") 
 :annotation (Def "Catalysis of the transfer of a phosphate group, usually from ATP or GTP, to a nucleobase, nucleoside, nucleotide or polynucleotide substrate."))

(defclass ToCatalyseProteinGeranylgeranyltransferaseActivity 
 :annotation (goid "GO:0004661") 
 :annotation (Def "Catalysis of the covalent addition of a geranylgeranyl (20-carbon isoprenoid) group via thioether linkages to a cysteine residue at or near the C terminus of a protein."))

(defclass ToCatalyseFructosamine-3-KinaseActivity 
 :annotation (goid "GO:0030387") 
 :annotation (Def "Catalysis of the phosphorylation of fructosamine to form fructosamine-3-phosphate."))

(defclass ToCatalyseHydroxyprolineO-GalactosyltransferaseActivity 
 :annotation (goid "GO:1990714") 
 :annotation (Def "Catalysis of the transfer of galactose from UDP-galactose to hydroxyproline residues present in the peptide backbone."))

(defclass ToCatalyseXyloglucan4-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033826") 
 :annotation (Def "Catalysis of the transfer of a beta-D-glucosyl residue from UDP-glucose on to a glucose residue in xyloglucan, forming a beta-1,4-D-glucosyl-D-glucose linkage."))

(defclass ToCatalyseTransferaseActivity-TransferringSelenium-ContainingGroups 
 :annotation (goid "GO:0016785") 
 :annotation (Def "Catalysis of the transfer of a selenium-containing group from one compound (donor) to another (acceptor)."))

(defclass ToCatalysePalmitoleoyltransferaseActivity 
 :annotation (goid "GO:1990698") 
 :annotation (Def "Catalysis of the transfer of a palmitoleyl group, a 16-carbon monounsaturated fatty acid (C16:1), to an acceptor molecule."))

(defclass ToCatalyseTransferaseActivity 
 :annotation (goid "GO:0016740") 
 :annotation (Def "Catalysis of the transfer of a group, e.g. a methyl group, glycosyl group, acyl group, phosphorus-containing, or other groups, from one compound (generally regarded as the donor) to another compound (generally regarded as the acceptor). Transferase is the systematic name for any enzyme of EC class 2."))

(defclass ToCatalysePhosphotransferaseActivity-PhosphateGroupAsAcceptor 
 :annotation (goid "GO:0016776") 
 :annotation (Def "Catalysis of the transfer of a phosphorus-containing group from one compound (donor) to a phosphate group (acceptor)."))

(defclass ToCatalyseTransferaseActivity-TransferringOne-CarbonGroups 
 :annotation (goid "GO:0016741") 
 :annotation (Def "Catalysis of the transfer of a one-carbon group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseTelomeraseRnaReverseTranscriptaseActivity 
 :annotation (goid "GO:0003721") 
 :annotation (Def "Catalysis of the extension of the 3' end of a DNA strand by one deoxynucleotide at a time. Cannot initiate a chain de novo
 uses the RNA subunit of the telomerase enzyme complex as its template."))

(defclass ToCatalyseProtein-LysineN-MethyltransferaseActivity 
 :annotation (goid "GO:0016279") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the epsilon-amino group of a lysine residue in a protein substrate."))

(defclass ToCatalyseUrm1LigaseActivity 
 :annotation (goid "GO:0061667") 
 :annotation (Def "Catalysis of the transfer of URM1 to a substrate protein via the reaction X-URM1 + S --> X + S-URM1, where X is either an E2 or E3 enzyme, the X-URM1 linkage is a thioester bond, and the S-URM1 linkage is an isopeptide bond between the C-terminal amino acid of URM1 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseUbiquitinConjugatingEnzymeActivity 
 :annotation (goid "GO:0061631") 
 :annotation (Def  "Isoenergetic transfer of ubiquitin from one protein to another via the reaction X-ubiquitin + Y -> Y-ubiquitin + X, where both the X-ubiquitin and Y-ubiquitin linkages are thioester bonds between the C-terminal glycine of ubiquitin and a sulfhydryl side group of a cysteine residue. "))

(defclass ToCatalyseRnaMethyltransferaseActivity 
 :annotation (goid "GO:0008173") 
 :annotation (Def "Catalysis of the transfer of a methyl group from a donor to a nucleoside residue in an RNA molecule.|Note that the methyl donor is usually S-adenosyl-L-methionine, but there is at least one exception (see GO:0030698)."))

(defclass ToCatalyseL-TyrosineAminotransferaseActivity 
 :annotation (goid "GO:0070547") 
 :annotation (Def "Catalysis of the transfer of an amino group from L-tyrosine to an acceptor, usually a 2-oxo acid."))

(defclass ToCatalysePhosphotransferaseActivity-NitrogenousGroupAsAcceptor 
 :annotation (goid "GO:0016775") 
 :annotation (Def "Catalysis of the transfer of a phosphorus-containing group from one compound (donor) to a nitrogenous group (acceptor)."))

(defclass ToCatalyseCyclomaltodextrinGlucanotransferaseActivity 
 :annotation (goid "GO:0043895") 
 :annotation (Def "Catalysis of the cyclization of part of a 1,4-alpha-D-glucan chain by formation of a 1,4-alpha-D-glucosidic bond."))

(defclass ToCatalyse5-10-Methylenetetrahydrofolate-DependentMethyltransferaseActivity 
 :annotation (goid "GO:0042083") 
 :annotation (Def "Catalysis of the transfer of a methyl group to an acceptor molecule
 dependent on the presence of 5,10-methylenetetrahydrofolate."))

(defclass ToCatalyseBeta-1-3-GalactosyltransferaseActivity 
 :annotation (goid "GO:0048531") 
 :annotation (Def "Catalysis of the transfer of a galactose residue from a donor molecule to an oligosaccharide, forming a beta-1,3-linkage."))

(defclass ToCatalyseMrnaMethyltransferaseActivity 
 :annotation (goid "GO:0008174") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to a nucleoside residue in an mRNA molecule."))

(defclass ToCatalyseArabinosyltransferaseActivity 
 :annotation (goid "GO:0052636") 
 :annotation (Def "Catalysis of the transfer of an arabinosyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseJunKinaseKinaseKinaseKinaseActivity 
 :annotation (goid "GO:0042656") 
 :annotation (Def "Catalysis of the phosphorylation and activation of JUN kinase kinase kinases (JNKKKs)."))

(defclass ToCatalyseTransferaseActivity-TransferringNitrogenousGroups 
 :annotation (goid "GO:0016769") 
 :annotation (Def "Catalysis of the transfer of a nitrogenous group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseGlucuronoxylanGlucuronosyltransferaseActivity 
 :annotation (goid "GO:0080116") 
 :annotation (Def "Catalysis of the transfer of glucuronate to the xylan backbone of glucuronoxylan molecule."))

(defclass ToCatalyseN-TerminalProteinN-MethyltransferaseActivity 
 :annotation (goid "GO:0071885") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine (AdoMet) to the alpha-amino group of the N-terminal amino or imino acid residue of a protein substrate. For example, yeast Tae1p and mammalian family member METTL11A preferentially modify the N-terminal residue of substrates with the N-terminal sequence X-Pro-Lys, where X can be Pro, Ala, or Ser."))

(defclass ToCatalyseAcylglycerolO-AcyltransferaseActivity 
 :annotation (goid "GO:0016411") 
 :annotation (Def "Catalysis of the transfer of an acyl group to an oxygen atom on the acylglycerol molecule."))

(defclass ToCatalyse5-Methyltetrahydrofolate-DependentMethyltransferaseActivity 
 :annotation (goid "GO:0042084") 
 :annotation (Def "Catalysis of the transfer of a methyl group to an acceptor molecule
 dependent on the presence of 5-methyltetrahydrofolate."))

(defclass ToCatalyseIsg15ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061653") 
 :annotation (Def  "Isoenergetic transfer of ISG15 from one protein to another via the reaction X-ISG15 + Y -> Y-ISG15 + X, where both the X-ISG15 and Y-ISG15 linkages are thioester bonds between the C-terminal amino acid of ISG15 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalysePyruvyltransferaseActivity 
 :annotation (goid "GO:0046919") 
 :annotation (Def "Catalysis of the transfer of a pyruvyl (oxopropanoyl) group from one compound to another."))

(defclass ToCatalyse4-Alpha-GlucanotransferaseActivity 
 :annotation (goid "GO:0004134") 
 :annotation (Def "Catalysis of the transfer of a segment of a (1->4)-alpha-D-glucan to a new 4-position in an acceptor, which may be glucose or (1->4)-alpha-D-glucan."))

(defclass ToCatalyseN-PalmitoyltransferaseActivity 
 :annotation (goid "GO:0019105") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl group to a nitrogen atom on the acceptor molecule."))

(defclass ToCatalyseUdp-Glucose:GlycoproteinGlucosyltransferaseActivity 
 :annotation (goid "GO:0003980") 
 :annotation (Def "Catalysis of the addition of UDP-glucose on to asparagine-linked (N-linked) oligosaccharides of the form Man7-9GlcNAc2 on incorrectly folded glycoproteins."))

(defclass ToCatalyseS-AcetyltransferaseActivity 
 :annotation (goid "GO:0016418") 
 :annotation (Def "Catalysis of the transfer of an acetyl group to a sulfur atom on the acceptor molecule."))

(defclass ToCatalysePupTransferaseActivity 
 :annotation (goid "GO:0072496") 
 :annotation (Def "Catalysis of the transfer of Pup from one protein to another via the reaction X-Pup + Y --> Y-Pup + X, where both X-Pup and Y-Pup are covalent linkages."))

(defclass ToCatalyseMapKinaseKinaseActivity 
 :annotation (goid "GO:0004708") 
 :annotation (Def "Catalysis of the concomitant phosphorylation of threonine (T) and tyrosine (Y) residues in a Thr-Glu-Tyr (TEY) thiolester sequence in a MAP kinase (MAPK) substrate. "))

(defclass ToCatalyseBeta-1-4-MannosyltransferaseActivity 
 :annotation (goid "GO:0019187") 
 :annotation (Def "Catalysis of the transfer of a mannose residue to an oligosaccharide, forming a beta-(1->4) linkage."))

(defclass ToCatalyseProteinC-TerminalCarboxylO-MethyltransferaseActivity 
 :annotation (goid "GO:0003880") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the oxygen atom of a carboxyl group at the C-terminal of a protein."))

(defclass ToCatalyseDolichyl-Phosphate-Mannose-GlycolipidAlpha-MannosyltransferaseActivity 
 :annotation (goid "GO:0004584") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-mannosyl residue from dolichyl-phosphate D-mannose into membrane lipid-linked oligosaccharide. "))

(defclass ToCatalyseN-AcyltransferaseActivity 
 :annotation (goid "GO:0016410") 
 :annotation (Def "Catalysis of the transfer of an acyl group to a nitrogen atom on the acceptor molecule."))

(defclass ToCatalyseQuercetin4'-O-GlucosyltransferaseActivity 
 :annotation (goid "GO:0080046") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group from UDP-glucose to the 4'-hydroxy group of a quercetin molecule."))

(defclass ToCatalyseC-AcyltransferaseActivity 
 :annotation (goid "GO:0016408") 
 :annotation (Def "Catalysis of the transfer of an acyl group to a carbon atom on the acceptor molecule."))

(defclass ToCatalyseProteinXylosyltransferaseActivity 
 :annotation (goid "GO:0030158") 
 :annotation (Def "Catalysis of the transfer of a beta-D-xylosyl residue from UDP-D-xylose to the serine hydroxyl group of an acceptor protein substrate. "))

(defclass ToCatalysePrenyltransferaseActivity 
 :annotation (goid "GO:0004659") 
 :annotation (Def "Catalysis of the transfer of a prenyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseO-SinapoyltransferaseActivity 
 :annotation (goid "GO:0016753") 
 :annotation (Def "Catalysis of the transfer of a sinapoyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseUfm1LigaseActivity 
 :annotation (goid "GO:0061666") 
 :annotation (Def "Catalysis of the transfer of UFM1 to a substrate protein via the reaction X-UFM1 + S --> X + S-UFM1, where X is either an E2 or E3 enzyme, the X-UFM1 linkage is a thioester bond, and the S-UFM1 linkage is an isopeptide bond between the C-terminal amino acid of UFM1 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseL-PhenylalanineAminotransferaseActivity 
 :annotation (goid "GO:0070546") 
 :annotation (Def "Catalysis of the transfer of an amino group from L-phenylalanine to an acceptor, usually a 2-oxo acid."))

(defclass ToCatalyseHistoneTyrosineKinaseActivity 
 :annotation (goid "GO:0035400") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to a tyrosine residue of a histone. Histones are any of a group of water-soluble proteins found in association with the DNA of eukaroytic  chromosomes."))

(defclass ToCatalyseUrm1TransferaseActivity 
 :annotation (goid "GO:0042294") 
 :annotation (Def "Catalysis of the transfer of URM1 from one protein to another via the reaction X-URM1 + Y --> Y-URM1 + X, where both X-URM1 and Y-URM1 are covalent linkages."))

(defclass ToCatalyse5-10-Methylenetetrahydrofolate-DependentTrna_M5U54_MethyltransferaseActivity 
 :annotation (goid "GO:0030698") 
 :annotation (Def "Catalysis of the transfer of a methyl group from 5,10-methylenetetrahydrofolate to the C5 atom of the uridine residue at position 54 in a tRNA molecule. This occurs in most Gram-positive bacteria and some Gram-negative bacteria."))

(defclass ToCatalysePhosphotransferaseActivity-CarboxylGroupAsAcceptor 
 :annotation (goid "GO:0016774") 
 :annotation (Def "Catalysis of the transfer of a phosphorus-containing group from one compound (donor) to a carboxyl group (acceptor)."))

(defclass ToCatalysePhosphoserine:HomoserinePhosphotransferaseActivity 
 :annotation (goid "GO:0043899") 
 :annotation (Def "Catalysis of the transfer of a phosphoryl group from phosphoserine to homoserine to form phosphohomoserine."))

(defclass ToCatalyseO-HydroxycinnamoyltransferaseActivity 
 :annotation (goid "GO:0050737") 
 :annotation (Def "Catalysis of the transfer of a hydroxycinnamoyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalysePurineDeoxyribosyltransferaseActivity 
 :annotation (goid "GO:0044102") 
 :annotation (Def "Catalysis of deoxyribose exchange between purine deoxyribonucleoside as a donor and purine base as an acceptor. "))

(defclass ToCatalyseGalactoside6-L-FucosyltransferaseActivity 
 :annotation (goid "GO:0046702") 
 :annotation (Def "Catalysis of the transfer of an L-fucosyl group from GDP-beta-L-fucose to a galactoside acceptor molecule, usually an N-glycan, to form an alpha(1,6)-fucosylated galactoside."))

(defclass ToCatalyseL-TryptophanAminotransferaseActivity 
 :annotation (goid "GO:0070529") 
 :annotation (Def "Catalysis of the transfer of an amino group from L-tryptophan to an acceptor, usually a 2-oxo acid."))

(defclass ToCatalyseFructosyltransferaseActivity 
 :annotation (goid "GO:0050738") 
 :annotation (Def "Catalysis of the transfer of a fructosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseFat10ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061652") 
 :annotation (Def  "Isoenergetic transfer of FAT10 from one protein to another via the reaction X-FAT10 + Y -> Y-FAT10 + X, where both the X-FAT10 and Y-FAT10 linkages are thioester bonds between the C-terminal amino acid of FAT10 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseUdp-GlucosyltransferaseActivity 
 :annotation (goid "GO:0035251") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group from UDP-glucose to an acceptor molecule."))

(defclass ToCatalyseDehydrodolichylDiphosphateSynthaseActivity 
 :annotation (goid "GO:0045547") 
 :annotation (Def "Catalysis of the condensation of isopentenyl diphosphate and farnesyl diphosphate in the cis-configuration to form dehydrodolichyl diphosphate."))

(defclass ToCatalyseAcetyl-CoaSynthetaseAcetyltransferaseActivity 
 :annotation (goid "GO:0043894") 
 :annotation (Def "Catalysis of the acetylation of residue Lys609 of the enzyme acetyl-CoA synthetase, using acetyl-CoA as substrate. "))

(defclass ToCatalyseTransferaseActivity-TransferringHexosylGroups 
 :annotation (goid "GO:0016758") 
 :annotation (Def "Catalysis of the transfer of a hexosyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseAlcoholO-AcyltransferaseActivity 
 :annotation (goid "GO:0034318") 
 :annotation (Def "Catalysis of the transfer of an acyl group to an oxygen atom on an alcohol acceptor molecule. "))

(defclass ToCatalysePeptidyl-ArginineC-MethyltransferaseActivity 
 :annotation (goid "GO:0035244") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the carbon atom of an arginine residue in a protein."))

(defclass ToCatalyseSpermidine:CoumaroylCoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0080073") 
 :annotation (Def "Catalysis of the transfer of a coumaroyl group to a nitrogen atom on the spermidine molecule."))

(defclass ToCatalysePhosphotransferaseActivity-PairedAcceptors 
 :annotation (goid "GO:0016781") 
 :annotation (Def "Catalysis of the transfer of two phosphate groups from a donor, such as ATP, to two different acceptors."))

(defclass ToCatalyseHomogentisatePrenyltransferaseActivity 
 :annotation (goid "GO:0010354") 
 :annotation (Def "Catalysis of the transfer of a prenyl group from one compound (donor) to homogentisic acid."))

(defclass ToCatalyseNedd8TransferaseActivity 
 :annotation (goid "GO:0019788") 
 :annotation (Def "Catalysis of the transfer of NEDD8 from one protein to another via the reaction X-NEDD8 + Y --> Y-NEDD8 + X, where both X-NEDD8 and Y-NEDD8 are covalent linkages. "))

(defclass ToCatalyseAtg12ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061651") 
 :annotation (Def  "Isoenergetic transfer of Atg12 from one protein to another via the reaction X-Atg12 + Y -> Y-Atg12 + X, where both the X-Atg12 and Y-Atg12 linkages are thioester bonds between the C-terminal amino acid of Atg12 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseGlycolipidMannosyltransferaseActivity 
 :annotation (goid "GO:0004376") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-mannosyl residue from GDP-mannose into lipid-linked oligosaccharide, forming an alpha-D-mannosyl-D-mannose linkage."))

(defclass ToCatalyseTrnaGuanylyltransferaseActivity 
 :annotation (goid "GO:0008193") 
 :annotation (Def "Catalysis of the posttranscriptional addition of a guanyl residue to the 5' end of a tRNA molecule
 observed for His tRNAs."))

(defclass ToCatalyseGalactosyltransferaseActivity 
 :annotation (goid "GO:0008378") 
 :annotation (Def "Catalysis of the transfer of a galactosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseCytidylyltransferaseActivity 
 :annotation (goid "GO:0070567") 
 :annotation (Def "Catalysis of the transfer of a cytidylyl group to an acceptor."))

(defclass ToCatalyseO-Fucosylpeptide3-Beta-N-AcetylglucosaminyltransferaseActivity 
 :annotation (goid "GO:0033829") 
 :annotation (Def "Catalysis of the transfer of a beta-D-GlcNAc residue from UDP-D-GlcNAc to the fucose residue of a fucosylated protein acceptor."))

(defclass ToCatalyseMannosylphosphateTransferaseActivity 
 :annotation (goid "GO:0000031") 
 :annotation (Def "Catalysis of the transfer of a mannosylphosphate group from one compound to another."))

(defclass ToCatalyseUdp-GlycosyltransferaseActivity 
 :annotation (goid "GO:0008194") 
 :annotation (Def "Catalysis of the transfer of a glycosyl group from a UDP-sugar to a small hydrophobic molecule."))

(defclass ToCatalyseCarboxyl-OrCarbamoyltransferaseActivity 
 :annotation (goid "GO:0016743") 
 :annotation (Def "Catalysis of the transfer of a carboxyl- or carbamoyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseSulfateAdenylyltransferaseActivity 
 :annotation (goid "GO:0004779") 
 :annotation (Def "Catalysis of the transfer of an adenylyl group from an adenosine nucleotide (ATP or ADP) to sulfate, forming adenylylsulfate."))

(defclass ToCatalyseTransferaseActivity-TransferringAlkylthioGroups 
 :annotation (goid "GO:0050497") 
 :annotation (Def "Catalysis of the transfer of an alkylthio group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseHistoneSerineKinaseActivity 
 :annotation (goid "GO:0035174") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to a serine residue of a histone. Histones are any of a group of water-soluble proteins found in association with the DNA of eukaroytic  chromosomes."))

(defclass ToCatalyseHnk-1SulfotransferaseActivity 
 :annotation (goid "GO:0016232") 
 :annotation (Def "Catalysis of the synthesis of the HKK-1 carbohydrate epitope
 adds a sulfate group to a precursor, GlcA-beta-(1->3)-Gal-beta-(1->4)-GlcNAc-beta-(1->R), forming sulfo-3GlcA-beta-(1->3)-Gal-beta-(1->4)-GlcNAc-beta-(1->R)."))

(defclass ToCatalyseHistoneKinaseActivity_H3-S10Specific_ 
 :annotation (goid "GO:0035175") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-10 residue of the N-terminal tail of histone H3."))

(defclass ToCatalyseTrichothecene3-O-AcetyltransferaseActivity 
 :annotation (goid "GO:0045462") 
 :annotation (Def "Catalysis of the 3-O-acetylation of a trichothecene. Trichothecenes are sesquiterpene epoxide mycotoxins that act as potent inhibitors of eukaryotic protein synthesis."))

(defclass ToCatalyseTransferaseActivity-TransferringAldehydeOrKetonicGroups 
 :annotation (goid "GO:0016744") 
 :annotation (Def "Catalysis of the transfer of an aldehyde or ketonic group from one compound (donor) to another (acceptor)."))

(defclass ToCatalysePeptidyl-LysineN6-MyristoyltransferaseActivity 
 :annotation (goid "GO:0018030") 
 :annotation (Def "Catalysis of the transfer of a myristoyl group to the N6 nitrogen atom on a lysine residue of a peptide or protein molecule."))

(defclass ToCatalysePeptidyl-CysteineS-NitrosylaseActivity 
 :annotation (goid "GO:0035605") 
 :annotation (Def "Catalysis of the transfer of a nitric oxide (NO) group to a sulphur atom within a cysteine residue of a protein. "))

(defclass ToCatalyseLipidAPhosphateMethyltransferaseActivity 
 :annotation (goid "GO:0043839") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosylmethionine (SAM) to the 1-phosphate group of lipid A."))

(defclass ToCatalyseFucosyltransferaseActivity 
 :annotation (goid "GO:0008417") 
 :annotation (Def "Catalysis of the transfer of a fucosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalysePeptidyl-LysineN6-PalmitoyltransferaseActivity 
 :annotation (goid "GO:0018031") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl group to the N6 nitrogen atom on a lysine residue of a peptide or protein molecule."))

(defclass ToCatalyseAmidinotransferaseActivity 
 :annotation (goid "GO:0015067") 
 :annotation (Def "Catalysis of the reversible transfer of an amidino group to an acceptor."))

(defclass ToCatalyseJunKinaseKinaseActivity 
 :annotation (goid "GO:0008545") 
 :annotation (Def "Catalysis of the phosphorylation of tyrosine and threonine residues in a c-Jun NH2-terminal kinase (JNK), a member of a subgroup of mitogen-activated protein kinases (MAPKs), which signal in response to cytokines and exposure to environmental stress. JUN kinase kinase (JNKK) is a dual-specificity protein kinase kinase and requires activation by a serine/threonine kinase JUN kinase kinase kinase."))

(defclass ToCatalyseNucleotidyltransferaseActivity 
 :annotation (goid "GO:0016779") 
 :annotation (Def "Catalysis of the transfer of a nucleotidyl group to a reactant."))

(defclass ToCatalyseProteinAdp-RibosylaseActivity 
 :annotation (goid "GO:1990404") 
 :annotation (Def  "The transfer, from NAD, of ADP-ribose to a protein amino acid residue."))

(defclass ToCatalyseAcetyltransferaseActivity 
 :annotation (goid "GO:0016407") 
 :annotation (Def "Catalysis of the transfer of an acetyl group to an acceptor molecule."))

(defclass ToCatalyse5-Methyl-5-6-7-8-Tetrahydromethanopterin-DependentMethyltransferaseActivity 
 :annotation (goid "GO:0042086") 
 :annotation (Def "Catalysis of the transfer of a methyl group to an acceptor molecule, dependent on the presence of 5-methyl-5,6,7,8-tetrahydromethanopterin."))

(defclass ToCatalyseSumoConjugatingEnzymeActivity 
 :annotation (goid "GO:0061656") 
 :annotation (Def  "Isoenergetic transfer of SUMO from one protein to another via the reaction X-SUMO + Y -> Y-SUMO + X, where both the X-SUMO and Y-SUMO linkages are thioester bonds between the C-terminal amino acid of SUMO and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseFormimidoyltransferaseActivity 
 :annotation (goid "GO:0030407") 
 :annotation (Def "Catalysis of the transfer of a formimino group from 5-formimidoyltetrahydrofolate to an acceptor molecule such as an amino acid."))

(defclass ToCatalyseBeta-1-4-MannosylglycolipidBeta-1-3-N-AcetylglucosaminyltransferaseActivity 
 :annotation (goid "GO:0046981") 
 :annotation (Def "Catalysis of the transfer of N-acetylglucosamine (GlcNAc) in a beta-1,3 linkage to the mannose(beta-1,4)Glc disaccharide core of glycolipids."))

(defclass ToCatalyseAlpha-1-2-GalactosyltransferaseActivity 
 :annotation (goid "GO:0031278") 
 :annotation (Def "Catalysis of the transfer of a galactose residue from a donor molecule, such as GDP-galactose or UDP-galactose, to an oligosaccharide, forming an alpha-1,2-linkage."))

(defclass ToCatalyseO-MalonyltransferaseActivity 
 :annotation (goid "GO:0050736") 
 :annotation (Def "Catalysis of the transfer of a malonyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseUbiquitin-LikeProteinTransferaseActivity 
 :annotation (goid "GO:0019787") 
 :annotation (Def "Catalysis of the transfer of a ubiquitin-like from one protein to another via the reaction X-ULP + Y --> Y-ULP + X, where both X-ULP and Y-ULP are covalent linkages. ULP represents a ubiquitin-like protein."))

(defclass ToCatalyseAdenylyltransferaseActivity 
 :annotation (goid "GO:0070566") 
 :annotation (Def "Catalysis of the transfer of an adenylyl group to an acceptor."))

(defclass ToCatalyseS-MethyltransferaseActivity 
 :annotation (goid "GO:0008172") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the sulfur atom of an acceptor molecule."))

(defclass ToCatalyseMannose-PhosphateGuanylyltransferaseActivity 
 :annotation (goid "GO:0008905") 
 :annotation (Def "Catalysis of the transfer of a phosphate group from GTP or GDP to a mannose molecule."))

(defclass ToCatalyseLipoyltransferaseActivity 
 :annotation (goid "GO:0017118") 
 :annotation (Def "Catalysis of the transfer of the lipoyl group from lipoyl-AMP to the lysine residue of lipoate-dependent enzyme."))

(defclass ToCatalyseO-OctanoyltransferaseActivity 
 :annotation (goid "GO:0016414") 
 :annotation (Def "Catalysis of the transfer of an octanoyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseAtg8LigaseActivity 
 :annotation (goid "GO:0019776") 
 :annotation (Def "Catalysis of the covalent attachment of the ubiquitin-like protein Atg8 to substrate molecules
 phosphatidylethanolamine is a known substrate."))

(defclass ToCatalyseDnaAlpha-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033820") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-glucosyl residue from UDP-glucose to a hydroxymethylcytosine residue in DNA. "))

(defclass ToCatalyseLysophosphatidicAcidAcyltransferaseActivity 
 :annotation (goid "GO:0042171") 
 :annotation (Def "Catalysis of the transfer of acyl groups from an acyl-CoA to lysophosphatidic acid to form phosphatidic acid."))

(defclass ToCatalyseUdp-GalactosyltransferaseActivity 
 :annotation (goid "GO:0035250") 
 :annotation (Def "Catalysis of the transfer of a galactose group from UDP-galactose to an acceptor molecule."))

(defclass ToCatalyseHistoneKinaseActivity_H3-S28Specific_ 
 :annotation (goid "GO:0044022") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-28 residue of the N-terminal tail of histone H3. "))

(defclass ToCatalyseCarbohydrateKinaseActivity 
 :annotation (goid "GO:0019200") 
 :annotation (Def "Catalysis of the transfer of a phosphate group, usually from ATP, to a carbohydrate substrate molecule."))

(defclass ToCatalyseAtg12TransferaseActivity 
 :annotation (goid "GO:0019777") 
 :annotation (Def "Catalysis of the transfer of ATG12 from one protein to another via the reaction X-ATG12 + Y --> Y-ATG12 + X, where both X-ATG12 and Y-ATG12 are covalent linkages."))

(defclass ToCatalysePhosphofructokinaseActivity 
 :annotation (goid "GO:0008443") 
 :annotation (Def "Catalysis of the transfer of a phosphate group, usually from ATP, to a phosphofructose substrate molecule."))

(defclass ToCatalyseSpermidine:SinapoylCoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0080072") 
 :annotation (Def "Catalysis of the transfer of a sinapoyl group to a nitrogen atom on the spermidine molecule."))

(defclass ToCatalysePhosphotransferaseActivity-ForOtherSubstitutedPhosphateGroups 
 :annotation (goid "GO:0016780") 
 :annotation (Def "Catalysis of the transfer of a substituted phosphate group, other than diphosphate or nucleotidyl residues, from one compound (donor) to a another (acceptor)."))

(defclass ToCatalyseDnaBeta-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033821") 
 :annotation (Def "Catalysis of the transfer of a beta-D-glucosyl residue from UDP-glucose to a hydroxymethylcytosine residue in DNA. "))

(defclass ToCatalyseTransferaseActivity-TransferringGlycosylGroups 
 :annotation (goid "GO:0016757") 
 :annotation (Def "Catalysis of the transfer of a glycosyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseProtein-ArginineOmega-NSymmetricMethyltransferaseActivity 
 :annotation (goid "GO:0035243") 
 :annotation (Def "Catalysis of the addition of a second methyl group to methylated peptidyl-arginine. Methylation is on the terminal nitrogen (omega nitrogen) residue that is not already methylated, resulting in symmetrical peptidyl-N(omega),N'(omega)-dimethyled arginine residues.|Note that type II protein arginine N-methyltransferase enzymes possess 'protein-arginine omega-N monomethyltransferase activity 
 GO:0035241' and 'protein-arginine omega-N symmetric methyltransferase activity 
 GO:0035243'."))

(defclass ToCatalyseRrnaMethyltransferaseActivity 
 :annotation (goid "GO:0008649") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to a nucleoside residue in an rRNA molecule."))

(defclass ToCatalyseN-AcylHomoserineLactoneSynthaseActivity 
 :annotation (goid "GO:0061579") 
 :annotation (Def "Catalysis the reaction: acyl-[acyl-carrier-protein] + S-adenosyl-L-methionine -> [acyl-carrier- protein] + S-methyl-5'-thioadenosine + N-acyl-L-homoserine lactone."))

(defclass ToCatalyseMannosyltransferaseActivity 
 :annotation (goid "GO:0000030") 
 :annotation (Def "Catalysis of the transfer of a mannosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseBeta-1-4-N-AcetylgalactosaminyltransferaseActivity 
 :annotation (goid "GO:0033207") 
 :annotation (Def "Catalysis of the transfer of an N-acetylgalactosaminyl residue from UDP-N-acetyl-galactosamine to an acceptor molecule, forming a beta-1,4 linkage."))

(defclass ToCatalyseDiphosphotransferaseActivity 
 :annotation (goid "GO:0016778") 
 :annotation (Def "Catalysis of the transfer of a diphosphate group from one compound (donor) to a another (acceptor)."))

(defclass ToCatalyseSe-MethyltransferaseActivity 
 :annotation (goid "GO:0051995") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the selenium atom of an acceptor molecule."))

(defclass ToCatalyseCarnitineO-AcyltransferaseActivity 
 :annotation (goid "GO:0016406") 
 :annotation (Def "Catalysis of the transfer of an acyl group to an oxygen atom on the carnitine molecule."))

(defclass ToCatalyseHydroxymethyl--Formyl-AndRelatedTransferaseActivity 
 :annotation (goid "GO:0016742") 
 :annotation (Def "Catalysis of the transfer of a hydroxymethyl- or formyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseHistoneKinaseActivity 
 :annotation (goid "GO:0035173") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to a histone. Histones are any of a group of water-soluble proteins found in association with the DNA of eukaroytic chromosomes."))

(defclass ToCatalyseIsg15LigaseActivity 
 :annotation (goid "GO:0061662") 
 :annotation (Def "Catalysis of the transfer of a ISG15 to a substrate protein via the reaction X-ISG15 + S --> X + S-ISG15, where X is either an E2 or E3 enzyme, the X-ISG15 linkage is a thioester bond, and the S-ISG15 linkage is an isopeptide bond between the C-terminal amino acid of ISG15 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseHistoneKinaseActivity_H3-T11Specific_ 
 :annotation (goid "GO:0035402") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the threonine-11 residue of the N-terminal tail of histone H3. "))

(defclass ToCatalyseDeoxycytidylTransferaseActivity 
 :annotation (goid "GO:0017125") 
 :annotation (Def "Catalysis of the insertion of a dCMP residue opposite a template abasic site in DNA."))

(defclass ToCatalyseSialyltransferaseActivity 
 :annotation (goid "GO:0008373") 
 :annotation (Def "Catalysis of the transfer of sialic acid to an acceptor molecule, typically the terminal portions of the sialylated glycolipids (gangliosides) or to the N- or O-linked sugar chains of glycoproteins."))

(defclass ToCatalysePhosphatidylinositolAlpha-MannosyltransferaseActivity 
 :annotation (goid "GO:0043750") 
 :annotation (Def "Catalysis of the transfer of one or more alpha-D-mannose residues from GDP-mannose to positions 2,6 and others in 1-phosphatidyl-myo-inositol. "))

(defclass ToCatalyseAlpha-1-4-MannosyltransferaseActivity 
 :annotation (goid "GO:0051751") 
 :annotation (Def "Catalysis of the transfer of a mannose residue to an oligosaccharide, forming an alpha-(1->4) linkage."))

(defclass ToCatalyseDolichylPyrophosphateGlc1Man9Glcnac2Alpha-1-3-GlucosyltransferaseActivity 
 :annotation (goid "GO:0042283") 
 :annotation (Def "Catalysis of the addition of the second glucose residue to the lipid-linked oligosaccharide precursor for N-linked glycosylation
 the transfer of glucose from dolichyl phosphate glucose (Dol-P-Glc) on to the lipid-linked oligosaccharide Glc(1)Man(9)GlcNAc(2)-PP-Dol."))

(defclass ToCatalyseHistoneKinaseActivity_H3-T6Specific_ 
 :annotation (goid "GO:0035403") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the threonine-6 residue of the N-terminal tail of histone H3. "))

(defclass ToCatalyseO-AcyltransferaseActivity 
 :annotation (goid "GO:0008374") 
 :annotation (Def "Catalysis of the transfer of an acyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseSeryl-Selenocysteinyl-TrnaKinaseActivity 
 :annotation (goid "GO:0098620") 
 :annotation (Def "Catalysis of the reaction: Ser-tRNA(Sec) + ATP ---> Sep-tRNA(Sec) + ADP"))

(defclass ToCatalyseTransferaseActivity-TransferringPentosylGroups 
 :annotation (goid "GO:0016763") 
 :annotation (Def "Catalysis of the transfer of a pentosyl group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseO-ButanoyltransferaseActivity 
 :annotation (goid "GO:0034323") 
 :annotation (Def "Catalysis of the transfer of a butyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseOligosaccharide4-Alpha-D-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033825") 
 :annotation (Def "Catalysis of the transfer of the non-reducing terminal alpha-D-glucose residue from a 1,4-alpha-D-glucan to the 4-position of an alpha-D-glucan, thus bringing about the hydrolysis of oligosaccharides."))

(defclass ToCatalyseSerineO-AcyltransferaseActivity 
 :annotation (goid "GO:0016412") 
 :annotation (Def "Catalysis of the transfer of an acyl group to an oxygen atom on the serine molecule."))

(defclass ToCatalyse5-Methyltetrahydropteroyltri-L-Glutamate-DependentMethyltransferaseActivity 
 :annotation (goid "GO:0042085") 
 :annotation (Def "Catalysis of the transfer of a methyl group to an acceptor molecule
 dependent on the presence of 5-methyltetrahydropteroyltri-L-glutamate."))

(defclass ToCatalyseO-HexanoyltransferaseActivity 
 :annotation (goid "GO:0034324") 
 :annotation (Def "Catalysis of the transfer of a hexyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseMapKinaseKinaseKinaseActivity 
 :annotation (goid "GO:0004709") 
 :annotation (Def "Catalysis of the phosphorylation and activation of a MAP kinase kinase
 each MAP kinase kinase can be phosphorylated by any of several MAP kinase kinase kinases."))

(defclass ToCatalyseN-MalonyltransferaseActivity 
 :annotation (goid "GO:0050735") 
 :annotation (Def "Catalysis of the transfer of a malonyl group to a nitrogen atom on the acceptor molecule."))

(defclass ToCatalyseAlpha-1-4-N-AcetylgalactosaminyltransferaseActivity 
 :annotation (goid "GO:0035248") 
 :annotation (Def "Catalysis of the transfer of an N-acetylgalactosaminyl residue from UDP-N-acetyl-galactosamine to an acceptor molecule, forming an alpha-1,4 linkage."))

(defclass ToCatalyseMyristoyltransferaseActivity 
 :annotation (goid "GO:0019107") 
 :annotation (Def "Catalysis of the transfer of a myristoyl (CH3-[CH2]12-CO-) group to an acceptor molecule."))

(defclass ToCatalyseO-AcetyltransferaseActivity 
 :annotation (goid "GO:0016413") 
 :annotation (Def "Catalysis of the transfer of an acetyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseLyticTransglycosylaseActivity 
 :annotation (goid "GO:0008933") 
 :annotation (Def "Catalysis of the specific cleavage of the beta-(1->4) glycosidic linkage between N-acetylmuramyl and N-acetylglucosaminyl residues in peptidoglycan, with the concomitant formation of 1,6-anhydro-N-acetylmuramyl residues."))

(defclass ToCatalyseO-DecanoyltransferaseActivity 
 :annotation (goid "GO:0034325") 
 :annotation (Def "Catalysis of the transfer of a decyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalysePupConjugatingEnzymeActivity 
 :annotation (goid "GO:0061655") 
 :annotation (Def  "Isoenergetic transfer of Pup from one protein to another via the reaction X-Pup + Y -> Y-Pup + X, where both the X-Pup and Y-Pup linkages are thioester bonds between the C-terminal amino acid of Pup and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseN6-ThreonylcarbomyladenosineMethylthiotransferaseActivity 
 :annotation (goid "GO:0035598") 
 :annotation (Def "Catalysis of the methylthiolation (-SCH3 addition) at the C2 of the adenosine ring of N6-threonylcarbomyladenosine (t6A) in tRNA, to form 2-methylthio-N6-threonylcarbamoyladenosine (ms2t6A)."))

(defclass ToCatalyseLysineN-MethyltransferaseActivity 
 :annotation (goid "GO:0016278") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the epsilon-amino group of a lysine residue."))

(defclass ToCatalyseLysophosphatidylethanolamineAcyltransferaseActivity 
 :annotation (goid "GO:0071618") 
 :annotation (Def "Catalysis of the transfer of acyl groups from an acyl-CoA to lysophosphatidylethanolamine."))

(defclass ToCatalyseAlternansucraseActivity 
 :annotation (goid "GO:0033824") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-glucosyl residue from sucrose to alternately the 6-position and the 3-position of the non-reducing terminal residue of an alpha-D-glucan, thus producing a glucan having alternating alpha-1,6- and alpha-1,3-linkages."))

(defclass ToCatalyseTrihydroxyferuloylSpermidine:S-Adenosyl-L-MethionineO-MethyltransferaseActivity 
 :annotation (goid "GO:0080077") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the oxygen atom of a trihydroxyferuloyl spermidine molecule."))

(defclass ToCatalyseTransferaseActivity-TransferringAcylGroupsOtherThanAmino-AcylGroups 
 :annotation (goid "GO:0016747") 
 :annotation (Def "Catalysis of the transfer of an acyl group, other than amino-acyl, from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseTransketolaseActivity 
 :annotation (goid "GO:0004802") 
 :annotation (Def "Catalysis of the reversible transfer of a 2-carbon ketol group (CH2OH-CO-) from a ketose phosphate donor to an aldose phosphate acceptor. "))

(defclass ToCatalyse1-3-Beta-GlucanosyltransferaseActivity 
 :annotation (goid "GO:0042124") 
 :annotation (Def "Catalysis of the splitting and linkage of (1->3)-beta-D-glucan molecules, resulting in (1->3)-beta-D-glucan chain elongation."))

(defclass ToCatalyseGdp-Mannose:Serine-ProteinMannose-1-PhosphotransferaseActivity 
 :annotation (goid "GO:0018422") 
 :annotation (Def "Catalysis of the transfer of mannose-1-phosphate to a serine residue in a protein."))

(defclass ToCatalyseRrna_Cytosine-C5-_-MethyltransferaseActivity 
 :annotation (goid "GO:0009383") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to cytosine to form 5-methylcytosine in small subunit ribosomal RNA."))

(defclass ToCatalyseRnaGuanylyltransferaseActivity 
 :annotation (goid "GO:0008192") 
 :annotation (Def "Catalysis of the posttranscriptional addition of a guanyl residue to the 5' end of an RNA molecule."))

(defclass ToCatalyseBeta-GalactosideAlpha-2-3-SialyltransferaseActivity 
 :annotation (goid "GO:0052798") 
 :annotation (Def "Catalysis of the transfer of sialyl residues alpha-2,3-linked to a beta galactosyl residue on the donor to form an alpha-2,3 linkage to a terminal beta galactosyl residue on the acceptor."))

(defclass ToCatalyseFat10LigaseActivity 
 :annotation (goid "GO:0061661") 
 :annotation (Def "Catalysis of the transfer of FAT10 to a substrate protein via the reaction X-FAT10 + S --> X + S-FAT10, where X is either an E2 or E3 enzyme, the X-FAT10 linkage is a thioester bond, and the S-FAT10 linkage is an isopeptide bond between the C-terminal glycine of FAT10 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseArginineN-MethyltransferaseActivity 
 :annotation (goid "GO:0016273") 
 :annotation (Def  "Enables the transfer of a methyl group from S-adenosyl-L-methionine to an amino group of an arginine residue."))

(defclass ToCatalyseTrna_Adenine-57-58-N_1_-_MethyltransferaseActivity 
 :annotation (goid "GO:0043827") 
 :annotation (Def "Catalysis of the methylation of adenine-57 and adenine-58 in the T-loop of tRNA."))

(defclass ToCatalyseDolichylPyrophosphateMan7Glcnac2Alpha-1-3-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033556") 
 :annotation (Def "Catalysis of the addition of a glucose residue to the lipid-linked oligosaccharide precursor for N-linked glycosylation
 the transfer of glucose from dolichyl phosphate glucose (Dol-P-Glc) on to the lipid-linked oligosaccharide Man(7)GlcNAc(2)-PP-Dol."))

(defclass ToCatalyseGlucanosyltransferaseActivity 
 :annotation (goid "GO:0042123") 
 :annotation (Def "Catalysis of the splitting and linkage of glucan molecules, resulting in glucan chain elongation."))

(defclass ToCatalyseQuercetin3'-O-GlucosyltransferaseActivity 
 :annotation (goid "GO:0080045") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group from UDP-glucose to the 3'-hydroxy group of a quercetin molecule."))

(defclass ToCatalysePhosphorelaySensorKinaseActivity 
 :annotation (goid "GO:0000155") 
 :annotation (Def "Catalysis of the phosphorylation of a histidine residue in response to detection of an extracellular signal such as a chemical ligand or change in environment, to initiate a change in cell state or activity. The two-component sensor is a histidine kinase that autophosphorylates a histidine residue in its active site. The phosphate is then transferred to an aspartate residue in a downstream response regulator, to trigger a response."))

(defclass ToCatalyseUbiquitin-LikeProteinLigaseActivity 
 :annotation (goid "GO:0061659") 
 :annotation (Def "Catalysis of the transfer of a ubiquitin-like protein (ULP) to a substrate protein via the reaction X-ULP + S --> X + S-ULP, where X is either an E2 or E3 enzyme, the X-ULP linkage is a thioester bond, and the S-ULP linkage is an isopeptide bond between the C-terminal glycine of ULP and the epsilon-amino group of lysine residues in the substrate. "))

(defclass ToCatalyseTrna5-CarboxymethoxyuridineMethyltransferaseActivity 
 :annotation (goid "GO:0097697") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosylmethionine to a 5-carboxymethoxy-modified uridine residue in a tRNA molecule."))

(defclass ToCatalyseL-GlutamineAminotransferaseActivity 
 :annotation (goid "GO:0070548") 
 :annotation (Def "Catalysis of the transfer of an amino group from L-glutamine to an acceptor, usually a 2-oxo acid."))

(defclass ToCatalyseOAntigenPolymeraseActivity 
 :annotation (goid "GO:0008755") 
 :annotation (Def "Catalysis of the polymerization of o-antigen chains. O-antigens are tetra- and pentasaccharide repeat units of the cell walls of Gram-negative bacteria and are a component of lipopolysaccharide."))

(defclass ToCatalyseDecanoyltransferaseActivity 
 :annotation (goid "GO:0034328") 
 :annotation (Def "Catalysis of the transfer of a decanoyl (CH3-[CH2]8-CO-) group to an acceptor molecule."))

(defclass ToCatalyseGlycolipid6-Alpha-MannosyltransferaseActivity 
 :annotation (goid "GO:0033164") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-mannosyl residue from GDP-mannose into lipid-linked oligosaccharide, forming an alpha-(1->6)-D-mannosyl-D-mannose linkage."))

(defclass ToCatalyseIsg15TransferaseActivity 
 :annotation (goid "GO:0042296") 
 :annotation (Def "Catalysis of the transfer of ISG15 from one protein to another via the reaction X-ISG15 + Y --> Y-ISG15 + X, where both X-ISG15 and Y-ISG15 are covalent linkages."))

(defclass ToCatalyseSinapoyltransferaseActivity 
 :annotation (goid "GO:0016752") 
 :annotation (Def "Catalysis of the transfer of a sinapoyl group to an acceptor molecule."))

(defclass ToCatalyseTrnaMethyltransferaseActivity 
 :annotation (goid "GO:0008175") 
 :annotation (Def "Catalysis of the transfer of a methyl group from a donor to a nucleoside residue in a tRNA molecule."))

(defclass ToCatalyseUridylyltransferaseActivity 
 :annotation (goid "GO:0070569") 
 :annotation (Def "Catalysis of the transfer of an uridylyl group to an acceptor. "))

(defclass ToCatalyseDnaPrimaseActivity 
 :annotation (goid "GO:0003896") 
 :annotation (Def "Catalysis of the synthesis of a short RNA primer on a DNA template, providing a free 3'-OH that can be extended by DNA-directed DNA polymerases."))

(defclass ToCatalyseIron-SulfurTransferaseActivity 
 :annotation (goid "GO:0036455") 
 :annotation (Def "Catalysis of the transfer of a iron-sulfur cluster from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseP-MethyltransferaseActivity 
 :annotation (goid "GO:0051994") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the phosphorus atom of an acceptor molecule."))

(defclass ToCatalyseAcyl-CoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0019186") 
 :annotation (Def "Catalysis of the transfer of an acyl group from acyl-CoA to a nitrogen atom on an acceptor molecule."))

(defclass ToCatalyseAlpha-1-3-GalactosyltransferaseActivity 
 :annotation (goid "GO:0001962") 
 :annotation (Def "Catalysis of the transfer of a galactose residue from a donor molecule, such as GDP-galactose or UDP-galactose, to an oligosaccharide, forming an alpha-(1->3) linkage."))

(defclass ToCatalyseLyticEndotransglycosylaseActivity 
 :annotation (goid "GO:0008932") 
 :annotation (Def "Catalysis of the specific cleavage of the beta-(1->4) glycosidic linkage between N-acetylmuramyl and N-acetylglucosaminyl residues in peptidoglycan, with the concomitant formation of 1,6-anhydro-N-acetylmuramyl residues. Acts on linkages within peptidoglycan chains (i.e. not at the ends) to produce shorter strands with 1,6-anhydromuramic acid ends."))

(defclass ToCatalyseNedd8ConjugatingEnzymeActivity 
 :annotation (goid "GO:0061654") 
 :annotation (Def  "Isoenergetic transfer of NEDD8 from one protein to another via the reaction X-NEDD8 + Y -> Y-NEDD8 + X, where both the X-NEDD8 and Y-NEDD8 linkages are thioester bonds between the C-terminal amino acid of NEDD8 and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalysePhosphatidyltransferaseActivity 
 :annotation (goid "GO:0030572") 
 :annotation (Def "Catalysis of the reaction involving the transfer of a phosphatidate (otherwise known as diacylglycerol 3-phosphosphate) group."))

(defclass ToCatalyseN6-IsopentenyladenosineMethylthiotransferaseActivity 
 :annotation (goid "GO:0035597") 
 :annotation (Def "Catalysis of the methylthiolation (-SCH3 addition) at the C2 of the adenosine ring of N6-isopentenyladenosine (i6A) in tRNA, to form 2-methylthio-N6-isopentenyladenosine (ms2i6A)."))

(defclass ToCatalyse1-4-Alpha-GlucanBranchingEnzymeActivity 
 :annotation (goid "GO:0003844") 
 :annotation (Def "Catalysis of the transfer of a segment of a (1->4)-alpha-D-glucan chain to a primary hydroxyl group in a similar glucan chain."))

(defclass ToCatalyseTransferaseActivity-TransferringAcylGroups-AcylGroupsConvertedIntoAlkylOnTransfer 
 :annotation (goid "GO:0046912") 
 :annotation (Def "Catalysis of the transfer of an acyl group from one compound (donor) to another (acceptor), with the acyl group being converted into alkyl on transfer."))

(defclass ToCatalyseHistoneThreonineKinaseActivity 
 :annotation (goid "GO:0035184") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to a threonine residue of a histone. Histones are any of a group of water-soluble proteins found in association with the DNA of eukaroytic  chromosomes."))

(defclass ToCatalyseXyloglucan:XyloglucosylTransferaseActivity 
 :annotation (goid "GO:0016762") 
 :annotation (Def "Catalysis of the cleavage of a beta-(1->4) bond in the backbone of a xyloglucan and transfers the xyloglucanyl segment on to O-4 of the non-reducing terminal glucose residue of an acceptor, which can be a xyloglucan or an oligosaccharide of xyloglucan. "))

(defclass ToCatalyseProtein-CysteineS-AcyltransferaseActivity 
 :annotation (goid "GO:0019707") 
 :annotation (Def "Catalysis of the transfer of an acyl group to a sulfur atom on the cysteine of a protein molecule."))

(defclass ToCatalyseSumoTransferaseActivity 
 :annotation (goid "GO:0019789") 
 :annotation (Def "Catalysis of the transfer of SUMO from one protein to another via the reaction X-SUMO + Y --> Y-SUMO + X, where both X-SUMO and Y-SUMO are covalent linkages."))

(defclass ToCatalyseHistoneKinaseActivity_H2B-S14Specific_ 
 :annotation (goid "GO:0044025") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-14 or an equivalent residue of the N-terminal tail of histone H2B. "))

(defclass ToCatalyseUbiquitin-UbiquitinLigaseActivity 
 :annotation (goid "GO:0034450") 
 :annotation (Def  "Isoenergetic transfer of ubiquitin from one protein to an existing ubiquitin chain via the reaction X-ubiquitin + Y-ubiquitin -> Y-ubiquitin-ubiquitin + X, where both the X-ubiquitin and Y-ubiquitin-ubiquitin linkages are thioester bonds between the C-terminal glycine of ubiquitin and a sulfhydryl side group of a cysteine residue."))

(defclass ToCatalyseMembrane-OligosaccharideGlycerophosphotransferaseActivity 
 :annotation (goid "GO:0047495") 
 :annotation (Def "Catalysis of the transfer of a glycerophospho group from one membrane-derived oligosaccharide to another. "))

(defclass ToCatalyseHistoneKinaseActivity_H2A-S139Specific_ 
 :annotation (goid "GO:0035979") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-139 residue of the C-terminal tail of histone H2A."))

(defclass ToCatalyseOligosaccharylTransferaseActivity 
 :annotation (goid "GO:0004576") 
 :annotation (Def "Catalysis of the transfer of a oligosaccharyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseTransferaseActivity-TransferringSulfur-ContainingGroups 
 :annotation (goid "GO:0016782") 
 :annotation (Def "Catalysis of the transfer of a sulfur-containing group from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseGalactose-6-SulfurylaseActivity 
 :annotation (goid "GO:0033844") 
 :annotation (Def "Catalysis of the elimination of sulfate from the D-galactose 6-sulfate residues of porphyran, producing 3,6-anhydrogalactose residues. "))

(defclass ToCatalyseHistoneKinaseActivity_H2A-T120Specific_ 
 :annotation (goid "GO:1990244") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the threonine-120 residue of histone H2A."))

(defclass ToCatalyseProtein-CysteineS-PalmitoyltransferaseActivity 
 :annotation (goid "GO:0019706") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl group to a sulfur atom on the cysteine of a protein molecule."))

(defclass ToCatalyseSulfurtransferaseActivity 
 :annotation (goid "GO:0016783") 
 :annotation (Def "Catalysis of the transfer of sulfur atoms from one compound (donor) to another (acceptor). "))

(defclass ToCatalyseSpermidine:FeruloylCoaN-AcyltransferaseActivity 
 :annotation (goid "GO:0080075") 
 :annotation (Def "Catalysis of the transfer of a feruloyl group to a nitrogen atom on the spermidine molecule."))

(defclass ToCatalyseAlpha-1-3-MannosyltransferaseActivity 
 :annotation (goid "GO:0000033") 
 :annotation (Def "Catalysis of the transfer of a mannose residue to an oligosaccharide, forming an alpha-(1->3) linkage."))

(defclass ToCatalysePalmitoyltransferaseActivity 
 :annotation (goid "GO:0016409") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl (CH3-[CH2]14-CO-) group to an acceptor molecule."))

(defclass ToCatalyseProteinCarboxylO-MethyltransferaseActivity 
 :annotation (goid "GO:0051998") 
 :annotation (Def "Catalysis of the transfer of a methyl group to a carboxyl group on a protein."))

(defclass ToCatalyseGlucosyltransferaseActivity 
 :annotation (goid "GO:0046527") 
 :annotation (Def "Catalysis of the transfer of a glucosyl group to an acceptor molecule, typically another carbohydrate or a lipid."))

(defclass ToCatalyseGlycoprotein-N-Acetylgalactosamine3-Beta-GalactosyltransferaseActivity 
 :annotation (goid "GO:0016263") 
 :annotation (Def "Catalysis of the addition of a galactosyl residue to a non-reducing O-linked N-acetylgalactosamine residue in an O-glycan. "))

(defclass ToCatalyse4-HydroxybutyrateCoa-TransferaseActivity 
 :annotation (goid "GO:0008411") 
 :annotation (Def "Catalysis of the transfer of a coenzyme A (CoA) group to 4-hydroxybutyrate."))

(defclass ToCatalyseCaffeoylCoa:S-Adenosyl-L-MethionineO-MethyltransferaseActivity 
 :annotation (goid "GO:0080076") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the oxygen atom of a caffeoyl CoA molecule."))

(defclass ToCatalyseMapKinaseKinaseKinaseKinaseActivity 
 :annotation (goid "GO:0008349") 
 :annotation (Def "Catalysis of the phosphorylation of serine and threonine residues in a mitogen-activated protein kinase kinase kinase (MAPKKK), resulting in activation of MAPKKK. MAPKKK signaling pathways relay, amplify and integrate signals from the plasma membrane to the nucleus in response to a diverse range of extracellular stimuli. "))

(defclass ToCatalyseJuvenileHormoneAcidMethyltransferaseActivity 
 :annotation (goid "GO:0035049") 
 :annotation (Def "Catalysis of the transfer of a methyl group to juvenile hormone acid."))

(defclass ToCatalyseHistoneMethyltransferaseActivity_H4-R3Specific_ 
 :annotation (goid "GO:0044020") 
 :annotation (Def "Catalysis of the reaction: S-adenosyl-L-methionine + (histone H4)-arginine (position 3) = S-adenosyl-L-homocysteine + (histone H4)-N-methyl-arginine (position 3). This reaction is the addition of a methyl group to arginine at position 3 of histone H4. "))

(defclass ToCatalyseFat10TransferaseActivity 
 :annotation (goid "GO:0019775") 
 :annotation (Def "Catalysis of the transfer of FAT10 from one protein to another via the reaction X-FAT10 + Y --> Y-FAT10 + X, where both X-FAT10 and Y-FAT10 are covalent linkages."))

(defclass ToCatalyseC-MethyltransferaseActivity 
 :annotation (goid "GO:0008169") 
 :annotation (Def "Catalysis of the transfer of a methyl group to the carbon atom of an acceptor molecule."))

(defclass ToCatalysePolynucleotideAdenylyltransferaseActivity 
 :annotation (goid "GO:0004652") 
 :annotation (Def "Catalysis of the template-independent extension of the 3'- end of an RNA or DNA strand by addition of one adenosine molecule at a time. Cannot initiate a chain 'de novo'. The primer, depending on the source of the enzyme, may be an RNA or DNA fragment, or oligo(A) bearing a 3'-OH terminal group."))

(defclass ToCatalyseProteinPrenyltransferaseActivity 
 :annotation (goid "GO:0008318") 
 :annotation (Def "Catalysis of the covalent addition of an isoprenoid group such as a farnesyl or geranylgeranyl group via thioether linkages to a cysteine residue in a protein."))

(defclass ToCatalyseAll-TransUndecaprenolKinaseActivity 
 :annotation (goid "GO:0036432") 
 :annotation (Def "Catalysis of the reaction: ATP + undecaprenol + all-trans-undecaprenyl phosphate + ADP + H+."))

(defclass ToCatalyseUbiquitinProteinLigaseActivity 
 :annotation (goid "GO:0061630") 
 :annotation (Def "Catalysis of the transfer of ubiquitin to a substrate protein via the reaction X-ubiquitin + S -> X + S-ubiquitin, where X is either an E2 or E3 enzyme, the X-ubiquitin linkage is a thioester bond, and the S-ubiquitin linkage is an amide bond: an isopeptide bond between the C-terminal glycine of ubiquitin and the epsilon-amino group of lysine residues in the substrate or, in the linear extension of ubiquitin chains, a peptide bond the between the C-terminal glycine and N-terminal methionine of ubiquitin residues. "))

(defclass ToCatalyseUdp-N-Acetylglucosamine:Serine-ProteinN-Acetylglucosamine-1-PhosphotransferaseActivity 
 :annotation (goid "GO:0018421") 
 :annotation (Def "Catalysis of the transfer of N-acetylglucosamine-1-phosphate to a serine residue in a protein."))

(defclass ToCatalyseHexanoyltransferaseActivity 
 :annotation (goid "GO:0034327") 
 :annotation (Def "Catalysis of the transfer of a hexanoyl (CH3-[CH2]4-CO-) group to an acceptor molecule."))

(defclass ToCatalyseRna5'-MethyltransferaseActivity 
 :annotation (goid "GO:1990276") 
 :annotation (Def "Catalysis of the transfer of a methyl group from S-adenosyl-L-methionine to the 5'-gamma-phosphate in an RNA molecule."))

(defclass ToCatalyseAtg12LigaseActivity 
 :annotation (goid "GO:0061660") 
 :annotation (Def "Catalysis of the transfer of Atg12 to a substrate protein via the reaction X-Atg12 + S --> X + S-Atg12, where X is either an E2 or E3 enzyme, the X-Atg12 linkage is a thioester bond, and the S-Atg12 linkage is an isopeptide bond between the C-terminal amino acid of Atg12 and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseAlpha-1-2-MannosyltransferaseActivity 
 :annotation (goid "GO:0000026") 
 :annotation (Def "Catalysis of the transfer of a mannose residue to an oligosaccharide, forming an alpha-(1->2) linkage."))

(defclass ToCatalyseO-PalmitoyltransferaseActivity 
 :annotation (goid "GO:0016416") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseDolichylPyrophosphateMan9Glcnac2Alpha-1-3-GlucosyltransferaseActivity 
 :annotation (goid "GO:0042281") 
 :annotation (Def "Catalysis of the addition of the first glucose residue to the lipid-linked oligosaccharide precursor for N-linked glycosylation
 the transfer of glucose from dolichyl phosphate glucose (Dol-P-Glc) on to the lipid-linked oligosaccharide Man(9)GlcNAc(2)-PP-Dol."))

(defclass ToCatalyseDolichyl-Phosphate-Glucose-GlycolipidAlpha-GlucosyltransferaseActivity 
 :annotation (goid "GO:0004583") 
 :annotation (Def "Catalysis of the transfer of an alpha-D-glucosyl residue from dolichyl-phosphate D-glucose into a membrane lipid-linked oligosaccharide."))

(defclass ToCatalyseAminoAcidKinaseActivity 
 :annotation (goid "GO:0019202") 
 :annotation (Def "Catalysis of the transfer of a phosphate group, usually from ATP, to an amino acid substrate."))

(defclass ToCatalyseUdp-XylosyltransferaseActivity 
 :annotation (goid "GO:0035252") 
 :annotation (Def "Catalysis of the transfer of a xylosyl group from UDP-xylose to an acceptor molecule."))

(defclass ToCatalyseS-AcyltransferaseActivity 
 :annotation (goid "GO:0016417") 
 :annotation (Def "Catalysis of the transfer of an acyl group to a sulfur atom on the acceptor molecule."))

(defclass ToCatalyseC-PalmitoyltransferaseActivity 
 :annotation (goid "GO:0016454") 
 :annotation (Def "Catalysis of the transfer of a palmitoyl group to a carbon atom on the acceptor molecule."))

(defclass ToCatalyseKinaseActivity 
 :annotation (goid "GO:0016301") 
 :annotation (Def "Catalysis of the transfer of a phosphate group, usually from ATP, to a substrate molecule.|Note that this term encompasses all activities that transfer a single phosphate group
 although ATP is by far the most common phosphate donor, reactions using other phosphate donors are included in this term."))

(defclass ToCatalyseO-SuccinyltransferaseActivity 
 :annotation (goid "GO:0016750") 
 :annotation (Def "Catalysis of the transfer of a succinyl group to an oxygen atom on the acceptor molecule."))

(defclass ToCatalyseOctanoyltransferaseActivity 
 :annotation (goid "GO:0016415") 
 :annotation (Def "Catalysis of the transfer of an octanoyl (CH3-[CH2]6-CO-) group to an acceptor molecule."))

(defclass ToCatalysePolyprenyltransferaseActivity 
 :annotation (goid "GO:0002094") 
 :annotation (Def "Catalysis of the transfer of multiple prenyl groups from one compound (donor) to another (acceptor)."))

(defclass ToCatalyseS-SuccinyltransferaseActivity 
 :annotation (goid "GO:0016751") 
 :annotation (Def "Catalysis of the transfer of a succinyl group to a sulfur atom on the acceptor molecule."))

(defclass ToCatalyseGuanylyltransferaseActivity 
 :annotation (goid "GO:0070568") 
 :annotation (Def "Catalysis of the transfer of a guanylyl group to an acceptor."))

(defclass ToCatalyseRnaAdenylyltransferaseActivity 
 :annotation (goid "GO:1990817") 
 :annotation (Def "Catalysis of the template-independent extension of the 3'- end of an RNA strand by addition of one adenosine molecule at a time. Cannot initiate a chain 'de novo'. The primer, depending on the source of the enzyme, may be an RNA, or oligo(A) bearing a 3'-OH terminal group."))

(defclass ToCatalyseAlpha-1-6-MannosyltransferaseActivity 
 :annotation (goid "GO:0000009") 
 :annotation (Def "Catalysis of the transfer of a mannose residue to an oligosaccharide, forming an alpha-(1->6) linkage."))

(defclass ToCatalyseTrna_M5U54_MethyltransferaseActivity 
 :annotation (goid "GO:0030696") 
 :annotation (Def "Catalysis of the transfer of a methyl group from a donor to the C5 atom of the uridine residue at position 54 in a tRNA molecule.|Note that the term name mentions a specific position within a tRNA because no other names have yet arisen for this activity, and because the position is conserved in nearly all tRNAs. The term nevertheless can be used for activities that methylase an analogous residue at a position other than 54, if such is found, and synonyms that mention positions applicable to other tRNAs or species may also be added."))

(defclass ToCatalyseTransferaseActivity-TransferringPhosphorus-ContainingGroups 
 :annotation (goid "GO:0016772") 
 :annotation (Def "Catalysis of the transfer of a phosphorus-containing group from one compound (donor) to another (acceptor).|Note that this term encompasses all kinase activities, as well as activities that transfer other phosphorus-containing groups such as diphosphate or nucleotides."))

(defclass ToCatalyse1-4-Alpha-Glucan6-Alpha-GlucosyltransferaseActivity 
 :annotation (goid "GO:0032001") 
 :annotation (Def "Catalysis of the transfer an alpha-D-glucosyl residue in a (1->4)-alpha-D-glucan to the primary hydroxy group of glucose, free or combined in a (1->4)-alpha-D-glucan."))

(defclass ToCatalyseTransaminaseActivity 
 :annotation (goid "GO:0008483") 
 :annotation (Def "Catalysis of the transfer of an amino group to an acceptor, usually a 2-oxo acid."))

(defclass ToCatalyseHistoneKinaseActivity_H2A-S1Specific_ 
 :annotation (goid "GO:0044024") 
 :annotation (Def "Catalysis of the transfer of a phosphate group to the serine-1 residue of the N-terminal tail of histone H2A. "))

(defclass ToCatalyse2'-DeoxyguanosineDnaAdp-RibosyltransferaseActivity 
 :annotation (goid "GO:0030591") 
 :annotation (Def "Catalysis of the transfer of the ADP-ribose group of NAD+ to the amino group at N2 of 2'-deoxyguanosine to yield N2-(alpha-ADP-ribos-1-yl)-2'-deoxyguanosine and its beta form."))

(defclass ToCatalyseMethylthiotransferaseActivity 
 :annotation (goid "GO:0035596") 
 :annotation (Def "Catalysis of the addition of a methylthioether group (-SCH3) to a nucleic acid or protein acceptor."))

(defclass ToCatalyseGlucosyl-DnaBeta-GlucosyltransferaseActivity 
 :annotation (goid "GO:0033822") 
 :annotation (Def "Catalysis of the transfer of a beta-D-glucosyl residue from UDP-glucose to a glucosylhydroxymethylcytosine residue in DNA. "))

(defclass ToCatalysePeptide-O-FucosyltransferaseActivity 
 :annotation (goid "GO:0046922") 
 :annotation (Def "Catalysis of the transfer of an alpha-L-fucosyl residue from GDP- beta-L-fucose to the serine hydroxy group of a protein acceptor. "))

(defclass ToCatalyseAcetylgalactosaminyltransferaseActivity 
 :annotation (goid "GO:0008376") 
 :annotation (Def "Catalysis of the transfer of an N-acetylgalactosaminyl residue from UDP-N-acetyl-galactosamine to an oligosaccharide."))

(defclass ToCatalysePhosphotransferaseActivity-AlcoholGroupAsAcceptor 
 :annotation (goid "GO:0016773") 
 :annotation (Def "Catalysis of the transfer of a phosphorus-containing group from one compound (donor) to an alcohol group (acceptor)."))

(defclass ToCatalyseProteinMethyltransferaseActivity 
 :annotation (goid "GO:0008276") 
 :annotation (Def "Catalysis of the transfer of a methyl group (CH3-) to a protein."))

(defclass ToCatalyseLauroyltransferaseActivity 
 :annotation (goid "GO:0008913") 
 :annotation (Def "Catalysis of the transfer of a lauroyl (dodecanoyl) group from one compound to another."))

(defclass ToCatalyseSumoLigaseActivity 
 :annotation (goid "GO:0061665") 
 :annotation (Def "Catalysis of the transfer of SUMO to a substrate protein via the reaction X-SUMO + S --> X + S-SUMO, where X is either an E2 or E3 enzyme, the X-SUMO linkage is a thioester bond, and the S-SUMO linkage is an isopeptide bond between the C-terminal amino acid of SUMO and the epsilon-amino group of lysine residues in the substrate."))

(defclass ToCatalyseLysophospholipidAcyltransferaseActivity 
 :annotation (goid "GO:0071617") 
 :annotation (Def "Catalysis of the transfer of acyl groups from an acyl-CoA to a lysophospholipid."))

(defclass ToCatalyseO-MethyltransferaseActivity
  :annotation (goid "GO:0008171")
  :annotation (Def "Catalysis of the transfer of a methyl group to the oxygen atom of an acceptor molecule."))




















;;=============================================
;;========== Transferase Equation classes =====
;;=============================================

  (defcatalyse ToCatalyseGTP-DependentProteinSerineKinaseActivity
  :annotation (goid "GO:0034211")
  :annotation (database "RHEA:18673")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_ ch/L-serine_residue)
    (owl-some hasProduct ch/ADP_3-_ ch/hydron ch/O-phospho-L-serine_2-__residue))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_ ch/hydron ch/O-phospho-L-serine_2-__residue)
    (owl-some hasProduct ch/ATP_4-_ ch/L-serine_residue)))
  :when ch/GTP_4-_
  :enzyme Transferase)

(defcatalyse ToCatalyseGTP-DependentProteinThreonineKinaseActivity
  :annotation (goid "GO:0034211")
  :annotation (database "RHEA:44880")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_ ch/L-threonine_residue)
    (owl-some hasProduct ch/ADP_3-_ ch/hydron ch/O-phosphonato-L-threonine_2-__residue))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_ ch/hydron ch/O-phosphonato-L-threonine_2-__residue)
    (owl-some hasProduct ch/ATP_4-_ ch/L-threonine_residue)))
  :when ch/GTP_4-_
  :enzyme Transferase)

(defcatalyse ToCatalyseProteinSerineKinaseActivity
  :annotation (goid "GO:0004674")
  :annotation (database "RHEA:17989")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_	ch/L-serine_residue)
    (owl-some hasProduct ch/ADP_3-_ ch/O-phospho-L-serine_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_ ch/O-phospho-L-serine_2-__residue ch/hydron)
    (owl-some hasProduct ch/ATP_4-_	ch/L-serine_residue)))
  :enzyme Transferase)


(defcatalyse ToCatalyseProteinThreonineKinaseActivity
  :annotation (goid "GO:0004674")
  :annotation (database "RHEA:46608")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_	ch/L-threonine_residue)
    (owl-some hasProduct ch/ADP_3-_	ch/O-phosphonato-L-threonine_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_	ch/O-phosphonato-L-threonine_2-__residue ch/hydron)
    (owl-some hasProduct ch/ATP_4-_	ch/L-threonine_residue)))
  :enzyme Transferase)



(defcatalyse ToCatalysePeptidyl-prolyl_cis-transIsomeraseActivity
  :annotation (goid "GO:0003755")
  :annotation (database "RHEA:16237")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/peptidylproline__omega=180__residue)
    (owl-some hasProduct ch/peptidylproline__omega=0__residue))
   (owl-and
    (owl-some hasReactant ch/peptidylproline__omega=0__residue)
    (owl-some hasProduct ch/peptidylproline__omega=180__residue)))
  :enzyme Transferase)


(defcatalyse ToCatalyseThetin-HomocysteineS-MethyltransferaseActivity
  :annotation (goid "GO:0047149")
  :annotation (database "RHEA:22788")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/L-homocysteine_zwitterion ch/_dimethylsulfonio_acetate)
    (owl-some hasProduct  ch/_methylthio_acetate ch/L-methionine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_methylthio_acetate ch/L-methionine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/L-homocysteine_zwitterion ch/_dimethylsulfonio_acetate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylamine-GlutamateN-MethyltransferaseActivity
  :annotation (goid "GO:0047148")
  :annotation (database "RHEA:15837")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/L-glutamate_1-_ ch/methylammonium)
    (owl-some hasProduct  ch/N-methyl-L-glutamate_1-_ ch/ammonium))
   (owl-and
    (owl-some hasReactant  ch/N-methyl-L-glutamate_1-_ ch/ammonium)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/methylammonium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxymethylglutaryl-CoaSynthaseActivity
  :annotation (goid "GO:0004421")
  :annotation (database "RHEA:10188")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetoacetyl-CoA_4-_ ch/acetyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/_3S_-3-hydroxy-3-methylglutaryl-CoA_5-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3S_-3-hydroxy-3-methylglutaryl-CoA_5-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/acetoacetyl-CoA_4-_ ch/acetyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHypoxanthinePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0004422")
  :annotation (database "RHEA:17973")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/IMP_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/hypoxanthine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_))
   (owl-and
    (owl-some hasReactant  ch/hypoxanthine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_)
    (owl-some hasProduct  ch/IMP_2-_ ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomoserineO-AcetyltransferaseActivity
  :annotation (goid "GO:0004414")
  :annotation (database "RHEA:13701")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-homoserine_zwitterion ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/O-acetyl-L-homoserine_zwitterion ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/O-acetyl-L-homoserine_zwitterion ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/L-homoserine_zwitterion ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad+-Dinitrogen-ReductaseAdp-D-RibosyltransferaseActivity
  :annotation (goid "GO:0030701")
  :annotation (database "RHEA:18077")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NAD_1-_ ch/L-argininium_residue)
    (owl-some hasProduct  ch/nicotinamide ch/N_omega_-alpha-_ADP-D-ribosyl_-L-arginine_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/nicotinamide ch/N_omega_-alpha-_ADP-D-ribosyl_-L-arginine_1-__residue ch/hydron)
    (owl-some hasProduct  ch/NAD_1-_ ch/L-argininium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylmalonyl-CoaCarboxytransferaseActivity
  :annotation (goid "GO:0047154")
  :annotation (database "RHEA:20764")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyruvate ch/_S_-methylmalonyl-CoA_5-_)
    (owl-some hasProduct  ch/oxaloacetate_2-_ ch/propionyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/oxaloacetate_2-_ ch/propionyl-CoA_4-_)
    (owl-some hasProduct  ch/pyruvate ch/_S_-methylmalonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomoserineKinaseActivity
  :annotation (goid "GO:0004413")
  :annotation (database "RHEA:13985")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-homoserine_zwitterion ch/ATP_4-_)
    (owl-some hasProduct  ch/O-phosphonato-L-homoserine_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/O-phosphonato-L-homoserine_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/L-homoserine_zwitterion ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeoxycytidylate5-HydroxymethyltransferaseActivity
  :annotation (goid "GO:0047153")
  :annotation (database "RHEA:11280")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_ ch/water)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_5-hydroxymethyldeoxycytidylate_2-_))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_5-hydroxymethyldeoxycytidylate_2-_)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethanol-5-HydroxybenzimidazolylcobamideCo-MethyltransferaseActivity
  :annotation (goid "GO:0047152")
  :annotation (database "RHEA:21344")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-hydroxybenzimidazolylcob_I_amide_1-_ ch/methanol ch/hydron)
    (owl-some hasProduct  ch/water ch/Co-methyl-Co-5-hydroxybenzimidazolylcob_III_amide))
   (owl-and
    (owl-some hasReactant  ch/water ch/Co-methyl-Co-5-hydroxybenzimidazolylcob_III_amide)
    (owl-some hasProduct  ch/_5-hydroxybenzimidazolylcob_I_amide_1-_ ch/methanol ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylenetetrahydrofolate-tRNA-_Uracil-5-_-Methyltransferase_FADH2-oxidizing_Activity
  :annotation (goid "GO:0047151")
  :annotation (database "RHEA:16873")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/uridine_5'-monophosphate_1-__residue ch/FADH2_2-_)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_5-methyluridine_5'-monophosphate_1-__residue ch/FAD_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_5-methyluridine_5'-monophosphate_1-__residue ch/FAD_3-_ ch/hydron)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/uridine_5'-monophosphate_1-__residue ch/FADH2_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxymethylbilaneSynthaseActivity
  :annotation (goid "GO:0004418")
  :annotation (database "RHEA:13185")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/water ch/porphobilinogen_1-_ ch/porphobilinogen_1-_ ch/porphobilinogen_1-_ ch/porphobilinogen_1-_)
    (owl-some hasProduct  ch/preuroporphyrinogen_8-_ ch/ammonium ch/ammonium ch/ammonium ch/ammonium))
   (owl-and
    (owl-some hasReactant  ch/preuroporphyrinogen_8-_ ch/ammonium ch/ammonium ch/ammonium ch/ammonium)
    (owl-some hasProduct  ch/water ch/porphobilinogen_1-_ ch/porphobilinogen_1-_ ch/porphobilinogen_1-_ ch/porphobilinogen_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSinapoylglucose-SinapoylglucoseO-SinapoyltransferaseActivity
  :annotation (goid "GO:0047158")
  :annotation (database "RHEA:22664")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-O-sinapoyl-beta-D-glucose ch/_1-O-sinapoyl-beta-D-glucose)
    (owl-some hasProduct  ch/_1_2-di-O-sinapoyl-beta-D-glucose ch/D-glucopyranose))
   (owl-and
    (owl-some hasReactant  ch/_1_2-di-O-sinapoyl-beta-D-glucose ch/D-glucopyranose)
    (owl-some hasProduct  ch/_1-O-sinapoyl-beta-D-glucose ch/_1-O-sinapoyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxyethylthiazoleKinaseActivity
  :annotation (goid "GO:0004417")
  :annotation (database "RHEA:24212")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-_2-hydroxyethyl_-4-methylthiazole ch/ATP_4-_)
    (owl-some hasProduct  ch/_4-methyl-5-_2-phosphonatooxyethyl_thiazole_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_4-methyl-5-_2-phosphonatooxyethyl_thiazole_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_5-_2-hydroxyethyl_-4-methylthiazole ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetoin-Ribose-5-PhosphateTransaldolaseActivity
  :annotation (goid "GO:0047156")
  :annotation (database "RHEA:21504")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/aldehydo-D-ribose_5-phosphate_2-_ ch/acetoin)
    (owl-some hasProduct  ch/_1-deoxy-D-altro-heptulose_7-phosphate_2-_ ch/acetaldehyde))
   (owl-and
    (owl-some hasReactant  ch/_1-deoxy-D-altro-heptulose_7-phosphate_2-_ ch/acetaldehyde)
    (owl-some hasProduct  ch/aldehydo-D-ribose_5-phosphate_2-_ ch/acetoin)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-HydroxymethylcephemCarbamoyltransferaseActivity
  :annotation (goid "GO:0047155")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxymethylcephalosporin ch/carbamoyl_phosphate)
    (owl-some hasProduct  ch/hydrogenphosphate ch/_3-_carbamoyloxymethyl_cephalosporin))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/_3-_carbamoyloxymethyl_cephalosporin)
    (owl-some hasProduct  ch/_3-hydroxymethylcephalosporin ch/carbamoyl_phosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProtein-GlutamineN-MethyltransferaseActivity
  :annotation (goid "GO:0036009")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamine)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-methyl-L-glutamine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-methyl-L-glutamine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTagatoseKinaseActivity
  :annotation (goid "GO:0050317")
  :annotation (database "RHEA:15513")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/keto-D-tagatose ch/ATP_4-_)
    (owl-some hasProduct  ch/keto-D-tagatose_6-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/keto-D-tagatose_6-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/keto-D-tagatose ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBetaine-HomocysteineS-MethyltransferaseActivity
  :annotation (goid "GO:0047150")
  :annotation (database "RHEA:22336")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-homocysteine_zwitterion ch/glycine_betaine)
    (owl-some hasProduct  ch/N_N-dimethylglycine_zwitterion ch/L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/N_N-dimethylglycine_zwitterion ch/L-methionine_zwitterion)
    (owl-some hasProduct  ch/L-homocysteine_zwitterion ch/glycine_betaine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSym-NorspermidineSynthaseActivity
  :annotation (goid "GO:0050314")
  :annotation (database "RHEA:23244")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trimethylenediaminium ch/S-adenosylmethioninaminium)
    (owl-some hasProduct  ch/_5'-S-methyl-5'-thioadenosine ch/bis_3-azaniumylpropyl_azanium ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_5'-S-methyl-5'-thioadenosine ch/bis_3-azaniumylpropyl_azanium ch/hydron)
    (owl-some hasProduct  ch/trimethylenediaminium ch/S-adenosylmethioninaminium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThymidylateSynthase_FAD_Activity
  :annotation (goid "GO:0050797")
  :annotation (database "RHEA:29043")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/dUMP_2-_ ch/NADPH_4-_ ch/hydron)
    (owl-some hasProduct  ch/dTMP_2-_ ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/NADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/dTMP_2-_ ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/NADP_3-_)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/dUMP_2-_ ch/NADPH_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-Phosphatidylinositol4-KinaseActivity
  :annotation (goid "GO:0004430")
  :annotation (database "RHEA:19877")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-phosphatidyl-1D-myo-inositol_1-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/_1-phosphatidyl-1D-myo-inositol_4-phosphate_3-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1-phosphatidyl-1D-myo-inositol_4-phosphate_3-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_1-phosphatidyl-1D-myo-inositol_1-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-AlkenylglycerophosphocholineO-AcyltransferaseActivity
  :annotation (goid "GO:0047159")
  :annotation (database "RHEA:10344")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-_Z_-alk-1-enyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1-_Z_-alk-1-enyl-2-acyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1-_Z_-alk-1-enyl-2-acyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-_Z_-alk-1-enyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-Beta-GlucosideO-MalonyltransferaseActivity
  :annotation (goid "GO:0047165")
  :annotation (database "RHEA:20085")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-beta-D-glucoside ch/malonyl-CoA_5-_)
    (owl-some hasProduct  ch/flavonol_3-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/flavonol_3-O-beta-D-glucoside ch/malonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTau-ProteinKinaseActivity
  :annotation (goid "GO:0050321")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-threonine_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/O-phosphonato-L-threonine_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/O-phosphonato-L-threonine_2-__residue)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-threonine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoflavone-7-O-Beta-Glucoside6_-O-MalonyltransferaseActivity
  :annotation (goid "GO:0047164")
  :annotation (database "RHEA:15581")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/biochanin_A_7-O-beta-D-glucoside_1-_ ch/malonyl-CoA_5-_)
    (owl-some hasProduct  ch/biochanin_A_7-O-beta-D-glucoside_6''-O-malonate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/biochanin_A_7-O-beta-D-glucoside_6''-O-malonate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/biochanin_A_7-O-beta-D-glucoside_1-_ ch/malonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3_4-DichloroanilineN-MalonyltransferaseActivity
  :annotation (goid "GO:0047163")
  :annotation (database "RHEA:21060")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3_4-dichloroaniline ch/malonyl-CoA_5-_)
    (owl-some hasProduct  ch/N-_3_4-dichlorophenyl_malonamate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/N-_3_4-dichlorophenyl_malonamate ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_3_4-dichloroaniline ch/malonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse17-O-DeacetylvindolineO-AcetyltransferaseActivity
  :annotation (goid "GO:0047162")
  :annotation (database "RHEA:24496")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_17-O-deacetylvindolinium ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/vindolinium_1+_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/vindolinium_1+_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_17-O-deacetylvindolinium ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTaurine-2-OxoglutarateTransaminaseActivity
  :annotation (goid "GO:0050322")
  :annotation (database "RHEA:16353")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/taurine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/sulfonatoacetaldehyde ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/sulfonatoacetaldehyde ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/taurine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactarateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047169")
  :annotation (database "RHEA:12997")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trans-feruloyl-CoA_4-_ ch/galactarate_2-_)
    (owl-some hasProduct  ch/_2-_E_-O-feruloyl-D-galactarate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_2-_E_-O-feruloyl-D-galactarate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/trans-feruloyl-CoA_4-_ ch/galactarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsocitrateO-DihydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047168")
  :annotation (database "RHEA:20756")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/caffeoyl-CoA_4-_ ch/isocitrate_3-_)
    (owl-some hasProduct  ch/_2-caffeoylisocitrate_3-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_2-caffeoylisocitrate_3-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/caffeoyl-CoA_4-_ ch/isocitrate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-Alkyl-2-AcetylglycerolO-AcyltransferaseActivity
  :annotation (goid "GO:0047167")
  :annotation (database "RHEA:21996")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-2-acetyl-sn-glycerol ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1-alkyl-2-acetyl-3-acyl-sn-glycerol ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-2-acetyl-3-acyl-sn-glycerol ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-alkyl-2-acetyl-sn-glycerol ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-AlkenylglycerophosphoethanolamineO-AcyltransferaseActivity
  :annotation (goid "GO:0047166")
  :annotation (database "RHEA:16245")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-_Z_-alk-1-enyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1-_Z_-alk-1-enyl-2-acyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1-_Z_-alk-1-enyl-2-acyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-_Z_-alk-1-enyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTartronateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047161")
  :annotation (database "RHEA:10952")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/hydroxymalonate_2-_ ch/sinapoyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/sinapoyltartronate_2-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/sinapoyltartronate_2-_)
    (owl-some hasProduct  ch/hydroxymalonate_2-_ ch/sinapoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlkylglycerophosphate2-O-AcetyltransferaseActivity
  :annotation (goid "GO:0047160")
  :annotation (database "RHEA:18557")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycerol_3-phosphate_2-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_1-alkyl-2-acetyl-sn-glycerol_3-phosphate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-2-acetyl-sn-glycerol_3-phosphate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycerol_3-phosphate_2-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTaurocyamineKinaseActivity
  :annotation (goid "GO:0050324")
  :annotation (database "RHEA:22516")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/taurocyamine_zwitterion)
    (owl-some hasProduct  ch/N-phosphonatotaurocyamine_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-phosphonatotaurocyamine_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/taurocyamine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistidinol-PhosphateTransaminaseActivity
  :annotation (goid "GO:0004400")
  :annotation (database "RHEA:23744")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-histidinol_phosphate_1-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_3-_imidazol-4-yl_-2-oxopropyl_phosphate_2-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3-_imidazol-4-yl_-2-oxopropyl_phosphate_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-histidinol_phosphate_1-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBeta-Glucogallin-TetrakisgalloylglucoseO-GalloyltransferaseActivity
  :annotation (goid "GO:0047176")
  :annotation (database "RHEA:19109")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2_3_6-tetrakis-O-galloyl-beta-D-glucose ch/_1-O-galloyl-beta-D-glucose)
    (owl-some hasProduct  ch/_1_2_3_4_6-pentakis-O-galloyl-beta-D-glucose ch/D-glucopyranose))
   (owl-and
    (owl-some hasReactant  ch/_1_2_3_4_6-pentakis-O-galloyl-beta-D-glucose ch/D-glucopyranose)
    (owl-some hasProduct  ch/_1_2_3_6-tetrakis-O-galloyl-beta-D-glucose ch/_1-O-galloyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiaminePyridinylaseActivity
  :annotation (goid "GO:0050332")
  :annotation (database "RHEA:17697")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyridine ch/thiamine_1+_)
    (owl-some hasProduct  ch/_5-_2-hydroxyethyl_-4-methylthiazole ch/_1-__4-amino-2-methylpyrimidin-5-yl_methyl_pyridinium))
   (owl-and
    (owl-some hasReactant  ch/_5-_2-hydroxyethyl_-4-methylthiazole ch/_1-__4-amino-2-methylpyrimidin-5-yl_methyl_pyridinium)
    (owl-some hasProduct  ch/pyridine ch/thiamine_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosylacylglycerolO-AcyltransferaseActivity
  :annotation (goid "GO:0047175")
  :annotation (database "RHEA:17057")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-O-acyl-3-O-beta-D-galactosyl-sn-glycerol ch/O-_S-fatty_acylpantetheine-4'-phosphoryl_-L-serine_1-__residue)
    (owl-some hasProduct  ch/_1_2-diacyl-3-beta-D-galactosyl-sn-glycerol ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-3-beta-D-galactosyl-sn-glycerol ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue)
    (owl-some hasProduct  ch/_2-O-acyl-3-O-beta-D-galactosyl-sn-glycerol ch/O-_S-fatty_acylpantetheine-4'-phosphoryl_-L-serine_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiamine-DiphosphateKinaseActivity
  :annotation (goid "GO:0050331")
  :annotation (database "RHEA:11240")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/thiamine_1+__diphosphate_3-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/thiamine_1+__triphosphate_4-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/thiamine_1+__triphosphate_4-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/thiamine_1+__diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePutrescineN-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047174")
  :annotation (database "RHEA:12436")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/caffeoyl-CoA_4-_ ch/_1_4-butanediammonium)
    (owl-some hasProduct  ch/N-caffeoylputrescinium_1+_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-caffeoylputrescinium_1+_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/caffeoyl-CoA_4-_ ch/_1_4-butanediammonium)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphatidylcholine-RetinolO-AcyltransferaseActivity
  :annotation (goid "GO:0047173")
  :annotation (database "RHEA:17469")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/all-trans-retinol ch/_1_2-diacyl-sn-glycero-3-phosphocholine)
    (owl-some hasProduct  ch/all-trans-retinyl_ester ch/_2-acylglycerophosphocholine))
   (owl-and
    (owl-some hasReactant  ch/all-trans-retinyl_ester ch/_2-acylglycerophosphocholine)
    (owl-some hasProduct  ch/all-trans-retinol ch/_1_2-diacyl-sn-glycero-3-phosphocholine)))
  :enzyme Transferase)

(defcatalyse ToCatalysePlatelet-ActivatingFactorAcetyltransferaseActivity
  :annotation (goid "GO:0047179")
  :annotation (database "RHEA:11048")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-organyl-2-lyso-sn-glycero-3-phospholipid_1-_ ch/_2-acetyl-1-alkyl-sn-glycero-3-phosphocholine)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-organyl-2-acetyl-sn-glycero-3-phospholipid_1-_))
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-organyl-2-acetyl-sn-glycero-3-phospholipid_1-_)
    (owl-some hasProduct  ch/_1-organyl-2-lyso-sn-glycero-3-phospholipid_1-_ ch/_2-acetyl-1-alkyl-sn-glycero-3-phosphocholine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycerophospholipidAcyltransferase_CoA-dependent_Activity
  :annotation (goid "GO:0047178")
  :annotation (database "RHEA:20972")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/_2-acyl-1-alkyl-sn-glycero-3-phosphocholine)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-alkyl-2-acyl-sn-glycero-3-phosphoethanolamine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-alkyl-2-acyl-sn-glycero-3-phosphoethanolamine_zwitterion)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/_2-acyl-1-alkyl-sn-glycero-3-phosphocholine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycerophospholipidArachidonoyl-Transferase_CoA-independent_Activity
  :annotation (goid "GO:0047177")
  :annotation (database "RHEA:15409")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/_1-O-alkyl-2-O-arachidonoyl-sn-glycero-3-phosphocholine)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-O-alkyl-2-arachidonoyl-sn-glycero-3-phosphoethanolamine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/_1-O-alkyl-2-arachidonoyl-sn-glycero-3-phosphoethanolamine_zwitterion)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphoethanolamine_zwitterion ch/_1-O-alkyl-2-O-arachidonoyl-sn-glycero-3-phosphocholine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseShikimateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047172")
  :annotation (database "RHEA:12124")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/shikimate ch/_4-coumaroyl-CoA_4-_)
    (owl-some hasProduct  ch/_4-coumaroylshikimate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_4-coumaroylshikimate ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/shikimate ch/_4-coumaroyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThioethanolamineS-AcetyltransferaseActivity
  :annotation (goid "GO:0050336")
  :annotation (database "RHEA:23280")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/cysteaminium)
    (owl-some hasProduct  ch/S-acetylcysteaminium ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/S-acetylcysteaminium ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/cysteaminium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucarolactoneO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047171")
  :annotation (database "RHEA:14261")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glucono-1_5-lactone ch/sinapoyl-CoA_4-_)
    (owl-some hasProduct  ch/_6-O-sinapoyl-D-glucono-1_5-lactone ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_6-O-sinapoyl-D-glucono-1_5-lactone ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/D-glucono-1_5-lactone ch/sinapoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucarateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047170")
  :annotation (database "RHEA:23308")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glucarate_2-_ ch/sinapoyl-CoA_4-_)
    (owl-some hasProduct  ch/_2-O-sinapoyl-D-glucarate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_2-O-sinapoyl-D-glucarate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/D-glucarate_2-_ ch/sinapoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiosulfate-ThiolSulfurtransferaseActivity
  :annotation (goid "GO:0050337")
  :annotation (database "RHEA:14505")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trioxidosulfanidosulfate_1-_ ch/glutathionate_1-_ ch/glutathionate_1-_)
    (owl-some hasProduct  ch/sulfite ch/glutathione_disulfide_2-_ ch/hydrosulfide ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/sulfite ch/glutathione_disulfide_2-_ ch/hydrosulfide ch/hydron ch/hydron)
    (owl-some hasProduct  ch/trioxidosulfanidosulfate_1-_ ch/glutathionate_1-_ ch/glutathionate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomocitrateSynthaseActivity
  :annotation (goid "GO:0004410")
  :annotation (database "RHEA:12929")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/acetyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/hydron ch/_2R_-homocitrate_3-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/hydron ch/_2R_-homocitrate_3-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/acetyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalysePeptidyltransferaseActivity
  :annotation (goid "GO:0000048")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/Peptidyl-tRNA ch/alpha-aminoacyl-tRNA)
    (owl-some hasProduct  ch/transfer_RNA ch/Peptidyl-aminoacyl-tRNA))
   (owl-and
    (owl-some hasReactant  ch/transfer_RNA ch/Peptidyl-aminoacyl-tRNA)
    (owl-some hasProduct  ch/Peptidyl-tRNA ch/alpha-aminoacyl-tRNA)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeacetyl-_Citrate-_Pro-3s_-Lyase_S-AcetyltransferaseActivity
  :annotation (goid "GO:0047187")
  :annotation (database "RHEA:20393")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-_2'-_5-phosphoribosyl_-3'-dephospho-CoA_-L-serine_3-__residue ch/S-acetylphosphopantotheine_2-_)
    (owl-some hasProduct  ch/S-acetyl-O-_2'-_5-phosphoribosyl_-3'-dephospho-CoA_-L-serine_3-__residue ch/D-pantetheine_4'-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/S-acetyl-O-_2'-_5-phosphoribosyl_-3'-dephospho-CoA_-L-serine_3-__residue ch/D-pantetheine_4'-phosphate_2-_)
    (owl-some hasProduct  ch/O-_2'-_5-phosphoribosyl_-3'-dephospho-CoA_-L-serine_3-__residue ch/S-acetylphosphopantotheine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistoneAcetyltransferaseActivity
  :annotation (goid "GO:0004402")
  :annotation (database "RHEA:21992")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/L-lysinium_residue)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/L-lysinium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-Acetylneuraminate7-O_Or9-O_-AcetyltransferaseActivity
  :annotation (goid "GO:0047186")
  :annotation (database "RHEA:20808")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetylneuraminate ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-7-O-acetylneuraminate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-7-O-acetylneuraminate ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/N-acetylneuraminate ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTocopherolO-MethyltransferaseActivity
  :annotation (goid "GO:0050342")
  :annotation (database "RHEA:24012")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/gamma-tocopherol)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_+_-alpha-tocopherol ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_+_-alpha-tocopherol ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/gamma-tocopherol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-Acetylneuraminate4-O-AcetyltransferaseActivity
  :annotation (goid "GO:0047185")
  :annotation (database "RHEA:18305")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetylneuraminate ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-4-O-acetylneuraminate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-4-O-acetylneuraminate ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/N-acetylneuraminate ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-AcylglycerophosphocholineO-AcyltransferaseActivity
  :annotation (goid "GO:0047184")
  :annotation (database "RHEA:12937")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-O-acyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-O-acyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2_3-DiaminopropionateN-OxalyltransferaseActivity
  :annotation (goid "GO:0047189")
  :annotation (database "RHEA:13465")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-amino-L-alanine_zwitterion ch/oxalyl-CoA_5-_)
    (owl-some hasProduct  ch/N_3_-_carboxylatoformyl_-L-2_3-diaminopropionate_1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/N_3_-_carboxylatoformyl_-L-2_3-diaminopropionate_1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_3-amino-L-alanine_zwitterion ch/oxalyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAromatic-HydroxylamineO-AcetyltransferaseActivity
  :annotation (goid "GO:0047188")
  :annotation (database "RHEA:20325")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-hydroxy-4-acetylaminobiphenyl)
    (owl-some hasProduct  ch/N-acetoxy-1_1'-biphenyl-4-amine))
   (owl-and
    (owl-some hasReactant  ch/N-acetoxy-1_1'-biphenyl-4-amine)
    (owl-some hasProduct  ch/N-hydroxy-4-acetylaminobiphenyl)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthocyanin5-AromaticAcyltransferaseActivity
  :annotation (goid "GO:0047183")
  :annotation (database "RHEA:15661")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/anthocyanidin_3_5-diglucoside_betaine ch/hydroxycinnamoyl-CoAs)
    (owl-some hasProduct  ch/anthocyanidin_3-glucoside_5-hydroxycinnamoylglucoside ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/anthocyanidin_3-glucoside_5-hydroxycinnamoylglucoside ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/anthocyanidin_3_5-diglucoside_betaine ch/hydroxycinnamoyl-CoAs)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrans-OctaprenyltranstransferaseActivity
  :annotation (goid "GO:0050347")
  :annotation (database "RHEA:11324")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/all-trans-octaprenyl_diphosphate_2-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-octaprenyl_diphosphate_2-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlcoholO-CinnamoyltransferaseActivity
  :annotation (goid "GO:0047182")
  :annotation (database "RHEA:23524")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alcohol ch/_1-O-trans-cinnamoyl-beta-D-glucopyranose)
    (owl-some hasProduct  ch/beta-D-glucose ch/alkyl_cinnamate))
   (owl-and
    (owl-some hasReactant  ch/beta-D-glucose ch/alkyl_cinnamate)
    (owl-some hasProduct  ch/alcohol ch/_1-O-trans-cinnamoyl-beta-D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTetrahydroxybenzophenoneSynthaseActivity
  :annotation (goid "GO:0047181")
  :annotation (database "RHEA:19305")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxybenzoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/_2_3'_4_6-tetrahydroxybenzophenone_1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/_2_3'_4_6-tetrahydroxybenzophenone_1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_3-hydroxybenzoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSalutaridinol7-O-AcetyltransferaseActivity
  :annotation (goid "GO:0047180")
  :annotation (database "RHEA:22856")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_7S_-salutaridinol_1+_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_7-O-acetylsalutaridinol_1+_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_7-O-acetylsalutaridinol_1+_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_7S_-salutaridinol_1+_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrehaloseO-MycolyltransferaseActivity
  :annotation (goid "GO:0050348")
  :annotation (database "RHEA:23472")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha_alpha'-trehalose_6-mycolate ch/alpha_alpha'-trehalose_6-mycolate)
    (owl-some hasProduct  ch/alpha_alpha'-trehalose_6_6'-bismycolate ch/alpha_alpha-trehalose))
   (owl-and
    (owl-some hasReactant  ch/alpha_alpha'-trehalose_6_6'-bismycolate ch/alpha_alpha-trehalose)
    (owl-some hasProduct  ch/alpha_alpha'-trehalose_6-mycolate ch/alpha_alpha'-trehalose_6-mycolate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLactoseSynthaseActivity
  :annotation (goid "GO:0004461")
  :annotation (database "RHEA:12404")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/D-glucopyranose)
    (owl-some hasProduct  ch/UDP_3-_ ch/lactose ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/lactose ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyse5-AminovalerateTransaminaseActivity
  :annotation (goid "GO:0047589")
  :annotation (database "RHEA:10212")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/_5-aminopentanoic_acid_zwitterion)
    (owl-some hasProduct  ch/_5-oxopentanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_5-oxopentanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/_5-aminopentanoic_acid_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobinamidePhosphateGuanylyltransferaseActivity
  :annotation (goid "GO:0008820")
  :annotation (database "RHEA:22712")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_phosphate_1-_ ch/GTP_4-_ ch/hydron)
    (owl-some hasProduct  ch/adenosylcobinamide_guanosyl_diphosphate_1-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_guanosyl_diphosphate_1-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/adenosylcobinamide_phosphate_1-_ ch/GTP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDimethylhistidineN-MethyltransferaseActivity
  :annotation (goid "GO:0030745")
  :annotation (database "RHEA:11104")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/N_alpha__N_alpha_-dimethyl-L-histidine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_alpha__N_alpha__N_alpha_-trimethyl-L-histidine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_alpha__N_alpha__N_alpha_-trimethyl-L-histidine ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/N_alpha__N_alpha_-dimethyl-L-histidine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLuteolinO-MethyltransferaseActivity
  :annotation (goid "GO:0030744")
  :annotation (database "RHEA:14589")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_2-_3_4-dihydroxyphenyl_-5-hydroxy-4-oxo-4H-chromen-7-olate_luteolin-7-olate_1-_)
    (owl-some hasProduct  ch/_4'_5-dihydroxy-3'-methoxyflavon-7-olate_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_4'_5-dihydroxy-3'-methoxyflavon-7-olate_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_2-_3_4-dihydroxyphenyl_-5-hydroxy-4-oxo-4H-chromen-7-olate_luteolin-7-olate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCitrateCoa-TransferaseActivity
  :annotation (goid "GO:0008814")
  :annotation (database "RHEA:19405")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/citrate_3-_)
    (owl-some hasProduct  ch/acetate ch/_3S_-citryl-CoA_6-_))
   (owl-and
    (owl-some hasReactant  ch/acetate ch/_3S_-citryl-CoA_6-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/citrate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIndolepyruvateC-MethyltransferaseActivity
  :annotation (goid "GO:0030747")
  :annotation (database "RHEA:12112")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_3-_indol-3-yl_pyruvate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_R_-3-_indol-3-yl_-2-oxobutyrate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_R_-3-_indol-3-yl_-2-oxobutyrate ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_3-_indol-3-yl_pyruvate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoflavone4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030746")
  :annotation (database "RHEA:31739")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_4'-hydroxyisoflavones)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_4'-methoxyisoflavones))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_4'-methoxyisoflavones)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_4'-hydroxyisoflavones)))
  :enzyme Transferase)

(defcatalyse ToCatalyse5-HydroxypentanoateCoa-TransferaseActivity
  :annotation (goid "GO:0047591")
  :annotation (database "RHEA:23496")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-hydroxypentanoate ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_5-hydroxypentanoyl-CoA_4-_ ch/acetate))
   (owl-and
    (owl-some hasReactant  ch/_5-hydroxypentanoyl-CoA_4-_ ch/acetate)
    (owl-some hasProduct  ch/_5-hydroxypentanoate ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLoganateO-MethyltransferaseActivity
  :annotation (goid "GO:0030749")
  :annotation (database "RHEA:12508")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/loganate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/loganin))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/loganin)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/loganate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobinamideKinaseActivity
  :annotation (goid "GO:0008819")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cobinamide ch/ATP_4-_)
    (owl-some hasProduct  ch/adenosylcobinamide_phosphate ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_phosphate ch/ADP_3-_)
    (owl-some hasProduct  ch/cobinamide ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAmineN-MethyltransferaseActivity
  :annotation (goid "GO:0030748")
  :annotation (database "RHEA:23139")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/primary_ammonium_ion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/methylated_primary_amine_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/methylated_primary_amine_1+_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/primary_ammonium_ion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobalamin5'-PhosphateSynthaseActivity
  :annotation (goid "GO:0008818")
  :annotation (database "RHEA:23560")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_guanosyl_diphosphate_1-_ ch/alpha-ribazole_5'-phosphate_2-_)
    (owl-some hasProduct  ch/adenosylcobalamin_5'-phosphate_2-_ ch/guanosine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosylcobalamin_5'-phosphate_2-_ ch/guanosine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/adenosylcobinamide_guanosyl_diphosphate_1-_ ch/alpha-ribazole_5'-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCob_I_YrinicAcidA_C-DiamideAdenosyltransferaseActivity
  :annotation (goid "GO:0008817")
  :annotation (database "RHEA:14725")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/ATP_4-_ ch/cob_II_inamide ch/cob_II_inamide ch/FADH2_2-_)
    (owl-some hasProduct  ch/triphosphate_5-_ ch/triphosphate_5-_ ch/adenosylcobinamide ch/adenosylcobinamide ch/hydron ch/hydron ch/hydron ch/FAD_3-_))
   (owl-and
    (owl-some hasReactant  ch/triphosphate_5-_ ch/triphosphate_5-_ ch/adenosylcobinamide ch/adenosylcobinamide ch/hydron ch/hydron ch/hydron ch/FAD_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/ATP_4-_ ch/cob_II_inamide ch/cob_II_inamide ch/FADH2_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositol1-MethyltransferaseActivity
  :annotation (goid "GO:0030741")
  :annotation (database "RHEA:17565")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)
    (owl-some hasProduct  ch/_1D-1-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1D-1-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyse5-Dehydro-2-DeoxygluconokinaseActivity
  :annotation (goid "GO:0047590")
  :annotation (database "RHEA:13497")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5-dehydro-2-deoxy-D-gluconate)
    (owl-some hasProduct  ch/ADP_3-_ ch/_6-phosphonato-5-dehydro-2-deoxy-D-gluconate_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_6-phosphonato-5-dehydro-2-deoxy-D-gluconate_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5-dehydro-2-deoxy-D-gluconate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositol3-MethyltransferaseActivity
  :annotation (goid "GO:0030740")
  :annotation (database "RHEA:18877")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)
    (owl-some hasProduct  ch/_1D-3-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1D-3-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA_adenosine-2'-O-_-methyltransferaseActivity
  :annotation (goid "GO:0030743")
  :annotation (database "RHEA:43212")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/adenosine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2'-O-methyladenosine_5'-monophosphate_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2'-O-methyladenosine_5'-monophosphate_1-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/adenosine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA_uridine_MethyltransferaseActivity
  :annotation (goid "GO:0016436")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/uridine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_3_-methyluridine_5'-monophosphate_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_3_-methyluridine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/uridine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNACytidylyltransferaseActivity
  :annotation (goid "GO:0016437")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CTP_4-_ ch/_3'-end_ribonucleotide_1-__residue ch/ATP_4-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/tRNA_3'-terminal_nucleotidyl-cytidyl-cytidyl-adenosine_4-__residue))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/tRNA_3'-terminal_nucleotidyl-cytidyl-cytidyl-adenosine_4-__residue)
    (owl-some hasProduct  ch/CTP_4-_ ch/_3'-end_ribonucleotide_1-__residue ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA-QueuosineBeta-MannosyltransferaseActivity
  :annotation (goid "GO:0016438")
  :annotation (database "RHEA:12885")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/tRNA_Asp_-queuosine)
    (owl-some hasProduct  ch/GDP_3-_ ch/O-5''-beta-D-mannosylqueuosine))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/O-5''-beta-D-mannosylqueuosine)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/tRNA_Asp_-queuosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMalateSynthaseActivity
  :annotation (goid "GO:0004474")
  :annotation (database "RHEA:18181")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/glyoxylate ch/water)
    (owl-some hasProduct  ch/_S_-malate_2-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_S_-malate_2-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/glyoxylate ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDi-Trans_Poly-Cis-DecaprenylcistransferaseActivity
  :annotation (goid "GO:0008834")
  :annotation (database "RHEA:27551")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/ditrans_polycis-undecaprenyl_diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/ditrans_polycis-undecaprenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMannose-1-PhosphateGuanylyltransferaseActivity
  :annotation (goid "GO:0004475")
  :annotation (database "RHEA:15229")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-mannose_1-phosphate_2-_ ch/GTP_4-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/GDP-alpha-D-mannose_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/GDP-alpha-D-mannose_2-_)
    (owl-some hasProduct  ch/alpha-D-mannose_1-phosphate_2-_ ch/GTP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethionineAdenosyltransferaseActivity
  :annotation (goid "GO:0004478")
  :annotation (database "RHEA:21080")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-methionine_zwitterion ch/water)
    (owl-some hasProduct  ch/hydrogenphosphate ch/diphosphate_3-_ ch/S-adenosyl-L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/diphosphate_3-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-methionine_zwitterion ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalysePolysaccharideO-MethyltransferaseActivity
  :annotation (goid "GO:0030734")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/maltooligosaccharide)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/oligosaccharide_containing_6-methyl-D-glucose_units))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/oligosaccharide_containing_6-methyl-D-glucose_units)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/maltooligosaccharide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLysineN-AcetyltransferaseActivity_ActingOnAcetylPhosphateAsDonor	
  :annotation (goid "GO:0004468")
  :annotation (database "RHEA:14417")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl_phosphate_2-_ ch/L-lysinium_1+_)
    (owl-some hasProduct  ch/hydrogenphosphate ch/N_6_-acetyl-L-lysine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/N_6_-acetyl-L-lysine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/acetyl_phosphate_2-_ ch/L-lysinium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFattyAcidO-MethyltransferaseActivity
  :annotation (goid "GO:0030733")
  :annotation (database "RHEA:23012")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/fatty_acid_anion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/fatty_acid_methyl_ester))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/fatty_acid_methyl_ester)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/fatty_acid_anion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyclopropane-Fatty-Acyl-PhospholipidSynthaseActivity
  :annotation (goid "GO:0008825")
  :annotation (database "RHEA:11988")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_1-acyl-2-__Z_-9_10-enoyl_-sn-glycero-3-phospholipid_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-acyl-2-_9_10-methyleneacyl_-sn-glycero-3-phospholipid_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-acyl-2-_9_10-methyleneacyl_-sn-glycero-3-phospholipid_1-_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_1-acyl-2-__Z_-9_10-enoyl_-sn-glycero-3-phospholipid_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhenolO-MethyltransferaseActivity
  :annotation (goid "GO:0030736")
  :annotation (database "RHEA:14809")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/phenol)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/anisole ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/anisole ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/phenol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarnosineN-MethyltransferaseActivity
  :annotation (goid "GO:0030735")
  :annotation (database "RHEA:14205")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/carnosine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/anserine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/anserine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/carnosine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTyramineN-MethyltransferaseActivity
  :annotation (goid "GO:0030738")
  :annotation (database "RHEA:14865")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/tyraminium)
    (owl-some hasProduct  ch/N-methyltyraminium ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-methyltyraminium ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/tyraminium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIodophenolO-MethyltransferaseActivity
  :annotation (goid "GO:0030737")
  :annotation (database "RHEA:14313")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-iodophenol ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_1-iodo-2-methoxybenzene ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1-iodo-2-methoxybenzene ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_2-iodophenol ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseO-DemethylpuromycinO-MethyltransferaseActivity
  :annotation (goid "GO:0030739")
  :annotation (database "RHEA:22280")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/O-demethylpuromycin_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/puromycin_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/puromycin_1+_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/O-demethylpuromycin_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethionineS-MethyltransferaseActivity
  :annotation (goid "GO:0030732")
  :annotation (database "RHEA:13761")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/S-methyl-L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/S-methyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGuanidinoacetateN-MethyltransferaseActivity
  :annotation (goid "GO:0030731")
  :annotation (database "RHEA:10656")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/guanidinoacetic_acid_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/creatine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/creatine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/guanidinoacetic_acid_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseS-Adenosyl-L-Methionine:BenzoicAcidCarboxylMethylTransferaseActivity
  :annotation (goid "GO:0080150")
  :annotation (database "RHEA:36099")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/benzoate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/methyl_benzoate ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/methyl_benzoate ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/benzoate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA_cytosine-5-_-methyltransferaseActivity
  :annotation (goid "GO:0016428")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_5-methylcytosine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_5-methylcytosine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA_adenine-N1-_-methyltransferaseActivity
  :annotation (goid "GO:0016429")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_N_1_-methyladenine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_N_1_-methyladenine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA_adenine-N6-_-methyltransferaseActivity
  :annotation (goid "GO:0016430")
  :annotation (database "RHEA:16785")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_N_6_-methyladenine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/tRNA_containing_N_6_-methyladenine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/transfer_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA-UridineAminocarboxypropyltransferaseActivity
  :annotation (goid "GO:0016432")
  :annotation (database "RHEA:12300")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/uridine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/_5'-S-methyl-5'-thioadenosine ch/_3-_3-amino-3-carboxypropyl_uridine_5'-phosphate_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/_5'-S-methyl-5'-thioadenosine ch/_3-_3-amino-3-carboxypropyl_uridine_5'-phosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/uridine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA-adenine-N1-_-methyltransferaseActivity
  :annotation (goid "GO:0106142")
  :annotation (database "RHEA:43792")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/adenosine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_1_-methyladenosine_5'-monophosphate_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_1_-methyladenosine_5'-monophosphate_1-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/adenosine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKetohexokinaseActivity
  :annotation (goid "GO:0004454")
  :annotation (database "RHEA:18145")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/beta-D-fructofuranose)
    (owl-some hasProduct  ch/ADP_3-_ ch/beta-D-fructofuranose_1-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/beta-D-fructofuranose_1-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/beta-D-fructofuranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChloramphenicolO-AcetyltransferaseActivity
  :annotation (goid "GO:0008811")
  :annotation (database "RHEA:18421")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/chloramphenicol ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/chloramphenicol_3-acetate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/chloramphenicol_3-acetate ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/chloramphenicol ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarbamateKinaseActivity
  :annotation (goid "GO:0008804")
  :annotation (database "RHEA:10152")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/ammonium ch/hydrogencarbonate)
    (owl-some hasProduct  ch/ADP_3-_ ch/carbamoyl_phosphate_2-_ ch/hydron ch/water))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/carbamoyl_phosphate_2-_ ch/hydron ch/water)
    (owl-some hasProduct  ch/ATP_4-_ ch/ammonium ch/hydrogencarbonate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAminoglycoside6-KinaseActivity
  :annotation (goid "GO:0050300")
  :annotation (database "RHEA:22268")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/streptomycin_3+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/streptomycin_6-phosphate_1+_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/streptomycin_6-phosphate_1+_)
    (owl-some hasProduct  ch/ATP_4-_ ch/streptomycin_3+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrimethylsulfonium-TetrahydrofolateN-MethyltransferaseActivity
  :annotation (goid "GO:0047147")
  :annotation (database "RHEA:13693")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/trimethylsulfonium)
    (owl-some hasProduct  ch/_5-methyltetrahydrofolate_2-_ ch/dimethyl_sulfide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_5-methyltetrahydrofolate_2-_ ch/dimethyl_sulfide ch/hydron)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/trimethylsulfonium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCardiolipinSynthaseActivity
  :annotation (goid "GO:0008808")
  :annotation (database "RHEA:31451")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_ ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_)
    (owl-some hasProduct  ch/cardiolipin_2-_ ch/glycerol))
   (owl-and
    (owl-some hasReactant  ch/cardiolipin_2-_ ch/glycerol)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_ ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSterigmatocystin7-O-MethyltransferaseActivity
  :annotation (goid "GO:0047146")
  :annotation (database "RHEA:15561")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sterigmatocystin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_8-O-methylsterigmatocystin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_8-O-methylsterigmatocystin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/sterigmatocystin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarboxyvinyl-CarboxyphosphonatePhosphorylmutaseActivity
  :annotation (goid "GO:0008807")
  :annotation (database "RHEA:14045")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-carboxylatovinyl_carboxylatophosphonate_3-_ ch/hydron)
    (owl-some hasProduct  ch/_3-_hydroxy_oxido_phosphoranyl_pyruvate_2-_ ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/_3-_hydroxy_oxido_phosphoranyl_pyruvate_2-_ ch/carbon_dioxide)
    (owl-some hasProduct  ch/_1-carboxylatovinyl_carboxylatophosphonate_3-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDemethylsterigmatocystin6-O-MethyltransferaseActivity
  :annotation (goid "GO:0047145")
  :annotation (database "RHEA:11504")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6-demethylsterigmatocystin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/sterigmatocystin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/sterigmatocystin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_6-demethylsterigmatocystin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Acylglycerol-3-PhosphateO-AcyltransferaseActivity
  :annotation (goid "GO:0047144")
  :annotation (database "RHEA:14233")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-acyl-sn-glycero-3-phosphate ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycerol_3-phosphate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycerol_3-phosphate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_2-acyl-sn-glycero-3-phosphate ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSucrose1f-FructosyltransferaseActivity
  :annotation (goid "GO:0050306")
  :annotation (database "RHEA:23312")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sucrose ch/sucrose)
    (owl-some hasProduct  ch/D-glucopyranose ch/_1-kestose))
   (owl-and
    (owl-some hasReactant  ch/D-glucopyranose ch/_1-kestose)
    (owl-some hasProduct  ch/sucrose ch/sucrose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMrna_2'-O-methyladenosine-N6-_-methyltransferaseActivity
  :annotation (goid "GO:0016422")
  :annotation (database "RHEA:22744")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-2'-O-methyladenosine_2-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-N_6_-methyl-2'-O-methyladenosine_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-N_6_-methyl-2'-O-methyladenosine_2-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-2'-O-methyladenosine_2-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChlorophenolO-MethyltransferaseActivity
  :annotation (goid "GO:0030790")
  :annotation (database "RHEA:18909")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_2_4_6-trichlorophenolate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2_4_6-trichloroanisole))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2_4_6-trichloroanisole)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_2_4_6-trichlorophenolate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Alanine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0004021")
  :annotation (database "RHEA:19453")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-alanine_zwitterion)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/pyruvate))
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/pyruvate)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-alanine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenylylsulfateKinaseActivity
  :annotation (goid "GO:0004020")
  :annotation (database "RHEA:24152")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5'-adenylyl_sulfate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5'-adenylyl_sulfate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFormateC-AcetyltransferaseActivity
  :annotation (goid "GO:0008861")
  :annotation (database "RHEA:11844")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/formate)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/pyruvate))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/pyruvate)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/formate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlcoholSulfotransferaseActivity
  :annotation (goid "GO:0004027")
  :annotation (database "RHEA:22552")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/alcohol)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/alkyl_sulfate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/alkyl_sulfate_1-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/alcohol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFructokinaseActivity
  :annotation (goid "GO:0008865")
  :annotation (database "RHEA:16125")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/beta-D-fructofuranose)
    (owl-some hasProduct  ch/ADP_3-_ ch/D-fructofuranose_6-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/D-fructofuranose_6-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/beta-D-fructofuranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlcoholO-AcetyltransferaseActivity
  :annotation (goid "GO:0004026")
  :annotation (database "RHEA:17229")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/alcohol)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/acetate_ester))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/acetate_ester)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/alcohol)))
  :enzyme Transferase)

(defcatalyse ToCatalysePrecorrin-3bC17-MethyltransferaseActivity
  :annotation (goid "GO:0030789")
  :annotation (database "RHEA:12761")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/precorrin-3B_6-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/precorrin-4_8-_ ch/hydron ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/precorrin-4_8-_ ch/hydron ch/hydron ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/precorrin-3B_6-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiaminobutyrateAcetyltransferaseActivity
  :annotation (goid "GO:0033816")
  :annotation (database "RHEA:16901")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-2_4-diazaniumylbutyrate ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N_4_-acetyl-L-2_4-diaminobutyric_acid_zwitterion ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N_4_-acetyl-L-2_4-diaminobutyric_acid_zwitterion ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/L-2_4-diazaniumylbutyrate ch/acetyl-CoA_4-_)))
  :enzyme Transferase)


(defcatalyse ToCatalyseNucleosideMonophosphateKinaseActivity
  :annotation (goid "GO:0050145")
  :annotation (database "RHEA:24036")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_ ch/nucleoside_5'-monophosphate_2-_)
    (owl-some hasProduct ch/ADP_3-_ ch/nucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_ ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct ch/ATP_4-_ ch/nucleoside_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThymidylateKinaseActivity
  :annotation (goid "GO:0004798")
  :annotation (database "RHEA:13517")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_ ch/dTMP_2-_)
    (owl-some hasProduct ch/ADP_3-_ ch/dTDP_3-_))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_ ch/dTDP_3-_)
    (owl-some hasProduct ch/ATP_4-_ ch/dTMP_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGuanylateKinaseActivity
  :annotation (goid "GO:0004385")
  :annotation (database "RHEA:20780")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/ATP_4-_	ch/guanosine_5'-monophosphate_2-_)
    (owl-some hasProduct ch/ADP_3-_	ch/GDP_3-_))
   (owl-and
    (owl-some hasReactant ch/ADP_3-_	ch/GDP_3-_)
    (owl-some hasProduct ch/ATP_4-_	ch/guanosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenylateKinaseActivity
  :annotation (goid "GO:0004017")
  :annotation (database "RHEA:12973")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/adenosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/ADP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/adenosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePrecorrin-2C20-MethyltransferaseActivity
  :annotation (goid "GO:0030788")
  :annotation (database "RHEA:16841")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/precorrin-2_7-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/precorrin-3A_7-_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/precorrin-3A_7-_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/precorrin-2_7-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBiphenylSynthaseActivity
  :annotation (goid "GO:0033815")
  :annotation (database "RHEA:22292")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/malonyl-CoA_5-_ ch/benzoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron ch/hydron)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/_3_5-dihydroxybiphenyl ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/_3_5-dihydroxybiphenyl ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide)
    (owl-some hasProduct  ch/malonyl-CoA_5-_ ch/benzoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePropanoyl-CoaC-AcyltransferaseActivity
  :annotation (goid "GO:0033814")
  :annotation (database "RHEA:16865")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/choloyl-CoA_4-_ ch/propionyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_3alpha_7alpha_12alpha-trihydroxy-24-oxo-5beta-cholestan-26-oyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_3alpha_7alpha_12alpha-trihydroxy-24-oxo-5beta-cholestan-26-oyl-CoA_4-_)
    (owl-some hasProduct  ch/choloyl-CoA_4-_ ch/propionyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeacetylcephalosporin-CAcetyltransferaseActivity
  :annotation (goid "GO:0033813")
  :annotation (database "RHEA:23860")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/deacetylcephalosporin_C_1-_)
    (owl-some hasProduct  ch/cephalosporin_C_1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/cephalosporin_C_1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/deacetylcephalosporin_C_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseViomycinKinaseActivity
  :annotation (goid "GO:0050394")
  :annotation (database "RHEA:20509")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/viomycin_3+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/O-phosphoviomycin_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/O-phosphoviomycin_1+_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/viomycin_3+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipoyl_Octanoyl_TransferaseActivity
  :annotation (goid "GO:0033819")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/octanoyl-_acyl-carrier_protein_ ch/protein)
    (owl-some hasProduct  ch/Protein_N6-_octanoyl_lysine ch/holo-_acyl-carrier_protein_))
   (owl-and
    (owl-some hasReactant  ch/Protein_N6-_octanoyl_lysine ch/holo-_acyl-carrier_protein_)
    (owl-some hasProduct  ch/octanoyl-_acyl-carrier_protein_ ch/protein)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBeta-Ketoacyl-Acyl-Carrier-ProteinSynthaseIiiActivity
  :annotation (goid "GO:0033818")
  :annotation (database "RHEA:12080")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/O-_S-malonylpantetheine-4'-phosphoryl_serine_2-__residue	 ch/hydron)
    (owl-some hasProduct  ch/O-_S-acetoacetylpantetheine-4'-phosphoryl_serine_1-__residue ch/coenzyme_A_4-_ ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/O-_S-acetoacetylpantetheine-4'-phosphoryl_serine_1-__residue ch/coenzyme_A_4-_ ch/carbon_dioxide)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/O-_S-malonylpantetheine-4'-phosphoryl_serine_2-__residue	 ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBeta-Ketoacyl-Acyl-Carrier-ProteinSynthaseIiActivity
  :annotation (goid "GO:0033817")
  :annotation (database "RHEA:14565")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-_S-_11Z_27Z-hexatetracontadienoylpantetheine_-4'-phosphoryl_-L-serine_1-__residue ch/O-_S-malonylpantetheine-4'-phosphoryl_serine_2-__residue	 ch/hydron)
    (owl-some hasProduct  ch/O-_S-_13Z_-3-oxooctadecenoylpantetheine-4'-phosphoryl_serine_1-__residue ch/carbon_dioxide ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/O-_S-_13Z_-3-oxooctadecenoylpantetheine-4'-phosphoryl_serine_1-__residue ch/carbon_dioxide ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue)
    (owl-some hasProduct  ch/O-_S-_11Z_27Z-hexatetracontadienoylpantetheine_-4'-phosphoryl_-L-serine_1-__residue ch/O-_S-malonylpantetheine-4'-phosphoryl_serine_2-__residue	 ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseVitexinBeta-GlucosyltransferaseActivity
  :annotation (goid "GO:0050395")
  :annotation (database "RHEA:21956")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/vitexin-7-olate)
    (owl-some hasProduct  ch/hydron ch/UDP_3-_ ch/vitexin_2''-O-beta-D-glucoside_1-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/UDP_3-_ ch/vitexin_2''-O-beta-D-glucoside_1-_)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/vitexin-7-olate)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6-O-Methylnorlaudanosoline5'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030781")
  :annotation (database "RHEA:11892")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_6-O-methylnorlaudanosolinium)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/nororientalinium_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/nororientalinium_1+_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_6-O-methylnorlaudanosolinium)))
  :enzyme Transferase)

(defcatalyse ToCatalyse12-Hydroxydihydrochelirubine12-O-MethyltransferaseActivity
  :annotation (goid "GO:0030780")
  :annotation (database "RHEA:21092")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_12-hydroxydihydrochelirubine ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/dihydromacarpine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/dihydromacarpine ch/hydron)
    (owl-some hasProduct  ch/_12-hydroxydihydrochelirubine ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_S_-tetrahydroprotoberberineN-MethyltransferaseActivity
  :annotation (goid "GO:0030782")
  :annotation (database "RHEA:12805")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/alpha-berbine)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/cis-N-methyl-alpha-berbine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/cis-N-methyl-alpha-berbine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/alpha-berbine)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Oxoadipyl-CoaThiolaseActivity
  :annotation (goid "GO:0033812")
  :annotation (database "RHEA:19481")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/succinyl-CoA_5-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_3-oxoadipyl-CoA_5-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_3-oxoadipyl-CoA_5-_)
    (owl-some hasProduct  ch/succinyl-CoA_5-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3'-Hydroxy-N-Methyl-_S_-Coclaurine4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030784")
  :annotation (database "RHEA:17789")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_S_-3'-hydroxy-N-methylcoclaurinium_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_S_-reticulinium_1+_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_S_-reticulinium_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_S_-3'-hydroxy-N-methylcoclaurinium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-TriglucosideO-CoumaroyltransferaseActivity
  :annotation (goid "GO:0033811")
  :annotation (database "RHEA:22160")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-coumaroyl-CoA_4-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/flavonol_3-O-_6-_4-coumaroyl_-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside_s))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/flavonol_3-O-_6-_4-coumaroyl_-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside_s)
    (owl-some hasProduct  ch/_4-coumaroyl-CoA_4-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositol4-MethyltransferaseActivity
  :annotation (goid "GO:0030787")
  :annotation (database "RHEA:23248")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)
    (owl-some hasProduct  ch/_1D-4-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1D-4-O-methyl-myo-inositol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthocyanin5-O-Glucoside6_-O-MalonyltransferaseActivity
  :annotation (goid "GO:0033810")
  :annotation (database "RHEA:21988")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/malonyl-CoA_5-_ ch/pelargonidin_3-O-_6-O-caffeoyl-beta-D-glucoside__5-O-beta-D-glucoside_betaine)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_4'''-demalonylsalvianin))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_4'''-demalonylsalvianin)
    (owl-some hasProduct  ch/malonyl-CoA_5-_ ch/pelargonidin_3-O-_6-O-caffeoyl-beta-D-glucoside__5-O-beta-D-glucoside_betaine)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_RS_-norcoclaurine6-O-MethyltransferaseActivity
  :annotation (goid "GO:0030786")
  :annotation (database "RHEA:19941")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_RS_-norcoclaurinium)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_RS_-coclaurinium ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_RS_-coclaurinium ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_RS_-norcoclaurinium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosideO-AcetyltransferaseActivity
  :annotation (goid "GO:0008870")
  :annotation (database "RHEA:15713")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/beta-D-galactoside)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_6-O-acetyl-beta-D-galactoside))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_6-O-acetyl-beta-D-galactoside)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/beta-D-galactoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAminoglycoside2_-NucleotidyltransferaseActivity
  :annotation (goid "GO:0008871")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/gentamycin)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_2''-nucleotidylgentamycin))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_2''-nucleotidylgentamycin)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/gentamycin)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucose-1-PhosphateAdenylyltransferaseActivity
  :annotation (goid "GO:0008878")
  :annotation (database "RHEA:12120")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose_1-phosphate_2-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/ADP_alpha-D-glucoside_2-_ ch/diphosphate_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_alpha-D-glucoside_2-_ ch/diphosphate_3-_ ch/hydron)
    (owl-some hasProduct  ch/alpha-D-glucose_1-phosphate_2-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseColumbamineO-MethyltransferaseActivity
  :annotation (goid "GO:0030778")
  :annotation (database "RHEA:15373")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/columbamine)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/palmatine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/palmatine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/columbamine)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_S_-scoulerine9-O-MethyltransferaseActivity
  :annotation (goid "GO:0030777")
  :annotation (database "RHEA:23808")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_S_-scoulerine ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_S_-tetrahydrocolumbamine ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_S_-tetrahydrocolumbamine ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_S_-scoulerine ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKaempferol4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0033803")
  :annotation (database "RHEA:15105")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/kaempferol_oxoanion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/kaempferide_1-_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/kaempferide_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/kaempferol_oxoanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse10-Hydroxydihydrosanguinarine10-O-MethyltransferaseActivity
  :annotation (goid "GO:0030779")
  :annotation (database "RHEA:18541")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_10-hydroxydihydrosanguinarine ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/dihydrochelirubine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/dihydrochelirubine ch/hydron)
    (owl-some hasProduct  ch/_10-hydroxydihydrosanguinarine ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoliquiritigenin2'-O-MethyltransferaseActivity
  :annotation (goid "GO:0033802")
  :annotation (database "RHEA:21608")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/isoliquiritigenin_1-_)
    (owl-some hasProduct  ch/_2'-O-methylisoliquiritigenin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2'-O-methylisoliquiritigenin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/isoliquiritigenin_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthocyanin6_-O-MalonyltransferaseActivity
  :annotation (goid "GO:0033809")
  :annotation (database "RHEA:16025")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/malonyl-CoA_5-_ ch/anthocyanidin_3-O-beta-D-glucoside)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/anthocyanidin_3-O-_6-O-malonyl-beta-D-glucoside__betaine))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/anthocyanidin_3-O-_6-O-malonyl-beta-D-glucoside__betaine)
    (owl-some hasProduct  ch/malonyl-CoA_5-_ ch/anthocyanidin_3-O-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6'-DeoxychalconeSynthaseActivity
  :annotation (goid "GO:0033808")
  :annotation (database "RHEA:10584")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/_4-coumaroyl-CoA_4-_ ch/NADPH_4-_ ch/hydron ch/hydron ch/hydron)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/isoliquiritigenin_1-_ ch/carbon_dioxide ch/NADP_3-_ ch/water ch/carbon_dioxide ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/isoliquiritigenin_1-_ ch/carbon_dioxide ch/NADP_3-_ ch/water ch/carbon_dioxide ch/carbon_dioxide)
    (owl-some hasProduct  ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/_4-coumaroyl-CoA_4-_ ch/NADPH_4-_ ch/hydron ch/hydron ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistone-GlutamineMethyltransferaseActivity
  :annotation (goid "GO:1990259")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamine_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_5_-methyl-L-glutamine_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_5_-methyl-L-glutamine_residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIcosanoyl-CoaSynthaseActivity
  :annotation (goid "GO:0033807")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/stearoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/NADPH_4-_ ch/NADPH_4-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/icosanoyl-CoA_4-_ ch/carbon_dioxide ch/NADP_3-_ ch/NADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/icosanoyl-CoA_4-_ ch/carbon_dioxide ch/NADP_3-_ ch/NADP_3-_)
    (owl-some hasProduct  ch/stearoyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/NADPH_4-_ ch/NADPH_4-_ ch/hydron ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFluorothreonineTransaldolaseActivity
  :annotation (goid "GO:0033806")
  :annotation (database "RHEA:11748")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-threonine_zwitterion ch/fluoroacetaldehyde)
    (owl-some hasProduct  ch/acetaldehyde ch/_4-fluoro-L-threonine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/acetaldehyde ch/_4-fluoro-L-threonine_zwitterion)
    (owl-some hasProduct  ch/L-threonine_zwitterion ch/fluoroacetaldehyde)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDemethylmacrocinO-MethyltransferaseActivity
  :annotation (goid "GO:0030770")
  :annotation (database "RHEA:17573")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/demethylmacrocin_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/macrocin_1+_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/macrocin_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/demethylmacrocin_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTryptophan2-C-MethyltransferaseActivity
  :annotation (goid "GO:0030772")
  :annotation (database "RHEA:17321")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-tryptophan_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-methyl-L-tryptophan_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-methyl-L-tryptophan_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-tryptophan_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-Benzoyl-4-Hydroxyanthranilate4-O-MethyltransferaseActivity
  :annotation (goid "GO:0030771")
  :annotation (database "RHEA:17405")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-benzoyl-4-hydroxyanthranilate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/N-benzoyl-4-methoxyanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-benzoyl-4-methoxyanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/N-benzoyl-4-hydroxyanthranilate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthranilateN-MethyltransferaseActivity
  :annotation (goid "GO:0030774")
  :annotation (database "RHEA:12180")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/anthranilate)
    (owl-some hasProduct  ch/N-methylanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-methylanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/anthranilate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseVitexin2_-O-Rhamnoside7-O-MethyltransferaseActivity
  :annotation (goid "GO:0033801")
  :annotation (database "RHEA:11432")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/vitexin_2''-O-beta-L-rhamnoside_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_7-O-methylvitexin_2''-O-beta-L-rhamnoside_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_7-O-methylvitexin_2''-O-beta-L-rhamnoside_1-_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/vitexin_2''-O-beta-L-rhamnoside_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6-HydroxymelleinO-MethyltransferaseActivity
  :annotation (goid "GO:0030773")
  :annotation (database "RHEA:15201")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6-hydroxymellein ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_6-methoxymellein ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_6-methoxymellein ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_6-hydroxymellein ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoflavone7-O-MethyltransferaseActivity
  :annotation (goid "GO:0033800")
  :annotation (database "RHEA:17933")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_7-hydroxyisoflavones)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_7-methoxyisoflavones ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_7-methoxyisoflavones ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_7-hydroxyisoflavones)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_RS_-1-benzyl-1_2_3_4-tetrahydroisoquinolineN-MethyltransferaseActivity
  :annotation (goid "GO:0030776")
  :annotation (database "RHEA:13005")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_1-benzyl-1_2_3_4-tetrahydroisoquinolin-2-ium)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-benzyl-2-methyl-1_2_3_4-tetrahydroisoquinolinium ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-benzyl-2-methyl-1_2_3_4-tetrahydroisoquinolinium ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_1-benzyl-1_2_3_4-tetrahydroisoquinolin-2-ium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucuronoxylan4-O-MethyltransferaseActivity
  :annotation (goid "GO:0030775")
  :annotation (database "RHEA:20413")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/glucuronoxylan_D-glucuronate_polyanion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/glucuronoxylan_4-O-methyl-D-glucuronate_polyanion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/glucuronoxylan_4-O-methyl-D-glucuronate_polyanion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/glucuronoxylan_D-glucuronate_polyanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylene-Fatty-Acyl-PhospholipidSynthaseActivity
  :annotation (goid "GO:0004481")
  :annotation (database "RHEA:17549")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_1-acyl-2-__Z_-9_10-enoyl_-sn-glycero-3-phospholipid_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-acyl-2-_10-methylenealkanoyl_-sn-3-glycerophospholipid ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1-acyl-2-_10-methylenealkanoyl_-sn-3-glycerophospholipid ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_1-acyl-2-__Z_-9_10-enoyl_-sn-glycero-3-phospholipid_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMrna_nucleoside-2'-O-_-methyltransferaseActivity
  :annotation (goid "GO:0004483")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_purine-ribonucleotide__2-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_2'-O-methyl-purine-ribonucleotide__2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_2'-O-methyl-purine-ribonucleotide__2-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_purine-ribonucleotide__2-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMrna_guanine-N7-_-methyltransferaseActivity
  :annotation (goid "GO:0004482")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_5'-triphosphoguanosine_-_purine-ribonucleotide__3-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_purine-ribonucleotide__2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5'-_N_7_-methyl_5'-triphosphoguanosine_-_purine-ribonucleotide__2-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_5'-_5'-triphosphoguanosine_-_purine-ribonucleotide__3-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenosineKinaseActivity
  :annotation (goid "GO:0004001")
  :annotation (database "RHEA:20824")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/adenosine)
    (owl-some hasProduct  ch/ADP_3-_ ch/adenosine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/adenosine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/adenosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMrnaGuanylyltransferaseActivity
  :annotation (goid "GO:0004484")
  :annotation (database "RHEA:54592")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/_5'-end_purine_ribonucleotide_5'-diphosphate_3-__residue	 ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_5'-_5'-triphosphoguanosine_-_purine-ribonucleotide__3-__residue))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_5'-_5'-triphosphoguanosine_-_purine-ribonucleotide__3-__residue)
    (owl-some hasProduct  ch/GTP_4-_ ch/_5'-end_purine_ribonucleotide_5'-diphosphate_3-__residue	 ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyclin-DependentProteinKinaseActivity
  :annotation (goid "GO:0097472")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-alpha-amino_acid_residue ch/ATP_4-_)
    (owl-some hasProduct  ch/O-phosphoamino_acid ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/O-phosphoamino_acid ch/ADP_3-_)
    (owl-some hasProduct  ch/L-alpha-amino_acid_residue ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiphosphate-PurineNucleosideKinaseActivity
  :annotation (goid "GO:0008842")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/nebularine)
    (owl-some hasProduct  ch/phosphate_3-_ ch/_6-deoxyinosine_5'-phosphate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/phosphate_3-_ ch/_6-deoxyinosine_5'-phosphate ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/nebularine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistoneMethyltransferaseActivity_H4-K20Specific_	
  :annotation (goid "GO:0042799")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-lysinium_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_6_-methyl-L-lysinium_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_6_-methyl-L-lysinium_residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-lysinium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Hydroxyanthranilate4-C-MethyltransferaseActivity
  :annotation (goid "GO:0030767")
  :annotation (database "RHEA:17833")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxyanthranilate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3-hydroxy-4-methylanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxy-4-methylanthranilate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_3-hydroxyanthranilate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethionyl-tRNAFormyltransferaseActivity
  :annotation (goid "GO:0004479")
  :annotation (database "RHEA:24380")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_10-formyltetrahydrofolate_2-_ ch/_3'-_L-methionyl_adenylyl_zwitterionic_group)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_3'-_N-formyl-L-methionyl_adenylyl_1-__group ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_3'-_N-formyl-L-methionyl_adenylyl_1-__group ch/hydron)
    (owl-some hasProduct  ch/_10-formyltetrahydrofolate_2-_ ch/_3'-_L-methionyl_adenylyl_zwitterionic_group)))
  :enzyme Transferase)

(defcatalyse ToCatalyse11-O-Demethyl-17-O-DeacetylvindolineO-MethyltransferaseActivity
  :annotation (goid "GO:0030766")
  :annotation (database "RHEA:20992")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_11-O-demethyl-17-O-deacetylvindoline)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_17-O-deacetylvindoline))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_17-O-deacetylvindoline)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_11-O-demethyl-17-O-deacetylvindoline)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMacrocinO-MethyltransferaseActivity
  :annotation (goid "GO:0030769")
  :annotation (database "RHEA:17269")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/macrocin_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/tylosin_1+_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/tylosin_1+_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/macrocin_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse16-Methoxy-2_3-Dihydro-3-HydroxytabersonineN-MethyltransferaseActivity
  :annotation (goid "GO:0030768")
  :annotation (database "RHEA:11336")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxy-16-methoxy-2_3-dihydrotabersoninium ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/deacetoxyvindolinium_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/deacetoxyvindolinium_1+_ ch/hydron)
    (owl-some hasProduct  ch/_3-hydroxy-16-methoxy-2_3-dihydrotabersoninium ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMono-OleinTransacylationActivity
  :annotation (goid "GO:0051264")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/monooleoylglycerol ch/monooleoylglycerol)
    (owl-some hasProduct  ch/dioleoylglycerol ch/glycerol))
   (owl-and
    (owl-some hasReactant  ch/dioleoylglycerol ch/glycerol)
    (owl-some hasProduct  ch/monooleoylglycerol ch/monooleoylglycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDioleinTransacylationActivity
  :annotation (goid "GO:0051265")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/dioleoylglycerol ch/monooleoylglycerol)
    (owl-some hasProduct  ch/triolein ch/glycerol))
   (owl-and
    (owl-some hasReactant  ch/triolein ch/glycerol)
    (owl-some hasProduct  ch/dioleoylglycerol ch/monooleoylglycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyse8-Hydroxyquercitin8-O-MethyltransferaseActivity
  :annotation (goid "GO:0030761")
  :annotation (database "RHEA:16593")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/gossypetin_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_4'_5_7-pentahydroxy-8-methoxyflavon-3-olate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5_7-pentahydroxy-8-methoxyflavon-3-olate ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/gossypetin_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridineN-MethyltransferaseActivity
  :annotation (goid "GO:0030760")
  :annotation (database "RHEA:16893")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/pyridine)
    (owl-some hasProduct  ch/N-methylpyridinium ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/N-methylpyridinium ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/pyridine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsobutyraldoximeO-MethyltransferaseActivity
  :annotation (goid "GO:0030763")
  :annotation (database "RHEA:10996")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-methylpropanal_oxime ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_2-methylpropanal_O-methyloxime ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2-methylpropanal_O-methyloxime ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_2-methylpropanal_oxime ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolTetrakisphosphate2-KinaseActivity
  :annotation (goid "GO:0032942")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_1_3_4_6-tetrakisphosphate ch/ATP_4-_)
    (owl-some hasProduct  ch/myo-inositol_pentakisphosphate ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_pentakisphosphate ch/ADP_3-_)
    (owl-some hasProduct  ch/myo-inositol_1_3_4_6-tetrakisphosphate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTetrahydrocolumbamine2-O-MethyltransferaseActivity
  :annotation (goid "GO:0030762")
  :annotation (database "RHEA:22536")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_S_-tetrahydrocolumbamine ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/tetrahydropalmatine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/tetrahydropalmatine)
    (owl-some hasProduct  ch/_S_-tetrahydrocolumbamine ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHeparanSulfateN-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0042328")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/heparan_sulfate)
    (owl-some hasProduct  ch/UDP_3-_ ch/heparan_sulfate_N-acetyl-alpha-D-glucosaminide_polyanion))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/heparan_sulfate_N-acetyl-alpha-D-glucosaminide_polyanion)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/heparan_sulfate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMevalonateKinaseActivity
  :annotation (goid "GO:0004496")
  :annotation (database "RHEA:17065")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_R_-mevalonate ch/ATP_4-_)
    (owl-some hasProduct  ch/_R_-5-phosphonatomevalonate_3-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_R_-5-phosphonatomevalonate_3-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_R_-mevalonate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-ArabinokinaseActivity
  :annotation (goid "GO:0009702")
  :annotation (database "RHEA:20153")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-arabinopyranose ch/ATP_4-_)
    (owl-some hasProduct  ch/beta-L-arabinose_1-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/beta-L-arabinose_1-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/L-arabinopyranose ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenosylmethionine-8-Amino-7-OxononanoateTransaminaseActivity
  :annotation (goid "GO:0004015")
  :annotation (database "RHEA:16861")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_8-amino-7-oxononanoic_acid_zwitterion ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_7_8-diaminononanoate_cation ch/S-adenosyl-4-methylthio-2-oxobutanoate))
   (owl-and
    (owl-some hasReactant  ch/_7_8-diaminononanoate_cation ch/S-adenosyl-4-methylthio-2-oxobutanoate)
    (owl-some hasProduct  ch/_8-amino-7-oxononanoic_acid_zwitterion ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoorientin3'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030756")
  :annotation (database "RHEA:24096")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/isoorientin_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/isoscoparin-7-olate))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/isoscoparin-7-olate)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/isoorientin_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetin3-O-MethyltransferaseActivity
  :annotation (goid "GO:0030755")
  :annotation (database "RHEA:17673")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/quercetin-7-olate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_3'_4'_5-trihydroxy-3-methoxyflavon-7-olate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_3'_4'_5-trihydroxy-3-methoxyflavon-7-olate ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/quercetin-7-olate)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3_7-Dimethylquercitin4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030758")
  :annotation (database "RHEA:21832")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_5-dihydroxy-3_4'_7-trimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_5-dihydroxy-3_4'_7-trimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Methylquercitin7-O-MethyltransferaseActivity
  :annotation (goid "GO:0030757")
  :annotation (database "RHEA:16181")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5-trihydroxy-3-methoxyflavon-7-olate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_3'_4'_5-trihydroxy-3-methoxyflavon-7-olate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylquercetagetin6-O-MethyltransferaseActivity
  :annotation (goid "GO:0030759")
  :annotation (database "RHEA:18717")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5_6-tetrahydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_4'_5-trihydroxy-3_6_7-trimethoxyflavone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5-trihydroxy-3_6_7-trimethoxyflavone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_3'_4'_5_6-tetrahydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysePutrescineN-MethyltransferaseActivity
  :annotation (goid "GO:0030750")
  :annotation (database "RHEA:15037")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_1_4-butanediammonium)
    (owl-some hasProduct  ch/N-methylputrescinium_2+_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-methylputrescinium_2+_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_1_4-butanediammonium)))
  :enzyme Transferase)

(defcatalyse ToCatalyse5-Hydroxyfuranocoumarin5-O-MethyltransferaseActivity
  :annotation (goid "GO:0030752")
  :annotation (database "RHEA:11808")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/bergaptol_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-methoxypsoralen))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-methoxypsoralen)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/bergaptol_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistoneAcetyltransferaseActivity_H3-K56Specific_	
  :annotation (goid "GO:0032931")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/L-lysinium_residue)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/L-lysinium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLicodione2'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030751")
  :annotation (database "RHEA:18521")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/licodione_1-_)
    (owl-some hasProduct  ch/_2'-O-methyllicodione_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2'-O-methyllicodione_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/licodione_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseApigenin4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0030754")
  :annotation (database "RHEA:20429")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/apigenin-7-olate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-hydroxy-2-_4-methoxyphenyl_-4-oxo-4H-chromen-7-olate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-hydroxy-2-_4-methoxyphenyl_-4-oxo-4H-chromen-7-olate ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/apigenin-7-olate)))
  :enzyme Transferase)

(defcatalyse ToCatalyse8-Hydroxyfuranocoumarin8-O-MethyltransferaseActivity
  :annotation (goid "GO:0030753")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_8-hydroxyfurocoumarin)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_8-methoxyfurocoumarin ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_8-methoxyfurocoumarin ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_8-hydroxyfurocoumarin)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNadhKinaseActivity
  :annotation (goid "GO:0042736")
  :annotation (database "RHEA:12260")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/NADH_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/NADPH_4-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/NADPH_4-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/NADH_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArylamineN-AcetyltransferaseActivity
  :annotation (goid "GO:0004060")
  :annotation (database "RHEA:16613")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/aniline)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-phenylacetamide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-phenylacetamide)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/aniline)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArylSulfotransferaseActivity
  :annotation (goid "GO:0004062")
  :annotation (database "RHEA:12164")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/phenols)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/phenyl_sulfate_oxoanion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/phenyl_sulfate_oxoanion ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/phenols)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Aspartate:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0004069")
  :annotation (database "RHEA:21824")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-aspartate_1-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/oxaloacetate_2-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/oxaloacetate_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-aspartate_1-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Polyprenyl-6-Methoxy-1_4-BenzoquinoneMethyltransferaseActivity
  :annotation (goid "GO:0008425")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-Polyprenyl-6-methoxy-1_4-benzoquinone ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_2-Polyprenyl-3-methyl-6-methoxy-1_4-benzoquinone ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_2-Polyprenyl-3-methyl-6-methoxy-1_4-benzoquinone ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/_2-Polyprenyl-6-methoxy-1_4-benzoquinone ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCysteine-S-ConjugateN-AcetyltransferaseActivity
  :annotation (goid "GO:0047198")
  :annotation (database "RHEA:19213")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-substituted_L-cysteine_zwitterion ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/S-substituted_N-acetyl-L-cysteinate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-substituted_N-acetyl-L-cysteinate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/S-substituted_L-cysteine_zwitterion ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrans-PentaprenyltranstransferaseActivity
  :annotation (goid "GO:0048045")
  :annotation (database "RHEA:22632")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/all-trans-pentaprenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-hexaprenyl_diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/all-trans-hexaprenyl_diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-pentaprenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTriokinaseActivity
  :annotation (goid "GO:0050354")
  :annotation (database "RHEA:13941")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glyceraldehyde ch/ATP_4-_)
    (owl-some hasProduct  ch/D-glyceraldehyde_3-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/D-glyceraldehyde_3-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-glyceraldehyde ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-4-Amino-4-Deoxy-L-ArabinoseAminotransferase	
  :annotation (goid "GO:0099620")
  :annotation (database "RHEA:24710")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-4-amino-4-deoxy-beta-L-arabinopyranose_1-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/UDP-beta-L-threo-pentopyranos-4-ulose_2-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP-beta-L-threo-pentopyranos-4-ulose_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/UDP-4-amino-4-deoxy-beta-L-arabinopyranose_1-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTriglyceride-SterolO-AcyltransferaseActivity
  :annotation (goid "GO:0047197")
  :annotation (database "RHEA:16897")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3beta-hydroxy_steroid ch/triacyl-sn-glycerol)
    (owl-some hasProduct  ch/_3beta-hydroxysterol_ester ch/diglyceride))
   (owl-and
    (owl-some hasReactant  ch/_3beta-hydroxysterol_ester ch/diglyceride)
    (owl-some hasProduct  ch/_3beta-hydroxy_steroid ch/triacyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUndecaprenyl-Phosphate4-Deoxy-4-Formamido-L-ArabinoseTransferaseActivity
  :annotation (goid "GO:0099621")
  :annotation (database "RHEA:27722")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-4-deoxy-4-formamido-beta-L-arabinopyranose_2-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/_4-deoxy-4-formamido-alpha-L-arabinopyranosyl_ditrans_polycis-undecaprenyl_phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/_4-deoxy-4-formamido-alpha-L-arabinopyranosyl_ditrans_polycis-undecaprenyl_phosphate_1-_)
    (owl-some hasProduct  ch/UDP-4-deoxy-4-formamido-beta-L-arabinopyranose_2-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylgalactosamineKinaseActivity
  :annotation (goid "GO:0033858")
  :annotation (database "RHEA:12617")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N-acetyl-alpha-D-galactosamine)
    (owl-some hasProduct  ch/ADP_3-_ ch/N-acetyl-alpha-D-galactosamine_1-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/N-acetyl-alpha-D-galactosamine_1-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/N-acetyl-alpha-D-galactosamine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLong-Chain-AlcoholO-Fatty-AcyltransferaseActivity
  :annotation (goid "GO:0047196")
  :annotation (database "RHEA:38443")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/long-chain_fatty_alcohol ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/wax_ester ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/wax_ester ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/long-chain_fatty_alcohol ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiphosphoinositol-PentakisphosphateKinaseActivity
  :annotation (goid "GO:0033857")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_ ch/hydron)
    (owl-some hasProduct  ch/ADP_3-_ ch/_1_5-bis_diphospho_-1D-myo-inositol_2_3_4_6-tetrakisphosphate_13-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_1_5-bis_diphospho_-1D-myo-inositol_2_3_4_6-tetrakisphosphate_13-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiacylglycerol-SterolO-AcyltransferaseActivity
  :annotation (goid "GO:0047195")
  :annotation (database "RHEA:13301")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sterol ch/_1_2-diacyl-sn-glycerol)
    (owl-some hasProduct  ch/sterol_ester ch/_1-acyl-sn-glycerol))
   (owl-and
    (owl-some hasReactant  ch/sterol_ester ch/_1-acyl-sn-glycerol)
    (owl-some hasProduct  ch/sterol ch/_1_2-diacyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrihydroxystilbeneSynthaseActivity
  :annotation (goid "GO:0050350")
  :annotation (database "RHEA:11936")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/malonyl-CoA_5-_ ch/_4-coumaroyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/trans-resveratrol ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/trans-resveratrol ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide ch/carbon_dioxide)
    (owl-some hasProduct  ch/malonyl-CoA_5-_ ch/_4-coumaroyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphatidylcholine-DolicholO-AcyltransferaseActivity
  :annotation (goid "GO:0047199")
  :annotation (database "RHEA:19285")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/dolichol)
    (owl-some hasProduct  ch/_1-O-acyl-sn-glycero-3-phosphocholine ch/acyldolichol))
   (owl-and
    (owl-some hasReactant  ch/_1-O-acyl-sn-glycero-3-phosphocholine ch/acyldolichol)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/dolichol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThyroid-HormoneTransaminaseActivity
  :annotation (goid "GO:0033852")
  :annotation (database "RHEA:19133")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/_3_3'_5-triiodo-L-thyronine_zwitterion)
    (owl-some hasProduct  ch/_3_5_3'-triiodothyropyruvate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3_5_3'-triiodothyropyruvate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/_3_3'_5-triiodo-L-thyronine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-AcylglycerophosphocholineO-AcyltransferaseActivity
  :annotation (goid "GO:0047190")
  :annotation (database "RHEA:10332")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-acyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_2-acyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLavandulylDiphosphateSynthaseActivity
  :annotation (goid "GO:0033851")
  :annotation (database "RHEA:21676")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/prenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_R_-lavandulyl_diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_R_-lavandulyl_diphosphate_3-_)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/prenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseZ-FarnesylDiphosphateSynthaseActivity
  :annotation (goid "GO:0033850")
  :annotation (database "RHEA:23300")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/geranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_2-cis_6-trans-farnesyl_diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2-cis_6-trans-farnesyl_diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/geranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridoxine5'-PhosphateSynthaseActivity
  :annotation (goid "GO:0033856")
  :annotation (database "RHEA:15265")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-deoxy-D-xylulose_5-phosphate_2-_ ch/_3-ammonio-2-oxopropyl_phosphate_1-_)
    (owl-some hasProduct  ch/water ch/hydron ch/hydrogenphosphate ch/pyridoxine_5'-phosphate_2-_ ch/water))
   (owl-and
    (owl-some hasReactant  ch/water ch/hydron ch/hydrogenphosphate ch/pyridoxine_5'-phosphate_2-_ ch/water)
    (owl-some hasProduct  ch/_1-deoxy-D-xylulose_5-phosphate_2-_ ch/_3-ammonio-2-oxopropyl_phosphate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIndoleacetylglucose-InositolO-AcyltransferaseActivity
  :annotation (goid "GO:0047194")
  :annotation (database "RHEA:21180")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-O-_indol-3-ylacetyl_-beta-D-glucose ch/myo-inositol)
    (owl-some hasProduct  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/D-glucopyranose))
   (owl-and
    (owl-some hasReactant  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/D-glucopyranose)
    (owl-some hasProduct  ch/_1-O-_indol-3-ylacetyl_-beta-D-glucose ch/myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotianamineAminotransferaseActivity
  :annotation (goid "GO:0033855")
  :annotation (database "RHEA:22104")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/_S_S_S_-nicotianamine_trizwitterion)
    (owl-some hasProduct  ch/_3''-deamino-3''-oxonicotianaminium_1-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3''-deamino-3''-oxonicotianaminium_1-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/_S_S_S_-nicotianamine_trizwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutamate-PrephenateAminotransferaseActivity
  :annotation (goid "GO:0033854")
  :annotation (database "RHEA:22880")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-arogenate_1-_)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/_1s_4s_-prephenate_2-_))
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/_1s_4s_-prephenate_2-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-arogenate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-AlkylglycerophosphocholineO-AcetyltransferaseActivity
  :annotation (goid "GO:0047192")
  :annotation (database "RHEA:18461")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAspartate-PrephenateAminotransferaseActivity
  :annotation (goid "GO:0033853")
  :annotation (database "RHEA:20445")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-arogenate_1-_ ch/oxaloacetate_2-_)
    (owl-some hasProduct  ch/_1s_4s_-prephenate_2-_ ch/L-aspartate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_1s_4s_-prephenate_2-_ ch/L-aspartate_1-_)
    (owl-some hasProduct  ch/L-arogenate_1-_ ch/oxaloacetate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-AlkylglycerophosphocholineO-AcyltransferaseActivity
  :annotation (goid "GO:0047191")
  :annotation (database "RHEA:23992")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)
    (owl-some hasProduct  ch/_2-acyl-1-alkyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_2-acyl-1-alkyl-sn-glycero-3-phosphocholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_1-alkyl-sn-glycero-3-phosphocholine ch/acyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAspartateCarbamoyltransferaseActivity
  :annotation (goid "GO:0004070")
  :annotation (database "RHEA:20013")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-aspartate_1-_ ch/carbamoyl_phosphate_2-_)
    (owl-some hasProduct  ch/N-carbamoyl-L-aspartate_2-_ ch/hydron ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/N-carbamoyl-L-aspartate_2-_ ch/hydron ch/hydrogenphosphate)
    (owl-some hasProduct  ch/L-aspartate_1-_ ch/carbamoyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAspartateKinaseActivity
  :annotation (goid "GO:0004072")
  :annotation (database "RHEA:23776")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-aspartate_1-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/_4-phosphonato-L-aspartic_acid_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_4-phosphonato-L-aspartic_acid_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/L-aspartate_1-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBiotinSynthaseActivity
  :annotation (goid "GO:0004076")
  :annotation (database "RHEA:22060")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/dethiobiotin_1-_ ch/thiol_group ch/di-mu-sulfido-diiron_1+_ ch/di-mu-sulfido-diiron_1+_)
    (owl-some hasProduct  ch/_5'-deoxyadenosine ch/L-methionine_zwitterion ch/biotinate ch/H_group ch/_5'-deoxyadenosine ch/L-methionine_zwitterion ch/di-mu-sulfido-diiron_2+_))
   (owl-and
    (owl-some hasReactant  ch/_5'-deoxyadenosine ch/L-methionine_zwitterion ch/biotinate ch/H_group ch/_5'-deoxyadenosine ch/L-methionine_zwitterion ch/di-mu-sulfido-diiron_2+_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/dethiobiotin_1-_ ch/thiol_group ch/di-mu-sulfido-diiron_1+_ ch/di-mu-sulfido-diiron_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChrysanthemylDiphosphateSynthaseActivity
  :annotation (goid "GO:0033849")
  :annotation (database "RHEA:14009")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/prenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_R_R_-chrysanthemyl_diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_R_R_-chrysanthemyl_diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/prenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN2-_2-Carboxyethyl_ArginineSynthaseActivity
  :annotation (goid "GO:0033848")
  :annotation (database "RHEA:10556")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glyceraldehyde_3-phosphate_2-_ ch/L-argininium_1+_)
    (owl-some hasProduct  ch/N_2_-_2-carboxyethyl_-L-arginine_dizwitterion ch/hydron ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/N_2_-_2-carboxyethyl_-L-arginine_dizwitterion ch/hydron ch/hydrogenphosphate)
    (owl-some hasProduct  ch/D-glyceraldehyde_3-phosphate_2-_ ch/L-argininium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTryptophanDimethylallyltransferaseActivity
  :annotation (goid "GO:0050364")
  :annotation (database "RHEA:14173")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/L-tryptophan_zwitterion)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_4-_3-methylbut-2-enyl_-L-tryptophan_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_4-_3-methylbut-2-enyl_-L-tryptophan_zwitterion)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/L-tryptophan_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseO-PhosphoserineSulfhydrylaseActivity
  :annotation (goid "GO:0033847")
  :annotation (database "RHEA:10252")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-phosphonato-L-serine_2-_ ch/hydrosulfide ch/hydron)
    (owl-some hasProduct  ch/L-cysteine_zwitterion ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/L-cysteine_zwitterion ch/hydrogenphosphate)
    (owl-some hasProduct  ch/O-phosphonato-L-serine_2-_ ch/hydrosulfide ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenosyl-FluorideSynthaseActivity
  :annotation (goid "GO:0033846")
  :annotation (database "RHEA:16661")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/fluoride)
    (owl-some hasProduct  ch/_5'-deoxy-5'-fluoroadenosine ch/L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_5'-deoxy-5'-fluoroadenosine ch/L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/fluoride)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTyramineN-FeruloyltransferaseActivity
  :annotation (goid "GO:0050366")
  :annotation (database "RHEA:19685")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trans-feruloyl-CoA_4-_ ch/tyraminium)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-feruloyltyramine))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-feruloyltyramine)
    (owl-some hasProduct  ch/trans-feruloyl-CoA_4-_ ch/tyraminium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Tryptophan:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0050362")
  :annotation (database "RHEA:14093")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-tryptophan_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_3-_indol-3-yl_pyruvate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3-_indol-3-yl_pyruvate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-tryptophan_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6g-FructosyltransferaseActivity
  :annotation (goid "GO:0033841")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-kestose)
    (owl-some hasProduct  ch/_1_6-kestotetraose))
   (owl-and
    (owl-some hasReactant  ch/_1_6-kestotetraose)
    (owl-some hasProduct  ch/_1-kestose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNdp-Glucose-StarchGlucosyltransferaseActivity
  :annotation (goid "GO:0033840")
  :annotation (database "RHEA:15873")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NDP-alpha-D-glucose_2-_ ch/_1->4_-alpha-D-glucan)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/_1->4_-alpha-D-glucan ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/_1->4_-alpha-D-glucan ch/hydron)
    (owl-some hasProduct  ch/NDP-alpha-D-glucose_2-_ ch/_1->4_-alpha-D-glucan)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_tyrosine3-Monooxygenase_KinaseActivity
  :annotation (goid "GO:0050369")
  :annotation (database "RHEA:17133")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-serine_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/O-phospho-L-serine_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/O-phospho-L-serine_2-__residue ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-serine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-Acetyl-Beta-Glucosaminyl-Glycoprotein4-Beta-N-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0033842")
  :annotation (database "RHEA:20493")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/N-acetyl-beta-D-glucosaminide)
    (owl-some hasProduct  ch/UDP_3-_ ch/N-acetyl-beta-D-galactosaminyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N-acetyl-beta-D-galactosaminyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/N-acetyl-beta-D-glucosaminide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseApigeninidin5-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0102505")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/Apigeninidin ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/Cyanidin_5-O-glucoside ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/Cyanidin_5-O-glucoside ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/Apigeninidin ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetyl-Coa:L-GlutamateN-AcetyltransferaseActivity
  :annotation (goid "GO:0004042")
  :annotation (database "RHEA:24292")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-L-glutamate_2-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-L-glutamate_2-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAmidophosphoribosyltransferaseActivity
  :annotation (goid "GO:0004044")
  :annotation (database "RHEA:14905")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-phospho-beta-D-ribosylaminium_1-_ ch/L-glutamate_1-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/L-glutamine_zwitterion ch/water))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/L-glutamine_zwitterion ch/water)
    (owl-some hasProduct  ch/_5-phospho-beta-D-ribosylaminium_1-_ ch/L-glutamate_1-_ ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_glutamate-ammonia-ligase_AdenylyltransferaseActivity
  :annotation (goid "GO:0008882")
  :annotation (database "RHEA:18589")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-tyrosine_residue)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/O-adenyl-L-tyrosine_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/O-adenyl-L-tyrosine_1-__residue)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-tyrosine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAminomethyltransferaseActivity
  :annotation (goid "GO:0004047")
  :annotation (database "RHEA:16945")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N_6_-__R_-S_8_-ammoniomethyldihydrolipoyl_-L-lysine_1+__residue)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/ammonium ch/N_6_-__R_-dihydrolipoyl_-L-lysine_residue))
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/ammonium ch/N_6_-__R_-dihydrolipoyl_-L-lysine_residue)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N_6_-__R_-S_8_-ammoniomethyldihydrolipoyl_-L-lysine_1+__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycerateKinaseActivity
  :annotation (goid "GO:0008887")
  :annotation (database "RHEA:23516")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glycerate ch/ATP_4-_)
    (owl-some hasProduct  ch/_3-phosphonato-D-glycerate_3-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-phosphonato-D-glycerate_3-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-glycerate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthranilatePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0004048")
  :annotation (database "RHEA:11768")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-_5-phosphonato-beta-D-ribosyl_anthranilate ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/anthranilate))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/anthranilate)
    (owl-some hasProduct  ch/N-_5-phosphonato-beta-D-ribosyl_anthranilate ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-GlucosideGlucosyltransferaseActivity
  :annotation (goid "GO:0033838")
  :annotation (database "RHEA:18893")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/flavonol_3-O-beta-D-glucoside)
    (owl-some hasProduct  ch/UDP_3-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucoside ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucoside ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/flavonol_3-O-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAnthocyanin3'-O-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0033837")
  :annotation (database "RHEA:35627")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/delphinidin_3-O-beta-D-glucoside-5-O-beta-D-glucoside)
    (owl-some hasProduct  ch/UDP_3-_ ch/delphinidin_3_3'_5-tri-O-beta-D-glucoside_betaine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/delphinidin_3_3'_5-tri-O-beta-D-glucoside_betaine ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/delphinidin_3-O-beta-D-glucoside-5-O-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol7-O-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0033836")
  :annotation (database "RHEA:23164")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/_7-hydroxyflavonol)
    (owl-some hasProduct  ch/UDP_3-_ ch/flavonol_7-O-beta-D-glucoside ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/flavonol_7-O-beta-D-glucoside ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/_7-hydroxyflavonol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucose-1-PhosphateThymidylyltransferaseActivity
  :annotation (goid "GO:0008879")
  :annotation (database "RHEA:15225")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose_1-phosphate_2-_ ch/dTTP_4-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/dTDP-alpha-D-glucose_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/dTDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/alpha-D-glucose_1-phosphate_2-_ ch/dTTP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavanone7-O-Glucoside2_-O-Beta-L-RhamnosyltransferaseActivity
  :annotation (goid "GO:0033835")
  :annotation (database "RHEA:15473")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-beta-L-rhamnose_2-_ ch/_7-hydroxyflavanone_7-O-beta-D-glucoside)
    (owl-some hasProduct  ch/UDP_3-_ ch/flavanone_7-O-_alpha-L-rhamnosyl-_1->2_-beta-D-glucoside_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/flavanone_7-O-_alpha-L-rhamnosyl-_1->2_-beta-D-glucoside_ ch/hydron)
    (owl-some hasProduct  ch/UDP-beta-L-rhamnose_2-_ ch/_7-hydroxyflavanone_7-O-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-GlycosideGlucosyltransferaseActivity
  :annotation (goid "GO:0033839")
  :annotation (database "RHEA:23544")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucoside)
    (owl-some hasProduct  ch/UDP_3-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucosyl-_1->2_-beta-D-glucoside ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/flavonol_3-O-beta-D-glucosyl-_1->2_-beta-D-glucoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSkp1-Protein-HydroxyprolineN-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0033830")
  :annotation (database "RHEA:17841")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/trans-4-hydroxy-L-proline_residue)
    (owl-some hasProduct  ch/UDP_3-_ ch/O_4_-_N-acetyl-alpha-D-galactosaminyl_-trans-4-hydroxy-L-proline_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/O_4_-_N-acetyl-alpha-D-galactosaminyl_-trans-4-hydroxy-L-proline_residue ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/trans-4-hydroxy-L-proline_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalysePelargonidin3-O-Glucoside5-O-Glucosyltransferase_acyl-glucoseDependent_Activity
  :annotation (goid "GO:0102510")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pelargonidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)
    (owl-some hasProduct  ch/anthocyanidin_3_5-di-O-beta-D-glucoside_betaine ch/vanillate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/anthocyanidin_3_5-di-O-beta-D-glucoside_betaine ch/vanillate ch/hydron)
    (owl-some hasProduct  ch/pelargonidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKaempferol3-O-GalactosyltransferaseActivity
  :annotation (goid "GO:0033834")
  :annotation (database "RHEA:15709")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/kaempferol_oxoanion)
    (owl-some hasProduct  ch/UDP_3-_ ch/kaempferol_3-O-beta-D-galactoside_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/kaempferol_3-O-beta-D-galactoside_1-_)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/kaempferol_oxoanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlpha_Alpha-TrehalosePhosphorylase_configuration-retaining_Activity
  :annotation (goid "GO:0033832")
  :annotation (database "RHEA:16257")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha_alpha-trehalose ch/hydrogenphosphate)
    (owl-some hasProduct  ch/alpha-D-glucose ch/alpha-D-glucose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/alpha_alpha-trehalose ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKojibiosePhosphorylaseActivity
  :annotation (goid "GO:0033831")
  :annotation (database "RHEA:11176")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/kojibiose ch/hydrogenphosphate)
    (owl-some hasProduct  ch/beta-D-glucose_1-phosphate_2-_ ch/D-glucopyranose))
   (owl-and
    (owl-some hasReactant  ch/beta-D-glucose_1-phosphate_2-_ ch/D-glucopyranose)
    (owl-some hasProduct  ch/kojibiose ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDelphinidin3-O-Glucoside5-O-Glucosyltransferase_acyl-glucoseDependent_Activity
  :annotation (goid "GO:0102512")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/delphinidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)
    (owl-some hasProduct  ch/delphinidin_3-O-beta-D-glucoside-5-O-beta-D-glucoside_betaine ch/vanillate))
   (owl-and
    (owl-some hasReactant  ch/delphinidin_3-O-beta-D-glucoside-5-O-beta-D-glucoside_betaine ch/vanillate)
    (owl-some hasProduct  ch/delphinidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalysePelargonidin3-O-Glucoside7-O-Glucosyltransferase_acyl-glucoseDependent_Activity
  :annotation (goid "GO:0102511")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)
    (owl-some hasProduct  ch/cyanidin_3_7-di-O-beta-D-glucoside_betaine ch/vanillate))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3_7-di-O-beta-D-glucoside_betaine ch/vanillate)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-glucoside ch/_1-O-vanilloyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycineC-AcetyltransferaseActivity
  :annotation (goid "GO:0008890")
  :annotation (database "RHEA:20736")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/glycine_zwitterion)
    (owl-some hasProduct  ch/L-2-amino-3-oxobutanoic_acid_zwitterion ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/L-2-amino-3-oxobutanoic_acid_zwitterion ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/glycine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArginineKinaseActivity
  :annotation (goid "GO:0004054")
  :annotation (database "RHEA:22940")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-argininium_1+_ ch/ATP_4-_)
    (owl-some hasProduct  ch/N_omega_-phosphonato-L-arginine ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N_omega_-phosphonato-L-arginine ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/L-argininium_1+_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse4-HydroxybenzoateOctaprenyltransferaseActivity
  :annotation (goid "GO:0008412")
  :annotation (database "RHEA:27782")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/all-trans-octaprenyl_diphosphate_2-_ ch/_4-hydroxybenzoate)
    (owl-some hasProduct  ch/_4-hydroxy-3-octaprenylbenzoate ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxy-3-octaprenylbenzoate ch/diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-octaprenyl_diphosphate_2-_ ch/_4-hydroxybenzoate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArginyltransferaseActivity
  :annotation (goid "GO:0004057")
  :annotation (database "RHEA:10208")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-_L-arginyl_adenylyl_1+__group ch/N-terminal_alpha-amino-acid_1+__residue)
    (owl-some hasProduct  ch/AMP_3'-end_1-__residue ch/N-terminal_L-arginyl-L-alpha-amino_acid_2+__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/AMP_3'-end_1-__residue ch/N-terminal_L-arginyl-L-alpha-amino_acid_2+__residue ch/hydron)
    (owl-some hasProduct  ch/_3'-_L-arginyl_adenylyl_1+__group ch/N-terminal_alpha-amino-acid_1+__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomoserineO-SuccinyltransferaseActivity
  :annotation (goid "GO:0008899")
  :annotation (database "RHEA:22008")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-homoserine_zwitterion ch/succinyl-CoA_5-_)
    (owl-some hasProduct  ch/O-succinyl-L-homoserinate_1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/O-succinyl-L-homoserinate_1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/L-homoserine_zwitterion ch/succinyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseS-Adenosylmethionine-HomocysteineS-MethyltransferaseActivity
  :annotation (goid "GO:0008898")
  :annotation (database "RHEA:21820")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/L-methionine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/L-methionine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-homocysteine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAralkylamineN-AcetyltransferaseActivity
  :annotation (goid "GO:0004059")
  :annotation (database "RHEA:20497")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/_2-arylethylammomium_1+_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-acetyl-2-arylethylamine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-acetyl-2-arylethylamine ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/_2-arylethylammomium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHolo-_Acyl-Carrier-Protein_SynthaseActivity
  :annotation (goid "GO:0008897")
  :annotation (database "RHEA:12068")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/L-serine_residue)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue ch/hydron)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/L-serine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucosylglycerol-PhosphateSynthaseActivity
  :annotation (goid "GO:0033828")
  :annotation (database "RHEA:12881")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sn-glycerol_3-phosphate_2-_ ch/ADP_alpha-D-glucoside_2-_)
    (owl-some hasProduct  ch/_2-O-_alpha-D-glucosyl_-sn-glycerol_3-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2-O-_alpha-D-glucosyl_-sn-glycerol_3-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/sn-glycerol_3-phosphate_2-_ ch/ADP_alpha-D-glucoside_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUrate-RibonucleotidePhosphorylaseActivity
  :annotation (goid "GO:0050384")
  :annotation (database "RHEA:13909")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-_beta-D-ribofuranosyl_uric_acid ch/hydrogenphosphate)
    (owl-some hasProduct  ch/alpha-D-ribose_1-phosphate_2-_ ch/_7_9-dihydro-1H-purine-2_6_8_3H_-trione))
   (owl-and
    (owl-some hasReactant  ch/alpha-D-ribose_1-phosphate_2-_ ch/_7_9-dihydro-1H-purine-2_6_8_3H_-trione)
    (owl-some hasProduct  ch/_3-_beta-D-ribofuranosyl_uric_acid ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylarsoniteMethyltransferaseActivity
  :annotation (goid "GO:0030792")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/methylarsonous_acid)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/dimethylarsinate ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/dimethylarsinate ch/hydron ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/methylarsonous_acid)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArseniteMethyltransferaseActivity
  :annotation (goid "GO:0030791")
  :annotation (database "RHEA:15293")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/arsenite_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/methylarsonate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/methylarsonate_1-_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/arsenite_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_S_-coclaurine-N-methyltransferaseActivity
  :annotation (goid "GO:0030794")
  :annotation (database "RHEA:17409")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_S_-coclaurinium)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_S_-N-methylcoclaurinium_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_S_-N-methylcoclaurinium_1+_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_S_-coclaurinium)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3'-DemethylstaurosporineO-MethyltransferaseActivity
  :annotation (goid "GO:0030793")
  :annotation (database "RHEA:11696")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-demethylstaurosporinium_1+_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/staurosporinium))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/staurosporinium)
    (owl-some hasProduct  ch/_3'-demethylstaurosporinium_1+_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCycloartenol24-C-MethyltransferaseActivity
  :annotation (goid "GO:0030796")
  :annotation (database "RHEA:13137")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/cycloartenol)
    (owl-some hasProduct  ch/cyclolaudenol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/cyclolaudenol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/cycloartenol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseJasmonateO-MethyltransferaseActivity
  :annotation (goid "GO:0030795")
  :annotation (database "RHEA:13349")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/jasmonate_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_-_-methyl_jasmonate))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_-_-methyl_jasmonate)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/jasmonate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrans-Aconitate2-MethyltransferaseActivity
  :annotation (goid "GO:0030798")
  :annotation (database "RHEA:14969")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/trans-aconitate_3-_)
    (owl-some hasProduct  ch/_2E_-3-_methoxycarbonyl_pent-2-enedioate_2-_ ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_2E_-3-_methoxycarbonyl_pent-2-enedioate_2-_ ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/trans-aconitate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-4-Amino-4-Deoxy-L-ArabinoseFormyltransferaseActivity
  :annotation (goid "GO:0099619")
  :annotation (database "RHEA:24706")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_10-formyltetrahydrofolate_2-_ ch/UDP-4-amino-4-deoxy-beta-L-arabinopyranose_1-_)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/UDP-4-deoxy-4-formamido-beta-L-arabinopyranose_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/UDP-4-deoxy-4-formamido-beta-L-arabinopyranose_2-_ ch/hydron)
    (owl-some hasProduct  ch/_10-formyltetrahydrofolate_2-_ ch/UDP-4-amino-4-deoxy-beta-L-arabinopyranose_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse24-MethylenesterolC-MethyltransferaseActivity
  :annotation (goid "GO:0030797")
  :annotation (database "RHEA:21044")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_24-methylidenelophenol ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_Z_-24-ethylidenelophenol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_Z_-24-ethylidenelophenol ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_24-methylidenelophenol ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseApigenin7-O-MethyltransferaseActivity
  :annotation (goid "GO:0102529")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/apigenin-7-olate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/genkwanin))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/genkwanin)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/apigenin-7-olate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFormylmethanofuran-TetrahydromethanopterinN-FormyltransferaseActivity
  :annotation (goid "GO:0030270")
  :annotation (database "RHEA:18061")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5_6_7_8-tetrahydromethanopterin_3-_ ch/N-formylmethanofuran_5-_ ch/hydron)
    (owl-some hasProduct  ch/N_5_-formyl-5_6_7_8-tetrahydromethanopterin ch/methanofuranate_4-_))
   (owl-and
    (owl-some hasReactant  ch/N_5_-formyl-5_6_7_8-tetrahydromethanopterin ch/methanofuranate_4-_)
    (owl-some hasProduct  ch/_5_6_7_8-tetrahydromethanopterin_3-_ ch/N-formylmethanofuran_5-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA4-DemethylwyosineAlpha-Amino-Alpha-CarboxypropyltransferaseActivity
  :annotation (goid "GO:0102522")
  :annotation (database "RHEA:36355")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_4-demethylwyosine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/_4-demethyl-7-_3-amino-3-carboxypropyl_wyosine_5'-monophosphate_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/_4-demethyl-7-_3-amino-3-carboxypropyl_wyosine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_4-demethylwyosine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucuronokinaseActivity
  :annotation (goid "GO:0047940")
  :annotation (database "RHEA:17005")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glucopyranuronate ch/ATP_4-_)
    (owl-some hasProduct  ch/_1-phosphonato-alpha-D-glucuronate_3-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1-phosphonato-alpha-D-glucuronate_3-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-glucopyranuronate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutamineN-PhenylacetyltransferaseActivity
  :annotation (goid "GO:0047947")
  :annotation (database "RHEA:21844")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phenylacetyl-CoA_4-_ ch/L-glutamine_zwitterion)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_2_-phenylacetyl-L-glutaminate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_2_-phenylacetyl-L-glutaminate ch/hydron)
    (owl-some hasProduct  ch/phenylacetyl-CoA_4-_ ch/L-glutamine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutamineN-AcyltransferaseActivity
  :annotation (goid "GO:0047946")
  :annotation (database "RHEA:18469")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/L-glutamine_zwitterion)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_2_-acyl-L-glutaminate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_2_-acyl-L-glutaminate ch/hydron)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/L-glutamine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Glutamine:PyruvateAminotransferaseActivity
  :annotation (goid "GO:0047945")
  :annotation (database "RHEA:10400")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-glutamine_zwitterion ch/pyruvate)
    (owl-some hasProduct  ch/_2-oxoglutaramate ch/L-alanine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutaramate ch/L-alanine_zwitterion)
    (owl-some hasProduct  ch/L-glutamine_zwitterion ch/pyruvate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutamate1-KinaseActivity
  :annotation (goid "GO:0047944")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/L-alpha-glutamyl_phosphate_2-_ ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/L-alpha-glutamyl_phosphate_2-_ ch/ADP_3-_)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTetrahydromethanopterinS-MethyltransferaseActivity
  :annotation (goid "GO:0030269")
  :annotation (database "RHEA:53492")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-methyl-5_6_7_8-tetrahydromethanopterin_3-_ ch/coenzyme_M_1-_)
    (owl-some hasProduct  ch/_5_6_7_8-tetrahydromethanopterin_3-_ ch/methyl-CoM_1-_))
   (owl-and
    (owl-some hasReactant  ch/_5_6_7_8-tetrahydromethanopterin_3-_ ch/methyl-CoM_1-_)
    (owl-some hasProduct  ch/_5-methyl-5_6_7_8-tetrahydromethanopterin_3-_ ch/coenzyme_M_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRNAPolymeraseIiCtdHeptapeptideRepeatKinaseActivity
  :annotation (goid "GO:0008353")
  :annotation (database "RHEA:10216")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/hydroxy_group)
    (owl-some hasProduct  ch/ADP_3-_ ch/phosphate_group_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/phosphate_group_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/hydroxy_group)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGenkwanin4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0102533")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/genkwanin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/hydron ch/apigenin_7_4'-dimethyl_ether ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/apigenin_7_4'-dimethyl_ether ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/genkwanin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0047958")
  :annotation (database "RHEA:14089")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/glycine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/glyoxylate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/glyoxylate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/glycine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycineN-AcyltransferaseActivity
  :annotation (goid "GO:0047961")
  :annotation (database "RHEA:19869")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/glycine_zwitterion)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-acylglycinate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-acylglycinate ch/hydron)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/glycine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolHeptakisphosphate6-KinaseActivity
  :annotation (goid "GO:0000834")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate)
    (owl-some hasProduct  ch/_5_6-bis_diphospho_-1D-myo-inositol_tetrakisphosphate))
   (owl-and
    (owl-some hasReactant  ch/_5_6-bis_diphospho_-1D-myo-inositol_tetrakisphosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycoproteinO-Fatty-AcyltransferaseActivity
  :annotation (goid "GO:0047965")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/palmitoyl-CoA_4-_ ch/glycoprotein)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/O-glycoprotein))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/O-glycoprotein)
    (owl-some hasProduct  ch/palmitoyl-CoA_4-_ ch/glycoprotein)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolHeptakisphosphate4-KinaseActivity
  :annotation (goid "GO:0000833")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_)
    (owl-some hasProduct  ch/_4_5-bis_diphospho_-1D-myo-inositol_tetrakisphosphate))
   (owl-and
    (owl-some hasReactant  ch/_4_5-bis_diphospho_-1D-myo-inositol_tetrakisphosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiaminobutyrate-2-OxoglutarateTransaminaseActivity
  :annotation (goid "GO:0045303")
  :annotation (database "RHEA:11160")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-2_4-diazaniumylbutyrate)
    (owl-some hasProduct  ch/L-aspartic_acid_4-semialdehyde_betaine ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/L-aspartic_acid_4-semialdehyde_betaine ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-2_4-diazaniumylbutyrate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolHexakisphosphate5-KinaseActivity
  :annotation (goid "GO:0000832")
  :annotation (database "RHEA:12793")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_5-diphospho-1D-myo-inositol_pentakisphosphate_13-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycineN-CholoyltransferaseActivity
  :annotation (goid "GO:0047963")
  :annotation (database "RHEA:14001")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/choloyl-CoA_4-_ ch/glycine_zwitterion)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/glycocholate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/glycocholate ch/hydron)
    (owl-some hasProduct  ch/choloyl-CoA_4-_ ch/glycine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolHexakisphosphate6-KinaseActivity
  :annotation (goid "GO:0000831")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_6-diphospho-1D-myo-inositol_pentakisphosphate))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_6-diphospho-1D-myo-inositol_pentakisphosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycineN-BenzoyltransferaseActivity
  :annotation (goid "GO:0047962")
  :annotation (database "RHEA:18493")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/benzoyl-CoA_4-_ ch/glycine_zwitterion)
    (owl-some hasProduct  ch/N-benzoylglycinate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-benzoylglycinate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/benzoyl-CoA_4-_ ch/glycine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolHexakisphosphate4-KinaseActivity
  :annotation (goid "GO:0000830")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_4-diphospho-1D-myo-inositol_pentakisphosphate))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_4-diphospho-1D-myo-inositol_pentakisphosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/myo-inositol_hexakisphosphate_12-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomogentisateGeranylgeranylTransferaseActivity
  :annotation (goid "GO:0102551")
  :annotation (database "RHEA:38003")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/homogentisate ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_2-methyl-6-geranylgeranyl-1_4-benzoquinol ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_2-methyl-6-geranylgeranyl-1_4-benzoquinol ch/carbon_dioxide)
    (owl-some hasProduct  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/homogentisate ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Methyl-6-Geranylgeranyl-1_4-BenzoquinolMethyltransferaseActivity
  :annotation (goid "GO:0102550")
  :annotation (database "RHEA:38007")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_2-methyl-6-geranylgeranyl-1_4-benzoquinol)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2_3-dimethyl-6-geranylgeranyl-1_4-benzoquinol ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2_3-dimethyl-6-geranylgeranyl-1_4-benzoquinol ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_2-methyl-6-geranylgeranyl-1_4-benzoquinol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHamameloseKinaseActivity
  :annotation (goid "GO:0047976")
  :annotation (database "RHEA:22796")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-hamamelose ch/ATP_4-_)
    (owl-some hasProduct  ch/D-hamamelose_2_1_-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/D-hamamelose_2_1_-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-hamamelose ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGuanosinePhosphorylaseActivity
  :annotation (goid "GO:0047975")
  :annotation (database "RHEA:13233")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/guanosine ch/hydrogenphosphate)
    (owl-some hasProduct  ch/guanine ch/alpha-D-ribose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/guanine ch/alpha-D-ribose_1-phosphate_2-_)
    (owl-some hasProduct  ch/guanosine ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGuanidinoacetateKinaseActivity
  :annotation (goid "GO:0047973")
  :annotation (database "RHEA:14145")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/guanidinoacetic_acid_zwitterion)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/phosphonatoguanidiniumylacetate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/phosphonatoguanidiniumylacetate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/guanidinoacetic_acid_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad_P_-AsparagineAdp-RibosyltransferaseActivity
  :annotation (goid "GO:0018121")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NADP_3-_ ch/L-asparagine_zwitterion)
    (owl-some hasProduct  ch/nicotinamide ch/N_4_-_ADP-D-ribosyl_-L-asparagine_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/nicotinamide ch/N_4_-_ADP-D-ribosyl_-L-asparagine_2-__residue)
    (owl-some hasProduct  ch/NADP_3-_ ch/L-asparagine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistidineN-AcetyltransferaseActivity
  :annotation (goid "GO:0047981")
  :annotation (database "RHEA:24596")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-histidine ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-L-histidinate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-L-histidinate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/L-histidine ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad_P_-SerineAdp-RibosyltransferaseActivity
  :annotation (goid "GO:0018127")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NADP_3-_ ch/L-serine_zwitterion)
    (owl-some hasProduct  ch/nicotinamide ch/O-_ADP-D-ribosyl_-L-serine_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/nicotinamide ch/O-_ADP-D-ribosyl_-L-serine_2-__residue)
    (owl-some hasProduct  ch/NADP_3-_ ch/L-serine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProteinAdenylyltransferaseActivity
  :annotation (goid "GO:0070733")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/protein)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/adenosine_5'-monophosphate))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/adenosine_5'-monophosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/protein)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactolipidO-AcyltransferaseActivity
  :annotation (goid "GO:0047909")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/mono-beta-D-galactosyl_diacylglycerol ch/mono-beta-D-galactosyl_diacylglycerol)
    (owl-some hasProduct  ch/_1_2-diacyl-3-_6-O-acyl-beta-D-galactosyl_-sn-glycerol ch/_2-O-acyl-3-O-beta-D-galactosyl-sn-glycerol))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-3-_6-O-acyl-beta-D-galactosyl_-sn-glycerol ch/_2-O-acyl-3-O-beta-D-galactosyl-sn-glycerol)
    (owl-some hasProduct  ch/mono-beta-D-galactosyl_diacylglycerol ch/mono-beta-D-galactosyl_diacylglycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFormateKinaseActivity
  :annotation (goid "GO:0047900")
  :annotation (database "RHEA:16009")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/formate)
    (owl-some hasProduct  ch/ADP_3-_ ch/formyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/formyl_phosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/formate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAminodeoxyfutalosineSynthaseActivity
  :annotation (goid "GO:0102573")
  :annotation (database "RHEA:33075")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-__1-carboxylatovinyl_oxy_benzoate_2-_ ch/S-adenosyl-L-methionine_zwitterion ch/water)
    (owl-some hasProduct  ch/aminodeoxyfutalosinate ch/L-methionine_zwitterion ch/hydrogencarbonate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/aminodeoxyfutalosinate ch/L-methionine_zwitterion ch/hydrogencarbonate ch/hydron)
    (owl-some hasProduct  ch/_3-__1-carboxylatovinyl_oxy_benzoate_2-_ ch/S-adenosyl-L-methionine_zwitterion ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGangliosideGalactosyltransferaseActivity
  :annotation (goid "GO:0047915")
  :annotation (database "RHEA:16773")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/beta-D-GalNAc-_1->4_-_alpha-Neu5Ac-_2->3__-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer_1-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/alpha-N-acetylneuraminosyl-_2->3_-_beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_--N-acylsphingosine_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/alpha-N-acetylneuraminosyl-_2->3_-_beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_--N-acylsphingosine_1-_)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/beta-D-GalNAc-_1->4_-_alpha-Neu5Ac-_2->3__-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistoneMethyltransferaseActivity_H3-K79Specific_	
  :annotation (goid "GO:0031151")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/Histone-L-lysine)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_6_-methyl-L-lysine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_6_-methyl-L-lysine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/Histone-L-lysine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGallate1-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047913")
  :annotation (database "RHEA:15249")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/gallate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_1-O-galloyl-beta-D-glucose ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1-O-galloyl-beta-D-glucose ch/UDP_3-_)
    (owl-some hasProduct  ch/gallate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalacturonokinaseActivity
  :annotation (goid "GO:0047912")
  :annotation (database "RHEA:12965")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-galacturonate ch/ATP_4-_)
    (owl-some hasProduct  ch/_1-phosphonato-alpha-D-galacturonate_3-_ ch/ADP_3-_ ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1-phosphonato-alpha-D-galacturonate_3-_ ch/ADP_3-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/alpha-D-galacturonate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-_2_-O-_Xylosyl_-6_-O-_P-Coumaroyl_Glucoside_5-O-GlucosideMalonyltransferaseActivity
  :annotation (goid "GO:0102585")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/malonyl-CoA_5-_ ch/hydron)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/malonyl-CoA_5-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMycothiol-ArsenateLigaseActivity
  :annotation (goid "GO:0102100")
  :annotation (database "RHEA:27349")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/arsenate_2-_ ch/mycothiol)
    (owl-some hasProduct  ch/arseno-mycothiol_2-_ ch/water))
   (owl-and
    (owl-some hasReactant  ch/arseno-mycothiol_2-_ ch/water)
    (owl-some hasProduct  ch/arsenate_2-_ ch/mycothiol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-_2_-O-_Xylosyl_-6_-O-_P-Coumaroyl_Glucoside_5-O-GlucosyltransferaseActivity5-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0102584")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside_ ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDemethoxycurcuminSynthase	
  :annotation (goid "GO:0102103")
  :annotation (database "RHEA:35119")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-coumaroyl_acetyl-CoA ch/_4-coumaroyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/bisdemethoxycurcumin ch/coenzyme_A_4-_ ch/carbon_dioxide ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/bisdemethoxycurcumin ch/coenzyme_A_4-_ ch/carbon_dioxide ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_4-coumaroyl_acetyl-CoA ch/_4-coumaroyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-_2_-O-_2_-O-_Sinapoyl_Xylosyl_6_-O-_P-O-_Glucosyl_-P-Coumaroyl_Glucoside_5-O-_6_-O-_Malonyl_Glucoside_SinapoylglucoseGlucosyltransferaseActivity
  :annotation (goid "GO:0102587")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/_1-O-sinapoyl-beta-D-glucose)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/trans-sinapate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/trans-sinapate ch/hydron)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/_1-O-sinapoyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-_2_-O-_2_-O-_Sinapoyl_Xylosyl_6_-O-_P-Coumaroyl_Glucoside_5-O-_6_-O-_Malonyl_Glucoside_SinapoyltransferaseActivity
  :annotation (goid "GO:0102586")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/_1-O-sinapoyl-beta-D-glucose)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/beta-D-glucose))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_2-O-sinapoyl-beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/beta-D-glucose)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_4-O-beta-D-glucosyl-p-coumaroyl_-2-O-_beta-D-xylosyl_-beta-D-glucosyl_-5-O-_6-O-malonyl-beta-D-glucoside__1-_ ch/_1-O-sinapoyl-beta-D-glucose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-Glucoside-P-CoumaroyltransferaseActivity
  :annotation (goid "GO:0102581")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/_4-coumaroyl-CoA_4-_ ch/hydron)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-_E_-4-coumaroyl-beta-D-glucoside_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-_E_-4-coumaroyl-beta-D-glucoside_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/_4-coumaroyl-CoA_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-Glucoside2-O_-XylosyltransferaseActivity
  :annotation (goid "GO:0102580")
  :annotation (database "RHEA:35443")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/UDP-alpha-D-xylose_2-_)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-sambubioside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-sambubioside ch/UDP_3-_)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/UDP-alpha-D-xylose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTricaffeoylSpermidineO-MethyltransferaseActivity
  :annotation (goid "GO:0102109")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N1_N5_N10-Tricaffeoyl_spermidine ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/hydron ch/N1_N5_N10-Triferuloyl_spermidine ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/hydron ch/S-adenosyl-L-homocysteine_zwitterion ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/N1_N5_N10-Triferuloyl_spermidine ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron ch/hydron ch/S-adenosyl-L-homocysteine_zwitterion ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/N1_N5_N10-Tricaffeoyl_spermidine ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGibberellinBeta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047928")
  :annotation (database "RHEA:20025")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/gibberellin_A3_1-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/gibberellin_A3_O-beta-D-glucoside_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/gibberellin_A3_O-beta-D-glucoside_1-_ ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/gibberellin_A3_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDemethoxycurcuminSynthaseActivity
  :annotation (goid "GO:0102104")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-coumaroyl_acetyl-CoA ch/trans-feruloyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/demethoxycurcumin ch/coenzyme_A_4-_ ch/carbon_dioxide ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/demethoxycurcumin ch/coenzyme_A_4-_ ch/carbon_dioxide ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_4-coumaroyl_acetyl-CoA ch/trans-feruloyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin3-O-Glucoside6_-O-MalonyltransferaseActivity
  :annotation (goid "GO:0102588")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/malonyl-CoA_5-_)
    (owl-some hasProduct  ch/cyanidin_3-O-_6-O-malonyl-beta-D-glucoside_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-_6-O-malonyl-beta-D-glucoside_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/malonyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAminoglycoside2'-N-AcetyltransferaseActivity
  :annotation (goid "GO:0047921")
  :annotation (database "RHEA:24516")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/gentamycin_C1a_5+_)
    (owl-some hasProduct  ch/N_2'_-acetylgentamycin_C1a_4+_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N_2'_-acetylgentamycin_C1a_4+_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/gentamycin_C1a_5+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCeramideKinaseActivity
  :annotation (goid "GO:0001729")
  :annotation (database "RHEA:17929")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N-acylsphingosine)
    (owl-some hasProduct  ch/ADP_3-_ ch/ceramide_1-phosphate))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/ceramide_1-phosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/N-acylsphingosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethylated-Dna-_Protein_-CysteineS-MethyltransferaseActivity
  :annotation (goid "GO:0003908")
  :annotation (database "RHEA:24000")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6-O-methyl_dGMP_1-__residue ch/L-cysteine_residue)
    (owl-some hasProduct  ch/_2'-deoxyguanosine_5'-monophosphate_1-__residue ch/S-methyl-L-cysteine_residue))
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxyguanosine_5'-monophosphate_1-__residue ch/S-methyl-L-cysteine_residue)
    (owl-some hasProduct  ch/_6-O-methyl_dGMP_1-__residue ch/L-cysteine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMyricetin3'-O-MethyltransferaseActivity
  :annotation (goid "GO:0033799")
  :annotation (database "RHEA:25629")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/myricetin_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/laricitrin))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/laricitrin)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/myricetin_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGibberellinA20CarboxylMethyltransferaseActivity
  :annotation (goid "GO:0102119")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A20 ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A20_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A20_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A20 ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucose-1-PhosphatePhosphodismutaseActivity
  :annotation (goid "GO:0047937")
  :annotation (database "RHEA:16397")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glucopyranose_1-phosphate_2-_ ch/D-glucopyranose_1-phosphate_2-_)
    (owl-some hasProduct  ch/D-glucopyranose ch/D-glucose_1_6-bisphosphate_4-_))
   (owl-and
    (owl-some hasReactant  ch/D-glucopyranose ch/D-glucose_1_6-bisphosphate_4-_)
    (owl-some hasProduct  ch/D-glucopyranose_1-phosphate_2-_ ch/D-glucopyranose_1-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGibberellinA4CarboxylMethyltransferaseActivity
  :annotation (goid "GO:0102118")
  :annotation (database "RHEA:36107")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A4_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A4_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A4_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A4_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGibberellinA9CarboxylMethyltransferaseActivity
  :annotation (goid "GO:0102117")
  :annotation (database "RHEA:36119")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A9_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A9_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/gibberellin_A9_methyl_ester ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/gibberellin_A9_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucosamineN-AcetyltransferaseActivity
  :annotation (goid "GO:0047932")
  :annotation (database "RHEA:21332")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-ammonio-2-deoxy-D-glucopyranose ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-D-glucosamine ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-D-glucosamine ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/_2-ammonio-2-deoxy-D-glucopyranose ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucosamineKinaseActivity
  :annotation (goid "GO:0047931")
  :annotation (database "RHEA:10948")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_2-ammonio-2-deoxy-D-glucopyranose)
    (owl-some hasProduct  ch/ADP_3-_ ch/_2-ammonio-2-deoxy-D-glucopyranose_6-phosphate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_2-ammonio-2-deoxy-D-glucopyranose_6-phosphate_1-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/_2-ammonio-2-deoxy-D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucose-1_6-BisphosphateSynthaseActivity
  :annotation (goid "GO:0047933")
  :annotation (database "RHEA:16769")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-phosphonato-D-glyceroyl_phosphate_4-_ ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/_3-phosphonato-D-glycerate_3-_ ch/alpha-D-glucose_1_6-bisphosphate_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-phosphonato-D-glycerate_3-_ ch/alpha-D-glucose_1_6-bisphosphate_4-_ ch/hydron)
    (owl-some hasProduct  ch/_3-phosphonato-D-glyceroyl_phosphate_4-_ ch/alpha-D-glucose_1-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosylceramideSulfotransferaseActivity
  :annotation (goid "GO:0001733")
  :annotation (database "RHEA:43304")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/N-acyl-beta-D-galactosylsphingosine)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/galactosylceramide_sulfate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/galactosylceramide_sulfate_1-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/N-acyl-beta-D-galactosylsphingosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFarnesoicAcidO-MethyltransferaseActivity
  :annotation (goid "GO:0019010")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/farnesoic_acid ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/methyl_farnesoate ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/methyl_farnesoate ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/farnesoic_acid ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDnaNucleotidylexotransferaseActivity
  :annotation (goid "GO:0003912")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxyribonucleoside_5'-triphosphate_4-_ ch/DNA_polyanion)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/DNA_polyanion))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/DNA_polyanion)
    (owl-some hasProduct  ch/_2'-deoxyribonucleoside_5'-triphosphate_4-_ ch/DNA_polyanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHeptose-1-PhosphateAdenylyltransferaseActivity
  :annotation (goid "GO:0033786")
  :annotation (database "RHEA:27465")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glycero-beta-D-manno-heptose_1-phosphate_2-_ ch/ATP_4-_ ch/hydron)
    (owl-some hasProduct  ch/ADP-D-glycero-beta-D-manno-heptose_2-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP-D-glycero-beta-D-manno-heptose_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/D-glycero-beta-D-manno-heptose_1-phosphate_2-_ ch/ATP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHeptose7-PhosphateKinaseActivity
  :annotation (goid "GO:0033785")
  :annotation (database "RHEA:27473")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glycero-beta-D-manno-heptose_7-phosphate_2-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/D-glycero-beta-D-manno-heptose_1_7-bisphosphate_4-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/D-glycero-beta-D-manno-heptose_1_7-bisphosphate_4-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-glycero-beta-D-manno-heptose_7-phosphate_2-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFmnAdenylyltransferaseActivity
  :annotation (goid "GO:0003919")
  :annotation (database "RHEA:17237")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/FMN_3-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/FAD_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/FAD_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/FMN_3-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Phenylalanine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0080130")
  :annotation (database "RHEA:25152")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-phenylalanine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/keto-phenylpyruvate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/keto-phenylpyruvate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-phenylalanine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCystathionineGamma-SynthaseActivity
  :annotation (goid "GO:0003962")
  :annotation (database "RHEA:20397")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-succinyl-L-homoserinate_1-_ ch/L-cysteine_zwitterion)
    (owl-some hasProduct  ch/L-cystathionine_dizwitterion ch/succinate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/L-cystathionine_dizwitterion ch/succinate_2-_ ch/hydron)
    (owl-some hasProduct  ch/O-succinyl-L-homoserinate_1-_ ch/L-cysteine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNAAdenylyltransferaseActivity
  :annotation (goid "GO:0004810")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/transfer_RNA)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/transfer_RNA))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/transfer_RNA)
    (owl-some hasProduct  ch/ATP_4-_ ch/transfer_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRNA-DirectedDnaPolymeraseActivity
  :annotation (goid "GO:0003964")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxyribonucleoside_5'-triphosphate_4-_ ch/DNA_polyanion)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/DNA_polyanion))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/DNA_polyanion)
    (owl-some hasProduct  ch/_2'-deoxyribonucleoside_5'-triphosphate_4-_ ch/DNA_polyanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRNA-Directed5'-3'RNAPolymeraseActivity
  :annotation (goid "GO:0003968")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/RNA_polyanion)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/RNA_polyanion))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/RNA_polyanion)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/RNA_polyanion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistoneAcetyltransferaseActivity_H3-K14Specific_	
  :annotation (goid "GO:0036408")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/Histone-L-lysine)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_6_-acetyl-L-lysine_residue)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/Histone-L-lysine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUtp:Glucose-1-PhosphateUridylyltransferaseActivity
  :annotation (goid "GO:0003983")
  :annotation (database "RHEA:19889")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose_1-phosphate_2-_ ch/UTP_4-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/UDP-alpha-D-glucose_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/alpha-D-glucose_1-phosphate_2-_ ch/UTP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-N-Acetylglucosamine-Dolichyl-PhosphateN-AcetylglucosaminephosphotransferaseActivity
  :annotation (goid "GO:0003975")
  :annotation (database "RHEA:13289")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/uridine_5'-monophosphate_2-_ ch/N-acetyl-D-glucosaminyldiphosphodolichol_2-_))
   (owl-and
    (owl-some hasReactant  ch/uridine_5'-monophosphate_2-_ ch/N-acetyl-D-glucosaminyldiphosphodolichol_2-_)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/dolichyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-N-Acetylglucosamine-Lysosomal-EnzymeN-AcetylglucosaminephosphotransferaseActivity
  :annotation (goid "GO:0003976")
  :annotation (database "RHEA:13581")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_alpha-D-mannosyl-_1->2_-alpha-D-mannosyl-glycan_-L-asparagine_residue)
    (owl-some hasProduct  ch/uridine_5'-monophosphate_2-_ ch/N_4_-_6-_N-acetyl-alpha-D-glucosaminyl-1-phospho_-alpha-D-mannosyl-_1->2_-alpha-D-mannosyl-glycan_-L-asparagine_residue_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/uridine_5'-monophosphate_2-_ ch/N_4_-_6-_N-acetyl-alpha-D-glucosaminyl-1-phospho_-alpha-D-mannosyl-_1->2_-alpha-D-mannosyl-glycan_-L-asparagine_residue_1-_ ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_alpha-D-mannosyl-_1->2_-alpha-D-mannosyl-glycan_-L-asparagine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-N-AcetylglucosamineDiphosphorylaseActivity
  :annotation (goid "GO:0003977")
  :annotation (database "RHEA:13509")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-alpha-D-glucosamine_1-phosphate_2-_ ch/UTP_4-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/UDP-N-acetyl-alpha-D-glucosamine_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-alpha-D-glucosamine_1-phosphate_2-_ ch/UTP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePeptideN-AcetyltransferaseActivity
  :annotation (goid "GO:0034212")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/organic_cationic_group)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-terminal_alpha-amino-acid_residue))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-terminal_alpha-amino-acid_residue)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/organic_cationic_group)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDol-P-Man:Man_7_Glcnac_2_-Pp-DolAlpha-1_6-MannosyltransferaseActivity
  :annotation (goid "GO:0052917")
  :annotation (database "RHEA:29535")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)
    (owl-some hasProduct  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDol-P-Man:Man_8_Glcnac_2_-Pp-DolAlpha-1_2-MannosyltransferaseActivity
  :annotation (goid "GO:0052918")
  :annotation (database "RHEA:29539")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)
    (owl-some hasProduct  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-OxoadipateCoa-TransferaseActivity
  :annotation (goid "GO:0047569")
  :annotation (database "RHEA:12048")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/succinyl-CoA_5-_ ch/_3-oxoadipate_2-_)
    (owl-some hasProduct  ch/succinate_2-_ ch/_3-oxoadipyl-CoA_5-_))
   (owl-and
    (owl-some hasReactant  ch/succinate_2-_ ch/_3-oxoadipyl-CoA_5-_)
    (owl-some hasProduct  ch/succinyl-CoA_5-_ ch/_3-oxoadipate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad+Adp-RibosyltransferaseActivity
  :annotation (goid "GO:0003950")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NAD_1-_ ch/_ADP-D-ribosyl__n_-acceptor)
    (owl-some hasProduct  ch/nicotinamide ch/_ADP-D-ribosyl__n+1_-acceptor ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/nicotinamide ch/_ADP-D-ribosyl__n+1_-acceptor ch/hydron)
    (owl-some hasProduct  ch/NAD_1-_ ch/_ADP-D-ribosyl__n_-acceptor)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetyllactosamineSynthaseActivity
  :annotation (goid "GO:0003945")
  :annotation (database "RHEA:17745")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/N-acetyl-D-glucosamine)
    (owl-some hasProduct  ch/UDP_3-_ ch/beta-D-galactopyranosyl-_1->4_-N-acetyl-D-glucosamine ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/beta-D-galactopyranosyl-_1->4_-N-acetyl-D-glucosamine ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/N-acetyl-D-glucosamine)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_N-acetylneuraminyl_-galactosylglucosylceramideN-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0003947")
  :annotation (database "RHEA:12588")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/beta-D-GalNAc-_1->4_-_alpha-Neu5Ac-_2->3__-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/beta-D-GalNAc-_1->4_-_alpha-Neu5Ac-_2->3__-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer_1-_ ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2_5-DhbaUDP-GlucosyltransferaseActivity
  :annotation (goid "GO:0102156")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2_5-dihydroxybenzoate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_2_5-dihydroxybenzoic_acid_5-O-beta-D-glucoside ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2_5-dihydroxybenzoic_acid_5-O-beta-D-glucoside ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_2_5-dihydroxybenzoate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBaicalein7-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0102159")
  :annotation (database "RHEA:28314")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucuronate_3-_ ch/baicalein_1-_)
    (owl-some hasProduct  ch/hydron ch/UDP_3-_ ch/baicalin_1-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/UDP_3-_ ch/baicalin_1-_)
    (owl-some hasProduct  ch/UDP-alpha-D-glucuronate_3-_ ch/baicalein_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCtp:3'-Cytidine-tRNACytidylyltransferaseActivity
  :annotation (goid "GO:0052928")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/tRNA_with_a_3'_cytidine ch/CTP_4-_)
    (owl-some hasProduct  ch/tRNA_with_a_3'_CC_end ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/tRNA_with_a_3'_CC_end ch/diphosphate_3-_)
    (owl-some hasProduct  ch/tRNA_with_a_3'_cytidine ch/CTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAtp:3'-Cytidine-Cytidine-tRNAAdenylyltransferaseActivity
  :annotation (goid "GO:0052929")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/tRNA_with_a_3'_CC_end ch/ATP_4-_)
    (owl-some hasProduct  ch/tRNA_with_a_3'_CCA_end ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/tRNA_with_a_3'_CCA_end ch/diphosphate_3-_)
    (owl-some hasProduct  ch/tRNA_with_a_3'_CC_end ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse4-HydroxyglutamateTransaminaseActivity
  :annotation (goid "GO:0047578")
  :annotation (database "RHEA:10480")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxy-L-glutamate_1-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_4-hydroxy-2-oxoglutarate_2-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxy-2-oxoglutarate_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_4-hydroxy-L-glutamate_1-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseO-AcetylhomoserineAminocarboxypropyltransferaseActivity
  :annotation (goid "GO:0003961")
  :annotation (database "RHEA:10048")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-acetyl-L-homoserine_zwitterion ch/methanethiol)
    (owl-some hasProduct  ch/L-methionine_zwitterion ch/acetate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/L-methionine_zwitterion ch/acetate ch/hydron)
    (owl-some hasProduct  ch/O-acetyl-L-homoserine_zwitterion ch/methanethiol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad+KinaseActivity
  :annotation (goid "GO:0003951")
  :annotation (database "RHEA:18629")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/NAD_1-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/NADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/NADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/NAD_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSedoheptulose-7-Phosphate:D-Glyceraldehyde-3-PhosphateGlyceronetransferaseActivity
  :annotation (goid "GO:0004801")
  :annotation (database "RHEA:17053")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sedoheptulose_7-phosphate_2-_ ch/D-glyceraldehyde_3-phosphate_2-_)
    (owl-some hasProduct  ch/D-erythrose_4-phosphate_2-_ ch/D-fructofuranose_6-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/D-erythrose_4-phosphate_2-_ ch/D-fructofuranose_6-phosphate_2-_)
    (owl-some hasProduct  ch/sedoheptulose_7-phosphate_2-_ ch/D-glyceraldehyde_3-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCyanidin-3-O-Glucoside2-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0102160")
  :annotation (database "RHEA:28258")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/UDP-alpha-D-glucuronate_3-_)
    (owl-some hasProduct  ch/hydron ch/cyanidin_3-O-_2-O-beta-D-glucuronosyl_-beta-D-glucoside_2-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/cyanidin_3-O-_2-O-beta-D-glucuronosyl_-beta-D-glucoside_2-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/cyanidin_3-O-beta-D-glucoside_1-_ ch/UDP-alpha-D-glucuronate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad_P_+-Protein-ArginineAdp-RibosyltransferaseActivity
  :annotation (goid "GO:0003956")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/NAD_1-_ ch/L-argininium_residue)
    (owl-some hasProduct  ch/nicotinamide ch/N_omega_-_ADP-D-ribosyl_-L-argininium_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/nicotinamide ch/N_omega_-_ADP-D-ribosyl_-L-argininium_1-__residue ch/hydron)
    (owl-some hasProduct  ch/NAD_1-_ ch/L-argininium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDol-P-Man:Man_6_Glcnac_2_-Pp-DolAlpha-1_2-MannosyltransferaseActivity
  :annotation (goid "GO:0052926")
  :annotation (database "RHEA:29531")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)
    (owl-some hasProduct  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCtp:tRNACytidylyltransferaseActivity
  :annotation (goid "GO:0052927")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/tRNA_precursor ch/CTP_4-_)
    (owl-some hasProduct  ch/tRNA_with_a_3'_cytidine ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/tRNA_with_a_3'_cytidine ch/diphosphate_3-_)
    (owl-some hasProduct  ch/tRNA_precursor ch/CTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAll-Trans-Nonaprenyl-DiphosphateSynthase_geranylgeranyl-diphosphateSpecific_Activity
  :annotation (goid "GO:0052924")
  :annotation (database "RHEA:27594")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNA_5-methylaminomethyl-2-thiouridylate_-methyltransferaseActivity
  :annotation (goid "GO:0004808")
  :annotation (database "RHEA:19569")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_5-aminomethyl-2-thiouridine_5'-monophosphate_zwitterion_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-methylaminomethyl-2-thiouridine_5'-monophosphate_zwitterion_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_5-methylaminomethyl-2-thiouridine_5'-monophosphate_zwitterion_residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_5-aminomethyl-2-thiouridine_5'-monophosphate_zwitterion_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDol-P-Man:Man_5_Glcnac_2_-Pp-DolAlpha-1_3-MannosyltransferaseActivity
  :annotation (goid "GO:0052925")
  :annotation (database "RHEA:29527")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)
    (owl-some hasProduct  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->3_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/alpha-D-Man-_1->2_-alpha-D-Man-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-alpha-D-GlcNAc_PP-Dol__2-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse5-Methyl-Phenazine-1-CarboxylateN-MethyltransferaseActivity
  :annotation (goid "GO:0102168")
  :annotation (database "RHEA:49112")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phenazine-1-carboxylate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_5-methylphenazine-1-carboxylate ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_5-methylphenazine-1-carboxylate ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/phenazine-1-carboxylate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHexaprenylDiphosphateSynthase_geranylgeranyl-diphosphateSpecific_Activity
  :annotation (goid "GO:0052922")
  :annotation (database "RHEA:27555")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/all-trans-hexaprenyl_diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/all-trans-hexaprenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAll-Trans-Nonaprenyl-DiphosphateSynthase_geranyl-diphosphateSpecific_Activity
  :annotation (goid "GO:0052923")
  :annotation (database "RHEA:27563")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/geranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/all-trans-nonaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/geranyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMannosylfructose-PhosphateSynthaseActivity
  :annotation (goid "GO:0103011")
  :annotation (database "RHEA:26039")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/beta-D-fructofuranose_6-phosphate_2-_)
    (owl-some hasProduct  ch/beta-D-fructofuranosyl_alpha-D-mannopyranoside_6_F_-phosphate_2-_ ch/GDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/beta-D-fructofuranosyl_alpha-D-mannopyranoside_6_F_-phosphate_2-_ ch/GDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/beta-D-fructofuranose_6-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydrogen-SulfideS-AcetyltransferaseActivity
  :annotation (goid "GO:0047986")
  :annotation (database "RHEA:16625")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/hydrosulfide)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/thioacetate))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/thioacetate)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/hydrosulfide)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_deoxy_nucleoside-phosphateKinaseActivity
  :annotation (goid "GO:0047507")
  :annotation (database "RHEA:11216")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_2'-deoxynucleoside_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_2'-deoxyribonucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_2'-deoxyribonucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_2'-deoxynucleoside_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_deoxy_adenylateKinaseActivity
  :annotation (goid "GO:0047506")
  :annotation (database "RHEA:23100")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/dADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/dADP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseXylulokinaseActivity
  :annotation (goid "GO:0004856")
  :annotation (database "RHEA:10964")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-xylulose ch/ATP_4-_)
    (owl-some hasProduct  ch/D-xylulose_5-phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/D-xylulose_5-phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-xylulose ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxylysineKinaseActivity
  :annotation (goid "GO:0047992")
  :annotation (database "RHEA:19049")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/erythro-5-hydroxy-L-lysinium_1+_ ch/GTP_4-_)
    (owl-some hasProduct  ch/erythro-5-phosphonatoooxy-L-lysinium_1-_ ch/GDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/erythro-5-phosphonatoooxy-L-lysinium_1-_ ch/GDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/erythro-5-hydroxy-L-lysinium_1+_ ch/GTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDermatan6-SulfotransferaseActivity
  :annotation (goid "GO:0036443")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phospho-5'-adenylyl_sulfate ch/dermatan)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/dermatan_6'-sulfate))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/dermatan_6'-sulfate)
    (owl-some hasProduct  ch/_3'-phospho-5'-adenylyl_sulfate ch/dermatan)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCitrateSynthaseActivity
  :annotation (goid "GO:0036440")
  :annotation (database "RHEA:16845")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/water ch/oxaloacetate_2-_)
    (owl-some hasProduct  ch/citrate_3-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/citrate_3-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/water ch/oxaloacetate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Glutamine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0080100")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-glutamine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_2-oxoglutaramate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutaramate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-glutamine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1_3-Beta-D-GlucanPhosphorylaseActivity
  :annotation (goid "GO:0047514")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1->3_-beta-D-glucan ch/hydrogenphosphate)
    (owl-some hasProduct  ch/_1->3_-beta-D-glucan ch/alpha-D-glucose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/_1->3_-beta-D-glucan ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/_1->3_-beta-D-glucan ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphatidyl-N-DimethylethanolamineN-MethyltransferaseActivity
  :annotation (goid "GO:0080101")
  :annotation (database "RHEA:32739")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_1_2-diacyl-sn-glycero-3-phospho-N-methylethanolamine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1_2-diacyl-sn-glycero-3-phospho-N_N-dimethylethanolamine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_1_2-diacyl-sn-glycero-3-phospho-N_N-dimethylethanolamine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_1_2-diacyl-sn-glycero-3-phospho-N-methylethanolamine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1_4-Beta-D-XylanSynthaseActivity
  :annotation (goid "GO:0047517")
  :annotation (database "RHEA:15289")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-xylose_2-_ ch/_1->4_-beta-D-xylan)
    (owl-some hasProduct  ch/UDP_3-_ ch/_1->4_-beta-D-xylan ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/_1->4_-beta-D-xylan ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-xylose_2-_ ch/_1->4_-beta-D-xylan)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1_3-Beta-OligoglucanPhosphorylaseActivity
  :annotation (goid "GO:0047515")
  :annotation (database "RHEA:16041")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1->3_-beta-D-glucan ch/hydrogenphosphate)
    (owl-some hasProduct  ch/_1->3_-beta-D-glucan ch/alpha-D-glucose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/_1->3_-beta-D-glucan ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/_1->3_-beta-D-glucan ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCmpKinaseActivity
  :annotation (goid "GO:0036430")
  :annotation (database "RHEA:11600")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/cytidine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/CDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/CDP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/cytidine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDcmpKinaseActivity
  :annotation (goid "GO:0036431")
  :annotation (database "RHEA:25094")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/dCDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/dCDP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL_L-DiaminopimelateAminotransferaseActivity
  :annotation (goid "GO:0010285")
  :annotation (database "RHEA:23988")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/_2S_6S_-2_6-diaminopimelic_acid_dizwitterion)
    (owl-some hasProduct  ch/_S_-2_3_4_5-tetrahydrodipicolinate_2-_ ch/L-glutamate_1-_ ch/water ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_S_-2_3_4_5-tetrahydrodipicolinate_2-_ ch/L-glutamate_1-_ ch/water ch/hydron)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/_2S_6S_-2_6-diaminopimelic_acid_dizwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDi-Trans_Poly-Cis-UndecaprenolKinaseActivity
  :annotation (goid "GO:0036433")
  :annotation (database "RHEA:28122")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ditrans_polycis-undecaprenol ch/ATP_4-_)
    (owl-some hasProduct  ch/ditrans_polycis-undecaprenyl_phosphate_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ditrans_polycis-undecaprenyl_phosphate_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/ditrans_polycis-undecaprenol ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetylglutamateKinaseActivity
  :annotation (goid "GO:0003991")
  :annotation (database "RHEA:14629")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N-acetyl-L-glutamate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/N-acetyl-L-gamma-glutamyl_phosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/N-acetyl-L-gamma-glutamyl_phosphate_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/N-acetyl-L-glutamate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN2-Acetyl-L-Ornithine:2-Oxoglutarate5-AminotransferaseActivity
  :annotation (goid "GO:0003992")
  :annotation (database "RHEA:18049")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/N_2_-acetyl-L-ornithine_zwitterion)
    (owl-some hasProduct  ch/_2-acetamido-5-oxopentanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_2-acetamido-5-oxopentanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/N_2_-acetyl-L-ornithine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetolactateSynthaseActivity
  :annotation (goid "GO:0003984")
  :annotation (database "RHEA:25249")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyruvate ch/pyruvate ch/hydron)
    (owl-some hasProduct  ch/_2-acetyllactate ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/_2-acetyllactate ch/carbon_dioxide)
    (owl-some hasProduct  ch/pyruvate ch/pyruvate ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetyl-CoaC-AcetyltransferaseActivity
  :annotation (goid "GO:0003985")
  :annotation (database "RHEA:21036")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/acetoacetyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/acetoacetyl-CoA_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProtein-Fructosamine3-KinaseActivity
  :annotation (goid "GO:0102194")
  :annotation (database "RHEA:59832")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N_6_-_D-fructosyl_-L-lysinium_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/N_6_-_3-O-phospho-D-fructosyl_-L-lysinium_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/N_6_-_3-O-phospho-D-fructosyl_-L-lysinium_1-__residue)
    (owl-some hasProduct  ch/ATP_4-_ ch/N_6_-_D-fructosyl_-L-lysinium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProtein-Ribulosamine3-KinaseActivity
  :annotation (goid "GO:0102193")
  :annotation (database "RHEA:48432")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N_6_-D-ribulosyl-L-lysinium_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/N_6_-_3-O-phospho-D-ribulosyl_-L-lysinium_residue))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/N_6_-_3-O-phospho-D-ribulosyl_-L-lysinium_residue)
    (owl-some hasProduct  ch/ATP_4-_ ch/N_6_-D-ribulosyl-L-lysinium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetyl-CoaC-AcyltransferaseActivity
  :annotation (goid "GO:0003988")
  :annotation (database "RHEA:21564")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_3-oxoacyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_3-oxoacyl-CoA_4-_)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2_5-DiaminovalerateTransaminaseActivity
  :annotation (goid "GO:0047531")
  :annotation (database "RHEA:16017")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-ornithinium_1+_)
    (owl-some hasProduct  ch/_5-amino-2-oxopentanoic_acid_zwitterion ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_5-amino-2-oxopentanoic_acid_zwitterion ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-ornithinium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Tyrosine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0004838")
  :annotation (database "RHEA:15093")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-tyrosine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_3-_4-hydroxyphenyl_pyruvate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3-_4-hydroxyphenyl_pyruvate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-tyrosine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAll-Trans-Undecaprenyl-PhosphateMannosyltransferaseActivity
  :annotation (goid "GO:0036427")
  :annotation (database "RHEA:28118")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/undecaprenyl_phosphate_2-_ ch/GDP-alpha-D-mannose_2-_)
    (owl-some hasProduct  ch/D-mannosyl_undecaprenyl_phosphate_1-_ ch/GDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/D-mannosyl_undecaprenyl_phosphate_1-_ ch/GDP_3-_)
    (owl-some hasProduct  ch/undecaprenyl_phosphate_2-_ ch/GDP-alpha-D-mannose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenosylcobinamideKinase_GTP-specific_Activity
  :annotation (goid "GO:0036428")
  :annotation (database "RHEA:15765")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide ch/GTP_4-_)
    (owl-some hasProduct  ch/adenosylcobinamide_phosphate_1-_ ch/GDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_phosphate_1-_ ch/GDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/adenosylcobinamide ch/GTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdenosylcobinamideKinase_ATP_4-_-specific_Activity
  :annotation (goid "GO:0036429")
  :annotation (database "RHEA:15769")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide ch/ATP_4-_)
    (owl-some hasProduct  ch/adenosylcobinamide_phosphate_1-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosylcobinamide_phosphate_1-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/adenosylcobinamide ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHexaprenyl-DiphosphateSynthase__2E_6E_-farnesyl-diphosphateSpecific_Activity
  :annotation (goid "GO:0036423")
  :annotation (database "RHEA:27559")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/all-trans-hexaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/all-trans-hexaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhytolKinaseActivity
  :annotation (goid "GO:0010276")
  :annotation (database "RHEA:38055")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phytol ch/CTP_4-_)
    (owl-some hasProduct  ch/phytyl_phosphate_2-_ ch/CDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/phytyl_phosphate_2-_ ch/CDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/phytol ch/CTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDitrans_Polycis-Undecaprenyl-PhosphateMannosyltransferaseActivity
  :annotation (goid "GO:0036426")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ditrans_polycis-undecaprenyl_phosphate_2-_ ch/GDP-alpha-D-mannose_2-_)
    (owl-some hasProduct  ch/D-mannosyl_undecaprenyl_phosphate_1-_ ch/GDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/D-mannosyl_undecaprenyl_phosphate_1-_ ch/GDP_3-_)
    (owl-some hasProduct  ch/ditrans_polycis-undecaprenyl_phosphate_2-_ ch/GDP-alpha-D-mannose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAbscisicAcidGlucosyltransferaseActivity
  :annotation (goid "GO:0010294")
  :annotation (database "RHEA:31031")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_+_-abscisate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/_+_-abscisic_acid_beta-D-glucopyranosyl_ester))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/_+_-abscisic_acid_beta-D-glucopyranosyl_ester)
    (owl-some hasProduct  ch/_+_-abscisate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHeptaprenylDiphosphateSynthaseActivity
  :annotation (goid "GO:0036422")
  :annotation (database "RHEA:27794")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/all-trans-heptaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/all-trans-heptaprenyl_diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_2-trans_6-trans-farnesyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-AminoadipateTransaminaseActivity
  :annotation (goid "GO:0047536")
  :annotation (database "RHEA:12601")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-2-aminoadipate_1-_)
    (owl-some hasProduct  ch/_2-oxoadipate_2-_ ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_2-oxoadipate_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-2-aminoadipate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUridinePhosphorylaseActivity
  :annotation (goid "GO:0004850")
  :annotation (database "RHEA:24388")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/uridine ch/hydrogenphosphate)
    (owl-some hasProduct  ch/uracil ch/alpha-D-ribose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/uracil ch/alpha-D-ribose_1-phosphate_2-_)
    (owl-some hasProduct  ch/uridine ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUroporphyrin-IiiC-MethyltransferaseActivity
  :annotation (goid "GO:0004851")
  :annotation (database "RHEA:32459")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/uroporphyrinogen_III_8-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/precorrin-2_7-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/precorrin-2_7-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/uroporphyrinogen_III_8-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-AminohexanoateTransaminaseActivity
  :annotation (goid "GO:0047537")
  :annotation (database "RHEA:23600")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-2-aminohexanoic_acid_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_2-oxohexanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_2-oxohexanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-2-aminohexanoic_acid_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrans-HexaprenyltranstransferaseActivity
  :annotation (goid "GO:0000010")
  :annotation (database "RHEA:20836")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/all-trans-hexaprenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-heptaprenyl_diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/all-trans-heptaprenyl_diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/all-trans-hexaprenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUracilPhosphoribosyltransferaseActivity
  :annotation (goid "GO:0004845")
  :annotation (database "RHEA:13017")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/uridine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/uracil))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/uracil)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/uridine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdeninePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0003999")
  :annotation (database "RHEA:16609")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosine_5'-monophosphate_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/adenine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_))
   (owl-and
    (owl-some hasReactant  ch/adenine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_)
    (owl-some hasProduct  ch/adenosine_5'-monophosphate_2-_ ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUridineKinaseActivity
  :annotation (goid "GO:0004849")
  :annotation (database "RHEA:16825")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/uridine)
    (owl-some hasProduct  ch/ADP_3-_ ch/uridine_5'-monophosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/uridine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/uridine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKaempferol3-Glucoside7-O-RhamnosyltransferaseActivity
  :annotation (goid "GO:0103058")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/kaempferol_3-O-beta-D-glucoside ch/UDP-beta-L-rhamnose_2-_)
    (owl-some hasProduct  ch/kaempferol_3-O-beta-D-glucopyranosyl-7-O-alpha-L-rhamnopyranoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/kaempferol_3-O-beta-D-glucopyranosyl-7-O-alpha-L-rhamnopyranoside ch/UDP_3-_)
    (owl-some hasProduct  ch/kaempferol_3-O-beta-D-glucoside ch/UDP-beta-L-rhamnose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-L-Rhamnose:Kaempferol3-O-RhamnosyltransferaseActivity
  :annotation (goid "GO:0103059")
  :annotation (database "RHEA:61164")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/kaempferol_oxoanion ch/UDP-beta-L-rhamnose_2-_)
    (owl-some hasProduct  ch/hydron ch/afzelin_1-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/afzelin_1-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/kaempferol_oxoanion ch/UDP-beta-L-rhamnose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetyl-Coa:OxalateCoa-Transferase	
  :annotation (goid "GO:0036412")
  :annotation (database "RHEA:37883")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/oxalate)
    (owl-some hasProduct  ch/acetate ch/oxalyl-CoA_5-_))
   (owl-and
    (owl-some hasReactant  ch/acetate ch/oxalyl-CoA_5-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/oxalate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKynurenine-OxaloacetateTransaminaseActivity
  :annotation (goid "GO:0036136")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-kynurenine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_4-_2-aminophenyl_-2_4-dioxobutanoate ch/L-aspartate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_4-_2-aminophenyl_-2_4-dioxobutanoate ch/L-aspartate_1-_)
    (owl-some hasProduct  ch/L-kynurenine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiolS-MethyltransferaseActivity
  :annotation (goid "GO:0018708")
  :annotation (database "RHEA:18277")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/thiol)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/methyl_sulfide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/methyl_sulfide ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/thiol)))
  :enzyme Transferase)

(defcatalyse ToCatalysePoly_Ribitol-Phosphate_N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0047269")
  :annotation (database "RHEA:21012")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/poly_ribitol_phosphate_ ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/poly_2-O-_N-acetyl-D-glucosaminyl_ribitol_phosphate_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/poly_2-O-_N-acetyl-D-glucosaminyl_ribitol_phosphate_ ch/UDP_3-_)
    (owl-some hasProduct  ch/poly_ribitol_phosphate_ ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucosaminylgalactosylglucosylceramideBeta-GalactosyltransferaseActivity
  :annotation (goid "GO:0047275")
  :annotation (database "RHEA:16045")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_d18:1_4E__ ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/beta-D-Gal-_1->3_-beta-D-GlcNAc-_1->3_-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/beta-D-Gal-_1->3_-beta-D-GlcNAc-_1->3_-beta-D-Gal-_1->4_-beta-D-Glc-_1<->1'_-Cer ch/UDP_3-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_d18:1_4E__ ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactinol-SucroseGalactosyltransferaseActivity
  :annotation (goid "GO:0047274")
  :annotation (database "RHEA:20161")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sucrose ch/alpha-D-galactosyl-_1->3_-1D-myo-inositol)
    (owl-some hasProduct  ch/raffinose ch/myo-inositol))
   (owl-and
    (owl-some hasReactant  ch/raffinose ch/myo-inositol)
    (owl-some hasProduct  ch/sucrose ch/alpha-D-galactosyl-_1->3_-1D-myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosylgalactosylglucosylceramideBeta-D-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0047273")
  :annotation (database "RHEA:22252")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)
    (owl-some hasProduct  ch/UDP_3-_ ch/N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-galactosamine_2-_ ch/alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphopolyprenolGlucosyltransferaseActivity
  :annotation (goid "GO:0047272")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/polyprenol_phosphate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/polyprenyl_glucosyl_phosphate ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/polyprenyl_glucosyl_phosphate ch/UDP_3-_)
    (owl-some hasProduct  ch/polyprenol_phosphate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSn-Glycerol-3-Phosphate1-GalactosyltransferaseActivity
  :annotation (goid "GO:0047279")
  :annotation (database "RHEA:20341")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sn-glycerol_3-phosphate_2-_ ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/_1-alpha-D-galactosyl-sn-glycerol_3-phosphate_2-_ ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1-alpha-D-galactosyl-sn-glycerol_3-phosphate_2-_ ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/sn-glycerol_3-phosphate_2-_ ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBilirubin-GlucuronosideGlucuronosyltransferaseActivity
  :annotation (goid "GO:0047278")
  :annotation (database "RHEA:16885")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/mono_glucosyluronic_acid_bilirubin_2-_ ch/mono_glucosyluronic_acid_bilirubin_2-_)
    (owl-some hasProduct  ch/bilirubin_2-_ ch/bis_beta-glucosyluronate_bilirubin))
   (owl-and
    (owl-some hasReactant  ch/bilirubin_2-_ ch/bis_beta-glucosyluronate_bilirubin)
    (owl-some hasProduct  ch/mono_glucosyluronic_acid_bilirubin_2-_ ch/mono_glucosyluronic_acid_bilirubin_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlobosideAlpha-N-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0047277")
  :annotation (database "RHEA:22164")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-alpha-D-galactosaminyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-alpha-D-galactosaminyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acetyl-beta-D-galactosaminyl-_1->3_-alpha-D-galactosyl-_1->4_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-Acetyllactosaminide3-Alpha-GalactosyltransferaseActivity
  :annotation (goid "GO:0047276")
  :annotation (database "RHEA:13013")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/alpha-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/alpha-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Hydroxy-3-OxoadipateSynthaseActivity
  :annotation (goid "GO:0050439")
  :annotation (database "RHEA:14341")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/glyoxylate ch/hydron)
    (owl-some hasProduct  ch/_2-hydroxy-3-oxoadipate_2-_ ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/_2-hydroxy-3-oxoadipate_2-_ ch/carbon_dioxide)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/glyoxylate ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-EthylmalateSynthaseActivity
  :annotation (goid "GO:0050438")
  :annotation (database "RHEA:23040")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxobutanoate ch/acetyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/_R_-2-ethylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_R_-2-ethylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/_2-oxobutanoate ch/acetyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycosaminoglycanGalactosyltransferaseActivity
  :annotation (goid "GO:0047271")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/glycosaminoglycan ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/D-galactosylglycosaminoglycan ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/D-galactosylglycosaminoglycan ch/UDP_3-_)
    (owl-some hasProduct  ch/glycosaminoglycan ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharideGlucosyltransferaseIiActivity
  :annotation (goid "GO:0047270")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/lipopolysaccharide ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/D-glucosyllipopolysaccharide ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/D-glucosyllipopolysaccharide ch/UDP_3-_)
    (owl-some hasProduct  ch/lipopolysaccharide ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolTetrakisphosphateKinaseActivity
  :annotation (goid "GO:0051765")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_tetrakisphosphate ch/ATP_4-_)
    (owl-some hasProduct  ch/myo-inositol_pentakisphosphate ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_pentakisphosphate ch/ADP_3-_)
    (owl-some hasProduct  ch/myo-inositol_tetrakisphosphate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSite-SpecificDna-Methyltransferase_cytosine-N4-specific_Activity
  :annotation (goid "GO:0015667")
  :annotation (database "RHEA:16857")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_2'-deoxycytidine_5'-monophosphate_1-__residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_4_-methyl-dCMP_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_4_-methyl-dCMP_1-__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_2'-deoxycytidine_5'-monophosphate_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Hydroxybutyryl-CoaThiolaseActivity
  :annotation (goid "GO:0018712")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-hydroxy-5-oxohexanoyl-CoA ch/coenzyme_A)
    (owl-some hasProduct  ch/_S_-3-hydroxybutanoyl-CoA ch/acetyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/_S_-3-hydroxybutanoyl-CoA ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_3-hydroxy-5-oxohexanoyl-CoA ch/coenzyme_A)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolTrisphosphateKinaseActivity
  :annotation (goid "GO:0051766")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_trisphosphate ch/ATP_4-_)
    (owl-some hasProduct  ch/myo-inositol_tetrakisphosphate ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_tetrakisphosphate ch/ADP_3-_)
    (owl-some hasProduct  ch/myo-inositol_trisphosphate ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBenzoylAcetate-CoaThiolaseActivity
  :annotation (goid "GO:0018711")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/benzoylacetyl-CoA ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/benzoyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/benzoyl-CoA_4-_)
    (owl-some hasProduct  ch/benzoylacetyl-CoA ch/coenzyme_A_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseButane-1_4-Diamine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0033094")
  :annotation (database "RHEA:12268")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_4-butanediammonium ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/_1-pyrrolinium ch/water))
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/_1-pyrrolinium ch/water)
    (owl-some hasProduct  ch/_1_4-butanediammonium ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNucleosideDiphosphateKinaseActivity
  :annotation (goid "GO:0004550")
  :annotation (database "RHEA:18113")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/nucleoside_triphosphate_4-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/nucleoside_triphosphate_4-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/nucleoside_5'-diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKanamycinKinaseActivity
  :annotation (goid "GO:0008910")
  :annotation (database "RHEA:24256")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/kanamycin_A_4+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/kanamycin_A_3'-phosphate_2+_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/kanamycin_A_3'-phosphate_2+_)
    (owl-some hasProduct  ch/ATP_4-_ ch/kanamycin_A_4+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHygromycin-B7_-O-PhosphotransferaseActivity
  :annotation (goid "GO:0008904")
  :annotation (database "RHEA:23388")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/hygromycin_B_3+_)
    (owl-some hasProduct  ch/_7''-O-phosphohygromycin_B_1+_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_7''-O-phosphohygromycin_B_1+_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/hygromycin_B_3+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNad+-DiphthamideAdp-RibosyltransferaseActivity
  :annotation (goid "GO:0047286")
  :annotation (database "RHEA:11820")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphthamide_residue ch/NAD_1-_)
    (owl-some hasProduct  ch/N-_ADP-D-ribosyl_diphthamide_1-__residue ch/nicotinamide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-_ADP-D-ribosyl_diphthamide_1-__residue ch/nicotinamide ch/hydron)
    (owl-some hasProduct  ch/diphthamide_residue ch/NAD_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-PropylmalateSynthaseActivity
  :annotation (goid "GO:0050442")
  :annotation (database "RHEA:14457")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/glyoxylate ch/water ch/pentanoyl-CoA_4-_)
    (owl-some hasProduct  ch/_3-propylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-propylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/glyoxylate ch/water ch/pentanoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiguanylateCyclaseActivity
  :annotation (goid "GO:0052621")
  :annotation (database "RHEA:24898")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/GTP_4-_)
    (owl-some hasProduct  ch/c-di-GMP_2-_ ch/diphosphate_3-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/c-di-GMP_2-_ ch/diphosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/GTP_4-_ ch/GTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-GlycosideXylosyltransferaseActivity
  :annotation (goid "GO:0047285")
  :annotation (database "RHEA:19701")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-glycoside ch/UDP-alpha-D-xylose_2-_)
    (owl-some hasProduct  ch/flavonol_3-O-_beta-D-xylosyl-_1->2_-beta-D-glycoside_s ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-_beta-D-xylosyl-_1->2_-beta-D-glycoside_s ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/flavonol_3-O-glycoside ch/UDP-alpha-D-xylose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-EthylmalateSynthaseActivity
  :annotation (goid "GO:0050441")
  :annotation (database "RHEA:10500")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/butyryl-CoA_4-_ ch/glyoxylate ch/water)
    (owl-some hasProduct  ch/_3-ethylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-ethylmalate_2-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/butyryl-CoA_4-_ ch/glyoxylate ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAtpDimethylallyltransferaseActivity
  :annotation (goid "GO:0052622")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/N_6_-_dimethylallyl_adenosine_5'-triphosphate_4-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/N_6_-_dimethylallyl_adenosine_5'-triphosphate_4-_)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxymethylpyrimidineKinaseActivity
  :annotation (goid "GO:0008902")
  :annotation (database "RHEA:23096")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-amino-5-hydroxymethyl-2-methylpyrimidine ch/ATP_4-_)
    (owl-some hasProduct  ch/_4-amino-2-methyl-5-phosphonatooxymethylpyrimidine_2-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_4-amino-2-methyl-5-phosphonatooxymethylpyrimidine_2-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_4-amino-5-hydroxymethyl-2-methylpyrimidine ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-Xylosyl-Phosphate-ProteinXylosyltransferaseActivity
  :annotation (goid "GO:0047284")
  :annotation (database "RHEA:18361")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/dolichyl_D-xylosyl_phosphate_1-_ ch/L-serine_residue)
    (owl-some hasProduct  ch/dolichyl_phosphate_2-_ ch/O_3_-_beta-D-xylosyl_-L-serine_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/dolichyl_phosphate_2-_ ch/O_3_-_beta-D-xylosyl_-L-serine_residue ch/hydron)
    (owl-some hasProduct  ch/dolichyl_D-xylosyl_phosphate_1-_ ch/L-serine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-PhosphateD-XylosyltransferaseActivity
  :annotation (goid "GO:0047283")
  :annotation (database "RHEA:15361")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/dolichyl_phosphate_2-_ ch/UDP-alpha-D-xylose_2-_)
    (owl-some hasProduct  ch/dolichyl_D-xylosyl_phosphate_1-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/dolichyl_D-xylosyl_phosphate_1-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/dolichyl_phosphate_2-_ ch/UDP-alpha-D-xylose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosyldiacylglycerolAlpha-2_3-SialyltransferaseActivity
  :annotation (goid "GO:0047289")
  :annotation (database "RHEA:11664")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-3-beta-D-galactosyl-sn-glycerol ch/CMP-N-acetyl-beta-neuraminate_2-_)
    (owl-some hasProduct  ch/_1_2-diacyl-3-_3-_alpha-D-N-acetylneuraminyl_-beta-D-galactosyl_-sn-glycerol_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-3-_3-_alpha-D-N-acetylneuraminyl_-beta-D-galactosyl_-sn-glycerol_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/_1_2-diacyl-3-beta-D-galactosyl-sn-glycerol ch/CMP-N-acetyl-beta-neuraminate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInosineKinaseActivity
  :annotation (goid "GO:0008906")
  :annotation (database "RHEA:21140")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/inosine)
    (owl-some hasProduct  ch/ADP_3-_ ch/IMP_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/IMP_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/inosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMonosialogangliosideSialyltransferaseActivity
  :annotation (goid "GO:0047288")
  :annotation (database "RHEA:18021")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminosyl-_2->3_-_beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_--N-acylsphingosine_1-_ ch/CMP-N-acetyl-beta-neuraminate_2-_)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4_-_alpha-N-acetylneuraminosyl-_2->3__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_2-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4_-_alpha-N-acetylneuraminosyl-_2->3__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_2-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminosyl-_2->3_-_beta-D-galactosyl-_1->3_-N-acetyl-beta-D-galactosaminyl-_1->4__-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_--N-acylsphingosine_1-_ ch/CMP-N-acetyl-beta-neuraminate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-MethylcitrateSynthaseActivity
  :annotation (goid "GO:0050440")
  :annotation (database "RHEA:23780")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/water ch/oxaloacetate_2-_ ch/propionyl-CoA_4-_)
    (owl-some hasProduct  ch/_2R_3S_-2-methylcitrate_3-_ ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2R_3S_-2-methylcitrate_3-_ ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/water ch/oxaloacetate_2-_ ch/propionyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLactosylceramideAlpha-2_6-N-SialyltransferaseActivity
  :annotation (goid "GO:0047287")
  :annotation (database "RHEA:21552")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/CMP-N-acetyl-beta-neuraminate_2-_)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminyl-_2->6_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminyl-_2->6_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/CMP-N-acetyl-beta-neuraminate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDtdp-Dihydrostreptose-Streptidine-6-PhosphateDihydrostreptosyltransferaseActivity
  :annotation (goid "GO:0047282")
  :annotation (database "RHEA:24392")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/dTDP-L-dihydrostreptose_2-_ ch/streptidine_6-phosphate_zwitterion)
    (owl-some hasProduct  ch/O-_1->4_-alpha-L-dihydrostreptosylstreptidine_6-phosphate_zwitterion ch/dTDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/O-_1->4_-alpha-L-dihydrostreptosylstreptidine_6-phosphate_zwitterion ch/dTDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/dTDP-L-dihydrostreptose_2-_ ch/streptidine_6-phosphate_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDioxotetrahydropyrimidinePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0047281")
  :annotation (database "RHEA:10232")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_5_6-dihydrouridine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/_5_6-dihydrouracil))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/_5_6-dihydrouracil)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_5_6-dihydrouridine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinamidePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0047280")
  :annotation (database "RHEA:16149")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/NMN_-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/nicotinamide))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/nicotinamide)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/NMN_-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAdpDimethylallyltransferaseActivity
  :annotation (goid "GO:0052623")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/ADP_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/N_6_-_dimethylallyl_adenosine_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/N_6_-_dimethylallyl_adenosine_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/ADP_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseZeatin9-AminocarboxyethyltransferaseActivity
  :annotation (goid "GO:0050447")
  :annotation (database "RHEA:17333")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-acetyl-L-serine_zwitterion ch/zeatin)
    (owl-some hasProduct  ch/L-lupinic_acid_zwitterion ch/acetate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/L-lupinic_acid_zwitterion ch/acetate ch/hydron)
    (owl-some hasProduct  ch/O-acetyl-L-serine_zwitterion ch/zeatin)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Phytyl-1_4-NaphthoquinoneMethyltransferaseActivity
  :annotation (goid "GO:0052624")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-phytyl-1_4-dihydroxynaphthalene ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/phyllohydroquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/phyllohydroquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_2-phytyl-1_4-dihydroxynaphthalene ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMolybdopterinAdenylyltransferaseActivity
  :annotation (goid "GO:0061598")
  :annotation (database "RHEA:31331")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/molybdopterin_3-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/molybdopterin_adenine_dinucleotide_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/molybdopterin_adenine_dinucleotide_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/molybdopterin_3-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6-Deoxy-6-SulfofructoseKinaseActivity
  :annotation (goid "GO:0061594")
  :annotation (database "RHEA:40443")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6-deoxy-6-sulfo-D-fructofuranose_1-_ ch/ATP_4-_ ch/hydron)
    (owl-some hasProduct  ch/_6-deoxy-6-sulfo-D-fructofuranose_1-phosphate_3-_ ch/ADP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_6-deoxy-6-sulfo-D-fructofuranose_1-phosphate_3-_ ch/ADP_3-_)
    (owl-some hasProduct  ch/_6-deoxy-6-sulfo-D-fructofuranose_1-_ ch/ATP_4-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMolybdopterinMolybdotransferaseActivity
  :annotation (goid "GO:0061599")
  :annotation (database "RHEA:35047")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/molybdopterin_adenine_dinucleotide_3-_ ch/molybdate ch/hydron)
    (owl-some hasProduct  ch/MoO2-molybdopterin_cofactor_2-_ ch/adenosine_5'-monophosphate_2-_ ch/water))
   (owl-and
    (owl-some hasReactant  ch/MoO2-molybdopterin_cofactor_2-_ ch/adenosine_5'-monophosphate_2-_ ch/water)
    (owl-some hasProduct  ch/molybdopterin_adenine_dinucleotide_3-_ ch/molybdate ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNeolactotetraosylceramideAlpha-2_3-SialyltransferaseActivity
  :annotation (goid "GO:0004513")
  :annotation (database "RHEA:18913")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CMP-N-acetyl-beta-neuraminate_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)
    (owl-some hasProduct  ch/cytidine_5'-monophosphate_2-_ ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/cytidine_5'-monophosphate_2-_ ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_1-_ ch/hydron)
    (owl-some hasProduct  ch/CMP-N-acetyl-beta-neuraminate_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAsparagine-Oxo-AcidTransaminaseActivity
  :annotation (goid "GO:0047297")
  :annotation (database "RHEA:19813")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxo_monocarboxylic_acid_anion ch/L-asparagine_zwitterion)
    (owl-some hasProduct  ch/L-alpha-amino_acid_zwitterion ch/_2-oxosuccinamate))
   (owl-and
    (owl-some hasReactant  ch/L-alpha-amino_acid_zwitterion ch/_2-oxosuccinamate)
    (owl-some hasProduct  ch/_2-oxo_monocarboxylic_acid_anion ch/L-asparagine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHomospermidineSynthaseActivity
  :annotation (goid "GO:0047296")
  :annotation (database "RHEA:18645")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_4-butanediammonium ch/_1_4-butanediammonium)
    (owl-some hasProduct  ch/ammonium ch/sym-homospermidinium_3+_))
   (owl-and
    (owl-some hasReactant  ch/ammonium ch/sym-homospermidinium_3+_)
    (owl-some hasProduct  ch/_1_4-butanediammonium ch/_1_4-butanediammonium)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinate-NucleotideAdenylyltransferaseActivity
  :annotation (goid "GO:0004515")
  :annotation (database "RHEA:22860")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/nicotinate_D-ribonucleotide_2-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/deamido-NAD_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/deamido-NAD_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/nicotinate_D-ribonucleotide_2-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGeranylgeranylglycerol-PhosphateGeranylgeranyltransferaseActivity
  :annotation (goid "GO:0047295")
  :annotation (database "RHEA:18109")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sn-3-O-_geranylgeranyl_glycerol_1-phosphate_2-_ ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_2_3-bis-O-_geranylgeranyl_-sn-glycerol_1-phosphate_2-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2_3-bis-O-_geranylgeranyl_-sn-glycerol_1-phosphate_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/sn-3-O-_geranylgeranyl_glycerol_1-phosphate_2-_ ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-N-AcetylgalactosamineDiphosphorylaseActivity
  :annotation (goid "GO:0052630")
  :annotation (database "RHEA:34363")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UTP_4-_ ch/N-acetyl-alpha-D-galactosamine_1-phosphate_2-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/UDP-N-acetyl-alpha-D-galactosamine_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)
    (owl-some hasProduct  ch/UTP_4-_ ch/N-acetyl-alpha-D-galactosamine_1-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinate-NucleotideDiphosphorylase_carboxylating_Activity
  :annotation (goid "GO:0004514")
  :annotation (database "RHEA:12733")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/carbon_dioxide ch/diphosphate_3-_ ch/nicotinate_D-ribonucleotide_2-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/quinolinate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/quinolinate_2-_ ch/hydron)
    (owl-some hasProduct  ch/carbon_dioxide ch/diphosphate_3-_ ch/nicotinate_D-ribonucleotide_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphoglycerolGeranylgeranyltransferaseActivity
  :annotation (goid "GO:0047294")
  :annotation (database "RHEA:23404")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sn-glycerol_1-phosphate_2-_ ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_)
    (owl-some hasProduct  ch/sn-3-O-_geranylgeranyl_glycerol_1-phosphate_2-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/sn-3-O-_geranylgeranyl_glycerol_1-phosphate_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/sn-glycerol_1-phosphate_2-_ ch/_2-trans_6-trans_10-trans-geranylgeranyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinatePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0004516")
  :annotation (database "RHEA:13393")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/nicotinate_D-ribonucleotide_2-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/nicotinate))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/hydron ch/nicotinate)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/nicotinate_D-ribonucleotide_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTryptophan-PhenylpyruvateTransaminaseActivity
  :annotation (goid "GO:0047299")
  :annotation (database "RHEA:13741")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/keto-phenylpyruvate ch/L-tryptophan_zwitterion)
    (owl-some hasProduct  ch/_3-_indol-3-yl_pyruvate ch/L-phenylalanine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_3-_indol-3-yl_pyruvate ch/L-phenylalanine_zwitterion)
    (owl-some hasProduct  ch/keto-phenylpyruvate ch/L-tryptophan_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_S_-3-amino-2-methylpropionateTransaminaseActivity
  :annotation (goid "GO:0047298")
  :annotation (database "RHEA:13993")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_S_-3-aminoisobutyric_acid_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_2-methyl-3-oxopropanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_2-methyl-3-oxopropanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_S_-3-aminoisobutyric_acid_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipoateSynthaseActivity
  :annotation (goid "GO:0016992")
  :annotation (database "RHEA:16585")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/Protein_N6-_octanoyl_lysine ch/sulfur_atom ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/Protein_N6-_lipoyl_lysine ch/L-methionine_zwitterion ch/cobamamide ch/L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/Protein_N6-_lipoyl_lysine ch/L-methionine_zwitterion ch/cobamamide ch/L-methionine_zwitterion)
    (owl-some hasProduct  ch/Protein_N6-_octanoyl_lysine ch/sulfur_atom ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSalicylicAcidGlucosyltransferase_ester-forming_Activity
  :annotation (goid "GO:0052639")
  :annotation (database "RHEA:62316")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/salicylate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_1-O-salicyl-D-glucose ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1-O-salicyl-D-glucose ch/UDP_3-_)
    (owl-some hasProduct  ch/salicylate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse4-HydroxybenzoateNonaprenyltransferaseActivity
  :annotation (goid "GO:0047293")
  :annotation (database "RHEA:17709")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxybenzoate ch/all-trans-nonaprenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/_4-hydroxy-3-all-trans-nonaprenylbenzoate ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxy-3-all-trans-nonaprenylbenzoate ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_4-hydroxybenzoate ch/all-trans-nonaprenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDecylcitrateSynthaseActivity
  :annotation (goid "GO:0050457")
  :annotation (database "RHEA:16605")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/water ch/lauroyl-CoA_4-_ ch/oxaloacetate_2-_)
    (owl-some hasProduct  ch/_2S_3S_-2-hydroxytridecane-1_2_3-tricarboxylate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2S_3S_-2-hydroxytridecane-1_2_3-tricarboxylate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/water ch/lauroyl-CoA_4-_ ch/oxaloacetate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrihydroxypterocarpanDimethylallyltransferaseActivity
  :annotation (goid "GO:0047292")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3_6_9-trihydroxypterocarpan ch/prenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/glyceollin ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/glyceollin ch/diphosphate_3-_)
    (owl-some hasProduct  ch/_3_6_9-trihydroxypterocarpan ch/prenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLactosylceramideAlpha-2_3-SialyltransferaseActivity
  :annotation (goid "GO:0047291")
  :annotation (database "RHEA:18417")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/CMP-N-acetyl-beta-neuraminate_2-_)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/CMP-N-acetyl-beta-neuraminate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_alpha-N-acetylneuraminyl-2_3-beta-galactosyl-1_3_-N-acetyl-galactosaminide6-Alpha-SialyltransferaseActivity
  :annotation (goid "GO:0047290")
  :annotation (database "RHEA:53896")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminyl-2_3-beta-D-galactosyl-1_3-N-acetyl-D-galactosaminyl_group ch/CMP-N-acetyl-beta-neuraminate_2-_)
    (owl-some hasProduct  ch/beta-N-acetylneuraminyl-2_3-beta-D-galactosyl-1_3-_beta-N-acetylneuraminyl-2_6_-N-acetyl-D-galactosaminyl_2-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/beta-N-acetylneuraminyl-2_3-beta-D-galactosyl-1_3-_beta-N-acetylneuraminyl-2_6_-N-acetyl-D-galactosaminyl_2-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminyl-2_3-beta-D-galactosyl-1_3-N-acetyl-D-galactosaminyl_group ch/CMP-N-acetyl-beta-neuraminate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDecylhomocitrateSynthaseActivity
  :annotation (goid "GO:0050458")
  :annotation (database "RHEA:10364")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/water ch/lauroyl-CoA_4-_)
    (owl-some hasProduct  ch/_3S_4S_-3-hydroxytetradecane-1_3_4-tricarboxylate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3S_4S_-3-hydroxytetradecane-1_3_4-tricarboxylate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/water ch/lauroyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBenzoicAcidGlucosyltransferaseActivity
  :annotation (goid "GO:0052641")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/benzoic_acid ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/benzoyl-beta-D-glucoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/benzoyl-beta-D-glucoside ch/UDP_3-_)
    (owl-some hasProduct  ch/benzoic_acid ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylneuraminateSynthaseActivity
  :annotation (goid "GO:0050462")
  :annotation (database "RHEA:19273")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phosphoenolpyruvate ch/N-acetyl-D-mannosamine ch/water)
    (owl-some hasProduct  ch/hydrogenphosphate ch/N-acetylneuraminate))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/N-acetylneuraminate)
    (owl-some hasProduct  ch/phosphoenolpyruvate ch/N-acetyl-D-mannosamine ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-MimosineSynthaseActivity
  :annotation (goid "GO:0050461")
  :annotation (database "RHEA:12693")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyridine-3_4-diol ch/O-acetyl-L-serine_zwitterion)
    (owl-some hasProduct  ch/_3-_3_4-dihydroxypyridinium-1-yl_-L-alanine_zwitterion ch/acetate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-_3_4-dihydroxypyridinium-1-yl_-L-alanine_zwitterion ch/acetate ch/hydron)
    (owl-some hasProduct  ch/pyridine-3_4-diol ch/O-acetyl-L-serine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-PhosphateBeta-D-MannosyltransferaseActivity
  :annotation (goid "GO:0004582")
  :annotation (database "RHEA:21184")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/GDP_3-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/dolichyl_beta-D-mannosyl_phosphate_1-_)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/dolichyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1_2-Diacylglycerol3-GlucosyltransferaseActivity
  :annotation (goid "GO:0047228")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-sn-glycerol ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_3-beta-D-glucosyl-1_2-diacyl-sn-glycerol ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-beta-D-glucosyl-1_2-diacyl-sn-glycerol ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_1_2-diacyl-sn-glycerol ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-PhosphateBeta-GlucosyltransferaseActivity
  :annotation (goid "GO:0004581")
  :annotation (database "RHEA:15401")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/dolichyl_beta-D-glucosyl_phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/dolichyl_beta-D-glucosyl_phosphate_1-_)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/dolichyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIndolylacetyl-Myo-InositolGalactosyltransferaseActivity
  :annotation (goid "GO:0047227")
  :annotation (database "RHEA:21148")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/_5-O-_indol-3-ylacetyl_-myo-inositol_D-galactoside ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_5-O-_indol-3-ylacetyl_-myo-inositol_D-galactoside ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetylgalactosaminyl-O-Glycosyl-GlycoproteinBeta-1_6-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0047225")
  :annotation (database "RHEA:16552")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-N-acetyl-D-galactosaminyl_group ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-glucosaminyl-1_6-_N-acetyl-beta-D-glucosaminyl-1_3_-N-acetyl-D-galactosaminyl_group ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-glucosaminyl-1_6-_N-acetyl-beta-D-glucosaminyl-1_3_-N-acetyl-D-galactosaminyl_group ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-N-acetyl-D-galactosaminyl_group ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCholineO-AcetyltransferaseActivity
  :annotation (goid "GO:0004102")
  :annotation (database "RHEA:18821")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/choline)
    (owl-some hasProduct  ch/acetylcholine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/acetylcholine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/choline)))
  :enzyme Transferase)

(defcatalyse ToCatalyseOrnithineCarbamoyltransferaseActivity
  :annotation (goid "GO:0004585")
  :annotation (database "RHEA:19513")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/carbamoyl_phosphate_2-_ ch/L-ornithinium_1+_)
    (owl-some hasProduct  ch/hydrogenphosphate ch/L-citrulline ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/L-citrulline ch/hydron)
    (owl-some hasProduct  ch/carbamoyl_phosphate_2-_ ch/L-ornithinium_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseOrotatePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0004588")
  :annotation (database "RHEA:10380")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/orotidine_5'-phosphate_3-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/orotate ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_))
   (owl-and
    (owl-some hasReactant  ch/orotate ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_)
    (owl-some hasProduct  ch/orotidine_5'-phosphate_3-_ ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCholineKinaseActivity
  :annotation (goid "GO:0004103")
  :annotation (database "RHEA:12837")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/choline)
    (owl-some hasProduct  ch/ADP_3-_ ch/choline_phosphate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/choline_phosphate_1-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/choline)))
  :enzyme Transferase)

(defcatalyse ToCatalyseOrnithine-Oxo-AcidTransaminaseActivity
  :annotation (goid "GO:0004587")
  :annotation (database "RHEA:13877")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-ornithinium_1+_ ch/_2-oxo_monocarboxylic_acid_anion)
    (owl-some hasProduct  ch/L-glutamic_5-semialdehyde_zwitterion ch/L-alpha-amino_acid_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/L-glutamic_5-semialdehyde_zwitterion ch/L-alpha-amino_acid_zwitterion)
    (owl-some hasProduct  ch/L-ornithinium_1+_ ch/_2-oxo_monocarboxylic_acid_anion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse13-Hydroxydocosanoate13-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047229")
  :annotation (database "RHEA:22316")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_13-hydroxydocosanoate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_13-_beta-D-glucosyloxy_docosanoate ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_13-_beta-D-glucosyloxy_docosanoate ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_13-hydroxydocosanoate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-Diphosphooligosaccharide-ProteinGlycotransferaseActivity
  :annotation (goid "GO:0004579")
  :annotation (database "RHEA:22980")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/dolichyl_diphosphooligosaccharide_2-_ ch/L-asparagine_residue)
    (owl-some hasProduct  ch/dolichyl_diphosphate_3-_ ch/N_4_-_oligosaccharide-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->4_-N-acetyl-beta-D-glucosaminyl_-L-asparagine_residue))
   (owl-and
    (owl-some hasReactant  ch/dolichyl_diphosphate_3-_ ch/N_4_-_oligosaccharide-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->4_-N-acetyl-beta-D-glucosaminyl_-L-asparagine_residue)
    (owl-some hasProduct  ch/dolichyl_diphosphooligosaccharide_2-_ ch/L-asparagine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridoxine5'-O-Beta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047231")
  :annotation (database "RHEA:20177")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyridoxine ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_5'-O-beta-D-glucosylpyridoxine ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_5'-O-beta-D-glucosylpyridoxine ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/pyridoxine ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChitobiosyldiphosphodolicholBeta-MannosyltransferaseActivity
  :annotation (goid "GO:0004578")
  :annotation (database "RHEA:13865")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/N_N'-diacetylchitobiosyldiphosphonatodolichol_2-_)
    (owl-some hasProduct  ch/GDP_3-_ ch/beta-D-mannosyldiacetylchitobiosyldiphosphodolichol_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/beta-D-mannosyldiacetylchitobiosyldiphosphodolichol_2-_ ch/hydron)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/N_N'-diacetylchitobiosyldiphosphonatodolichol_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavonol-3-O-GlucosideL-RhamnosyltransferaseActivity
  :annotation (goid "GO:0047230")
  :annotation (database "RHEA:22528")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-beta-D-glucoside ch/UDP-beta-L-rhamnose_2-_)
    (owl-some hasProduct  ch/flavonol_3-O-_alpha-L-rhamnosyl-_1->6_-beta-D-glucoside_s ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/flavonol_3-O-_alpha-L-rhamnosyl-_1->6_-beta-D-glucoside_s ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/flavonol_3-O-beta-D-glucoside ch/UDP-beta-L-rhamnose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSucrose6f-Alpha-GalactotransferaseActivity
  :annotation (goid "GO:0047235")
  :annotation (database "RHEA:10088")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sucrose ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/planteose ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/planteose ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/sucrose ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRaffinose-RaffinoseAlpha-GalactotransferaseActivity
  :annotation (goid "GO:0047234")
  :annotation (database "RHEA:14125")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/raffinose ch/raffinose)
    (owl-some hasProduct  ch/sucrose ch/_1_F_-alpha-D-galactosylraffinose))
   (owl-and
    (owl-some hasReactant  ch/sucrose ch/_1_F_-alpha-D-galactosylraffinose)
    (owl-some hasProduct  ch/raffinose ch/raffinose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinate-Nucleotide-DimethylbenzimidazolePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0008939")
  :annotation (database "RHEA:11196")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5_6-dimethylbenzimidazole ch/nicotinate_D-ribonucleotide_2-_)
    (owl-some hasProduct  ch/alpha-ribazole_5'-phosphate_2-_ ch/hydron ch/nicotinate))
   (owl-and
    (owl-some hasReactant  ch/alpha-ribazole_5'-phosphate_2-_ ch/hydron ch/nicotinate)
    (owl-some hasProduct  ch/_5_6-dimethylbenzimidazole ch/nicotinate_D-ribonucleotide_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylneuraminylgalactosylglucosylceramideBeta-1_4-N-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0047233")
  :annotation (database "RHEA:13569")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_ ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-galactosaminyl-_1->4_-alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_anion ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-galactosaminyl-_1->4_-alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_anion ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/alpha-N-acetylneuraminosyl-_2->3_-beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1'_-N-acylsphingosine_1-_ ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotinateN-MethyltransferaseActivity
  :annotation (goid "GO:0008938")
  :annotation (database "RHEA:20241")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/nicotinate)
    (owl-some hasProduct  ch/N-methylnicotinate ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/N-methylnicotinate ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/nicotinate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactosyl-N-Acetylglucosaminylgalactosylglucosyl-CeramideBeta-1_6-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0047232")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-glucosaminyl-_1->6_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-glucosaminyl-_1->6_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIndolylacetylinositolArabinosyltransferaseActivity
  :annotation (goid "GO:0050409")
  :annotation (database "RHEA:19505")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/UDP-beta-L-arabinopyranose_2-_)
    (owl-some hasProduct  ch/_indol-3-ylacetyl_-myo-inositol_3-L-arabinoside ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_indol-3-ylacetyl_-myo-inositol_3-L-arabinoside ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/_1D-1-O-_indol-3-yl_acetyl-myo-inositol ch/UDP-beta-L-arabinopyranose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePalmitoleoyl_acyl-carrier-protein_-dependentAcyltransferaseActivity
  :annotation (goid "GO:0008951")
  :annotation (database "RHEA:44012")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-_S-_9Z_-hexadecenoylpantetheine-4'-phosphoryl_serine_1-__residue ch/_KDO_2-lipid_IVA_6-_)
    (owl-some hasProduct  ch/_KDO_2-_palmitoleoyl_-lipid_IVA_6-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue))
   (owl-and
    (owl-some hasReactant  ch/_KDO_2-_palmitoleoyl_-lipid_IVA_6-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue)
    (owl-some hasProduct  ch/O-_S-_9Z_-hexadecenoylpantetheine-4'-phosphoryl_serine_1-__residue ch/_KDO_2-lipid_IVA_6-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxymandelonitrileGlucosyltransferaseActivity
  :annotation (goid "GO:0047239")
  :annotation (database "RHEA:15961")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxymandelonitrile ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/hydron ch/_R_-4-hydroxymandelonitrile_beta-D-glucoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/_R_-4-hydroxymandelonitrile_beta-D-glucoside ch/UDP_3-_)
    (owl-some hasProduct  ch/_4-hydroxymandelonitrile ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucuronosyl-N-Acetylgalactosaminyl-Proteoglycan4-Beta-N-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0047238")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-glucuronyl-N-acetyl-_1->3_-beta-D-galactosaminylproteoglycan ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-D-galactosaminyl-_1->4_-beta-D-glucuronyl-N-acetyl-_1->3_-beta-D-galactosaminylproteoglycan ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-D-galactosaminyl-_1->4_-beta-D-glucuronyl-N-acetyl-_1->3_-beta-D-galactosaminylproteoglycan ch/UDP_3-_)
    (owl-some hasProduct  ch/D-glucuronyl-N-acetyl-_1->3_-beta-D-galactosaminylproteoglycan ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCreatineKinaseActivity
  :annotation (goid "GO:0004111")
  :annotation (database "RHEA:17157")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/creatine_zwitterion)
    (owl-some hasProduct  ch/N-phosphocreatinate_2-_ ch/ADP_3-_ ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-phosphocreatinate_2-_ ch/ADP_3-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/creatine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysePantetheine-PhosphateAdenylyltransferaseActivity
  :annotation (goid "GO:0004595")
  :annotation (database "RHEA:19801")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/D-pantetheine_4'-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-dephospho-CoA_2-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_3'-dephospho-CoA_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/D-pantetheine_4'-phosphate_2-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlucuronylgalactosylproteoglycan4-Beta-N-AcetylgalactosaminyltransferaseActivity
  :annotation (goid "GO:0047237")
  :annotation (database "RHEA:23464")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O_3_-_beta-D-glucuronosyl-_1->3_-beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-xylosyl_-L-serine_1-__residue ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)
    (owl-some hasProduct  ch/O_3_-_N-acetyl-beta-D-galactosaminyl-_1->4_-beta-D-glucuronosyl-_1->3_-beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-xylosyl_-L-serine_1-__residue ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/O_3_-_N-acetyl-beta-D-galactosaminyl-_1->4_-beta-D-glucuronosyl-_1->3_-beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-xylosyl_-L-serine_1-__residue ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/O_3_-_beta-D-glucuronosyl-_1->3_-beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-xylosyl_-L-serine_1-__residue ch/UDP-N-acetyl-alpha-D-galactosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePantothenateKinaseActivity
  :annotation (goid "GO:0004594")
  :annotation (database "RHEA:16373")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_R_-pantothenate)
    (owl-some hasProduct  ch/ADP_3-_ ch/_R_-4'-phosphonatopantothenate_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_R_-4'-phosphonatopantothenate_3-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/_R_-pantothenate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMethyl-Onn-AzoxymethanolBeta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047236")
  :annotation (database "RHEA:20205")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/methylazoxymethanol ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/hydron ch/cycasin ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/cycasin ch/UDP_3-_)
    (owl-some hasProduct  ch/methylazoxymethanol ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePeptidoglycanGlycosyltransferaseActivity
  :annotation (goid "GO:0008955")
  :annotation (database "RHEA:23708")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_GlcNAc-_1->4_-Mur2Ac_oyl-L-Ala-gamma-D-Glu-L-Lys-D-Ala-D-Ala__n-diphospho-ditrans_polycis-undecaprenol_polyanion ch/lipid_II_3-_)
    (owl-some hasProduct  ch/_GlcNAc-_1->4_-Mur2Ac_oyl-L-Ala-gamma-D-Glu-L-Lys-D-Ala-D-Ala__n-diphospho-ditrans_polycis-undecaprenol_polyanion ch/ditrans_polycis-undecaprenyl_diphosphate_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_GlcNAc-_1->4_-Mur2Ac_oyl-L-Ala-gamma-D-Glu-L-Lys-D-Ala-D-Ala__n-diphospho-ditrans_polycis-undecaprenol_polyanion ch/ditrans_polycis-undecaprenyl_diphosphate_3-_ ch/hydron)
    (owl-some hasProduct  ch/_GlcNAc-_1->4_-Mur2Ac_oyl-L-Ala-gamma-D-Glu-L-Lys-D-Ala-D-Ala__n-diphospho-ditrans_polycis-undecaprenol_polyanion ch/lipid_II_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePeptideAlpha-N-AcetyltransferaseActivity
  :annotation (goid "GO:0004596")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/peptide)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_alpha_-acetylpeptide_1-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_alpha_-acetylpeptide_1-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/peptide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHydroxyanthraquinoneGlucosyltransferaseActivity
  :annotation (goid "GO:0047242")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-hydroxyanthraquinone ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/glucosyloxyanthraquinone ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/glucosyloxyanthraquinone ch/UDP_3-_)
    (owl-some hasProduct  ch/_1-hydroxyanthraquinone ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGtp-DependentPolyribonucleotide5'-Hydroxyl-KinaseActivity
  :annotation (goid "GO:0051730")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/_5'-end_ribonucleoside_residue)
    (owl-some hasProduct  ch/GDP_3-_ ch/_5'-end_ribonucleotide_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/_5'-end_ribonucleotide_2-__residue ch/hydron)
    (owl-some hasProduct  ch/GTP_4-_ ch/_5'-end_ribonucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCholine-PhosphateCytidylyltransferaseActivity
  :annotation (goid "GO:0004105")
  :annotation (database "RHEA:18997")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CTP_4-_ ch/choline_phosphate_1-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/CDP-choline_1-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/CDP-choline_1-_)
    (owl-some hasProduct  ch/CTP_4-_ ch/choline_phosphate_1-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePolynucleotide5'-Hydroxyl-KinaseActivity
  :annotation (goid "GO:0051731")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/nucleoside_residue)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-phosphopolynucleotide))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-phosphopolynucleotide)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/nucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharideN-AcetylmannosaminouronosyltransferaseActivity
  :annotation (goid "GO:0047241")
  :annotation (database "RHEA:28366")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-N-acetyl-alpha-D-mannosaminouronate_3-_)
    (owl-some hasProduct  ch/beta-D-ManNAcA-_1->4_-alpha-D-GlcNAc-1-diphospho-ditrans_polycis-undecaprenol_3-_ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/beta-D-ManNAcA-_1->4_-alpha-D-GlcNAc-1-diphospho-ditrans_polycis-undecaprenol_3-_ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-N-acetyl-alpha-D-mannosaminouronate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLactosylceramideBeta-1_3-GalactosyltransferaseActivity
  :annotation (goid "GO:0047240")
  :annotation (database "RHEA:18413")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-beta-D-glucoside ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucoside ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucoside ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-beta-D-glucoside ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseXylitolKinaseActivity
  :annotation (goid "GO:0050400")
  :annotation (database "RHEA:20209")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/xylitol)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/xylitol_5-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/xylitol_5-phosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/xylitol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLuteolin-7-O-Glucuronide7-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0047246")
  :annotation (database "RHEA:14149")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/luteolin_7-O-beta-D-glucosiduronate_2-_ ch/UDP-alpha-D-glucuronate_3-_)
    (owl-some hasProduct  ch/hydron ch/luteolin_7-O-__beta-D-glucosiduronate_-_1->2_-_beta-D-glucosiduronate___3-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/luteolin_7-O-__beta-D-glucosiduronate_-_1->2_-_beta-D-glucosiduronate___3-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/luteolin_7-O-beta-D-glucosiduronate_2-_ ch/UDP-alpha-D-glucuronate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylglucosaminyldiphosphoundecaprenolGlucosyltransferaseActivity
  :annotation (goid "GO:0047245")
  :annotation (database "RHEA:20952")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/beta-D-glucosyl-_1->4_-N-acetyl-alpha-D-glucosaminyl_undecaprenyl_diphosphate_2-_ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/beta-D-glucosyl-_1->4_-N-acetyl-alpha-D-glucosaminyl_undecaprenyl_diphosphate_2-_ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylglucosaminyldiphosphoundecaprenolN-Acetyl-Beta-D-MannosaminyltransferaseActivity
  :annotation (goid "GO:0047244")
  :annotation (database "RHEA:16053")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-N-acetyl-alpha-D-mannosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-mannosaminyl-_1->4_-N-acetyl-alpha-D-glucosaminyl_undecaprenyl_diphosphate_2-_ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-mannosaminyl-_1->4_-N-acetyl-alpha-D-glucosaminyl_undecaprenyl_diphosphate_2-_ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acetyl-alpha-D-glucosaminyl-1-diphospho-ditrans_polycis-undecaprenol_2-_ ch/UDP-N-acetyl-alpha-D-mannosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFlavanone7-O-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047243")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/flavanone ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_7-hydroxyflavanone_7-O-beta-D-glucoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_7-hydroxyflavanone_7-O-beta-D-glucoside ch/UDP_3-_)
    (owl-some hasProduct  ch/flavanone ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAtp-DependentPolyribonucleotide5'-Hydroxyl-KinaseActivity
  :annotation (goid "GO:0051736")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_5'-end_ribonucleoside_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/_5'-end_ribonucleotide_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_5'-end_ribonucleotide_2-__residue)
    (owl-some hasProduct  ch/ATP_4-_ ch/_5'-end_ribonucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGtp-DependentPolydeoxyribonucleotide5'-Hydroxyl-KinaseActivity
  :annotation (goid "GO:0051737")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/_5'-end_2'-deoxyribonucleoside_residue)
    (owl-some hasProduct  ch/GDP_3-_ ch/_5'-end_2'-deoxyribonucleotide_2-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/_5'-end_2'-deoxyribonucleotide_2-__residue ch/hydron)
    (owl-some hasProduct  ch/GTP_4-_ ch/_5'-end_2'-deoxyribonucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAtp-DependentPolynucleotideKinaseActivity
  :annotation (goid "GO:0051734")
  :annotation (database "RHEA:54580")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/nucleoside_residue)
    (owl-some hasProduct  ch/ADP_3-_ ch/_5'-phosphopolynucleotide))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_5'-phosphopolynucleotide)
    (owl-some hasProduct  ch/ATP_4-_ ch/nucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGtp-DependentPolynucleotideKinaseActivity
  :annotation (goid "GO:0051735")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/nucleoside_residue)
    (owl-some hasProduct  ch/GDP_3-_ ch/_5'-phosphopolynucleotide))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/_5'-phosphopolynucleotide)
    (owl-some hasProduct  ch/GTP_4-_ ch/nucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseZeatinO-Beta-D-XylosyltransferaseActivity
  :annotation (goid "GO:0050404")
  :annotation (database "RHEA:14721")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-xylose_2-_ ch/zeatin)
    (owl-some hasProduct  ch/O-beta-D-xylosylzeatin ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/O-beta-D-xylosylzeatin ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/UDP-alpha-D-xylose_2-_ ch/zeatin)))
  :enzyme Transferase)

(defcatalyse ToCatalysePolyribonucleotideKinaseActivity
  :annotation (goid "GO:0051732")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/nucleoside_residue)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-end_ribonucleotide_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-end_ribonucleotide_2-__residue)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/nucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalysePolydeoxyribonucleotideKinaseActivity
  :annotation (goid "GO:0051733")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/_5'-end_2'-deoxyribonucleoside_residue)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-end_2'-deoxyribonucleotide_2-__residue))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/_5'-end_2'-deoxyribonucleotide_2-__residue)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/_5'-end_2'-deoxyribonucleoside_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTrans-ZeatinO-Beta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0050403")
  :annotation (database "RHEA:23224")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trans-zeatin ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/O-beta-D-glucosyl-trans-zeatin ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/O-beta-D-glucosyl-trans-zeatin ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/trans-zeatin ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePropionateCoa-TransferaseActivity
  :annotation (goid "GO:0018729")
  :annotation (database "RHEA:23520")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/propionate)
    (owl-some hasProduct  ch/acetate ch/propionyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/acetate ch/propionyl-CoA_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/propionate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSarsapogenin3-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047249")
  :annotation (database "RHEA:14461")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_25S_-5beta-spirostan-3beta-ol ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_25S_-5beta-spirostan-3beta-yl_beta-D-glucoside ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_25S_-5beta-spirostan-3beta-yl_beta-D-glucoside ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/_25S_-5beta-spirostan-3beta-ol ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNuatigenin3-Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047248")
  :annotation (database "RHEA:19329")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nuatigenin ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/hydron ch/nuatigenin_3-beta-D-glucopyranoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/nuatigenin_3-beta-D-glucopyranoside ch/UDP_3-_)
    (owl-some hasProduct  ch/nuatigenin ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLuteolin-7-O-Diglucuronide4'-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0047247")
  :annotation (database "RHEA:22116")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/luteolin_7-O-__beta-D-glucosiduronate_-_1->2_-_beta-D-glucosiduronate___3-_ ch/UDP-alpha-D-glucuronate_3-_)
    (owl-some hasProduct  ch/hydron ch/luteolin_7-O-__beta-D-glucosyluronate_-_1->2_-_beta-D-glucosiduronate___4'-O-beta-D-glucosiduronate_4-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/luteolin_7-O-__beta-D-glucosyluronate_-_1->2_-_beta-D-glucosiduronate___4'-O-beta-D-glucosiduronate_4-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/luteolin_7-O-__beta-D-glucosiduronate_-_1->2_-_beta-D-glucosiduronate___3-_ ch/UDP-alpha-D-glucuronate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharide3-Alpha-GalactosyltransferaseActivity
  :annotation (goid "GO:0008918")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/lipopolysaccharide)
    (owl-some hasProduct  ch/UDP_3-_ ch/alpha-D-galactosyl-_1->3_-lipopolysaccharide))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/alpha-D-galactosyl-_1->3_-lipopolysaccharide)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/lipopolysaccharide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharide-1_6-GalactosyltransferaseActivity
  :annotation (goid "GO:0008921")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-galactose_2-_ ch/lipopolysaccharide)
    (owl-some hasProduct  ch/UDP_3-_ ch/D-glucosyllipopolysaccharide))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/D-glucosyllipopolysaccharide)
    (owl-some hasProduct  ch/UDP-alpha-D-galactose_2-_ ch/lipopolysaccharide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipid-A-DisaccharideSynthaseActivity
  :annotation (goid "GO:0008915")
  :annotation (database "RHEA:22668")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/lipid_X_2-_ ch/UDP-2_3-bis__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/_2_3_2'_3'-tetrakis_3-hydroxytetradecanoyl_-alpha-D-glucosaminyl-1_6-beta-D-glucosamine_1-phosphate_2-_ ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2_3_2'_3'-tetrakis_3-hydroxytetradecanoyl_-alpha-D-glucosaminyl-1_6-beta-D-glucosamine_1-phosphate_2-_ ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/lipid_X_2-_ ch/UDP-2_3-bis__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlpha-1_6-Mannosylglycoprotein4-Beta-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0047253")
  :annotation (database "RHEA:19945")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-_beta-D-GlcNAc-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-_beta-D-GlcNAc-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->6__-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Methyl-6-Phytyl-1_4-BenzoquinoneMethyltransferaseActivity
  :annotation (goid "GO:0051741")
  :annotation (database "RHEA:37979")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_R_R_-2-methyl-6-phytylhydroquinone ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_R_R_-2_3-dimethyl-6-phytylhydroquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_R_R_-2_3-dimethyl-6-phytylhydroquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_R_R_-2-methyl-6-phytylhydroquinone ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Methyl-6-Solanyl-1_4-BenzoquinoneMethyltransferaseActivity
  :annotation (goid "GO:0051742")
  :annotation (database "RHEA:37999")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-methyl-6-all-trans-nonaprenyl-1_4-benzoquinone ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/plastoquinol-9 ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/plastoquinol-9 ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_2-methyl-6-all-trans-nonaprenyl-1_4-benzoquinone ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiohydroximateBeta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047251")
  :annotation (database "RHEA:13757")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phenylthioacetohydroximate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_Z_-desulfoglucotropeolin ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_Z_-desulfoglucotropeolin ch/UDP_3-_)
    (owl-some hasProduct  ch/phenylthioacetohydroximate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse4-Hydroxybenzoate4-O-Beta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047250")
  :annotation (database "RHEA:15153")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-hydroxybenzoate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_4-_beta-D-glucosyloxy_benzoate ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_4-_beta-D-glucosyloxy_benzoate ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/_4-hydroxybenzoate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharideGlucosyltransferaseIActivity
  :annotation (goid "GO:0008919")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/lipopolysaccharide)
    (owl-some hasProduct  ch/UDP_3-_ ch/D-glucosyllipopolysaccharide))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/D-glucosyllipopolysaccharide)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/lipopolysaccharide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiglucosylDiacylglycerolSynthaseActivity
  :annotation (goid "GO:0047257")
  :annotation (database "RHEA:19165")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1_2-diacyl-3-O-_alpha-D-glucosyl_-sn-glycerol ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/_1_2-diacyl-3-O-_alpha-D-glucosyl-_1->_2_-alpha-D-glucosyl_-sn-glycerol ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/_1_2-diacyl-3-O-_alpha-D-glucosyl-_1->_2_-alpha-D-glucosyl_-sn-glycerol ch/hydron)
    (owl-some hasProduct  ch/_1_2-diacyl-3-O-_alpha-D-glucosyl_-sn-glycerol ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLactosylceramide1_3-N-Acetyl-Beta-D-GlucosaminyltransferaseActivity
  :annotation (goid "GO:0047256")
  :annotation (database "RHEA:13905")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_d18:1_4E__ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide_d18:1_4E__ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/beta-D-galactosyl-_1->4_-beta-D-glucosyl-_1<->1_-N-acylsphingosine ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLipopolysaccharideN-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0008917")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/lipopolysaccharide)
    (owl-some hasProduct  ch/UDP_3-_ ch/N-acetyl-D-glucosaminyllipopolysaccharides))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N-acetyl-D-glucosaminyllipopolysaccharides)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/lipopolysaccharide)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2_4-Dihydroxy-7-Methoxy-2h-1_4-Benzoxazin-3_4h_-One2-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0047254")
  :annotation (database "RHEA:15541")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/DIMBOA ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_2R_-DIMBOA_glucoside ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2R_-DIMBOA_glucoside ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/DIMBOA ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutaconateCoa-TransferaseActivity
  :annotation (goid "GO:0018730")
  :annotation (database "RHEA:23208")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/_E_-glutaconate_2-_)
    (owl-some hasProduct  ch/acetate ch/trans-4-carboxybut-2-enoyl-CoA_5-_))
   (owl-and
    (owl-some hasReactant  ch/acetate ch/trans-4-carboxybut-2-enoyl-CoA_5-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/_E_-glutaconate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUtp-Monosaccharide-1-PhosphateUridylyltransferaseActivity
  :annotation (goid "GO:0051748")
  :annotation (database "RHEA:13205")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UTP_4-_ ch/monosaccharide_1-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/UDP-monosaccharide_2-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/UDP-monosaccharide_2-_)
    (owl-some hasProduct  ch/UTP_4-_ ch/monosaccharide_1-phosphate_2-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseD-Alanine2-HydroxymethyltransferaseActivity
  :annotation (goid "GO:0050413")
  :annotation (database "RHEA:10064")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/D-alanine ch/water)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_2-methylserine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/_2-methylserine_zwitterion)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/D-alanine ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCinnamateBeta-D-GlucosyltransferaseActivity
  :annotation (goid "GO:0050412")
  :annotation (database "RHEA:13437")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/trans-cinnamate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_1-O-trans-cinnamoyl-beta-D-glucopyranose ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1-O-trans-cinnamoyl-beta-D-glucopyranose ch/UDP_3-_)
    (owl-some hasProduct  ch/trans-cinnamate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Ketopimelyl-CoaThiolaseActivity
  :annotation (goid "GO:0018713")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3-oxopimeloyl-CoA ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/glutaryl-CoA ch/acetyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/glutaryl-CoA ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/_3-oxopimeloyl-CoA ch/coenzyme_A_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1-PhenanthrolGlycosyltransferaseActivity
  :annotation (goid "GO:0018716")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1-phenanthrol ch/D-glucopyranose)
    (owl-some hasProduct  ch/_1-phenanthryl_beta-D-glucoside ch/water))
   (owl-and
    (owl-some hasReactant  ch/_1-phenanthryl_beta-D-glucoside ch/water)
    (owl-some hasProduct  ch/_1-phenanthrol ch/D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositolPentakisphosphate2-KinaseActivity
  :annotation (goid "GO:0035299")
  :annotation (database "RHEA:20313")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_1_3_4_5_6-pentakisphosphate_10-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/myo-inositol_hexakisphosphate_12-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/myo-inositol_hexakisphosphate_12-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/myo-inositol_1_3_4_5_6-pentakisphosphate_10-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse9-PhenanthrolUDP-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0018715")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_9-phenanthrol ch/UDP-alpha-D-glucuronic_acid)
    (owl-some hasProduct  ch/_9-phenanthryl_beta-D-glucosiduronic_acid ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_9-phenanthryl_beta-D-glucosiduronic_acid ch/UDP_3-_)
    (owl-some hasProduct  ch/_9-phenanthrol ch/UDP-alpha-D-glucuronic_acid)))
  :enzyme Transferase)

(defcatalyse ToCatalyse1_2-Dihydroxy-PhenanthreneGlycosyltransferaseActivity
  :annotation (goid "GO:0018718")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phenanthrene-1_2-diol ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/_2-hydroxy-1-phenanthryl_beta-D-glucopyranoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2-hydroxy-1-phenanthryl_beta-D-glucopyranoside ch/UDP_3-_)
    (owl-some hasProduct  ch/phenanthrene-1_2-diol ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse9-PhenanthrolGlycosyltransferaseActivity
  :annotation (goid "GO:0018717")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_9-phenanthrol ch/D-glucopyranose)
    (owl-some hasProduct  ch/_9-phenanthryl_beta-D-glucopyranoside ch/water))
   (owl-and
    (owl-some hasReactant  ch/_9-phenanthryl_beta-D-glucopyranoside ch/water)
    (owl-some hasProduct  ch/_9-phenanthrol ch/D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Phenylalanine-OxaloacetateTransaminaseActivity
  :annotation (goid "GO:0036141")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-phenylalanine ch/oxaloacetate_2-_)
    (owl-some hasProduct  ch/keto-phenylpyruvate ch/aspartate))
   (owl-and
    (owl-some hasReactant  ch/keto-phenylpyruvate ch/aspartate)
    (owl-some hasProduct  ch/L-phenylalanine ch/oxaloacetate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse6-AminohexanoateTransaminaseActivity
  :annotation (goid "GO:0018719")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6-aminohexanoate ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/glutamate_2-_ ch/_6-oxohexanoate))
   (owl-and
    (owl-some hasReactant  ch/glutamate_2-_ ch/_6-oxohexanoate)
    (owl-some hasProduct  ch/_6-aminohexanoate ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSphingosineBeta-GalactosyltransferaseActivity
  :annotation (goid "GO:0047258")
  :annotation (database "RHEA:19485")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sphingosine_1+_ ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/hydron ch/psychosine_1+_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/psychosine_1+_ ch/UDP_3-_)
    (owl-some hasProduct  ch/sphingosine_1+_ ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetylglucosaminyldiphosphodolicholN-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0004577")
  :annotation (database "RHEA:23380")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N-acetyl-D-glucosaminyldiphosphodolichol_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/N_N'-diacetylchitobiosyldiphosphonatodolichol_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N_N'-diacetylchitobiosyldiphosphonatodolichol_2-_ ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N-acetyl-D-glucosaminyldiphosphodolichol_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycogenSynthaseActivity_TransferringGlucose-1-Phosphate	
  :annotation (goid "GO:0061547")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/_1->4_-alpha-D-glucan)
    (owl-some hasProduct  ch/uridine_5'-monophosphate_2-_ ch/alpha-D-glucose_1-phosphate))
   (owl-and
    (owl-some hasReactant  ch/uridine_5'-monophosphate_2-_ ch/alpha-D-glucose_1-phosphate)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/_1->4_-alpha-D-glucan)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHeteroglycanAlpha-MannosyltransferaseActivity
  :annotation (goid "GO:0047264")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/heteroglycan ch/GDP-alpha-D-mannose_2-_)
    (owl-some hasProduct  ch/_1_2-alpha-D-Mannosylheteroglycan ch/GDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1_2-alpha-D-Mannosylheteroglycan ch/GDP_3-_)
    (owl-some hasProduct  ch/heteroglycan ch/GDP-alpha-D-mannose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMaltoseSynthaseActivity
  :annotation (goid "GO:0050420")
  :annotation (database "RHEA:22320")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose_1-phosphate_2-_ ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/maltose ch/hydrogenphosphate ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/maltose ch/hydrogenphosphate ch/hydrogenphosphate)
    (owl-some hasProduct  ch/alpha-D-glucose_1-phosphate_2-_ ch/alpha-D-glucose_1-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMaltoseO-AcetyltransferaseActivity
  :annotation (goid "GO:0008925")
  :annotation (database "RHEA:10456")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/maltose)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_1-O-acetylmaltose))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_1-O-acetylmaltose)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/maltose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcylsphingosineGalactosyltransferaseActivity
  :annotation (goid "GO:0047263")
  :annotation (database "RHEA:13093")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acylsphingosine ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/N-acyl-beta-D-galactosylsphingosine ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acyl-beta-D-galactosylsphingosine ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/N-acylsphingosine ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSteroidN-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0047261")
  :annotation (database "RHEA:14153")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_17alpha-estradiol_3-glucosiduronate ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)
    (owl-some hasProduct  ch/_17alpha-_N-acetyl-alpha-D-glucosaminyl_estradiol_3-glucosiduronate ch/hydron ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_17alpha-_N-acetyl-alpha-D-glucosaminyl_estradiol_3-glucosiduronate ch/hydron ch/UDP_3-_)
    (owl-some hasProduct  ch/_17alpha-estradiol_3-glucosiduronate ch/UDP-N-acetyl-alpha-D-glucosamine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactinol-RaffinoseGalactosyltransferaseActivity
  :annotation (goid "GO:0047268")
  :annotation (database "RHEA:20776")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/raffinose ch/alpha-D-galactosyl-_1->3_-1D-myo-inositol)
    (owl-some hasProduct  ch/stachyose ch/myo-inositol))
   (owl-and
    (owl-some hasReactant  ch/stachyose ch/myo-inositol)
    (owl-some hasProduct  ch/raffinose ch/alpha-D-galactosyl-_1->3_-1D-myo-inositol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUndecaprenyl-PhosphateMannosyltransferaseActivity
  :annotation (goid "GO:0047267")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)
    (owl-some hasProduct  ch/GDP_3-_ ch/D-mannosyl_ditrans_polycis-undecaprenyl_phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/GDP_3-_ ch/D-mannosyl_ditrans_polycis-undecaprenyl_phosphate_1-_)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMannose-1-PhosphateGuanylyltransferase_GDP_Activity
  :annotation (goid "GO:0008928")
  :annotation (database "RHEA:12905")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-mannose_1-phosphate_2-_ ch/GDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/GDP-alpha-D-mannose_2-_ ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-mannose_2-_ ch/hydrogenphosphate)
    (owl-some hasProduct  ch/alpha-D-mannose_1-phosphate_2-_ ch/GDP_3-_ ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePoly_Ribitol-Phosphate_Beta-GlucosyltransferaseActivity
  :annotation (goid "GO:0047266")
  :annotation (database "RHEA:10068")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/poly_ribitol_phosphate_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/poly_2-beta-D-glucosylribitol_phosphate_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/poly_2-beta-D-glucosylribitol_phosphate_ ch/UDP_3-_)
    (owl-some hasProduct  ch/poly_ribitol_phosphate_ ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePoly_Glycerol-Phosphate_Alpha-GlucosyltransferaseActivity
  :annotation (goid "GO:0047265")
  :annotation (database "RHEA:15845")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/poly_glycerol_phosphate_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/O-_alpha-D-glucosyl__poly_glycerol_phosphate_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/O-_alpha-D-glucosyl__poly_glycerol_phosphate_ ch/UDP_3-_)
    (owl-some hasProduct  ch/poly_glycerol_phosphate_ ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlpha_Alpha-Trehalose-PhosphateSynthase_GDP-forming_Activity
  :annotation (goid "GO:0047260")
  :annotation (database "RHEA:14605")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GDP-alpha-D-glucose_2-_ ch/D-glucopyranose_6-phosphate_2-_)
    (owl-some hasProduct  ch/alpha_alpha-trehalose_6-phosphate_2-_ ch/GDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/alpha_alpha-trehalose_6-phosphate_2-_ ch/GDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/GDP-alpha-D-glucose_2-_ ch/D-glucopyranose_6-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN2-Acetyl-L-LysineAminotransferaseActivity
  :annotation (goid "GO:0043746")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-L-2-aminoadipate_semialdehyde ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/N_2_-acetyl-L-lysine))
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/N_2_-acetyl-L-lysine)
    (owl-some hasProduct  ch/N-acetyl-L-2-aminoadipate_semialdehyde ch/L-glutamate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGalactogen6-Beta-GalactosyltransferaseActivity
  :annotation (goid "GO:0047255")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/galactogen ch/UDP-alpha-D-galactose_2-_)
    (owl-some hasProduct  ch/_1_6-beta-D-galactosylgalactogen ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_1_6-beta-D-galactosylgalactogen ch/UDP_3-_)
    (owl-some hasProduct  ch/galactogen ch/UDP-alpha-D-galactose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePropionateKinaseActivity
  :annotation (goid "GO:0008980")
  :annotation (database "RHEA:23148")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/propionate)
    (owl-some hasProduct  ch/ADP_3-_ ch/propanoyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/propanoyl_phosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/propionate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDephospho-CoaKinaseActivity
  :annotation (goid "GO:0004140")
  :annotation (database "RHEA:18245")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-dephospho-CoA_2-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/coenzyme_A_4-_ ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/coenzyme_A_4-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/_3'-dephospho-CoA_2-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiacylglycerolCholinephosphotransferaseActivity
  :annotation (goid "GO:0004142")
  :annotation (database "RHEA:32939")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CDP-choline_1-_ ch/_1_2-diacyl-sn-glycerol)
    (owl-some hasProduct  ch/cytidine_5'-monophosphate_2-_ ch/phosphatidylcholine))
   (owl-and
    (owl-some hasReactant  ch/cytidine_5'-monophosphate_2-_ ch/phosphatidylcholine)
    (owl-some hasProduct  ch/CDP-choline_1-_ ch/_1_2-diacyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProtein-GlutamateO-MethyltransferaseActivity
  :annotation (goid "GO:0008983")
  :annotation (database "RHEA:24452")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamate_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/gamma-methyl_L-glutamate_residue))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/gamma-methyl_L-glutamate_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-glutamate_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiacylglycerolO-AcyltransferaseActivity
  :annotation (goid "GO:0004144")
  :annotation (database "RHEA:10868")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/_1_2-diacyl-sn-glycerol)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/triacyl-sn-glycerol))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/triacyl-sn-glycerol)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/_1_2-diacyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-2-AminoadipateN-AcetyltransferaseActivity
  :annotation (goid "GO:0043741")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-2-aminoadipate_1-_ ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-L-2-aminoadipate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-L-2-aminoadipate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/L-2-aminoadipate_1-_ ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiacylglycerolKinaseActivity
  :annotation (goid "GO:0004143")
  :annotation (database "RHEA:10272")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/_1_2-diacyl-sn-glycerol)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/_1_2-diacyl-sn-glycerol_3-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/_1_2-diacyl-sn-glycerol_3-phosphate_2-_)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/_1_2-diacyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA_adenine-N6-_-methyltransferaseActivity
  :annotation (goid "GO:0008988")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_6_-methyladenine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_6_-methyladenine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLppg:Fo2-Phospho-L-LactateTransferaseActivity
  :annotation (goid "GO:0043743")
  :annotation (database "RHEA:27510")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_7_8-didemethyl-8-hydroxy-5-deazariboflavin ch/L-lactyl-2-diphospho-5'-guanosine)
    (owl-some hasProduct  ch/F420-0 ch/guanosine_5'-monophosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/F420-0 ch/guanosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/_7_8-didemethyl-8-hydroxy-5-deazariboflavin ch/L-lactyl-2-diphospho-5'-guanosine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiamineN-AcetyltransferaseActivity
  :annotation (goid "GO:0004145")
  :annotation (database "RHEA:25181")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/alkane-alpha_omega-diammonium_2+_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-monoacetylalkane-alpha_omega-diamine_1+_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-monoacetylalkane-alpha_omega-diamine_1+_ ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/alkane-alpha_omega-diammonium_2+_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyruvate_WaterDikinaseActivity
  :annotation (goid "GO:0008986")
  :annotation (database "RHEA:11364")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/water ch/pyruvate)
    (owl-some hasProduct  ch/adenosine_5'-monophosphate_2-_ ch/hydron ch/hydrogenphosphate ch/phosphoenolpyruvate ch/hydron ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_5'-monophosphate_2-_ ch/hydron ch/hydrogenphosphate ch/phosphoenolpyruvate ch/hydron ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/water ch/pyruvate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDihydrolipoamideBranchedChainAcyltransferaseActivity
  :annotation (goid "GO:0004147")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/dihydrolipoamide)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/S_6_-acetyldihydrolipoamide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/S_6_-acetyldihydrolipoamide)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/dihydrolipoamide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN2-Acetyl-L-AminoadipateKinaseActivity
  :annotation (goid "GO:0043744")
  :annotation (database "RHEA:41944")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/N-acetyl-L-2-aminoadipic_acid)
    (owl-some hasProduct  ch/ADP_3-_ ch/N-acetyl-L-2-aminoadipic_acid_6-phosphate))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/N-acetyl-L-2-aminoadipic_acid_6-phosphate)
    (owl-some hasProduct  ch/ATP_4-_ ch/N-acetyl-L-2-aminoadipic_acid)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeoxyguanosineKinaseActivity
  :annotation (goid "GO:0004138")
  :annotation (database "RHEA:19201")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxyguanosine ch/ATP_4-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_2'-deoxyguanosine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_2'-deoxyguanosine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/_2'-deoxyguanosine ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphocholineTransferaseActivity
  :annotation (goid "GO:0044605")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CDP-choline_1-_ ch/L-serine_residue)
    (owl-some hasProduct  ch/cytidine_5'-monophosphate_2-_ ch/O-phosphocholine-L-serine_residue))
   (owl-and
    (owl-some hasReactant  ch/cytidine_5'-monophosphate_2-_ ch/O-phosphocholine-L-serine_residue)
    (owl-some hasProduct  ch/CDP-choline_1-_ ch/L-serine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA_guanine-N2-_-methyltransferaseActivity
  :annotation (goid "GO:0008990")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_2_-methylguanine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_2_-methylguanine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRhamnulokinaseActivity
  :annotation (goid "GO:0008993")
  :annotation (database "RHEA:20117")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-rhamnulose)
    (owl-some hasProduct  ch/ADP_3-_ ch/L-rhamnulose_1-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/L-rhamnulose_1-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-rhamnulose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLeucineN-AcetyltransferaseActivity
  :annotation (goid "GO:0050050")
  :annotation (database "RHEA:20089")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-leucine_zwitterion ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/N-acetyl-L-leucinate ch/coenzyme_A_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-L-leucinate ch/coenzyme_A_4-_ ch/hydron)
    (owl-some hasProduct  ch/L-leucine_zwitterion ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRibosomal-Protein-AlanineN-AcetyltransferaseActivity
  :annotation (goid "GO:0008999")
  :annotation (database "RHEA:43756")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/L-alaniniumyl_group)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N-terminal_N-acetyl-L-alanine_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N-terminal_N-acetyl-L-alanine_residue ch/hydron)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/L-alaniniumyl_group)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDihydrolipoyllysine-Residue_2-methylpropanoyl_transferaseActivity
  :annotation (goid "GO:0043754")
  :annotation (database "RHEA:18865")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/isobutyryl-CoA_4-_ ch/N_6_-__R_-dihydrolipoyl_-L-lysine_residue)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_6_-__R_-S_8_-isobutyryldihydrolipoyl_-L-lysine_residue))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_6_-__R_-S_8_-isobutyryldihydrolipoyl_-L-lysine_residue)
    (owl-some hasProduct  ch/isobutyryl-CoA_4-_ ch/N_6_-__R_-dihydrolipoyl_-L-lysine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDihydropteroateSynthaseActivity
  :annotation (goid "GO:0004156")
  :annotation (database "RHEA:19949")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_7_8-dihydropterin-6-yl_methyl_diphosphate_3-_ ch/_4-aminobenzoate)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_7_8-dihydropteroate))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_7_8-dihydropteroate)
    (owl-some hasProduct  ch/_7_8-dihydropterin-6-yl_methyl_diphosphate_3-_ ch/_4-aminobenzoate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProteinGuanylyltransferaseActivity
  :annotation (goid "GO:0044600")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/GTP_4-_ ch/protein)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/_5'-guanylyl_group))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/_5'-guanylyl_group)
    (owl-some hasProduct  ch/GTP_4-_ ch/protein)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDihydrolipoyllysine-ResidueSuccinyltransferaseActivity
  :annotation (goid "GO:0004149")
  :annotation (database "RHEA:15213")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/succinyl-CoA_5-_ ch/dihydrolipoamide)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/S_8_-succinyldihydrolipoamide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/S_8_-succinyldihydrolipoamide)
    (owl-some hasProduct  ch/succinyl-CoA_5-_ ch/dihydrolipoamide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLaminaribiosePhosphorylaseActivity
  :annotation (goid "GO:0050045")
  :annotation (database "RHEA:16617")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/laminarabiose ch/hydrogenphosphate)
    (owl-some hasProduct  ch/D-glucopyranose ch/alpha-D-glucose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/D-glucopyranose ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/laminarabiose ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Leucine:2-OxoglutarateAminotransferaseActivity
  :annotation (goid "GO:0050048")
  :annotation (database "RHEA:18321")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-leucine_zwitterion ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_4-methyl-2-oxopentanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_4-methyl-2-oxopentanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/L-leucine_zwitterion ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyserRNA_guanine-N1-_-methyltransferaseActivity
  :annotation (goid "GO:0008989")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_1_-methylguanine))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/rRNA_containing_N_1_-methylguanine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/ribosomal_RNA)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNicotianamineSynthaseActivity
  :annotation (goid "GO:0030410")
  :annotation (database "RHEA:16481")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/_S_S_S_-nicotianamine_trizwitterion ch/hydron ch/hydron ch/_5'-S-methyl-5'-thioadenosine ch/_5'-S-methyl-5'-thioadenosine))
   (owl-and
    (owl-some hasReactant  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/_S_S_S_-nicotianamine_trizwitterion ch/hydron ch/hydron ch/_5'-S-methyl-5'-thioadenosine ch/_5'-S-methyl-5'-thioadenosine)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseArchaetidylserineSynthaseActivity
  :annotation (goid "GO:0043761")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CDP-2_3-bis-O-_geranylgeranyl_-sn-glycerol_2-_ ch/L-serine_zwitterion)
    (owl-some hasProduct  ch/_2_3-bis-O-_geranylgeranyl_-sn-glycero-3-phospho-L-serine_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2_3-bis-O-_geranylgeranyl_-sn-glycero-3-phospho-L-serine_1-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/CDP-2_3-bis-O-_geranylgeranyl_-sn-glycerol_2-_ ch/L-serine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysetRNAN-AcetyltransferaseActivity
  :annotation (goid "GO:0051392")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/cytidine)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/N_4_-acetylcytidine))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/N_4_-acetylcytidine)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/cytidine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetyldiaminopimelateAminotransferaseActivity
  :annotation (goid "GO:0043760")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-acetyl-LL-2_6-diaminopimelate_2-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/_S_-2-amino-6-oxopimelate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_S_-2-amino-6-oxopimelate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/N-acetyl-LL-2_6-diaminopimelate_2-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphoenolpyruvate-ProteinPhosphotransferaseActivity
  :annotation (goid "GO:0008965")
  :annotation (database "RHEA:23880")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phosphonatoenolpyruvate ch/L-histidine_residue)
    (owl-some hasProduct  ch/pyruvate ch/N_pros_-phosphonato-L-histidine_residue))
   (owl-and
    (owl-some hasReactant  ch/pyruvate ch/N_pros_-phosphonato-L-histidine_residue)
    (owl-some hasProduct  ch/phosphonatoenolpyruvate ch/L-histidine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUDP-3-O-_3-Hydroxymyristoyl_GlucosamineN-AcyltransferaseActivity
  :annotation (goid "GO:0043764")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-3-O-__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_1-_ ch/O-_S-_3R_-hydroxytetradecanoylpantetheine-4-phosphoryl_serine_1-__residue)
    (owl-some hasProduct  ch/UDP-2_3-bis__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_2-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP-2_3-bis__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_2-_ ch/O-_pantetheine-4'-phosphoryl_serine_1-__residue ch/hydron)
    (owl-some hasProduct  ch/UDP-3-O-__3R_-3-hydroxytetradecanoyl_-alpha-D-glucosamine_1-_ ch/O-_S-_3R_-hydroxytetradecanoylpantetheine-4-phosphoryl_serine_1-__residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-Seryl-tRNASecSeleniumTransferaseActivity
  :annotation (goid "GO:0004125")
  :annotation (database "RHEA:22728")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-_L-seryl_adenylyl_1-__group ch/selenophosphate ch/hydron)
    (owl-some hasProduct  ch/_3'-_L-selenocysteinyl_adenylyl_1-__group ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/_3'-_L-selenocysteinyl_adenylyl_1-__group ch/hydrogenphosphate)
    (owl-some hasProduct  ch/_3'-_L-seryl_adenylyl_1-__group ch/selenophosphate ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhospho-N-Acetylmuramoyl-Pentapeptide-TransferaseActivity
  :annotation (goid "GO:0008963")
  :annotation (database "RHEA:21920")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-muramoyl-L-alanyl-gamma-D-glutamyl-L-lysyl-D-alanyl-D-alaninate_3-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)
    (owl-some hasProduct  ch/uridine_5'-monophosphate_2-_ ch/undecaprenyldiphosphonato-N-acetylmuramoyl-L-alanyl-D-gamma-glutamyl-L-lysyl-D-alanyl-D-alanine_3-_))
   (owl-and
    (owl-some hasReactant  ch/uridine_5'-monophosphate_2-_ ch/undecaprenyldiphosphonato-N-acetylmuramoyl-L-alanyl-D-gamma-glutamyl-L-lysyl-D-alanyl-D-alanine_3-_)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-muramoyl-L-alanyl-gamma-D-glutamyl-L-lysyl-D-alanyl-D-alaninate_3-_ ch/ditrans_polycis-undecaprenyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSep-tRNA:Cys-TrnaSynthaseActivity
  :annotation (goid "GO:0043766")
  :annotation (database "RHEA:25686")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-_O-phosphonato-L-seryl_adenylyl_2-__group ch/hydrosulfide ch/hydron)
    (owl-some hasProduct  ch/_3'-_L-cysteinyl_adenylyl_zwitterionic_group ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/_3'-_L-cysteinyl_adenylyl_zwitterionic_group ch/hydrogenphosphate)
    (owl-some hasProduct  ch/_3'-_O-phosphonato-L-seryl_adenylyl_2-__group ch/hydrosulfide ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphateAcetyltransferaseActivity
  :annotation (goid "GO:0008959")
  :annotation (database "RHEA:19521")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/hydrogenphosphate)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/acetyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/acetyl_phosphate_2-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLinamarinSynthaseActivity
  :annotation (goid "GO:0050057")
  :annotation (database "RHEA:20009")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/_2-hydroxy-2-methylpropanenitrile)
    (owl-some hasProduct  ch/UDP_3-_ ch/linamarin ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/linamarin ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/_2-hydroxy-2-methylpropanenitrile)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLombricineKinaseActivity
  :annotation (goid "GO:0050059")
  :annotation (database "RHEA:23292")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/L-lombricine_dizwitterion)
    (owl-some hasProduct  ch/ADP_3-_ ch/N-phosphonato-L-lombricine_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/N-phosphonato-L-lombricine_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/L-lombricine_dizwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycineFormimidoyltransferaseActivity
  :annotation (goid "GO:0030408")
  :annotation (database "RHEA:24288")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-formimidoyltetrahydrofolate_2-_ ch/glycine_zwitterion)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N-formimidoylglycine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N-formimidoylglycine_zwitterion)
    (owl-some hasProduct  ch/_5-formimidoyltetrahydrofolate_2-_ ch/glycine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDemethylmenaquinoneMethyltransferaseActivity
  :annotation (goid "GO:0043770")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-demethylmenaquinone ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/menaquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/menaquinone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_2-demethylmenaquinone ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlutamateFormimidoyltransferaseActivity
  :annotation (goid "GO:0030409")
  :annotation (database "RHEA:15097")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5-formimidoyltetrahydrofolate_2-_ ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N-formimidoyl-L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_6S_-5_6_7_8-tetrahydrofolate_2-_ ch/N-formimidoyl-L-glutamate_1-_)
    (owl-some hasProduct  ch/_5-formimidoyltetrahydrofolate_2-_ ch/L-glutamate_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcyl-PhosphateGlycerol-3-PhosphateAcyltransferaseActivity
  :annotation (goid "GO:0043772")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl_monophosphate_2-_ ch/sn-glycerol_3-phosphate_2-_)
    (owl-some hasProduct  ch/_1-acyl-sn-glycerol_3-phosphate_2-_ ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/_1-acyl-sn-glycerol_3-phosphate_2-_ ch/hydrogenphosphate)
    (owl-some hasProduct  ch/acyl_monophosphate_2-_ ch/sn-glycerol_3-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLysyltransferaseActivity
  :annotation (goid "GO:0050071")
  :annotation (database "RHEA:10668")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-_L-lysyl_adenylyl_1+__group ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_)
    (owl-some hasProduct  ch/AMP_3'-end_1-__residue ch/_1_2-diacyl-sn-glycero-3-phospho-1'-_3'-O-L-lysyl_-sn-glycerol_1+_))
   (owl-and
    (owl-some hasReactant  ch/AMP_3'-end_1-__residue ch/_1_2-diacyl-sn-glycero-3-phospho-1'-_3'-O-L-lysyl_-sn-glycerol_1+_)
    (owl-some hasProduct  ch/_3'-_L-lysyl_adenylyl_1+__group ch/_1_2-diacyl-sn-glycero-3-phospho-_1'-sn-glycerol__1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphomethylpyrimidineKinaseActivity+D648	
  :annotation (goid "GO:0008972")
  :annotation (database "RHEA:19893")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_4-amino-2-methyl-5-phosphonatooxymethylpyrimidine_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_4-amino-2-methyl-5-diphosphonatooxymethylpyrimidine_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_4-amino-2-methyl-5-diphosphonatooxymethylpyrimidine_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_4-amino-2-methyl-5-phosphonatooxymethylpyrimidine_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCytidineKinaseActivity
  :annotation (goid "GO:0043771")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/cytidine)
    (owl-some hasProduct  ch/ADP_3-_ ch/cytidine_5'-monophosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/cytidine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/cytidine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMacrolide2'-KinaseActivity
  :annotation (goid "GO:0050073")
  :annotation (database "RHEA:18333")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/oleandomycin_1+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/oleandomycin_2'-O-phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/oleandomycin_2'-O-phosphate_1-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/oleandomycin_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAmpDimethylallyltransferaseActivity
  :annotation (goid "GO:0009824")
  :annotation (database "RHEA:15285")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/adenosine_5'-monophosphate_2-_ ch/prenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/N_6_-_dimethylallyl_adenosine_5'-phosphate_2-_ ch/diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/N_6_-_dimethylallyl_adenosine_5'-phosphate_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/adenosine_5'-monophosphate_2-_ ch/prenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobalt-Precorrin-6bC5-MethyltransferaseActivity
  :annotation (goid "GO:0043776")
  :annotation (database "RHEA:36067")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/cobalt-precorrin-6B_7-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-7_7-_ ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-7_7-_ ch/carbon_dioxide)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/cobalt-precorrin-6B_7-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeoxycytidineKinaseActivity
  :annotation (goid "GO:0004137")
  :annotation (database "RHEA:20061")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/nucleoside_triphosphate_4-_ ch/_2'-deoxycytidine)
    (owl-some hasProduct  ch/nucleoside_5'-diphosphate_3-_ ch/cytidine_5'-monophosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/nucleoside_5'-diphosphate_3-_ ch/cytidine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/nucleoside_triphosphate_4-_ ch/_2'-deoxycytidine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeoxyadenosineKinaseActivity
  :annotation (goid "GO:0004136")
  :annotation (database "RHEA:23452")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxyadenosine ch/ATP_4-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/_2'-deoxyadenosine ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphoribulokinaseActivity
  :annotation (goid "GO:0008974")
  :annotation (database "RHEA:19365")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/D-ribulose_5-phosphate_2-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/D-ribulose_1_5-bisphosphate_4-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/D-ribulose_1_5-bisphosphate_4-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/D-ribulose_5-phosphate_2-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobalt-Precorrin-7C15-MethyltransferaseActivity
  :annotation (goid "GO:0043777")
  :annotation (database "RHEA:34591")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cobalt-precorrin-7_7-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/cobalt-precorrin-8_6-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/cobalt-precorrin-8_6-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/carbon_dioxide)
    (owl-some hasProduct  ch/cobalt-precorrin-7_7-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLysineCarbamoyltransferaseActivity
  :annotation (goid "GO:0050068")
  :annotation (database "RHEA:17121")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-lysinium_1+_ ch/carbamoyl_phosphate_2-_)
    (owl-some hasProduct  ch/L-homocitrulline_zwitterion ch/hydron ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/L-homocitrulline_zwitterion ch/hydron ch/hydrogenphosphate)
    (owl-some hasProduct  ch/L-lysinium_1+_ ch/carbamoyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCytidylateKinaseActivity
  :annotation (goid "GO:0004127")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_2'-deoxycytosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/dCDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/dCDP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_2'-deoxycytosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLuteolin7-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0050064")
  :annotation (database "RHEA:10568")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-_3_4-dihydroxyphenyl_-5-hydroxy-4-oxo-4H-chromen-7-olate_luteolin-7-olate_1-_ ch/UDP-alpha-D-glucuronate_3-_)
    (owl-some hasProduct  ch/luteolin_7-O-beta-D-glucosiduronate_2-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/luteolin_7-O-beta-D-glucosiduronate_2-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/_2-_3_4-dihydroxyphenyl_-5-hydroxy-4-oxo-4H-chromen-7-olate_luteolin-7-olate_1-_ ch/UDP-alpha-D-glucuronate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobalt-FactorIiC20-MethyltransferaseActivity
  :annotation (goid "GO:0043781")
  :annotation (database "RHEA:17997")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/cobalt-precorrin-2_8-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-3_8-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-3_8-_ ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/cobalt-precorrin-2_8-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCobalt-Precorrin-5bC1-MethyltransferaseActivity
  :annotation (goid "GO:0043780")
  :annotation (database "RHEA:26285")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/cobalt-precorrin-5B_8-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-6A_7-_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/cobalt-precorrin-6A_7-_)
    (owl-some hasProduct  ch/cobalt-precorrin-5B_8-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLysine-Pyruvate6-TransaminaseActivity
  :annotation (goid "GO:0050065")
  :annotation (database "RHEA:19393")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-lysinium_1+_ ch/pyruvate)
    (owl-some hasProduct  ch/L-alanine_zwitterion ch/L-allysine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/L-alanine_zwitterion ch/L-allysine_zwitterion)
    (owl-some hasProduct  ch/L-lysinium_1+_ ch/pyruvate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-LeucineTransaminaseActivity
  :annotation (goid "GO:0052654")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-leucine_zwitterion)
    (owl-some hasProduct  ch/_4-methyl-2-oxopentanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_4-methyl-2-oxopentanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-leucine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-ValineTransaminaseActivity
  :annotation (goid "GO:0052655")
  :annotation (database "RHEA:24813")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-valine_zwitterion)
    (owl-some hasProduct  ch/_3-methyl-2-oxobutanoate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_3-methyl-2-oxobutanoate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-valine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUracilylalanineSynthaseActivity
  :annotation (goid "GO:0050471")
  :annotation (database "RHEA:11496")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/O-acetyl-L-serine_zwitterion ch/uracil)
    (owl-some hasProduct  ch/_3-_uracil-1-yl_-L-alanine_zwitterion ch/acetate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3-_uracil-1-yl_-L-alanine_zwitterion ch/acetate ch/hydron)
    (owl-some hasProduct  ch/O-acetyl-L-serine_zwitterion ch/uracil)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-IsoleucineTransaminaseActivity
  :annotation (goid "GO:0052656")
  :annotation (database "RHEA:24801")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutarate_2-_ ch/L-isoleucine_zwitterion)
    (owl-some hasProduct  ch/_S_-3-methyl-2-oxovalerate ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/_S_-3-methyl-2-oxovalerate ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/_2-oxoglutarate_2-_ ch/L-isoleucine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseNucleosideKinaseActivity
  :annotation (goid "GO:0019206")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/nucleoside)
    (owl-some hasProduct  ch/ADP_3-_ ch/nucleoside_5'-monophosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/nucleoside_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/nucleoside)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGuaninePhosphoribosyltransferaseActivity
  :annotation (goid "GO:0052657")
  :annotation (database "RHEA:25424")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/guanosine_5'-monophosphate_2-_ ch/diphosphate_3-_)
    (owl-some hasProduct  ch/guanine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_))
   (owl-and
    (owl-some hasReactant  ch/guanine ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_)
    (owl-some hasProduct  ch/guanosine_5'-monophosphate_2-_ ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse_R_-citramalateSynthaseActivity
  :annotation (goid "GO:0043714")
  :annotation (database "RHEA:19045")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyruvate ch/acetyl-CoA_4-_ ch/water)
    (owl-some hasProduct  ch/D-citramalate_2-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/D-citramalate_2-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/pyruvate ch/acetyl-CoA_4-_ ch/water)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-HydroxyisocaproateCoa-TransferaseActivity
  :annotation (goid "GO:0043712")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_R_-2-hydroxy-4-methylpentanoate ch/_4-methylpentanoyl-CoA_4-_)
    (owl-some hasProduct  ch/_R_-2-hydroxy-4-methylpentanoyl-CoA_4-_ ch/isocaproate))
   (owl-and
    (owl-some hasReactant  ch/_R_-2-hydroxy-4-methylpentanoyl-CoA_4-_ ch/isocaproate)
    (owl-some hasProduct  ch/_R_-2-hydroxy-4-methylpentanoate ch/_4-methylpentanoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsoflavone7-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0050004")
  :annotation (database "RHEA:56344")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/_7-hydroxyisoflavones)
    (owl-some hasProduct  ch/UDP_3-_ ch/_7-hydroxyisoflavones_7-O-beta-D-glucoside ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/_7-hydroxyisoflavones_7-O-beta-D-glucoside ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/_7-hydroxyisoflavones)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDeoxycytidylateC-MethyltransferaseActivity
  :annotation (goid "GO:0050003")
  :annotation (database "RHEA:11568")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/_2'-deoxy-5-methyl-5'-cytidylate_2-_ ch/dihydrofolate_2-_))
   (owl-and
    (owl-some hasReactant  ch/_2'-deoxy-5-methyl-5'-cytidylate_2-_ ch/dihydrofolate_2-_)
    (owl-some hasProduct  ch/_6R_-5_10-methylenetetrahydrofolate_2-_ ch/_2'-deoxyadenosine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSulfoacetaldehydeAcetyltransferaseActivity
  :annotation (goid "GO:0050487")
  :annotation (database "RHEA:24204")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl_phosphate_2-_ ch/sulfite ch/hydron)
    (owl-some hasProduct  ch/hydrogenphosphate ch/sulfonatoacetaldehyde))
   (owl-and
    (owl-some hasReactant  ch/hydrogenphosphate ch/sulfonatoacetaldehyde)
    (owl-some hasProduct  ch/acetyl_phosphate_2-_ ch/sulfite ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCtp:2-Trans_-6-Trans-FarnesolKinaseActivity
  :annotation (goid "GO:0052669")
  :annotation (database "RHEA:51680")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_2-trans_6-trans_-farnesol ch/CTP_4-_)
    (owl-some hasProduct  ch/_2E_6E_-farnesyl_monophosphate_2-_ ch/CDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_2E_6E_-farnesyl_monophosphate_2-_ ch/CDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_2-trans_6-trans_-farnesol ch/CTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhosphomethylethanolamineN-MethyltransferaseActivity
  :annotation (goid "GO:0052667")
  :annotation (database "RHEA:25322")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/N-methylethanolaminium_phosphate_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/N_N-dimethylethanolamine_phosphate_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/N_N-dimethylethanolamine_phosphate_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/N-methylethanolaminium_phosphate_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsonocardicinSynthaseActivity
  :annotation (goid "GO:0050007")
  :annotation (database "RHEA:19845")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/nocardicin_E_2-_)
    (owl-some hasProduct  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/isonocardicin_A_2-_))
   (owl-and
    (owl-some hasReactant  ch/_5'-S-methyl-5'-thioadenosine ch/hydron ch/isonocardicin_A_2-_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/nocardicin_E_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseFarnesolKinaseActivity
  :annotation (goid "GO:0052668")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/farnesol ch/nucleoside_triphosphate_4-_)
    (owl-some hasProduct  ch/_2E_6E_-farnesyl_monophosphate_2-_ ch/nucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2E_6E_-farnesyl_monophosphate_2-_ ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/farnesol ch/nucleoside_triphosphate_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse2-Keto-4-MethylthiobutyrateAminotransferaseActivity
  :annotation (goid "GO:0043728")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-methylthio-2-oxobutanoic_acid ch/L-glutamine_zwitterion)
    (owl-some hasProduct  ch/_2-oxoglutaramate ch/L-methionine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_2-oxoglutaramate ch/L-methionine_zwitterion)
    (owl-some hasProduct  ch/_4-methylthio-2-oxobutanoic_acid ch/L-glutamine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDimethylallyltranstransferaseActivity
  :annotation (goid "GO:0004161")
  :annotation (database "RHEA:22408")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)
    (owl-some hasProduct  ch/diphosphate_3-_ ch/geranyl_diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/diphosphate_3-_ ch/geranyl_diphosphate_3-_)
    (owl-some hasProduct  ch/prenyl_diphosphate_3-_ ch/isopentenyl_diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiphthineSynthaseActivity
  :annotation (goid "GO:0004164")
  :annotation (database "RHEA:20145")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_2-_3-amino-3-carboxypropyl_-L-histidine_dizwitterion)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-_3-carboxylato-3-_methylammonio_propyl_-L-histidine_dizwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_2-_3-carboxylato-3-_methylammonio_propyl_-L-histidine_dizwitterion ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_2-_3-amino-3-carboxypropyl_-L-histidine_dizwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolichyl-PhosphateAlpha-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0004166")
  :annotation (database "RHEA:14693")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/dolichyl_N-acetyl-alpha-D-glucosaminyl_phosphate_1-_))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/dolichyl_N-acetyl-alpha-D-glucosaminyl_phosphate_1-_)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/dolichyl_phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDolicholKinaseActivity
  :annotation (goid "GO:0004168")
  :annotation (database "RHEA:13133")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CTP_4-_ ch/dolichol)
    (owl-some hasProduct  ch/CDP_3-_ ch/dolichyl_phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/CDP_3-_ ch/dolichyl_phosphate_2-_)
    (owl-some hasProduct  ch/CTP_4-_ ch/dolichol)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3-Keto-5-AminohexanoateCleavageActivity
  :annotation (goid "GO:0043720")
  :annotation (database "RHEA:31555")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_5S_-5-amino-3-oxohexanoic_acid_zwitterion ch/acetyl-CoA_4-_)
    (owl-some hasProduct  ch/L-3-aminobutanoyl-CoA_3-_ ch/acetoacetate))
   (owl-and
    (owl-some hasReactant  ch/L-3-aminobutanoyl-CoA_3-_ ch/acetoacetate)
    (owl-some hasProduct  ch/_5S_-5-amino-3-oxohexanoic_acid_zwitterion ch/acetyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCtp:GeranylgeraniolKinaseActivity
  :annotation (goid "GO:0052672")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/geranylgeraniol ch/CTP_4-_)
    (owl-some hasProduct  ch/_2E_6E_10E_-geranylgeranyl_phosphate_2-_ ch/CDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2E_6E_10E_-geranylgeranyl_phosphate_2-_ ch/CDP_3-_)
    (owl-some hasProduct  ch/geranylgeraniol ch/CTP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePrenolKinaseActivity
  :annotation (goid "GO:0052673")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/prenol ch/nucleoside_triphosphate_4-_)
    (owl-some hasProduct  ch/prenyl_phosphate_2-_ ch/nucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/prenyl_phosphate_2-_ ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/prenol ch/nucleoside_triphosphate_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGeraniolKinaseActivity
  :annotation (goid "GO:0052670")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/geraniol ch/nucleoside_triphosphate_4-_)
    (owl-some hasProduct  ch/geranyl_phosphate ch/nucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/geranyl_phosphate ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/geraniol ch/nucleoside_triphosphate_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseIsovitexinBeta-GlucosyltransferaseActivity
  :annotation (goid "GO:0050010")
  :annotation (database "RHEA:19529")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/isovitexin-7-olate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/hydron ch/isovitexin_2''-O-beta-D-glucoside_1-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/isovitexin_2''-O-beta-D-glucoside_1-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/isovitexin-7-olate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGeranylgeraniolKinaseActivity
  :annotation (goid "GO:0052671")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/geranylgeraniol ch/nucleoside_triphosphate_4-_)
    (owl-some hasProduct  ch/_2E_6E_10E_-geranylgeranyl_phosphate_2-_ ch/nucleoside_5'-diphosphate_3-_))
   (owl-and
    (owl-some hasReactant  ch/_2E_6E_10E_-geranylgeranyl_phosphate_2-_ ch/nucleoside_5'-diphosphate_3-_)
    (owl-some hasProduct  ch/geranylgeraniol ch/nucleoside_triphosphate_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyrimidine-NucleosidePhosphorylaseActivity
  :annotation (goid "GO:0016154")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyrimidine_nucleoside ch/hydrogenphosphate)
    (owl-some hasProduct  ch/pyrimidine ch/alpha-D-ribose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/pyrimidine ch/alpha-D-ribose_1-phosphate_2-_)
    (owl-some hasProduct  ch/pyrimidine_nucleoside ch/hydrogenphosphate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSucroseSynthaseActivity
  :annotation (goid "GO:0016157")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/beta-D-fructofuranose)
    (owl-some hasProduct  ch/UDP_3-_ ch/sucrose ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/sucrose ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/beta-D-fructofuranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCaffeoyl-CoaO-MethyltransferaseActivity
  :annotation (goid "GO:0042409")
  :annotation (database "RHEA:16925")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/caffeoyl-CoA_4-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/trans-feruloyl-CoA_4-_))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/trans-feruloyl-CoA_4-_)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/caffeoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseEcdysoneO-AcyltransferaseActivity
  :annotation (goid "GO:0004173")
  :annotation (database "RHEA:15217")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ecdysone ch/palmitoyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/ecdysone_palmitate))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/ecdysone_palmitate)
    (owl-some hasProduct  ch/ecdysone ch/palmitoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseN-AcetyllactosaminideBeta-1_3-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0008532")
  :annotation (database "RHEA:14389")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide)
    (owl-some hasProduct  ch/UDP_3-_ ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRiboflavinKinaseActivity
  :annotation (goid "GO:0008531")
  :annotation (database "RHEA:14357")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/riboflavin_1-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/FMN_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/FMN_3-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/riboflavin_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseL-tyrosineGlycogeninGlucosyltransferaseActivity
  :annotation (goid "GO:0008466")
  :annotation (database "RHEA:23360")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-alpha-D-glucose_2-_ ch/L-tyrosine_residue)
    (owl-some hasProduct  ch/UDP_3-_ ch/alpha-D-glucosyl-L-tyrosyl_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/alpha-D-glucosyl-L-tyrosyl_residue ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucose_2-_ ch/L-tyrosine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseHistone-ArginineN-MethyltransferaseActivity
  :annotation (goid "GO:0008469")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/L-argininium_residue)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_omega_-methyl-argininium_1+__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/N_omega_-methyl-argininium_1+__residue ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/L-argininium_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetin-3_4'-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0102411")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/quercetin_3-glucoside-3'-sulfate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/quercetin_3_4'-di-O-beta-D-glucoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/quercetin_3_4'-di-O-beta-D-glucoside ch/UDP_3-_)
    (owl-some hasProduct  ch/quercetin_3-glucoside-3'-sulfate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetin-4'_3-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0102410")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/quercetin_4'-O-beta-D-glucopyranoside ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/quercetin_3_4'-di-O-beta-D-glucoside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/quercetin_3_4'-di-O-beta-D-glucoside ch/UDP_3-_)
    (owl-some hasProduct  ch/quercetin_4'-O-beta-D-glucopyranoside ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetinGentiobioside1_6-GlucosyltransferaseActivity
  :annotation (goid "GO:0102415")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/quercetin_3-beta-gentiobioside ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/quercetin_3-beta-gentiotrioside ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/quercetin_3-beta-gentiotrioside ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/quercetin_3-beta-gentiobioside ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetin-3-O-Glucoside1_6-GlucosyltransferaseActivity
  :annotation (goid "GO:0102414")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/quercetin_3-glucoside-3'-sulfate ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/quercetin_3-beta-gentiobioside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/quercetin_3-beta-gentiobioside ch/UDP_3-_)
    (owl-some hasProduct  ch/quercetin_3-glucoside-3'-sulfate ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridoxalKinaseActivity
  :annotation (goid "GO:0008478")
  :annotation (database "RHEA:10224")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/pyridoxal)
    (owl-some hasProduct  ch/ADP_3-_ ch/pyridoxal_5'-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/pyridoxal_5'-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/pyridoxal)))
  :enzyme Transferase)

(defcatalyse ToCatalyseProtein-TyrosineSulfotransferaseActivity
  :annotation (goid "GO:0008476")
  :annotation (database "RHEA:16801")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/L-tyrosine_residue)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/L-tyrosine-O-sulfate_1-__residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/L-tyrosine-O-sulfate_1-__residue ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/L-tyrosine_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQueuinetRNA-RibosyltransferaseActivity
  :annotation (goid "GO:0008479")
  :annotation (database "RHEA:16633")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/guanosine_5'-monophosphate_1-__residue ch/queuine_1+_)
    (owl-some hasProduct  ch/queuosine_5'-phosphate_zwitterion_residue ch/guanine))
   (owl-and
    (owl-some hasReactant  ch/queuosine_5'-phosphate_zwitterion_residue ch/guanine)
    (owl-some hasProduct  ch/guanosine_5'-monophosphate_1-__residue ch/queuine_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLanosterolO-AcyltransferaseActivity
  :annotation (goid "GO:0034738")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/lanosterol)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/lanosteryl_ester))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/lanosteryl_ester)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/lanosterol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseErgosterolO-AcyltransferaseActivity
  :annotation (goid "GO:0034737")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/ergosterol)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/ergosteryl_ester))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/ergosteryl_ester)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/ergosterol)))
  :enzyme Transferase)

(defcatalyse ToCatalysePhenanthrolGlycosyltransferaseActivity
  :annotation (goid "GO:0019112")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/phenanthrol ch/D-glucopyranose)
    (owl-some hasProduct  ch/phenanthryl_beta-D-glucopyranoside ch/water))
   (owl-and
    (owl-some hasReactant  ch/phenanthryl_beta-D-glucopyranoside ch/water)
    (owl-some hasProduct  ch/phenanthrol ch/D-glucopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseXylanO-AcetyltransferaseActivity
  :annotation (goid "GO:1990538")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/xylan)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/acetyl_xylan))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/acetyl_xylan)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/xylan)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMaltodextrinPhosphorylaseActivity
  :annotation (goid "GO:0031220")
  :annotation (database "RHEA:29691")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/maltodextrin)
    (owl-some hasProduct  ch/alpha-D-glucose_1-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/alpha-D-glucose_1-phosphate_2-_)
    (owl-some hasProduct  ch/maltodextrin)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCholesterolO-AcyltransferaseActivity
  :annotation (goid "GO:0034736")
  :annotation (database "RHEA:17729")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/cholesterol)
    (owl-some hasProduct  ch/cholesteryl_ester ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/cholesteryl_ester ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/cholesterol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKaempferol-3-O-Glucoside1_6-GlucosyltransferaseActivity
  :annotation (goid "GO:0102428")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/kaempferol_3-O-beta-D-glucoside ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/kaempferol_3-beta-gentiobioside ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/kaempferol_3-beta-gentiobioside ch/UDP_3-_)
    (owl-some hasProduct  ch/kaempferol_3-O-beta-D-glucoside ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseInositol-1_4_5-Trisphosphate3-KinaseActivity
  :annotation (goid "GO:0008440")
  :annotation (database "RHEA:11020")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_1D-myo-inositol_1_4_5-trisphosphate_6-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/_1D-myo-inositol_1_3_4_5-tetrakisphosphate_8-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1D-myo-inositol_1_3_4_5-tetrakisphosphate_8-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/_1D-myo-inositol_1_4_5-trisphosphate_6-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCaffeoyl-Coa:AlcoholCaffeoylTransferaseActivity
  :annotation (goid "GO:0090430")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/caffeoyl-CoA_4-_ ch/aromatic_primary_alcohol)
    (owl-some hasProduct  ch/alkyl_caffeate_ester ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/alkyl_caffeate_ester ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/caffeoyl-CoA_4-_ ch/aromatic_primary_alcohol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBranched-Chain-Amino-AcidTransaminaseActivity
  :annotation (goid "GO:0004084")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/branched-chain_amino_acid ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/L-glutamate_1-_ ch/_2-oxo_monocarboxylic_acid))
   (owl-and
    (owl-some hasReactant  ch/L-glutamate_1-_ ch/_2-oxo_monocarboxylic_acid)
    (owl-some hasProduct  ch/branched-chain_amino_acid ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMyricetin3-O-GlucosyltransferaseActivity
  :annotation (goid "GO:0102425")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myricetin_1-_ ch/UDP-alpha-D-glucose_2-_)
    (owl-some hasProduct  ch/myricetin_3-O-beta-D-glucopyranoside_1-_ ch/UDP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/myricetin_3-O-beta-D-glucopyranoside_1-_ ch/UDP_3-_ ch/hydron)
    (owl-some hasProduct  ch/myricetin_1-_ ch/UDP-alpha-D-glucose_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCdp-Diacylglycerol-Glycerol-3-Phosphate3-PhosphatidyltransferaseActivity
  :annotation (goid "GO:0008444")
  :annotation (database "RHEA:12593")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/sn-glycerol_3-phosphate_2-_ ch/CDP-diacylglycerol_2-_)
    (owl-some hasProduct  ch/_1-_3-sn-phosphatidyl_-sn-glycerol_3-phosphate_3-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_1-_3-sn-phosphatidyl_-sn-glycerol_3-phosphate_3-_ ch/cytidine_5'-monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/sn-glycerol_3-phosphate_2-_ ch/CDP-diacylglycerol_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcetateKinase_diphosphate_Activity
  :annotation (goid "GO:0047601")
  :annotation (database "RHEA:24276")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetate ch/diphosphate_3-_)
    (owl-some hasProduct  ch/acetyl_phosphate_2-_ ch/hydrogenphosphate))
   (owl-and
    (owl-some hasReactant  ch/acetyl_phosphate_2-_ ch/hydrogenphosphate)
    (owl-some hasProduct  ch/acetate ch/diphosphate_3-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAbequosyltransferaseActivity
  :annotation (goid "GO:0047600")
  :annotation (database "RHEA:34183")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/CDP-alpha-D-abequose_2-_ ch/alpha-D-mannosyl-_1->4_-alpha-L-rhamnosyl-_1->3_-beta-D-galactosyl-1-diphosphodecaprenol_2-_)
    (owl-some hasProduct  ch/CDP_3-_ ch/alpha-D-abequosyl-_1->3_-alpha-D-mannosyl-_1->4_-alpha-L-rhamnosyl-_1->3_-beta-D-galactosyl-1-diphosphodecaprenol_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/CDP_3-_ ch/alpha-D-abequosyl-_1->3_-alpha-D-mannosyl-_1->4_-alpha-L-rhamnosyl-_1->3_-beta-D-galactosyl-1-diphosphodecaprenol_2-_ ch/hydron)
    (owl-some hasProduct  ch/CDP-alpha-D-abequose_2-_ ch/alpha-D-mannosyl-_1->4_-alpha-L-rhamnosyl-_1->3_-beta-D-galactosyl-1-diphosphodecaprenol_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseScymnolSulfotransferaseActivity
  :annotation (goid "GO:0033874")
  :annotation (database "RHEA:15477")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/_5beta-scymnol)
    (owl-some hasProduct  ch/_5beta-scymnol_sulfate_1-_ ch/adenosine_3'_5'-bismonophosphate_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_5beta-scymnol_sulfate_1-_ ch/adenosine_3'_5'-bismonophosphate_4-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/_5beta-scymnol)))
  :enzyme Transferase)

(defcatalyse ToCatalysePetromyzonolSulfotransferaseActivity
  :annotation (goid "GO:0033873")
  :annotation (database "RHEA:16997")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/_5alpha-cholane-3alpha_7alpha_12alpha_24-tetrol)
    (owl-some hasProduct  ch/_3alpha_7alpha_12alpha-trihydroxy-5alpha-cholan-24-yl_sulfate_1-_ ch/adenosine_3'_5'-bismonophosphate_4-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3alpha_7alpha_12alpha-trihydroxy-5alpha-cholan-24-yl_sulfate_1-_ ch/adenosine_3'_5'-bismonophosphate_4-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/_5alpha-cholane-3alpha_7alpha_12alpha_24-tetrol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseQuercetin7-O-MethyltransferaseActivity
  :annotation (goid "GO:0102432")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/quercetin-7-olate ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/rhamnetin ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/rhamnetin ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/quercetin-7-olate ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSuccinyl-Coa:_R_-BenzylsuccinateCoa-TransferaseActivity
  :annotation (goid "GO:0033877")
  :annotation (database "RHEA:16469")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_R_-2-benzylsuccinate ch/succinyl-CoA_5-_)
    (owl-some hasProduct  ch/_R_-2-benzylsuccinyl-CoA ch/succinate_2-_))
   (owl-and
    (owl-some hasReactant  ch/_R_-2-benzylsuccinyl-CoA ch/succinate_2-_)
    (owl-some hasProduct  ch/_R_-2-benzylsuccinate ch/succinyl-CoA_5-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycochenodeoxycholateSulfotransferaseActivity
  :annotation (goid "GO:0033876")
  :annotation (database "RHEA:17689")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/glycochenodeoxycholate)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/glycochenodeoxycholate_7-sulfate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/glycochenodeoxycholate_7-sulfate_2-_ ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/glycochenodeoxycholate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseTetraketideAlpha-PyroneSynthaseActivity
  :annotation (goid "GO:0090439")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/hydroxyacyl-CoA ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron)
    (owl-some hasProduct  ch/_2H-pyran-2-one ch/carbon_dioxide ch/coenzyme_A_4-_ ch/carbon_dioxide ch/carbon_dioxide ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/_2H-pyran-2-one ch/carbon_dioxide ch/coenzyme_A_4-_ ch/carbon_dioxide ch/carbon_dioxide ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/hydroxyacyl-CoA ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/malonyl-CoA_5-_ ch/hydron ch/hydron)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGlycerol-3-Phosphate2-O-AcyltransferaseActivity
  :annotation (goid "GO:0090447")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acyl-CoA_4-_ ch/sn-glycerol_3-phosphate_2-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/_2-acyl-sn-glycero-3-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/_2-acyl-sn-glycero-3-phosphate_2-_)
    (owl-some hasProduct  ch/acyl-CoA_4-_ ch/sn-glycerol_3-phosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyse3'_4'_5'-Trimethylmyricetin7-O-MethyltransferaseActivity
  :annotation (goid "GO:0102439")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'_5_7-trihydroxy-3_4'_5'-trimethoxyflavone ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_5-dihydroxy-3_4'_5'_7-tetramethoxyflavone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_5-dihydroxy-3_4'_5'_7-tetramethoxyflavone ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/_3'_5_7-trihydroxy-3_4'_5'-trimethoxyflavone ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseLaricitrin4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0102438")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/laricitrin_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/hydron ch/syringetin_1-_ ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/hydron ch/syringetin_1-_ ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/laricitrin_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarnitineO-AcetyltransferaseActivity
  :annotation (goid "GO:0004092")
  :annotation (database "RHEA:21136")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/acetyl-CoA_4-_ ch/_R_-carnitine)
    (owl-some hasProduct  ch/O-acetyl-L-carnitine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/O-acetyl-L-carnitine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/acetyl-CoA_4-_ ch/_R_-carnitine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiolSulfotransferaseActivity
  :annotation (goid "GO:0033870")
  :annotation (database "RHEA:14637")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/thiol)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/S-alkyl_thiosulfate_anion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/S-alkyl_thiosulfate_anion ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/thiol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMyricetin3-O-MethyltransferaseActivity
  :annotation (goid "GO:0102437")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/myricetin_1-_ ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/laricitrin_1-_ ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/laricitrin_1-_ ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/myricetin_1-_ ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarnitineO-PalmitoyltransferaseActivity
  :annotation (goid "GO:0004095")
  :annotation (database "RHEA:12661")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/palmitoyl-CoA_4-_ ch/_R_-carnitine)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/O-palmitoyl-L-carnitine))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/O-palmitoyl-L-carnitine)
    (owl-some hasProduct  ch/palmitoyl-CoA_4-_ ch/_R_-carnitine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlpha-1_6-Mannosylglycoprotein2-Beta-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0008455")
  :annotation (database "RHEA:12941")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-Asn_residue)
    (owl-some hasProduct  ch/UDP_3-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAcl-_1->4_-beta-D-GlcNAc_-Asn_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAcl-_1->4_-beta-D-GlcNAc_-Asn_residue ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-Asn_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlpha-1_3-Mannosylglycoprotein4-Beta-N-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0008454")
  :annotation (database "RHEA:16057")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAcl-_1->4_-beta-D-GlcNAc_-Asn_residue)
    (owl-some hasProduct  ch/UDP_3-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-_beta-D-GlcNAc-_1->4__-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAc-_1->4_-beta-D-GlcNAc_-L-Asn_residue ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/N_4_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->3_-_beta-D-GlcNAc-_1->2_-alpha-D-Man-_1->6__-beta-D-Man-_1->4_-beta-D-GlcNAcl-_1->4_-beta-D-GlcNAc_-Asn_residue)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAlanine-GlyoxylateTransaminaseActivity
  :annotation (goid "GO:0008453")
  :annotation (database "RHEA:24248")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/L-alanine_zwitterion ch/glyoxylate)
    (owl-some hasProduct  ch/pyruvate ch/glycine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/pyruvate ch/glycine_zwitterion)
    (owl-some hasProduct  ch/L-alanine_zwitterion ch/glyoxylate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChondroitin6-SulfotransferaseActivity
  :annotation (goid "GO:0008459")
  :annotation (database "RHEA:11108")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/chondroitin_D-glucuronate_anion)
    (owl-some hasProduct  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/chondroitin_6'-sulfate_anion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/adenosine_3'_5'-bismonophosphate_4-_ ch/chondroitin_6'-sulfate_anion ch/hydron)
    (owl-some hasProduct  ch/_3'-phosphonato-5'-adenylyl_sulfate_4-_ ch/chondroitin_D-glucuronate_anion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseCarnitineO-OctanoyltransferaseActivity
  :annotation (goid "GO:0008458")
  :annotation (database "RHEA:17177")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_R_-carnitine ch/octanoyl-CoA_4-_)
    (owl-some hasProduct  ch/O-octanoyl-L-carnitine ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant  ch/O-octanoyl-L-carnitine ch/coenzyme_A_4-_)
    (owl-some hasProduct  ch/_R_-carnitine ch/octanoyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBeta-Galactosyl-N-Acetylglucosaminylgalactosylglucosyl-CeramideBeta-1_3-AcetylglucosaminyltransferaseActivity
  :annotation (goid "GO:0008457")
  :annotation (database "RHEA:23004")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)
    (owl-some hasProduct  ch/UDP_3-_ ch/beta-D-GlcpNAc-_1->3_-beta-D-Galp-_1->4_-beta-D-GlcpNAc-_1->3_-beta-D-Galp-_1->4_-beta-D-Glcp-_1<->1'_-Cer ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/beta-D-GlcpNAc-_1->3_-beta-D-Galp-_1->4_-beta-D-GlcpNAc-_1->3_-beta-D-Galp-_1->4_-beta-D-Glcp-_1<->1'_-Cer ch/hydron)
    (owl-some hasProduct  ch/UDP-N-acetyl-alpha-D-glucosamine_2-_ ch/beta-D-galactosyl-_1->4_-N-acetyl-beta-D-glucosaminyl-_1->3_-beta-D-galactosyl-_1->4_-beta-D-glucosylceramide)))
  :enzyme Transferase)

(defcatalyse ToCatalyseAcylglycerolKinaseActivity
  :annotation (goid "GO:0047620")
  :annotation (database "RHEA:19293")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/_1-acyl-sn-glycerol)
    (owl-some hasProduct  ch/ADP_3-_ ch/monoacyl-sn-glycerol_3-phosphate_2-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/monoacyl-sn-glycerol_3-phosphate_2-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/_1-acyl-sn-glycerol)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDecaprenyldihydroxybenzoateMethyltransferaseActivity
  :annotation (goid "GO:0044595")
  :annotation (database "RHEA:44492")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/_3-decaprenyl-4_5-dihydroxybenzoate)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/_3-decaprenyl-4-hydroxy-5-methoxybenzoate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/_3-decaprenyl-4-hydroxy-5-methoxybenzoate ch/hydron)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/_3-decaprenyl-4_5-dihydroxybenzoate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRibose1_5-BisphosphatePhosphokinaseActivity
  :annotation (goid "GO:0033863")
  :annotation (database "RHEA:20109")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alpha-D-ribose_1_5-bisphosphate_4-_ ch/ATP_4-_)
    (owl-some hasProduct  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/ADP_3-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_5-O-phosphonato-alpha-D-ribofuranosyl_diphosphate_5-_ ch/ADP_3-_ ch/hydron)
    (owl-some hasProduct  ch/alpha-D-ribose_1_5-bisphosphate_4-_ ch/ATP_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseUmpKinaseActivity
  :annotation (goid "GO:0033862")
  :annotation (database "RHEA:24400")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/uridine_5'-monophosphate_2-_)
    (owl-some hasProduct  ch/ADP_3-_ ch/UDP_3-_))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/UDP_3-_)
    (owl-some hasProduct  ch/ATP_4-_ ch/uridine_5'-monophosphate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseKaempferol3-O-MethyltransferaseActivity
  :annotation (goid "GO:0102449")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/kaempferol_oxoanion ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3-methoxyapigenin ch/S-adenosyl-L-homocysteine_zwitterion))
   (owl-and
    (owl-some hasReactant  ch/_3-methoxyapigenin ch/S-adenosyl-L-homocysteine_zwitterion)
    (owl-some hasProduct  ch/kaempferol_oxoanion ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseGibberellinCarboxyl-O-MethyltransferaseActivity
  :annotation (goid "GO:0010341")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-methionine_zwitterion ch/gibberellin_A20_1-_)
    (owl-some hasProduct  ch/S-adenosyl-L-homocysteine_zwitterion ch/gibberellin_A20_methyl_ester))
   (owl-and
    (owl-some hasReactant  ch/S-adenosyl-L-homocysteine_zwitterion ch/gibberellin_A20_methyl_ester)
    (owl-some hasProduct  ch/S-adenosyl-L-methionine_zwitterion ch/gibberellin_A20_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRhamnetin3-O-MethyltransferaseActivity
  :annotation (goid "GO:0102446")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/_3'_4'_5-trihydroxy-3_7-dimethoxyflavone_1-_ ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRhamnetin4'-O-MethyltransferaseActivity
  :annotation (goid "GO:0102448")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/ombuin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ombuin ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalyseRhamnetin3'-O-MethyltransferaseActivity
  :annotation (goid "GO:0102447")
  :annotation (database "Not available RHEA")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)
    (owl-some hasProduct  ch/rhamnacene ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/rhamnacene ch/S-adenosyl-L-homocysteine_zwitterion ch/hydron)
    (owl-some hasProduct  ch/rhamnetin ch/S-adenosyl-L-methionine_zwitterion)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridoxamine-OxaloacetateTransaminaseActivity
  :annotation (goid "GO:0019162")
  :annotation (database "RHEA:10844")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/oxaloacetate_2-_ ch/pyridoxamine)
    (owl-some hasProduct  ch/L-aspartate_1-_ ch/pyridoxal))
   (owl-and
    (owl-some hasReactant  ch/L-aspartate_1-_ ch/pyridoxal)
    (owl-some hasProduct  ch/oxaloacetate_2-_ ch/pyridoxamine)))
  :enzyme Transferase)

(defcatalyse ToCatalyseDiamineTransaminaseActivity
  :annotation (goid "GO:0019161")
  :annotation (database "RHEA:18217")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/alkane-alpha_omega-diammonium_2+_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/omega-ammonioaldehyde ch/L-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/omega-ammonioaldehyde ch/L-glutamate_1-_)
    (owl-some hasProduct  ch/alkane-alpha_omega-diammonium_2+_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalysePyridoxamine-PhosphateTransaminaseActivity
  :annotation (goid "GO:0019163")
  :annotation (database "RHEA:15877")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/pyridoxamine_5'-phosphate_1-_ ch/_2-oxoglutarate_2-_)
    (owl-some hasProduct  ch/pyridoxal_5'-phosphate_2-_ ch/D-glutamate_1-_))
   (owl-and
    (owl-some hasReactant  ch/pyridoxal_5'-phosphate_2-_ ch/D-glutamate_1-_)
    (owl-some hasProduct  ch/pyridoxamine_5'-phosphate_1-_ ch/_2-oxoglutarate_2-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseThiamineKinaseActivity
  :annotation (goid "GO:0019165")
  :annotation (database "RHEA:12012")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/thiamine_1+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/hydron ch/thiamine_1+__monophosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/hydron ch/thiamine_1+__monophosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/thiamine_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseBisdemethoxycurcuminSynthaseActivity
  :annotation (goid "GO:0102452")
  :annotation (database "RHEA:34803")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/_4-coumaroyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/water ch/hydron ch/_4-coumaroyl-CoA_4-_)
    (owl-some hasProduct  ch/coenzyme_A_4-_ ch/bisdemethoxycurcumin ch/carbon_dioxide ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/carbon_dioxide))
   (owl-and
    (owl-some hasReactant  ch/coenzyme_A_4-_ ch/bisdemethoxycurcumin ch/carbon_dioxide ch/coenzyme_A_4-_ ch/coenzyme_A_4-_ ch/carbon_dioxide)
    (owl-some hasProduct  ch/_4-coumaroyl-CoA_4-_ ch/malonyl-CoA_5-_ ch/water ch/hydron ch/_4-coumaroyl-CoA_4-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseD-RibulokinaseActivity
  :annotation (goid "GO:0019150")
  :annotation (database "RHEA:17601")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/D-ribulose)
    (owl-some hasProduct  ch/ADP_3-_ ch/D-ribulose_5-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/D-ribulose_5-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/D-ribulose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseMannokinaseActivity
  :annotation (goid "GO:0019158")
  :annotation (database "RHEA:11028")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/D-mannopyranose)
    (owl-some hasProduct  ch/ADP_3-_ ch/D-hexopyranose_6-phosphate_2-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/D-hexopyranose_6-phosphate_2-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/D-mannopyranose)))
  :enzyme Transferase)

(defcatalyse ToCatalyseSphinganineKinaseActivity
  :annotation (goid "GO:0008481")
  :annotation (database "RHEA:15465")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant  ch/ATP_4-_ ch/sphinganine_1+_)
    (owl-some hasProduct  ch/ADP_3-_ ch/sphinganine_1-phosphate_1-_ ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/ADP_3-_ ch/sphinganine_1-phosphate_1-_ ch/hydron)
    (owl-some hasProduct  ch/ATP_4-_ ch/sphinganine_1+_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseWogonin7-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0102468")
  :annotation (database "RHEA:28322")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/UDP-alpha-D-glucuronate_3-_ ch/wogonin_1-_)
    (owl-some hasProduct  ch/UDP_3-_ ch/wogonin_7-O-beta-D-glucuronate ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/wogonin_7-O-beta-D-glucuronate ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucuronate_3-_ ch/wogonin_1-_)))
  :enzyme Transferase)

(defcatalyse ToCatalyseScutellarein7-O-GlucuronosyltransferaseActivity
  :annotation (goid "GO:0102467")
  :annotation (database "RHEA:28318")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/UDP-alpha-D-glucuronate_3-_ ch/scutellarein)
    (owl-some hasProduct  ch/UDP_3-_ ch/scutellarin ch/hydron))
   (owl-and
    (owl-some hasReactant  ch/UDP_3-_ ch/scutellarin ch/hydron)
    (owl-some hasProduct  ch/UDP-alpha-D-glucuronate_3-_ ch/scutellarein)))
  :enzyme Transferase)


(defcatalyse ToCatalyseQuinateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047205")
  :annotation (database "RHEA:15021")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/trans-feruloyl-CoA_4-_ ch/_-_-quinate)
    (owl-some hasProduct ch/_4-O-feruloyl-D-quinate ch/coenzyme_A_4-_))
   (owl-and
    (owl-some hasReactant ch/_4-O-feruloyl-D-quinate ch/coenzyme_A_4-_)
    (owl-some hasProduct ch/trans-feruloyl-CoA_4-_ ch/_-_-quinate)))
  :enzyme Transferase)

(defcatalyse ToCatalyseChlorogenate-GlucarateO-HydroxycinnamoyltransferaseActivity
  :annotation (goid "GO:0047204")
  :annotation (database "RHEA:23204")
  :reaction
  (owl-or
   (owl-and
    (owl-some hasReactant ch/D-glucarate_2-_	ch/chlorogenate)
    (owl-some hasProduct ch/_-_-quinate	ch/_2-O-caffeoylglucarate_2-_))
   (owl-and
    (owl-some hasReactant	ch/_-_-quinate	ch/_2-O-caffeoylglucarate_2-_)
    (owl-some hasProduct	ch/D-glucarate_2-_	ch/chlorogenate)))
  :enzyme Transferase)





;;======================================
;;======== Asserting relationships======
;;======================================

(as-subclasses
 ToCatalyseHydroxycinnamoyltransferaseActivity
 :disjoint
 (declare-classes
  ToCatalyseO-HydroxycinnamoyltransferaseActivity
  ToCatalysePutrescineN-HydroxycinnamoyltransferaseActivity))


(as-subclasses
 ToCatalyseO-HydroxycinnamoyltransferaseActivity
 :disjoint
 (declare-classes
  ToCatalyseGlucarateO-HydroxycinnamoyltransferaseActivity
  ToCatalyseGalactarateO-HydroxycinnamoyltransferaseActivity
  ToCatalyseTartronateO-HydroxycinnamoyltransferaseActivity
  ToCatalyseShikimateO-HydroxycinnamoyltransferaseActivity
  ToCatalyseGlucarolactoneO-HydroxycinnamoyltransferaseActivity
  ToCatalyseQuinateO-HydroxycinnamoyltransferaseActivity
  ToCatalyseChlorogenate-GlucarateO-HydroxycinnamoyltransferaseActivity
  ))
