package pe.com.fas.bookito.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.fas.bookito.model.UsuarioCurso;
import pe.com.fas.bookito.service.IUsuarioCursoService;

@RestController
@RequestMapping("/usuario_cursos")
public class UsuarioCursoController {

	@Autowired
	private IUsuarioCursoService service;
	
	@ApiOperation(value = "Obtener lista de UsuarioCursos", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioCurso> getUsuarioCursos() {
		List<UsuarioCurso> list = new ArrayList<UsuarioCurso>();
		try {
			list = service.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@ApiOperation(value = "Obtener UsuarioCurso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioCurso getUsuarioCurso(@PathVariable("id") Long id) {
		UsuarioCurso UsuarioCurso = new UsuarioCurso();
		try {
			UsuarioCurso = service.findOne(id);
			return UsuarioCurso;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@ApiOperation(value = "Guardar un nuevo UsuarioCurso", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> save(@RequestBody UsuarioCurso UsuarioCurso) {
		try {
			service.save(UsuarioCurso);
			return new ResponseEntity<>("UsuarioCurso ingresado correctamente", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo ingresar UsuarioCurso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Actualizar un UsuarioCurso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody UsuarioCurso UsuarioCurso) {
		UsuarioCurso obj = new UsuarioCurso();
		obj = service.findOne(id);
		if(obj != null) {
			try {
				service.save(UsuarioCurso);
				return new ResponseEntity<>("UsuarioCurso actualizado correctamente", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>("No se pudo actualizar UsuarioCurso", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<>("No se pudo encontrar el UsuarioCurso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Eliminar un UsuarioCurso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping("/delete/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			service.delete(id);
			return new ResponseEntity<>("El UsuarioCurso ha sido eliminado con éxito", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo eliminar el UsuarioCurso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
