package com.hiabernate.hiabernate.Model;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

@Entity
@Table(name = "corrupteditem")
public class modelCorruptedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_item",referencedColumnName = "id")
    private modelItem item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public modelItem getItem() {
        return item;
    }

    public void setItem(modelItem item) {
        this.item = item;
    }


}
