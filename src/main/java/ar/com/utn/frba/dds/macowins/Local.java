package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;
import java.util.Set;

import org.joda.time.LocalDate;

public class Local {

	private String nombre;
	private Set<Venta> ventas;

	public Local(String nombre, Set<Venta> ventas) {
		this.setNombre(nombre);
		this.setVentas(ventas);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public BigDecimal obtenerGanancias(LocalDate unaFecha) {
		return new BigDecimal(getVentas().stream()
				.filter(venta -> venta.getFecha().equals(unaFecha))
				.map(venta -> venta.obtenerGanancia().doubleValue())
				.reduce(0D, (ganancia1, ganancia2) -> ganancia1+ganancia2));
	}

}
