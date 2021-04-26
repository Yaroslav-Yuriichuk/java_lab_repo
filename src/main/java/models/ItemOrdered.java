package models;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public final class ItemOrdered {
    private String name;
    private int price;
    private double weight;
    private int itemCount;
    private ItemType itemType;

    @Override
    public String toString() {
        return String.format("%d x %s (%d x %d hrn)%n",
                this.getItemCount(),
                this.getName(),
                this.getItemCount(),
                this.getPrice());
    }
}
