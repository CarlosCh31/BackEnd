package com.olimpiadas.inscriptionsback.Service;

import com.olimpiadas.inscriptionsback.DTO.ActivityDTO;
import com.olimpiadas.inscriptionsback.DTO.AthleteDTO;
import com.olimpiadas.inscriptionsback.Models.Athlete;
import com.olimpiadas.inscriptionsback.Repositories.AthleteRepository;
import com.olimpiadas.inscriptionsback.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional

public class AthleteServiceImpl implements AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public List<Athlete> findAll() {
        return this.athleteRepository.findAll();
    }

    @Override
    public Athlete findById(Integer id) {
        return athleteRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Atleta con id " + id + " no se encuentra")
        );
    }

    @Override
    public void deleteById(String id) {
        athleteRepository.deleteAthlete(id);
    }

    @Override
    public String update(Athlete athlete) {
        return athleteRepository.update(athlete.getId(), athlete.getLaterality(), athlete.getDisability_type(), athlete.getWeight(), athlete.getHeight());
    }
    @Override
    @Transactional // Ensures proper transaction management
    public void save(Athlete athlete) {
        athlete.setHeight(170.0);
        athlete.setWeight(150.0);
        System.out.println(athleteRepository.saveAthlete(
                athlete.getId(),
                athlete.getName(),
                athlete.getBirthdate(),
                (athlete.getRegion_id() != null) ? athlete.getRegion_id().getId() : null,
                athlete.getEmail(),
                athlete.getPhone_number(),
                athlete.getTipo(),  // ✅ Agregar el tipo
                (athlete.getProvince_id() != null) ? athlete.getProvince_id().getId() : null,
                (athlete.getCanton_id() != null) ? athlete.getCanton_id().getId() : null,
                athlete.getLaterality(),
                athlete.getDisability_type(),
                athlete.getWeight(),
                athlete.getHeight(),
                athlete.getSubProgram(),
                athlete.getState()
        ));
    }


    // Método para manejar los errores de PostgreSQL
    @Override
    public String handlePostgreSQLError(Exception e) {
        if (e.getCause() instanceof PSQLException) {
            PSQLException psqlException = (PSQLException) e.getCause();
            String sqlState = psqlException.getSQLState();
            String detailedMessage = psqlException.getServerErrorMessage().getDetail();

            switch (sqlState) {
                case "23505":  // Código para unique_violation
                    return "Ya existe un registro con esta información. Verifica los datos ingresados.";
                case "23503":  // Código para foreign_key_violation
                    return "No se puede registrar, hay una referencia inválida a otra entidad.";
                case "22001":  // Código para value_too_long
                    return "Uno de los campos tiene demasiados caracteres.";
                default:
                    return "Ha ocurrido un error en el sistema. Detalles: " + detailedMessage;
            }
        }
        return "Error desconocido. Contacte al administrador.";
    }

    // Método para extraer el campo que causó el error del mensaje detallado de PostgreSQL
    @Override
    public String extractFieldFromError(String detailedMessage) {
        // Regex para capturar el nombre del campo que causó el error
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(detailedMessage);
        if (matcher.find()) {
            return matcher.group(1);  // Retorna el nombre del campo
        }
        return "desconocido";  // Si no se encuentra el campo
    }

    @Override
    public String updateManager(Athlete athlete) {
        System.out.println("Athlete recibido: " + athlete);
        return athleteRepository.updateManager(athlete.getId(), athlete.getLaterality(), athlete.getDisability_type(), athlete.getState());
    }

}
