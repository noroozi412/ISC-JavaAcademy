package com.transactionsession;
import com.transactionsession.Model.CorruptedItem;
import com.transactionsession.Model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Component
public class JpaBaseInRun {

    @PersistenceContext
    private EntityManager entityManager;

    public void sampleRun() {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.getTransaction();

        // مقادیر پیشفرض
        createDefaultItems(session, transaction);

        // نمایش تمام اقلام
        transaction.begin();
        List<Item> allItems = session.createQuery("from Item", Item.class).getResultList();
        allItems.forEach(item -> System.out.println(item.getName()));
        transaction.commit();

        // حذف یک کالا
         transaction.begin();
        deleteItem(session, 1L); // فرض می‌کنیم اینجا می‌خواهیم کالا با ID 1 را حذف کنیم
        transaction.commit();

        // نمایش دوباره اقلام بعد از حذف
        transaction.begin();
        allItems = session.createQuery("from Item", Item.class).getResultList();
        allItems.forEach(item -> System.out.println(item.getName()));
        transaction.commit();
    }

    private void createDefaultItems(Session session, Transaction transaction) {
        transaction.begin();

        Item item1 = new Item();
        item1.setName("Item 1");
        item1.setPrice(100.0);
        item1.setCategory("Category A");
        session.persist(item1);

        Item item2 = new Item();
        item2.setName("Item 2");
        item2.setPrice(200.0);
        item2.setCategory("Category B");
        session.persist(item2);

        // فرض می‌کنیم یک CorruptedItem برای item1 داریم
        CorruptedItem corruptedItem = new CorruptedItem();
        corruptedItem.setItem(item1);
        session.persist(corruptedItem);

        transaction.commit();
    }

    private void deleteItem(Session session, Long itemId) {
        Item item = session.get(Item.class, itemId);
        if (item != null) {
            // حذف کالاهای خراب مرتبط
            List<CorruptedItem> corruptedItems = session.createQuery("from CorruptedItem where item.id = :itemId", CorruptedItem.class)
                    .setParameter("itemId", itemId)
                    .getResultList();
            for (CorruptedItem corruptedItem : corruptedItems) {
                session.remove(corruptedItem);
            }
            // حذف کالا
            session.remove(item);
        }
    }
}