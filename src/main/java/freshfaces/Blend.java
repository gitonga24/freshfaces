package freshfaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Blend {

	@Id
	@GeneratedValue
	private Long id;
	
	private String blendName;

	private String description;

	private String ingredients;
	
	private String sku;

	@ManyToOne
	private Product product;
	
	
	public Long getId() {
		return id;
	}
	public String getBlendName() {
		return blendName;
	}

	public String getDescription() {
		return description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public String getSku() {
		return sku;
	}

	public Blend() {
		
	}

	public Blend(String blendName, String description, String ingredients, String sku, Product product) {
		this.blendName = blendName;
		this.description = description;
		this.ingredients = ingredients;
		this.sku = sku; 	
		this.product = product;
	}

}
