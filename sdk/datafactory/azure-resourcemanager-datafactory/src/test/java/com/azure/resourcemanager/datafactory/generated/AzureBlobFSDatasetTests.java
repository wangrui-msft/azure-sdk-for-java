// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureBlobFSDataset;
import com.azure.resourcemanager.datafactory.models.DatasetCompression;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.DatasetStorageFormat;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class AzureBlobFSDatasetTests {
    @Test
    public void testDeserialize() {
        AzureBlobFSDataset model =
            BinaryData
                .fromString(
                    "{\"type\":\"AzureBlobFSFile\",\"typeProperties\":{\"format\":{\"type\":\"DatasetStorageFormat\",\"\":{}},\"compression\":{\"\":{}}},\"description\":\"kkshkbffm\",\"linkedServiceName\":{\"referenceName\":\"zjrgyww\",\"parameters\":{}},\"parameters\":{\"tf\":{\"type\":\"Bool\"},\"icgaao\":{\"type\":\"Bool\"},\"taqutdewem\":{\"type\":\"Array\"},\"vru\":{\"type\":\"SecureString\"}},\"annotations\":[],\"folder\":{\"name\":\"gehkfkimrtixokff\"},\"\":{}}")
                .toObject(AzureBlobFSDataset.class);
        Assertions.assertEquals("kkshkbffm", model.description());
        Assertions.assertEquals("zjrgyww", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.BOOL, model.parameters().get("tf").type());
        Assertions.assertEquals("gehkfkimrtixokff", model.folder().name());
    }

    @Test
    public void testSerialize() {
        AzureBlobFSDataset model =
            new AzureBlobFSDataset()
                .withDescription("kkshkbffm")
                .withLinkedServiceName(
                    new LinkedServiceReference().withReferenceName("zjrgyww").withParameters(mapOf()))
                .withParameters(
                    mapOf(
                        "tf",
                        new ParameterSpecification().withType(ParameterType.BOOL),
                        "icgaao",
                        new ParameterSpecification().withType(ParameterType.BOOL),
                        "taqutdewem",
                        new ParameterSpecification().withType(ParameterType.ARRAY),
                        "vru",
                        new ParameterSpecification().withType(ParameterType.SECURE_STRING)))
                .withAnnotations(Arrays.asList())
                .withFolder(new DatasetFolder().withName("gehkfkimrtixokff"))
                .withFormat(new DatasetStorageFormat().withAdditionalProperties(mapOf("type", "DatasetStorageFormat")))
                .withCompression(new DatasetCompression().withAdditionalProperties(mapOf()));
        model = BinaryData.fromObject(model).toObject(AzureBlobFSDataset.class);
        Assertions.assertEquals("kkshkbffm", model.description());
        Assertions.assertEquals("zjrgyww", model.linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.BOOL, model.parameters().get("tf").type());
        Assertions.assertEquals("gehkfkimrtixokff", model.folder().name());
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
