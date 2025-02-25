// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureSqlSink;
import com.azure.resourcemanager.datafactory.models.SqlUpsertSettings;
import org.junit.jupiter.api.Test;

public final class AzureSqlSinkTests {
    @Test
    public void testDeserialize() {
        AzureSqlSink model =
            BinaryData
                .fromString("{\"type\":\"AzureSqlSink\",\"upsertSettings\":{},\"\":{}}")
                .toObject(AzureSqlSink.class);
    }

    @Test
    public void testSerialize() {
        AzureSqlSink model = new AzureSqlSink().withUpsertSettings(new SqlUpsertSettings());
        model = BinaryData.fromObject(model).toObject(AzureSqlSink.class);
    }
}
