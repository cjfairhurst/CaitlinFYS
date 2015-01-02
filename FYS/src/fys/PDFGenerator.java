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
 *
 * @author Lars
 */
public class PDFGenerator {

    PDDocument document;
    PDPageContentStream contentStream;

    public PDFGenerator() {
        try {

            // Create a document and add a page to it
            this.document = PDDocument.load("C:\\Users\\Caitlin\\Documents\\GitHub\\CaitlinFYS\\FYS\\Template.pdf");
            PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
            this.document.addPage(page);

            this.contentStream = new PDPageContentStream(document, page, true, true);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void generateClient(String firstname, String lastname, String country, String city, String zipcode, String address, String phonenumber, String emailaddress,
            String shippingcountry, String shippingzipcode, String shippingaddress, String shippingcity) {
        try {

            System.out.println(firstname + lastname + country + city + zipcode + address + phonenumber + emailaddress + shippingcountry + shippingzipcode + shippingaddress + shippingcity);
            PDFont normalFont = PDType1Font.HELVETICA;

            int spacingbetweenlinesnormalFontSize = 12;
            // header
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

            String[] allvariablesanswers = {firstname, lastname, country, city,
                zipcode, address, phonenumber, emailaddress, shippingcountry,
                shippingzipcode, shippingaddress, shippingcity};

            for (int i = 0; i < allvariablesanswers.length; i++) {
                pdfSetText(setXAnswer, setYStart, normalFont, normalFontSize,
                        allvariablesanswers[i],
                        spacingbetweenlinesnormalFontSize, i);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pdfSetText(int XBegin, int YBegin, PDFont fontType,
            int fontSize, String allVariables,
            int spacingbetweenlinesnormalFontSize, int i) throws IOException {
        this.contentStream.beginText();
        this.contentStream.setFont(fontType, fontSize);
        this.contentStream.moveTextPositionByAmount(XBegin,
                (YBegin - (spacingbetweenlinesnormalFontSize * i)));
        this.contentStream.setNonStrokingColor(Color.black);
        this.contentStream.drawString(allVariables);
        this.contentStream.endText();
    }

    public void save(String filename) {
        try {

            this.contentStream.close();

            this.document.save(filename);
            this.document.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generateBaggage(String flightnumber, String brand, String color, String weight, String description, String Case_Status) {
        try {

            System.out.println(flightnumber + brand + color + weight);
            PDFont normalFont = PDType1Font.HELVETICA;

           
            int spacingbetweenlinesnormalFontSize = 12;
            // header
            int normalFontSize = 12;
            int setXAnswer = 200;
            int setYStart = 670;
            String dateTimeString = dateTime() + "";

            String[] allvariablesanswers = {flightnumber,
                brand, color, weight, description, Case_Status};

            for (int i = 0; i < allvariablesanswers.length; i++) {
                pdfSetText(setXAnswer, setYStart, normalFont, normalFontSize,
                        allvariablesanswers[i],
                        spacingbetweenlinesnormalFontSize, i);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int stringWidth(String s, PDFont font, double fontSize) {
        try {
            return (int) (font.getStringWidth(s) * fontSize / 1000) + 1;
        } catch (IOException ex) {
            // ignore, but return 0
            return 0;
        }
    }

    public Date dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
//	   System.out.println(dateFormat.format(date));
// 
//	   get current date time with Calendar()
//	   Calendar cal = Calendar.getInstance();
//	   System.out.println(dateFormat.format(cal.getTime()));
        return date;
    }

}
