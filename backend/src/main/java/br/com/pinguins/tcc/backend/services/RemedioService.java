package br.com.pinguins.tcc.backend.services;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.mappers.RemedioMapper;
import br.com.pinguins.tcc.backend.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    @Autowired
    private RemedioMapper remedioMapper;


    public List<RemedioDTO> findAll() {
        return remedioMapper.dtoList(repository.findAll());
    }
}
