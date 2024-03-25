package com.atelier.tenisu.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Data {

    private int rank;
    private int points;
    private int weight;
    private int height;
    private int age;
    private int[] last;

    public Data() {

    }

    public Data(int[] last) {
        this.last = last;
    }

    public Data(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    public Data(int height){
        this.height = height;
    }
    
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getLast() {
        return last;
    }

    public void setLast(int[] last) {
        this.last = last;
    }

}
