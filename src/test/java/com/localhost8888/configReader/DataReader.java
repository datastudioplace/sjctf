package com.localhost8888.configReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class DataReader {

  public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
    // read json to string
    String jsonContent =
        FileUtils.readFileToString(
            new File(
                System.getProperty("user.dir")
                    + "//src//test//java//localhost8888//testData//jsonFiles//PurchaseOrder.json"),
            StandardCharsets.UTF_8);

    // String to HashMap- Jackson DataBind

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

    // {map, map}

  }
}
