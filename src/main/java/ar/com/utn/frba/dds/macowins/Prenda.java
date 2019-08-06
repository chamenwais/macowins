package ar.com.utn.frba.dds.macowins;

import java.math.BigDecimal;

public class Prenda {

	private TiposPrenda tipo;
	private BigDecimal precioBase;
	private EstadoPrenda estadoActual;
	
	public Prenda(TiposPrenda tipo, BigDecimal precioBase, EstadoPrenda estadoActual) {
		this.tipo=tipo;
		this.precioBase=precioBase;
		this.estadoActual=estadoActual;
	}
	
	public TiposPrenda getTipo() {
		return tipo;
	}
	public void setTipo(TiposPrenda tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	public EstadoPrenda getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(EstadoPrenda estadoActual) {
		this.estadoActual = estadoActual;
	}

	public BigDecimal calcularPrecio() {
		return estadoActual.obtenerPrecioVenta(this.precioBase);
	}
	
}
