package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;

public class Nueva implements EstadoPrenda {

	@Override
	public BigDecimal obtenerPrecioVenta(BigDecimal precioBase) {
		return precioBase;
	}

}
