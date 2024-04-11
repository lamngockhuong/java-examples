package com.ngockhuong.springboot_rediscache.repository;

import com.ngockhuong.springboot_rediscache.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
