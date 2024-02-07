package br.com.rentabilidade.rentabilidadeanualapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rentabilidade.rentabilidadeanualapi.model.Rentabilidade;
import br.com.rentabilidade.rentabilidadeanualapi.service.RentabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rentabilidades")
public class RentabilidadeController {

    @Autowired
    private RentabilidadeService rentabilidadeService;

    @GetMapping
    public List<Rentabilidade> listarRentabilidades(@RequestParam int ano) throws IOException, ParseException {
        List<Rentabilidade> rentabilidades = rentabilidadeService.calcularRentabilidadesMensais();

        rentabilidades = rentabilidades.stream()
                .filter(r -> r.getMes().endsWith("/" + ano))
                .collect(Collectors.toList());

        rentabilidades.sort(Comparator.comparing(Rentabilidade::getRentabilidade).reversed());

        return rentabilidades;
    }
}

