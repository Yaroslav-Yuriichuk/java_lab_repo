package services;

import models.ItemOrdered;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import dal.ItemOrderedRepository;

@Service
@ApplicationScope
public class ItemOrderedService {

	@Autowired
	private ItemOrderedRepository repository;

	public ItemOrdered getItemOrdered(final Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<ItemOrdered> getItemsOrdered() {
		return (List<ItemOrdered>) repository.findAll();
	}

	public ItemOrdered addItemOrdered(final ItemOrdered itemOrdered) {
		return repository.save(itemOrdered);
	}

	public ItemOrdered updateItemOrdered(final Integer id, final ItemOrdered itemOrdered) {
		ItemOrdered tmp = repository.findById(id).orElse(null);
		if (tmp == null) {
			return null;
		}
		tmp.setItemCount(itemOrdered.getItemCount());
		tmp.setItemType(itemOrdered.getItemType());
		tmp.setName(itemOrdered.getName());
		tmp.setPrice(itemOrdered.getPrice());
		tmp.setWeight(itemOrdered.getWeight());
		return repository.save(tmp);
	}

	public ItemOrdered deleteItemOrdered(final Integer id) {
		ItemOrdered tmp = repository.findById(id).orElse(null);
		if (tmp == null) {
			return null;
		}
		repository.deleteById(id);
		return tmp;
	}
}
