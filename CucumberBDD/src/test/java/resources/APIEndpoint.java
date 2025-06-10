package resources;

public enum APIEndpoint {
    CREATE_USER("/users"),
    GET_ALL_USERS("/users"),
    GET_USER_BY_ID("/users/{id}"),
    UPDATE_USER_BY_ID("/users/{id}"),
    PARTIAL_UPDATE_USER_BY_ID("/users/{id}"),
    DELETE_USER_BY_ID("/users/{id}");

    private final String path;

    APIEndpoint(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static APIEndpoint fromString(String endpointName) {
        try {
            return APIEndpoint.valueOf(endpointName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid endpoint: " + endpointName +
                ". Valid values are: " + java.util.Arrays.toString(APIEndpoint.values()));
        }
    }
}
