/**
 * 
 */
package com.quickcommerce.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.quickcommerce.Respuesta.EntidadProductRespuesta;
import com.quickcommerce.Solicitud.PutProductoSolicitud;
import com.quickcommerce.config.Tiempo;
import com.quickcommerce.model.ProductoModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.quickcommerce.ApiRestController.ProductoApiRestControllerImpl;
import com.quickcommerce.Respuesta.EntidadRespuesta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Kevin Velásquez
 *
 */
public class SuperHeroeTest {
	static ProductoApiRestControllerImpl superHeroeApi;
	HttpServletResponse respuesta;
	static ProductoModel batManMock;
	static ProductoModel superManMock;
	static ProductoModel spiderManMock;
	static ProductoModel ironManMock;
	static ProductoModel capitanAmericaMock;
	static ProductoModel thorMock;
	static ProductoModel hulkMock;
	
	@BeforeAll
	static void SetUpBeforeClass() throws Exception {
		// Arrange
		/*batManMock = new ProductoModel(0, "Bat Man", "Bruce Wayne", "Ciudad Gotica", Habilidad.SuperIntelecto,
				"Murcielago", Color.Negro, "El Guason");

		superManMock = new ProductoModel(1, "Super Man", "Clark Kent", "Metrópolis", Habilidad.SuperFuerza, "S",
				Color.Azul, "Lex Luthor");

		spiderManMock = new ProductoModel(2, "Spider Man", "Peter Parker", "Ciudad de Nueva York", Habilidad.Telaraña,
				"Araña", Color.Rojo, "Duende Verde");

		ironManMock = new ProductoModel(3, "Iron Man", "Tony Stark", "Mansión Stark", Habilidad.Volar, "Robot",
				Color.Rojo, "Ultron");

		capitanAmericaMock = new ProductoModel(4, "Capitan America", "Steven Rogers", "Nueva York",
				Habilidad.SuperSoldado, "Estrella", Color.Azul, "Hydra");

		thorMock = new ProductoModel(5, "Thor", "Dios del Trueno", "Asgard", Habilidad.CombateArmado, "Martillo",
				Color.Dorado, "Loki");

		hulkMock = new ProductoModel(6, "Hulk", "Bruce Banner", "Sakaar", Habilidad.SuperFuerza, "Puño", Color.Verde,
				"Graviton");*/
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		superHeroeApi = mock(ProductoApiRestControllerImpl.class);
	}

	@Test
	@DisplayName("Consultar Todos debería obtener una lista con información de todos los Súper Heroes encontrados")
	public void consultarTodosObtieneListaInformacionDeTodosLosSuperHeroes() {
		// Arrange
		List<ProductoModel> listaSuperHeroes = new ArrayList<ProductoModel>();
		listaSuperHeroes.add(batManMock);
		listaSuperHeroes.add(superManMock);
		listaSuperHeroes.add(spiderManMock);
		listaSuperHeroes.add(ironManMock);
		listaSuperHeroes.add(capitanAmericaMock);
		listaSuperHeroes.add(thorMock);
		listaSuperHeroes.add(hulkMock);

		EntidadProductRespuesta<List<ProductoModel>> entidadRespuesta=new EntidadProductRespuesta<List<ProductoModel>>(null,0);
		entidadRespuesta.setProducts(listaSuperHeroes);
		
		when(superHeroeApi.consultarTodos()).thenReturn(entidadRespuesta);

		// Act
		List<ProductoModel> listaResultado = superHeroeApi.consultarTodos().getProducts();

		// Assert
		assertTrue(listaResultado.size() > 0);
		assertEquals("Bat Man", listaResultado.get(0).getNameProduct());
		assertEquals("Super Man", listaResultado.get(1).getNameProduct());
	}

	@Test
	@DisplayName("Consultar Todos debería obtener una lista vacía sin información")
	public void consultarTodosObtieneListaVaciaSinInformacion() {
		// Arrange
		List<ProductoModel> listaSuperHeroes = new ArrayList<ProductoModel>();
		EntidadProductRespuesta<List<ProductoModel>> entidadRespuesta=new EntidadProductRespuesta<List<ProductoModel>>(null,0);
		when(superHeroeApi.consultarTodos()).thenReturn(entidadRespuesta);

		// Act
		List<ProductoModel> listaResultado = superHeroeApi.consultarTodos().getProducts();

		// Assert
		assertEquals(Collections.EMPTY_LIST, listaResultado);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			listaResultado.get(0);
		});
	}

	@Test
	@DisplayName("Consultar por Id debería obtener información por cada Súper Heroe indicado")
	public void consultarPorIdObtieneInformacionPorCadaSuperHeroeIndicado() {
		// Arrange
		EntidadRespuesta<ProductoModel> entidadRespuesta=new EntidadRespuesta<ProductoModel>(200,null,null,Tiempo.obtener());
		entidadRespuesta.setData(batManMock);
		
		//when(superHeroeApi.consultarPorId(0)).thenReturn(entidadRespuesta);

		// Act
		//ProductoModel batmanResultado = superHeroeApi.consultarPorId(0).getData();

		// Assert
		//assertEquals("Bat Man", batmanResultado.getNombre());
	}

	@Test
	@DisplayName("Consultar por Id debería obtener información vacía por cada Súper Heroe indicado")
	public void consultarPorIdObtieneVacioPorCadaSuperHeroeIndicado() {
		// Arrange
		EntidadRespuesta<ProductoModel> entidadRespuesta=new EntidadRespuesta<ProductoModel>(200,null,null,Tiempo.obtener());
		//when(superHeroeApi.consultarPorId(anyInt())).thenReturn(entidadRespuesta);

		// Act
		//ProductoModel superHeroeResultado1 = superHeroeApi.consultarPorId(7).getData();
		//ProductoModel superHeroeResultado2 = superHeroeApi.consultarPorId(8).getData();
		//ProductoModel superHeroeResultado3 = superHeroeApi.consultarPorId(9).getData();

		// Assert
		//assertNull(superHeroeResultado1);
		//assertNull(superHeroeResultado2);
		//assertNull(superHeroeResultado3);
	}

	@Test
	@DisplayName("Consultar por nombre que contenga debería obtener una lista con información de todos los Súper Heroes encontrados")
	public void consultarPorNombreContengaObtieneListainformacionDeTodosLosSuperHeroes() {
		// Arrange
		List<ProductoModel> listaSuperHeroe1 = new ArrayList<ProductoModel>();
		List<ProductoModel> listaSuperHeroe2 = new ArrayList<ProductoModel>();

		listaSuperHeroe1.add(batManMock);
		listaSuperHeroe1.add(superManMock);
		listaSuperHeroe1.add(spiderManMock);
		listaSuperHeroe1.add(ironManMock);

		listaSuperHeroe2.add(superManMock);
		listaSuperHeroe2.add(spiderManMock);

		EntidadRespuesta<List<ProductoModel>> entidadRespuesta=new EntidadRespuesta<List<ProductoModel>>(200,null,null,Tiempo.obtener());
		entidadRespuesta.setData(listaSuperHeroe1);
		//when(superHeroeApi.consultarPorNombreContenga("man")).thenReturn(entidadRespuesta);
		
		entidadRespuesta.setData(listaSuperHeroe2);
		//when(superHeroeApi.consultarPorNombreContenga("er")).thenReturn(entidadRespuesta);

		// Act
		for (String nombreContiene : new String[] { "man", "er" }) {
			//List<ProductoModel> listaResultadoSuperHeroe = superHeroeApi.consultarPorNombreContenga(nombreContiene).getData();
			//for (ProductoModel superHeroe : listaResultadoSuperHeroe) {
				// Assert
				//assertTrue(superHeroe.getNombre().toLowerCase().indexOf(nombreContiene) != -1);
			//}
		}
	}

	@Test
	@DisplayName("Consultar por Nombre que contenga debería obtener una lista vacía")
	public void consultarPorNombreContengaObtieneListaVacia() {
		// Arrange
		List<ProductoModel> listaSuperHeroe1 = new ArrayList<ProductoModel>();
		EntidadRespuesta<List<ProductoModel>> entidadRespuesta=new EntidadRespuesta<List<ProductoModel>>(200,null,listaSuperHeroe1,Tiempo.obtener());
		//when(superHeroeApi.consultarPorNombreContenga(anyString())).thenReturn(entidadRespuesta);

		// Act
		//List<ProductoModel> listaResultado = superHeroeApi.consultarPorNombreContenga("ork").getData();

		// Assert
		//assertEquals(Collections.EMPTY_LIST, listaResultado);
	}

	@Test
	@DisplayName("Actualizar Súper Héroe debería modificar la información de un súper héroe indicado")
	public void modificarSuperHeroe() {
		// Arrange
		PutProductoSolicitud prodcuto = new PutProductoSolicitud();
		//superHeroe.setId(1);
		prodcuto.setNameProduct("nuevo-nombre");
		prodcuto.setCategoryProduct("nueva-identidad");

		EntidadRespuesta<ProductoModel>entidadRespuesta=new EntidadRespuesta<ProductoModel>(201,null,null,Tiempo.obtener());
		when(superHeroeApi.actualizar(prodcuto,respuesta)).thenReturn(entidadRespuesta);
		// Act

		EntidadRespuesta<ProductoModel> entidadResultado = superHeroeApi.actualizar(prodcuto,respuesta);
		// Assert
		assertEquals(201, entidadResultado.getEstatus());
	}

	@Test
	@DisplayName("Eliminar Súper Héroe debería eliminar la información de un Súper héroe indicado")
	public void eliminarSuperHeroe() {
		// Arrange
		int identificacion=2;		

		EntidadRespuesta<ProductoModel>entidadRespuesta=new EntidadRespuesta<ProductoModel>(201,null,null,Tiempo.obtener());
		when(superHeroeApi.eliminar(identificacion,respuesta)).thenReturn(entidadRespuesta);
		// Act

		EntidadRespuesta<ProductoModel> entidadResultado = superHeroeApi.eliminar(identificacion,respuesta);
		// Assert
		assertEquals(201, entidadResultado.getEstatus());
	}
}
