package com.hiabernate.hiabernate.Repository‌;

import com.hiabernate.hiabernate.Model.modelItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<modelItem,Long> {
}
