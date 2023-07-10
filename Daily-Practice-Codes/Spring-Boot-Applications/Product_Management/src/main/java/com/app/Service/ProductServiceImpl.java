package com.app.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.DTO.PnameQtyDTO;
import com.app.DTO.ResponseIdpnameprice;
import com.app.Exception.ProductException;
import com.app.Repository.ProductRepository;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository pdao;
	@Autowired
	private ModelMapper mp;

	public ProductServiceImpl() {
	}

	@Override
	public Product InsertProduct(Product p) {
		return pdao.save(p);
	}

	@Override
	public List<Product> GetProductList() {
		return pdao.findAll();
	}

	@Override
	public Product UpdateProduct(Product p) {
		return pdao.saveAndFlush(p);
	}

	@Override
	public void DeleteProduct(Product p) {
		pdao.delete(p);
	}

	@Override
	public String DeleteProductById(long id) {
		String msg = "Invalid ID ";
		if (pdao.existsById(id)) {
			pdao.deleteById(id);
			msg = "Product Deleted Successful";
		}
		return msg;
	}

	@Override
	public Product UpdateProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product Getproductbyid(long id) {
		return pdao.findById(id).orElseThrow(() -> new ProductException("Product By Id NOT FOUND"));
	}

	public ResponseIdpnameprice validate(PnameQtyDTO p) {
		Product product = pdao.findByPnameAndQty(p.getPname(), p.getQty())
				.orElseThrow(() -> new ProductException("Wrong Product name or qty"));

		ResponseIdpnameprice map = mp.map(product, ResponseIdpnameprice.class);
		return map;
	}

}
