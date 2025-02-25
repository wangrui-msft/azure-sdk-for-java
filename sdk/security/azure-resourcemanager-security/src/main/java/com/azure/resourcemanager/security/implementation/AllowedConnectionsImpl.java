// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.security.fluent.AllowedConnectionsClient;
import com.azure.resourcemanager.security.fluent.models.AllowedConnectionsResourceInner;
import com.azure.resourcemanager.security.models.AllowedConnections;
import com.azure.resourcemanager.security.models.AllowedConnectionsResource;
import com.azure.resourcemanager.security.models.ConnectionType;

public final class AllowedConnectionsImpl implements AllowedConnections {
    private static final ClientLogger LOGGER = new ClientLogger(AllowedConnectionsImpl.class);

    private final AllowedConnectionsClient innerClient;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    public AllowedConnectionsImpl(
        AllowedConnectionsClient innerClient, com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<AllowedConnectionsResource> list() {
        PagedIterable<AllowedConnectionsResourceInner> inner = this.serviceClient().list();
        return Utils.mapPage(inner, inner1 -> new AllowedConnectionsResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<AllowedConnectionsResource> list(Context context) {
        PagedIterable<AllowedConnectionsResourceInner> inner = this.serviceClient().list(context);
        return Utils.mapPage(inner, inner1 -> new AllowedConnectionsResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<AllowedConnectionsResource> listByHomeRegion(String ascLocation) {
        PagedIterable<AllowedConnectionsResourceInner> inner = this.serviceClient().listByHomeRegion(ascLocation);
        return Utils.mapPage(inner, inner1 -> new AllowedConnectionsResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<AllowedConnectionsResource> listByHomeRegion(String ascLocation, Context context) {
        PagedIterable<AllowedConnectionsResourceInner> inner =
            this.serviceClient().listByHomeRegion(ascLocation, context);
        return Utils.mapPage(inner, inner1 -> new AllowedConnectionsResourceImpl(inner1, this.manager()));
    }

    public AllowedConnectionsResource get(String resourceGroupName, String ascLocation, ConnectionType connectionType) {
        AllowedConnectionsResourceInner inner =
            this.serviceClient().get(resourceGroupName, ascLocation, connectionType);
        if (inner != null) {
            return new AllowedConnectionsResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<AllowedConnectionsResource> getWithResponse(
        String resourceGroupName, String ascLocation, ConnectionType connectionType, Context context) {
        Response<AllowedConnectionsResourceInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, ascLocation, connectionType, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new AllowedConnectionsResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private AllowedConnectionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }
}
