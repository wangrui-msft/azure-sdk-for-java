## Azure Communications Rooms Service client library for Java

Azure Communication Rooms is used to operate on rooms.

[Source code][source] | [Package (Maven)][package] | [API reference documentation][api_documentation]
| [Product documentation][product_docs]

## Getting started

### Prerequisites

- An Azure account with an active subscription. [Create an account for free](https://azure.microsoft.com/free/?WT.mc_id=A261C142F).
- [Java Development Kit (JDK)](https://docs.microsoft.com/java/azure/jdk/?view=azure-java-stable) version 8 or above.
- [Apache Maven](https://maven.apache.org/download.cgi).
- A deployed Communication Services resource. You can use the [Azure Portal](https://docs.microsoft.com/azure/communication-services/quickstarts/create-communication-resource?tabs=windows&pivots=platform-azp) or the [Azure PowerShell](https://docs.microsoft.com/powershell/module/az.communication/new-azcommunicationservice) to set it up.

### Include the package
#### Include the BOM file

Please include the azure-sdk-bom to your project to take dependency on the General Availability (GA) version of the library. In the following snippet, replace the {bom_version_to_target} placeholder with the version number.
To learn more about the BOM, see the [AZURE SDK BOM README](https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/boms/azure-sdk-bom/README.md).

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.azure</groupId>
            <artifactId>azure-sdk-bom</artifactId>
            <version>{bom_version_to_target}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
and then include the direct dependency in the dependencies section without the version tag.

```xml
<dependencies>
  <dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-communication-rooms</artifactId>
  </dependency>
</dependencies>
```

#### Include direct dependency
If you want to take dependency on a particular version of the library that is not present in the BOM,
add the direct dependency to your project as follows.

[//]: # ({x-version-update-start;com.azure:azure-communication-rooms;current})
```xml
<dependency>
  <groupId>com.azure</groupId>
  <artifactId>azure-communication-rooms</artifactId>
  <version>1.0.0-alpha.1</version>
</dependency>
```

## Authenticate the client

### Azure Active Directory Token Authentication
A `DefaultAzureCredential` object must be passed to the `RoomsClientBuilder` via the credential() function. Endpoint and httpClient must also be set via the endpoint() and httpClient() functions respectively.

`AZURE_CLIENT_SECRET`, `AZURE_CLIENT_ID` and `AZURE_TENANT_ID` environment variables
are needed to create a DefaultAzureCredential object.

Alternatively, you can provide the entire connection string using the connectionString() function instead of providing the endpoint and access key.
<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L45-L53 -->
```java

return roomsClient;


ic RoomsClient createRoomsClientWithConnectionString() {
// You can find your connection string from your resource in the Azure Portal
String connectionString = "https://<resource-name>.communication.azure.com/;<access-key>";

RoomsClient roomsClient = new RoomsClientBuilder().connectionString(connectionString).buildClient();
```

## Key concepts

There are four operations to interact with the Azure Communication Rooms Service.

## Examples

### Create a new room
Use the `createRoom`  function to create a new Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L76-L91 -->
```java
return roomsClient;


ic void createRoomWithValidInput() {
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
```
### Update an existing room
Use the `updateRoom`  function to create a new Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L93-L115 -->
```java
System.out.println("Room Id: " + roomResult.getRoomId());


ic void updateRoomWithRoomId() {
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
```

### Get an existing room
Use the `getRoom`  function to get an existing Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L117-L126 -->
```java

}

public void getRoomWithRoomId() {
    RoomsClient roomsClient = createRoomsClientWithConnectionString();
    try {
        CommunicationRoom roomResult = roomsClient.getRoom("<Room Id in String>");
        System.out.println("Room Id: " + roomResult.getRoomId());
    } catch (RuntimeException ex) {
        System.out.println(ex);
```

### Delete an existing room
Use the `deleteRoomWithResponse`  function to delete an existing Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L128-L135 -->
```java

}

public void deleteRoomWithRoomId() {
    RoomsClient roomsClient = createRoomsClientWithConnectionString();
    try {
        roomsClient.deleteRoomWithResponse("<Room Id in String>", Context.NONE);
    } catch (RuntimeException ex) {
```

### Add particpants an existing room
Use the `addParticipants`  function to add participants to an existing Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L142-L158 -->
```java
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
```

### Remove particpants an existing room
Use the `removeParticipants`  function to remove participants from an existing Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L160-L173 -->
```java
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
```


### Remove all particpants from an existing room
Use the `updateRoom`  function to remove all participants from an existing Room on Azure Communciation Service.

<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L175-L186 -->
```java
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
```

## Troubleshooting

Rooms operations will throw an exception if the request to the server fails.
Exceptions will not be thrown if the error is caused by an individual message, only if something fails with the overall request.
Please use the `getSuccessful()` flag to validate each individual result to verify if the message was sent.
<!-- embedme src/samples/java/com/azure/communication/rooms/ReadmeSamples.java#L188-L209 -->
```java
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
```

## Next steps

- [Read more about Rooms in Azure Communication Services][next_steps]

### TODO

- Add existing links of room service wiki and sdk repo once released

<!-- LINKS -->
[cla]: https://cla.microsoft.com
[coc]: https://opensource.microsoft.com/codeofconduct/
[coc_faq]: https://opensource.microsoft.com/codeofconduct/faq/
[coc_contact]: mailto:opencode@microsoft.com
[product_docs]: https://docs.microsoft.com/azure/communication-services/
[api_documentation]: https://aka.ms/java-docs


## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a [Contributor License Agreement (CLA)][cla] declaring that you have the right to, and actually do, grant us the rights to use your contribution.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][coc]. For more information see the [Code of Conduct FAQ][coc_faq] or contact [opencode@microsoft.com][coc_contact] with any additional questions or comments.
