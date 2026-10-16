package org.example.eshopnew.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private final PromotionService service;
    private final PromotionMapper mapper;

    @Autowired
    public PromotionController(PromotionService service, PromotionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<Promotion> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Promotion findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Promotion create(@RequestBody CreatePromotionRequest request) {
        return service.create(mapper.toEntity(request));
    }

    @PutMapping("/{id}")
    public Promotion update(@PathVariable UUID id, @RequestBody UpdatePromotionRequest request) {
        return service.update(id, mapper.toEntity(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
