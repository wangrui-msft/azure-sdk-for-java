// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.ActivityDependency;
import com.azure.resourcemanager.datafactory.models.ActivityPolicy;
import com.azure.resourcemanager.datafactory.models.DependencyCondition;
import com.azure.resourcemanager.datafactory.models.HDInsightActivityDebugInfoOption;
import com.azure.resourcemanager.datafactory.models.HDInsightPigActivity;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.UserProperty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class HDInsightPigActivityTests {
    @Test
    public void testDeserialize() {
        HDInsightPigActivity model =
            BinaryData
                .fromString(
                    "{\"type\":\"HDInsightPig\",\"typeProperties\":{\"storageLinkedServices\":[{\"referenceName\":\"wxbsmtbl\",\"parameters\":{}},{\"referenceName\":\"ehhcifkwdv\",\"parameters\":{}}],\"getDebugInfo\":\"Always\",\"scriptLinkedService\":{\"referenceName\":\"hsqhtf\",\"parameters\":{}},\"defines\":{}},\"linkedServiceName\":{\"referenceName\":\"ejuwyqwdqigmghgi\",\"parameters\":{}},\"policy\":{\"retryIntervalInSeconds\":561302398,\"secureInput\":false,\"secureOutput\":true,\"\":{}},\"name\":\"nkfm\",\"description\":\"cqtwmlmhjnqtq\",\"dependsOn\":[{\"activity\":\"j\",\"dependencyConditions\":[\"Skipped\",\"Succeeded\",\"Skipped\",\"Completed\"],\"\":{}}],\"userProperties\":[{\"name\":\"dxe\"},{\"name\":\"hhkvguavtptbk\"},{\"name\":\"wkqyns\"},{\"name\":\"gbvoffbkk\"}],\"\":{}}")
                .toObject(HDInsightPigActivity.class);
        Assertions.assertEquals("nkfm", model.name());
        Assertions.assertEquals("cqtwmlmhjnqtq", model.description());
        Assertions.assertEquals("j", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.SKIPPED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("dxe", model.userProperties().get(0).name());
        Assertions.assertEquals("ejuwyqwdqigmghgi", model.linkedServiceName().referenceName());
        Assertions.assertEquals(561302398, model.policy().retryIntervalInSeconds());
        Assertions.assertEquals(false, model.policy().secureInput());
        Assertions.assertEquals(true, model.policy().secureOutput());
        Assertions.assertEquals("wxbsmtbl", model.storageLinkedServices().get(0).referenceName());
        Assertions.assertEquals(HDInsightActivityDebugInfoOption.ALWAYS, model.getDebugInfo());
        Assertions.assertEquals("hsqhtf", model.scriptLinkedService().referenceName());
    }

    @Test
    public void testSerialize() {
        HDInsightPigActivity model =
            new HDInsightPigActivity()
                .withName("nkfm")
                .withDescription("cqtwmlmhjnqtq")
                .withDependsOn(
                    Arrays
                        .asList(
                            new ActivityDependency()
                                .withActivity("j")
                                .withDependencyConditions(
                                    Arrays
                                        .asList(
                                            DependencyCondition.SKIPPED,
                                            DependencyCondition.SUCCEEDED,
                                            DependencyCondition.SKIPPED,
                                            DependencyCondition.COMPLETED))
                                .withAdditionalProperties(mapOf())))
                .withUserProperties(
                    Arrays
                        .asList(
                            new UserProperty().withName("dxe"),
                            new UserProperty().withName("hhkvguavtptbk"),
                            new UserProperty().withName("wkqyns"),
                            new UserProperty().withName("gbvoffbkk")))
                .withLinkedServiceName(
                    new LinkedServiceReference().withReferenceName("ejuwyqwdqigmghgi").withParameters(mapOf()))
                .withPolicy(
                    new ActivityPolicy()
                        .withRetryIntervalInSeconds(561302398)
                        .withSecureInput(false)
                        .withSecureOutput(true)
                        .withAdditionalProperties(mapOf()))
                .withStorageLinkedServices(
                    Arrays
                        .asList(
                            new LinkedServiceReference().withReferenceName("wxbsmtbl").withParameters(mapOf()),
                            new LinkedServiceReference().withReferenceName("ehhcifkwdv").withParameters(mapOf())))
                .withGetDebugInfo(HDInsightActivityDebugInfoOption.ALWAYS)
                .withScriptLinkedService(
                    new LinkedServiceReference().withReferenceName("hsqhtf").withParameters(mapOf()))
                .withDefines(mapOf());
        model = BinaryData.fromObject(model).toObject(HDInsightPigActivity.class);
        Assertions.assertEquals("nkfm", model.name());
        Assertions.assertEquals("cqtwmlmhjnqtq", model.description());
        Assertions.assertEquals("j", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.SKIPPED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("dxe", model.userProperties().get(0).name());
        Assertions.assertEquals("ejuwyqwdqigmghgi", model.linkedServiceName().referenceName());
        Assertions.assertEquals(561302398, model.policy().retryIntervalInSeconds());
        Assertions.assertEquals(false, model.policy().secureInput());
        Assertions.assertEquals(true, model.policy().secureOutput());
        Assertions.assertEquals("wxbsmtbl", model.storageLinkedServices().get(0).referenceName());
        Assertions.assertEquals(HDInsightActivityDebugInfoOption.ALWAYS, model.getDebugInfo());
        Assertions.assertEquals("hsqhtf", model.scriptLinkedService().referenceName());
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
