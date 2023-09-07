package br.com.xml.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IAgentesService {

    void processarXml(MultipartFile xmlMultipartFile) throws IOException;
}
