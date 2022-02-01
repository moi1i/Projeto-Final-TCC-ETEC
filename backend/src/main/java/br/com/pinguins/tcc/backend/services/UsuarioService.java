package br.com.pinguins.tcc.backend.services;


import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.exceptions.ResourceNotFoundException;
import br.com.pinguins.tcc.backend.mappers.DozerMapper;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        return DozerMapper.parseListObjects(usuarioRepository.findAll(), UsuarioDTO.class);
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = DozerMapper.parseObject(usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND)), Usuario.class);

        return DozerMapper.parseObject(usuario, UsuarioDTO.class);

    }


    public void save(UsuarioDTO usuarioDTO) {
        Usuario usuarioEntity = DozerMapper.parseObject(usuarioDTO, Usuario.class);
        DozerMapper.parseObject(usuarioRepository.save(usuarioEntity), UsuarioDTO.class);
    }
}
