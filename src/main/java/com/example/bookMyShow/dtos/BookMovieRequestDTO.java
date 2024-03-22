package com.example.bookMyShow.dtos;
import com.example.bookMyShow.models.User;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Setter
@Getter
public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    private Long showId;
    private User userId;


}
