package com.example.autocomplete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class AutoCompleteApplication{


	public static void main(String[] args) {
		SpringApplication.run(AutoCompleteApplication.class, args);
	}



}
