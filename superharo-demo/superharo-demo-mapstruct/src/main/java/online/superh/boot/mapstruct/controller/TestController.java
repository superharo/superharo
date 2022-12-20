package online.superh.boot.mapstruct.controller;

import online.superh.boot.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-20 16:16
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public CommonResult<?> getTest() {
        int test = 1/0;
        return CommonResult.success();
    }

}
