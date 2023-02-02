package com.luciuswong.renting.authentication;

import com.luciuswong.renting.model.Person;
import com.luciuswong.renting.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

//public class PersonAuthenticationProvider implements AuthenticationProvider {
//    @Autowired
//    private PersonRepository personRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        Person personFromDb = personRepository.findByUsername(username);
//        if (personFromDb != null && personFromDb.getPersonId() > 0 && passwordEncoder.matches(password, personFromDb.getPassword())) {
//            // null is passed to authentication token as credentials since user password is not used in the application
//            return new UsernamePasswordAuthenticationToken(username, null, getGrantedAuthorities(personFromDb.getRole()));
//        } else {
//            throw new BadCredentialsException("Credentials are invalid");
//        }
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(String role) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
//        return grantedAuthorities;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
