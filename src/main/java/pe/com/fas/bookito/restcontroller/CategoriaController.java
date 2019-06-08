package pe.com.fas.bookito.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.com.fas.bookito.model.Categoria;
import pe.com.fas.bookito.service.ICategoriaService;

@RestController
@RequestMapping("/categorias")
@Api(value = "categorias", description = "Operaciones para la entidad Categoría")
@CrossOrigin(origins = "*")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;

	@ApiOperation(value = "Obtener lista de categorias", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getCategorias() {
		List<Categoria> list = new ArrayList<>();
		try {
			list = service.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@ApiOperation(value = "Obtener categoria por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria getCategoria(@PathVariable("id") Long id) {
		Categoria obj = new Categoria();
		try {
			obj = service.findOne(id);
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@ApiOperation(value = "Guardar una nueva categoria", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpStatus save(@RequestBody Categoria obj) {
		try {
			service.save(obj);
			return HttpStatus.OK;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo guarda la Categoría");
		}
	}

	@ApiOperation(value = "Actualizar una categoria por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpStatus update(@PathVariable("id") Long id, @RequestBody Categoria obj) {
		Categoria objTemp = new Categoria();
		objTemp = service.findOne(id);
		if (objTemp != null) {
			try {
				service.save(obj);
				return HttpStatus.OK;
			} catch (Exception e) {
				// TODO: handle exception
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar la Categoría");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la categoría");
		}
	}

	@ApiOperation(value = "Eliminar una categoria por ID", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HttpStatus delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return HttpStatus.OK;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo eliminar la Categoría");
		}
	}

}
