package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;

public class Liquidacion implements EstadoPrenda {
	
	private Double porcentaje;

	public Liquidacion(Double porcentaje) {
		this.porcentaje=porcentaje;
	}

	@Override
	public BigDecimal obtenerPrecioVenta(BigDecimal precioBase) {
		return precioBase.multiply(new BigDecimal(porcentaje));
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
