package fys;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PDFGenerator {

    PDDocument document;
    PDPageContentStream contentStream;

    /**
     * Creates a new document for either a client case or a baggage case and adds the first page. A
     * template is being used so our application only has to add text.
     *
     * @param type
     */
    public PDFGenerator(String type) {
        try {
            if (type.equals("baggage")) {
                this.document = PDDocument.load("C:\\Users\\Caitlin\\Documents\\GitHub\\CaitlinFYS"
                        + "\\FYS\\Templatebaggage.pdf");
                PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
                this.document.addPage(page);

                this.contentStream = new PDPageContentStream(document, page, true, true);
            }
            if (type.equals("client")) {
                this.document = PDDocument.load("C:\\Users\\Caitlin\\Documents\\GitHub\\CaitlinFYS"
                        + "\\FYS\\Templateclient.pdf");
                PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
                this.document.addPage(page);

                this.contentStream = new PDPageContentStream(document, page, true, true);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
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
     * @param address
     * @param phoneNumber
     * @param email
     * @param shippingCountry
     * @param shippingZipCode
     * @param shippingAddress
     * @param shippingCity
     */
    public void generateClient(String firstName, String lastName, String country, String city,
            String zipCode, String address, String phoneNumber, String email,
            String shippingCountry, String shippingZipCode, String shippingAddress,
            String shippingCity) {
        try {

            System.out.println(firstName + lastName + country + city + zipCode + address
                    + phoneNumber + email + shippingCountry + shippingZipCode + shippingAddress
                    + shippingCity);
            PDFont normalFont = PDType1Font.HELVETICA;

            int spacingBetweenLinesNormalFontSize = 12;
            int normalFontSize = 12;
            String text = "text";
            int setXStart = 30;
            int setXstartLogo = 20;
            int setystartLogo = 720;
            int setXAnswer = 200;
            int setXemployee = 30;
            int setXemployeeanswer = 200;
            int setYemployeeanswer = 276;
            int setYStart = 670;
            String dateTimeString = dateTime() + "";

            String[] allVariablesAnswers = {firstName, lastName, country, city,
                zipCode, address, phoneNumber, email, shippingCountry,
                shippingZipCode, shippingAddress, shippingCity};

            for (int i = 0; i < allVariablesAnswers.length; i++) {
                pdfSetText(setXAnswer, setYStart, normalFont, normalFontSize,
                        allVariablesAnswers[i], spacingBetweenLinesNormalFontSize, i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Writes all received baggage-variables into the PDF-document.
     *
     * @param flightNumber
     * @param brand
     * @param color
     * @param weight
     * @param description
     * @param caseStatus
     */
    public void generateBaggage(String flightNumber, String brand, String color, String weight,
            String description, String caseStatus) {

        try {
            System.out.println(flightNumber + brand + color + weight);
            PDFont normalFont = PDType1Font.HELVETICA;

            int spacingBetweenLinesNormalFontSize = 12;
            int normalFontSize = 12;
            int setXAnswer = 200;
            int setYStart = 670;
            String dateTimeString = dateTime() + "";

            String[] allVariablesAnswers = {flightNumber, brand, color, weight, description,
                caseStatus};

            for (int i = 0; i < allVariablesAnswers.length; i++) {
                pdfSetText(setXAnswer, setYStart, normalFont, normalFontSize,
                        allVariablesAnswers[i], spacingBetweenLinesNormalFontSize, i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initiates settings for location of text and fonts.
     *
     * @param xBegin
     * @param yBegin
     * @param fontType
     * @param fontSize
     * @param allVariables
     * @param spacingBetweenLinesNormalFontSize
     * @param i a multiplier for spacingBetweenLinesNormalFontSize
     * @throws IOException
     */
    private void pdfSetText(int xBegin, int yBegin, PDFont fontType, int fontSize,
            String allVariables, int spacingBetweenLinesNormalFontSize, int i) throws IOException {

        this.contentStream.beginText();

        this.contentStream.setFont(fontType, fontSize);

        this.contentStream.moveTextPositionByAmount(xBegin, (yBegin
                - (spacingBetweenLinesNormalFontSize * i)));

        this.contentStream.setNonStrokingColor(Color.black);

        this.contentStream.drawString(allVariables);

        this.contentStream.endText();
    }

    /**
     * Saves the generated PDF-document on the HDD with the received filename.
     *
     * @param filename
     */
    public void save(String filename) {
        try {
            this.contentStream.close();
            this.document.save(filename);
            this.document.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
            // ignore and return 0
            return 0;
        }
    }

    /**
     * @return current date
     */
    public Date dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date();

        return date;
    }
}
