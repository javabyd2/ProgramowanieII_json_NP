package com.sdabyd2.programowanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdabyd2.programowanie.model.Item;
import com.sdabyd2.programowanie.model.Order;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Item item = new Item("mleko", 2, "TESCO");
        Item item1 = new Item("chleb", 3, "PIEKUS");
        Item item2 = new Item("ziemniaki", 1, "Zieleniak");

        List<Item> items = Arrays.asList(item, item1, item2);
        Order order = new Order(items, 1);

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("order.json");
        file.createNewFile();
        objectMapper.writeValue(file, order);

        Order readOrders = objectMapper.readValue(new File("order.json"), Order.class);

        List<Item> itemList = readOrders.getItemList();
        for (Item item3 : itemList) {
            System.out.println(item3.getName() + " " + item3.getPrice() + " " + item3.getShop());
        }
        itemList.stream().forEach(i-> System.out.println(i.getName()));

    }
}
