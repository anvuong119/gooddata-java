package com.gooddata.dataload.processes;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

public class SchedulesTest {

    @Test
    public void testDeserialization() throws Exception {
        final InputStream stream = getClass().getResourceAsStream("/dataload/processes/schedules.json");
        final Schedules schedules = new ObjectMapper().readValue(stream, Schedules.class);

        assertThat(schedules.getItems(), notNullValue());
        assertThat(schedules.getItems(), hasSize(1));
        assertThat(schedules.getItems().get(0).getId(), is("schedule_id"));
        assertThat(schedules.getItems().get(0).getType(), is("MSETL"));
        assertThat(schedules.getNextPage(), nullValue());
    }

    @Test
    public void testDeserializationPaging() throws Exception {
        final InputStream stream = getClass().getResourceAsStream("/dataload/processes/schedules_page1.json");
        final Schedules schedules = new ObjectMapper().readValue(stream, Schedules.class);

        assertThat(schedules.getItems(), notNullValue());
        assertThat(schedules.getItems(), hasSize(1));
        assertThat(schedules.getItems().get(0).getId(), is("schedule_id_1"));
        assertThat(schedules.getItems().get(0).getType(), is("MSETL"));
        assertThat(schedules.getNextPage(), notNullValue());
        assertThat(schedules.getNextPage().getPageUri(null).toString(), is("/gdc/projects/PROJECT_ID/schedules?offset=1&limit=1"));
    }
}