package com.darien.foro.api.domain.topico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findByEstatusTrue(Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Topico t WHERE t.titulo = :titulo AND t.mensaje = :mensaje AND t.id != :id")
    Boolean existsByTituloAndMensajeExcludingId(@Param("titulo") String titulo, @Param("mensaje") String mensaje, @Param("id") Long id);

}
