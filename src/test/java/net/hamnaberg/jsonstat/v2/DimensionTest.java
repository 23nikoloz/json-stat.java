package net.hamnaberg.jsonstat.v2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.common.collect.ImmutableMap;
import net.hamnaberg.jsonstat.JsonStatModule;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hadrien on 07/06/16.
 */
public class DimensionTest {

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeMethod
    public void setUp() throws Exception {
        // TODO
        mapper.registerModule(new JsonStatModule());
        mapper.registerModule(new Jdk8Module().configureAbsentsAsNulls(true));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Test
    public void testSerialize() throws Exception {

        Dimension dimension = Dimension.create("test")
                .withIndexedLabels(ImmutableMap.of(
                        "test", "test label",
                        "test2", "test label2"
                )).build();

        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, dimension);

    }

    @Test
    public void testDeserialize() throws Exception {

    }

}