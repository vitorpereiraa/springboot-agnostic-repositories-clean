package com.github.vitorpereiraa.agnosticRepositories.persistence.document;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductPersistenceMapper;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductSchema;

@Component
@Profile("documentPersistence")
public class ProductDocumentPersistenceMapper implements ProductPersistenceMapper {

    public ProductSchema productToSchema(final Product product){
        return new ProductDocumentSchema(product.getSku(), product.getDesignation(), product.getDescription());
    }

    public Product schemaToProduct(final ProductSchema productSchema){
        return new Product(productSchema.getSku(), productSchema.getDesignation(), productSchema.getDescription());
    }

    public Iterable<Product> schemasToProducts(final Iterable<ProductSchema> productSchemas){
        return StreamSupport
                .stream(productSchemas.spliterator(),false)
                .map(this::schemaToProduct)
                .collect(Collectors.toList());
    }
}
