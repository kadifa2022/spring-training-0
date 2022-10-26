package com.cydeo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")//to
    private LocalDateTime dataTime;
    @ManyToOne(fetch= FetchType.LAZY)//(@ManyToOne is EAGER-Immediately by default)-that 's why we have to add LAZY By self - Fetch when needed
    private Movie movie;
    @ManyToOne(fetch= FetchType.LAZY)//even if we don't need data springboot is loading behind the scene that's we need  to Fetch
    private Cinema cinema;





}
