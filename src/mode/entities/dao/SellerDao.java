package mode.entities.dao;

import java.util.List;

import mode.entities.Seller;

public interface SellerDao {

	public Seller findById(Long id);
	
	public void update(Seller seller);
	
	public void deleteById(Long id);
	
	public void insert(Seller seller);
	
	public List<Seller> findAll();
}
