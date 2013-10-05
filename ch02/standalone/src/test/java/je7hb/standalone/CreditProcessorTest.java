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

import je7hb.travelfunk.AbstractCdiContainerTest;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * A unit test CreditProcessorTest to verify the operation of CreditProcessorTest
 *
 * @author Peter Pilgrim
 */
public class CreditProcessorTest extends AbstractCdiContainerTest {

//    private @Inject @Economy Instance<Integer> randomInt;
    private @Inject @Economy CreditProcessor agent;

    @Test
    public void shouldInjectStreetCredit() {
        assertNotNull(agent);
        agent.check("12354678");
        System.out.printf("agent=%s\n", agent );
    }
}
