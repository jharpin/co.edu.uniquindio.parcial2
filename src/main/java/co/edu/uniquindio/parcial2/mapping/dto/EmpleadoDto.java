package co.edu.uniquindio.parcial2.mapping.dto;

public record EmpleadoDto(
        String nombre,
                          String apellido,
                          String cedula,
                          String email,
                          String direccion,
                        String tipoEmpleado
) {
}

