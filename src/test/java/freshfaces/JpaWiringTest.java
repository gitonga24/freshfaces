package freshfaces;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
		
	
	@Resource
	private ProductRepository productRepo;
	
	@Resource
	private BlendRepository blendRepo;
	
	@Resource
	TestEntityManager entityManager;

	Product spaButter = new Product ("Spa Butter");
//	spaButter = productRepo.save(spaButter);
	Blend lemon = new Blend("Lemon", "description one", "ingridient 1", "sku # 1", spaButter);
//	lemon = blendRepo.save(lemon);
	Blend orange = new Blend("orange", "description two", "ingridient 2", "sku # 2", spaButter);
//	orange = blendRepo.save(orange);
	Blend chocolate = new Blend("chocolate", "description three", "ingridient 3", "sku # 3", spaButter);
//	chocolate = blendRepo.save(chocolate);
	
	@Test
	public void shouldAddBlendToProduct() {
		
		entityManager.flush();
		entityManager.clear();		
		
		spaButter = productRepo.findById(spaButter.getId()).get();
		
		Long underTestId = spaButter.getId();
		assertThat(spaButter.getId(), is(4));
		
		assertThat(spaButter.getProductName(), is("spaButter"));			
	}

	
	@Test
	public void productShouldHaveACollectionOfAllBlends() {
		
		Product spaButter = new Product ("Spa Butter");
		
		
		
	}
	
}
