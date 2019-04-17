package com.jeomo;

import com.jeomo.common.vo.ParameterInvalidItem;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

/**
 * @Author: qbt
 * @Date: 2019/4/10 23:32
 * @Version 1.0
 */
public class ConvertUtil {

    public static List<ParameterInvalidItem> convertCVSetToParameterInvalidItemList(Set<ConstraintViolation<?>> constraintViolations) {
        return null;
    }

    public static List<ParameterInvalidItem> convertBindingResultToMapParameterInvalidItemList(BindingResult bindingResult) {
        return null;
    }
}
