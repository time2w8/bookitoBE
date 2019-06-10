package pe.com.fas.bookito.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.fas.bookito.model.Curso;
import pe.com.fas.bookito.service.ICursoService;

@RestController
@RequestMapping("/api/v1/cursos")
@Api(value = "cursos", description = "Operaciones para la entidad Curso")
@Secured("ROLE_ADMIN")
public class CursoController {
	
	@Autowired
	private ICursoService service;
	
	@ApiOperation(value = "Obtener lista de cursos", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> getCursos() {
		List<Curso> list = new ArrayList<Curso>();
		try {
			list = service.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@ApiOperation(value = "Obtener curso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Curso getCurso(@PathVariable("id") Long id) {
		Curso curso = new Curso();
		try {
			curso = service.findOne(id);
			return curso;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@ApiOperation(value = "Guardar un nuevo curso", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> save(@RequestBody Curso curso) {
		try {
			service.save(curso);
			return new ResponseEntity<>("Curso ingresado correctamente", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo ingresar curso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Actualizar un curso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> update(@PathVariable("id") Long id,@RequestBody Curso curso) {
		Curso obj = new Curso();
		obj = service.findOne(id);
		if(obj != null) {
			try {
				service.save(curso);
				return new ResponseEntity<>("Curso actualizado correctamente", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>("No se pudo actualizar curso", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<>("No se pudo encontrar el curso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Eliminar un curso por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping("/delete/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			service.delete(id);
			return new ResponseEntity<>("El curso ha sido eliminado con éxito", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo eliminar el curso", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
