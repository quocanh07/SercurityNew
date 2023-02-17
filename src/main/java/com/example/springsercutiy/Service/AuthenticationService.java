package com.example.springsercutiy.Service;

import com.example.springsercutiy.Entity.User;
import com.example.springsercutiy.Repository.RoleCustomRepo;
import com.example.springsercutiy.Repository.UserRepository;
import com.example.springsercutiy.auth.AuthenticationRequest;
import com.example.springsercutiy.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import com.example.springsercutiy.Entity.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepo roleCustomRepo;
    private final JwtService jwtService;
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        User user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        List<Role> role = null;

        if(user!=null){
            role = roleCustomRepo.getRole(user);
        }


        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        Set<Role> set = new HashSet<>();
        role.forEach(c->set.add(new Role(c.getName())));
        user.setRoles(set);
        set.forEach(i->authorities.add(new SimpleGrantedAuthority(i.getName())));
        var jwtToken = jwtService.generateToken(user,authorities);
        var jwtRefreshToken=jwtService.generateRefreshToken(user,authorities);
       return  AuthenticationResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }

}
