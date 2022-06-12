package com.project.boardAdvance.config.auth;

public interface OAuthUserInfo {

    public String getProviderId();

    public String getName();

    public String getEmail();

    public String getProvider();
}
