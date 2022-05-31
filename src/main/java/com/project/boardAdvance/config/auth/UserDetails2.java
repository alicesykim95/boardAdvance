package com.project.boardAdvance.config.auth;

import com.project.boardAdvance.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class UserDetails2 implements UserDetails, OAuth2User {

    private static final long serialVersionUID = 1L;

    private User user;

    private Map<String, Object> attributes;

    public UserDetails2(User user) {
        this.user = user;
    }

    public UserDetails2(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    // Collection - List = {LinkedList, Stack, Vector, ArrayList}, Set = [HashSet, LinkedHashSet, TreeSet}
    // Map = {HashMap, Hashtable, TreeMap, LinkedHashMap}
    // Array Collection
    // List Collection
    // Map - 키/ 값 (순서가 없다)
    // Set - 중복이 없고, 순서도 없다. Collection
    // Enum - 상수 집합

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> String.valueOf(user.getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
