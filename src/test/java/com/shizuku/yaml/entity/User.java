package com.shizuku.yaml.entity;

import com.shizuku.yaml.annotaiton.YamlField;

import java.util.ArrayList;
import java.util.List;

public class User {
    @YamlField(name = "n", format = YamlField.Format.AUTO)
    private int id;
    private Name name;
    private String email;
    private List<Integer> friends;

    public User() {
        this.id = 0;
        this.name = new Name();
        this.email = "";
        this.friends = new ArrayList<>();
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public User(int id, Name name, String email, List<Integer> friends) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
