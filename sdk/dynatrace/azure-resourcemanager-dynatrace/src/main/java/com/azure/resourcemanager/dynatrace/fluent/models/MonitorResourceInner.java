// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dynatrace.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.dynatrace.models.DynatraceEnvironmentProperties;
import com.azure.resourcemanager.dynatrace.models.IdentityProperties;
import com.azure.resourcemanager.dynatrace.models.LiftrResourceCategories;
import com.azure.resourcemanager.dynatrace.models.MarketplaceSubscriptionStatus;
import com.azure.resourcemanager.dynatrace.models.MonitoringStatus;
import com.azure.resourcemanager.dynatrace.models.PlanData;
import com.azure.resourcemanager.dynatrace.models.ProvisioningState;
import com.azure.resourcemanager.dynatrace.models.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Dynatrace Monitor Resource. */
@Fluent
public final class MonitorResourceInner extends Resource {
    /*
     * The resource-specific properties for this resource.
     */
    @JsonProperty(value = "properties", required = true)
    private MonitorProperties innerProperties = new MonitorProperties();

    /*
     * System metadata for this resource.
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /*
     * The managed service identities assigned to this resource.
     */
    @JsonProperty(value = "identity")
    private IdentityProperties identity;

    /**
     * Get the innerProperties property: The resource-specific properties for this resource.
     *
     * @return the innerProperties value.
     */
    private MonitorProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: System metadata for this resource.
     *
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the identity property: The managed service identities assigned to this resource.
     *
     * @return the identity value.
     */
    public IdentityProperties identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The managed service identities assigned to this resource.
     *
     * @param identity the identity value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withIdentity(IdentityProperties identity) {
        this.identity = identity;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public MonitorResourceInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public MonitorResourceInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the monitoringStatus property: Status of the monitor.
     *
     * @return the monitoringStatus value.
     */
    public MonitoringStatus monitoringStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().monitoringStatus();
    }

    /**
     * Set the monitoringStatus property: Status of the monitor.
     *
     * @param monitoringStatus the monitoringStatus value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withMonitoringStatus(MonitoringStatus monitoringStatus) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MonitorProperties();
        }
        this.innerProperties().withMonitoringStatus(monitoringStatus);
        return this;
    }

    /**
     * Get the marketplaceSubscriptionStatus property: Marketplace subscription status.
     *
     * @return the marketplaceSubscriptionStatus value.
     */
    public MarketplaceSubscriptionStatus marketplaceSubscriptionStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().marketplaceSubscriptionStatus();
    }

    /**
     * Set the marketplaceSubscriptionStatus property: Marketplace subscription status.
     *
     * @param marketplaceSubscriptionStatus the marketplaceSubscriptionStatus value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withMarketplaceSubscriptionStatus(
        MarketplaceSubscriptionStatus marketplaceSubscriptionStatus) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MonitorProperties();
        }
        this.innerProperties().withMarketplaceSubscriptionStatus(marketplaceSubscriptionStatus);
        return this;
    }

    /**
     * Get the dynatraceEnvironmentProperties property: Properties of the Dynatrace environment.
     *
     * @return the dynatraceEnvironmentProperties value.
     */
    public DynatraceEnvironmentProperties dynatraceEnvironmentProperties() {
        return this.innerProperties() == null ? null : this.innerProperties().dynatraceEnvironmentProperties();
    }

    /**
     * Set the dynatraceEnvironmentProperties property: Properties of the Dynatrace environment.
     *
     * @param dynatraceEnvironmentProperties the dynatraceEnvironmentProperties value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withDynatraceEnvironmentProperties(
        DynatraceEnvironmentProperties dynatraceEnvironmentProperties) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MonitorProperties();
        }
        this.innerProperties().withDynatraceEnvironmentProperties(dynatraceEnvironmentProperties);
        return this;
    }

    /**
     * Get the userInfo property: User info.
     *
     * @return the userInfo value.
     */
    public UserInfo userInfo() {
        return this.innerProperties() == null ? null : this.innerProperties().userInfo();
    }

    /**
     * Set the userInfo property: User info.
     *
     * @param userInfo the userInfo value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withUserInfo(UserInfo userInfo) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MonitorProperties();
        }
        this.innerProperties().withUserInfo(userInfo);
        return this;
    }

    /**
     * Get the planData property: Billing plan information.
     *
     * @return the planData value.
     */
    public PlanData planData() {
        return this.innerProperties() == null ? null : this.innerProperties().planData();
    }

    /**
     * Set the planData property: Billing plan information.
     *
     * @param planData the planData value to set.
     * @return the MonitorResourceInner object itself.
     */
    public MonitorResourceInner withPlanData(PlanData planData) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MonitorProperties();
        }
        this.innerProperties().withPlanData(planData);
        return this;
    }

    /**
     * Get the liftrResourceCategory property: Liftr Resource category.
     *
     * @return the liftrResourceCategory value.
     */
    public LiftrResourceCategories liftrResourceCategory() {
        return this.innerProperties() == null ? null : this.innerProperties().liftrResourceCategory();
    }

    /**
     * Get the liftrResourcePreference property: The priority of the resource.
     *
     * @return the liftrResourcePreference value.
     */
    public Integer liftrResourcePreference() {
        return this.innerProperties() == null ? null : this.innerProperties().liftrResourcePreference();
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property innerProperties in model MonitorResourceInner"));
        } else {
            innerProperties().validate();
        }
        if (identity() != null) {
            identity().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MonitorResourceInner.class);
}
