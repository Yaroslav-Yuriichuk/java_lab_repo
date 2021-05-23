package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Table(name = "ITEM_ORDERED_TBL")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public final class ItemOrdered {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private int price;
	private double weight;
	private int itemCount;
	private ItemType itemType;

	@Override
	public String toString() {
		return String.format("%d x %s (%d x %d hrn.)%n", this.getItemCount(), this.getName(), this.getItemCount(),
				this.getPrice());
	}
}
