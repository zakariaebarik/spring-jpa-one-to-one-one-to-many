package ma.enset.hopitale.service;

import ma.enset.hopitale.entities.Consultation;
import ma.enset.hopitale.entities.Medecin;
import ma.enset.hopitale.entities.Patient;
import ma.enset.hopitale.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
