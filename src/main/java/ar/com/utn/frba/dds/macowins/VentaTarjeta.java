package ar.com.utn.frba.dds.macowins;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

public class VentaTarjeta extends Venta {

	private static final double PORCENTAJE_PRENDA = .01D;
	private Double coeficienteFijo;
	private Integer cuotas;

	public VentaTarjeta(LocalDate fecha, Map<Prenda, Integer> prendas, Double coeficienteFijo, Integer cuotas) {
		this.setFecha(fecha);
		this.setPrendas(prendas);
		this.setCoeficienteFijo(coeficienteFijo);
		this.setCoutas(cuotas);
	}

	public Double getCoeficienteFijo() {
		return coeficienteFijo;
	}

	public void setCoeficienteFijo(Double coeficienteFijo) {
		this.coeficienteFijo = coeficienteFijo;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public void setCoutas(Integer coutas) {
		this.cuotas = coutas;
	}

	@Override
	public Double aplicarRecargo() {
		List<Double> recargos = new ArrayList<Double>();
		getPrendas().forEach((prenda, cantidad) -> recargos.add((prenda.calcularPrecio().doubleValue() * PORCENTAJE_PRENDA)*cantidad));
		return recargos.stream()
				.reduce(0D, (valor1, valor2) -> valor1 + valor2)+getRecargo();
	}

	private Double getRecargo() {
		return getCuotas()*getCoeficienteFijo();
	}

}
