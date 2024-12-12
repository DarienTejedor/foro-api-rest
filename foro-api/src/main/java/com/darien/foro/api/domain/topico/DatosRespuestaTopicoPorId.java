package com.darien.foro.api.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopicoPorId(
        String titulo,
        String mensaje,
        LocalDateTime fechaPublicacion,
        String autor,
        Boolean estado,
        String curso
) {
}
