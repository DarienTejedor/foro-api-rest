package com.darien.foro.api.domain.topico.validaciones;

import com.darien.foro.api.domain.topico.DatosActualizaTopico;
import com.darien.foro.api.domain.topico.DatosRegistraTopico;

public interface ValidadorDeTopicos {

    void valida(DatosRegistraTopico datosRegistraTopico);
    void valida(DatosActualizaTopico datosActualizaTopico);
}
