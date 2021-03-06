package fys.sdworker;

import fys.FYS;
import fys.TrackUser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class enables service-desk-workers to create new cases.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class NewCase_Page extends javax.swing.JPanel {

    boolean emptyClientField = false;
    boolean emptyBaggageField = false;
    String caseStatus = "";

    /**
     * Initiates the page, sets a welcome text, hides the warnings and context-aware manual, shows
     * the right panel, makes sure neither a client case nor a baggage case is selected and groups
     * the radio buttons.
     */
    public NewCase_Page() {
        initComponents();
        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");

        emptyfield_warning.setVisible(false);
        emptyfield_warning.setEnabled(false);
        setEnabledClient(false);
        setEnabledBaggage(false);
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);

        ButtonGroup casestatus = new ButtonGroup();
        casestatus.add(found_radiobutton);
        casestatus.add(lost_radiobutton);
        casestatus.add(resolved_radiobutton);

        ButtonGroup casetype = new ButtonGroup();
        casetype.add(client_radiobutton);
        casetype.add(baggage_radiobutton);
    }

    /**
     * Enables fields for a client case if the received boolean is true.
     *
     * @param enabled
     */
    public void setEnabledClient(boolean enabled) {
        firstname_field.setEnabled(enabled);
        lastname_field.setEnabled(enabled);
        email_field.setEnabled(enabled);
        phonenumber_field.setEnabled(enabled);
        streetaddress_field.setEnabled(enabled);
        zipcode_field.setEnabled(enabled);
        city_field.setEnabled(enabled);
        country_field.setEnabled(enabled);
        shippingstreetaddress_field.setEnabled(enabled);
        shippingzipcode_field.setEnabled(enabled);
        shippingcity_field.setEnabled(enabled);
        shippingcountry_field.setEnabled(enabled);
    }

    /**
     * Enables fields for a baggage case if the received boolean is true.
     *
     * @param enabled
     */
    public void setEnabledBaggage(boolean enabled) {
        baggageid_field.setEnabled(enabled);
        flightnumber_field.setEnabled(enabled);
        brand_field.setEnabled(enabled);
        color_field.setEnabled(enabled);
        description_field.setEnabled(enabled);
        found_radiobutton.setEnabled(enabled);
        lost_radiobutton.setEnabled(enabled);
        resolved_radiobutton.setEnabled(enabled);
    }

    /**
     * Saves the case in the database with information in the enabled fields.
     *
     * @param typeCase either a client or a baggage case
     * @throws SQLException
     */
    public void saveCase(String typeCase) throws SQLException {
        String firstName = firstname_field.getText();
        String lastName = lastname_field.getText();
        String email = email_field.getText();
        String telephoneNumber = phonenumber_field.getText();
        String streetAddress = streetaddress_field.getText();
        String zipcode = zipcode_field.getText();
        String city = city_field.getText();
        String country = country_field.getText();
        String shippingStreetAddress = shippingstreetaddress_field.getText();
        String shippingZipcode = shippingzipcode_field.getText();
        String shippingCity = shippingcity_field.getText();
        String shippingCountry = shippingcountry_field.getText();

        String baggageID = baggageid_field.getText();
        String flightNumber = flightnumber_field.getText();
        String brand = brand_field.getText();
        String color = color_field.getText();
        String description = description_field.getText();

        if (found_radiobutton.isSelected()) {
            caseStatus = "found";
        } else if (lost_radiobutton.isSelected()) {
            caseStatus = "lost";
        } else if (resolved_radiobutton.isSelected()) {
            caseStatus = "resolved";
        }

        FYS.getQueryManager().saveCase(typeCase, firstName, lastName, email, telephoneNumber,
                streetAddress, zipcode, city, country, shippingStreetAddress, shippingZipcode,
                shippingCity, shippingCountry, baggageID, flightNumber, brand, color, description,
                caseStatus);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeuser = new javax.swing.JLabel();
        manual_panel = new javax.swing.JPanel();
        exitManual = new javax.swing.JLabel();
        manualTitle = new javax.swing.JLabel();
        manualText = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        call_manual = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        logout_button = new javax.swing.JLabel();
        newcase_button = new javax.swing.JLabel();
        updatecase_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        case_panel = new javax.swing.JPanel();
        brand = new javax.swing.JLabel();
        brand_field = new javax.swing.JTextField();
        flightnumber_field = new javax.swing.JTextField();
        flightnumber = new javax.swing.JLabel();
        baggageid = new javax.swing.JLabel();
        baggageid_field = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description_field = new javax.swing.JTextArea();
        color = new javax.swing.JLabel();
        color_field = new javax.swing.JTextField();
        baggage_radiobutton = new javax.swing.JRadioButton();
        phonenumber_field = new javax.swing.JTextField();
        phone_number = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        last_name = new javax.swing.JLabel();
        lastname_field = new javax.swing.JTextField();
        firstname_field = new javax.swing.JTextField();
        first_name = new javax.swing.JLabel();
        account_type = new javax.swing.JLabel();
        client_radiobutton = new javax.swing.JRadioButton();
        country = new javax.swing.JLabel();
        zipcode = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        streetaddress = new javax.swing.JLabel();
        streetaddress_field = new javax.swing.JTextField();
        city_field = new javax.swing.JTextField();
        zipcode_field = new javax.swing.JTextField();
        country_field = new javax.swing.JTextField();
        shippingstreetaddress = new javax.swing.JLabel();
        shippingstreetaddress_field = new javax.swing.JTextField();
        shippingcity = new javax.swing.JLabel();
        shippingcity_field = new javax.swing.JTextField();
        shippingzipcode = new javax.swing.JLabel();
        shippingzipcode_field = new javax.swing.JTextField();
        shippingcountry = new javax.swing.JLabel();
        shippingcountry_field = new javax.swing.JTextField();
        emptyfield_warning = new javax.swing.JLabel();
        casestatus = new javax.swing.JLabel();
        found_radiobutton = new javax.swing.JRadioButton();
        lost_radiobutton = new javax.swing.JRadioButton();
        resolved_radiobutton = new javax.swing.JRadioButton();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeuser.setForeground(new java.awt.Color(255, 255, 255));
        welcomeuser.setText("Welcome ");
        add(welcomeuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        manual_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        manual_panel.setForeground(new java.awt.Color(153, 0, 0));
        manual_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitManual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitManual.setForeground(new java.awt.Color(153, 153, 153));
        exitManual.setText("x");
        exitManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitManualMouseClicked(evt);
            }
        });
        manual_panel.add(exitManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 0, -1, -1));

        manualTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manualTitle.setForeground(new java.awt.Color(153, 0, 0));
        manualTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manualTitle.setText("MANUAL");
        manual_panel.add(manualTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 20, 280, -1));

        manualText.setForeground(new java.awt.Color(153, 0, 0));
        manualText.setText("<html>\nFirst, select which type of case you wish to make by\nclicking the corresponding radio button. \nThen fill in the given fields with the desired information. \nWhen finished, click on 'Save' to create and save the account. \n<br>\n<br>\nRequired fields are marked with a *.");
        manualText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        manualText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        manual_panel.add(manualText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 520));

        add(manual_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 290, 600));

        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 70));

        call_manual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        call_manual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                call_manualMouseClicked(evt);
            }
        });
        add(call_manual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 22, 30, 30));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("New Case");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        logout_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logout_button.setForeground(new java.awt.Color(153, 0, 0));
        logout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        logout_button.setText("Log Out");
        logout_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_buttonMouseExited(evt);
            }
        });
        add(logout_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 101, 250, -1));

        newcase_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newcase_button.setForeground(new java.awt.Color(153, 0, 0));
        newcase_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
        newcase_button.setText("New Case");
        newcase_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newcase_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newcase_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newcase_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newcase_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newcase_buttonMouseExited(evt);
            }
        });
        add(newcase_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 101, 250, -1));

        updatecase_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatecase_button.setForeground(new java.awt.Color(153, 0, 0));
        updatecase_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        updatecase_button.setText("Update Case");
        updatecase_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatecase_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        updatecase_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatecase_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatecase_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatecase_buttonMouseExited(evt);
            }
        });
        add(updatecase_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 101, 250, -1));

        search_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_button.setForeground(new java.awt.Color(153, 0, 0));
        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        search_button.setText("Search");
        search_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search_buttonMouseExited(evt);
            }
        });
        add(search_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 101, 250, -1));

        save_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save_button.setForeground(new java.awt.Color(255, 255, 255));
        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        save_button.setText("Save");
        save_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                save_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                save_buttonMouseExited(evt);
            }
        });
        add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 590, -1, -1));

        case_panel.setBackground(new java.awt.Color(255, 255, 255));
        case_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brand.setForeground(new java.awt.Color(153, 0, 0));
        brand.setText("Brand:");
        case_panel.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, -1, -1));

        brand_field.setForeground(new java.awt.Color(153, 0, 0));
        brand_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(brand_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 230, 20));

        flightnumber_field.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(flightnumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 230, 20));

        flightnumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        flightnumber.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        flightnumber.setText("Flight Number:");
        case_panel.add(flightnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, -1, -1));

        baggageid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        baggageid.setForeground(new java.awt.Color(153, 0, 0));
        baggageid.setText("Baggage ID:");
        case_panel.add(baggageid, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, -1));

        baggageid_field.setForeground(new java.awt.Color(153, 0, 0));
        baggageid_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(baggageid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 230, 20));

        description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(153, 0, 0));
        description.setText("Description:");
        case_panel.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, -1, -1));

        description_field.setColumns(20);
        description_field.setRows(5);
        jScrollPane1.setViewportView(description_field);

        case_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 230, 80));

        color.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        color.setForeground(new java.awt.Color(153, 0, 0));
        color.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        color.setText("Color:");
        case_panel.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        color_field.setForeground(new java.awt.Color(153, 0, 0));
        color_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(color_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 230, 20));

        baggage_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        baggage_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        baggage_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        baggage_radiobutton.setText("Baggage");
        baggage_radiobutton.setBorder(null);
        baggage_radiobutton.setOpaque(false);
        baggage_radiobutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baggage_radiobuttonMouseClicked(evt);
            }
        });
        case_panel.add(baggage_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, -1));

        phonenumber_field.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(phonenumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 250, 20));

        phone_number.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(153, 0, 0));
        phone_number.setText("Phone Number:");
        case_panel.add(phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 0, 0));
        email.setText("Email:");
        case_panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        email_field.setForeground(new java.awt.Color(153, 0, 0));
        email_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, 20));

        last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name.setForeground(new java.awt.Color(153, 0, 0));
        last_name.setText("Last Name: *");
        case_panel.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lastname_field.setForeground(new java.awt.Color(153, 0, 0));
        lastname_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 250, 20));

        firstname_field.setForeground(new java.awt.Color(153, 0, 0));
        firstname_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 250, 20));

        first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name.setForeground(new java.awt.Color(153, 0, 0));
        first_name.setText("First Name: *");
        case_panel.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        account_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type.setForeground(new java.awt.Color(153, 0, 0));
        account_type.setText("Case Type: *");
        case_panel.add(account_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        client_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        client_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        client_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        client_radiobutton.setText("Client");
        client_radiobutton.setBorder(null);
        client_radiobutton.setOpaque(false);
        client_radiobutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                client_radiobuttonMouseClicked(evt);
            }
        });
        case_panel.add(client_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        country.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        country.setForeground(new java.awt.Color(153, 0, 0));
        country.setText("Country: *");
        case_panel.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        zipcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipcode.setForeground(new java.awt.Color(153, 0, 0));
        zipcode.setText("Zipcode: *");
        case_panel.add(zipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        city.setForeground(new java.awt.Color(153, 0, 0));
        city.setText("City: *");
        case_panel.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        streetaddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        streetaddress.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress.setText("Street Address: *");
        case_panel.add(streetaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        streetaddress_field.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(streetaddress_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 250, 20));

        city_field.setForeground(new java.awt.Color(153, 0, 0));
        city_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(city_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 250, 20));

        zipcode_field.setForeground(new java.awt.Color(153, 0, 0));
        zipcode_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(zipcode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 250, 20));

        country_field.setForeground(new java.awt.Color(153, 0, 0));
        country_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(country_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 250, 20));

        shippingstreetaddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingstreetaddress.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress.setText("Shipping St. Address:");
        case_panel.add(shippingstreetaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        shippingstreetaddress_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(shippingstreetaddress_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 230, 20));

        shippingcity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcity.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity.setText("Shipping City:");
        case_panel.add(shippingcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        shippingcity_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(shippingcity_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 230, 20));

        shippingzipcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingzipcode.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode.setText("Shipping Zipcode:");
        case_panel.add(shippingzipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        shippingzipcode_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(shippingzipcode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 230, 20));

        shippingcountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcountry.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry.setText("Shipping Country:");
        case_panel.add(shippingcountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        shippingcountry_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        case_panel.add(shippingcountry_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 230, 20));

        emptyfield_warning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emptyfield_warning.setForeground(new java.awt.Color(153, 0, 0));
        emptyfield_warning.setText("* One or more required fields are empty. Please fill them in and try again.");
        case_panel.add(emptyfield_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        casestatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        casestatus.setForeground(new java.awt.Color(153, 0, 0));
        casestatus.setText("Case Status: *");
        case_panel.add(casestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, -1, -1));

        found_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        found_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        found_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        found_radiobutton.setText("Found");
        case_panel.add(found_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 275, -1, -1));

        lost_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        lost_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lost_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        lost_radiobutton.setText("Lost");
        case_panel.add(lost_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 275, -1, -1));

        resolved_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        resolved_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resolved_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        resolved_radiobutton.setText("Resolved");
        case_panel.add(resolved_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 275, -1, -1));

        add(case_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1220, 350));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void newcase_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        newcase_button.setIcon(II);
    }//GEN-LAST:event_newcase_buttonMouseEntered

    private void newcase_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        newcase_button.setIcon(II);
    }//GEN-LAST:event_newcase_buttonMouseExited

    private void updatecase_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        updatecase_button.setIcon(II);
    }//GEN-LAST:event_updatecase_buttonMouseEntered

    private void updatecase_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        updatecase_button.setIcon(II);
    }//GEN-LAST:event_updatecase_buttonMouseExited

    private void search_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        search_button.setIcon(II);
    }//GEN-LAST:event_search_buttonMouseEntered

    private void search_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        search_button.setIcon(II);
    }//GEN-LAST:event_search_buttonMouseExited

    private void logout_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        logout_button.setIcon(II);
    }//GEN-LAST:event_logout_buttonMouseEntered

    private void logout_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        logout_button.setIcon(II);
    }//GEN-LAST:event_logout_buttonMouseExited

    private void save_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        save_button.setIcon(II);
    }//GEN-LAST:event_save_buttonMouseEntered

    private void save_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        save_button.setIcon(II);
    }//GEN-LAST:event_save_buttonMouseExited

    private void call_manualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_call_manualMouseClicked
        if (manual_panel.isVisible()) {
            manual_panel.setVisible(false);
            manual_panel.setEnabled(false);
        } else {
            manual_panel.setVisible(true);
            manual_panel.setEnabled(true);
        }
    }//GEN-LAST:event_call_manualMouseClicked

    private void updatecase_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_buttonMouseClicked
        FYS.getInstance().showPage(new UpdateCase_Page());
    }//GEN-LAST:event_updatecase_buttonMouseClicked

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        FYS.getInstance().showPage(new SWSearch_Page());
    }//GEN-LAST:event_search_buttonMouseClicked

    private void logout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseClicked
        FYS.getInstance().showPage(new SWLogout_Page());
    }//GEN-LAST:event_logout_buttonMouseClicked

    private void newcase_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseClicked
        FYS.getInstance().showPage(new NewCase_Page());
    }//GEN-LAST:event_newcase_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        emptyClientField = firstname_field.getText().equals("")
                || lastname_field.getText().equals("")
                || streetaddress_field.getText().equals("")
                || zipcode_field.getText().equals("")
                || city_field.getText().equals("")
                || country_field.getText().equals("");

        emptyBaggageField = baggageid_field.getText().equals("")
                && flightnumber_field.getText().equals("")
                && brand_field.getText().equals("")
                && color_field.getText().equals("") && description_field.getText().equals("");

        if (!client_radiobutton.isSelected() && !baggage_radiobutton.isSelected()) {
            JOptionPane.showMessageDialog(null,
                    "Please select which type of case you wish to make first.");

        } else {
            if (client_radiobutton.isSelected()) {
                if (emptyClientField) {
                    emptyfield_warning.setVisible(true);
                    emptyfield_warning.setEnabled(true);
                } else {
                    try {
                        FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "NewCase_Page",
                                "Created Client Case " + firstname_field.getText() + " "
                                + lastname_field.getText() + ".");

                        saveCase("client");

                    } catch (SQLException ex) {
                        Logger.getLogger(NewCase_Page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    FYS.getInstance().showPage(new NewCase_Page());
                }
            } else if (baggage_radiobutton.isSelected()) {
                if (emptyBaggageField || (!found_radiobutton.isSelected()
                        && !lost_radiobutton.isSelected() && !resolved_radiobutton.isSelected())) {

                    emptyfield_warning.setVisible(true);
                    emptyfield_warning.setEnabled(true);

                } else {
                    try {
                        FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "NewCase_Page",
                                "Created Baggage Case.");
                        saveCase("baggage");
                    } catch (SQLException ex) {
                        Logger.getLogger(NewCase_Page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    FYS.getInstance().showPage(new NewCase_Page());
                }
            }
        }
    }//GEN-LAST:event_save_buttonMouseClicked

    private void client_radiobuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client_radiobuttonMouseClicked
        setEnabledClient(true);
    }//GEN-LAST:event_client_radiobuttonMouseClicked

    private void baggage_radiobuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baggage_radiobuttonMouseClicked
        setEnabledBaggage(true);
    }//GEN-LAST:event_baggage_radiobuttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_type;
    private javax.swing.JLabel background;
    private javax.swing.JRadioButton baggage_radiobutton;
    private javax.swing.JLabel baggageid;
    private javax.swing.JTextField baggageid_field;
    private javax.swing.JLabel brand;
    private javax.swing.JTextField brand_field;
    private javax.swing.JLabel call_manual;
    private javax.swing.JPanel case_panel;
    private javax.swing.JLabel casestatus;
    private javax.swing.JLabel city;
    private javax.swing.JTextField city_field;
    private javax.swing.JRadioButton client_radiobutton;
    private javax.swing.JLabel color;
    private javax.swing.JTextField color_field;
    private javax.swing.JLabel country;
    private javax.swing.JTextField country_field;
    private javax.swing.JLabel description;
    private javax.swing.JTextArea description_field;
    private javax.swing.JLabel email;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel emptyfield_warning;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel first_name;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JLabel flightnumber;
    private javax.swing.JTextField flightnumber_field;
    private javax.swing.JRadioButton found_radiobutton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel last_name;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JRadioButton lost_radiobutton;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel newcase_button;
    private javax.swing.JLabel phone_number;
    private javax.swing.JTextField phonenumber_field;
    private javax.swing.JRadioButton resolved_radiobutton;
    private javax.swing.JLabel save_button;
    private javax.swing.JLabel search_button;
    private javax.swing.JLabel shippingcity;
    private javax.swing.JTextField shippingcity_field;
    private javax.swing.JLabel shippingcountry;
    private javax.swing.JTextField shippingcountry_field;
    private javax.swing.JLabel shippingstreetaddress;
    private javax.swing.JTextField shippingstreetaddress_field;
    private javax.swing.JLabel shippingzipcode;
    private javax.swing.JTextField shippingzipcode_field;
    private javax.swing.JLabel streetaddress;
    private javax.swing.JTextField streetaddress_field;
    private javax.swing.JLabel title;
    private javax.swing.JLabel updatecase_button;
    private javax.swing.JLabel welcomeuser;
    private javax.swing.JLabel zipcode;
    private javax.swing.JTextField zipcode_field;
    // End of variables declaration//GEN-END:variables
}
