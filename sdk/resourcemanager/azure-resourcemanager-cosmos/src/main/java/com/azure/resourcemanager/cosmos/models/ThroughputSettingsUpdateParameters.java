// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.cosmos.fluent.models.ThroughputSettingsUpdateProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Parameters to update Cosmos DB resource throughput. */
@Fluent
public final class ThroughputSettingsUpdateParameters extends ArmResourceProperties {
    /*
     * Properties to update Azure Cosmos DB resource throughput.
     */
    @JsonProperty(value = "properties", required = true)
    private ThroughputSettingsUpdateProperties innerProperties = new ThroughputSettingsUpdateProperties();

    /**
     * Get the innerProperties property: Properties to update Azure Cosmos DB resource throughput.
     *
     * @return the innerProperties value.
     */
    private ThroughputSettingsUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public ThroughputSettingsUpdateParameters withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ThroughputSettingsUpdateParameters withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the resource property: The standard JSON format of a resource throughput.
     *
     * @return the resource value.
     */
    public ThroughputSettingsResource resource() {
        return this.innerProperties() == null ? null : this.innerProperties().resource();
    }

    /**
     * Set the resource property: The standard JSON format of a resource throughput.
     *
     * @param resource the resource value to set.
     * @return the ThroughputSettingsUpdateParameters object itself.
     */
    public ThroughputSettingsUpdateParameters withResource(ThroughputSettingsResource resource) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ThroughputSettingsUpdateProperties();
        }
        this.innerProperties().withResource(resource);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property innerProperties in model ThroughputSettingsUpdateParameters"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ThroughputSettingsUpdateParameters.class);
}
