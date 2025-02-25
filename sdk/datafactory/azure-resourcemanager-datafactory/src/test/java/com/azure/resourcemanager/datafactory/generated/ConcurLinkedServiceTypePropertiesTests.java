// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.ConcurLinkedServiceTypeProperties;
import com.azure.resourcemanager.datafactory.models.SecretBase;
import org.junit.jupiter.api.Test;

public final class ConcurLinkedServiceTypePropertiesTests {
    @Test
    public void testDeserialize() {
        ConcurLinkedServiceTypeProperties model =
            BinaryData
                .fromString("{\"password\":{\"type\":\"SecretBase\"}}")
                .toObject(ConcurLinkedServiceTypeProperties.class);
    }

    @Test
    public void testSerialize() {
        ConcurLinkedServiceTypeProperties model =
            new ConcurLinkedServiceTypeProperties().withPassword(new SecretBase());
        model = BinaryData.fromObject(model).toObject(ConcurLinkedServiceTypeProperties.class);
    }
}
