/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.dataset;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import static com.gooddata.util.ResourceUtils.OBJECT_MAPPER;
import static com.gooddata.util.ResourceUtils.readFromResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaqlDmlTest {

    @Test
    public void testSerialization() throws Exception {
        final String json = IOUtils.toString(readFromResource("/dataset/maqlDml.json"), "UTF-8");
        assertThat(OBJECT_MAPPER.writeValueAsString(new MaqlDml("maqlddl")),
                is(json));
    }
}
