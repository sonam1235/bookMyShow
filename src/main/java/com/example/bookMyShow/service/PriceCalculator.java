package com.example.bookMyShow.service;

import com.example.bookMyShow.models.Show;
import com.example.bookMyShow.models.ShowSeat;
import com.example.bookMyShow.models.ShowSeatType;
import com.example.bookMyShow.repositories.ShowSeatTypeRepository;

import java.util.List;

public class PriceCalculator {
    ShowSeatTypeRepository showSeatTypeRepository;
    PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showSeats, Show show)
    {
       List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
       int amount=0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                }
            }
        }
       return amount;
    }
}
