package com.darien.foro.api.controller;

import com.darien.foro.api.domain.usuario.DatosUsuario;
import com.darien.foro.api.domain.usuario.Usuario;
import com.darien.foro.api.security.DatosJWToken;
import com.darien.foro.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity auteticarUsuario(@RequestBody @Valid DatosUsuario datosAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(), datosAutenticacionUsuario.clave());
        var usuaruiAutenticado = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.generarToken((Usuario) usuaruiAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWToken(JWToken));
    }
}
