package net.sevecek.zakladniwebapp;

import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
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

        for (Rostlina rostlina : rostliny) {
            doplnCinnostiDoRostliny(rostlina);
        }

        modelAndView.addObject("rostliny", rostliny);
        modelAndView.addObject("mesice", seznamMesicu());
        return modelAndView;
    }

    private void doplnCinnostiDoRostliny(Rostlina rostlina) {
        List<CinnostVMesici> cinnostiVMesici = praceSDatabazi.nactiCinnostiVMesicichProRostlinu(rostlina.getId());

        Map<Integer, List<String>> cinnostiPodleMesicu = new LinkedHashMap<Integer, List<String>>();

        cinnostiPodleMesicu.put(1, new ArrayList<>());
        cinnostiPodleMesicu.put(2, new ArrayList<>());
        cinnostiPodleMesicu.put(3, new ArrayList<>());
        cinnostiPodleMesicu.put(4, new ArrayList<>());
        cinnostiPodleMesicu.put(5, new ArrayList<>());
        cinnostiPodleMesicu.put(6, new ArrayList<>());
        cinnostiPodleMesicu.put(7, new ArrayList<>());
        cinnostiPodleMesicu.put(8, new ArrayList<>());
        cinnostiPodleMesicu.put(9, new ArrayList<>());
        cinnostiPodleMesicu.put(10, new ArrayList<>());
        cinnostiPodleMesicu.put(11, new ArrayList<>());
        cinnostiPodleMesicu.put(12, new ArrayList<>());

        for (CinnostVMesici cinnostVMesici : cinnostiVMesici) {

            int mesic = cinnostVMesici.getMesic();
            cinnostiPodleMesicu.get(mesic).add(cinnostVMesici.getCinnost());
        }

        rostlina.setCinnostiPodleMesicu(cinnostiPodleMesicu);
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

        // presunout do Rostliny a umožnit získat pomocí metod

        List<String> nazvyCinnosti = praceSDatabazi.nactiNazvyCinnosti();

        HashMap<String, List<Integer>> mapaCinnosti = vytvorMapuCinnosti(nazvyCinnosti);

        List<CinnostVMesici> cinnostiVMesici = praceSDatabazi.nactiCinnostiVMesicichProRostlinu(id);

        naplnMapuCinnosti(mapaCinnosti, cinnostiVMesici);

        modelAndView.addObject("nazvyCinnosti", nazvyCinnosti);
        modelAndView.addObject("mapaCinnosti", mapaCinnosti);

        modelAndView.addObject("rostlina", praceSDatabazi.nactiDetailRostliny(id));
        modelAndView.addObject("mesice", seznamMesicu());

        return modelAndView;
    }

    private void naplnMapuCinnosti(HashMap<String, List<Integer>> mapaCinnosti, List<CinnostVMesici> cinnostiVMesici) {
        for (CinnostVMesici cinnost : cinnostiVMesici) {
            List<Integer> prihradkaCinnosti = mapaCinnosti.get(cinnost.getCinnost());
            prihradkaCinnosti.add(cinnost.getMesic());
        }
    }

    private HashMap<String, List<Integer>> vytvorMapuCinnosti(List<String> nazvyCinnosti) {
        HashMap<String, List<Integer>> mapaCinnosti = new LinkedHashMap<>();

        for (String nazev : nazvyCinnosti) {
            mapaCinnosti.put(nazev, new ArrayList<>());
        }
        return mapaCinnosti;
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
