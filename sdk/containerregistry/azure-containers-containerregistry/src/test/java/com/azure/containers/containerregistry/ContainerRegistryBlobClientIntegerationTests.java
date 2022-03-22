// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.containers.containerregistry;

import com.azure.containers.containerregistry.models.OciAnnotations;
import com.azure.containers.containerregistry.models.OciBlobDescriptor;
import com.azure.containers.containerregistry.models.OciManifest;
import com.azure.containers.containerregistry.models.UploadBlobResult;
import com.azure.containers.containerregistry.models.UploadManifestResult;

import com.azure.containers.containerregistry.specialized.ContainerRegistryBlobClient;
import com.azure.core.http.HttpClient;
import com.azure.core.util.BinaryData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.azure.containers.containerregistry.TestUtils.DISPLAY_NAME_WITH_ARGUMENTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContainerRegistryBlobClientIntegerationTests extends ContainerRegistryClientsTestBase {
    private ContainerRegistryBlobClient client;

    private ContainerRegistryBlobClient getBlobClient(String repositoryName, HttpClient httpClient) {
        return getBlobClientBuilder(repositoryName, httpClient).buildClient();
    }

    private OciManifest createManifest() {
        OciManifest manifest = new OciManifest()
            .setSchemaVersion(2)
            .setConfig(new OciBlobDescriptor()
                .setMediaType("application/vnd.acme.rocket.config.v1+json")
                .setDigest(configDigest)
                .setSize(41L));


        List<OciBlobDescriptor> layers = new ArrayList<>();

        layers.add(new OciBlobDescriptor()
            .setMediaType("text/plain")
            .setSize(16L)
            .setDigest(layerDigest)
            .setAnnotations(new OciAnnotations()
                .setName("artifact.txt")));

        manifest.setLayers(layers);

        return manifest;
    }

    private String configDigest;
    private String layerDigest;
    private String manifestDigest;

    private void uploadManifestPrerequisites() {
        String layer = "artifact.txt";
        String config = "config.json";
        Path configPath = Paths.get("src", "test", "resources", "oci-artifact", config);
        Path layerPath = Paths.get("src", "test", "resources", "oci-artifact", layer);


        UploadBlobResult result = client.uploadBlob(BinaryData.fromFile(configPath));
        configDigest = result.getDigest();

        result = client.uploadBlob(BinaryData.fromFile(layerPath));
        layerDigest = result.getDigest();
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("getHttpClients")
    // @EnabledOnOs(value = {OS.WINDOWS}, disabledReason = "OCI manifest are OS specific. Will need another test for Linux and Mac.")
    public void uploadManifest(HttpClient httpClient) {
        client = getBlobClient("oci-artifact", httpClient);

        try {
            uploadManifestPrerequisites();
            OciManifest manifest = createManifest();

            UploadManifestResult result = client.uploadManifest(manifest);
            assertNotNull(result);
            assertNotNull(result.getDigest());
            manifestDigest = result.getDigest();
        }
        finally {
            if(configDigest != null) {
                client.deleteBlob(configDigest);
            }

            if(layerDigest != null) {
                client.deleteBlob(layerDigest);
            }
            if(manifestDigest != null) {
                client.deleteManifest(manifestDigest);
            }
        }
    }
}
