package ru.netology.domain;

public class  Player implements Comparable {
    private int id;
    private String name;
    private int strength;

    public Player() {
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player) o;
        return getStrength()-p.getStrength();
    }
}
