package com.darien.foro.api.domain.topico;

import com.darien.foro.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistraTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long usuario,
        @NotBlank
        String curso
) {
}
