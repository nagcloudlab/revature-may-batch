package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    private int id;
    private String title;
    @OneToMany(mappedBy = "movie",targetEntity = Promotion.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Promotion> promotions;
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
