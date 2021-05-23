package dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import models.ItemOrdered;

@Repository
public interface ItemOrderedRepository extends CrudRepository<ItemOrdered, Integer> {

}
