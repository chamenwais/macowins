package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;

public class Promocion implements EstadoPrenda {

	private BigDecimal valorFijo;

	public Promocion(BigDecimal valorFijo) {
		this.setValorFijo(valorFijo);
	}

	@Override
	public BigDecimal obtenerPrecioVenta(BigDecimal precioBase) {
		return precioBase.subtract(valorFijo);
	}

	public BigDecimal getValorFijo() {
		return valorFijo;
	}

	public void setValorFijo(BigDecimal valorFijo) {
		this.valorFijo = valorFijo;
	}

}
