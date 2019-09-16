package com.dashuai.learning.thymeleaf.api;

import com.dashuai.learning.thymeleaf.model.Info;
import com.dashuai.learning.thymeleaf.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InfoController {

    public static final String uploadingdir = "/Users/quan/Downloads/uploadingdir/";

    @Autowired
    InfoService infoService;

    @RequestMapping("/info")
    public String index() {
        return "redirect:/info/list";
    }

    @RequestMapping("/info/list")
    public String list(Model model) {
        List<Info> infos = infoService.getInfoList();
        model.addAttribute("infos", infos);
        return "info/list";
    }

    @RequestMapping("/info/toAdd")
    public String toAdd() {
        return "info/infoAdd";
    }

    @RequestMapping("/info/add")
    public String add(Info info, @RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws IOException {

        String uploadFilePath = "";
        for (MultipartFile uploadedFile : uploadFiles) {
            File file = new File(uploadingdir + getStringDate() + "_" + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);

            System.out.println(file.getAbsolutePath());
            uploadFilePath = file.getAbsolutePath();
        }
        info.setUploadPath(uploadFilePath);
        info.setUploadDate(getStringDate());
        infoService.save(info);
        return "redirect:/info/list";
    }

    @RequestMapping("/info/toEdit")
    public String toEdit(Model model, Long id) {
        Info info = infoService.findInfoById(id);
        model.addAttribute("info", info);
        return "info/infoEdit";
    }

    @RequestMapping("/info/edit")
    public String edit(Info info) {
        infoService.edit(info);
        return "redirect:/info/list";
    }


    @RequestMapping("/info/delete")
    public String delete(Long id) {
        infoService.delete(id);
        return "redirect:/info/list";
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    @ResponseBody
    @RequestMapping("/infoList")
    public List<Info> infoList() {
        List<Info> infos = infoService.getInfoList();
        return infos;
    }
}