package freshfaces;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Product {

	@Id
	@GeneratedValue 
	private Long id; 
	
	private String productName;
	
	
	@OneToMany(mappedBy="product")
	private List<Blend> blends;
	
	
	
	public String getProductName() {
		return productName;
	}

	protected Product() {
		
	}

	public Product(String productName) {
		this.productName = productName;
	}


	public List <Blend> getBlends() {
		return blends;
	}
	
	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blends == null) ? 0 : blends.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		Product other = (Product) obj;
		if (blends == null) {
			if (other.blends != null)
				return false;
		} else if (!blends.equals(other.blends))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}
	
	
	
	
	

}
