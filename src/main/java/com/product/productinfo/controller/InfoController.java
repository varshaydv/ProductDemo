package com.product.productinfo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.productinfo.model.Category;
import com.product.productinfo.model.LoginPojo;
import com.product.productinfo.model.Product;
import com.product.productinfo.model.User;
import com.product.productinfo.repository.CategoryRepository;
import com.product.productinfo.repository.ProductRepository;
import com.product.productinfo.repository.UserRepository;

@RestController
public class InfoController {
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private CategoryRepository categoryrepo;
	
	@Autowired
	private UserRepository userrepository;
	
	
	
	//------------------------create category and product--------------------------------
	
	@PostMapping("/product/{id}")
	public String createproduct(@Valid @RequestBody Product product, @PathVariable Long id) {
	
		Category category  = categoryrepo.getOne(id);
		
		product.setCategory(category);
	//categoryrepo.save(category);
		productrepo.save(product);
		
		return "save suceesfully"; 
		
	}
	
	@PutMapping("/product/{id}")
	public String updateproduct(@PathVariable(value="id") Long id, @Valid @RequestBody Product updateproduct) {
		
		Category cat = categoryrepo.getOne(id);
		
		//updateproduct.setPrice(price);
		
		Product p = productrepo.getOne(id);
		
		p.setPrice(updateproduct.getPrice());
		
		p.setProductname(updateproduct.getProductname());
		
		p.setType(updateproduct.getType());
		
		Product pd = productrepo.save(p);
		
		return "product update";
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteproduct(@PathVariable(value="id") long id) {
		
		Product p = productrepo.getOne(id);
		p.setCategory(null);
		
		productrepo.delete(p);
		
		return "product delete";
		
		
	}
	
	
	
	@PostMapping("/catagory")
	public Category createcat(@Valid @RequestBody Category category) {
		
		return categoryrepo.save(category);
		
	}
	
	
	
	//----------------------update category and product-----------------------------
	
	@PutMapping("/category/{id}")
	public String updatecat(@PathVariable(value="id") Long id, @Valid @RequestBody Category updatecategory) {
		
		Category cat = categoryrepo.getOne(id);
		cat.setCategoryname(updatecategory.getCategoryname());
		cat.setDescription(updatecategory.getDescription());
		
		Category updatecat = categoryrepo.save(cat);
		
		
		return "update succesfully";
	}
	
	
	
	
	//--------------------delete product and category--------------------------
	
	@DeleteMapping("/category/{id}")
	public String deletecat(@PathVariable(value="id") Long id) {
		
		Category cat = categoryrepo.getOne(id);
		
		categoryrepo.delete(cat);
		
		return "delete successfully";
		
	}
		

	@GetMapping("/info")
	 public void run(String... args) throws Exception {
	        // Cleanup Database tables
//		productrepo.deleteAllInBatch();
//		categoryrepo.deleteAllInBatch();
	
		Category category = new Category("plastic","dailyuse kitchenwear");
		Category category1 = new Category("steel","dailyuse hardware");
		
		Product product1 = new Product("tifin","A",100.00);
		product1.setCategory(category);
		
		Product product2 = new Product("bottle","B",90.00);
		product2.setCategory(category1);
		
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		
		categoryrepo.save(category);
		categoryrepo.save(category1);
		
		//productrepo.save(product1);
		

}
	
	//---------------------user------------------------------
	
	@PostMapping("/user")
	public String adduser( @RequestBody User user ) {
		
		userrepository.save(user);
		return "add";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginPojo loginPojo) {
	
		
		User user=userrepository.findByEmail(loginPojo.getEmail());
		
		if(user.getEmail().equals(loginPojo.getEmail()) && user.getPassword().equals(loginPojo.getPassword())) 
		{
			
			return "login success"+user.getEmail();
		}
		
		return "login fail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}