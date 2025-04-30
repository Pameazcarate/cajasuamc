package cua.integra.cajasuamc.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PagoDTO {
    private Long id;
    private Date fechaPago;
    private BigDecimal monto;
    private Long alumnoId;
    private Long cajaId;
    private Long servicioId;
}
