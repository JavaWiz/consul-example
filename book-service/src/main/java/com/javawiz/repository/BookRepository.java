package com.javawiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javawiz.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
