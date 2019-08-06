package ar.com.utn.frba.dds.macowins.test;

import java.math.BigDecimal;

import org.junit.Before;

import ar.com.utn.frba.dds.macowins.Liquidacion;
import ar.com.utn.frba.dds.macowins.Nueva;
import ar.com.utn.frba.dds.macowins.Prenda;
import ar.com.utn.frba.dds.macowins.Promocion;
import ar.com.utn.frba.dds.macowins.TiposPrenda;

public abstract class AbstractTestLocalDeRopa {

	public static final double PORCENTAJE_LIQUI = .5;
	public static final BigDecimal VALOR_FIJO = new BigDecimal(500.0);
	public Prenda sacoNuevo;
	public Prenda pantalonPromo;
	public Prenda camisaEnLiqui;

	@Before
	public void doInit() {
		sacoNuevo=new Prenda(TiposPrenda.SACO, new BigDecimal(3000.0), new Nueva());
		pantalonPromo=new Prenda(TiposPrenda.PANTALON, new BigDecimal(1500.0), new Promocion(VALOR_FIJO));
		camisaEnLiqui=new Prenda(TiposPrenda.CAMISA, new BigDecimal(1000.0), new Liquidacion(PORCENTAJE_LIQUI));
	}

}
