// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.Context;
import com.azure.resourcemanager.avs.models.ScriptOutputStreamType;
import java.util.Arrays;

/** Samples for ScriptExecutions GetExecutionLogs. */
public final class ScriptExecutionsGetExecutionLogsSamples {
    /*
     * x-ms-original-file: specification/vmware/resource-manager/Microsoft.AVS/stable/2022-05-01/examples/ScriptExecutions_GetExecutionLogs.json
     */
    /**
     * Sample code: ScriptExecutions_GetExecutionLogs.
     *
     * @param manager Entry point to AvsManager.
     */
    public static void scriptExecutionsGetExecutionLogs(com.azure.resourcemanager.avs.AvsManager manager) {
        manager
            .scriptExecutions()
            .getExecutionLogsWithResponse(
                "group1",
                "cloud1",
                "addSsoServer",
                Arrays
                    .asList(
                        ScriptOutputStreamType.INFORMATION,
                        ScriptOutputStreamType.fromString("Warnings"),
                        ScriptOutputStreamType.fromString("Errors"),
                        ScriptOutputStreamType.OUTPUT),
                Context.NONE);
    }
}
