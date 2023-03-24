package com.example.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class FilterUtil {


    private static Map<String, String> tokenRolePairs = new HashMap<>();

    public static String retrieveTokenFromRequest(HttpHeaders headers) {
        if (!headers.containsKey(HttpHeaders.AUTHORIZATION))
            throw new RuntimeException("dont have token");

        String[] partsOfToken = headers.get(HttpHeaders.AUTHORIZATION).get(0)
                .split(" ");

        if (partsOfToken.length != 2 || !partsOfToken[0].equals("Bearer"))
            throw new RuntimeException("invalid token");

        return partsOfToken[1];
    }

    public static boolean isAdmin(String jwtToken) {
        return getRequestForGettingRole(jwtToken).equals("ROLE_ADMIN");
    }
    private static String getRequestForGettingRole(String jwtToken) {
        RestTemplate restTemplate = new RestTemplate();
        if (tokenRolePairs.containsKey(jwtToken)) {
            return tokenRolePairs.get(jwtToken);
        }
        String role = restTemplate.getForObject("http://localhost:8080/auth/role?token=" + jwtToken, String.class);
        tokenRolePairs.put(jwtToken, role);
        return role;
    }
}
