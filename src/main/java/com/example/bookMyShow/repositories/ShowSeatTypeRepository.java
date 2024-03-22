package com.example.bookMyShow.repositories;

import com.example.bookMyShow.models.Show;
import com.example.bookMyShow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatTypeRepository, Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
