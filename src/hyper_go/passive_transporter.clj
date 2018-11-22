(ns hyper-go.passive_transporter
  (:use [tawny.pattern])
  (:require [tawny.owl  :refer :all]
            [tawny-chebi.chebi :as ch]
            [hyper-go.core :refer :all]))

(ontology-to-namespace hyper-go.core/hyper-go)




;; Passive transport

(deftransport ToTransportPassiveTransmembrane
  :comment "GO:0022803"
  :across Membrane
  :mechanism (owl-or Diffusion Facilitated_diffusion)
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; channel activity
(deftransport ToTransportSoluteByChannel
  :comment "GO:0015267"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-or Channel PoreComplex)
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; gated channel activity
(deftransport ToTransportSoluteByGatedChannel
  :comment "GO:0022836"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Stimulus))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; phosphorylation-gated channel activity
(deftransport ToTransportSoluteByPhosphorylationGatedChannel
  :comment "GO:0022828"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Phosphorylation))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; dephosphorylation-gated channel activity
(deftransport ToTransportSoluteByPhosphorylationGatedChannel
  :comment "GO:0022859"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Dephosphorylation))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


;; ion gated channel activity
(deftransport ToTransportSoluteByIonGatedChannel
  :comment "GO:0022839"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/ion))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))


;; voltage-gated channel activity
(deftransport ToTransportSoluteByVoltageGatedChannel
  :comment "GO:0022832"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity
(deftransport ToTransportIonByVoltageGatedChannel
  :comment "GO:0005244"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportIonByVoltageGatedChannel
  :comment "GO:0099508"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :involved presynaptic_membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated ion channel activity involved in regulation of postsynaptic  membrane potential
(deftransport ToTransportIonByVoltageGatedChannel
  :comment "GO:1905030"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :involved postsynaptic_membrane
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated cation channel activity
(deftransport ToTransportCationByVoltageGatedChannel
  :comment "GO:0022843"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; voltage-gated proton channel activity
(deftransport ToTransportProtonByVoltageGatedChannel
  :comment "GO:0030171"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0005245"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0099511"
  :comment "Involved in regulation of cytosolic calcium levels"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved CalciumIonHomeostasis
  :to Cytosol
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of presynaptic cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0099626"
  :comment "Involved in regulation of presynaptic cytosolic calcium levels"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved CalciumIonHomeostasis
  :occurs PresynapticCytosol
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in regulation of postsynaptic cytosolic calcium levels
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:1905057"
  :comment "Involved in regulation of postsynaptic cytosolic calcium levels"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved CalciumIonHomeostasis
  :occurs PostsynapticCytosol
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; High voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByHighVoltageGatedChannel
  :comment "GO:0008331"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus HighVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; Low voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByLowVoltageGatedChannel
  :comment "GO:0008332"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus LowVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; intermediate voltage-gated calcium ion channel activity
(deftransport ToTransportCalciumIonByIntermediateVoltageGatedChannel
  :comment "GO:1990028"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus IntermediateVoltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; voltage-gated calcium ion channel activity involved in cardiac muscle cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086007"
  :comment "Involved in cardiac muscle cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :involved cardiac_muscle_cell_action_potential
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; Need Review
;; light-activated voltage-gated calcium ion channel activity
(deftransport ToTransportLightActivatedCalciumIonByVoltageGatedChannel
  :comment "GO:0008086"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage)
                (owl-some hasStimulus Light))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated channel activity: Transmembrane channel open/close in response to binding of a ligand
;; Ligands: are moleclues that acts like keys that fit certain binding pockets or locks on the receptor.
(deftransport ToTransportSoluteByLigandGatedChannel
  :comment "GO:0022834"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; transmitter-gated channel activity
;; transfer of a solute by a channel that opens when a specific neurotransmitter has been bound by the channel 
(deftransport ToTransportSoluteByTransmitterGatedChannel
  :comment "GO:0022835"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/chemical_entity
                                           (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; histamine-gated chloride channel activity
;; transfer of a chloride ion by a channel that opens when histamine has been bound by the channel 
(deftransport ToTransportChlorideByHistamineGatedChannel
  :comment "GO:0019182"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/histamine (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; transmitter-gated ion channel activity
;; transfer of a ion by a channel that opens when a specific neurotransmitter has been bound by the channel 
(deftransport ToTransportIonByTransmitterGatedChannel
  :comment "GO:0022824"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/chemical_entity (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; Any transmitter-gated ion channel activity that is involved in regulation of postsynaptic membrane potentia
(deftransport ToTransportIonByTransmitterGatedChannel
  :comment "GO:1904315"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved postsynaptic_membrane
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/chemical_entity (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))


;;  enables the transmembrane transfer of a cation by a channel that opens upon binding acetylcholine
(deftransport ToTransportCationByAcetylcholineGatedChannel
  :comment "GO:0022848"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/acetylcholine (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; transfer of a cation by a channel that opens when serotonin has been bound by the channel 
(deftransport ToTransportCationBySerotoninGatedChannel
  :comment "GO:0022850"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                 (owl-and ch/serotonin (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; transfer of a chloride by a channel that opens when glycine has been bound by the channel 
(deftransport ToTransportChlorideByGlycineGatedChannel
  :comment "GO:0022852"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/glycine (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; transfer of a chloride by a channel that opens when GABA has been bound by the channel 
(deftransport ToTransportChlorideByGABAGatedChannel
  :comment "GO:0022851"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/gamma-aminobutyric_acid (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByGlutamateGatedChannel
  :comment "GO:0004970"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportIonByATPGatedChannel
  :comment "GO:0035381"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/ATP))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; intracellularly ATP-gated ion channel activity
(deftransport ToTransportIonByintracellularlyATPGatedChannel
  :comment "GO:0099142"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/ATP))
  :occurs Intracellular
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; Intracellularly ATP-gated chloride channel activity
(deftransport ToTransportChlorideByIntracellularlyATPGatedChannel
  :comment "GO:0005260"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/ATP))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; Intracellularly ATP-gated chloride channel activity
(deftransport ToTransportCationByExtracellularlyATPGatedChannel
  :comment "GO:0004931"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/ATP))
  :occurs ExtracellularRegion
  :cargo (owl-and ch/inorganic_cation (owl-some hasConcentration HighConcentration)))


;; ligand-gated ion channel activity
(deftransport ToTransportIonByLigandGatedChannel
  :comment "GO:0015276"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated ion channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportIonByLigandGatedChannel
  :comment "GO:0099507"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved presynaptic_membrane
  :occurs presynaptic_membrane
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated anion channel activity
(deftransport ToTransportAnionByLigandGatedChannel
  :comment "GO:0099095"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))


;; cyclic nucleotide-gated ion channel activity
(deftransport ToTransportIonByCyclicNucleotideGatedChannel
  :comment "GO:0043855"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/cyclic_nucleotide))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))


;; extracellular ligand-gated ion channel activity
(deftransport ToTransportIonByExtracellularLigandGatedChannel
  :comment "GO:0005230"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :occurs ExtracellularRegion
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellular glycine-gated ion channel activity
(deftransport ToTransportIonByExtracellularGlycineGatedChannel
  :comment "GO:00016933"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/glycine))
  :occurs ExtracellularRegion
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glycine-gated chloride channel activity
(deftransport ToTransportChlorideByExtracellularGlycineGatedChannel
  :comment "GO:00016934"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/glycine))
  :occurs ExtracellularRegion
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; extracellular phenylacetaldehyde-gated ion channel activity
(deftransport ToTransportIonByExtracellularPhenylacetaldehydeGatedChannel
  :comment "GO:0036082"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs ExtracellularRegion
  :via (owl-and Channel (owl-some hasStimulus ch/phenylacetaldehyde))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellular ammonia-gated ion channel activity
(deftransport ToTransportIonByExtracellularAmmoniaGatedChannel
  :comment "GO:0036081"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs ExtracellularRegion
  :via (owl-and Channel (owl-some hasStimulus ch/ammonia))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; Intracellular ligand-gated ion channel activity
(deftransport ToTransportIonByIntracellularLigandGatedChannel
  :comment "GO:0005217"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :occurs Intracellular
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glutamate-gated ion channel activity
(deftransport ToTransportIonByExtracellularGlutamate-gatedChannel
  :comment "GO:0005234"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/L-glutamic_acid))
  :occurs ExtracellularRegion
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; ligand-gated cation channel activity
(deftransport ToTransportCationByLigandGatedChannel
  :comment "GO:0099094"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; glycine betaine-activated nonselective monovalent cation channel activity
(deftransport ToTransportMonovalentCationByGlycineBetaineGatedChannel
  :comment "GO:0090686"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/glycine_betaine))
  :cargo (owl-and ch/monovalent_inorganic_cation (owl-some hasConcentration HighConcentration)))

;; ligand-gated calcium channel activity
(deftransport ToTransportCalciumIonByLigandGatedChannel
  :comment "GO:0099604"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; glutamate-gated calcium ion channel activiy
(deftransport ToTransportCalciumIonByGlutamateGatedChannel
  :comment "GO:0022849"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; extracellularly glutamate-gated chloride channel activity
(deftransport ToTransportChlorideByExtracellularlyGlutamateGatedChannel
  :comment "GO:0008068"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs  ExtracellularRegion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/L-glutamic_acid (owl-some has-biological-role ch/neurotransmitter))))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; Intracellular phosphatidylinositol-3,5-bisphosphate-sensitive cation
(deftransport ToTransportCationByIntracellularPhosphatidylinositol-3-5-bisphosphateChannel
  :comment "GO:0097682"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/_1-phosphatidyl-1D-myo-inositol_3_4-bisphosphate_5-_))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))


;; ligand-gated sodium channel activity
(deftransport ToTransportSodiumIonByLigandGatedChannel
  :comment "GO:0015280"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSodiumIonByProtonGatedChannel
  :comment "GO:0044736"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/proton))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; channel-forming ionophore activity
(deftransport ToTransportSoluteByPoreChannel
  :comment "GO:0022886"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via PoreComplex
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; narrow pore channel activity
(deftransport ToTransportSoluteByNarrowPoreChannel
  :comment "GO:0022842"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Narrow))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportSoluteByNarrowPoreChannel
  :comment "GO:0022831"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Narrow) (owl-some hasStimulus Stimulus))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumByNarrowPoreChannel
  :comment "GO:0022841"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Narrow))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))


;; wide pore channel activity
(deftransport ToTransportSoluteByWidePoreChannel
  :comment "GO:0022829"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; gap junction channel activity
(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:0005243"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Cell
  :to Cell
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; Need Review- not complete
;; gap junction channel activity involved in cell communication by electrical coupling
(deftransport ToTransportSoluteByGapJunctionWidePoreChannel
  :comment "GO:1903763"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Cell
  :to Cell
  :involved CellCommunicationByElectricalCoupling
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; Proin Activity
(deftransport ToTransportSoluteByPorinChannel
  :comment "GO:0015288"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/chemical_entity (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))


;; oligosaccharide transporting porin Activity
(deftransport ToTransportOligosaccharideByPorinChannel
  :comment "GO:0015478"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/oligosaccharide (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; autotransporter activity
(deftransport ToTransportPassengerProteinByPorinChannel
  :comment "GO:0015474"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from PeriplasmicSpace
  :to ExtracellularRegion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/chemical_entity (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; hemaglutinin autotransporter activity
(deftransport ToTransportHemaglutininByPorinChannel
  :comment "GO:0015476"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from PeriplasmicSpace
  :to ExtracellularRegion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/glycoprotein (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; toxin export channel Activity
(deftransport ToTransportToxinExportByPorinChannel
  :comment "GO:0000269"
  :across Membrane
  :mechanism Facilitated_diffusion
  :to ExtracellularRegion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/toxin (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; maltose transporting porin activity
(deftransport ToTransportMaltoseByPorinChannel
  :comment "GO:0015481"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/maltose (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; nucleoside-specific channel porin activity
(deftransport ToTransportNucleosideByPorinChannel
  :comment "GO:0015471"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/nucleoside (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))

;; long-chain fatty acid transporting porin activity
(deftransport ToTransportLongChainFattyAcidByPorinChannel
  :comment "GO:0015483"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and PoreComplex (owl-some hasPoreSize Wide))
  :cargo (owl-and ch/long-chain_fatty_acid (owl-some hasDaSize [(span < 1000)])
                  (owl-some hasConcentration HighConcentration)))


;; calcium-release channel activity
(deftransport ToTransportCalciumIonByChannel
  :comment "GO:0015278"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Intracellular
  :via (owl-and Channel (owl-some hasStimulus Ligand))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; calcium-induced calcium release activity
(deftransport ToTransportCalciumIonByCalcium-inducedChannel
  :comment "GO:0048763"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Intracellular
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; ;; calcium-induced calcium release activity involved in regulation of postsynaptic cytosolic calcium ion concentration
;; (deftransport ToTransportCalciumIonByCalcium-inducedChannel
;;   :comment "GO:1905058"
;;   :across Membrane
;;   :mechanism Facilitated_diffusion
;;   :from Intracellular
;;   :involved
;;   :via (owl-and Channel (owl-some hasStimulus
;;                                   (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration))))
  
;; NAADP-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByNAADP-sensitiveChannel
  :comment "GO:0072345"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus ch/nicotinic_acid-adenine_dinucleotide_phosphate))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; calcium-release channel activity
(deftransport ToTransportCalciumIonBycADPR-sensitiveChannel
  :comment "GO:0072346"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/cyclic_ADP-ribose))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; ryanodine-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByRyanodineChannel
  :comment "GO:0005219"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/ryanodine))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; inositol 1,4,5-trisphosphate-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByInositolTrisphosphateChannel
  :comment "GO:0005220"
  :across Membrane
  :mechanism Facilitated_diffusion
  :from Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/_1D-myo-inositol_1_4_5-trisphosphate))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; inositol 1,4,5-trisphosphate-sensitive calcium-release channel activity
(deftransport ToTransportCalciumIonByInositolTrisphosphateChannel
  :comment "GO:0098695"
  :comment "Involved in regulation of postsynaptic cytosolic calcium levels"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved CalciumIonHomeostasis
  :occurs PostsynapticCytosol
  :via (owl-and Channel (owl-some hasStimulus ch/_1D-myo-inositol_1_4_5-trisphosphate))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; Intracellular cyclic nucleotide activated cation channel activity
(deftransport ToTransportCationByIntracellularCyclicNucleotideChannel
  :comment "GO:0005221"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/cyclic_nucleotide))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; Intracellular cGMP-activated cation channel activity
(deftransport ToTransportCationByIntracellular-cGMPChannel
  :comment "GO:0005223"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/_7-deaza-cGMP))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; Intracellular cAMP-activated cation channel activity
(deftransport ToTransportCationByIntracellular-cAMPChannel
  :comment "GO:0005222"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via (owl-and Channel (owl-some hasStimulus ch/_7-deaza-cGMP))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; Intracellular cAMP-activated cation channel activity involved in regulation of postsynaptic membrane potential
(deftransport ToTransportCationByIntracellular-cAMPChannel
  :comment "GO:0140233"
  :comment "Involved in regulation of postsynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :involved postsynaptic_membrane
  :via (owl-and Channel (owl-some hasStimulus ch/_7-deaza-cGMP))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; Intracellular cAMP-activated cation channel activity involved in regulation of presynaptic membrane potential
(deftransport ToTransportCationByIntracellular-cAMPChannel
  :comment "GO:0140232"
  :comment "Involved in regulation of presynaptic membrane potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :involved presynaptic_membrane
  :via (owl-and Channel (owl-some hasStimulus ch/_7-deaza-cGMP))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; voltage-gated anion channel activity
(deftransport ToTransportAnionByVoltageGatedChannel
  :comment "GO:0008308"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; voltage-gated chloride channel activity
(deftransport ToTransportChlorideByVoltageGatedChannel
  :comment "GO:0005247"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0005248"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated potassium channel activity
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0005249"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in cardiac muscle cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086006"
  :comment "Involved in cardiac muscle cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in SA node cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086063"
  :comment "Involved in SA node cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved SinoatrialNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


;; voltage-gated sodium channel activity involved in Purkinje myocyte action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086062"
  :comment "Involved in Purkinje myocyte action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved PurkinjeMyocyteActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))


;; voltage-gated sodium channel activity involved in bundle of His cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086061"
  :comment "Involved in bundle of His cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved BundleOfHisCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated sodium channel activity involved in AV node cell action potential
(deftransport ToTransportSodiumIonByVoltageGatedChannel
  :comment "GO:0086060"
  :comment "Involved in AV node cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved AtrioventricularNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in AV node cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086056"
  :comment "Involved in AV cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved AtrioventricularNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in bundle of His cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086057"
  :comment "Involved in bundle of His cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved BundleOfHisCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved in Purkinje myocyte cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086058"
  :comment "Involved in Purkinje myocyte cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved PurkinjeMyocyteActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; voltage-gated calcium channel activity involved SA node cell action potential
(deftransport ToTransportCalciumIonByVoltageGatedChannel
  :comment "GO:0086059"
  :comment "Involved in SA node cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved SinoatrialNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; propanediol channel activity
(deftransport ToTransportPropanediolByChannel
  :comment "GO:0015255"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/propanediol (owl-some hasConcentration HighConcentration)))

;; glycerol channel activity
(deftransport ToTransportGlycerolByChannel
  :comment "GO:0015254"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/glycerol (owl-some hasConcentration HighConcentration)))


;; ;; substrate-specific channel activity
;; (deftransport ToTransportsubstrate-specificByChannel
;;   :comment "GO:0022838"
;;   :across Membrane
;;   :mechanism Facilitated_diffusion
;;   :cargo (owl-and ch/chemical_entity (owl-some hasConcentration HighConcentration)))

;; methylammonium channel activity
(deftransport ToTransportAmmoniumIonByChannel
  :comment "GO:0015264"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/methylammonium (owl-some hasConcentration HighConcentration)))

;; ammonium channel activity
(deftransport ToTransportAmmoniumIonByChannel
  :comment "GO:0015251"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/ammonium_ion (owl-some hasConcentration HighConcentration)))

;; water channel activity
(deftransport ToTransportWaterByChannel
  :comment "GO:0015250"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/water (owl-some hasConcentration HighConcentration)))

;; ion channel activity
(deftransport ToTransportIonByChannel
  :comment "GO:0005216"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; light-activated ion channel activity
(deftransport ToTransportIonByLightActivatedChannel
  :comment "GO:0010461"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Light))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

;; anion channel activity
(deftransport ToTransportAnionByChannel
  :comment "GO:0005253"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; volume-sensitive anion channel activity
(deftransport ToTransportAnionByVolume-sensitiveChannel
  :comment "GO:0005225"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus volume-sensitive))
  :cargo (owl-and ch/anion (owl-some hasConcentration HighConcentration)))

;; volume-sensitive chloride channel activity
(deftransport ToTransportChlorideByVolume-sensitiveChannel
  :comment "GO:0072320"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus volume-sensitive))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; chloride channel activity
(deftransport ToTransportChlorideByChannel
  :comment "GO:0005254"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; pH-gated chloride channel activity
(deftransport ToTransportChlorideBypHGatedChannel
  :comment "GO:0061797"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus CellularResponseTopH))
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))

;; Intracellular chloride channel activity
(deftransport ToTransportChlorideIntracellularByChannel
  :comment "GO:0061778"
  :across Membrane
  :mechanism Facilitated_diffusion
  :occurs Intracellular
  :via Channel
  :cargo (owl-and ch/chloride (owl-some hasConcentration HighConcentration)))


;; fluoride channel activity
(deftransport ToTransportFluorideByChannel
  :comment "GO:0062054"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/fluoride (owl-some hasConcentration HighConcentration)))


;; cation channel activity
(deftransport ToTransportCationByChannel
  :comment "GO:0005261"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; calcium activated cation channel activity
(deftransport ToTransportCationByChannelCalciumActivated
  :comment "GO:0005227"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

;; calcium-activated potassium channel activity
(deftransport ToTransportPotassiumIonByChannelCalciumActivated
  :comment "GO:0015269"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                   (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; ;; small conductance calcium-activated potassium channel activity
;; (deftransport ToTransportPotassiumIonByChannelCalciumActivated
;;   :comment "GO:0016286"
;;   :across Membrane
;;   :mechanism Facilitated_diffusion
;;   :via (owl-and Channel (owl-some hasStimulus
;;                                  (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration))))
;;   :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))



;; chloride-activated potassium channel activity
(deftransport ToTransportPotassiumIonByChannelChlorideActivated
  :comment "GO:0070089"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus
                                  (owl-and ch/chloride (owl-some hasConcentration HighConcentration))))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; potassium channel activity
(deftransport ToTransportPotassiumIonByChannel
  :comment "GO:0005267"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; Intracellular sodium activated potassium channel activity
(deftransport ToTransportPotassiumIonByIntracellularSodium-activatedChannel
  :comment "GO:0005228"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus (owl-or ch/ion ch/sodium_1+_)))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; Intracellular calcium activated potassium channel activity
(deftransport ToTransportChlorideByIntracellularCalcium-activatedChannel
  :comment "GO:0005229"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus (owl-or ch/ion ch/calcium_ion)))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; osmolarity-sensing cation channel activity
(deftransport ToTransportOsmolarity-sensingCationByChannel
  :comment "GO:1990760"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus Osmolarity))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportMechanosensitiveIonByChannel
  :comment "GO:0008381"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/ion (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCationByChannel
  :comment "GO:0140135"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/cation (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitivePotassiumByChannel
  :comment "GO:0098782"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportMechanosensitiveCalciumByChannel
  :comment "GO:0015275"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportMechanosensitiveCalciumByChannel
  :comment "GO:0097364"
  :comment "Involved in regulation of action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :involved ActionPotential
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


(deftransport ToTransportMechanosensitiveCalciumByChannel
  :comment "GO:0097365"
  :comment "Involved in regulation of cardiac muscle cell action potential"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved cardiac_muscle_cell_action_potential
  :via (owl-and Channel (owl-some hasStimulus MechanicalStress))
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))


;; proton channel activity
(deftransport ToTransportProtonByChannel
  :comment "GO:0015252"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/proton (owl-some hasConcentration HighConcentration)))

;; sodium channel activity
(deftransport ToTransportSodiumByChannel
  :comment "GO:0005272"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/sodium_1+_ (owl-some hasConcentration HighConcentration)))

;; calcium channel activity
(deftransport ToTransportCalciumIonByChannel
  :comment "GO:0005262"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/calcium_ion (owl-some hasConcentration HighConcentration)))

;; iron ion channel activity
(deftransport ToTransportIronIonByChannel
  :comment "GO:0097689"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/iron_cation (owl-some hasConcentration HighConcentration)))

;; urea channel activity
(deftransport ToTransportUreaByChannel
  :comment "GO:0015265"
  :across Membrane
  :mechanism Facilitated_diffusion
  :via Channel
  :cargo (owl-and ch/urea (owl-some hasConcentration HighConcentration)))





;; ================================= Need Review ==============================================
;; voltage-gated potassium channel activity involved in ventricular cardiac muscle cell action potential repolarization
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:1902282"
  :comment "Involved in ventricular cardiac muscle cell action potential repolarization"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved VentricularCardiacMuscleCellMembraneRepolarization
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

;; voltage-gated potassium channel activity involved in atrial cardiac muscle cell action potential repolarization
(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086089"
  :comment "Involved in atrial cardiac muscle cell action potential repolarization"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved SinoatrialNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))

(deftransport ToTransportPotassiumIonByVoltageGatedChannel
  :comment "GO:0086090"
  :comment "Involved in SA node cell action potential repolarization"
  :across Membrane
  :mechanism Facilitated_diffusion
  :involved SinoatrialNodeCellActionPotential
  :via (owl-and Channel (owl-some hasStimulus Voltage))
  :cargo (owl-and ch/potassium_1+_ (owl-some hasConcentration HighConcentration)))
