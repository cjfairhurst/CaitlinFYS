package fys.sdworker;

import fys.FYS;
import fys.TrackUser;
import fys.appmanager.ManageAccounts_Page;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UpdateCase_Page extends javax.swing.JPanel {

    boolean tableClicked = false;
    String selectedRow;

    boolean clientTableClicked = false;
    String selectedClientRow;

    boolean baggageTableClicked = false;
    String selectedBaggageRow;

    boolean emptyClientField = false;
    boolean emptyBaggageField = false;

    String caseStatus = "";

    public UpdateCase_Page() {
        initComponents();
        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");

        emptyfield_warning.setVisible(false);
        emptyfield_warning.setEnabled(false);
        view_panel.setVisible(false);
        view_panel.setEnabled(false);
        addconnections_panel.setVisible(false);
        addconnections_panel.setEnabled(false);
        setEnabledClient(false);
        setEnabledBaggage(false);
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);

        ButtonGroup group = new ButtonGroup();
        group.add(client_radiobutton);
        group.add(baggage_radiobutton);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(client_radiobutton1);
        group1.add(baggage_radiobutton1);

        ButtonGroup casestatus = new ButtonGroup();
        casestatus.add(found_radiobutton);
        casestatus.add(lost_radiobutton);
        casestatus.add(resolved_radiobutton);
    }

    public void setEnabledClient(boolean enabled) {
        firstname_textfield.setEnabled(enabled);
        lastname_textfield.setEnabled(enabled);
        email_textfield.setEnabled(enabled);
        phonenumber_textfield.setEnabled(enabled);
        streetaddress_textfield.setEnabled(enabled);
        zipcode_textfield.setEnabled(enabled);
        city_textfield.setEnabled(enabled);
        country_textfield.setEnabled(enabled);
        shippingstreetaddress_textfield.setEnabled(enabled);
        shippingzipcode_textfield.setEnabled(enabled);
        shippingcity_textfield.setEnabled(enabled);
        shippingcountry_textfield.setEnabled(enabled);
    }

    public void setEnabledBaggage(boolean enabled) {
        baggageid_textfield.setEnabled(enabled);
        flightnumber_textfield.setEnabled(enabled);
        brand_textfield.setEnabled(enabled);
        color_textfield.setEnabled(enabled);
        description_textfield.setEnabled(enabled);
        found_radiobutton.setEnabled(enabled);
        lost_radiobutton.setEnabled(enabled);
        resolved_radiobutton.setEnabled(enabled);
    }

    public void updateCase(String typeCase) throws SQLException {
        String firstName = firstname_textfield.getText();
        String lastName = lastname_textfield.getText();
        String email = email_textfield.getText();
        String telephoneNumber = phonenumber_textfield.getText();
        String streetAddress = streetaddress_textfield.getText();
        String zipcode = zipcode_textfield.getText();
        String city = city_textfield.getText();
        String country = country_textfield.getText();
        String shippingStreetAddress = shippingstreetaddress_textfield.getText();
        String shippingZipcode = shippingzipcode_textfield.getText();
        String shippingCity = shippingcity_textfield.getText();
        String shippingCountry = shippingcountry_textfield.getText();

        String baggageID = baggageid_textfield.getText();
        String flightNumber = flightnumber_textfield.getText();
        String brand = brand_textfield.getText();
        String color = color_textfield.getText();
        String description = description_textfield.getText();

        if (found_radiobutton.isSelected()) {
            caseStatus = "found";
        } else if (lost_radiobutton.isSelected()) {
            caseStatus = "lost";
        } else if (resolved_radiobutton.isSelected()) {
            caseStatus = "resolved";
        }

        FYS.getQueryManager().editCase(typeCase, firstName, lastName, email, telephoneNumber, streetAddress, zipcode, city, country, shippingStreetAddress, shippingZipcode, shippingCity, shippingCountry, baggageID, flightNumber, brand, color, description, caseStatus, selectedRow);
    }

    public void viewCase(ResultSet rs) throws SQLException {
        if (rs.next()) {
            if (client_radiobutton.isSelected()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String telephone_number = rs.getString("telephone_number");
                String street_address = rs.getString("street_Address");
                String zipcode = rs.getString("zipcode");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String shipping_street_address = rs.getString("shipping_street_address");
                String shipping_zipcode = rs.getString("shipping_zipcode");
                String shipping_city = rs.getString("shipping_city");
                String shipping_country = rs.getString("shipping_country");

                firstname_textfield.setText(first_name);
                lastname_textfield.setText(last_name);
                email_textfield.setText(email);
                phonenumber_textfield.setText(telephone_number);
                streetaddress_textfield.setText(street_address);
                zipcode_textfield.setText(zipcode);
                city_textfield.setText(city);
                country_textfield.setText(country);
                shippingstreetaddress_textfield.setText(shipping_street_address);
                shippingzipcode_textfield.setText(shipping_zipcode);
                shippingcity_textfield.setText(shipping_city);
                shippingcountry_textfield.setText(shipping_country);

                firstname_field.setText(first_name);
                lastname_field.setText(last_name);
                email_field.setText(email);
                phonenumber_field.setText(telephone_number);
                streetaddress_field.setText(street_address);
                zipcode_field.setText(zipcode);
                city_field.setText(city);
                country_field.setText(country);
                shippingstreetaddress_field.setText(shipping_street_address);
                shippingzipcode_field.setText(shipping_zipcode);
                shippingcity_field.setText(shipping_city);
                shippingcountry_field.setText(shipping_country);

            } else if (baggage_radiobutton.isSelected()) {
                String baggage_id = rs.getString("baggage_id");
                String flight_number = rs.getString("flight_number");
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String case_status = rs.getString("case_status");

                baggageid_textfield.setText(baggage_id);
                flightnumber_textfield.setText(flight_number);
                brand_textfield.setText(brand);
                color_textfield.setText(color);
                description_textfield.setText(description);

                baggageid_field.setText(baggage_id);
                flightnumber_field.setText(flight_number);
                brand_field.setText(brand);
                color_field.setText(color);
                description_field.setText(description);

                switch (case_status) {
                    case "found":
                        found_radiobutton.setSelected(true);
                        break;
                    case "lost":
                        lost_radiobutton.setSelected(true);
                        break;
                    case "resolved":
                        resolved_radiobutton.setSelected(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        logout_button = new javax.swing.JLabel();
        newcase_button = new javax.swing.JLabel();
        view_panel = new javax.swing.JPanel();
        edit_panel = new javax.swing.JPanel();
        edit_title = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        brand_textfield = new javax.swing.JTextField();
        flightnumber_textfield = new javax.swing.JTextField();
        flightnumber = new javax.swing.JLabel();
        baggageid = new javax.swing.JLabel();
        baggageid_textfield = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description_textfield = new javax.swing.JTextArea();
        color = new javax.swing.JLabel();
        color_textfield = new javax.swing.JTextField();
        baggage_radiobutton1 = new javax.swing.JRadioButton();
        phonenumber_textfield = new javax.swing.JTextField();
        phone_number1 = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        email_textfield = new javax.swing.JTextField();
        last_name1 = new javax.swing.JLabel();
        lastname_textfield = new javax.swing.JTextField();
        firstname_textfield = new javax.swing.JTextField();
        first_name1 = new javax.swing.JLabel();
        account_type1 = new javax.swing.JLabel();
        client_radiobutton1 = new javax.swing.JRadioButton();
        country = new javax.swing.JLabel();
        zipcode = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        streetaddress = new javax.swing.JLabel();
        streetaddress_textfield = new javax.swing.JTextField();
        city_textfield = new javax.swing.JTextField();
        zipcode_textfield = new javax.swing.JTextField();
        country_textfield = new javax.swing.JTextField();
        shippingstreetaddress = new javax.swing.JLabel();
        shippingstreetaddress_textfield = new javax.swing.JTextField();
        shippingcity = new javax.swing.JLabel();
        shippingcity_textfield = new javax.swing.JTextField();
        shippingzipcode = new javax.swing.JLabel();
        shippingzipcode_textfield = new javax.swing.JTextField();
        shippingcountry = new javax.swing.JLabel();
        shippingcountry_textfield = new javax.swing.JTextField();
        emptyfield_warning = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        lost_radiobutton = new javax.swing.JRadioButton();
        resolved_radiobutton = new javax.swing.JRadioButton();
        found_radiobutton = new javax.swing.JRadioButton();
        casestatus = new javax.swing.JLabel();
        edit_background = new javax.swing.JLabel();
        phone_number = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        last_name = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        account_type3 = new javax.swing.JLabel();
        viewclient_radiobutton = new javax.swing.JRadioButton();
        country1 = new javax.swing.JLabel();
        zipcode1 = new javax.swing.JLabel();
        city1 = new javax.swing.JLabel();
        streetaddress1 = new javax.swing.JLabel();
        shippingstreetaddress1 = new javax.swing.JLabel();
        shippingcity1 = new javax.swing.JLabel();
        shippingzipcode1 = new javax.swing.JLabel();
        shippingcountry1 = new javax.swing.JLabel();
        shippingcountry_field = new javax.swing.JLabel();
        firstname_field = new javax.swing.JLabel();
        lastname_field = new javax.swing.JLabel();
        email_field = new javax.swing.JLabel();
        phonenumber_field = new javax.swing.JLabel();
        streetaddress_field = new javax.swing.JLabel();
        city_field = new javax.swing.JLabel();
        zipcode_field = new javax.swing.JLabel();
        country_field = new javax.swing.JLabel();
        shippingstreetaddress_field = new javax.swing.JLabel();
        shippingcity_field = new javax.swing.JLabel();
        shippingzipcode_field = new javax.swing.JLabel();
        baggageid1 = new javax.swing.JLabel();
        viewbaggage_radiobutton = new javax.swing.JRadioButton();
        baggageid_field = new javax.swing.JLabel();
        flightnumber1 = new javax.swing.JLabel();
        brand1 = new javax.swing.JLabel();
        color1 = new javax.swing.JLabel();
        description1 = new javax.swing.JLabel();
        description_field = new javax.swing.JLabel();
        color_field = new javax.swing.JLabel();
        brand_field = new javax.swing.JLabel();
        flightnumber_field = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        edit_button = new javax.swing.JLabel();
        viewback_button = new javax.swing.JLabel();
        view_background = new javax.swing.JLabel();
        addconnections_panel = new javax.swing.JPanel();
        addconnection_title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clientcase_table = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        baggagecase_table = new javax.swing.JTable();
        baggagecase = new javax.swing.JLabel();
        clientcase = new javax.swing.JLabel();
        saveconnection_button = new javax.swing.JLabel();
        addconnectionsback_button = new javax.swing.JLabel();
        addconnections_background = new javax.swing.JLabel();
        delete_button = new javax.swing.JLabel();
        updatecase_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        view_button = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        updatecase_table = new javax.swing.JTable();
        infotext = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        account_type = new javax.swing.JLabel();
        client_radiobutton = new javax.swing.JRadioButton();
        baggage_radiobutton = new javax.swing.JRadioButton();
        addconnection_button = new javax.swing.JLabel();
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
        manualText.setText("<html>\nSelect which type of case you wish to view by clicking\neither on the 'Client' radio button or the 'Baggage' radio button.\nA list of all current cases based on your selection will appear in the table.\nFrom this you can select the case you wish to view, edit, connect, or delete.\n<br>\n<br>\nTo permanently delete a case, select it in the table and click 'Delete.\nTo view or edit a case, click on the 'View' button. A new screen will appear\nwith the details of the case. Click on 'Edit' to change the data saved in the case,\nthen 'Save' to make those changes permanent.\n<br>\n<br>\nClick on 'Add Connection' to create a connection between a piece of baggage \nand a client. A screen with two tables will appear - one with client cases and one with baggage cases. Choose the cases you wish to connect from the tables, then click 'Save\nConnection'.\n<br>\n<br>\nAt any time, you can use the red and white arrow button to go back to the original page.");
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
        newcase_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
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

        view_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_panel.setBackground(new java.awt.Color(255, 255, 255));
        edit_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        edit_title.setForeground(new java.awt.Color(153, 0, 0));
        edit_title.setText("Edit Case");
        edit_panel.add(edit_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brand.setForeground(new java.awt.Color(153, 0, 0));
        brand.setText("Brand:");
        edit_panel.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, -1, -1));

        brand_textfield.setForeground(new java.awt.Color(153, 0, 0));
        brand_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(brand_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 230, 20));

        flightnumber_textfield.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(flightnumber_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, 230, 20));

        flightnumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        flightnumber.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        flightnumber.setText("Flight Number:");
        edit_panel.add(flightnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, -1, -1));

        baggageid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        baggageid.setForeground(new java.awt.Color(153, 0, 0));
        baggageid.setText("Baggage ID:");
        edit_panel.add(baggageid, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        baggageid_textfield.setForeground(new java.awt.Color(153, 0, 0));
        baggageid_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(baggageid_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 230, 20));

        description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(153, 0, 0));
        description.setText("Description:");
        edit_panel.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, -1, -1));

        description_textfield.setColumns(20);
        description_textfield.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        description_textfield.setForeground(new java.awt.Color(153, 51, 0));
        description_textfield.setRows(5);
        jScrollPane2.setViewportView(description_textfield);

        edit_panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 230, 80));

        color.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        color.setForeground(new java.awt.Color(153, 0, 0));
        color.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        color.setText("Color:");
        edit_panel.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, -1, -1));

        color_textfield.setForeground(new java.awt.Color(153, 0, 0));
        color_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(color_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 230, 20));

        baggage_radiobutton1.setBackground(new java.awt.Color(255, 255, 255));
        baggage_radiobutton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        baggage_radiobutton1.setForeground(new java.awt.Color(153, 0, 0));
        baggage_radiobutton1.setText("Baggage");
        baggage_radiobutton1.setBorder(null);
        baggage_radiobutton1.setOpaque(false);
        baggage_radiobutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baggage_radiobutton1MouseClicked(evt);
            }
        });
        edit_panel.add(baggage_radiobutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, -1, -1));

        phonenumber_textfield.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(phonenumber_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 250, 20));

        phone_number1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number1.setForeground(new java.awt.Color(153, 0, 0));
        phone_number1.setText("Phone Number:");
        edit_panel.add(phone_number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        email1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email1.setForeground(new java.awt.Color(153, 0, 0));
        email1.setText("Email:");
        edit_panel.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        email_textfield.setForeground(new java.awt.Color(153, 0, 0));
        email_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(email_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, 20));

        last_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name1.setForeground(new java.awt.Color(153, 0, 0));
        last_name1.setText("Last Name: *");
        edit_panel.add(last_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lastname_textfield.setForeground(new java.awt.Color(153, 0, 0));
        lastname_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(lastname_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 250, 20));

        firstname_textfield.setForeground(new java.awt.Color(153, 0, 0));
        firstname_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(firstname_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 20));

        first_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name1.setForeground(new java.awt.Color(153, 0, 0));
        first_name1.setText("First Name: *");
        edit_panel.add(first_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        account_type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type1.setForeground(new java.awt.Color(153, 0, 0));
        account_type1.setText("Case Type: *");
        edit_panel.add(account_type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        client_radiobutton1.setBackground(new java.awt.Color(255, 255, 255));
        client_radiobutton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        client_radiobutton1.setForeground(new java.awt.Color(153, 0, 0));
        client_radiobutton1.setText("Client");
        client_radiobutton1.setBorder(null);
        client_radiobutton1.setOpaque(false);
        client_radiobutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                client_radiobutton1MouseClicked(evt);
            }
        });
        edit_panel.add(client_radiobutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        country.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        country.setForeground(new java.awt.Color(153, 0, 0));
        country.setText("Country: *");
        edit_panel.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        zipcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipcode.setForeground(new java.awt.Color(153, 0, 0));
        zipcode.setText("Zipcode: *");
        edit_panel.add(zipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        city.setForeground(new java.awt.Color(153, 0, 0));
        city.setText("City: *");
        edit_panel.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        streetaddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        streetaddress.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress.setText("Street Address: *");
        edit_panel.add(streetaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        streetaddress_textfield.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(streetaddress_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, 20));

        city_textfield.setForeground(new java.awt.Color(153, 0, 0));
        city_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(city_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 250, 20));

        zipcode_textfield.setForeground(new java.awt.Color(153, 0, 0));
        zipcode_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(zipcode_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 250, 20));

        country_textfield.setForeground(new java.awt.Color(153, 0, 0));
        country_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(country_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 250, 20));

        shippingstreetaddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingstreetaddress.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress.setText("Shipping St. Address:");
        edit_panel.add(shippingstreetaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        shippingstreetaddress_textfield.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(shippingstreetaddress_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 230, 20));

        shippingcity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcity.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity.setText("Shipping City:");
        edit_panel.add(shippingcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        shippingcity_textfield.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(shippingcity_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, 20));

        shippingzipcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingzipcode.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode.setText("Shipping Zipcode:");
        edit_panel.add(shippingzipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        shippingzipcode_textfield.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(shippingzipcode_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 230, 20));

        shippingcountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcountry.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry.setText("Shipping Country:");
        edit_panel.add(shippingcountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        shippingcountry_textfield.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(shippingcountry_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 230, 20));

        emptyfield_warning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emptyfield_warning.setForeground(new java.awt.Color(153, 0, 0));
        emptyfield_warning.setText("* One or more required fields are empty. Please fill them in and try again.");
        edit_panel.add(emptyfield_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

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
        edit_panel.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, -1, -1));

        lost_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        lost_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lost_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        lost_radiobutton.setText("Lost");
        edit_panel.add(lost_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 395, -1, -1));

        resolved_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        resolved_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resolved_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        resolved_radiobutton.setText("Resolved");
        edit_panel.add(resolved_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 395, -1, -1));

        found_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        found_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        found_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        found_radiobutton.setText("Found");
        edit_panel.add(found_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 395, -1, -1));

        casestatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        casestatus.setForeground(new java.awt.Color(153, 0, 0));
        casestatus.setText("Case Status: *");
        edit_panel.add(casestatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, -1, -1));

        edit_background.setBackground(new java.awt.Color(255, 255, 255));
        edit_panel.add(edit_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        view_panel.add(edit_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1200, 550));

        phone_number.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(153, 0, 0));
        phone_number.setText("Phone Number:");
        view_panel.add(phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 0, 0));
        email.setText("Email:");
        view_panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name.setForeground(new java.awt.Color(153, 0, 0));
        last_name.setText("Last Name:");
        view_panel.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name.setForeground(new java.awt.Color(153, 0, 0));
        first_name.setText("First Name:");
        view_panel.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        account_type3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type3.setForeground(new java.awt.Color(153, 0, 0));
        account_type3.setText("Case Type:");
        view_panel.add(account_type3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        viewclient_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        viewclient_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewclient_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        viewclient_radiobutton.setText("Client");
        viewclient_radiobutton.setBorder(null);
        viewclient_radiobutton.setOpaque(false);
        view_panel.add(viewclient_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        country1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        country1.setForeground(new java.awt.Color(153, 0, 0));
        country1.setText("Country:");
        view_panel.add(country1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        zipcode1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zipcode1.setForeground(new java.awt.Color(153, 0, 0));
        zipcode1.setText("Zipcode:");
        view_panel.add(zipcode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        city1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        city1.setForeground(new java.awt.Color(153, 0, 0));
        city1.setText("City:");
        view_panel.add(city1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        streetaddress1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        streetaddress1.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress1.setText("Street Address:");
        view_panel.add(streetaddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        shippingstreetaddress1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingstreetaddress1.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress1.setText("Shipping St. Address:");
        view_panel.add(shippingstreetaddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        shippingcity1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcity1.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity1.setText("Shipping City:");
        view_panel.add(shippingcity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, -1));

        shippingzipcode1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingzipcode1.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode1.setText("Shipping Zipcode:");
        view_panel.add(shippingzipcode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        shippingcountry1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shippingcountry1.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry1.setText("Shipping Country:");
        view_panel.add(shippingcountry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        shippingcountry_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingcountry_field.setText("-");
        view_panel.add(shippingcountry_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 240, 20));

        firstname_field.setForeground(new java.awt.Color(153, 0, 0));
        firstname_field.setText("-");
        view_panel.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 240, 20));

        lastname_field.setForeground(new java.awt.Color(153, 0, 0));
        lastname_field.setText("-");
        view_panel.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 240, 20));

        email_field.setForeground(new java.awt.Color(153, 0, 0));
        email_field.setText("-");
        view_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 240, 20));

        phonenumber_field.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_field.setText("-");
        view_panel.add(phonenumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 240, 20));

        streetaddress_field.setForeground(new java.awt.Color(153, 0, 0));
        streetaddress_field.setText("-");
        view_panel.add(streetaddress_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 240, 20));

        city_field.setForeground(new java.awt.Color(153, 0, 0));
        city_field.setText("-");
        view_panel.add(city_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 240, 20));

        zipcode_field.setForeground(new java.awt.Color(153, 0, 0));
        zipcode_field.setText("-");
        view_panel.add(zipcode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 240, 20));

        country_field.setForeground(new java.awt.Color(153, 0, 0));
        country_field.setText("-");
        view_panel.add(country_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 240, 20));

        shippingstreetaddress_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingstreetaddress_field.setText("-");
        view_panel.add(shippingstreetaddress_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 240, 20));

        shippingcity_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingcity_field.setText("-");
        view_panel.add(shippingcity_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 240, 20));

        shippingzipcode_field.setForeground(new java.awt.Color(153, 0, 0));
        shippingzipcode_field.setText("-");
        view_panel.add(shippingzipcode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 240, 20));

        baggageid1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        baggageid1.setForeground(new java.awt.Color(153, 0, 0));
        baggageid1.setText("Baggage ID:");
        view_panel.add(baggageid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, -1, -1));

        viewbaggage_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        viewbaggage_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewbaggage_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        viewbaggage_radiobutton.setText("Baggage");
        viewbaggage_radiobutton.setBorder(null);
        viewbaggage_radiobutton.setOpaque(false);
        view_panel.add(viewbaggage_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, -1, -1));

        baggageid_field.setForeground(new java.awt.Color(153, 0, 0));
        baggageid_field.setText("-");
        view_panel.add(baggageid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 160, 240, 20));

        flightnumber1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        flightnumber1.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        flightnumber1.setText("Flight Number:");
        view_panel.add(flightnumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, -1, -1));

        brand1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        brand1.setForeground(new java.awt.Color(153, 0, 0));
        brand1.setText("Brand:");
        view_panel.add(brand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, -1, -1));

        color1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        color1.setForeground(new java.awt.Color(153, 0, 0));
        color1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        color1.setText("Color:");
        view_panel.add(color1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, -1, -1));

        description1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        description1.setForeground(new java.awt.Color(153, 0, 0));
        description1.setText("Description:");
        view_panel.add(description1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, -1, -1));

        description_field.setForeground(new java.awt.Color(153, 0, 0));
        description_field.setText("-");
        description_field.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        view_panel.add(description_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 280, 240, 160));

        color_field.setForeground(new java.awt.Color(153, 0, 0));
        color_field.setText("-");
        view_panel.add(color_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 240, 20));

        brand_field.setForeground(new java.awt.Color(153, 0, 0));
        brand_field.setText("-");
        view_panel.add(brand_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 220, 240, 20));

        flightnumber_field.setForeground(new java.awt.Color(153, 0, 0));
        flightnumber_field.setText("-");
        view_panel.add(flightnumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, 240, 20));

        title2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title2.setForeground(new java.awt.Color(153, 0, 0));
        title2.setText("View Case");
        view_panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        edit_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit_button.setForeground(new java.awt.Color(255, 255, 255));
        edit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        edit_button.setText("Edit");
        edit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edit_buttonMouseExited(evt);
            }
        });
        view_panel.add(edit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        viewback_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewback_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewback_buttonMouseClicked(evt);
            }
        });
        view_panel.add(viewback_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 40));

        view_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/appmanager/Images/switchpanel.png"))); // NOI18N
        view_panel.add(view_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        add(view_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1280, 550));

        addconnections_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addconnection_title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        addconnection_title.setForeground(new java.awt.Color(153, 0, 0));
        addconnection_title.setText("Connect Cases");
        addconnections_panel.add(addconnection_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        clientcase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        clientcase_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientcase_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(clientcase_table);

        addconnections_panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 860, 150));

        baggagecase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        baggagecase_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baggagecase_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(baggagecase_table);

        addconnections_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 860, 150));

        baggagecase.setForeground(new java.awt.Color(153, 0, 0));
        baggagecase.setText("Baggage Case:");
        addconnections_panel.add(baggagecase, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        clientcase.setForeground(new java.awt.Color(153, 0, 0));
        clientcase.setText("Client Case:");
        addconnections_panel.add(clientcase, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        saveconnection_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveconnection_button.setForeground(new java.awt.Color(255, 255, 255));
        saveconnection_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        saveconnection_button.setText("Save Connection");
        saveconnection_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveconnection_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveconnection_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveconnection_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveconnection_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveconnection_buttonMouseExited(evt);
            }
        });
        addconnections_panel.add(saveconnection_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, -1, -1));

        addconnectionsback_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addconnectionsback_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addconnectionsback_buttonMouseClicked(evt);
            }
        });
        addconnections_panel.add(addconnectionsback_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 15, 40, 40));

        addconnections_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/sdworker/Images/switchpanel.png"))); // NOI18N
        addconnections_panel.add(addconnections_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        add(addconnections_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1280, 540));

        delete_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete_button.setForeground(new java.awt.Color(255, 255, 255));
        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        delete_button.setText("Delete");
        delete_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete_buttonMouseExited(evt);
            }
        });
        add(delete_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 630, -1, -1));

        updatecase_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatecase_button.setForeground(new java.awt.Color(153, 0, 0));
        updatecase_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
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

        view_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        view_button.setForeground(new java.awt.Color(255, 255, 255));
        view_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        view_button.setText("View");
        view_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        view_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_buttonMouseExited(evt);
            }
        });
        add(view_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, -1, -1));

        updatecase_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        updatecase_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatecase_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(updatecase_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 860, 310));

        infotext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infotext.setForeground(new java.awt.Color(153, 0, 0));
        infotext.setText("Choose the case you want to view.");
        add(infotext, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("Update Case");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        account_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type.setForeground(new java.awt.Color(153, 0, 0));
        account_type.setText("Case Type:");
        add(account_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

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
        add(client_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

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
        baggage_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baggage_radiobuttonActionPerformed(evt);
            }
        });
        add(baggage_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        addconnection_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addconnection_button.setForeground(new java.awt.Color(255, 255, 255));
        addconnection_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        addconnection_button.setText("Add Connection");
        addconnection_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addconnection_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addconnection_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addconnection_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addconnection_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addconnection_buttonMouseExited(evt);
            }
        });
        add(addconnection_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, -1, -1));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void newcase_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));//Create a rollover effect for the button by changing the background icon.
        newcase_button.setIcon(II);//Sets the new background icon.
    }//GEN-LAST:event_newcase_buttonMouseEntered

    private void newcase_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        newcase_button.setIcon(II);
    }//GEN-LAST:event_newcase_buttonMouseExited

    private void updatecase_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_buttonMouseEntered

    }//GEN-LAST:event_updatecase_buttonMouseEntered

    private void updatecase_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_buttonMouseExited

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

    private void view_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseEntered

    private void view_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseExited

    private void view_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseClicked
        if (tableClicked) {
            try {
                if (client_radiobutton.isSelected()) {
                    viewCase(FYS.getQueryManager().viewCase("client", selectedRow));
                    client_radiobutton1.setSelected(true);
                    viewclient_radiobutton.setSelected(true);
                    setEnabledClient(true);
                    baggage_radiobutton1.setEnabled(false);
                    viewbaggage_radiobutton.setEnabled(false);
                } else if (baggage_radiobutton.isSelected()) {
                    viewCase(FYS.getQueryManager().viewCase("baggage", selectedRow));
                    baggage_radiobutton1.setSelected(true);
                    viewbaggage_radiobutton.setSelected(true);
                    setEnabledBaggage(true);
                    client_radiobutton1.setEnabled(false);
                    viewclient_radiobutton.setEnabled(false);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ManageAccounts_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
            view_panel.setVisible(true);
            view_panel.setEnabled(true);
            edit_panel.setVisible(false);
            edit_panel.setVisible(false);
            updatecase_table.setVisible(false);
            updatecase_table.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an account from the table.", "Selection Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_view_buttonMouseClicked

    private void client_radiobuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client_radiobuttonMouseClicked
        FYS.getInstance().updateTable(updatecase_table, FYS.getQueryManager().fillTableCase("client"));
    }//GEN-LAST:event_client_radiobuttonMouseClicked

    private void baggage_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baggage_radiobuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_baggage_radiobuttonActionPerformed

    private void baggage_radiobuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baggage_radiobuttonMouseClicked
        FYS.getInstance().updateTable(updatecase_table, FYS.getQueryManager().fillTableCase("baggage"));
    }//GEN-LAST:event_baggage_radiobuttonMouseClicked

    private void updatecase_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatecase_tableMouseClicked
        int row = updatecase_table.getSelectedRow();
        selectedRow = (updatecase_table.getModel().getValueAt(row, 0).toString());
        tableClicked = true;
    }//GEN-LAST:event_updatecase_tableMouseClicked

    private void delete_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_buttonMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete Account", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            if (client_radiobutton.isSelected()) {
                if (FYS.getQueryManager().checkConnection(selectedRow)) {
                    JOptionPane.showMessageDialog(null, "This case cannot be deleted because it's already connected to another case.", "Deletion Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "UpdateCase_Page", "Deleted Client Case " + selectedRow + ".");
                    FYS.getQueryManager().deleteCase("client", selectedRow);
                    FYS.getInstance().updateTable(updatecase_table, FYS.getQueryManager().fillTableCase("client"));
                }
            } else if (baggage_radiobutton.isSelected()) {
                if (FYS.getQueryManager().checkConnection(selectedRow)) {
                    JOptionPane.showMessageDialog(null, "This case cannot be deleted because it's already connected to another case.", "Deletion Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "UpdateCase_Page", "Deleted Baggage Case " + selectedRow + ".");
                    FYS.getQueryManager().deleteCase("baggage", selectedRow);
                    FYS.getInstance().updateTable(updatecase_table, FYS.getQueryManager().fillTableCase("baggage"));
                }

            }
        }
    }//GEN-LAST:event_delete_buttonMouseClicked

    private void delete_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        delete_button.setIcon(II);
    }//GEN-LAST:event_delete_buttonMouseEntered

    private void delete_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        delete_button.setIcon(II);
    }//GEN-LAST:event_delete_buttonMouseExited

    private void edit_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_buttonMouseClicked
        edit_panel.setVisible(true);
        edit_panel.setEnabled(true);
    }//GEN-LAST:event_edit_buttonMouseClicked

    private void edit_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        edit_button.setIcon(II);
    }//GEN-LAST:event_edit_buttonMouseEntered

    private void edit_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        edit_button.setIcon(II);
    }//GEN-LAST:event_edit_buttonMouseExited

    private void viewback_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewback_buttonMouseClicked
        FYS.getInstance().showPage(new UpdateCase_Page());
    }//GEN-LAST:event_viewback_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        emptyClientField = firstname_field.getText().equals("") || lastname_field.getText().equals("") || streetaddress_textfield.getText().equals("") || zipcode_textfield.getText().equals("") || city_textfield.getText().equals("") || country_textfield.getText().equals("");
        emptyBaggageField = baggageid_textfield.getText().equals("") && flightnumber_textfield.getText().equals("") && brand_textfield.getText().equals("") && color_textfield.getText().equals("") && description_textfield.getText().equals("");
        if (client_radiobutton1.isSelected()) {
            if (emptyClientField) {
                emptyfield_warning.setVisible(true);
                emptyfield_warning.setEnabled(true);
            } else {
                try {
                    FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "UpdateCase_Page", "Updated Client Case " + firstname_field.getText() + " " + lastname_field.getText() + ".");
                    updateCase("client");
                } catch (SQLException ex) {
                    Logger.getLogger(NewCase_Page.class.getName()).log(Level.SEVERE, null, ex);
                }
                FYS.getInstance().showPage(new UpdateCase_Page());
            }
        } else if (baggage_radiobutton1.isSelected()) {
            if (emptyBaggageField || (!found_radiobutton.isSelected() && !lost_radiobutton.isSelected() && !resolved_radiobutton.isSelected())) {
                emptyfield_warning.setVisible(true);
                emptyfield_warning.setEnabled(true);
            } else {
                try {
                    FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "UpdateCase_Page", "Updated Baggage Case.");
                    updateCase("baggage");
                } catch (SQLException ex) {
                    Logger.getLogger(NewCase_Page.class.getName()).log(Level.SEVERE, null, ex);
                }
                FYS.getInstance().showPage(new UpdateCase_Page());
            }
        }

    }//GEN-LAST:event_save_buttonMouseClicked

    private void save_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        save_button.setIcon(II);
    }//GEN-LAST:event_save_buttonMouseEntered

    private void save_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        save_button.setIcon(II);
    }//GEN-LAST:event_save_buttonMouseExited

    private void client_radiobutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_client_radiobutton1MouseClicked

    }//GEN-LAST:event_client_radiobutton1MouseClicked

    private void baggage_radiobutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baggage_radiobutton1MouseClicked

    }//GEN-LAST:event_baggage_radiobutton1MouseClicked

    private void addconnection_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addconnection_buttonMouseClicked
        FYS.getInstance().updateTable(clientcase_table, FYS.getQueryManager().fillTableCase("client"));
        FYS.getInstance().updateTable(baggagecase_table, FYS.getQueryManager().fillTableCase("baggage"));
        addconnections_panel.setVisible(true);
        addconnections_panel.setEnabled(true);
        updatecase_table.setVisible(false);
        updatecase_table.setEnabled(false);
    }//GEN-LAST:event_addconnection_buttonMouseClicked

    private void addconnection_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addconnection_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        addconnection_button.setIcon(II);
    }//GEN-LAST:event_addconnection_buttonMouseEntered

    private void addconnection_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addconnection_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        addconnection_button.setIcon(II);
    }//GEN-LAST:event_addconnection_buttonMouseExited

    private void clientcase_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientcase_tableMouseClicked
        int row = clientcase_table.getSelectedRow();
        selectedClientRow = (clientcase_table.getModel().getValueAt(row, 0).toString());
        clientTableClicked = true;
    }//GEN-LAST:event_clientcase_tableMouseClicked

    private void baggagecase_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baggagecase_tableMouseClicked
        int row = baggagecase_table.getSelectedRow();
        selectedBaggageRow = (baggagecase_table.getModel().getValueAt(row, 0).toString());
        baggageTableClicked = true;
    }//GEN-LAST:event_baggagecase_tableMouseClicked

    private void saveconnection_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveconnection_buttonMouseClicked
        if (clientTableClicked && baggageTableClicked) {
            FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "UpdateCase_Page", "Added connection between Client Case " + selectedClientRow + " and Baggage Case " + selectedBaggageRow + ".");
            FYS.getQueryManager().connectCase(selectedClientRow, selectedBaggageRow);
            FYS.getInstance().updateTable(clientcase_table, FYS.getQueryManager().fillTableCase("client"));
            FYS.getInstance().updateTable(baggagecase_table, FYS.getQueryManager().fillTableCase("baggage"));
        } else {
            JOptionPane.showMessageDialog(null, "Please select both a client case and a baggage case from the tables above.", "Selection Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveconnection_buttonMouseClicked

    private void saveconnection_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveconnection_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        saveconnection_button.setIcon(II);
    }//GEN-LAST:event_saveconnection_buttonMouseEntered

    private void saveconnection_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveconnection_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        saveconnection_button.setIcon(II);
    }//GEN-LAST:event_saveconnection_buttonMouseExited

    private void addconnectionsback_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addconnectionsback_buttonMouseClicked
        FYS.getInstance().showPage(new UpdateCase_Page());
    }//GEN-LAST:event_addconnectionsback_buttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_type;
    private javax.swing.JLabel account_type1;
    private javax.swing.JLabel account_type3;
    private javax.swing.JLabel addconnection_button;
    private javax.swing.JLabel addconnection_title;
    private javax.swing.JLabel addconnections_background;
    private javax.swing.JPanel addconnections_panel;
    private javax.swing.JLabel addconnectionsback_button;
    private javax.swing.JLabel background;
    private javax.swing.JRadioButton baggage_radiobutton;
    private javax.swing.JRadioButton baggage_radiobutton1;
    private javax.swing.JLabel baggagecase;
    private javax.swing.JTable baggagecase_table;
    private javax.swing.JLabel baggageid;
    private javax.swing.JLabel baggageid1;
    private javax.swing.JLabel baggageid_field;
    private javax.swing.JTextField baggageid_textfield;
    private javax.swing.JLabel brand;
    private javax.swing.JLabel brand1;
    private javax.swing.JLabel brand_field;
    private javax.swing.JTextField brand_textfield;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel casestatus;
    private javax.swing.JLabel city;
    private javax.swing.JLabel city1;
    private javax.swing.JLabel city_field;
    private javax.swing.JTextField city_textfield;
    private javax.swing.JRadioButton client_radiobutton;
    private javax.swing.JRadioButton client_radiobutton1;
    private javax.swing.JLabel clientcase;
    private javax.swing.JTable clientcase_table;
    private javax.swing.JLabel color;
    private javax.swing.JLabel color1;
    private javax.swing.JLabel color_field;
    private javax.swing.JTextField color_textfield;
    private javax.swing.JLabel country;
    private javax.swing.JLabel country1;
    private javax.swing.JLabel country_field;
    private javax.swing.JTextField country_textfield;
    private javax.swing.JLabel delete_button;
    private javax.swing.JLabel description;
    private javax.swing.JLabel description1;
    private javax.swing.JLabel description_field;
    private javax.swing.JTextArea description_textfield;
    private javax.swing.JLabel edit_background;
    private javax.swing.JLabel edit_button;
    private javax.swing.JPanel edit_panel;
    private javax.swing.JLabel edit_title;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email1;
    private javax.swing.JLabel email_field;
    private javax.swing.JTextField email_textfield;
    private javax.swing.JLabel emptyfield_warning;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel firstname_field;
    private javax.swing.JTextField firstname_textfield;
    private javax.swing.JLabel flightnumber;
    private javax.swing.JLabel flightnumber1;
    private javax.swing.JLabel flightnumber_field;
    private javax.swing.JTextField flightnumber_textfield;
    private javax.swing.JRadioButton found_radiobutton;
    private javax.swing.JLabel infotext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel last_name;
    private javax.swing.JLabel last_name1;
    private javax.swing.JLabel lastname_field;
    private javax.swing.JTextField lastname_textfield;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JRadioButton lost_radiobutton;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel newcase_button;
    private javax.swing.JLabel phone_number;
    private javax.swing.JLabel phone_number1;
    private javax.swing.JLabel phonenumber_field;
    private javax.swing.JTextField phonenumber_textfield;
    private javax.swing.JRadioButton resolved_radiobutton;
    private javax.swing.JLabel save_button;
    private javax.swing.JLabel saveconnection_button;
    private javax.swing.JLabel search_button;
    private javax.swing.JLabel shippingcity;
    private javax.swing.JLabel shippingcity1;
    private javax.swing.JLabel shippingcity_field;
    private javax.swing.JTextField shippingcity_textfield;
    private javax.swing.JLabel shippingcountry;
    private javax.swing.JLabel shippingcountry1;
    private javax.swing.JLabel shippingcountry_field;
    private javax.swing.JTextField shippingcountry_textfield;
    private javax.swing.JLabel shippingstreetaddress;
    private javax.swing.JLabel shippingstreetaddress1;
    private javax.swing.JLabel shippingstreetaddress_field;
    private javax.swing.JTextField shippingstreetaddress_textfield;
    private javax.swing.JLabel shippingzipcode;
    private javax.swing.JLabel shippingzipcode1;
    private javax.swing.JLabel shippingzipcode_field;
    private javax.swing.JTextField shippingzipcode_textfield;
    private javax.swing.JLabel streetaddress;
    private javax.swing.JLabel streetaddress1;
    private javax.swing.JLabel streetaddress_field;
    private javax.swing.JTextField streetaddress_textfield;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel updatecase_button;
    private javax.swing.JTable updatecase_table;
    private javax.swing.JLabel view_background;
    private javax.swing.JLabel view_button;
    private javax.swing.JPanel view_panel;
    private javax.swing.JLabel viewback_button;
    private javax.swing.JRadioButton viewbaggage_radiobutton;
    private javax.swing.JRadioButton viewclient_radiobutton;
    private javax.swing.JLabel welcomeuser;
    private javax.swing.JLabel zipcode;
    private javax.swing.JLabel zipcode1;
    private javax.swing.JLabel zipcode_field;
    private javax.swing.JTextField zipcode_textfield;
    // End of variables declaration//GEN-END:variables
}
