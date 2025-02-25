// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.models.ClientScriptForConnect;
import com.azure.resourcemanager.recoveryservicesbackup.models.InstantItemRecoveryTarget;
import com.azure.resourcemanager.recoveryservicesbackup.models.OperationStatusProvisionIlrExtendedInfo;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class OperationStatusProvisionIlrExtendedInfoTests {
    @Test
    public void testDeserialize() {
        OperationStatusProvisionIlrExtendedInfo model =
            BinaryData
                .fromString(
                    "{\"objectType\":\"OperationStatusProvisionILRExtendedInfo\",\"recoveryTarget\":{\"clientScripts\":[{\"scriptContent\":\"ldoychi\",\"scriptExtension\":\"cecfehuwaoaguh\",\"osType\":\"qllizstac\",\"url\":\"vhrweftkwqejpmv\",\"scriptNameSuffix\":\"ehaepwamcxtc\"},{\"scriptContent\":\"upeuknijduyye\",\"scriptExtension\":\"ydjfb\",\"osType\":\"yv\",\"url\":\"ulrtywikdmh\",\"scriptNameSuffix\":\"kuflgbh\"}]}}")
                .toObject(OperationStatusProvisionIlrExtendedInfo.class);
        Assertions.assertEquals("ldoychi", model.recoveryTarget().clientScripts().get(0).scriptContent());
        Assertions.assertEquals("cecfehuwaoaguh", model.recoveryTarget().clientScripts().get(0).scriptExtension());
        Assertions.assertEquals("qllizstac", model.recoveryTarget().clientScripts().get(0).osType());
        Assertions.assertEquals("vhrweftkwqejpmv", model.recoveryTarget().clientScripts().get(0).url());
        Assertions.assertEquals("ehaepwamcxtc", model.recoveryTarget().clientScripts().get(0).scriptNameSuffix());
    }

    @Test
    public void testSerialize() {
        OperationStatusProvisionIlrExtendedInfo model =
            new OperationStatusProvisionIlrExtendedInfo()
                .withRecoveryTarget(
                    new InstantItemRecoveryTarget()
                        .withClientScripts(
                            Arrays
                                .asList(
                                    new ClientScriptForConnect()
                                        .withScriptContent("ldoychi")
                                        .withScriptExtension("cecfehuwaoaguh")
                                        .withOsType("qllizstac")
                                        .withUrl("vhrweftkwqejpmv")
                                        .withScriptNameSuffix("ehaepwamcxtc"),
                                    new ClientScriptForConnect()
                                        .withScriptContent("upeuknijduyye")
                                        .withScriptExtension("ydjfb")
                                        .withOsType("yv")
                                        .withUrl("ulrtywikdmh")
                                        .withScriptNameSuffix("kuflgbh"))));
        model = BinaryData.fromObject(model).toObject(OperationStatusProvisionIlrExtendedInfo.class);
        Assertions.assertEquals("ldoychi", model.recoveryTarget().clientScripts().get(0).scriptContent());
        Assertions.assertEquals("cecfehuwaoaguh", model.recoveryTarget().clientScripts().get(0).scriptExtension());
        Assertions.assertEquals("qllizstac", model.recoveryTarget().clientScripts().get(0).osType());
        Assertions.assertEquals("vhrweftkwqejpmv", model.recoveryTarget().clientScripts().get(0).url());
        Assertions.assertEquals("ehaepwamcxtc", model.recoveryTarget().clientScripts().get(0).scriptNameSuffix());
    }
}
