package com.example.bookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel{
    private String name;
    public boolean equals(SeatType obj)
    {
        return this.name.equals(obj.getName());
    }
}
