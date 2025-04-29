package cua.integra.cajasuamc.dto;

import lombok.Data;

@Data
public class ServicioDTO {
    private int idServicio;
    private String recuperación;
    private String constancia;
    private String reposiciónCredencial;
    private String multaBiblioteca;
    private String boletoTransporte;
}
