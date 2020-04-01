/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.export;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gooddata.sdk.model.md.report.Report;
import com.gooddata.util.GoodDataToStringBuilder;

import static com.gooddata.util.Validate.notNull;

/**
 * Report execution request
 */
public class ExecuteReport extends ReportRequest {

    private final String reportUri;

    ExecuteReport(final String reportUri) {
        this.reportUri = notNull(reportUri, "reportUri");
    }

    /**
     * Create ExecuteReport based on {@link Report}
     *
     * @param report to create report execution request for
     */
    public ExecuteReport(final Report report) {
        this(notNull(report, "report").getUri());
    }

    @JsonProperty("report")
    public String getReportUri() {
        return reportUri;
    }

    @Override
    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}
