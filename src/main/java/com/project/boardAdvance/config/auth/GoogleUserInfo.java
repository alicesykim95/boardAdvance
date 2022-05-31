package com.project.boardAdvance.config.auth;

import java.util.Map;

public class GoogleUserInfo {

    private Map<String, Object> attributes;

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getProviderId() {
        return attributes.get("sub").toString();
    }

    public String getName() {
        return attributes.get("name").toString();
    }

    public String getEmail() {
        return attributes.get("email").toString();
    }

    public String getProvider() {
        return "google";
    }

}
