package freshfaces;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ProductPopulator implements CommandLineRunner {
	
	@Resource
	private ProductRepository productRepo;
	
	@Resource
	private BlendRepository blendRepo;
	
	
	public void run(String... args) throws Exception {
		
		Product spaButter = new Product("Spa Butter");
		spaButter = productRepo.save(spaButter);
		
		Product sugarScrub = new Product ("Sugar Scrub");
		sugarScrub = productRepo.save(sugarScrub);
		
		Blend lemon = new Blend("Lemon", "description one", "ingridient 1", "sku # 1", spaButter);
		Blend orange = new Blend("orange", "description two", "ingridient 2", "sku # 2", spaButter);
		Blend chocolate = new Blend("chocolate", "description three", "ingridient 3", "sku # 3", spaButter);
		
		lemon = blendRepo.save(lemon);
		orange = blendRepo.save(orange);
		chocolate = blendRepo.save(chocolate);
	}

}
