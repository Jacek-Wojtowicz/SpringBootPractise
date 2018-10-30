package rc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner{

	private HotelRepository hotelRepository;
	
	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Hotel Marriot = new Hotel(
				"Marriot",
				130,
				new Address("Paris", "France"),
				Arrays.asList(
						new Review("John", 8, false),
						new Review("Jake", 7, true)
					)
			);
		
		Hotel Ibis = new Hotel(
				"Ibis",
				90,
				new Address("Zagreb", "Croatia"),
				Arrays.asList(
						new Review("Merry", 9, true)
					)
			);
		
		Hotel Novotel = new Hotel(
				"Novotel",
				200,
				new Address("Szczecin", "Poland"),
				new ArrayList<>()
			);
		
		//Delete all data
		this.hotelRepository.deleteAll();
		
		List<Hotel> hotels = Arrays.asList(Marriot, Ibis, Novotel);
		this.hotelRepository.saveAll(hotels);
		
	}

}
