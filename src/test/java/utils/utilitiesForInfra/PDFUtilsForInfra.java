package utils.utilitiesForInfra;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFUtilsForInfra {
    private static final Logger log = Logger.getLogger(PDFUtilsForInfra.class);

    public static String getTextFromPdfFile(String filePath) {
        log.info(String.format("Read text from a file %s", filePath));

        String pdfText = null;
        File myFile = new File(filePath);

        try(PDDocument doc = PDDocument.load(myFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            pdfText = stripper.getText(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pdfText;
    }
}
