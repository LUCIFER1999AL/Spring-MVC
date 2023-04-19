package com.example.patientsmvc.web;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.IpatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private IpatientRepository ipatientRepository;

    @GetMapping(path = "/index")
    public String Patient(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "Nom", defaultValue = "") String Nom)
    {

        Page<Patient> patient = ipatientRepository.findByNomContains(Nom,  PageRequest.of(page,size));
        model.addAttribute("listPatients", patient.getContent());
        model.addAttribute("pages", new int[patient.getTotalPages()]);
        model.addAttribute("Nom", Nom);
        model.addAttribute("currentPage", page);

        return "patients";

    }

    @GetMapping(path = "/delete")
    public String DeletePatient(Long id, String Nom, int page){
        ipatientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&Nom=" + Nom;
    }

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path = "/patients")
    @ResponseBody
    public List<Patient> listPatients(){
       return ipatientRepository.findAll();
    }
}
