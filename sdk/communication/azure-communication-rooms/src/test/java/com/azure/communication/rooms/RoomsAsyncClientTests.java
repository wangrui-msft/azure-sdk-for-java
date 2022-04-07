// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.rooms;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.azure.communication.rooms.models.CommunicationRoom;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.Response;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class RoomsAsyncClientTests extends RoomsTestBase {
    private RoomsAsyncClient roomsAsyncClient;

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
    public void createRoomFullCycleWithResponseStep(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "createRoomFullCycleWithResponse");
        assertNotNull(roomsAsyncClient);
        
        Mono<Response<CommunicationRoom>> response1 = roomsAsyncClient.createRoomWithResponse(VALID_FROM, VALID_UNTIL, participants1);
        StepVerifier.create(response1)
            .assertNext(roomResult -> {
                assertHappyPath(roomResult, 201);
                assertEquals(roomResult.getValue().getParticipants().size(), 3);
                assertEquals(roomResult.getValue().getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(roomResult.getValue().getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(roomResult.getValue().getParticipants().containsKey(thirdParticipant.getId()), true);
            })
            .verifyComplete();

        String roomId = response1.block().getValue().getRoomId();

        Mono<Response<CommunicationRoom>> response3 =  roomsAsyncClient.updateRoomWithResponse(roomId, VALID_FROM, VALID_FROM.plusMonths(3));

        StepVerifier.create(response3)
            .assertNext(roomResult -> {
                assertHappyPath(roomResult, 200);
                assertEquals(roomResult.getValue().getParticipants().size(), 3);
                assertEquals(roomResult.getValue().getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(roomResult.getValue().getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(roomResult.getValue().getParticipants().containsKey(thirdParticipant.getId()), true);
                assertEquals(roomResult.getValue().getValidUntil().getDayOfYear(), VALID_FROM.plusMonths(3).getDayOfYear());
            }).verifyComplete();

        Mono<Response<CommunicationRoom>> response4 =  roomsAsyncClient.getRoomWithResponse(roomId);

        StepVerifier.create(response4)
            .assertNext(result4 -> {
                assertHappyPath(result4, 200);
                assertEquals(result4.getValue().getParticipants().size(), 3);
            }).verifyComplete();

        Mono<Response<Void>> response5 =  roomsAsyncClient.deleteRoomWithResponse(roomId);
        StepVerifier.create(response5)
        .assertNext(result5 -> {
            assertEquals(result5.getStatusCode(), 204);
        }).verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void createRoomFullCycleWithOutResponseStep(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "createRoomFullCycleWithOutResponse");
        assertNotNull(roomsAsyncClient);
        
        Mono<CommunicationRoom> response1 = roomsAsyncClient.createRoom(VALID_FROM, VALID_UNTIL, participants1);

        StepVerifier.create(response1)
        .assertNext(roomResult -> {
            assertEquals(roomResult.getParticipants().size(), 3);
            assertEquals(roomResult.getParticipants().containsKey(firstParticipant.getId()), true);
            assertEquals(roomResult.getParticipants().containsKey(secondParticipant.getId()), true);
            assertEquals(roomResult.getParticipants().containsKey(thirdParticipant.getId()), true);
        }).verifyComplete();

        String roomId = response1.block().getRoomId();

        Mono<CommunicationRoom> response3 =  roomsAsyncClient.updateRoom(roomId, VALID_FROM, VALID_FROM.plusMonths(3));

        StepVerifier.create(response3)
            .assertNext(result3 -> {
                assertEquals(result3.getParticipants().size(), 3);
                assertEquals(result3.getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(result3.getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(result3.getParticipants().containsKey(thirdParticipant.getId()), true);
                assertEquals(result3.getValidUntil().getDayOfYear(), VALID_FROM.plusMonths(3).getDayOfYear());
            }).verifyComplete();

        Mono<CommunicationRoom> response4 = roomsAsyncClient.getRoom(roomId);

        StepVerifier.create(response4)
            .assertNext(result4 -> {
                assertEquals(result4.getParticipants().size(), 3);
                assertEquals(result4.getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(result4.getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(result4.getParticipants().containsKey(thirdParticipant.getId()), true);
            }).verifyComplete();

        Mono<Response<Void>> response5 =  roomsAsyncClient.deleteRoomWithResponse(roomId);
        StepVerifier.create(response5)
        .assertNext(result5 -> {
            assertEquals(result5.getStatusCode(), 204);
        }).verifyComplete();

    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteParticipantsWithOutResponseStep(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "deleteParticipantsWithOutResponseStep");
        createUsers(httpClient);
        
        assertNotNull(roomsAsyncClient);

        Mono<CommunicationRoom> response1 = roomsAsyncClient.createRoom(VALID_FROM, VALID_UNTIL, participants1);

        StepVerifier.create(response1)
        .assertNext(roomResult -> {
            assertEquals(roomResult.getParticipants().size(), 3);
            assertEquals(roomResult.getParticipants().containsKey(firstParticipant.getId()), true);
            assertEquals(roomResult.getParticipants().containsKey(secondParticipant.getId()), true);
            assertEquals(roomResult.getParticipants().containsKey(thirdParticipant.getId()), true);
        }).verifyComplete();

        String roomId = response1.block().getRoomId();

        Mono<CommunicationRoom> response4 =  roomsAsyncClient.removeParticipants(roomId, participants5);
        System.out.println("response " + response4);
        StepVerifier.create(response4)
            .assertNext(result4 -> {
                assertEquals(result4.getParticipants().size(), 0);
            }).verifyComplete();

        Mono<Response<Void>> response5 =  roomsAsyncClient.deleteRoomWithResponse(roomId);
        StepVerifier.create(response5)
        .assertNext(result5 -> {
            assertEquals(result5.getStatusCode(), 204);
        }).verifyComplete();

    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void addRemoveParticipantsWithResponseStep(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "addRemoveParticipantsWithResponseStep");
        assertNotNull(roomsAsyncClient);

        Mono<Response<CommunicationRoom>> response1 = roomsAsyncClient.createRoomWithResponse(VALID_FROM, VALID_UNTIL, null);
        StepVerifier.create(response1)
            .assertNext(roomResult -> {
                assertHappyPath(roomResult, 201);
                assertEquals(roomResult.getValue().getParticipants(), null);
            })
            .verifyComplete();

        String roomId = response1.block().getValue().getRoomId();

        Mono<Response<CommunicationRoom>> response2 =  roomsAsyncClient.addParticipantsWithResponse(roomId, participants5);

        StepVerifier.create(response2)
            .assertNext(result2 -> {
                assertHappyPath(result2, 200);
                assertEquals(result2.getValue().getParticipants().size(), 3);
                assertEquals(result2.getValue().getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(result2.getValue().getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(result2.getValue().getParticipants().containsKey(thirdParticipant.getId()), true);
            }).verifyComplete();

        Mono<Response<CommunicationRoom>> response3 =  roomsAsyncClient.removeParticipantsWithResponse(roomId, participants6);

        StepVerifier.create(response3)
            .assertNext(result3 -> {
                assertHappyPath(result3, 200);
                assertEquals(result3.getValue().getParticipants().size(), 1);
                assertEquals(result3.getValue().getParticipants().containsKey(firstParticipant.getId()), true);
            }).verifyComplete();


    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void addRemoveParticipantsWithOutResponseStep(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "addRemoveParticipantsWithOutResponseStep");
        assertNotNull(roomsAsyncClient);
        Map<String, Object> participantMap = new HashMap<>();
        Mono<CommunicationRoom> response1 = roomsAsyncClient.createRoom(VALID_FROM, VALID_UNTIL, participantMap);

        StepVerifier.create(response1)
        .assertNext(roomResult -> {
            assertEquals(roomResult.getParticipants(), participantMap);
        }).verifyComplete();

        String roomId = response1.block().getRoomId();

        Mono<CommunicationRoom> response2 =  roomsAsyncClient.addParticipants(roomId, participants5);
        
        StepVerifier.create(response2)
            .assertNext(roomResult -> {
                assertEquals(roomResult.getParticipants().size(), 3);
                assertEquals(roomResult.getParticipants().containsKey(firstParticipant.getId()), true);
                assertEquals(roomResult.getParticipants().containsKey(secondParticipant.getId()), true);
                assertEquals(roomResult.getParticipants().containsKey(thirdParticipant.getId()), true);
            }).verifyComplete();

        Mono<CommunicationRoom> response3 =  roomsAsyncClient.removeParticipants(roomId, participants6);

        StepVerifier.create(response3)
            .assertNext(roomResult -> {
                assertEquals(roomResult.getParticipants().size(), 1);
                assertEquals(roomResult.getParticipants().containsKey(firstParticipant.getId()), true);
            }).verifyComplete();

        StepVerifier.create(roomsAsyncClient.getRoom(roomId)).assertNext(response4 -> {
            assertEquals(response4.getParticipants().size(), 1);
            assertEquals(response4.getParticipants().containsKey(firstParticipant.getId()), true);
        }).verifyComplete();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void getRoomWithUnexistingRoomId(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "getRoomWithUnexistingRoomId");
        assertNotNull(roomsAsyncClient);

        StepVerifier.create(roomsAsyncClient.getRoom(NONEXIST_ROOM_ID)).verifyError();
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    public void deleteRoomWithConnectionString(HttpClient httpClient) {
        roomsAsyncClient = setupAsyncClient(httpClient, "deleteRoomWithConnectionString");
        assertNotNull(roomsAsyncClient);

        StepVerifier.create(roomsAsyncClient.deleteRoomWithResponse(NONEXIST_ROOM_ID)).verifyError();
    }

    private RoomsAsyncClient setupAsyncClient(HttpClient httpClient, String testName) {
        RoomsClientBuilder builder = getRoomsClientWithConnectionString(httpClient);
        createUsers(httpClient);
        return addLoggingPolicy(builder, testName).buildAsyncClient();
    }
}
