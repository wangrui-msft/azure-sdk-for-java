// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** The access key to regenerate. */
public final class KeyKind extends ExpandableStringEnum<KeyKind> {
    /** Static value primary for KeyKind. */
    public static final KeyKind PRIMARY = fromString("primary");

    /** Static value secondary for KeyKind. */
    public static final KeyKind SECONDARY = fromString("secondary");

    /** Static value primaryReadonly for KeyKind. */
    public static final KeyKind PRIMARY_READONLY = fromString("primaryReadonly");

    /** Static value secondaryReadonly for KeyKind. */
    public static final KeyKind SECONDARY_READONLY = fromString("secondaryReadonly");

    /**
     * Creates or finds a KeyKind from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding KeyKind.
     */
    @JsonCreator
    public static KeyKind fromString(String name) {
        return fromString(name, KeyKind.class);
    }

    /**
     * Gets known KeyKind values.
     *
     * @return known KeyKind values.
     */
    public static Collection<KeyKind> values() {
        return values(KeyKind.class);
    }
}
