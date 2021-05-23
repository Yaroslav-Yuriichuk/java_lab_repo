package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import models.ItemOrdered;
import services.ItemOrderedService;

@RestController
@RequestMapping(path = "/item_ordered")
public class ShippingController {

	@Autowired
	private ItemOrderedService itemOrderedService;

	@GetMapping(path = "{id}")
	public ResponseEntity<ItemOrdered> getItemOrdered(@PathVariable (name = "id") final Integer id) {
		if (itemOrderedService.getItemOrdered(id) != null) {
			return new ResponseEntity<ItemOrdered>(itemOrderedService.getItemOrdered(id), HttpStatus.OK);
		}
		return new ResponseEntity<ItemOrdered>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public List<ItemOrdered> getItemsOrdered() {
		return itemOrderedService.getItemsOrdered();
	}

	@PostMapping
	public ItemOrdered addItemOrdered(@RequestBody final ItemOrdered itemOrdered) {
		return itemOrderedService.addItemOrdered(itemOrdered);
	}

	@PutMapping
	public ResponseEntity<ItemOrdered> updateItemOrdered(@RequestBody final ItemOrdered itemOrdered) {
		if (itemOrderedService.getItemOrdered(itemOrdered.getId()) != null) {
			return new ResponseEntity<ItemOrdered>(
					itemOrderedService.updateItemOrdered(itemOrdered), HttpStatus.OK);
		}
		return new ResponseEntity<ItemOrdered>(HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ItemOrdered> updateItemOrdered(
			@RequestBody final ItemOrdered itemOrdered,
			@PathVariable (name = "id") final Integer id) {
		if (itemOrderedService.getItemOrdered(id) != null) {
			return new ResponseEntity<ItemOrdered>(
					itemOrderedService.updateItemOrdered(id, itemOrdered), HttpStatus.OK);
		}
		return new ResponseEntity<ItemOrdered>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ItemOrdered> deleteItemOrdered(@PathVariable (name = "id") final Integer id) {
		if (itemOrderedService.getItemOrdered(id) != null) {
			return new ResponseEntity<ItemOrdered>(itemOrderedService.deleteItemOrdered(id), HttpStatus.OK);
		}
		return new ResponseEntity<ItemOrdered>(HttpStatus.NOT_FOUND);
	}
}
