package com.example.Eshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String header;

    @Column(length = 1000)
    private String text;
    private int stars;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
