package com.test.fastjson;

import java.util.List;

public class User {

    private int id;

    private String name;

    private List<Card> cardList;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public User setCardList(List<Card> cardList) {
        this.cardList = cardList;
        return this;
    }
}
