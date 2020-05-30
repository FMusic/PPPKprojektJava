package com.fm.pdf;

import com.fm.model.generated.RoutesEntity;
import com.fm.model.generated.TravelWarrantsEntity;
import okhttp3.Route;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class PDFUtils {
    public static void savePDFFileForWarrant(TravelWarrantsEntity twe, List<RoutesEntity> routes, String path) throws IOException {
        PDDocument doc = new PDDocument();
        doc.addPage(pageForTwe(twe, doc, routes));
        doc.save(path);
        doc.close();
    }

    private static PDPage pageForTwe(TravelWarrantsEntity tw, PDDocument doc, List<RoutesEntity> routes) throws IOException {
        PDPage page = new PDPage();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.beginText();
        //set title
        contentStream.newLineAtOffset(70, 700);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 25);
        contentStream.showText(tw.getIdTwarrant() + " WARRANT");
        contentStream.endText();
        //set data
        int counter = 0;
        int beginY = 750;
        int endY =0;
        contentStream.setFont(PDType1Font.HELVETICA, 15);
        for (int i = 0; i < routes.size(); i++) {
            endY = beginY + 25*i;
            contentStream.beginText();
            contentStream.newLineAtOffset(25, endY);
            contentStream.showText(routes.get(i).toString());
            contentStream.endText();
        }
        // set end text
        contentStream.beginText();
        contentStream.newLineAtOffset(70, endY + 50);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 25);
        contentStream.showText("WARRANT END");
        contentStream.endText();
        contentStream.close();
        return page;
    }
}
