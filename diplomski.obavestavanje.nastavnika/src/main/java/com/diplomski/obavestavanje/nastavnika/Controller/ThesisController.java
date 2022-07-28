package com.diplomski.obavestavanje.nastavnika.Controller;



import com.diplomski.obavestavanje.nastavnika.Model.JsonModel;
import com.diplomski.obavestavanje.nastavnika.Model.Thesis;

import com.diplomski.obavestavanje.nastavnika.Service.ParsingService;
import com.diplomski.obavestavanje.nastavnika.Service.ThesisService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ThesisController {

    private static final String MAIN_PAGE = "main";
    private static final String JSON_URL = "http://localhost:3000/diplomski";

    @Autowired
    private ParsingService parsingService;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    ThesisService thesisService;

    @GetMapping
    @Scheduled(cron = "0 0 0 * * *")
    public String main() {

        JsonNode jsonNode = (JsonNode) parsingService.parse(JSON_URL);

        List<JsonModel> dataModel = mapper.convertValue(jsonNode, new TypeReference<List<JsonModel>>() { });
        System.out.println(dataModel);
        dataModel.forEach(object -> thesisService.saveThesis(object));
        return MAIN_PAGE;
    }
    @GetMapping("find/{startPeriod}/{endPerion}")
    public List<Thesis> returnAllByThesisDateOfDefenseBetween(
            @RequestParam("startPeriod") Date startPeriod,
            @RequestParam("endPerion")Date endPerion){
        return thesisService.returnAllByThesisDateOfDefenseBetween(startPeriod,endPerion);

    }
}
