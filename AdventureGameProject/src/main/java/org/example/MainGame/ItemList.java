package org.example.MainGame;

import java.util.ArrayList;
import java.util.List;
import org.example.Players.Hero;

public class ItemList {
    List<Item> items = new ArrayList<Item>();

    public void addItemToInventory(Item item) {
        if (items.size()+1 <= 10 && items.size() >= 0) {
            items.add(item);
        }
        else  {
            System.out.println("Your inventory is full! Can't add more items.");
        }
    }

    public void allItemsOnList() {
        System.out.println("----------");
        System.out.println("All items: ");
        System.out.println("----------");
        if (items.size() > 0) {
            for (Item item : items) {
                System.out.println("Item: " + item.getName());
            }
        }
        else if (items.size() == 0)
        {
            System.out.println("No items in your inventory");
        }
        System.out.println("----------");
    }

    public void useItem(Hero hero) {
        int size = 0;
        for( Item item : items) {
            if(items.size()+1 == 0) {
                System.out.println("You have no items you can use!");
            }
            else {
                size = items.size();
            }
        }
        if(size > 0) {
        }
    }
}
