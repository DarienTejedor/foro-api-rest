package com.darien.foro.api.domain.topico;

import com.darien.foro.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaPublicacion;
    private Boolean estatus;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String curso;

    public Topico(DatosTopico datosTopico, Usuario usuario) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaPublicacion = LocalDateTime.now();
        this.estatus = true;
        this.usuario = usuario;
        this.curso = datosTopico.curso();
    }

    public void actualiza(DatosActualizaTopico actualizaTopico) {
        if (actualizaTopico.titulo() != null){
            this.titulo = actualizaTopico.titulo();
        }if (actualizaTopico.mensaje() != null){
            this.mensaje = actualizaTopico.mensaje();
        }if (actualizaTopico.curso() != null){
            this.curso = actualizaTopico.curso();
        }
    }

    public void desactivaTopico(){
        this.estatus = false;
    }
}






