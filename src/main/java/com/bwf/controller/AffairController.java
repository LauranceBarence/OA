package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModule;
import com.bwf.entity.User;
import com.bwf.service.IAffairModuleService;
import com.bwf.service.IAffairRelModulePartService;

@Controller
@RequestMapping("affair")
public class AffairController {
	@Autowired
	IAffairModuleService affairModuleService;

	@Autowired
	IAffairRelModulePartService affairRelModulePartService;

	@Autowired
	com.bwf.service.IAffairService affairService;

	@Autowired
	com.bwf.service.IAffairChainService affairChainService;

	@RequestMapping("show")
	public String show(ModelMap modelMap , HttpSession session) {
		User currentUser = (User) session.getAttribute("user");

		// 我发起的
		List<Affair> affairByMe = affairService.getAffairByMe(currentUser);

		// 等我审批的
		List<Affair> affairToBePropose = affairService.getAffairToBePropose(currentUser);

		modelMap.addAttribute("affairByMe", affairByMe);
		modelMap.addAttribute("affairToBePropose", affairToBePropose);
		modelMap.addAttribute("affairModules", affairModuleService.getAllModules());
		return "affair/show";
	}

	@RequestMapping("detail/{id}")
	public String detail(@PathVariable Integer id, ModelMap model) {

		Affair affair = affairService.getAffairDetailByAffairId(id);
		model.addAttribute("affair", affair);

		return "affair/detail";
	}

	// 公文审批页面
	@RequestMapping("propose/{id}")
	public String propose(@PathVariable Integer id, ModelMap model) {

		Affair affair = affairService.getAffairDetailByAffairId(id);
		model.addAttribute("affair", affair);

		return "affair/propose";
	}

	// 公文审批保存
	@RequestMapping("doPropose")
	public String doPropose(AffairChain affairChain, String propose) {
		if (propose.equals("同意")) {
			affairChain.setAffairChainStatus(2);
		} else {
			affairChain.setAffairChainStatus(3);
		}

		affairChainService.propose(affairChain);

		return "redirect:/affair/show";
	}

	@RequestMapping("add")
	public String add(Integer affairModuleId, ModelMap modelMap) {

		modelMap.addAttribute("moduleOptions",
				affairRelModulePartService.getModulePartsByAffairModuleId(affairModuleId));
		modelMap.addAttribute("affairModuleId", affairModuleId);
		return "affair/add";
	}

	@RequestMapping("doAdd/{affairModuleId}")
	public String doAdd(@PathVariable Integer affairModuleId,String html, HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		Affair affair = new Affair();
		AffairModule affairModule = new AffairModule();
		affairModule.setModuleId(affairModuleId);
		affair.setAffairModule(affairModule);
		affair.setAffairData(html);
		affair.setProposer(currentUser);
		affair.setAffairStatus(0);
		System.out.println(html);
		affairService.add(affair, currentUser);
		return "redirect:/affair/show";
	}
}
