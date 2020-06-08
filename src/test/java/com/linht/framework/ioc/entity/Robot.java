package com.linht.framework.ioc.entity;

public class Robot implements Body {

    private Hand hand;

    private Mouth mouth;

    @Override
    public void show(){
        hand.waveHand();
        mouth.speak();
    }

}
