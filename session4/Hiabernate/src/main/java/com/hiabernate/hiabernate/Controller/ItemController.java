package com.hiabernate.hiabernate.Controller;

import ch.qos.logback.core.model.Model;
import com.hiabernate.hiabernate.Model.modelCorruptedItem;
import com.hiabernate.hiabernate.Model.modelItem;
import com.hiabernate.hiabernate.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<modelItem> getAllItems(){
        return  itemService.getAllItems();
    }
    @GetMapping("/{id}")
    public modelItem getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
    @PostMapping
    public modelItem createItem(@RequestBody modelItem item)
    {
        return itemService.createItem(item);
    }

    public modelItem updateItem(@PathVariable Long id, @RequestBody modelItem item) {
        return itemService.updateItem(id, item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
    @PostMapping("/corrupteditems")
    public modelCorruptedItem createCorruptedItem(@RequestBody modelCorruptedItem item) {
        return itemService.createCorruptedItem(item);
    }

}
