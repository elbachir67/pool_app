package pool.tpv.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pool.tpv.first.domain.Compagnie;
import pool.tpv.first.domain.Branche;
import pool.tpv.first.domain.CompagnieRepository;
import pool.tpv.first.domain.BrancheRepository;

import java.util.Arrays;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(FirstApplication.class);

	private final CompagnieRepository crepository;
	private final BrancheRepository brepository;

	public FirstApplication(CompagnieRepository crepository, BrancheRepository brepository) {
		this.crepository = crepository;
		this.brepository = brepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(FirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db
		Compagnie c1 = new Compagnie("Axa Assurance");
		Compagnie c2 = new Compagnie("Amsa Assurance");
		crepository.saveAll(Arrays.asList(c1, c2));

		brepository.save(new Branche("Risque Divers", c1));
		brepository.save(new Branche("Automobile", c1));
		brepository.save(new Branche("ADP", c2));
		brepository.save(new Branche("Automobile", c2));


		for (Branche b : brepository.findAll()) {
			logger.info("libelle: {}", b.getNomBranche());
		}
	}

}
