/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.standalone;

import je7hb.standalone.alternatives.FoodProcessor;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * A unit test AlternativesFoodProcessorTest to verify the operation of AlternativesFoodProcessor.
 * This test directly uses the Open Web Beans container API instead of Delta Spike
 *
 * @author Peter Pilgrim
 */
public class AlternativesFoodProcessorOWBTest {

    private @Inject FoodProcessor foodProcessor;

    @Test
    public void shouldInjectAlternative() {

        System.out.printf("java.class.path=%s\n", System.getProperty("java.class.path"));
        System.out.printf("java.home=%s\n", System.getProperty("java.home"));
        System.out.printf("user.dir=%s\n", System.getProperty("user.dir"));

        final ContainerLifecycle lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(this);

        final BeanManager beanManager = lifecycle.getBeanManager();
        final Bean<?> bean = beanManager.getBeans(FoodProcessor.class).iterator().next();

        foodProcessor = (FoodProcessor) beanManager.getReference(bean, FoodProcessor.class, beanManager.createCreationalContext(bean));

        assertNotNull(foodProcessor);
        assertEquals("Xenonique", foodProcessor.sayBrand());

        lifecycle.stopApplication(this);
    }
}
