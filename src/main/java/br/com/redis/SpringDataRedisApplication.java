package br.com.redis;

import br.com.redis.entity.Product;
import br.com.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;

import javax.management.StandardEmitterMBean;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
//@DependsOn("jedisConnectionFactory")
public class SpringDataRedisApplication {

	@Autowired
	private ProductDao productDao;

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDao.save(product);
	}

	@GetMapping
	public List<Product> getAll(){
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable int id){
		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id){
		return productDao.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

}
