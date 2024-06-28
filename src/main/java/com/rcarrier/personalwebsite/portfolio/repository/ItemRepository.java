package com.rcarrier.personalwebsite.portfolio.repository;

import com.rcarrier.personalwebsite.portfolio.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositories allow us to access data
public interface ItemRepository  extends JpaRepository<Item, Long> {
}
