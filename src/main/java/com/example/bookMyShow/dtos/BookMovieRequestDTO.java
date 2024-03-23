package com.example.bookMyShow.dtos;
import com.example.bookMyShow.models.User;

import java.util.List;
public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    private Long showIds;
    private User userId;
}
