/**
 * 
 */
package com.quickcommerce.integracion;

import com.quickcommerce.model.ProductoModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.quickcommerce.Respuesta.EntidadRespuesta;
import com.quickcommerce.Solicitud.PostProductoSolicitud;
import com.quickcommerce.Solicitud.UsuarioSolicitud;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin Velásquez
 *
 */
//@Category(IntegrationTest.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SuperHeroeIntegracionTest extends httpUtil {				
	UsuarioSolicitud adminMock;
	UsuarioSolicitud uctMock;
	UsuarioSolicitud uciMock;
	UsuarioSolicitud ucnMock;	
	UsuarioSolicitud uscMock;
	UsuarioSolicitud ucmMock;
	UsuarioSolicitud ucmeMock;
	
	@Autowired
    private FilterChainProxy springSecurityFilterChain;	
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeAll
	static void SetUpBeforeClass() throws Exception {}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {		
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
							 .addFilter(springSecurityFilterChain)
							 .build();		
		adminMock=new UsuarioSolicitud("admin","f9ce73932a795e2");
		uctMock=new UsuarioSolicitud("uct","uct1234");
		uciMock=new UsuarioSolicitud("uci","uci1234");
		ucnMock=new UsuarioSolicitud("ucn","ucn1234");	
		uscMock=new UsuarioSolicitud("usc","usc1234");
		ucmMock=new UsuarioSolicitud("ucm","ucm1234");
		ucmeMock=new UsuarioSolicitud("ucme","ucme1234");
	}	
	
	@Test
	@DisplayName("Consulta Todos los Súper Héroes y Consulta por Id debería obtener informacion correcta de cada API indicada")
	public void consultaTodosSuperHeroesYPorIdDeberiaObteneInfoCorrecta() throws Exception {
		//Arrange			
		List<UsuarioSolicitud> listaUsuarios=new ArrayList<UsuarioSolicitud>();
		//uscMock es igual a usuario con privilegios de solo consultas
		//ucmMock es igual a usuario con privilegios de consultas modificación
		//ucmeMock es igual a usuario con privilegios de consultas, modificación y eliminación
		listaUsuarios.add(uscMock);
		listaUsuarios.add(ucmMock);
		listaUsuarios.add(ucmeMock);
		
		//Act
		for(UsuarioSolicitud usuario:listaUsuarios) {			
			//Resultado integracion autenticacion	
			String jwtToken=autenticar(usuario);	
			
			//Resultado integracion super heroe consulta			
			EntidadRespuesta<List<ProductoModel>> listaSuperHeroe=mvc(http.GET, urlSuperHeroe,jwtToken,mapTipoListaSuperHeroeModel);
			//Assert
			assertEquals(200,listaSuperHeroe.getEstatus(),String.format("%s:", usuario.getUsuario()));
			assertNotEquals(null, listaSuperHeroe.getData());
			
			//Act
			for(ProductoModel superHeroe:listaSuperHeroe.getData()) {
				//Establece el id en la url
				String url= urlSuperHeroePorID.replace(":id",String.valueOf(superHeroe.getId()));
				EntidadRespuesta<ProductoModel>superHeroeModel=mvc(http.GET,url,jwtToken,mapTipoSuperHeroeModel);
				//Assert
				assertEquals(200, superHeroeModel.getEstatus(),String.format("%s:", superHeroeModel.getDescripcion()));
				assertNotEquals(null, superHeroeModel.getData(),String.format("%s:", superHeroe.getNombre()));
			}			
		}			
	}
	
	@Test
	@DisplayName("Consulta Todos los Súper Héroes por Nombre Contenga debería obtener informacion correcta de cada API indicada")
	public void consultaTodosSuperHeroesNombreContengaDeberiaObteneInfoCorrecta() throws UnsupportedEncodingException, Exception {
		//Arrange			
		List<UsuarioSolicitud> listaUsuarios=new ArrayList<UsuarioSolicitud>();
		List<String> listaNombresBusqueda=new ArrayList<String>();
		//uscMock es igual a usuario con privilegios de solo consultas
		//ucmMock es igual a usuario con privilegios de consultas modificación
		//ucmeMock es igual a usuario con privilegios de consultas, modificación y eliminación
		listaUsuarios.add(uscMock);
		listaUsuarios.add(ucmMock);
		listaUsuarios.add(ucmeMock);
		
		listaNombresBusqueda.add("man");
		listaNombresBusqueda.add("er");
		listaNombresBusqueda.add("pi");
		//Act
		for(UsuarioSolicitud usuario:listaUsuarios) {
			//Resultado integracion autenticacion	
			String jwtToken=autenticar(usuario);
			
			for(String busquedaNombre:listaNombresBusqueda) {
				String url= urlSuperHeroeNombreContenga.replace(":nombre",busquedaNombre);
				
				//Resultado integracion super heroe consulta
				EntidadRespuesta<List<ProductoModel>> listaSuperHeroe=mvc(http.GET, url, jwtToken, mapTipoListaSuperHeroeModel);
				
				//Assert
				assertEquals(200, listaSuperHeroe.getEstatus(),String.format("%s:%s", usuario.getUsuario(),busquedaNombre));
				assertNotEquals(null, listaSuperHeroe.getData(),String.format("%s:",  usuario.getUsuario(),busquedaNombre));
				assertNotEquals(Collections.EMPTY_LIST, listaSuperHeroe.getData(),String.format("Nombre Contenga: '%s' retornó vacío",busquedaNombre));
				
				for(ProductoModel superHeroe:listaSuperHeroe.getData()) {
					//Assert					
					assertTrue(superHeroe.getNombre().toLowerCase().indexOf(busquedaNombre)!=-1,
							String.format("%s : %s", superHeroe.getNombre(),busquedaNombre));					
				}
			}												
		}		
	}
	
	@Test
	@DisplayName("Consulta Todos los Súper Héroes con usuario y contrasenia errada debería obtener error de acceso")
	public void consultaSuperHeroeDeberiaObtenerErrorAcceso() throws Exception {
		//Arrange,Act	
		List<UsuarioSolicitud> listaUsuarios=new ArrayList<UsuarioSolicitud>();
		//uscMock es igual a usuario con privilegios de solo consultas
		//ucmMock es igual a usuario con privilegios de consultas modificación
		//ucmeMock es igual a usuario con privilegios de consultas, modificación y eliminación
		listaUsuarios.add(uscMock);
		listaUsuarios.add(ucmMock);
		listaUsuarios.add(ucmeMock);
		uscMock.setContrasenia("clave-errada");
		ucmMock.setContrasenia("clave-errada");	
		ucmeMock.setContrasenia("clave-errada");	
		
		//Act
		for(UsuarioSolicitud usuario:listaUsuarios) {
			//Resultado integracion autenticacion
			String jwtToken=autenticar(usuario,403,false);
			
			EntidadRespuesta<List<ProductoModel>> listaSuperHero=mvc(http.GET, urlSuperHeroe,jwtToken,mapTipoListaSuperHeroeModel);
			EntidadRespuesta<List<ProductoModel>> superHeroeResultado=mvc(http.GET, urlSuperHeroePorID.replace(":id", String.valueOf(2)),jwtToken,mapTipoListaSuperHeroeModel);
			EntidadRespuesta<List<ProductoModel>> listaSuperHeroeNombreContenga=mvc(http.GET, urlSuperHeroeNombreContenga.replace(":nombre","man"),jwtToken,mapTipoListaSuperHeroeModel);
			
			//Assert
			assertEquals(401,listaSuperHero.getEstatus(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroe));
			assertEquals(null,listaSuperHero.getData(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroe));
			
			assertEquals(401,superHeroeResultado.getEstatus(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroePorID));
			assertEquals(null,superHeroeResultado.getData(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroePorID));
			
			assertEquals(401,listaSuperHeroeNombreContenga.getEstatus(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroeNombreContenga));
			assertEquals(null,listaSuperHeroeNombreContenga.getData(),String.format("%s :%s",usuario.getUsuario(), urlSuperHeroeNombreContenga));
		}
	}			
	
	@Test
	@DisplayName("Actualizar Súper Héroe con autenticación y privilegios de acceso debería procesar correctamente")
	public void actualizaSuperHeroeDeberiProcesarCorrectamente() throws UnsupportedEncodingException, Exception {
		//Arrange
		PostProductoSolicitud postProductoSolicitud =new PostProductoSolicitud();
		//Indicar la identificaciones obligatorio
		//postProductoSolicitud.setId(2);
		//productoSolicitud.setColor("blanco");
		postProductoSolicitud.setNombre("NuevoSuperHeroe");
		
		//Act
		//1era integración autenticación resultado
		//ucmMock es igual a usuario con privilegios de consultas y modificación
		String jwtToken=autenticar(ucmMock);
		
		//2da integracion modificacion resultado
		EntidadRespuesta<ProductoModel>superHeroeResultado=mvc(http.PUT, urlSuperHeroe,jwtToken, postProductoSolicitud,mapTipoSuperHeroeModel);
		
		//Assert
		assertEquals(202, superHeroeResultado.getEstatus());
		assertNotEquals(null, superHeroeResultado.getData());
	//	assertAll("Debería obtener los atributos modificados y sera iguales en el objeto recibido",
			//()-> assertEquals(superHeroeSolicitud.getIdentificacion(),superHeroeResultado.getData().getId()),
			//()-> assertEquals(superHeroeSolicitud.getNombre(),superHeroeResultado.getData().getNombre()),
			//()-> assertEquals(superHeroeSolicitud.getColor(),superHeroeResultado.getData().getColor())
		//);
	}
	
	@Test
	@DisplayName("Actualizar Súper Héroe con autenticación fallida o sin privilegio debería obtener error de acceso")
	public void actualizaSuperHeroeDeberiaObtenerErrorAcceso() throws UnsupportedEncodingException, Exception {
		//Arrange
		PostProductoSolicitud postProductoSolicitud =new PostProductoSolicitud();
		//Indicar la identificaciones obligatorio
		///postProductoSolicitud.setId(2);
		//productoSolicitud.setColor("nuevoColor");
		postProductoSolicitud.setNombre("NuevoSuperHeroe");
		
		//Act
		//1era integración autenticación resultado
		//uscMock es igual a usuario con privilegios de solo consultas
		String jwtToken=autenticar(uscMock);
		
		//2da integracion modificacion resultado
		EntidadRespuesta<ProductoModel>superHeroeResultado=mvc(http.PUT, urlSuperHeroe,jwtToken, postProductoSolicitud,mapTipoSuperHeroeModel);
		
		//Assert
		assertEquals(401, superHeroeResultado.getEstatus());
		assertEquals(null, superHeroeResultado.getData());		
	}

	@Test
	@DisplayName("Eliminar Súper Héroe con autenticación y privilegios de acceso debería procesar correctamente")
	public void eliminarSuperHeroeDeberiProcesarCorrectamente() throws UnsupportedEncodingException, Exception {
		//Arrange
		List<Integer> listaSuperHeroesEliminar=new ArrayList<Integer>();
		listaSuperHeroesEliminar.add(1);
		listaSuperHeroesEliminar.add(2);
		
		//1era integración autenticación resultado
		//ucmeMock es igual a usuario con privilegios de consultas,modificación y eliminación
		String jwtToken=autenticar(ucmeMock);
		
		//Act
		for(Integer identificacion :listaSuperHeroesEliminar) {		
			//2da integracion modificacion resultado
			EntidadRespuesta<ProductoModel> superHeroeResultado=mvc(http.DELETE,
					urlSuperHeroePorID.replace(":id", String.valueOf(identificacion)),
					jwtToken,mapTipoSuperHeroeModel);
			
			//Assert
			assertEquals(202, superHeroeResultado.getEstatus());
			assertNotEquals(null, superHeroeResultado.getData());
			assertEquals(identificacion, superHeroeResultado.getData().getId());	
		}								
	}
	
	@Test
	@DisplayName("Eliminar Súper Héroe con autenticación fallida o sin privilegio debería obtener error de acceso")
	public void eliminarSuperHeroeDeberiaObtenerErrorAcceso() throws UnsupportedEncodingException, Exception {
		//Arrange
		List<Integer> listaSuperHeroesEliminar=new ArrayList<Integer>();
		listaSuperHeroesEliminar.add(1);
		listaSuperHeroesEliminar.add(2);
		
		//1era integración autenticación resultado
		//uscMock es igual a usuario con privilegios de solo consultas
		String jwtToken=autenticar(uscMock);
		
		//Act
		for(Integer identificacion :listaSuperHeroesEliminar) {		
			//2da integracion modificacion resultado
			EntidadRespuesta<ProductoModel> superHeroeResultado=mvc(http.DELETE,
					urlSuperHeroePorID.replace(":id", String.valueOf(identificacion)),
					jwtToken,mapTipoSuperHeroeModel);
			
			//Assert
			assertEquals(401, superHeroeResultado.getEstatus());
			assertEquals(null, superHeroeResultado.getData());			
		}	
	}
}
