package freshfaces;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
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

	

	
	
	
	@Test
	public void productShouldHaveACollectionOfAllBlends () {
	
		Product spaButter = new Product ("Spa Butter");
		spaButter = productRepo.save(spaButter);
		
		Blend lemon = new Blend("Lemon", "description one", "ingridient 1", "sku # 1", spaButter);
		lemon = blendRepo.save(lemon);
		
		Blend orange = new Blend("orange", "description two", "ingridient 2", "sku # 2", spaButter);
		orange = blendRepo.save(orange);
		
		Blend chocolate = new Blend("chocolate", "description three", "ingridient 3", "sku # 3", spaButter);
		chocolate = blendRepo.save(chocolate);
		
		
		entityManager.flush();
		entityManager.clear();		
		
		Product retrievedProduct = productRepo.findById(spaButter.getId()).get();
		assertThat(retrievedProduct.getBlends(), containsInAnyOrder(lemon, orange, chocolate));
		
//		
//		Blend retrievedBlend = blendRepo.findById(lemon.getId()).get();
//		Blend retrievedBlend2 = blendRepo.findById(orange.getId()).get();
//		
//		assertThat(retrievedProduct.getBlends(), containsInAnyOrder(lemon, orange));		
//		
//		spaButter = productRepo.findById(spaButter.getId()).get();
//		Long underTestId = spaButter.getId();
//		assertThat(spaButter.getId(), is(underTestId));
//		assertThat(spaButter.getProductName(), is("spaButter"));			
	}

	
	@Test
	public void shouldAddandRetrieveBlendById() {
		Product spaButter = new Product ("Spa Butter");
		spaButter = productRepo.save(spaButter);
		
		Blend lemon = new Blend("Lemon", "description one", "ingridient 1", "sku # 1", spaButter);
		lemon = blendRepo.save(lemon);
		
		Blend orange = new Blend("orange", "description two", "ingridient 2", "sku # 2", spaButter);
		orange = blendRepo.save(orange);
		
		Blend underTest = blendRepo.findById(lemon.getId()).get();
		
		assertThat(underTest.getId(), is(lemon.getId()));
		
//		spaButter = productRepo.findById(spaButter.getId()).get();	
//		Long underTestId = spaButter.getId();
//		assertThat(spaButter.getId(), is(underTestId));
//		assertThat(spaButter.getProductName(), is("spaButter"));
				
	}
	
}
