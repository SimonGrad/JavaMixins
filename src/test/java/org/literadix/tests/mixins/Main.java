package org.literadix.tests.mixins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example how to use the mixin outside spring. Just pure java.
 * <p>
 * Created by mab on 29.02.2016.
 */
public class Main {

    final static Logger log = LoggerFactory.getLogger(MixinTest.class);


    public static void main(String args[]) {

        InterfaceBoth mixin = (new InterfaceBoth.Factory()).create();
        log.debug("hello one: {}", mixin.helloOne());
        log.debug("hello two: {}", mixin.helloTwo());

        // Please not that no injection is set up.
        // Following values are intentionally empty:
        log.debug("password: {}", mixin.getPassword());
        log.debug("service: {}", mixin.getService());


    }

}
