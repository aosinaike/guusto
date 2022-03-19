package com.guusto.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User principal = (User) authentication.getPrincipal();
        if (principal != null) {
            System.out.println("principal" + principal.getUsername());
            boolean isUser = false;
            Iterator<GrantedAuthority> grantedAuthorityIterator = principal.getAuthorities().iterator();
            while (grantedAuthorityIterator.hasNext()) {
                if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ROLE_USER")) {
                    isUser = true;
                }
            }
            httpServletResponse.sendRedirect("/index");
        }
    }
}