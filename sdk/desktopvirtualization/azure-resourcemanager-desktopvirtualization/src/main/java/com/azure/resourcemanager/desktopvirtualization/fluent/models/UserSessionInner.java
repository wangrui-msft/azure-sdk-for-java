// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.resourcemanager.desktopvirtualization.models.ApplicationType;
import com.azure.resourcemanager.desktopvirtualization.models.SessionState;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Represents a UserSession definition. */
@Fluent
public final class UserSessionInner extends ProxyResource {
    /*
     * Metadata pertaining to creation and last modification of the resource.
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /*
     * Detailed properties for UserSession
     */
    @JsonProperty(value = "properties")
    private UserSessionProperties innerProperties;

    /**
     * Get the systemData property: Metadata pertaining to creation and last modification of the resource.
     *
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the innerProperties property: Detailed properties for UserSession.
     *
     * @return the innerProperties value.
     */
    private UserSessionProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the objectId property: ObjectId of user session. (internal use).
     *
     * @return the objectId value.
     */
    public String objectId() {
        return this.innerProperties() == null ? null : this.innerProperties().objectId();
    }

    /**
     * Get the userPrincipalName property: The user principal name.
     *
     * @return the userPrincipalName value.
     */
    public String userPrincipalName() {
        return this.innerProperties() == null ? null : this.innerProperties().userPrincipalName();
    }

    /**
     * Set the userPrincipalName property: The user principal name.
     *
     * @param userPrincipalName the userPrincipalName value to set.
     * @return the UserSessionInner object itself.
     */
    public UserSessionInner withUserPrincipalName(String userPrincipalName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new UserSessionProperties();
        }
        this.innerProperties().withUserPrincipalName(userPrincipalName);
        return this;
    }

    /**
     * Get the applicationType property: Application type of application.
     *
     * @return the applicationType value.
     */
    public ApplicationType applicationType() {
        return this.innerProperties() == null ? null : this.innerProperties().applicationType();
    }

    /**
     * Set the applicationType property: Application type of application.
     *
     * @param applicationType the applicationType value to set.
     * @return the UserSessionInner object itself.
     */
    public UserSessionInner withApplicationType(ApplicationType applicationType) {
        if (this.innerProperties() == null) {
            this.innerProperties = new UserSessionProperties();
        }
        this.innerProperties().withApplicationType(applicationType);
        return this;
    }

    /**
     * Get the sessionState property: State of user session.
     *
     * @return the sessionState value.
     */
    public SessionState sessionState() {
        return this.innerProperties() == null ? null : this.innerProperties().sessionState();
    }

    /**
     * Set the sessionState property: State of user session.
     *
     * @param sessionState the sessionState value to set.
     * @return the UserSessionInner object itself.
     */
    public UserSessionInner withSessionState(SessionState sessionState) {
        if (this.innerProperties() == null) {
            this.innerProperties = new UserSessionProperties();
        }
        this.innerProperties().withSessionState(sessionState);
        return this;
    }

    /**
     * Get the activeDirectoryUsername property: The active directory user name.
     *
     * @return the activeDirectoryUsername value.
     */
    public String activeDirectoryUsername() {
        return this.innerProperties() == null ? null : this.innerProperties().activeDirectoryUsername();
    }

    /**
     * Set the activeDirectoryUsername property: The active directory user name.
     *
     * @param activeDirectoryUsername the activeDirectoryUsername value to set.
     * @return the UserSessionInner object itself.
     */
    public UserSessionInner withActiveDirectoryUsername(String activeDirectoryUsername) {
        if (this.innerProperties() == null) {
            this.innerProperties = new UserSessionProperties();
        }
        this.innerProperties().withActiveDirectoryUsername(activeDirectoryUsername);
        return this;
    }

    /**
     * Get the createTime property: The timestamp of the user session create.
     *
     * @return the createTime value.
     */
    public OffsetDateTime createTime() {
        return this.innerProperties() == null ? null : this.innerProperties().createTime();
    }

    /**
     * Set the createTime property: The timestamp of the user session create.
     *
     * @param createTime the createTime value to set.
     * @return the UserSessionInner object itself.
     */
    public UserSessionInner withCreateTime(OffsetDateTime createTime) {
        if (this.innerProperties() == null) {
            this.innerProperties = new UserSessionProperties();
        }
        this.innerProperties().withCreateTime(createTime);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
