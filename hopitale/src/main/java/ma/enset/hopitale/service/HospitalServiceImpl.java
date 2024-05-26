package ma.enset.hopitale.service;

import jakarta.transaction.Transactional;
import ma.enset.hopitale.entities.Consultation;
import ma.enset.hopitale.entities.Medecin;
import ma.enset.hopitale.entities.Patient;
import ma.enset.hopitale.entities.RendezVous;
import ma.enset.hopitale.repository.ConsultationRepository;
import ma.enset.hopitale.repository.MedecinRepository;
import ma.enset.hopitale.repository.PatientRepository;
import ma.enset.hopitale.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
