package com.jeomo.masterdata.service;

import com.jeomo.masterdata.dto.MallDto;

/**
 * @Author: qbt
 * @Date: 2020/5/8 22:13
 * @Version 1.0
 */
public interface IMallService {

   MallDto queryMallByCode(String mallCode);


}
