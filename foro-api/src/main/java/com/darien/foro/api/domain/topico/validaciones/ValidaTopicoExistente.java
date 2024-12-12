package com.darien.foro.api.domain.topico.validaciones;

import com.darien.foro.api.domain.ValidacionException;
import com.darien.foro.api.domain.topico.DatosActualizaTopico;
import com.darien.foro.api.domain.topico.DatosRegistraTopico;
import com.darien.foro.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidaTopicoExistente implements ValidadorDeTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void valida(DatosRegistraTopico datosRegistraTopico) {
        var verificaTopicoYaExistente = topicoRepository.existsByTituloAndMensaje(datosRegistraTopico.titulo(), datosRegistraTopico.mensaje());
        if(verificaTopicoYaExistente){
            throw new ValidacionException("Topico ya registrado");
        }
    }

    @Override
    public void valida(DatosActualizaTopico datosActualizaTopico) {
        var verificaTopicoExistente = topicoRepository.existsByTituloAndMensajeExcludingId(datosActualizaTopico.titulo(), datosActualizaTopico.mensaje(), datosActualizaTopico.id());
        if (verificaTopicoExistente){
            throw new ValidacionException("Topico ya registrado");
        }
    }
}
