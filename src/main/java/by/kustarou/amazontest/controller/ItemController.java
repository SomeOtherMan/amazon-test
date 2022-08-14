package by.kustarou.amazontest.controller;

import by.kustarou.amazontest.model.Item;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private static final List<Item> items = new ArrayList<>(){{
        add(new Item("Ivan", "Ivanov", 2));
        add(new Item("kir", "Lukan", 15));
    }};


    @GetMapping("/item")
    public List<Item> getAll() {
        return items;
    }

    @GetMapping("/item/{index}")
    public Item getByIndex(@PathVariable int index) {
        return items.get(index);
    }

    @PostMapping("/item")
    public Item create(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @DeleteMapping("/item/{index}")
    public Item deleteByIndex(@PathVariable int index) {
        Item result = items.get(index);
        items.remove(index);
        return result;
    }

}
