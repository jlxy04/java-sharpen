package com.test.fastjson;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setId(11);
        user.setName("名称");

        List<Card> cardList = new ArrayList<>();

        Card card = new Card();
        card.setId(1);
        card.setName("卡1");
        cardList.add(card);

        Card card2 = new Card();
        card2.setId(2);
        card2.setName("卡2");
        cardList.add(card2);

        user.setCardList(cardList);

        System.out.println(JSON.toJSON(user));
    }
}
