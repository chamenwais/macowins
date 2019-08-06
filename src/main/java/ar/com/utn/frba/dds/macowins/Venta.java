package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public abstract class Venta {

	private LocalDate fecha;
	private Map<Prenda, Integer> prendas;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Map<Prenda, Integer> getPrendas() {
		return prendas;
	}

	public void setPrendas(Map<Prenda, Integer> prendas) {
		this.prendas = prendas;
	}

	public BigDecimal obtenerGanancia() {
		List<Double> totales = new ArrayList<Double>();
		prendas.forEach((prenda, cantidad) -> 
			totales.add(prenda.calcularPrecio().doubleValue()*cantidad));
		return new BigDecimal(totales.stream()
				.reduce(0D, (precio1, precio2) -> precio1 + precio2)
				+ aplicarRecargo());
	}
	
	public abstract Double aplicarRecargo();
	

}
