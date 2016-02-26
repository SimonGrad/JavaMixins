package org.literadix.tests.mixins;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Tests Mixins.
 */
public class MixinTest {

    /**
     * Logger.
     */
    final static Logger log = LoggerFactory.getLogger(MixinTest.class);

    /**
     * Load mixin by spring bean.
     */
    @Test
    public final void testSpring() {

        final ApplicationContext sCtx = new ClassPathXmlApplicationContext("Application.xml");
        final InterfaceBoth instance = sCtx.getBean(InterfaceBoth.class);

        log.debug("hello one: {}", instance.helloOne());
        log.debug("hello two: {}", instance.helloTwo());
        log.debug("password: {}", instance.getPassword());
        log.debug("service instance: {}", instance.getService());

        Assert.assertNotNull(instance.helloOne());
        Assert.assertNotNull(instance.helloTwo());
        Assert.assertNotNull(instance.getPassword());
        Assert.assertNotNull(instance.getService());

    }

}
