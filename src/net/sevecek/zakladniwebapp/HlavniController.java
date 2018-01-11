package net.sevecek.zakladniwebapp;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    @Autowired
    private ZahradkaPraceSDatabazi praceSDatabazi;

    @RequestMapping("/seznam")
    public ModelAndView seznam() {

        ModelAndView modelAndView = new ModelAndView(
                "/WEB-INF/view/seznam.jsp");

        modelAndView.addObject("rostliny", praceSDatabazi.nactiMojeRostliny());

        return modelAndView;
    }

    @RequestMapping("/mesice")
    public ModelAndView mesice() {
        ModelAndView modelAndView = new ModelAndView(
                "/WEB-INF/view/mesice.jsp");

        List<Rostlina> rostliny = praceSDatabazi.nactiMojeRostliny();

        modelAndView.addObject("rostliny", rostliny);
        modelAndView.addObject("mesice", seznamMesicu());
        return modelAndView;
    }

    @RequestMapping(value = "/uprava-zahradky", method = RequestMethod.GET)
    public ModelAndView upravaZahradky() {
        ModelAndView modelAndView = new ModelAndView(
                "/WEB-INF/view/uprava_zahradky.jsp");

        modelAndView.addObject("seznamIdMychRostlin", praceSDatabazi.nactiIdMychRostlin());
        modelAndView.addObject("vsechnyRostliny", praceSDatabazi.nactiVsechnyRostliny());

        return modelAndView;
    }

    @RequestMapping(value = "/uprava-zahradky", method = RequestMethod.POST)
    public String ulozZahradku(@ModelAttribute MojeZahradkaKUlozeni zahradkaKUlozeni) {

        praceSDatabazi.aktualizujZahradku(zahradkaKUlozeni.getRostliny());

        return "redirect:/seznam";
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView(
                "/WEB-INF/view/detail.jsp");

        Rostlina rostlina = praceSDatabazi.nactiDetailRostliny(id);

        modelAndView.addObject("rostlina", rostlina);
        modelAndView.addObject("mesice", seznamMesicu());

        return modelAndView;
    }

    private List<String> seznamMesicu() {
        return Arrays.asList(
                null,
                "leden",
                "únor",
                "březen",
                "duben",
                "květen",
                "červen",
                "červenec",
                "srpen",
                "září",
                "říjen",
                "listopad",
                "prosinec"
        );
    }

}
