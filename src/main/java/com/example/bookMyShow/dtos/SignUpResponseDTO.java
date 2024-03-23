package com.example.bookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class SignUpResponseDTO {
    private ResponseStatus responseStatus;
    private Long userId;

}
