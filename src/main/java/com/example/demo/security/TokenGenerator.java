//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import java.security.SecureRandom;
//import com.example.demo.Models.User;
//import com.example.demo.Repository.UserRepository;
//
//@Service
//public class TokenGenerator {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//    private static final int TOKEN_LENGTH = 60;
//    private static final SecureRandom RANDOM = new SecureRandom();
//
//    // Method to generate a random alphanumeric string
//    private String generateRandomString() {
//        StringBuilder stringBuilder = new StringBuilder(TOKEN_LENGTH);
//
//        for (int i = 0; i < TOKEN_LENGTH; i++) {
//            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
//            stringBuilder.append(CHARACTERS.charAt(randomIndex));
//        }
//
//        return stringBuilder.toString();
//    }
//
//    // Generate and save the token in the User model
//    public String generateToken(String email, String password) {
//        User user = userRepository.findByEmail(email);
//
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            String token;
//            do {
//                token = generateRandomString();
//            } while (userRepository.existsByToken(token)); // Check if token exists in DB
//
//            user.setToken(token);
//            userRepository.save(user);
//            return token;
//        }
//        return null;
//    }
//
//    // Validate the token
//    public boolean validateToken(String token) {
//        User user = userRepository.findByToken(token);
//        return user != null;
//    }
//}

package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {

    private final String secret = "mysecretkey123";  // keep same everywhere

    public String generateToken(Long userId, String email) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
