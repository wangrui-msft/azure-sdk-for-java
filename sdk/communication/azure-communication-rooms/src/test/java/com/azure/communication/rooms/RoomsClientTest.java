// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.rooms;

import com.azure.communication.rooms.models.CommunicationRoom;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomsClientTest extends RoomsTestBase {
    private RoomsClient roomsClient;

    @Override
    protected void beforeTest() {
        super.beforeTest();
    }

    @Override
    protected void afterTest() {
        super.afterTest();
        cleanUpUsers();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createRoomSyncWithFullOperation(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "createRoomSyncWithFullOperation");
        assertNotNull(roomsClient);
        CommunicationRoom createCommunicationRoom = roomsClient.createRoom(VALID_FROM, VALID_UNTIL, participants4);
        assertHappyPath(createCommunicationRoom);
        assertEquals(createCommunicationRoom.getParticipants().size(), 2);

        String roomId = createCommunicationRoom.getRoomId();

        CommunicationRoom updateCommunicationRoom = roomsClient.updateRoom(roomId, VALID_FROM, VALID_FROM.plusMonths(4));
        assertEquals(updateCommunicationRoom.getParticipants().size(), 2);
        assertHappyPath(updateCommunicationRoom);

        CommunicationRoom addCommunicationRoom = roomsClient.addParticipants(roomId, participants6);
        assertEquals(addCommunicationRoom.getParticipants().size(), 3);
        assertHappyPath(addCommunicationRoom);

        CommunicationRoom getCommunicationRoom = roomsClient.getRoom(roomId);
        assertEquals(getCommunicationRoom.getParticipants().size(), 3);
        assertHappyPath(getCommunicationRoom);

        Response<Void> deleteResponse = roomsClient.deleteRoomWithResponse(roomId, Context.NONE);
        assertEquals(deleteResponse.getStatusCode(), 204);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createRoomSyncWithFullOperationWithResponse(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "createRoomSyncWithFullOperationWithResponse");
        assertNotNull(roomsClient);
        Response<CommunicationRoom> createdRoomResponse = roomsClient.createRoomWithResponse(VALID_FROM, VALID_UNTIL, participants4, Context.NONE);
        assertHappyPath(createdRoomResponse, 201);
        assertEquals(createdRoomResponse.getValue().getParticipants().size(), 2);

        String roomId = createdRoomResponse.getValue().getRoomId();

        Response<CommunicationRoom> updateRoomResponse = roomsClient.updateRoomWithResponse(roomId, VALID_FROM, VALID_FROM.plusMonths(4), Context.NONE);
        assertHappyPath(updateRoomResponse, 200);

        CommunicationRoom addCommunicationRoom = roomsClient.addParticipants(roomId, participants6);
        assertEquals(addCommunicationRoom.getParticipants().size(), 3);
        assertHappyPath(addCommunicationRoom);

        Response<CommunicationRoom> getRoomResponse = roomsClient.getRoomWithResponse(roomId, Context.NONE);
        assertHappyPath(getRoomResponse, 200);
        assertEquals(getRoomResponse.getValue().getParticipants().size(), 3);

        Response<Void> deleteResponse = roomsClient.deleteRoomWithResponse(roomId, Context.NONE);
        assertEquals(deleteResponse.getStatusCode(), 204);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void addRemoveParticipantsSyncWithFullOperation(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "AddRemoveParticipantsSyncWithFullOperation");
        assertNotNull(roomsClient);
        CommunicationRoom createCommunicationRoom = roomsClient.createRoom(VALID_FROM, VALID_UNTIL, null);
        assertHappyPath(createCommunicationRoom);
        assertEquals(createCommunicationRoom.getParticipants(), null);

        String roomId = createCommunicationRoom.getRoomId();

        // Add 3 participants.
        CommunicationRoom addedParticipantsRoom = roomsClient.addParticipants(roomId, participants5);
        assertHappyPath(addedParticipantsRoom);
        assertEquals(addedParticipantsRoom.getParticipants().size(), 3);
        assertEquals(addedParticipantsRoom.getParticipants().contains(firstParticipant), true);
        assertEquals(addedParticipantsRoom.getParticipants().contains(secondParticipant), true);
        assertEquals(addedParticipantsRoom.getParticipants().contains(thirdParticipant), true);

        // Remove 2 participants.
        CommunicationRoom removedParticipantsRoom = roomsClient.removeParticipants(roomId, participants6);
        assertHappyPath(removedParticipantsRoom);
        assertEquals(removedParticipantsRoom.getParticipants().size(), 1);
        assertEquals(removedParticipantsRoom.getParticipants().contains(firstParticipant), true);
        assertEquals(removedParticipantsRoom.getParticipants().contains(secondParticipant), false);
        assertEquals(removedParticipantsRoom.getParticipants().contains(thirdParticipant), false);

        Response<Void> deleteResponse = roomsClient.deleteRoomWithResponse(roomId, Context.NONE);
        assertEquals(deleteResponse.getStatusCode(), 204);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void addRemoveParticipantsSyncWithFullOperationWithResponse(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "AddRemoveParticipantsSyncWithFullOperationWithResponse");
        assertNotNull(roomsClient);

        Response<CommunicationRoom> createdRoomResponse = roomsClient.createRoomWithResponse(VALID_FROM, VALID_UNTIL, null, Context.NONE);
        assertHappyPath(createdRoomResponse, 201);
        assertEquals(createdRoomResponse.getValue().getParticipants(), null);

        String roomId = createdRoomResponse.getValue().getRoomId();

        // Add 3 participants.
        Response<CommunicationRoom> addedParticipantsRoom = roomsClient.addParticipantsWithResponse(roomId, participants5, Context.NONE);
        assertHappyPath(addedParticipantsRoom.getValue());
        assertEquals(addedParticipantsRoom.getValue().getParticipants().size(), 3);
        assertEquals(addedParticipantsRoom.getValue().getParticipants().contains(firstParticipant), true);
        assertEquals(addedParticipantsRoom.getValue().getParticipants().contains(secondParticipant), true);
        assertEquals(addedParticipantsRoom.getValue().getParticipants().contains(thirdParticipant), true);

        // Remove 2 participants.
        Response<CommunicationRoom> removedParticipantsRoom = roomsClient.removeParticipantsWithResponse(roomId, participants6, Context.NONE);
        assertHappyPath(removedParticipantsRoom.getValue());
        assertEquals(removedParticipantsRoom.getValue().getParticipants().size(), 1);
        assertEquals(removedParticipantsRoom.getValue().getParticipants().contains(firstParticipant), true);
        assertEquals(removedParticipantsRoom.getValue().getParticipants().contains(secondParticipant), false);
        assertEquals(removedParticipantsRoom.getValue().getParticipants().contains(thirdParticipant), false);

        Response<Void> deleteResponse = roomsClient.deleteRoomWithResponse(roomId, Context.NONE);
        assertEquals(deleteResponse.getStatusCode(), 204);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void patchMeetingValidTimeWithResponse(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "patchMeetingValidTimeWithResponse");
        assertNotNull(roomsClient);
        Response<CommunicationRoom> createdRoomResponse = roomsClient.createRoomWithResponse(VALID_FROM, null, participants4, Context.NONE);
        assertHappyPath(createdRoomResponse, 201);
        assertEquals(createdRoomResponse.getValue().getParticipants().size(), 2);
        assertEquals(createdRoomResponse.getValue().getValidFrom().getDayOfYear(), VALID_FROM.getDayOfYear());

        String roomId = createdRoomResponse.getValue().getRoomId();

        Response<CommunicationRoom> updateRoomResponse = roomsClient.updateRoomWithResponse(roomId, VALID_FROM, VALID_UNTIL, Context.NONE);
        assertHappyPath(updateRoomResponse, 200);
        assertEquals(updateRoomResponse.getValue().getParticipants().size(), 2);
        assertEquals(updateRoomResponse.getValue().getValidFrom().getDayOfYear(), VALID_FROM.getDayOfYear());
        assertEquals(updateRoomResponse.getValue().getValidUntil().getDayOfYear(), VALID_UNTIL.getDayOfYear());

        Response<Void> deleteResponse = roomsClient.deleteRoomWithResponse(roomId, Context.NONE);
        assertEquals(deleteResponse.getStatusCode(), 204);
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void getRoomWithUnexistingRoomIdReturnBadRequest(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "getRoomWithUnexistingRoomIdReturnBadRequest");
        assertNotNull(roomsClient);
        assertThrows(HttpResponseException.class, () -> {
            roomsClient.getRoom(NONEXIST_ROOM_ID);
        });
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteRoomWithUnexistingRoomIdReturnBadRequest(HttpClient httpClient) {
        roomsClient = setupSyncClient(httpClient, "deleteRoomWithUnexistingRoomIdReturnBadRequest");
        assertNotNull(roomsClient);
        assertThrows(HttpResponseException.class, () -> {
            roomsClient.deleteRoomWithResponse(NONEXIST_ROOM_ID, Context.NONE);
        });
    }

    private RoomsClient setupSyncClient(HttpClient httpClient, String testName) {
        RoomsClientBuilder builder = getRoomsClientWithConnectionString(httpClient);
        createUsers(httpClient);
        return addLoggingPolicy(builder, testName).buildClient();
    }
}
