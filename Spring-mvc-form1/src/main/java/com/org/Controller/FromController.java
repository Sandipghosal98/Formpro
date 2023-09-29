package com.org.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.Dao.FormDao;
import com.org.Dto.Form;
@Controller
public class FromController {
	@RequestMapping("/save")
	public ModelAndView saveForm(@ModelAttribute Form f) {
		ModelAndView mav = new ModelAndView("Home.jsp");
		boolean result = FormDao.saveValue(f);
		if(result) {
			mav.addObject("msg","data saved");
		}else {
			mav.addObject("msg" , "something wrong");
		}
		return mav;
	}
	
	@RequestMapping("/get")
	public String getForm(HttpSession hs) {
		List<Form> em = FormDao.getALLForms();
		hs.setAttribute("em", em);
		return "Display.jsp";
	}
	
	@RequestMapping("/update")
	public ModelAndView updateForm(@ModelAttribute Form f) {
		FormDao.updateForm(f);
		ModelAndView mav = new ModelAndView("get");
		mav.addObject("msg", "data update successfully");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteForm(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("get");
		boolean res = FormDao.deleteForm(id);
		mav.addObject("msg", "data delete successfully");
		return mav;
	}
	@RequestMapping("/edit")
	public ModelAndView editForm(@RequestParam int id) {
		Form f = FormDao.findById(id);
		ModelAndView mav = new ModelAndView("update.jsp");
		mav.addObject("stu", f);
		return mav;
	}
	
}
