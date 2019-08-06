package ar.com.utn.frba.dds.macowins;

import java.util.Map;

import org.joda.time.LocalDate;

public class VentaEfectivo extends Venta {

	public VentaEfectivo(LocalDate fecha, Map<Prenda, Integer> prendas) {
		this.setFecha(fecha);
		this.setPrendas(prendas);
	}

	@Override
	public Double aplicarRecargo() {
		return 0D;
	}

}
