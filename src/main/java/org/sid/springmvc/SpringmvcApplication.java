package org.sid.springmvc;

import java.util.Date;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringmvcApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		return args -> {
			patientRepository.save(new Patient(null, "Hassan", new Date(), false, 4));
			patientRepository.save(new Patient(null, "Mohamed", new Date(), false, 9));
			patientRepository.save(new Patient(null, "Samira", new Date(), false, 12));
			
			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getName());
			});
		};
	}

}
