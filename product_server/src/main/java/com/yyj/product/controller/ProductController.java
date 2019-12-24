package com.yyj.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyj.product.common.DecreaseStockInPut;
import com.yyj.product.common.ProductInfoOutPut;
import com.yyj.product.dataobject.ProductCategory;
import com.yyj.product.dataobject.ProductInfo;
import com.yyj.product.service.CategoryService;
import com.yyj.product.service.ProductService;
import com.yyj.product.utils.ResultVOUtil;
import com.yyj.product.vo.ProductInfoVO;
import com.yyj.product.vo.ProductVO;
import com.yyj.product.vo.ResultVO;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	/**
	 * 1.查询所有在架的商品
	 * 2.获取类目type列表
	 * 3.查询类目
	 * 4.构造数据
	 */
	@GetMapping("/productInfo")
	public ResultVO<ProductVO> list(){
		//1.查询所有在架的商品
		List<ProductInfo>  productInfoList = productService.findUpALL();
		//2.获取类目type列表
		List<Integer> categoryTypeList = productInfoList.stream().
				map(ProductInfo::getCategoryType).
				 collect(Collectors.toList());
		
		//3.查询类目
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
		//4.构造数据
		List<ProductVO> productVOList = new ArrayList<>();
		for(ProductCategory category : productCategoryList){
			ProductVO productVo = new ProductVO();
			productVo.setCategoryName(category.getCategoryName());
			productVo.setCategoryType(category.getCategoryType());
			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for(ProductInfo productInfo: productInfoList){
				if(category.getCategoryType().equals(productInfo.getCategoryType())){
					ProductInfoVO po = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, po);
					productInfoVOList.add(po);
				}
			}
			productVo.setProductInfoList(productInfoVOList);
			productVOList.add(productVo);
		}
//		ResultVO<List<ProductVO>> resultVO = new ResultVO<List<ProductVO>>();
//		resultVO.setCode(0);
//		resultVO.setMsg("success");
//		resultVO.setData(productVOList);
		return ResultVOUtil.success(productVOList);
	}
	
	@PostMapping("/listForOrder")
	public List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productList){
		return  productService.findList(productList);
	}
	
	@PostMapping("/decreaseStock")
	public void decreaseStock(@RequestBody List<DecreaseStockInPut> carDtoList){
		productService.decreaseStock(carDtoList);
	}
	
}
