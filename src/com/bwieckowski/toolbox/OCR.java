package com.bwieckowski.toolbox;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCR {

    public String doOCR(String inputFilePath, String tesseractPath, String language) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tesseractPath);
        //tesseract.setLanguage();
        return tesseract.doOCR(new File(inputFilePath));
    }

    public String doOCR(String inputFilePath, String tesseractPath) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tesseractPath);
        //tesseract.setLanguage();
        File file = new File(inputFilePath);
        if(file.canRead()) {
            return tesseract.doOCR(file);
        } else{
            return "Permission denied";
        }
    }
}
