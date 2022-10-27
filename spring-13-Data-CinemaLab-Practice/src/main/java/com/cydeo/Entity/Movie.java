package com.cydeo.Entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity//to create table
@Data//lombok
@NoArgsConstructor
public class Movie extends BaseEntity{  //red-looking for primary key

    private String name;
    @Column(columnDefinition="DATE")//To show date
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition="text")//no limit for text
    private String summary;
    @Enumerated(EnumType.STRING)//enum class
    private MovieType type;
    @Enumerated(EnumType.STRING)//enum class
    private MovieState state;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(name="movie_genre_rel",joinColumns=@JoinColumn(name="movie_id"),    //join two tables in one
    inverseJoinColumns =@JoinColumn(name="genre_id"))
    private List<Genre> genreList;         //if is many than put in LIST/SET relations between two tables


}
