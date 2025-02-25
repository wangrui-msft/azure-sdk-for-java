// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.MongoDbCollectionDataset;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class MongoDbCollectionDatasetTests {
    @Test
    public void testDeserialize() {
        MongoDbCollectionDataset model =
            BinaryData
                .fromString(
                    "{\"type\":\"MongoDbCollection\",\"typeProperties\":{},\"description\":\"hflzokxco\",\"linkedServiceName\":{\"referenceName\":\"lnjetaglt\",\"parameters\":{}},\"parameters\":{\"g\":{\"type\":\"String\"}},\"annotations\":[],\"folder\":{\"name\":\"swvefloccsrmoz\"},\"\":{}}")
                .toObject(MongoDbCollectionDataset.class);
        Assertions.assertEquals("hflzokxco", model.description());
        Assertions.assertEquals("lnjetaglt", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.STRING, model.parameters().get("g").type());
        Assertions.assertEquals("swvefloccsrmoz", model.folder().name());
    }

    @Test
    public void testSerialize() {
        MongoDbCollectionDataset model =
            new MongoDbCollectionDataset()
                .withDescription("hflzokxco")
                .withLinkedServiceName(
                    new LinkedServiceReference().withReferenceName("lnjetaglt").withParameters(mapOf()))
                .withParameters(mapOf("g", new ParameterSpecification().withType(ParameterType.STRING)))
                .withAnnotations(Arrays.asList())
                .withFolder(new DatasetFolder().withName("swvefloccsrmoz"));
        model = BinaryData.fromObject(model).toObject(MongoDbCollectionDataset.class);
        Assertions.assertEquals("hflzokxco", model.description());
        Assertions.assertEquals("lnjetaglt", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.STRING, model.parameters().get("g").type());
        Assertions.assertEquals("swvefloccsrmoz", model.folder().name());
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
