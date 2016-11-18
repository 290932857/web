package com.e6wifi.cmp.business.sys.right.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.common.model.ResponseJson;

@Controller
public class ResourcesController {

	static final Logger logger = LoggerFactory.getLogger(ResourcesController.class);

	@RequestMapping(value = "/sys/getResources", method = RequestMethod.POST)
	@ResponseBody
	public void getResources(@RequestParam Integer rid, @RequestParam Integer roleCode) {
		ResponseJson json = new ResponseJson();
		json.setSuccess(true);
	}

}
