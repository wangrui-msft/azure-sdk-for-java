// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of ScalingPlans. */
public interface ScalingPlans {
    /**
     * Get a scaling plan.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scalingPlanName The name of the scaling plan.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a scaling plan.
     */
    ScalingPlan getByResourceGroup(String resourceGroupName, String scalingPlanName);

    /**
     * Get a scaling plan.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scalingPlanName The name of the scaling plan.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a scaling plan along with {@link Response}.
     */
    Response<ScalingPlan> getByResourceGroupWithResponse(
        String resourceGroupName, String scalingPlanName, Context context);

    /**
     * Remove a scaling plan.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scalingPlanName The name of the scaling plan.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByResourceGroup(String resourceGroupName, String scalingPlanName);

    /**
     * Remove a scaling plan.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param scalingPlanName The name of the scaling plan.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroupName, String scalingPlanName, Context context);

    /**
     * List scaling plans.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> listByResourceGroup(String resourceGroupName);

    /**
     * List scaling plans.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List scaling plans in subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> list();

    /**
     * List scaling plans in subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> list(Context context);

    /**
     * List scaling plan associated with hostpool.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param hostPoolName The name of the host pool within the specified resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> listByHostPool(String resourceGroupName, String hostPoolName);

    /**
     * List scaling plan associated with hostpool.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param hostPoolName The name of the host pool within the specified resource group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return scalingPlanList as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ScalingPlan> listByHostPool(String resourceGroupName, String hostPoolName, Context context);

    /**
     * Get a scaling plan.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a scaling plan along with {@link Response}.
     */
    ScalingPlan getById(String id);

    /**
     * Get a scaling plan.
     *
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a scaling plan along with {@link Response}.
     */
    Response<ScalingPlan> getByIdWithResponse(String id, Context context);

    /**
     * Remove a scaling plan.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Remove a scaling plan.
     *
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new ScalingPlan resource.
     *
     * @param name resource name.
     * @return the first stage of the new ScalingPlan definition.
     */
    ScalingPlan.DefinitionStages.Blank define(String name);
}
