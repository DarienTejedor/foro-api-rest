package com.darien.foro.api.domain.topico;

import com.darien.foro.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        String titulo,
        String mensaje,
        LocalDateTime fechaPublicacion,
        String autor,
        Boolean estado,
        String curso
) {
    public DatosListaTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaPublicacion(), topico.getUsuario().getLogin(), topico.getEstatus(),topico.getCurso());
    }
}
