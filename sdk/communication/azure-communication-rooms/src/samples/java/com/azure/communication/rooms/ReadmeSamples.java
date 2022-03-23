// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.rooms;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.azure.communication.rooms.models.CommunicationRoom;
import com.azure.communication.rooms.models.RoomParticipant;
import com.azure.communication.rooms.models.RoomRequest;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class ReadmeSamples {

    public RoomsClient createRoomsClientUsingAzureKeyCredential() {
        // You can find your endpoint and access key from your resource in the Azure
        // Portal
        String endpoint = "https://<resource-name>.communication.azure.com";
        AzureKeyCredential azureKeyCredential = new AzureKeyCredential("<access-key>");

        RoomsClient roomsClient = new RoomsClientBuilder().endpoint(endpoint).credential(azureKeyCredential)
                .buildClient();

        return roomsClient;
    }

    public RoomsAsyncClient createRoomsAsyncClientUsingAzureKeyCredential() {
        // You can find your endpoint and access key from your resource in the Azure
        // Portal
        String endpoint = "https://<resource-name>.communication.azure.com";
        AzureKeyCredential azureKeyCredential = new AzureKeyCredential("<access-key>");

        RoomsAsyncClient roomsClient = new RoomsClientBuilder().endpoint(endpoint).credential(azureKeyCredential)
                .buildAsyncClient();

        return roomsClient;
    }

    public RoomsClient createRoomsClientWithConnectionString() {
        // You can find your connection string from your resource in the Azure Portal
        String connectionString = "https://<resource-name>.communication.azure.com/;<access-key>";

        RoomsClient roomsClient = new RoomsClientBuilder().connectionString(connectionString).buildClient();

        return roomsClient;
    }

    public RoomsClient createRoomsClientWithAAD() {
        // You can find your endpoint and access key from your resource in the Azure
        // Portal
        String endpoint = "https://<RESOURCE_NAME>.communication.azure.com";

        RoomsClient roomsClient = new RoomsClientBuilder().endpoint(endpoint)
                .credential(new DefaultAzureCredentialBuilder().build()).buildClient();

        return roomsClient;
    }

    public RoomsClient createSyncClientUsingTokenCredential() {
        TokenCredential tokenCredential = new DefaultAzureCredentialBuilder().build();
        // You can find your endpoint and access key from your resource in the Azure
        // Portal
        String endpoint = "https://<RESOURCE_NAME>.communication.azure.com";

        RoomsClient roomsClient = new RoomsClientBuilder().endpoint(endpoint).credential(tokenCredential).buildClient();
        return roomsClient;
    }

    public void createRoomWithValidInput() {
        RoomRequest request = new RoomRequest();
        OffsetDateTime validFrom = OffsetDateTime.of(2021, 8, 1, 5, 30, 20, 10, ZoneOffset.UTC);
        OffsetDateTime validUntil = OffsetDateTime.of(2021, 9, 1, 5, 30, 20, 10, ZoneOffset.UTC);
        Map<String, Object> participants = new HashMap<>();
        // Add two participants
        participants.put("<ACS User MRI identity 1>", new RoomParticipant());
        participants.put("<ACS User MRI identity 2>", new RoomParticipant());
        request.setValidFrom(validFrom);
        request.setValidUntil(validUntil);
        request.setParticipants(participants);

        RoomsClient roomsClient = createRoomsClientWithConnectionString();
        CommunicationRoom roomResult = roomsClient.createRoom(request);
        System.out.println("Room Id: " + roomResult.getRoomId());
    }

    public void updateRoomWithRoomId() {
        RoomRequest request = new RoomRequest();
        OffsetDateTime validFrom = OffsetDateTime.of(2021, 8, 1, 5, 30, 20, 10, ZoneOffset.UTC);
        OffsetDateTime validUntil = OffsetDateTime.of(2021, 9, 1, 5, 30, 20, 10, ZoneOffset.UTC);
        Map<String, Object> participants = new HashMap<>();
        participants.put("<ACS User MRI identity 1>", new RoomParticipant());
        // Delete one participant
        participants.put("<ACS User MRI identity 2>", null);
        request.setValidFrom(validFrom);
        request.setValidUntil(validUntil);
        request.setParticipants(participants);

        RoomsClient roomsClient = createRoomsClientWithConnectionString();

        try {
            CommunicationRoom roomResult = roomsClient.updateRoom("<Room Id in String>", request);
            System.out.println("Room Id: " + roomResult.getRoomId());

        } catch (RuntimeException ex) {
            System.out.println(ex);
        }

    }

    public void getRoomWithRoomId() {
        RoomsClient roomsClient = createRoomsClientWithConnectionString();
        try {
            CommunicationRoom roomResult = roomsClient.getRoom("<Room Id in String>");
            System.out.println("Room Id: " + roomResult.getRoomId());
        } catch (RuntimeException ex) {
            System.out.println(ex);
        }

    }

    public void deleteRoomWithRoomId() {
        RoomsClient roomsClient = createRoomsClientWithConnectionString();
        try {
            roomsClient.deleteRoomWithResponse("<Room Id in String>", Context.NONE);
        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
    }

    public void addRoomWithRoomId() {
        String user1 = "8:acs:b6372803-0c35-4ec0-833b-c19b798cef1d_0000000e-3240-55cf-9806-113a0d001dd9";
        String user2 = "8:acs:b6372803-0c35-4ec0-833b-c19b798cef1d_0000001e-322a-f9f7-740a-113a0d00ee19";
        String user3 = "8:acs:b6372803-0c35-4ec0-833b-c19b798cef1d_0000002e-5609-f66d-defd-8b3a0d002749";
    
        Set<String> participants = new HashSet<String>(Arrays.asList(user1, user2, user3));

        RoomsClient roomsClient = createRoomsClientWithConnectionString();

        try {
            CommunicationRoom addedParticipantRoom =  roomsClient.addParticipants("<Room Id>", participants);
            System.out.println("Room Id: " + addedParticipantRoom.getRoomId());

        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
    }

    public void removeRoomWithRoomId() {
        String user1 = "8:acs:b6372803-0c35-4ec0-833b-c19b798cef1d_0000000e-3240-55cf-9806-113a0d001dd9";
        String user2 = "8:acs:b6372803-0c35-4ec0-833b-c19b798cef1d_0000001e-322a-f9f7-740a-113a0d00ee19";
    
        Set<String> participants = new HashSet<String>(Arrays.asList(user1, user2));

        RoomsClient roomsClient = createRoomsClientWithConnectionString();

        try {
            CommunicationRoom removedParticipantRoom =  roomsClient.removeParticipants("<Room Id>", participants);
            System.out.println("Room Id: " + removedParticipantRoom.getRoomId());

        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
    }

    public void deleteAllParticipantsWithEmptyPayload() {    
        Map<String, Object> participants = new HashMap<>();
        RoomRequest roomRequest = new RoomRequest();
        roomRequest.setParticipants(participants);
        RoomsClient roomsClient = createRoomsClientWithConnectionString();
        try {
            CommunicationRoom deleteAllParticipantsRoom =  roomsClient.updateRoom("<Room Id>", roomRequest);
            System.out.println("Room Id: " + deleteAllParticipantsRoom.getRoomId());
        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
    }

    public void createRoomTroubleShooting() {
        RoomsClient roomsClient = createRoomsClientWithConnectionString();
        try {
            RoomRequest request = new RoomRequest();
            OffsetDateTime validFrom = OffsetDateTime.of(2021, 9, 1, 5, 30, 20, 10, ZoneOffset.UTC);
            OffsetDateTime validUntil = OffsetDateTime.of(2021, 8, 1, 5, 30, 20, 10, ZoneOffset.UTC);
            Map<String, Object> participants = new HashMap<>();

            request.setValidFrom(validFrom);
            request.setValidUntil(validUntil);
            request.setParticipants(participants);
            Response<CommunicationRoom> roomResult = roomsClient.createRoomWithResponse(request, null);

            if (roomResult.getStatusCode() == 201) {
                System.out.println("Successfully create the room: " + roomResult.getValue().getRoomId());
            } else {
                System.out.println("Error Happened at create room request: " + roomResult.getStatusCode());
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
