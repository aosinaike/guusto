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
//        //do some logic here if you want something to be done whenever
//        //the user successfully logs in.
//
//        HttpSession session = httpServletRequest.getSession();
//        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        session.setAttribute("username", authUser.getUsername());
//        session.setAttribute("authorities", authentication.getAuthorities());
//
//        //set our response to OK status
//        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//
//        //since we have created our custom success handler, its up to us to where
//        //we will redirect the user after successfully login
//        httpServletResponse.sendRedirect("home");
        User principal = (User) authentication.getPrincipal();
        System.out.println("principal" + principal.getUsername());
        boolean isUser = false;
        Iterator<GrantedAuthority> grantedAuthorityIterator = principal.getAuthorities().iterator();
        while (grantedAuthorityIterator.hasNext()) {
            if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ROLE_USER")) {
                isUser = true;
            }
        }
//        if (isUser) {
//            httpServletResponse.sendRedirect("/user");
//        } else {
//            httpServletResponse.sendRedirect("/home");
//        }
    }
}