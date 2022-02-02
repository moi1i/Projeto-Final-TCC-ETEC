package br.com.pinguins.tcc.backend.services;


import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.UsuarioMapper;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;

    public List<UsuarioDTO> findAll() {
        List<Usuario> userList = usuarioRepository.findAll();

        return mapper.dtoList(userList);
    }

    public UsuarioDTO findById(Long id) {
        return usuarioRepository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO updateById(Long id, UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND));

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());

        usuarioRepository.save(usuario);

        return mapper.toDto(usuario);
    }

    public void save(UsuarioDTO usuarioDTO) {
         Optional<Usuario> teste = Optional
                 .of(usuarioRepository.save(mapper.toEntity(usuarioDTO)));

        Usuario usuario = mapper.toEntity(usuarioDTO);

        mapper.toDto(usuario);
    }
}
