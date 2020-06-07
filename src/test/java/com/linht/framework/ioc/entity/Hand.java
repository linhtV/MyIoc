package com.linht.framework.ioc.entity;

import lombok.Setter;

@Setter
public class Hand {


    private String text;


    public void waveHand(){

        System.out.println("挥一挥手");

    }

}
