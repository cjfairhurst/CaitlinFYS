package fys.appmanager;

import fys.FYS;
import fys.TrackUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class enables app-managers to search and view accounts.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class AppManSearch_Page extends javax.swing.JPanel {

    String selectedRow;
    String selectedUsername;
    private boolean tableClicked = false;
    private boolean radiobuttonSelected = false;
    private String searchType;
    private String searchTerm;

    /**
     * Initiates the page, shows the right panel, groups the radio buttons, hides the context-aware
     * manual and sets a welcome text.
     */
    public AppManSearch_Page() {
        initComponents();

        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");

        emptyfield_warning.setVisible(false);
        emptyfield_warning.setVisible(false);
        view_panel.setVisible(false);
        view_panel.setEnabled(false);
        edit_panel.setVisible(false);
        edit_panel.setEnabled(false);
        editemptyfield_warning.setVisible(false);
        editemptyfield_warning.setVisible(false);

        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);

        ButtonGroup group = new ButtonGroup();
        group.add(employeeid_radiobutton);
        group.add(username_radiobutton);
        group.add(firstname_radiobutton);
        group.add(lastname_radiobutton);
    }

    /**
     * Fills the table by searching in the column of the database, which is selected based on the
     * radio button.
     *
     * @return a filled table.
     */
    public ResultSet searchAccount() {
        if (employeeid_radiobutton.isSelected()) {
            searchType = "employee_id";
        } else if (username_radiobutton.isSelected()) {
            searchType = "username";
        } else if (firstname_radiobutton.isSelected()) {
            searchType = "first_name";
        } else if (lastname_radiobutton.isSelected()) {
            searchType = "last_name";
        }

        searchTerm = search_field.getText();

        return FYS.getQueryManager().fillTableMAS(searchType, searchTerm);
    }

    /**
     * Fills fields with data from the database based on the selected row within the table.
     *
     * @param rs
     * @throws SQLException
     */
    public void viewAccount(ResultSet rs) throws SQLException {
        if (rs.next()) {
            String employee_id = rs.getString("employee_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String telephone_number = rs.getString("telephone_number");
            String function = rs.getString("function");
            String location = rs.getString("location");

            switch (function) {
                case "appmanager":
                    accounttype_field.setText("Application Manager");
                    appmanager_radiobutton.setSelected(true);
                    break;
                case "manager":
                    accounttype_field.setText("Manager");
                    manager_radiobutton.setSelected(true);
                    break;
                case "sdworker":
                    accounttype_field.setText("Service Desk Worker");
                    sdworker_radiobutton.setSelected(true);
                    break;
                default:
                    accounttype_field.setText("Unknown");
                    break;
            }
            employeeid_field.setText(employee_id);
            firstname_field.setText(first_name);
            lastname_field.setText(last_name);
            username_field.setText(username);
            password_field.setText(password);
            email_field.setText(email);
            phonenumber_field.setText(telephone_number);
            location_field.setText(location);

            employeeid_textfield.setText(employee_id);
            firstname_textfield.setText(first_name);
            lastname_textfield.setText(last_name);
            username_textfield.setText(username);
            password_textfield.setText(password);
            email_textfield.setText(email);
            phonenumber_textfield.setText(telephone_number);
            location_combo.setSelectedItem(location);
        }
    }

    /**
     * Sets a number of variables to be used in a query to edit the details of a particular row in
     * the employee database.
     */
    public void editAccount() {
        String employeeID = employeeid_textfield.getText();
        String firstName = firstname_textfield.getText();
        String lastName = lastname_textfield.getText();
        String username = username_textfield.getText();
        String password = password_textfield.getText();
        String email = email_textfield.getText();
        String phoneNumber = phonenumber_textfield.getText();
        String location = location_combo.getSelectedItem().toString();

        String employeeFunction;
        if (appmanager_radiobutton.isSelected()) {
            employeeFunction = "appmanager";
        } else if (manager_radiobutton.isSelected()) {
            employeeFunction = "manager";
        } else if (sdworker_radiobutton.isSelected()) {
            employeeFunction = "sdworker";
        } else {
            employeeFunction = "";
        }

        FYS.getQueryManager().editAccount(employeeID, firstName, lastName, username, password,
                email, phoneNumber, employeeFunction, location, selectedRow);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeuser = new javax.swing.JLabel();
        userlogs_button = new javax.swing.JLabel();
        manual_panel = new javax.swing.JPanel();
        exitManual = new javax.swing.JLabel();
        manualTitle = new javax.swing.JLabel();
        manualText = new javax.swing.JLabel();
        view_panel = new javax.swing.JPanel();
        edit_panel = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        account_type1 = new javax.swing.JLabel();
        sdworker_radiobutton = new javax.swing.JRadioButton();
        manager_radiobutton = new javax.swing.JRadioButton();
        appmanager_radiobutton = new javax.swing.JRadioButton();
        employee_id1 = new javax.swing.JLabel();
        first_name1 = new javax.swing.JLabel();
        last_name1 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        phone_number1 = new javax.swing.JLabel();
        phonenumber_textfield = new javax.swing.JTextField();
        email_textfield = new javax.swing.JTextField();
        password_textfield = new javax.swing.JTextField();
        username_textfield = new javax.swing.JTextField();
        lastname_textfield = new javax.swing.JTextField();
        firstname_textfield = new javax.swing.JTextField();
        employeeid_textfield = new javax.swing.JTextField();
        save_button = new javax.swing.JLabel();
        editemptyfield_warning = new javax.swing.JLabel();
        edit_background = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        location_combo = new javax.swing.JComboBox();
        title1 = new javax.swing.JLabel();
        account_type = new javax.swing.JLabel();
        accounttype_field = new javax.swing.JLabel();
        location_label = new javax.swing.JLabel();
        location_field = new javax.swing.JLabel();
        employeeid_field = new javax.swing.JLabel();
        firstname_field = new javax.swing.JLabel();
        lastname_field = new javax.swing.JLabel();
        username_field = new javax.swing.JLabel();
        password_field = new javax.swing.JLabel();
        email_field = new javax.swing.JLabel();
        phonenumber_field = new javax.swing.JLabel();
        phone_number = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        last_name = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        employee_id = new javax.swing.JLabel();
        edit_button = new javax.swing.JLabel();
        viewback_button = new javax.swing.JLabel();
        view_background = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        emptyfield_warning = new javax.swing.JLabel();
        call_manual = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        logout_button = new javax.swing.JLabel();
        newaccount_button = new javax.swing.JLabel();
        manageaccounts_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        smallsearch_button = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();
        searchby = new javax.swing.JLabel();
        employeeid_radiobutton = new javax.swing.JRadioButton();
        username_radiobutton = new javax.swing.JRadioButton();
        lastname_radiobutton = new javax.swing.JRadioButton();
        firstname_radiobutton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchaccounts_table = new javax.swing.JTable();
        view_button = new javax.swing.JLabel();
        delete_button = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomeuser.setForeground(new java.awt.Color(255, 255, 255));
        welcomeuser.setText("Welcome ");
        add(welcomeuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        userlogs_button.setForeground(new java.awt.Color(255, 255, 255));
        userlogs_button.setText("View User Logs");
        userlogs_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userlogs_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userlogs_buttonMouseClicked(evt);
            }
        });
        add(userlogs_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, -1));

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
        manualText.setText("<html>\nFill in your search time and choose the type of search\nyou wish to make by selecting one of the radio buttons, then \nclick 'Search'. A list of searches matching your term will appear\nin the table on the bottom half of the screen. If nothing appears,\nthen there are no accounts that match your term.\n<br>\n<br>\nSelect an account from the table and click on 'Delete' if you wish to\npermanently delete it from the database. Otherwise, click on 'View'\nand a screen will appear with all the available information from your\nselected account. From here, you can click on 'Edit' to change the\ninformation, then 'Save' to permanently save the new data in the \ndatabase. Click on the red and white arrow button to return \nto the original search page.");
        manualText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        manualText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        manual_panel.add(manualText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 520));

        add(manual_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 290, 600));

        view_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_panel.setBackground(new java.awt.Color(255, 255, 255));
        edit_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title2.setForeground(new java.awt.Color(153, 0, 0));
        title2.setText("Edit Account");
        edit_panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        account_type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type1.setForeground(new java.awt.Color(153, 0, 0));
        account_type1.setText("Account Type: *");
        edit_panel.add(account_type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        sdworker_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        sdworker_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdworker_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        sdworker_radiobutton.setText("Service Desk Worker");
        sdworker_radiobutton.setBorder(null);
        sdworker_radiobutton.setOpaque(false);
        edit_panel.add(sdworker_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        manager_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        manager_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manager_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        manager_radiobutton.setText("Manager");
        manager_radiobutton.setBorder(null);
        manager_radiobutton.setOpaque(false);
        edit_panel.add(manager_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        appmanager_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        appmanager_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appmanager_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        appmanager_radiobutton.setText("Application Manager");
        appmanager_radiobutton.setBorder(null);
        appmanager_radiobutton.setOpaque(false);
        appmanager_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appmanager_radiobuttonActionPerformed(evt);
            }
        });
        edit_panel.add(appmanager_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        employee_id1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employee_id1.setForeground(new java.awt.Color(153, 0, 0));
        employee_id1.setText("Employee ID: *");
        edit_panel.add(employee_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        first_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name1.setForeground(new java.awt.Color(153, 0, 0));
        first_name1.setText("First Name: *");
        edit_panel.add(first_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        last_name1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name1.setForeground(new java.awt.Color(153, 0, 0));
        last_name1.setText("Last Name: *");
        edit_panel.add(last_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        username1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(153, 0, 0));
        username1.setText("Username: *");
        edit_panel.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        password1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(153, 0, 0));
        password1.setText("Password: *");
        edit_panel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        email1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email1.setForeground(new java.awt.Color(153, 0, 0));
        email1.setText("Email:");
        edit_panel.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        phone_number1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number1.setForeground(new java.awt.Color(153, 0, 0));
        phone_number1.setText("Phone Number:");
        edit_panel.add(phone_number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        phonenumber_textfield.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(phonenumber_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 520, 20));

        email_textfield.setForeground(new java.awt.Color(153, 0, 0));
        email_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(email_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 520, 20));

        password_textfield.setForeground(new java.awt.Color(153, 0, 0));
        password_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(password_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 520, 20));

        username_textfield.setForeground(new java.awt.Color(153, 0, 0));
        username_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(username_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 520, 20));

        lastname_textfield.setForeground(new java.awt.Color(153, 0, 0));
        lastname_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(lastname_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 520, 20));

        firstname_textfield.setForeground(new java.awt.Color(153, 0, 0));
        firstname_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(firstname_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 520, 20));

        employeeid_textfield.setForeground(new java.awt.Color(153, 0, 0));
        employeeid_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        edit_panel.add(employeeid_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 520, 20));

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
        edit_panel.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, -1, -1));

        editemptyfield_warning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editemptyfield_warning.setForeground(new java.awt.Color(153, 0, 0));
        editemptyfield_warning.setText("* One or more required fields are empty. Please fill them in and try again.");
        edit_panel.add(editemptyfield_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        edit_background.setBackground(new java.awt.Color(255, 255, 255));
        edit_panel.add(edit_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        location.setForeground(new java.awt.Color(153, 0, 0));
        location.setText("Location: *");
        edit_panel.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        location_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Location", "Amsterdam", "Dubai" }));
        edit_panel.add(location_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 230, -1));

        view_panel.add(edit_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1200, 550));

        title1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(153, 0, 0));
        title1.setText("View Account");
        view_panel.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        account_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type.setForeground(new java.awt.Color(153, 0, 0));
        account_type.setText("Account Type:");
        view_panel.add(account_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        accounttype_field.setForeground(new java.awt.Color(153, 0, 0));
        accounttype_field.setText("Example");
        view_panel.add(accounttype_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 300, 20));

        location_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        location_label.setForeground(new java.awt.Color(153, 0, 0));
        location_label.setText("Location:");
        view_panel.add(location_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        location_field.setForeground(new java.awt.Color(153, 0, 0));
        location_field.setText("Example");
        view_panel.add(location_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 300, 20));

        employeeid_field.setForeground(new java.awt.Color(153, 0, 0));
        employeeid_field.setText("Example");
        view_panel.add(employeeid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 300, 20));

        firstname_field.setForeground(new java.awt.Color(153, 0, 0));
        firstname_field.setText("Example");
        view_panel.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 300, 20));

        lastname_field.setForeground(new java.awt.Color(153, 0, 0));
        lastname_field.setText("Example");
        view_panel.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 300, 20));

        username_field.setForeground(new java.awt.Color(153, 0, 0));
        username_field.setText("Example");
        view_panel.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 300, 20));

        password_field.setForeground(new java.awt.Color(153, 0, 0));
        password_field.setText("Example");
        view_panel.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 300, 20));

        email_field.setForeground(new java.awt.Color(153, 0, 0));
        email_field.setText("Example");
        view_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 300, 20));

        phonenumber_field.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_field.setText("Example");
        view_panel.add(phonenumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 300, 20));

        phone_number.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(153, 0, 0));
        phone_number.setText("Phone Number:");
        view_panel.add(phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 0, 0));
        email.setText("Email:");
        view_panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 0, 0));
        password.setText("Password:");
        view_panel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(153, 0, 0));
        username.setText("Username:");
        view_panel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name.setForeground(new java.awt.Color(153, 0, 0));
        last_name.setText("Last Name:");
        view_panel.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name.setForeground(new java.awt.Color(153, 0, 0));
        first_name.setText("First Name:");
        view_panel.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        employee_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employee_id.setForeground(new java.awt.Color(153, 0, 0));
        employee_id.setText("Employee ID:");
        view_panel.add(employee_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

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

        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 70));

        emptyfield_warning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emptyfield_warning.setForeground(new java.awt.Color(153, 0, 0));
        emptyfield_warning.setText("* Please fill in what type of search you'd like to make, as well as your search term.");
        add(emptyfield_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        call_manual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        call_manual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                call_manualMouseClicked(evt);
            }
        });
        add(call_manual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 22, 30, 30));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("Search Accounts");
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

        newaccount_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newaccount_button.setForeground(new java.awt.Color(153, 0, 0));
        newaccount_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        newaccount_button.setText("New Account");
        newaccount_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newaccount_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newaccount_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newaccount_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newaccount_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newaccount_buttonMouseExited(evt);
            }
        });
        add(newaccount_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 101, 250, -1));

        manageaccounts_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manageaccounts_button.setForeground(new java.awt.Color(153, 0, 0));
        manageaccounts_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        manageaccounts_button.setText("Manage Accounts");
        manageaccounts_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageaccounts_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageaccounts_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageaccounts_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageaccounts_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageaccounts_buttonMouseExited(evt);
            }
        });
        add(manageaccounts_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 101, 250, -1));

        search_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_button.setForeground(new java.awt.Color(153, 0, 0));
        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
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

        smallsearch_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        smallsearch_button.setForeground(new java.awt.Color(255, 255, 255));
        smallsearch_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        smallsearch_button.setText("Search");
        smallsearch_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallsearch_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        smallsearch_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smallsearch_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                smallsearch_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                smallsearch_buttonMouseExited(evt);
            }
        });
        add(smallsearch_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.setForeground(new java.awt.Color(153, 0, 0));
        search.setText("Search:");
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        search_field.setForeground(new java.awt.Color(153, 0, 0));
        search_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 520, 20));

        searchby.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchby.setForeground(new java.awt.Color(153, 0, 0));
        searchby.setText("Search By:");
        add(searchby, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        employeeid_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        employeeid_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeid_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        employeeid_radiobutton.setText("Employee ID");
        employeeid_radiobutton.setBorder(null);
        employeeid_radiobutton.setOpaque(false);
        add(employeeid_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        username_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        username_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        username_radiobutton.setText("Username");
        username_radiobutton.setBorder(null);
        username_radiobutton.setOpaque(false);
        add(username_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, -1));

        lastname_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        lastname_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastname_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        lastname_radiobutton.setText("Last Name");
        lastname_radiobutton.setBorder(null);
        lastname_radiobutton.setOpaque(false);
        lastname_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname_radiobuttonActionPerformed(evt);
            }
        });
        add(lastname_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, -1, -1));

        firstname_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        firstname_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstname_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        firstname_radiobutton.setText("First Name");
        firstname_radiobutton.setBorder(null);
        firstname_radiobutton.setOpaque(false);
        firstname_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname_radiobuttonActionPerformed(evt);
            }
        });
        add(firstname_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        searchaccounts_table.setModel(new javax.swing.table.DefaultTableModel(
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
        searchaccounts_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchaccounts_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(searchaccounts_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 860, 200));

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
        add(view_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, -1, -1));

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
        add(delete_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, -1, -1));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void newaccount_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        newaccount_button.setIcon(II);
    }//GEN-LAST:event_newaccount_buttonMouseEntered

    private void newaccount_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        newaccount_button.setIcon(II);
    }//GEN-LAST:event_newaccount_buttonMouseExited

    private void manageaccounts_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageaccounts_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        manageaccounts_button.setIcon(II);
    }//GEN-LAST:event_manageaccounts_buttonMouseEntered

    private void manageaccounts_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageaccounts_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        manageaccounts_button.setIcon(II);
    }//GEN-LAST:event_manageaccounts_buttonMouseExited

    private void search_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        search_button.setIcon(II);
    }//GEN-LAST:event_search_buttonMouseEntered

    private void search_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
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

    private void smallsearch_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallsearch_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        smallsearch_button.setIcon(II);
    }//GEN-LAST:event_smallsearch_buttonMouseEntered

    private void smallsearch_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallsearch_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        smallsearch_button.setIcon(II);
    }//GEN-LAST:event_smallsearch_buttonMouseExited

    private void call_manualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_call_manualMouseClicked
        if (manual_panel.isVisible()) {
            manual_panel.setVisible(false);
            manual_panel.setEnabled(false);
        } else {
            manual_panel.setVisible(true);
            manual_panel.setEnabled(true);
        }
    }//GEN-LAST:event_call_manualMouseClicked

    private void lastname_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname_radiobuttonActionPerformed

    }//GEN-LAST:event_lastname_radiobuttonActionPerformed

    private void firstname_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname_radiobuttonActionPerformed

    }//GEN-LAST:event_firstname_radiobuttonActionPerformed

    private void smallsearch_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallsearch_buttonMouseClicked
        radiobuttonSelected = employeeid_radiobutton.isSelected()
                || username_radiobutton.isSelected()
                || firstname_radiobutton.isSelected()
                || lastname_radiobutton.isSelected();

        String searchFieldText = search_field.getText();

        if (radiobuttonSelected && !"".equals(searchFieldText)) {
            emptyfield_warning.setVisible(false);
            emptyfield_warning.setVisible(false);
            FYS.getInstance().updateTable(searchaccounts_table, searchAccount());
            FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "AppManSearch_Page",
                    "Searched for account " + searchFieldText + ".");
        } else {
            emptyfield_warning.setVisible(true);
            emptyfield_warning.setVisible(true);
        }
    }//GEN-LAST:event_smallsearch_buttonMouseClicked

    private void newaccount_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseClicked
        FYS.getInstance().showPage(new NewAccount_Page());
    }//GEN-LAST:event_newaccount_buttonMouseClicked

    private void manageaccounts_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageaccounts_buttonMouseClicked
        FYS.getInstance().showPage(new ManageAccounts_Page());
    }//GEN-LAST:event_manageaccounts_buttonMouseClicked

    private void logout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseClicked
        FYS.getInstance().showPage(new AppManLogout_Page());
    }//GEN-LAST:event_logout_buttonMouseClicked

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        FYS.getInstance().showPage(new AppManSearch_Page());
    }//GEN-LAST:event_search_buttonMouseClicked

    private void searchaccounts_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchaccounts_tableMouseClicked
        int row = searchaccounts_table.getSelectedRow();
        selectedRow = (searchaccounts_table.getModel().getValueAt(row, 0).toString());
        selectedUsername = (searchaccounts_table.getModel().getValueAt(row, 3).toString());
        tableClicked = true;
    }//GEN-LAST:event_searchaccounts_tableMouseClicked

    private void view_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseClicked
        if (tableClicked) {
            try {
                viewAccount(FYS.getQueryManager().viewAccount(selectedRow));
            } catch (SQLException ex) {
                Logger.getLogger(ManageAccounts_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
            view_panel.setVisible(true);
            view_panel.setEnabled(true);
            searchaccounts_table.setVisible(false);
            searchaccounts_table.setEnabled(false);
            search_field.setVisible(false);
            search_field.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an account from the table.",
                    "Selection Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_view_buttonMouseClicked

    private void view_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseEntered

    private void view_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseExited

    private void delete_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_buttonMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this account?", "Delete Account",
                JOptionPane.YES_NO_OPTION);

        if (confirm == 0) {
            FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "AppManSearch_Page",
                    "Deleted account " + selectedUsername + ".");

            FYS.getQueryManager().deleteAccountMA(selectedRow);
            FYS.getInstance().showPage(new ManageAccounts_Page());
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

    private void appmanager_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appmanager_radiobuttonActionPerformed

    }//GEN-LAST:event_appmanager_radiobuttonActionPerformed

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
        radiobuttonSelected = appmanager_radiobutton.isSelected()
                || manager_radiobutton.isSelected()
                || sdworker_radiobutton.isSelected();

        if (employeeid_textfield.getText().equals("") || firstname_textfield.getText().equals("")
                || lastname_textfield.getText().equals("")
                || username_textfield.getText().equals("")
                || password_textfield.getText().equals("") || radiobuttonSelected == false) {

            editemptyfield_warning.setVisible(true);
            editemptyfield_warning.setEnabled(true);
        } else {
            FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "AppManSearch_Page",
                    "Updated account " + username_field.getText() + ".");

            editAccount();
            FYS.getInstance().showPage(new AppManSearch_Page());
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
        FYS.getInstance().showPage(new AppManSearch_Page());
    }//GEN-LAST:event_viewback_buttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    private void userlogs_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userlogs_buttonMouseClicked
        FYS.getInstance().showPage(new Logs_Page());
    }//GEN-LAST:event_userlogs_buttonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_type;
    private javax.swing.JLabel account_type1;
    private javax.swing.JLabel accounttype_field;
    private javax.swing.JRadioButton appmanager_radiobutton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel delete_button;
    private javax.swing.JLabel edit_background;
    private javax.swing.JLabel edit_button;
    private javax.swing.JPanel edit_panel;
    private javax.swing.JLabel editemptyfield_warning;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email1;
    private javax.swing.JLabel email_field;
    private javax.swing.JTextField email_textfield;
    private javax.swing.JLabel employee_id;
    private javax.swing.JLabel employee_id1;
    private javax.swing.JLabel employeeid_field;
    private javax.swing.JRadioButton employeeid_radiobutton;
    private javax.swing.JTextField employeeid_textfield;
    private javax.swing.JLabel emptyfield_warning;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel firstname_field;
    private javax.swing.JRadioButton firstname_radiobutton;
    private javax.swing.JTextField firstname_textfield;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel last_name;
    private javax.swing.JLabel last_name1;
    private javax.swing.JLabel lastname_field;
    private javax.swing.JRadioButton lastname_radiobutton;
    private javax.swing.JTextField lastname_textfield;
    private javax.swing.JLabel location;
    private javax.swing.JComboBox location_combo;
    private javax.swing.JLabel location_field;
    private javax.swing.JLabel location_label;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JLabel manageaccounts_button;
    private javax.swing.JRadioButton manager_radiobutton;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel newaccount_button;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password_field;
    private javax.swing.JTextField password_textfield;
    private javax.swing.JLabel phone_number;
    private javax.swing.JLabel phone_number1;
    private javax.swing.JLabel phonenumber_field;
    private javax.swing.JTextField phonenumber_textfield;
    private javax.swing.JLabel save_button;
    private javax.swing.JRadioButton sdworker_radiobutton;
    private javax.swing.JLabel search;
    private javax.swing.JLabel search_button;
    private javax.swing.JTextField search_field;
    private javax.swing.JTable searchaccounts_table;
    private javax.swing.JLabel searchby;
    private javax.swing.JLabel smallsearch_button;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel userlogs_button;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username_field;
    private javax.swing.JRadioButton username_radiobutton;
    private javax.swing.JTextField username_textfield;
    private javax.swing.JLabel view_background;
    private javax.swing.JLabel view_button;
    private javax.swing.JPanel view_panel;
    private javax.swing.JLabel viewback_button;
    private javax.swing.JLabel welcomeuser;
    // End of variables declaration//GEN-END:variables
}
