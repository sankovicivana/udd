package com.udd.cls.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;

import com.udd.cls.indexmodel.ContractIndex;
import com.udd.cls.repository.ContractRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DocumentService {
    
    @Autowired
    private ContractRepository contractRepository;

    public void createContract(ContractIndex contract) {
        contractRepository.save(contract);
    }

    public String getTextFromInputStream(InputStream inputStream) {
        PDDocument pdDocument = null;
        try {
            // Create a PDDocument instance by parsing the InputStream directly
            pdDocument = PDDocument.load(inputStream);

            // Extract text from the PDF document using PDFTextStripper
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(pdDocument);

            return text;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the PDDocument in a finally block to ensure it gets closed
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
