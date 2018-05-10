(ns hyper-go.go-test
  (:require [clojure.test :refer :all]
            [tawny owl reasoner fixture]
            [hyper-go.go :refer :all]))


(use-fixtures :once
  (tawny.fixture/ontology-and-reasoner hyper-go.go/hyper-go :elk))

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
    (tawny.reasoner/isubclass? ToTransportChromiumIon ToTransportIon)) ))


(deftest sodium-dependency []
  (is
   (tawny.reasoner/isubclass? ToTransportIon
                              ToTransportOrganicAnionWithSodiumCondition))
  (is
   (tawny.reasoner/isubclass? ToTransportWithChemicalCondition
                              ToTransportOrganicAnionWithSodiumCondition)))

(deftest drug-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransport
                              ToTransportDrugTransmembrane))
  (is
   (tawny.reasoner/isubclass? ToTransport
                              ToTransportDrug))
  (is
   (tawny.reasoner/isubclass? ToTransportTransmembrane
                              ToTransportDrugTransmembrane)))

(deftest biotin-transporter []
  (is
   (not
    ;; This fails at the moment, because we have not imported RO/BFO
    (tawny.reasoner/isubclass?
     ToTransportDrug ToTransportBiotinTransmembrane)))
  (is
   (tawny.reasoner/isubclass?
    ToTransport ToTransportBiotinTransmembrane))
  (is
   (tawny.reasoner/isubclass?
    ToTransportTransmembrane ToTransportBiotinTransmembrane)))

(deftest bicozamycin-transporter []
  (is
   (not
    ;; This fails at the moment, because we have not imported RO/BFO
    (tawny.reasoner/isubclass?
     ToTransportDrug ToTransportBicozamycin)))
  (is
   (tawny.reasoner/isubclass?
    ToTransport ToTransportBicozamycin)))


(deftest driven-transporter []
  (is
   (tawny.reasoner/isubclass? ToTransportCation
                              ToTransportCationDrivenWithATPase))
  (is
   (tawny.reasoner/isubclass? ToTransportDrivenWithATPase
                              ToTransportCationDrivenWithATPase)))
