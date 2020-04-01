/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.dataset;

import org.testng.annotations.Test;

import java.io.IOException;

import static com.gooddata.util.ResourceUtils.readObjectFromResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class TaskStateTest {

    @Test
    public void testDeserialize() throws IOException {
        TaskState taskState = readObjectFromResource("/dataset/taskStateOK.json", TaskState.class);
        assertThat(taskState.getStatus(), is("OK"));
        assertThat(taskState.getMessage(), is("ok message"));
    }

    @Test
    public void testToStringFormat() throws Exception {
        TaskState taskState = readObjectFromResource("/dataset/taskStateOK.json", TaskState.class);

        assertThat(taskState.toString(), matchesPattern(TaskState.class.getSimpleName() + "\\[.*\\]"));
    }
}
