package com.shizuku.yaml.entity;

public class Name {
    private String name;
    private String nick;

    public Name() {
    }

    public Name(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
