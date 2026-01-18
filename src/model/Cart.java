package model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {

    private final String id;

    private final Map<String, Item> items = new HashMap<>();

    public Cart(String id) {
        this.id = id;
    }

    public void addItem(Item item) {
        Objects.requireNonNull(item);

        items.merge(item.getId(), item, (existing, incoming) -> {
            existing.updateQuantity(existing.getQuantity() + item.getQuantity());

            return existing;
        });
    }

    public double totalAmount() {
        return items.values().stream().mapToDouble(Item::totalPrice).sum();
    }

    public Collection<Item> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }

}
