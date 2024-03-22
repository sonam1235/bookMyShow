package com.example.bookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
@Setter
@Getter

@Accessors(chain = true)
public class BookMovieResponseDTO {
  private ResponseStatus responseStatus;
  private int amount;
  private Long bookingId;
}
