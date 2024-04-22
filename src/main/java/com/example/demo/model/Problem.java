package com.example.demo.model;

import com.example.demo.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Problem implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String problemTitle;
    private boolean status;
    private double acceptance;
    private Difficulty difficulty;
    private double frequency;
}
