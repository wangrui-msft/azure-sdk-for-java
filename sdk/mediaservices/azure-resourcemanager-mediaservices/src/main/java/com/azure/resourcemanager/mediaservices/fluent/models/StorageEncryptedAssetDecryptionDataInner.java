// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.resourcemanager.mediaservices.models.AssetFileEncryptionMetadata;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Data needed to decrypt asset files encrypted with legacy storage encryption. */
@Fluent
public final class StorageEncryptedAssetDecryptionDataInner {
    /*
     * The Asset File storage encryption key.
     */
    @JsonProperty(value = "key")
    private byte[] key;

    /*
     * Asset File encryption metadata.
     */
    @JsonProperty(value = "assetFileEncryptionMetadata")
    private List<AssetFileEncryptionMetadata> assetFileEncryptionMetadata;

    /**
     * Get the key property: The Asset File storage encryption key.
     *
     * @return the key value.
     */
    public byte[] key() {
        return CoreUtils.clone(this.key);
    }

    /**
     * Set the key property: The Asset File storage encryption key.
     *
     * @param key the key value to set.
     * @return the StorageEncryptedAssetDecryptionDataInner object itself.
     */
    public StorageEncryptedAssetDecryptionDataInner withKey(byte[] key) {
        this.key = CoreUtils.clone(key);
        return this;
    }

    /**
     * Get the assetFileEncryptionMetadata property: Asset File encryption metadata.
     *
     * @return the assetFileEncryptionMetadata value.
     */
    public List<AssetFileEncryptionMetadata> assetFileEncryptionMetadata() {
        return this.assetFileEncryptionMetadata;
    }

    /**
     * Set the assetFileEncryptionMetadata property: Asset File encryption metadata.
     *
     * @param assetFileEncryptionMetadata the assetFileEncryptionMetadata value to set.
     * @return the StorageEncryptedAssetDecryptionDataInner object itself.
     */
    public StorageEncryptedAssetDecryptionDataInner withAssetFileEncryptionMetadata(
        List<AssetFileEncryptionMetadata> assetFileEncryptionMetadata) {
        this.assetFileEncryptionMetadata = assetFileEncryptionMetadata;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (assetFileEncryptionMetadata() != null) {
            assetFileEncryptionMetadata().forEach(e -> e.validate());
        }
    }
}
