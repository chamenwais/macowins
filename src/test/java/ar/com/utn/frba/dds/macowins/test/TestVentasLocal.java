package ar.com.utn.frba.dds.macowins.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.utn.frba.dds.macowins.Local;
import ar.com.utn.frba.dds.macowins.Prenda;
import ar.com.utn.frba.dds.macowins.Venta;
import ar.com.utn.frba.dds.macowins.VentaEfectivo;
import ar.com.utn.frba.dds.macowins.VentaTarjeta;

public class TestVentasLocal extends AbstractTestLocalDeRopa {
	
	private static final LocalDate FECHA_COMUN = new LocalDate(2019,03,24);
	public Venta ventaPantalonesPromo;
	public Map<Prenda,Integer> pantalonesPromo; 
	public Venta ventaCamisasLiquiYPantalonPromo;
	public Map<Prenda,Integer> camisasLiquiYPantalonPromo;
	public Venta ventaSacoNuevoYCamisaLiqui;
	public Map<Prenda,Integer> sacoNuevoYCamisaLiqui;
	public Local altoPalermo;
	public Set<Venta> ventasAltoPalermo;
	
	@Before
	public void init() {
		pantalonesPromo=new HashMap<Prenda, Integer>();
		pantalonesPromo.put(pantalonPromo, 3);
		ventaPantalonesPromo=new VentaEfectivo(FECHA_COMUN, pantalonesPromo);
		camisasLiquiYPantalonPromo=new HashMap<Prenda, Integer>();
		camisasLiquiYPantalonPromo.put(camisaEnLiqui, 3);
		camisasLiquiYPantalonPromo.put(pantalonPromo, 1);
		ventaCamisasLiquiYPantalonPromo=new VentaTarjeta(FECHA_COMUN, camisasLiquiYPantalonPromo, .1D, 3);
		sacoNuevoYCamisaLiqui=new HashMap<Prenda, Integer>();
		sacoNuevoYCamisaLiqui.put(sacoNuevo, 1);
		sacoNuevoYCamisaLiqui.put(camisaEnLiqui, 1);
		ventaSacoNuevoYCamisaLiqui=new VentaTarjeta(new LocalDate(2019,03,30),sacoNuevoYCamisaLiqui, .2D, 6);
		ventasAltoPalermo=new HashSet<Venta>();
		ventasAltoPalermo.add(ventaPantalonesPromo);
		ventasAltoPalermo.add(ventaCamisasLiquiYPantalonPromo);
		ventasAltoPalermo.add(ventaSacoNuevoYCamisaLiqui);
		altoPalermo=new Local("Alto Palermo", ventasAltoPalermo);
	}
	
	@Test
	public void testCamisasYPantalonValenMasCaroConTarjeta() {
		Assert.assertEquals(new BigDecimal(2525.3D), ventaCamisasLiquiYPantalonPromo.obtenerGanancia());
	}
	
	@Test
	public void testPantalonesValenLoMismoEnEfectivo() {
		Assert.assertEquals(new BigDecimal(3000D), ventaPantalonesPromo.obtenerGanancia());
	}
	
	@Test
	public void testObtenerGananciasDeUnDia() {
		Assert.assertEquals(new BigDecimal(5525.3D), altoPalermo.obtenerGanancias(FECHA_COMUN));
	}

}
