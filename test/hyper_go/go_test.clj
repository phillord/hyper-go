(ns hyper-go.go-test
  (:require [clojure.test :refer :all]
            [tawny owl reasoner fixture])
  (:use
            [hyper-go.core]
            [hyper-go.go]
            [hyper-go.ATPase_coupled]
            [hyper-go.active_transporter]))



(use-fixtures :once
  (tawny.fixture/ontology-and-reasoner hyper-go.core/hyper-go :elk))

(deftest transmembrane-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportTransmembrane))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTransmembrane ToTransport))))

(deftest cation-chloride-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportCation))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCation ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportAnion ToTransportChloride))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportChloride ToTransportAnion))))

(deftest chromium-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportIon ToTransportChromiumIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportChromiumIon ToTransportIon))))


(deftest drug-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportVitaminB6))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportDrug))))


(deftest vitamin-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportVitamin ToTransportVitaminB6))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportVitamin))))


(deftest drug-transporters []
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportThiamine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportThiamine ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportAdenosineTriphosphate))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAdenosineTriphosphate ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportAcadesine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAcadesine ToTransportDrug)))
  ;; (is
  ;;  (tawny.reasoner/isubclass? ToTransportDrug ToTransportD-glucarate))
  ;; (is
  ;;  (not
  ;;   (tawny.reasoner/isubclass? ToTransportD-glucarate ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportFolicAcid))
  (is
   (tawny.reasoner/isubclass? ToTransportVitamin ToTransportFolicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportFolicAcid ToTransportDrug)))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportFolicAcid ToTransportVitamin)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportCreatine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCreatine ToTransportDrug)))
    (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportR-Carnitine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportR-Carnitine ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportR-PantothenicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportR-PantothenicAcid ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportMethotrexate))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMethotrexate ToTransportDrug)))
  (is
   (tawny.reasoner/isubclass? ToTransportDrug ToTransportD-serine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportD-serine ToTransportDrug))))


(deftest fatty_acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportFattyAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportFattyAcid ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportFattyAcid ToTransportLongChainFattyAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportLongChainFattyAcid ToTransportFattyAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportFattyAcid ToTransportShortChainFattyAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportShortChainFattyAcid ToTransportFattyAcid))))

(deftest amino_acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportAminoAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAminoAcid ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportAminoAcid ToTransportSulfurAminoAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportSulfurAminoAcid ToTransportAminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportAminoAcid ToTransportAromaticAminoAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportAminoAcid))))

(deftest aromatic_amino_acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportAromaticAminoAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-phenylalanine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-phenylalanine ToTransportAromaticAminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-tyrosine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-tyrosine ToTransportAromaticAminoAcid)))
  (is ;; This fail, for no reason !!!
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-histidine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-histidine ToTransportAromaticAminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-tryptophan))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-tryptophan ToTransportAromaticAminoAcid)))
   (is
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-tryptophanWithHighAffinity))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-tryptophanWithHighAffinity ToTransportAromaticAminoAcid)))
   (is
   (tawny.reasoner/isubclass? ToTransportAromaticAminoAcid ToTransportL-tryptophanWithLowAffinity))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-tryptophanWithLowAffinity ToTransportAromaticAminoAcid))))

(deftest nucleotide-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportNucleotide ToTransportPurineNucleotide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPurineNucleotide ToTransportNucleotide)))
  (is
   (tawny.reasoner/isubclass? ToTransportNucleotide ToTransportPyrimidineNucleotide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyrimidineNucleotide ToTransportNucleotide)))
  (is
   (tawny.reasoner/isubclass? ToTransportNucleotide ToTransportNucleotideSulfate))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportNucleotideSulfate ToTransportNucleotide))))

(deftest Organic_acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportOrganicAcid ToTransportCarboxylicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransportOrganicAcid))))


(deftest Carboxylic_Acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportCarboxylicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransportDicarboxylicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportDicarboxylicAcid ToTransportCarboxylicAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransportTricarboxylicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTricarboxylicAcid ToTransportCarboxylicAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransportMonocarboxylicAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMonocarboxylicAcid ToTransportCarboxylicAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarboxylicAcid ToTransportAminoAcid))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAminoAcid ToTransportCarboxylicAcid))))

(deftest Nucleobase-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport ToTransportNucleobase))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportNucleobase ToTransport)))
  (is
   (tawny.reasoner/isubclass? ToTransportNucleobase ToTransportPurineNucleobase))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPurineNucleobase ToTransportNucleobase)))
  (is
   (tawny.reasoner/isubclass? ToTransportNucleobase ToTransportPyrimidineNucleobase))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyrimidineNucleobase ToTransportNucleobase))))

(deftest purin-nucleotide-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportPurineNucleotide ToTransportPurineRibonucleotide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPurineRibonucleotide ToTransportPurineNucleotide))))


(deftest nucleotide_sugar-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportNucleotideSugar ToTransportPurineNucleotideSugar))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPurineNucleotideSugar ToTransportNucleotideSugar)))
  (is
   (tawny.reasoner/isubclass? ToTransportNucleotideSugar ToTransportPyrimidineNucleotideSugar))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyrimidineNucleotideSugar ToTransportNucleotideSugar))))

(deftest anion-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportAnion ToTransportOrganicAnion))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportOrganicAnion ToTransportAnion)))
  (is
   (tawny.reasoner/isubclass? ToTransportAnion ToTransportInorganicAnion))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportInorganicAnion ToTransportAnion))))






(deftest l-alpha_amino_acid-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-alanine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-alanine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-asparagine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-asparagine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-cystine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-cystine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-glutamine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-glutamine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-lysine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-lysine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-leucine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-leucine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-methionine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-methionine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-histidine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-histidine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-isoleucine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-isoleucine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportL-phenylalanine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportL-phenylalanine ToTransportL-AminoAcid)))
  (is
   (tawny.reasoner/isubclass? ToTransportL-AminoAcid ToTransportGlycine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportGlycine ToTransportL-AminoAcid))))

(deftest methylammonium-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportAmmoniumIon ToTransportMethylammonium))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMethylammonium ToTransportAmmoniumIon))))


(deftest vitaminB6-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportPyridoxal))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyridoxal ToTransportVitaminB6)))
  (is
   (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportPyridoxamine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyridoxamine ToTransportVitaminB6)))
  (is
   (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportPyridoxine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyridoxine ToTransportVitaminB6)))
  (is
   (tawny.reasoner/isubclass? ToTransportVitaminB6 ToTransportPyridoxalPhosphate))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPyridoxalPhosphate ToTransportVitaminB6))))


(deftest quaternary_ammonium_compound-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportAminoAcidBetaine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAminoAcidBetaine ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportN-methylnicotinat))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportN-methylnicotinat ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportAcylCarnitine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportAcylCarnitine ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransport4-TrimethylammonioButanoate))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransport4-TrimethylammonioButanoate ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportCarnitine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCarnitine ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportR-Carnitine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportR-Carnitine ToTransportQuaternaryAmmoniumCompound)))
  (is
   (tawny.reasoner/isubclass? ToTransportQuaternaryAmmoniumCompound ToTransportBetaineTransportingDrivenWithATPase))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportBetaineTransportingDrivenWithATPase ToTransportQuaternaryAmmoniumCompound))))


(deftest amine-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportAmine ToTransportEthanolamine))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportEthanolamine ToTransportAmine))))


(deftest alcohol-sanity []
  (is
   (tawny.reasoner/isubclass? ToTransportAlchohol ToTransportEthanolamine)))


(deftest inorganic_cation-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportInorganicCation ToTransportDivalentInorganicCation))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportDivalentInorganicCation ToTransportInorganicCation)))
  (is
   (tawny.reasoner/isubclass? ToTransportInorganicCation ToTransportMonovalentInorganicCation))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMonovalentInorganicCation ToTransportInorganicCation)))
  (is
   (tawny.reasoner/isubclass? ToTransportInorganicCation ToTransportTrivalentInorganicCation))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTrivalentInorganicCation ToTransportInorganicCation))))


(deftest carbohydrate-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportCarbohydrate ToTransportMonosaccharide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMonosaccharide ToTransportCarbohydrate)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarbohydrate ToTransportOligosaccharide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportOligosaccharide ToTransportCarbohydrate)))
  (is
   (tawny.reasoner/isubclass? ToTransportCarbohydrate ToTransportPolysaccharide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportPolysaccharide ToTransportCarbohydrate))))


(deftest peptide-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportPeptide ToTransportOligopeptide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportOligopeptide ToTransportPeptide)))
  (is
   (tawny.reasoner/isubclass? ToTransportOligopeptide ToTransportDipeptide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportDipeptide ToTransportOligopeptide)))
  (is
   (tawny.reasoner/isubclass? ToTransportOligopeptide ToTransportTetrapeptide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTetrapeptide ToTransportOligopeptide)))
  (is
   (tawny.reasoner/isubclass? ToTransportOligopeptide ToTransportTripeptide))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTripeptide ToTransportOligopeptide))))

(deftest Metal_ion-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportMetalIon ToTransportTransitionMetalIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportVanadiumIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportVanadiumIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportIronIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportIronIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportManganeseIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportManganeseIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportManganeseIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportManganeseIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportZincIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportZincIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportMolybdenumIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMolybdenumIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportSilverIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportSilverIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportCadmiumIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCadmiumIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportNickelCation))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportNickelCation ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportCobaltIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCobaltIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportMercuryIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportMercuryIon ToTransportTransitionMetalIon)))
  (is
   (tawny.reasoner/isubclass? ToTransportTransitionMetalIon ToTransportCopperIon))
  (is
   (not
    (tawny.reasoner/isubclass? ToTransportCopperIon ToTransportTransitionMetalIon))))

