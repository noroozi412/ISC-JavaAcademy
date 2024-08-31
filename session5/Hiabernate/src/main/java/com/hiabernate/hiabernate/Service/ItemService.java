package com.hiabernate.hiabernate.Service;

import com.hiabernate.hiabernate.Model.modelCorruptedItem;
import com.hiabernate.hiabernate.Model.modelItem;
import com.hiabernate.hiabernate.Repository‌.CorruptedItemRepository;
import com.hiabernate.hiabernate.Repository‌.ItemRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CorruptedItemRepository corruptedItemRepository;
    public List<modelItem> getAllItems() {
        return itemRepository.findAll();
    }

 public modelItem getItemById(Long id){
        return itemRepository.findById(id).orElseThrow();
 }
 public modelItem createItem(modelItem item){
        return itemRepository.save(item);
 }
    public  modelItem updateItem(Long id, modelItem item) {
        modelItem existingItem = getItemById(id);
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setCategory(item.getCategory());
        return itemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
        corruptedItemRepository.deleteById(id);
    }
    public modelCorruptedItem createCorruptedItem(modelCorruptedItem item) {

        return corruptedItemRepository.save(item);
    }
}
