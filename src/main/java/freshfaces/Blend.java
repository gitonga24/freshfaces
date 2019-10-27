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

	
	
	@Override
	public String toString() {
		return "Blend [id=" + id + ", blendName=" + blendName + "]";
		
				
	}
	public Blend(String blendName, String description, String ingredients, String sku, Product product) {
		this.blendName = blendName;
		this.description = description;
		this.ingredients = ingredients;
		this.sku = sku; 	
		this.product = product;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blendName == null) ? 0 : blendName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blend other = (Blend) obj;
		if (blendName == null) {
			if (other.blendName != null)
				return false;
		} else if (!blendName.equals(other.blendName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

	
	
	
}
