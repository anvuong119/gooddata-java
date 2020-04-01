/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.model.connector;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gooddata.util.ISOZonedDateTimeDeserializer;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Connector process (i.e. single ETL run) status (standalone, not embedded in integration as its parent) .
 * Deserialization only.
 */
@JsonTypeName("process")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessStatus extends IntegrationProcessStatus {

    public static final String URL = "/gdc/projects/{project}/connectors/{connector}/integration/processes";

    @JsonCreator
    ProcessStatus(@JsonProperty("status") Status status,
                  @JsonProperty("started") @JsonDeserialize(using = ISOZonedDateTimeDeserializer.class) ZonedDateTime started,  //TODO check if necessary
                  @JsonProperty("finished") @JsonDeserialize(using = ISOZonedDateTimeDeserializer.class) ZonedDateTime finished,
                  @JsonProperty("links") Map<String, String> links) {
        super(status, started, finished, links);
    }

}
