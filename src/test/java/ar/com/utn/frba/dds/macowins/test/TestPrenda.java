package ar.com.utn.frba.dds.macowins.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TestPrenda extends AbstractTestLocalDeRopa {
	
	@Test
	public void testPrecioPrendaNueva() {
		Assert.assertEquals(sacoNuevo.calcularPrecio(), sacoNuevo.getPrecioBase());
	}
	
	@Test
	public void testPrecioPrendaEnPromo() {
		Assert.assertEquals(pantalonPromo.calcularPrecio(), pantalonPromo.getPrecioBase().subtract(VALOR_FIJO));
	}
	
	@Test
	public void testPrecioPrendaEnLiqui() {
		Assert.assertEquals(camisaEnLiqui.calcularPrecio()
				, camisaEnLiqui.getPrecioBase().multiply(new BigDecimal(PORCENTAJE_LIQUI)));
	}

}
