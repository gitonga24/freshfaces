package freshfaces;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Optional;

import java.util.Arrays;
import java.util.Collection;

//import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ProductControllerTest {

	@InjectMocks
	private ProductController underTest;
	
	@Mock
	private ProductRepository productRepo;
	
	@Mock
	private Product spaButter;
	
	@Mock
	private Product sugarScrub;
	
	@Mock
	private BlendRepository blendRepo;
	
	@Mock
	private Blend lemon;
	@Mock
	private Blend orange;
	
	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleBlendToModel() throws BlendNotFoundException {
		long blendId = 1;	
		when(blendRepo.findById(blendId)).thenReturn(Optional.of(lemon));
		underTest.findOneBlend(blendId, model);
		verify(model).addAttribute("blend", lemon);		
	}
	
//	@Test
//	public void shouldAddAllBlendsToModel() {
//		Collection<Blend>allBlends = Arrays.asList(lemon, orange);
//		when(blendRepo.findAll()).thenReturn(allBlends);
//		
//		underTest.findAllBlends(model);
//		verify(model).addAttribute("blends", allBlends);
//	}
	
	@Test
	public void shouldAddSingleProductToModel() throws ProductNotFoundException {
		long productId = 1;
		when(productRepo.findById(productId)).thenReturn(Optional.of(spaButter));
		underTest.findOneProduct(productId, model);
		verify(model).addAttribute("product", spaButter);	
	}
	
	@Test
	public void shouldAddProductsToModel() {
		Collection<Product> allProducts = Arrays.asList(spaButter, sugarScrub);
		when(productRepo.findAll()).thenReturn(allProducts);
		
		underTest.findAllProducts(model);
		verify(model).addAttribute("allProducts", allProducts);
	}
	
	
}
