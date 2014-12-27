package fys;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF {

    PDDocument document;
    PDPageContentStream contentStream;

    public PDF() {
        try {
            this.document = new PDDocument();
            PDPage page = new PDPage();
            this.document.addPage(page);
            this.contentStream = new PDPageContentStream(document, page);
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pdfMethod(final int X_START_NORMAL, final int Y_START_NORMAL, int spacingbetweenlines, PDFont boldFont, int headerFontSize, String drawStringNaam) throws IOException {
        this.contentStream.beginText();
        this.contentStream.moveTextPositionByAmount(X_START_NORMAL, (Y_START_NORMAL - spacingbetweenlines));
        this.contentStream.setFont(boldFont, headerFontSize);
        this.contentStream.setNonStrokingColor(Color.black);
        this.contentStream.drawString(drawStringNaam);
        this.contentStream.endText();
    }

    private void normal(PDFont normalFont, int normalFontSize) throws IOException {
        this.contentStream.beginText();
        this.contentStream.moveTextPositionByAmount(40, 650);
        this.contentStream.setFont(normalFont, normalFontSize);
        this.contentStream.setNonStrokingColor(Color.black);
    }

    public void save(String filename) throws COSVisitorException {
        try {
            this.contentStream.close();
            this.document.save(filename);
            this.document.close();
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException ex) {
            return 0;
        }
    }

    public void generateClient(String firstName, String lastName, String country, String city, String zipcode, String streetAddress, String phonenumber,
            String email, String shippingCountry, String shippingZipcode, String shippingStreetAddress, String shippingCity) {

        try {
            this.contentStream.beginText();
            
            PDFont boldFont = PDType1Font.HELVETICA_BOLD;
            PDFont normalFont = PDType1Font.HELVETICA;
            PDFont italicFont = PDType1Font.HELVETICA_OBLIQUE;
            
            final int X_START = 30;
            final int Y_START = 700;
            final int X_START_NORMAL = 40;
            final int X_ANSWER = 200;
            final int Y_START_NORMAL = 600;
            int spacingbetweenlines = 12;
            
            int logoFontSize = 32;
            int headerFontSize = 16;
            int normalFontSize = 12;
            
            String clientInfo = "Name: " + firstName + " " + lastName + "\nEmail: " + email + "\n Phonenumber: "
                    + phonenumber + "\nStreet Address: " + streetAddress + "\nZipcode: " + zipcode + "\nCity: " + city + "\nCountry: "
                    + country;
            String shippingInfo = "Street Address: " + shippingStreetAddress + "\nZipcode: " + shippingZipcode + "\nCity: "
                    + shippingCity + "\nCountry: " + shippingCountry;
            
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, logoFontSize, "Corendon");
            
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize, "Client Information");
            
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize, clientInfo);
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize, "Shipping Information");
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize, shippingInfo);
            
            
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the PDF could be generated.", "PDF Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    public void generateBaggage(String baggageID, String flightNumber, String brand, String color, String description, String caseStatus) {

        try {
            this.contentStream.beginText();
            
            PDFont boldFont = PDType1Font.HELVETICA_BOLD;
            PDFont normalFont = PDType1Font.HELVETICA;
            PDFont italicFont = PDType1Font.HELVETICA_OBLIQUE;
            
            final int X_START = 30;
            final int Y_START = 700;
            final int X_START_NORMAL = 40;
            final int X_ANSWER = 200;
            final int Y_START_NORMAL = 600;
            int spacingbetweenlines = 12;
            
            int logoFontSize = 32;
            int headerFontSize = 16;
            int normalFontSize = 12;
            
            String baggageInfo = "Baggage ID: " + baggageID + "\nFlight Number: " + flightNumber + "\nBrand: " + brand + "\nColor: "
                    + color + "\nDescription: " + description + "\nStatus: " + caseStatus;           

            
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, logoFontSize, "Corendon");
            
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize, "Baggage Information");
            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize, baggageInfo);
    
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the PDF could be generated.", "PDF Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
