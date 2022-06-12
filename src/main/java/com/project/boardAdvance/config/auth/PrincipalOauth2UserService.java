package com.project.boardAdvance.config.auth;

import com.project.boardAdvance.model.User;
import com.project.boardAdvance.model.UserRole;
import com.project.boardAdvance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println(super.loadUser(userRequest).getAttributes());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        OAuthUserInfo oAuthUserInfo = null;

        switch (userRequest.getClientRegistration().getRegistrationId()) {
            case "google":
                oAuthUserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
                break;

            case "naver":
                oAuthUserInfo = new NaverUserInfo(oAuth2User.getAttributes());
                break;

            default:
                System.out.println("구글과 네이버만 지원합니다.");

        }


        Optional<User> userOptional = userRepository.findByProviderAndProviderId(oAuthUserInfo.getProvider(), oAuthUserInfo.getProviderId());
        User user;

        if (userOptional.isPresent()){
            user = userOptional.get();
            user.setUserEmail(oAuthUserInfo.getEmail());
        } else {
            user = User.builder()
                    .username(oAuthUserInfo.getProvider() + "_" + oAuthUserInfo.getProviderId())
                    .userEmail(oAuthUserInfo.getEmail())
                    .password(bCryptPasswordEncoder.encode("1234"))
                    .role(UserRole.valueOf("ROLE_USER"))
                    .provider(oAuthUserInfo.getProvider())
                    .providerId(oAuthUserInfo.getProviderId())
                    .build();

            userRepository.save(user);
        }

        return new UserDetails2(user, oAuth2User.getAttributes());
    }




}
