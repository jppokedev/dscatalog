package com.bitworld.dscatalog.projections;

import com.bitworld.dscatalog.entities.Product;

public interface ProductProjection extends IdProjection<Long> {

    String getName();
}
