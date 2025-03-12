package fjavierjp.keepcomponents.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fjavierjp.keepcomponents.backend.exception.ResourceNotFoundException;
import fjavierjp.keepcomponents.backend.model.Purchase;
import fjavierjp.keepcomponents.backend.repository.PurchaseRepository;

@Service
public class PurchaseService implements IService<Purchase>
{
	@Autowired
	private PurchaseRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Purchase> index()
	{
		return (List<Purchase>) this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Purchase show(long id)
	{
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Purchase " + id + " not found"));
	}

	@Override
	public Purchase store(Purchase purchase)
	{
		return this.repository.save(purchase);
	}

	@Override
	public Purchase update(Purchase purchase, long id)
	{
		return this.repository.findById(id).map(purchaseDB -> {
			purchaseDB.setCustomer(purchase.getCustomer());
			purchaseDB.setArticle(purchase.getArticle()); // CHECK WHAT HAPPENS HERE WHEN ARTICLE DOES NOT EXIST.
			purchaseDB.setDate(purchase.getDate());
			purchaseDB.setAmount(purchase.getAmount());
			purchaseDB.setNet(purchase.getNet());
			purchaseDB.setTaxes(purchase.getTaxes());
			purchaseDB.setTotal(purchase.getTotal());
			return this.repository.save(purchaseDB);
		}).orElseThrow(() -> new ResourceNotFoundException("Purchase " + id + " not found"));
	}

	@Override
	public void delete(long id)
	{
		if (!this.repository.existsById(id))
		{
			throw new ResourceNotFoundException("Purchase " + id + " not found");
		}
		this.repository.deleteById(id);
	}
}
