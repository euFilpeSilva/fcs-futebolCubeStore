package br.com.loja.fcs.controllers;

import br.com.loja.fcs.domain.dto.ProdutoDTO;
import br.com.loja.fcs.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<ProdutoDTO>> listarP() {
        return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.buscarBlusaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/criar")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.criarBlusa(produtoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProdutoDTO> editarBlusa(@RequestBody ProdutoDTO produtoDTO, @PathVariable Long id) {
        return new ResponseEntity<>(produtoService.editarBlusa(produtoDTO, id), HttpStatus.OK);
    }
}
