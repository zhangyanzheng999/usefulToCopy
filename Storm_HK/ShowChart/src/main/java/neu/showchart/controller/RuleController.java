package neu.showchart.controller;

import neu.showchart.entity.Rule;
import neu.showchart.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class RuleController {
    @Autowired
    RuleRepository ruleRepository;

    @GetMapping("/rules")
    public String TurnToRule() {
        return "rules";
    }

    @PostMapping("/rules/save")
    public String update(Rule rule, Model model) {
        ruleRepository.deleteAll();
        ruleRepository.save(rule);
        model.addAttribute("updateRule","修改成功！");
        return "rules";
    }
}
