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

/**
 * This class creates PDF-documents by saying what text should go where and what fonts should be
 * used.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class PDF {

    PDDocument document;
    PDPageContentStream contentStream;

    /**
     * Creates a new document and adds the first page.
     */
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

    /**
     * Initiates settings for location of text and fonts.
     *
     * @param X_START_NORMAL
     * @param Y_START_NORMAL
     * @param spacingBetweenLines
     * @param boldFont
     * @param headerFontSize
     * @param drawStringNaam
     * @throws IOException
     */
    private void pdfMethod(final int X_START_NORMAL, final int Y_START_NORMAL,
            int spacingBetweenLines, PDFont boldFont, int headerFontSize,
            String drawStringNaam) throws IOException {

        this.contentStream.beginText();
        this.contentStream.moveTextPositionByAmount(X_START_NORMAL,
                (Y_START_NORMAL - spacingBetweenLines));
        this.contentStream.setFont(boldFont, headerFontSize);
        this.contentStream.setNonStrokingColor(Color.black);
        this.contentStream.drawString(drawStringNaam);
        this.contentStream.endText();
    }

    /**
     * A standard preset.
     *
     * @param normalFont
     * @param normalFontSize
     * @throws IOException
     */
    private void normal(PDFont normalFont, int normalFontSize) throws IOException {
        this.contentStream.beginText();
        this.contentStream.moveTextPositionByAmount(40, 650);
        this.contentStream.setFont(normalFont, normalFontSize);
        this.contentStream.setNonStrokingColor(Color.black);
    }

    /**
     * Saves the generated PDF-document on the HDD with the received filename.
     *
     * @param filename
     * @throws COSVisitorException
     */
    public void save(String filename) throws COSVisitorException {
        try {
            this.contentStream.close();
            this.document.save(filename);
            this.document.close();
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Calculates how many pixels String s would take up with the used font and font size.
     *
     * @param s
     * @param font
     * @param fontSize
     * @return the amount of pixels String s takes up
     */
    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException ex) {
            return 0;
        }
    }

    /**
     * Writes all received client-variables into the PDF-document.
     *
     * @param firstName
     * @param lastName
     * @param country
     * @param city
     * @param zipCode
     * @param streetAddress
     * @param phoneNumber
     * @param email
     * @param shippingCountry
     * @param shippingZipCode
     * @param shippingStreetAddress
     * @param shippingCity
     */
    public void generateClient(String firstName, String lastName, String country, String city,
            String zipCode, String streetAddress, String phoneNumber, String email,
            String shippingCountry, String shippingZipCode, String shippingStreetAddress,
            String shippingCity) {

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

            String clientInfo = "Name: " + firstName + " " + lastName + "\nEmail: " + email
                    + "\n Phonenumber: " + phoneNumber + "\nStreet Address: " + streetAddress
                    + "\nZipcode: " + zipCode + "\nCity: " + city + "\nCountry: " + country;

            String shippingInfo = "Street Address: " + shippingStreetAddress + "\nZipcode: "
                    + shippingZipCode + "\nCity: " + shippingCity + "\nCountry: " + shippingCountry;

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, logoFontSize,
                    "Corendon");

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize,
                    "Client Information");

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize,
                    clientInfo);

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize,
                    "Shipping Information");

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize,
                    shippingInfo);

        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "An error occured and the PDF could not be generated.", "PDF Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Writes all received baggage-variables into the PDF-document.
     *
     * @param baggageID
     * @param flightNumber
     * @param brand
     * @param color
     * @param description
     * @param caseStatus
     */
    public void generateBaggage(String baggageID, String flightNumber, String brand, String color,
            String description, String caseStatus) {

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

            String baggageInfo = "Baggage ID: " + baggageID + "\nFlight Number: " + flightNumber
                    + "\nBrand: " + brand + "\nColor: " + color + "\nDescription: " + description
                    + "\nStatus: " + caseStatus;

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, logoFontSize,
                    "Corendon");

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, headerFontSize,
                    "Baggage Information");

            pdfMethod(X_START_NORMAL, Y_START_NORMAL, spacingbetweenlines, boldFont, normalFontSize,
                    baggageInfo);

        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "An error occured and the PDF could not be generated.", "PDF Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
