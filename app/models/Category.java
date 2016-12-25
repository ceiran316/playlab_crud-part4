package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class Category extends Model {

	@Id
	private Long id;
	
	@Constraints.Required
	private String name;

	@OneToMany
	private List<Product> products;
	
	public Category() {
}
	
	public Category(Long id, String name, Product products) {
		this.id = id;
		this.name = name;
		this.products = products;
}	





	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getName()	{
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Product getProducts() {
		return products;
	}
	
	public void setProducts(Product products){
		this.products = products;
}
	
	public static Finder<Long,Category> find = new Finder<Long,Category>(Category.class);

public static List<Category> findAll() {
	return Category.find.where().orderBy("name asc").findList();
}

}
