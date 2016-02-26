package org.literadix.tests.mixins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Mixin;

public interface InterfaceBoth extends InterfaceOne, InterfaceTwo {

    /**
     * Logger.
     */
    Logger log = LoggerFactory.getLogger(InterfaceBoth.class);

    /**
     * Factory to create a mixin instance from both interfaces and both implementations.
     *
     * @return Merged instance
     */
    static InterfaceBoth createInstance() {
        return new Factory().create();
    }

    class Factory {

        @Autowired(required = false)
        NewService service;

        InterfaceBoth create() {

            log.debug("created instance {}", service);

            final Class<?>[] interfaces = new Class[]{InterfaceOne.class, InterfaceTwo.class, InterfaceBoth.class};
            final Object[] delegates = new Object[]{new ClassOne() {{
                setService(service);
            }}, new ClassTwo()};
            return ((InterfaceBoth) Mixin.create(interfaces, delegates));
        }
    }

}
