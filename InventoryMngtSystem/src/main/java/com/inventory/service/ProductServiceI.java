package com.inventory.service;

import java.util.List;
import java.util.Map;

import com.inventory.entity.ProductEntity;
import com.inventory.exception.ProductException;
import com.inventory.model.ProductModel;

public interface ProductServiceI {


	public ProductEntity addProductDetails(ProductModel productModel);

	public boolean isProductsDetailValid(ProductModel productDetails);

	public List<ProductModel> listProductDetails() throws ProductException;

	public boolean isProductExist(String productDesc);

	public ProductModel searchProductByDescription(String productDesc) throws ProductException;

	public void deleteProductDetails(Integer productDesc);

	public boolean isProductExistByID(Integer productId);

	public void updateProductDetails(Integer productId, ProductModel productModel);

}
