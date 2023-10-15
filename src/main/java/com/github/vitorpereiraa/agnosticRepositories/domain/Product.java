package com.github.vitorpereiraa.agnosticRepositories.domain;

public class Product {
    private String sku;
    private String designation;
    private String description;

    public Product(final String sku, final String designation, final String description) {
        setSku(sku);
        setDescription(description);
        setDesignation(designation);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU is a mandatory attribute of Product.");
        }
        if (sku.length() != 12) {
            throw new IllegalArgumentException("SKU must be 12 characters long.");
        }

        this.sku = sku;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation == null || designation.isBlank()) {
            throw new IllegalArgumentException("Designation is a mandatory attribute of Product.");
        }
        if (designation.length() > 50) {
            throw new IllegalArgumentException("Designation must not be greater than 50 characters.");
        }
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is a mandatory attribute of Product.");
        }

        if (description.length() > 1200) {
            throw new IllegalArgumentException("Description must not be greater than 1200 characters.");
        }

        this.description = description;
    }

    public void updateProduct(Product p) {
        setDesignation(p.designation);
        setDescription(p.description);
    }
}

