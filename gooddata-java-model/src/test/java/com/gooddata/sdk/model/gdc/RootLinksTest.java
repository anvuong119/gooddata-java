/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.gdc;

import org.testng.annotations.Test;

import static com.gooddata.util.ResourceUtils.readObjectFromResource;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RootLinksTest {

    @Test
    public void deserialize() {
        final RootLinks rootLinks = readObjectFromResource("/gdc/gdc.json", RootLinks.class);
        assertThat(rootLinks, is(notNullValue()));

        assertThat(rootLinks.getHomeUri(), is("/gdc/"));
        assertThat(rootLinks.getTokenUri(), is("/gdc/account/token"));
        assertThat(rootLinks.getLoginUri(), is("/gdc/account/login"));
        assertThat(rootLinks.getMetadataUri(), is("/gdc/md"));
        assertThat(rootLinks.getXTabUri(), is("/gdc/xtab2"));
        assertThat(rootLinks.getAvailableElementsUri(), is("/gdc/availableelements"));
        assertThat(rootLinks.getReportExporterUri(), is("/gdc/exporter"));
        assertThat(rootLinks.getAccountUri(), is("/gdc/account"));
        assertThat(rootLinks.getProjectsUri(), is("/gdc/projects"));
        assertThat(rootLinks.getToolUri(), is("/gdc/tool"));
        assertThat(rootLinks.getTemplatesUri(), is("/gdc/templates"));
        assertThat(rootLinks.getReleaseInfoUri(), is("/gdc/releaseInfo"));
        assertThat(rootLinks.getUserStagingUri(), is("/uploads"));
    }
}