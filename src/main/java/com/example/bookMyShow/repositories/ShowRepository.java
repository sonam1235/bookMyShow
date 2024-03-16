package com.example.bookMyShow.repositories;

import com.example.bookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Long> {
 Optional<Show> findById(Long id);
}
