package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Component
@Primary
public class FileCustomerLogger implements CustomerLogger {
    private String fileName;

    @Autowired
    public FileCustomerLogger() {
        this.fileName = "log.txt";          //tutaj nie jestem pewien - dopytać
    }

    @Override
    public void log() {
        Path path=Paths.get(fileName);
        String log= LocalDateTime.now()+":\tCustomer Operation\n";
        try {
            if (!Files.exists(path)){
                Files.createFile(path);
            }
            Files.write(path,log.getBytes(StandardCharsets.UTF_8), APPEND);
        } catch (IOException e) {
            System.out.println("coś nie poszło");
            e.printStackTrace();
        }
    }
}
