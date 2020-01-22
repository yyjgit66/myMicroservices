package com.yyj.user.utils;

import com.yyj.user.enums.ResultEnum;
import com.yyj.user.vo.ResultVO;

public class ResultVOUtil {
	public static ResultVO success(Object object){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		resultVO.setData(object);
		return resultVO;
	}
	
	
	public static ResultVO error(ResultEnum resultEnum){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(resultEnum.getCode());
		resultVO.setMsg(resultEnum.getMessage());
		return resultVO;
	}
	
	
	public static ResultVO success(){
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
}
