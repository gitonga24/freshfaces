package freshfaces;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Resource
	private BlendRepository blendRepo;
	
	@Resource
	private ProductRepository productRepo;

	@RequestMapping("/blend")
	public String findOneBlend(@RequestParam (value="id") long blendId, Model model) throws BlendNotFoundException {
		Optional<Blend> lemon = blendRepo.findById(blendId);
		
		if(lemon.isPresent()) {
			model.addAttribute("blend", lemon.get());
			return "blend";
		}
		throw new BlendNotFoundException();
		
	}

	@RequestMapping("/product")
	public String findOneProduct(@RequestParam (value="id") long productId, Model model) throws ProductNotFoundException {
		Optional<Product> spaButter = productRepo.findById(productId);
		
		if(spaButter.isPresent()) {
			model.addAttribute("product", spaButter.get());
			return "product";
		}
		throw new ProductNotFoundException();
	}

	@RequestMapping("/allProducts")
	public String findAllProducts(Model model) {
		model.addAttribute("allProducts", productRepo.findAll());
		return "allProducts";
		
		
	}

	@RequestMapping("/blends")
	public String findAllBlends(Model model) {
		model.addAttribute("blends", blendRepo.findAll());
		return("blends");	
	}

}
