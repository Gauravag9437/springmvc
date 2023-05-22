package springmvc.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.dto.TshirtSearchDto;
import springmvc.model.Tshirt;
import springmvc.service.ProductService;
import springmvc.validation.inputValidation;

@Controller
public class RequiredTshirtController {

	static ArrayList<Tshirt> list = new ArrayList<Tshirt>();

	@Autowired
	private TshirtSearchDto tshirtDto;

	@Autowired
	private ProductService productService;

	@Autowired
	private inputValidation inputval;

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("logout", "logout successfully!!!!");
		modelAndView.setViewName("index");

		return modelAndView;
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public ModelAndView dto(@ModelAttribute TshirtSearchDto tshirtSearchDto) {
		ModelAndView modelAndView = new ModelAndView();

		this.tshirtDto = this.inputval.getInput(tshirtSearchDto);

		String color = this.tshirtDto.getColor();
		String gender = this.tshirtDto.getGender();
		String size = this.tshirtDto.getSize();
		String outputPreference = this.tshirtDto.getPreference();

		if (color == null || size == null || gender == null || outputPreference == null) {
			String error = "Please type valid input such as Color:Black/Purple/White/Blue/Grey/Pink/Yellow/Maroon and Size:S/M/L/XL and Gender:M/F/U and OutputPreference:Price/Rating/Both";

			modelAndView.addObject("error1", error);
			modelAndView.setViewName("home");

		} else {

			try {
				list = this.productService.getMatchingTshirts(tshirtSearchDto);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			modelAndView.setViewName("home");
		}
		return modelAndView;

	}

	public static ArrayList<Tshirt> getList() {
		return list;
	}
}
