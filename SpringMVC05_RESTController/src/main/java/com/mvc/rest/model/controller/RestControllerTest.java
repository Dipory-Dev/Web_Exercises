package com.mvc.rest.model.controller;

import com.mvc.rest.model.biz.RestBiz;
import com.mvc.rest.model.dto.RestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RestControllerTest {

    @Autowired
    private RestBiz biz;

    @RequestMapping(value = "/restdto", method = RequestMethod.GET)
    public List<RestDto> getRest() {
        List<RestDto> res = new ArrayList<RestDto>();
        res = biz.selectAll();
        return res;
    }

    @RequestMapping(value = "/restdto/{restno}", method = RequestMethod.GET)
    public RestDto selectOne(@PathVariable int restno) {
        RestDto res = new RestDto();
        res = biz.selectOne(restno);
        return res;
    }

    @RequestMapping(value = "/restdto", method = RequestMethod.POST)
    public Map<String, Integer> insert(RestDto dto) {
        Map<String, Integer> map = new HashMap<>();
        int res = biz.insert(dto);

        if (res > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 404);
        }
        return map;
    }

    @RequestMapping(value = "/restdto/{restno}", method = RequestMethod.DELETE)
    public Map<String, Integer> deleteRest(@PathVariable int restno) {
        Map<String, Integer> map = new HashMap<>();
        int res = biz.delete(restno);
        if (res > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 404);
        }
        return map;
    }

    @RequestMapping(value = "/restdto", method = RequestMethod.PUT)
    public Map<String, Integer> update(RestDto dto) {
        Map<String, Integer> map = new HashMap<>();
        int res = biz.update(dto);
        if (res > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 404);
        }
        return map;
    }
}
