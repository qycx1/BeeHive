package com.hive.modules.shop.domain.factory;

import com.hive.modules.shop.domain.model.Catalog;
import com.hive.shared.id.IDGenerator;

import java.util.ArrayList;

public class DefaultCatalogFactory implements CatalogFactory{

    private final IDGenerator idGenerator;

    public DefaultCatalogFactory(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public Catalog create(String shopId, String name) {
        return new Catalog(idGenerator.generate(), shopId, name, new ArrayList<>());
    }
}