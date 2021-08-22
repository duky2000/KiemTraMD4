package Controller;

import Model.Staff;
import Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    StaffService staffService;
    @RequestMapping("/staff")
    public ModelAndView homeStaff(@PageableDefault(size = 2)Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list",staffService.findAllPage(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("staff",new Staff());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView ShowFormEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("staff",staffService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("staff",staffService.findById(id));
        return modelAndView;
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam("findName") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", staffService.findAllByName(name));
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showFormView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("staff", staffService.findById(id));
        return modelAndView;

    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Staff staff, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("staff",staff);
            return modelAndView;
        }
        staffService.save(staff);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff");
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Staff staff) {
        staffService.save(staff);
        return "redirect:/staff";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        staffService.delete(staffService.findById(id));
        return "redirect:/staff";
    }

}
