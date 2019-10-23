package freshfaces;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

public class ProductControllerTest {

	@InjectMocks
	private ProductController underTest;
	
	@Mock
	private ProductRepository productRepo;
	
	@Mock
	private Product spaButter;
	
	@Mock
	private BlendRepository blendRepo;
	
	@Mock
	private Blend lemon;
	
	@Mock
	private Model model;
	


	@Test
	public void shouldAddSingleBlendToModel() throws BlendNotFoundException {
		long blendId = 1;	
		System.out.println("testing");;
		when(blendRepo.findById(blendId)).thenReturn(Optional.of(lemon));
		underTest.findOneBlend(blendId, model);
		verify(model).addAttribute("blend", lemon);		
	}
	
	
}
