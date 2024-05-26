package ma.enset.hopitale;

import ma.enset.hopitale.entities.*;
import ma.enset.hopitale.repository.ConsultationRepository;
import ma.enset.hopitale.repository.MedecinRepository;
import ma.enset.hopitale.repository.PatientRepository;
import ma.enset.hopitale.repository.RendezVousRepository;
import ma.enset.hopitale.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitaleApplication {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HopitaleApplication.class, args);
	}

	@Bean //s'exécute au démarrage
	CommandLineRunner start(IHospitalService hospitalService, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository){
		return args -> {
			Stream.of("Mohammed", "Hassan", "Najat").forEach(name->{
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setMalade(false);
				patient.setDateNaissance(new Date());
				hospitalService.savePatient(patient);
			});

			Stream.of("Aymane", "Hanane", "Yassmine").forEach(name->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.saveMedecin(medecin);
			});

			Patient patient = patientRepository.findByNom("Mohammed");

			Medecin medecin = medecinRepository.findByNom("Yassmine");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);

			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport 1");


			hospitalService.saveConsultation(consultation);

		};
	}
}
