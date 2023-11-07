package com.senai.apivsconnect.services;

import com.senai.apivsconnect.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByEmail(username); //var é tipo dinamico

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }

        return usuario;
    }
}
