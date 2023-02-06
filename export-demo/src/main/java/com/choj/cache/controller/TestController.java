package com.choj.cache.controller;

import com.choj.cache.controller.vo.req.TestReq;
import com.choj.cache.controller.vo.resp.TestVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TestController
 *
 * @author behappyto.cn
 * @date 2022/09/21 20:28
 */
@RestController
@RequestMapping("/demo")
public class TestController {

    @GetMapping("/test1")
    public List<TestVO> test(Integer currentPage) {
        System.out.println(currentPage);
        if (currentPage > 10000) {
            return new ArrayList<>();
        }
        List<TestVO> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestVO testVO = new TestVO();
            testVO.setName("name_" + i);
            testVO.setSex("set_" + i);
            list.add(testVO);
        }
        return list;
    }

    @GetMapping("/test2")
    public List<TestVO> test2(Integer currentPage) {
        System.out.println(currentPage);
        if (currentPage > 10000) {
            return new ArrayList<>();
        }
        List<TestVO> list = new ArrayList<>();
        for (int i = 100; i < 200; i++) {
            TestVO testVO = new TestVO();
            testVO.setName("name_" + i);
            testVO.setSex("set_" + i);
            list.add(testVO);
        }
        return list;
    }

    @PostMapping("/test3")
    public List<TestVO> test3(@RequestBody TestReq testReq) {
        System.out.println(testReq);
        if (testReq.getCurrentPage() > 10) {
            return new ArrayList<>();
        }
        List<TestVO> list = new ArrayList<>();
        for (int i = 200; i < 300; i++) {
            TestVO testVO = new TestVO();
            testVO.setName("name_" + i);
            testVO.setSex("set_" + i);
            list.add(testVO);
        }
        return list;
    }

    @PostMapping("/test4")
    public List<TestVO> test4(@RequestBody TestReq testReq) {
        System.out.println(testReq);
        if (testReq.getCurrentPage() > 10) {
            return new ArrayList<>();
        }
        List<TestVO> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            TestVO testVO = new TestVO();
            testVO.setName("name_" + i);
            testVO.setSex("set_" + i);
            list.add(testVO);
        }
        return list;
    }
}
