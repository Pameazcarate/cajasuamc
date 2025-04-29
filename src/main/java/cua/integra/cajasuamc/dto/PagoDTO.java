package cua.integra.cajasuamc.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PagoDTO {
    private Long id;
    private Date fechaPago;
    private BigDecimal monto;
    private Long alumnoId;
    private Long cajaId;

}
