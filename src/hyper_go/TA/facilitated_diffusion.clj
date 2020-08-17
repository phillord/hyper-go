(ns hyper-go.facilitated_diffusion
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]
            [tawny-go.go :as go]))


(ontology-to-namespace hyper-go.core/HyperGo)


;; Passive transport
(deftransport ToTransportPassiveTransmembrane
  :comment "GO:0022803"
  :across go/plasma_membrane
  :mechanism (owl-or Facilitated_diffusion MembranePotential)
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; uniporter activity
(deftransport ToTransportSubstanceByFacilitatedDiffusionCarrier
  :comment "GO:0015292"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportHexoseByFacilitatedDiffusionCarrier
  :comment "GO:0008516"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/hexose (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportFructoseByFacilitatedDiffusionCarrier
  :comment "GO:0015284"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/fructose (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportGlucoseByFacilitatedDiffusionCarrier
  :comment "GO:0015304"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/glucose (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportGalactoseByFacilitatedDiffusionCarrier
  :comment "GO:0050782"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/galactose (owl-some hasConcentration HighConcentration)))

;; Propanoate has no role antibiotic, but propionic acid does.
(deftransport ToTransportPropionateByFacilitatedDiffusionCarrier
  :comment "GO:0015544"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/propionic_acid (owl-some has-biological-role ch/antimicrobial_drug)
                  (owl-some hasConcentration HighConcentration)))

;; nucleoside transmembrane transporter activity, down a concentration gradient
(deftransport ToTransportNucleosideByChannel
  :comment "GO:0015395"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :cargo (owl-and ch/nucleoside (owl-some hasConcentration HighConcentration)))

;; channel activity
(deftransport ToTransportSoluteByChannel
  :comment "GO:0015267"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-or Channel go/pore_complex)
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


;; =================== Gated channel ==================

;; gated channel activity
(deftransport ToTransportSoluteByGatedChannelInResponseToStimulus
  :comment "GO:0022836"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Stimulus))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; phosphorylation-gated channel activity
(deftransport ToTransportSoluteByPhosphorylationGatedChannel
  :comment "GO:0022828"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Phosphorylation))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; dephosphorylation-gated channel activity
(deftransport ToTransportSoluteByPhosphorylationGatedChannel
  :comment "GO:0022859"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Dephosphorylation))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveIonByChannel
  :comment "GO:0008381"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveIonByChannel
  :comment "GO:0043854"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress)
                (owl-some bound-by ch/cyclic_nucleotide))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCationByChannel
  :comment "GO:0140135"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCalciumByChannel
  :comment "GO:0015275"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCalciumIonByChannelInvolvedInRegulationOfActionPotential
  :comment "GO:0097364"
  :comment "Involved in regulation of action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/regulation_of_action_potential
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCalciumIonByChannelInvolvedInRegulationOfCardiacMuscleCellActionPotential
  :comment "GO:0097365"
  :comment "Involved in regulation of cardiac muscle cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs CardiacMuscleCell
  :involved go/regulation_of_cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitivePotassiumByChannel
  :comment "GO:0098782"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0101013"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and Voltage
                                           (owl-some hasStimulus MechanicalStress))))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


;; ion gated channel activity
(deftransport ToTransportSoluteByIonGatedChannel
  :comment "GO:0022839"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/ion))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; osmolarity-sensing cation channel activity
(deftransport ToTransportCationByOsmolarity-sensingChannel
  :comment "GO:1990760"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and Osmolarity
                                           (owl-some occurs_in go/extracellular_region))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportCationByGatedChannelInResponseToTemperatureStimulus
  :comment "GO:0097603"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus temperature))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportCationByGatedChannelInResponseToTemperatureStimulus
  :comment "GO:0097604"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus temperature))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))


;; voltage-gated channel activity
(deftransport ToTransportSoluteByVoltageGatedChannel
  :comment "GO:0022832"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity
(deftransport ToTransportIonByVoltageGatedChannel
  :comment "GO:0005244"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportIonByVoltageGatedChannelInvolvedInRegulationOfPresynapticMembranePotential
  :comment "GO:0099508"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs go/presynaptic_membrane
  :involved go/regulation_of_presynaptic_membrane_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity involved in regulation of postsynaptic  membrane potential
(deftransport ToTransportIonByVoltageGatedChannelInvolvedInRegulationOfPostsynapticMembranePotential
  :comment "GO:1905030"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs go/postsynaptic_membrane
  :involved go/regulation_of_postsynaptic_membrane_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated cation channel activity
(deftransport ToTransportCationByVoltageGatedChannel
  :comment "GO:0022843"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; voltage-gated proton channel activity
(deftransport ToTransportProtonByVoltageGatedChannel
  :comment "GO:0030171"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0005245"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannelInvolvedInRegulationOfCytosolicCalciumLevels
  :comment "GO:0099511"
  :comment "Involved in regulation of cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :to go/cytosol
  :involved (owl-and go/regulation_of_cytosolic_calcium_ion_concentration
                     (owl-some occurs_in go/cytosol))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of presynaptic cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannelInvolvedInRegulationOfPresynapticCytosolicCalciumLevels
  :comment "GO:0099626"
  :comment "Involved in regulation of presynaptic cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :to go/cytosol
  :involved (owl-and go/regulation_of_presynaptic_cytosolic_calcium_ion_concentration
                       (owl-some occurs_in go/presynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportCalciumIonByVoltageGatedChannelInvolvedInPositiveRegulationOfPresynapticCytosolicCalciumLevels
  :comment "GO:0099635"
  :comment "Involved in positive regulation of presynaptic cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :to go/cytosol
  :involved (owl-and go/positive_regulation_of_presynaptic_cytosolic_calcium_concentration
                     (owl-some occurs_in go/presynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of postsynaptic cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannelInvolvedInRegulationOfPostsynapticCytosolicCalciumLevels
  :comment "GO:1905057"
  :comment "Involved in regulation of postsynaptic cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :to go/cytosol
  :involved (owl-and go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
                     (owl-some occurs_in go/postsynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; High voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByHighVoltageGatedChannel
  :comment "GO:0008331"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus HighVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; Low voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByLowVoltageGatedChannel
  :comment "GO:0008332"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus LowVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; intermediate voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByIntermediateVoltageGatedChannel
  :comment "GO:1990028"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus IntermediateVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; voltage-gated calcium ion channel activity involved in cardiac muscle cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannelInvolvedInCardiacMuscleCellActionPotential
  :comment "GO:0086007"
  :comment "Involved in cardiac muscle cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs CardiacMuscleCell
  :involved go/membrane_depolarization_during_cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; Need Review
;; light-activated voltage-gated calcium ion channel activity
(deftransport ToTransportLightActivatedCalciumIonByVoltageGatedChannel
  :comment "GO:0008086"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and Voltage
                                           (owl-some hasStimulus Light))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))






;; =================== ligand-gated channel activity ===========
;;  Transmembrane channel open/close in response to binding of a ligand
;;  Ligands: are moleclues that acts like keys that fit certain binding pockets or locks on the receptor.
;; A ligand is an ion or molecule that bi
;; ===============================================
(deftransport ToTransportSoluteByLigandGatedChannel
  :comment "GO:0022834"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus 
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; transmitter-gated channel activity
;; transfer of a solute by a channel that opens when a specific neurotransmitter has been bound by the channel 
(deftransport ToTransportSoluteByTransmitterGatedChannel
  :comment "GO:0022835"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; histamine-gated chloride channel activity
;; transfer of a chloride ion by a channel that opens when histamine has been bound by the channel 
(deftransport ToTransportChlorideByHistamineGatedChannel
  :comment "GO:0019182"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/histamine
                                           (owl-some has-biological-role ch/neurotransmitter)
                                               (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; transmitter-gated ion channel activity
;; transfer of a ion by a channel that opens when a specific neurotransmitter has been bound by the channel 
(deftransport ToTransportIonByTransmitterGatedChannel
  :comment "GO:0022824"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some has-biological-role ch/neurotransmitter)
                                            (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; Any transmitter-gated ion channel activity that is involved in regulation of postsynaptic membrane potentia
(deftransport ToTransportIonByTransmitterGatedChannelInvolvedInRegulationOfPostsynapticMembranePotential
  :comment "GO:1904315"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs go/postsynaptic_membrane
  :involved go/regulation_of_postsynaptic_membrane_potential
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;;  enables the transmembrane transfer of a cation by a channel that opens upon binding acetylcholine
(deftransport ToTransportCationByAcetylcholineGatedChannel
  :comment "GO:0022848"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/acetylcholine
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; transfer of a cation by a channel that opens when serotonin has been bound by the channel 
(deftransport ToTransportCationBySerotoninGatedChannel
  :comment "GO:0022850"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/serotonin
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; transfer of a chloride by a channel that opens when glycine has been bound by the channel 
(deftransport ToTransportChlorideByGlycineGatedChannel
  :comment "GO:0022852"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/glycine
                                           (owl-some has-biological-role ch/neurotransmitter)
                                               (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; transfer of a chloride by a channel that opens when GABA has been bound by the channel 
(deftransport ToTransportChlorideByGABAGatedChannel
  :comment "GO:0022851"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/gamma-aminobutyric_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByGlutamateGatedChannel
  :comment "GO:0004970"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                            (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByGlutamateAMPAGatedChannel
  :comment "GO:0004971"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                            (owl-some bound-by go/AMPA_glutamate_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByGlutamateNMDAGatedChannel
  :comment "GO:0004972"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/NMDA_selective_glutamate_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByGlutamateKainateGatedChannel
  :comment "GO:0004977"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/kainate_selective_glutamate_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByATPGatedChannel
  :comment "GO:0035381"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ATP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; intracellularly ATP-gated ion channel activity
(deftransport ToTransportIonByintracellularlyATPGatedChannel
  :comment "GO:0099142"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ATP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; go/intracellularly ATP-gated chloride channel activity
(deftransport ToTransportChlorideByIntracellularlyATPGatedChannel
  :comment "GO:0005260"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ATP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; go/intracellularly ATP-gated chloride channel activity
(deftransport ToTransportCationByExtracellularlyATPGatedChannel
  :comment "GO:0004931"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ATP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration)))

;; ligand-gated ion channel activity
(deftransport ToTransportIonByLigandGatedChannel
  :comment "GO:0015276"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated ion channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportIonByLigandGatedChannelInvolvedInRegulationOfPresynapticMembranePotential
  :comment "GO:0099507"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs go/presynaptic_membrane
  :involved go/regulation_of_presynaptic_membrane_potential
  :via (owl-and Channel (owl-some hasStimulus
                                   (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated anion channel activity
(deftransport ToTransportAnionByLigandGatedChannel
  :comment "GO:0099095"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))


;; cyclic nucleotide-gated ion channel activity
(deftransport ToTransportIonByCyclicNucleotideGatedChannel
  :comment "GO:0043855"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/cyclic_nucleotide
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))


;; extracellular ligand-gated ion channel activity
(deftransport ToTransportIonByExtracellularLigandGatedChannel
  :comment "GO:0005230"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                                   (owl-some bound-by go/plasma_membrane_receptor_complex)
                                                   (owl-some occurs_in go/extracellular_region))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellular ligand-gated ion channel activity
(deftransport ToTransportIonByExtracellularLigandGatedChannel
  :comment "GO:0005231"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))


;;  Inhibitory ligands, such as GABA or glycine, open chloride-selective channels. 
(deftransport ToTransportIonByInhibitoryExtracellularLigandGatedChannel
  :comment "GO:0005237"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/gamma-aminobutyric_acid ch/glycine ch/chloride)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellular glycine-gated ion channel activity
(deftransport ToTransportIonByExtracellularGlycineGatedChannel
  :comment "GO:0016933"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/glycine (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glycine-gated chloride channel activity
(deftransport ToTransportChlorideByExtracellularGlycineGatedChannel
  :comment "GO:00016934"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/glycine (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; extracellular phenylacetaldehyde-gated ion channel activity
(deftransport ToTransportIonByExtracellularPhenylacetaldehydeGatedChannel
  :comment "GO:0036082"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/phenylacetaldehyde
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellular ammonia-gated ion channel activity
(deftransport ToTransportIonByExtracellularAmmoniaGatedChannel
  :comment "GO:0036081"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ammonia
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; intracellular ligand-gated ion channel activity
(deftransport ToTransportIonByIntracellularLigandGatedChannel
  :comment "GO:0005217"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glutamate-gated ion channel activity
(deftransport ToTransportIonByExtracellularGlutamateGatedChannel
  :comment "GO:0005234"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated cation channel activity
(deftransport ToTransportCationByLigandGatedChannel
  :comment "GO:0099094"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; glycine betaine-activated nonselective monovalent cation channel activity
(deftransport ToTransportMonovalentCationByGlycineBetaineGatedChannel
  :comment "GO:0090686"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/glycine_betaine
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/monovalent_inorganic_cation (owl-some hasConcentration HighConcentration)))

;; ligand-gated calcium channel activity
(deftransport ToTransportCalciumIonByLigandGatedChannel
  :comment "GO:0099604"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; glutamate-gated calcium ion channel activiy
(deftransport ToTransportCalciumIonByGlutamateGatedChannel
  :comment "GO:0022849"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid (owl-some has-biological-role ch/neurotransmitter)
                                  (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glutamate-gated chloride channel activity
(deftransport ToTransportChlorideByExtracellularlyGlutamateGatedChannel
  :comment "GO:0008068"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid
                                           (owl-some has-biological-role ch/neurotransmitter)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/extracellular_region)))
                 (owl-some contributes-to go/membrane_hyperpolarization))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; intracellular phosphatidylinositol-3,5-bisphosphate-sensitive cation
(deftransport ToTransportCationByIntracellularPhosphatidylinositol-3-5-bisphosphateChannel
  :comment "GO:0097682"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_1-phosphatidyl-1D-myo-inositol_3_4-bisphosphate_5-_
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))


;; ligand-gated sodium channel activity
(deftransport ToTransportSodiumIonByLigandGatedChannel
  :comment "GO:0015280"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSodiumIonByProtonGatedChannel
  :comment "GO:0044736"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/proton
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))



;; channel-forming ionophore activity
(deftransport ToTransportSoluteByPoreChannel
  :comment "GO:0022886"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via go/pore_complex
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; narrow pore channel activity
(deftransport ToTransportSoluteByNarrowPoreChannel
  :comment "GO:0022842"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize NarrowPore))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByNarrowPoreChannel
  :comment "GO:0022831"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and NarrowPore
                                                   (owl-some hasStimulus Stimulus))))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumByNarrowPoreChannel
  :comment "GO:0022841"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize NarrowPore))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; wide pore channel activity
(deftransport ToTransportSoluteByWidePoreChannel
  :comment "GO:0022829"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize WidePore))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; gap junction channel activity
(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0005243"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByConnexonGapJunctionWidePoreChannel
  :comment "GO:0055077"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction hemi-channel)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


;; gap junction channel activity involved in cell communication by electrical coupling
(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:1903763"
  :comment "involved in cell communication by electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/cell_communication_by_electrical_coupling
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086075"
  :comment "involved in cardiac conduction electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/cell_communication_by_electrical_coupling_involved_in_cardiac_conduction
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086076"
  :comment "involved in atrial cardiac muscle cell to AV node cell electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/atrial_cardiac_muscle_cell_to_AV_node_cell_communication_by_electrical_coupling
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086077"
  :comment "involved in AV node cell to bundle of His cell electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/AV_node_cell_to_bundle_of_His_cell_communication_by_electrical_coupling
  :via (owl-and  go/pore_complex (owl-some hasPoreSize
                                           (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086078"
  :comment "involved in bundle of His cell-Purkinje myocyte electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/bundle_of_His_cell_to_Purkinje_myocyte_communication_by_electrical_coupling
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086079"
  :comment "involved in Purkinje myocyte-ventricular cardiac muscle cell electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/Purkinje_myocyte_to_ventricular_cardiac_muscle_cell_communication_by_electrical_coupling
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0086020"
  :comment "involved in SA node cell-atrial cardiac muscle cell electrical coupling"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/cell
  :to go/cell
  :involved go/SA_node_cell_to_atrial_cardiac_muscle_cell_communication_by_electrical_coupling
  :via (owl-and  go/pore_complex (owl-some hasPoreSize
                                           (owl-and WidePore Gap-junction)))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


;; Proin Activity
;; Porins transport substances in and out of bacteria, mitochondria and chloroplasts.
(deftransport ToTransportSoluteByPorinChannel
  :comment "GO:0015288"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/chemical_entity (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; oligosaccharide transporting porin Activity
(deftransport ToTransportOligosaccharideByPorinChannel
  :comment "GO:0015478"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/oligosaccharide (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; autotransporter activity
(deftransport ToTransportPassengerProteinByPorinChannel
  :comment "GO:0015474"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/periplasmic_space
  :to go/extracellular_region
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/protein (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; hemaglutinin autotransporter activity
;; Known as glycoprotein
(deftransport ToTransportHemaglutininByPorinChannel
  :comment "GO:0015476"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/periplasmic_space
  :to go/extracellular_region
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/glycoprotein (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportAdhesinByPorinChannel
  :comment "GO:0015475"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/periplasmic_space
  :to go/extracellular_region
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and Adhesin (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))


;; toxin export channel Activity
(deftransport ToTransportToxinExportByPorinChannel
  :comment "GO:0000269"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :to go/extracellular_region
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/toxin (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; maltose transporting porin activity
(deftransport ToTransportMaltoseByPorinChannel
  :comment "GO:0015481"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/maltose (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; nucleoside-specific channel porin activity
(deftransport ToTransportNucleosideByPorinChannel
  :comment "GO:0015471"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/nucleoside (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; long-chain fatty acid transporting porin activity
(deftransport ToTransportLongChainFattyAcidByPorinChannel
  :comment "Go:0015483"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and go/pore_complex (owl-some hasPoreSize
                                          (owl-and WidePore Porins)))
  :cargo (owl-and ch/long-chain_fatty_acid (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))


;; calcium-release channel activity
(deftransport ToTransportCalciumIonByChannel
  :comment "GO:0015278"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/intracellular
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/molecule ch/ion)
                                  (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; calcium-induced calcium release activity
(deftransport ToTransportCalciumIonByCalcium-inducedChannel
  :comment "GO:0048763"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/intracellular
  :to go/cytosol
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; calcium-induced calcium release activity involved in regulation of postsynaptic cytosolic calcium ion concentration
(deftransport ToTransportCalciumIonByCalcium-inducedChannelInvolvedInRegulationOfPostsynapticCytosolicCalciumIonConcentration
  :comment "GO:1905058"
  :comment "Involved in regulation of postsynaptic cytosolic calcium ion concentration"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/intracellular
  :to go/cytosol
  :involved (owl-and go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
                     (owl-some occurs_in go/postsynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportCalciumIonByCalcium-inducedChannelInvolvedInRegulationOfPresynapticCytosolicCalciumIonConcentration
  :comment "GO:1905054"
  :comment "Involved in regulation of presynaptic cytosolic calcium ion concentration"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :from go/intracellular
  :to go/cytosol
  :involved go/regulation_of_presynaptic_cytosolic_calcium_ion_concentration
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; NAADP-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByNAADP-sensitiveChannel
  :comment "GO:0072345"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/nicotinic_acid-adenine_dinucleotide_phosphate
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; calcium-release channel activity
(deftransport ToTransportCalciumIonBycADPR-sensitiveChannel
  :comment "GO:0072346"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/cyclic_ADP-ribose
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; ryanodine-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByRyanodineChannel
  :comment "GO:0005219"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ryanodine
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; ryanodine-sensitive calcium-release channel activity involved in regulation of postsynaptic cytosolic calcium levels
(deftransport ToTransportCalciumIonByRyanodineSensitiveChannelInvolvedInRegulationOfPostsynapticCytosolicCalciumLevels
  :comment "GO:0098697"
  :comment "Involved in regulation of postsynaptic cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved (owl-and go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
                     (owl-some occurs_in go/postsynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/ryanodine
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; inositol 1,4,5-trisphosphate-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByInositolTrisphosphateChannel
  :comment "GO:0005220"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_1D-myo-inositol_1_4_5-trisphosphate
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; inositol 1,4,5-trisphosphate-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByInositolTrisphosphateChannelInvolvedInRegulationOfPostsynapticCytosolicCalciumLevels
  :comment "GO:0098695"
  :comment "Involved in regulation of postsynaptic cytosolic calcium levels"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved (owl-and go/regulation_of_postsynaptic_cytosolic_calcium_ion_concentration
                     (owl-some occurs_in go/postsynaptic_cytosol))
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_1D-myo-inositol_1_4_5-trisphosphate
                                           (owl-some bound-by go/plasma_membrane_receptor_complex))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; intracellular cyclic nucleotide activated cation channel activity
(deftransport ToTransportCationByIntracellularCyclicNucleotideChannel
  :comment "GO:0005221"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/cyclic_nucleotide
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; intracellular cGMP-activated cation channel activity
(deftransport ToTransportCationByIntracellular-cGMPChannel
  :comment "GO:0005223"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_7-deaza-cGMP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; intracellular cAMP-activated cation channel activity
(deftransport ToTransportCationByIntracellular-cAMPChannel
  :comment "GO:0005222"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_7-deaza-cGMP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; intracellular cAMP-activated cation channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportCationByIntracellular-cAMPChannelInvolvedInRegulationOfPresynapticMembranePotential
  :comment "GO:0140232"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved (owl-and go/regulation_of_presynaptic_membrane_potential
                     (owl-some occurs_in go/presynaptic_membrane))
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_7-deaza-cGMP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; go/intracellular cAMP-activated cation channel activity involved in regulation of postsynaptic membrane potential
(deftransport ToTransportCationByIntracellular-cAMPChannelInvolvedInRegulationOfPostsynapticMembranePotential
  :comment "GO:0140233"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved (owl-and go/regulation_of_postsynaptic_membrane_potential
                     (owl-some occurs_in go/postsynaptic_membrane))
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/_7-deaza-cGMP
                                           (owl-some bound-by go/plasma_membrane_receptor_complex)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; voltage-gated anion channel activity
(deftransport ToTransportAnionByVoltageGatedChannel
  :comment "GO:0008308"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; voltage-gated chloride channel activity
(deftransport ToTransportChlorideByVoltageGatedChannel
  :comment "GO:0005247"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; organellar voltage-gated chloride channel activity
(deftransport ToTransportChlorideByVoltageGatedChannel
  :comment "GO:0015274"
  :across go/organelle_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0005248"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated potassium channel activity
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0005249"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; inward rectifier potassium channel activity
(deftransport ToTransportPotassiumIonByInwardly-rectifyingVoltageGatedChannel
  :comment "GO:0005249"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  ;;:driven  
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))


;; voltage-gated potassium channel activity involved in cardiac muscle cell action potential repolarization
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086008"
  :comment "involved in cardiac muscle cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved (owl-and go/membrane_repolarization_during_cardiac_muscle_cell_action_potential
                     (owl-some occurs_in CardiacMuscleCell))
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated potassium channel activity involved in ventricular cardiac muscle cell action potential repolarization
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:1902282"
  :comment "Involved in ventricular cardiac muscle cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_ventricular_cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086086"
  :comment "involved in AV node cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_AV_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086087"
  :comment "involved in bundle of His cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_bundle_of_His_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086088"
  :comment "involved in cardiac muscle cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_Purkinje_myocyte_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated potassium channel activity involved in atrial cardiac muscle cell action potential repolarization
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086089"
  :comment "Involved in atrial cardiac muscle cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_atrial_cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086090"
  :comment "Involved in SA node cell action potential repolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_repolarization_during_SA_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086041"
  :comment "Involved in in SA node cell action potential depolarization"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_SA_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in cardiac muscle cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086006"
  :comment "Involved in cardiac muscle cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in SA node cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086063"
  :comment "Involved in SA node cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_SA_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


;; voltage-gated sodium channel activity involved in Purkinje myocyte action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086062"
  :comment "Involved in Purkinje myocyte action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_Purkinje_myocyte_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


;; voltage-gated sodium channel activity involved in bundle of His cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086061"
  :comment "Involved in bundle of His cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_bundle_of_His_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in AV node cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086060"
  :comment "Involved in AV node cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_AV_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in AV node cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086056"
  :comment "Involved in AV cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_AV_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in bundle of His cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086057"
  :comment "Involved in bundle of His cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_bundle_of_His_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in Purkinje myocyte cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086058"
  :comment "Involved in Purkinje myocyte cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_Purkinje_myocyte_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved SA node cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086059"
  :comment "Involved in SA node cell action potential"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :involved go/membrane_depolarization_during_SA_node_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; propanediol channel activity
(deftransport ToTransportPropanediolByChannel
  :comment "GO:0015255"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/propanediol (owl-some hasConcentration HighConcentration)))

;; glycerol channel activity
(deftransport ToTransportGlycerolByChannel
  :comment "GO:0015254"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/glycerol (owl-some hasConcentration HighConcentration)))


;; ;; substrate-specific channel activity
;; (deftransport ToTransportsubstrate-specificByChannel
;;   :comment "GO:0022838"
;;   :across go/plasma_membrane
;;   :mechanism Facilitated_diffusion
;;   :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; methylammonium channel activity
(deftransport ToTransportAmmoniumIonByChannel
  :comment "GO:0015264"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/methylammonium (owl-some hasConcentration HighConcentration)))

;; ammonium channel activity
(deftransport ToTransportAmmoniumIonByChannel
  :comment "GO:0015251"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/ammonium_ion_derivative
                  (owl-some hasConcentration HighConcentration)))

;; water channel activity
(deftransport ToTransportWaterByChannel
  :comment "GO:0015250"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/water (owl-some hasConcentration HighConcentration)))

;; ion channel activity
(deftransport ToTransportIonByChannel
  :comment "GO:0005216"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; light-activated ion channel activity
(deftransport ToTransportIonByLightActivatedChannel
  :comment "GO:0010461"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Light))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; anion channel activity
(deftransport ToTransportAnionByChannel
  :comment "GO:0005253"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; volume-sensitive anion channel activity
(deftransport ToTransportAnionByVolume-sensitiveChannel
  :comment "GO:0005225"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus volume-sensitive))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; volume-sensitive chloride channel activity
(deftransport ToTransportChlorideByVolume-sensitiveChannel
  :comment "GO:0072320"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus volume-sensitive))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; chloride channel activity
(deftransport ToTransportChlorideByChannel
  :comment "GO:0005254"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; pH-gated chloride channel activity
(deftransport ToTransportChlorideBypHGatedChannel
  :comment "GO:0061797"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some opens-in go/response_to_pH))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; go/intracellular chloride channel activity
(deftransport ToTransportChlorideIntracellularByChannel
  :comment "GO:0061778"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :occurs go/intracellular
  :via Channel
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; fluoride channel activity
(deftransport ToTransportFluorideByChannel
  :comment "GO:0062054"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/fluoride (owl-some hasConcentration HighConcentration)))


;; cation channel activity
(deftransport ToTransportCationByChannel
  :comment "GO:0005261"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; calcium activated cation channel activity
(deftransport ToTransportCationByChannelCalciumActivated
  :comment "GO:0005227"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; calcium-activated potassium channel activity
;; ref: http://www.ebi.ac.uk/interpro/entry/IPR015449
(deftransport ToTransportPotassiumIonByChannelCalciumActivated
  :comment "GO:0015269"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; small conductance calcium-activated potassium channel activity
;; ref: http://www.ebi.ac.uk/interpro/entry/IPR015449
(deftransport ToTransportPotassiumIonBySmall-conductanceChannelCalciumActivated
  :comment "GO:0016286"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)))
                (owl-some hasChannelType small-conductance))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))


;; Intermediate conductance calcium-activated potassium channel activity
;; ref: http://www.ebi.ac.uk/interpro/entry/IPR015449
(deftransport ToTransportPotassiumIonByIntermediate-conductanceChannelCalciumActivated
  :comment "GO:0022894"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)))
                (owl-some hasChannelType intermediate-conductance))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; large conductance calcium-activated potassium channel activity
;; ref: http://www.ebi.ac.uk/interpro/entry/IPR015449
(deftransport ToTransportPotassiumIonByLarge-conductanceChannelCalciumActivated
  :comment "GO:0060072"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion
                                           (owl-some hasConcentration HighConcentration)))
                (owl-some hasChannelType large-conductance))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; chloride-activated potassium channel activity
(deftransport ToTransportPotassiumIonByChannelChlorideActivated
  :comment "GO:0070089"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/chloride (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; potassium channel activity
(deftransport ToTransportPotassiumIonByChannel
  :comment "GO:0005267"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; go/intracellular sodium activated potassium channel activity
(deftransport ToTransportPotassiumIonByIntracellularSodium-activatedChannel
  :comment "GO:0005228"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/ion ch/sodium_1+_)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; go/intracellular calcium activated potassium channel activity
(deftransport ToTransportChlorideByIntracellularCalcium-activatedChannel
  :comment "GO:0005229"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and (owl-or ch/ion ch/calcium_ion)
                                           (owl-some occurs_in go/intracellular))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))




;; proton channel activity
(deftransport ToTransportProtonByChannel
  :comment "GO:0015252"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

;; sodium channel activity
(deftransport ToTransportSodiumByChannel
  :comment "GO:0005272"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; calcium channel activity
(deftransport ToTransportCalciumIonByChannel
  :comment "GO:0005262"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; iron ion channel activity
(deftransport ToTransportIronIonByChannel
  :comment "GO:0097689"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/iron_cation (owl-some hasConcentration HighConcentration)))

;; urea channel activity
(deftransport ToTransportUreaByChannel
  :comment "GO:0015265"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/urea (owl-some hasConcentration HighConcentration)))

;; store-operated calcium channel activity
(deftransport ToTransportCalciumIonByChannelInResponseToEmptyingCalciumStores.
  :comment "GO:0015279"
  :across go/plasma_membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus EmptyingOfIntracellularCalciumStores))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))
