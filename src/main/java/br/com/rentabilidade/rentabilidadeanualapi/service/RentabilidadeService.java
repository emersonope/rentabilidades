package br.com.rentabilidade.rentabilidadeanualapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.rentabilidade.rentabilidadeanualapi.model.Rentabilidade;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class RentabilidadeService {
    public List<Rentabilidade> calcularRentabilidadesMensais() throws IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#.##");

        Map<String, Double> rentabilidadesPorMes = new HashMap<>();
        String filePath = "files/rentabilidades.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource(filePath).getInputStream()))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String dataStr = parts[0];
                double rentabilidadeDiaria = Double.parseDouble(parts[1]);

                String mes = dataStr.substring(3, 5) + "/" + dataStr.substring(6, 10);

                rentabilidadesPorMes.put(mes, rentabilidadesPorMes.getOrDefault(mes, 0.0) + rentabilidadeDiaria);
            }
        }

        List<Rentabilidade> rentabilidades = new ArrayList<>();
        rentabilidadesPorMes.forEach((mes, rentabilidade) -> {
            try {
                rentabilidades.add(new Rentabilidade(mes, (Double) df.parse(df.format(rentabilidade))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        return rentabilidades;
    }
}
