/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.featureflag;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.testng.annotations.Test;

public class FeatureFlagTest {

    @Test
    public void shouldVerifyEquals() throws Exception {
        EqualsVerifier.forClass(FeatureFlag.class)
                .usingGetClass()
                .verify();
    }
}