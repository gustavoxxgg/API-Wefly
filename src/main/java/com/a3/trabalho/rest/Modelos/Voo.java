package com.a3.trabalho.rest.Modelos;
import jakarta.persistence.*;

@Entity
public class Voo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String imgSrc;

    @Column
    private String destTitle;

    @Column
    private String location;

    @Column
    private String grade;

    @Column
    private int fees;

    @Column
    private String description;

    public int getIdvoo() {
        return id;
    }

    public void setIdvoo(int idvoo) {
        this.id = idvoo;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getDestTitle() {
        return destTitle;
    }

    public void setDestTitle(String destTitle) {
        this.destTitle = destTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
