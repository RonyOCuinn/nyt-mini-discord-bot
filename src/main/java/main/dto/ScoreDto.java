package main.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ScoreDto {

    private long id;
    private long score;
    private LocalDate date;

}
