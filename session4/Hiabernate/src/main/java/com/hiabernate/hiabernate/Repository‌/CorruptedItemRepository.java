package com.hiabernate.hiabernate.Repository‌;
import com.hiabernate.hiabernate.Model.modelCorruptedItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CorruptedItemRepository extends JpaRepository<modelCorruptedItem,Long> {
}
