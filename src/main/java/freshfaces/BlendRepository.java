package freshfaces;

import org.springframework.data.repository.CrudRepository;

public interface BlendRepository extends CrudRepository<Blend, Long> {
	
	
	Blend findByBlendName(String blendName);

}
