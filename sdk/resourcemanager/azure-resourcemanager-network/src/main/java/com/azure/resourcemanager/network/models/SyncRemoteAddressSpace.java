// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SyncRemoteAddressSpace. */
public final class SyncRemoteAddressSpace extends ExpandableStringEnum<SyncRemoteAddressSpace> {
    /** Static value true for SyncRemoteAddressSpace. */
    public static final SyncRemoteAddressSpace TRUE = fromString("true");

    /**
     * Creates or finds a SyncRemoteAddressSpace from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SyncRemoteAddressSpace.
     */
    @JsonCreator
    public static SyncRemoteAddressSpace fromString(String name) {
        return fromString(name, SyncRemoteAddressSpace.class);
    }

    /**
     * Gets known SyncRemoteAddressSpace values.
     *
     * @return known SyncRemoteAddressSpace values.
     */
    public static Collection<SyncRemoteAddressSpace> values() {
        return values(SyncRemoteAddressSpace.class);
    }
}
