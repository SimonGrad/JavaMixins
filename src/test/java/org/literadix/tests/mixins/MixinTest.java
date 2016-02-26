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
     * Test creating a mixed interface and proxied implementation.
     */
    @Test
    public final void testCreate() {

        final InterfaceBoth instance = InterfaceBoth.createInstance();

        Assert.assertNotNull(instance.helloOne());
        Assert.assertNotNull(instance.helloTwo());

        log.debug("OK");

    }

    /**
     * Load mixin by spring bean.
     */
    @Test
    public final void testSpring() {

        final ApplicationContext sCtx = new ClassPathXmlApplicationContext("Application.xml");
        final InterfaceBoth instance = sCtx.getBean(InterfaceBoth.class);

        Assert.assertNotNull(instance.helloOne());
        Assert.assertNotNull(instance.helloTwo());
        Assert.assertNotNull(instance.getPassword());

        log.debug("OK");
    }

}
