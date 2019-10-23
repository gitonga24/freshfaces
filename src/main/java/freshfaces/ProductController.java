package freshfaces;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@Resource
	private BlendRepository blendRepo;

	@RequestMapping("/blend")
	public String findOneBlend(@RequestParam (value="id") long blendId, Model model) throws BlendNotFoundException {
		Optional<Blend> lemon = blendRepo.findById(blendId);
		
		if(lemon.isPresent()) {
			model.addAttribute("blend", lemon.get());
			return "blend";
		}
		throw new BlendNotFoundException();
		
	}

}
