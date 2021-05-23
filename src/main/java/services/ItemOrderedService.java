package services;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.HashMap;
import models.ItemOrdered;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class ItemOrderedService {
	private AtomicInteger id = new AtomicInteger(1);
	private Map<Integer, ItemOrdered> itemsOrdered  = new HashMap<Integer, ItemOrdered>();

	public ItemOrdered getItemOrdered(final Integer id) {
		return itemsOrdered.get(id);
	}

	public List<ItemOrdered> getItemsOrdered() {
		return new ArrayList<ItemOrdered>(itemsOrdered.values());
	}

	public ItemOrdered addItemOrdered(final ItemOrdered itemOrdered) {
		Integer tmpItemOrderedId = id.getAndIncrement();
		itemOrdered.setId(tmpItemOrderedId);
		itemsOrdered.put(tmpItemOrderedId, itemOrdered);
		return itemOrdered;
	}

	public ItemOrdered updateItemOrdered(final ItemOrdered itemOrdered) {
		return itemsOrdered.put(itemOrdered.getId(), itemOrdered);
	}

	public ItemOrdered updateItemOrdered(final Integer id, final ItemOrdered itemOrdered) {
		itemOrdered.setId(id);
		return itemsOrdered.put(id, itemOrdered);
	}

	public ItemOrdered deleteItemOrdered(final Integer id) {
		return itemsOrdered.remove(id);
	}
}
