package com.yyj.product.utils;

import java.util.List;

import com.yyj.product.vo.ProductVO;
import com.yyj.product.vo.ResultVO;

public class ResultVOUtil {
	public static ResultVO  success(Object object){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("success");
		resultVO.setData(object);
		return resultVO;
	}
}
