package idat.pe.app_catalogo_service.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import idat.pe.app_catalogo_service.dto.ProductoDtoRequest;
import idat.pe.app_catalogo_service.dto.ProductoDtoResponse;
import idat.pe.app_catalogo_service.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired private ProductoService service;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping
    public ResponseEntity<List<ProductoDtoResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductoDtoResponse>> listarPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(service.listarPorCategoria(categoriaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDtoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoDtoResponse> crear(
            @RequestParam("categoriaId") Long categoriaId,
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "marca", required = false) String marca,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam("costo") Float costo,
            @RequestParam("precioMin") BigDecimal precioMin,
            @RequestParam(value = "precioMax", required = false) BigDecimal precioMax,
            @RequestParam("stock") Integer stock,
            @RequestParam("file") MultipartFile file) throws IOException {

        String imageUrl = guardarImagen(file);

        ProductoDtoRequest request = new ProductoDtoRequest();
        request.setCategoriaId(categoriaId);
        request.setNombre(nombre);
        request.setMarca(marca);
        request.setDescripcion(descripcion);
        request.setCosto(costo);
        request.setPrecioMin(precioMin);
        request.setPrecioMax(precioMax);
        request.setStock(stock);
        request.setImagen(imageUrl);

        return ResponseEntity.ok(service.crear(request));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoDtoResponse> actualizar(
            @PathVariable Long id,
            @RequestParam("categoriaId") Long categoriaId,
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "marca", required = false) String marca,
            @RequestParam(value = "descripcion", required = false) String descripcion,
            @RequestParam("costo") Float costo,
            @RequestParam("precioMin") BigDecimal precioMin,
            @RequestParam(value = "precioMax", required = false) BigDecimal precioMax,
            @RequestParam("stock") Integer stock,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        String imageUrl = null;
        if (file != null && !file.isEmpty()) {
            imageUrl = guardarImagen(file);
        }

        ProductoDtoRequest request = new ProductoDtoRequest();
        request.setCategoriaId(categoriaId);
        request.setNombre(nombre);
        request.setMarca(marca);
        request.setDescripcion(descripcion);
        request.setCosto(costo);
        request.setPrecioMin(precioMin);
        request.setPrecioMax(precioMax);
        request.setStock(stock);
        request.setImagen(imageUrl);

        return ResponseEntity.ok(service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    private String guardarImagen(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String extension = "";
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }
        String fileName = UUID.randomUUID().toString() + extension;

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + fileName;
    }
}
