package org.literadix.tests.mixins;

import org.springframework.cglib.proxy.Mixin;

public interface InterfaceBoth extends InterfaceOne, InterfaceTwo {

    static InterfaceBoth createInstance() {

        final Class<?>[] interfaces = new Class[] { InterfaceOne.class, InterfaceTwo.class, InterfaceBoth.class };
        final Object[] delegates = new Object[] { new ClassOne(), new ClassTwo() };
        return ((InterfaceBoth) Mixin.create(interfaces, delegates));

    }
    
}
