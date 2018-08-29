(ns hyper-go.go-test
  (:require [clojure.test :refer :all]
            [tawny owl reasoner fixture]
            [hyper-go.go :refer :all]))


(use-fixtures :once
  (tawny.fixture/ontology-and-reasoner hyper-go.go/hyper-go :elk))

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


(deftest drug-transporter []
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
