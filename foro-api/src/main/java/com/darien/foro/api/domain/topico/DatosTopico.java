package com.darien.foro.api.domain.topico;

import com.darien.foro.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long usuarioId,
        @NotBlank
        String curso
) {

}
