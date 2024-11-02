package ma.tp;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.tp.entities.Compte;
import ma.tp.entities.TypeCompte;
import ma.tp.repository.CompteRepository;

@SpringBootApplication
public class JaxRsJerseyTpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaxRsJerseyTpApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			compteRepository.save(new Compte(0, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(0, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(0, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}

}
