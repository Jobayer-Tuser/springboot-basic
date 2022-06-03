package com.stmanagment.sts.controller;

import com.stmanagment.sts.model.Student;
import com.stmanagment.sts.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {
    
    @Autowired
    StudentService studentService;

    //Save the uploaded file to this folder
    @Value("${file.upload-dir}") // to get value from application.properties file.
    private static String UPLOADED_FOLDER = "F://temp//";

    @PostMapping
    public String store(@RequestBody Student student) {

        studentService.saveStudent(student);
        return "Student created";
    }

    @GetMapping("/index")
    public List<Student> index(){
        return studentService.getAllStudents();
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "File is empty";
        }

        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        return "File Uploaded successfully";
    }
}
