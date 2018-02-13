/*
package com.github.pawelo98.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class ProductDTOMapper {

    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    public static List<ProductDTO> toProductDTO(Collection<Product> products){
        List<ProductDTO> result = new ArrayList<ProductDTO>();
        for(Product product : products){
            result.add(toProductDTO(product));
        }
        return result;
    }
}

*/

package com.github.pawelo98.product;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTO(Collection<Product> products);
}

