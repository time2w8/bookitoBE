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
import pe.com.fas.bookito.model.BookitoSede;
import pe.com.fas.bookito.service.IBookitoSedeService;

@RestController
@RequestMapping("/api/v1/bokito_sedes")
public class BookitoSedeController {

	@Autowired
	private IBookitoSedeService service;
	
	@ApiOperation(value = "Obtener lista de BookitoSede", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookitoSede> getBookitoSedes() {
		List<BookitoSede> list = new ArrayList<BookitoSede>();
		try {
			list = service.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@ApiOperation(value = "Obtener BookitoSede por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookitoSede getBookitoSede(@PathVariable("id") Long id) {
		BookitoSede obj = new BookitoSede();
		try {
			obj = service.findOne(id);
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@ApiOperation(value = "Guardar un nuevo BookitoSede", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> save(@RequestBody BookitoSede obj) {
		try {
			service.save(obj);
			return new ResponseEntity<>("BookitoSede ingresado correctamente", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo ingresar BookitoSede", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Actualizar un BookitoSede por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody BookitoSede obj) {
		BookitoSede objTemp = new BookitoSede();
		objTemp = service.findOne(id);
		if (objTemp != null) {
			try {
				service.save(obj);
				return new ResponseEntity<>("BookitoSede actualizado correctamente", HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>("No se pudo actualizar BookitoSede", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("No se pudo encontrar el BookitoSede", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Eliminar un BookitoSede por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>("El BookitoSede ha sido eliminada con éxito", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("No se pudo eliminar el BookitoSede", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
