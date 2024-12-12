package com.darien.foro.api.controller;


import com.darien.foro.api.domain.topico.*;
import com.darien.foro.api.domain.topico.validaciones.ValidadorDeTopicos;
import com.darien.foro.api.domain.usuario.Usuario;
import com.darien.foro.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidadorDeTopicos valida;

    @PostMapping
    public ResponseEntity<DatosRegistraTopico> registrarTopico(@RequestBody @Valid DatosTopico registraTopico){

        Usuario usuario = usuarioRepository.findById(registraTopico.usuarioId()) .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        //Validar que el tópico no exista
        valida.valida(new DatosRegistraTopico( registraTopico.titulo(), registraTopico.mensaje(), usuario.getId(), registraTopico.curso() ));

        Topico topico = topicoRepository.save(new Topico(registraTopico, usuario));

        DatosRegistraTopico datosRegistraTopico = new DatosRegistraTopico(topico.getTitulo(), topico.getMensaje(), topico.getId(), topico.getCurso());

        return ResponseEntity.status(HttpStatus.CREATED).body(datosRegistraTopico);
    }


    //Lista de topicos
    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listaTopicos(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(topicoRepository.findByEstatusTrue(pageable).map(DatosListaTopicos::new));
    }

    //Topico por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicoPorId> toopicoPorId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopicoPorId(topico.getTitulo(), topico.getMensaje(), topico.getFechaPublicacion(), topico.getUsuario().getLogin(), topico.getEstatus(),topico.getCurso());

        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizaTopico(@RequestBody @Valid DatosActualizaTopico actualizaTopico){
        Topico topico = topicoRepository.getReferenceById(actualizaTopico.id());

        //Validar que el tópico no exista
        valida.valida(actualizaTopico);

        topico.actualiza(actualizaTopico);
        return ResponseEntity.ok(new DatosRespuestaTopicoPorId(topico.getTitulo(), topico.getMensaje(), topico.getFechaPublicacion(), topico.getUsuario().getLogin(), topico.getEstatus(),topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivaTopico();
        return ResponseEntity.noContent().build();
    }

}
