package freshfaces;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerMockMvcTest {

	@Resource
	private MockMvc mvc;
	
	@Mock
	private Product spaButter;
	
	@Mock
	private Product sugarScrub;

	@MockBean
	private ProductRepository productRepo;
	
	@MockBean
	private BlendRepository blendRepo;
	
	@Mock
	private Blend lemon;
	
	@Mock
	private Blend orange;
	
	
	@Test
	public void shouldRouteToSingleProductView() throws Exception {
		long productId = 1;
		when(productRepo.findById(productId)).thenReturn(Optional.of(spaButter));
		
		mvc.perform(get("/product?id=1")).andExpect(view().name(is("product")));	
	}
	
	@Test
	public void shouldRouteToAllProductsView() throws Exception {		
		mvc.perform(get("/allProducts")).andExpect(view().name(is("allProducts")));		
	}
	
	@Test
	public void shouldAddAllProductsIntoAllProductsModel() throws Exception {
		Collection<Product> allProducts = Arrays.asList(spaButter, sugarScrub);
		when(productRepo.findAll()).thenReturn(allProducts);
		mvc.perform(get("/allProducts")).andExpect(model().attribute("allProducts", is(allProducts)));
	}
	
	@Test
	public void shouldAddSingleBlendToBlendModel() throws Exception {
		when(blendRepo.findById(2L)).thenReturn(Optional.of(lemon));
		
		mvc.perform(get("/blend?id=2")).andExpect(model().attribute("blend", is(lemon)));	
	}
	
	//@Test
	public void shouldAddBlendsToTheProductModel() throws Exception {
		Product oneProduct = (Product) Arrays.asList(lemon, orange);
		when(oneProduct.getBlends()).thenReturn((List<Blend>) oneProduct);
		mvc.perform(get("/product")).andExpect(model().attribute("product", is(oneProduct)));
		
	}
}
