package fys.appmanager;

import fys.FYS;
import fys.TrackUser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class enables app-managers to create new accounts.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class NewAccount_Page extends javax.swing.JPanel {

    boolean radiobuttonSelected = false;

    /**
     * Initiates the page, groups the radio buttons, hides the context-aware manual and sets a
     * welcome text.
     */
    public NewAccount_Page() {
        initComponents();

        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");

        emptyfield_warning.setVisible(false);
        emptyfield_warning.setEnabled(false);
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);

        ButtonGroup group = new ButtonGroup();
        group.add(appmanager_radiobutton);
        group.add(manager_radiobutton);
        group.add(sdworker_radiobutton);
    }

    /**
     * Saves the account in the database.
     */
    public void saveAccount() {
        String employeeID = employeeid_field.getText();
        String firstName = firstname_field.getText();
        String lastName = lastname_field.getText();
        String username = username_field.getText();
        String password = password_field.getText();
        String email = email_field.getText();
        String phoneNumber = phonenumber_field.getText();
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

        FYS.getQueryManager().saveAccount(employeeID, firstName, lastName, username, password,
                email, phoneNumber, employeeFunction, location);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userlogs_button = new javax.swing.JLabel();
        manual_panel = new javax.swing.JPanel();
        exitManual = new javax.swing.JLabel();
        manualTitle = new javax.swing.JLabel();
        manualText = new javax.swing.JLabel();
        main_panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        welcomeuser = new javax.swing.JLabel();
        call_manual = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        account_type = new javax.swing.JLabel();
        sdworker_radiobutton = new javax.swing.JRadioButton();
        appmanager_radiobutton = new javax.swing.JRadioButton();
        manager_radiobutton = new javax.swing.JRadioButton();
        location = new javax.swing.JLabel();
        location_combo = new javax.swing.JComboBox();
        employee_id = new javax.swing.JLabel();
        employeeid_field = new javax.swing.JTextField();
        first_name = new javax.swing.JLabel();
        firstname_field = new javax.swing.JTextField();
        last_name = new javax.swing.JLabel();
        lastname_field = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        password_field = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        phone_number = new javax.swing.JLabel();
        phonenumber_field = new javax.swing.JTextField();
        logout_button = new javax.swing.JLabel();
        newaccount_button = new javax.swing.JLabel();
        manageaccounts_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        emptyfield_warning = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        manualText.setText("<html>\nFill in the given fields with the desired information and\nselect one of the radio buttons to designate the type of\naccount you wish to make. When finished, click on 'Save'\nto create and save the account. \n<br>\n<br>\nRequired fields are marked with a *.");
        manualText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        manualText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        manual_panel.add(manualText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 520));

        add(manual_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 290, 600));

        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        main_panel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 70));

        welcomeuser.setForeground(new java.awt.Color(255, 255, 255));
        welcomeuser.setText("Welcome ");
        main_panel.add(welcomeuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        call_manual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        call_manual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                call_manualMouseClicked(evt);
            }
        });
        main_panel.add(call_manual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 22, 30, 30));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("New Account");
        main_panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        account_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        account_type.setForeground(new java.awt.Color(153, 0, 0));
        account_type.setText("Account Type: *");
        main_panel.add(account_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        sdworker_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        sdworker_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdworker_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        sdworker_radiobutton.setText("Service Desk Worker");
        sdworker_radiobutton.setBorder(null);
        sdworker_radiobutton.setOpaque(false);
        main_panel.add(sdworker_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

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
        main_panel.add(appmanager_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, -1, -1));

        manager_radiobutton.setBackground(new java.awt.Color(255, 255, 255));
        manager_radiobutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manager_radiobutton.setForeground(new java.awt.Color(153, 0, 0));
        manager_radiobutton.setText("Manager");
        manager_radiobutton.setBorder(null);
        manager_radiobutton.setOpaque(false);
        main_panel.add(manager_radiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        location.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        location.setForeground(new java.awt.Color(153, 0, 0));
        location.setText("Location: *");
        main_panel.add(location, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        location_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Location", "Amsterdam", "Dubai" }));
        main_panel.add(location_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 230, -1));

        employee_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employee_id.setForeground(new java.awt.Color(153, 0, 0));
        employee_id.setText("Employee ID: *");
        main_panel.add(employee_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        employeeid_field.setForeground(new java.awt.Color(153, 0, 0));
        employeeid_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(employeeid_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 520, 20));

        first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        first_name.setForeground(new java.awt.Color(153, 0, 0));
        first_name.setText("First Name: *");
        main_panel.add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        firstname_field.setForeground(new java.awt.Color(153, 0, 0));
        firstname_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(firstname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 520, 20));

        last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        last_name.setForeground(new java.awt.Color(153, 0, 0));
        last_name.setText("Last Name: *");
        main_panel.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        lastname_field.setForeground(new java.awt.Color(153, 0, 0));
        lastname_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(lastname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 520, 20));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(153, 0, 0));
        username.setText("Username: *");
        main_panel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        username_field.setForeground(new java.awt.Color(153, 0, 0));
        username_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 520, 20));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(153, 0, 0));
        password.setText("Password: *");
        main_panel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        password_field.setForeground(new java.awt.Color(153, 0, 0));
        password_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 520, 20));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 0, 0));
        email.setText("Email:");
        main_panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        email_field.setForeground(new java.awt.Color(153, 0, 0));
        email_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(email_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 520, 20));

        phone_number.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(153, 0, 0));
        phone_number.setText("Phone Number:");
        main_panel.add(phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        phonenumber_field.setForeground(new java.awt.Color(153, 0, 0));
        phonenumber_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(phonenumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 520, 20));

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
        main_panel.add(logout_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 101, 250, -1));

        newaccount_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newaccount_button.setForeground(new java.awt.Color(153, 0, 0));
        newaccount_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
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
        main_panel.add(newaccount_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 101, 250, -1));

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
        main_panel.add(manageaccounts_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 101, 250, -1));

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
        main_panel.add(search_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 101, 250, -1));

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
        main_panel.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 580, -1, -1));

        emptyfield_warning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emptyfield_warning.setForeground(new java.awt.Color(153, 0, 0));
        emptyfield_warning.setText("* One or more required fields are empty. Please fill them in and try again.");
        main_panel.add(emptyfield_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, -1, -1));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        main_panel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));

        add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void newaccount_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        newaccount_button.setIcon(II);
    }//GEN-LAST:event_newaccount_buttonMouseEntered

    private void newaccount_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
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

    private void appmanager_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appmanager_radiobuttonActionPerformed

    }//GEN-LAST:event_appmanager_radiobuttonActionPerformed

    private void manageaccounts_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageaccounts_buttonMouseClicked
        FYS.getInstance().showPage(new ManageAccounts_Page());
    }//GEN-LAST:event_manageaccounts_buttonMouseClicked

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        FYS.getInstance().showPage(new AppManSearch_Page());
    }//GEN-LAST:event_search_buttonMouseClicked

    private void logout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseClicked
        FYS.getInstance().showPage(new AppManLogout_Page());
    }//GEN-LAST:event_logout_buttonMouseClicked

    private void newaccount_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaccount_buttonMouseClicked
        FYS.getInstance().showPage(new NewAccount_Page());
    }//GEN-LAST:event_newaccount_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked

        radiobuttonSelected = appmanager_radiobutton.isSelected()
                || manager_radiobutton.isSelected()
                || sdworker_radiobutton.isSelected();

        boolean missingField = employeeid_field.getText().equals("")
                || firstname_field.getText().equals("") || lastname_field.getText().equals("")
                || username_field.getText().equals("") || password_field.getText().equals("")
                || radiobuttonSelected == false
                || location_combo.getSelectedItem().toString().equals("Location");

        if (missingField) {
            emptyfield_warning.setVisible(true);
            emptyfield_warning.setEnabled(true);
        } else {
            if (FYS.getQueryManager().checkUniqueUsername(username_field.getText())) {
                FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "NewAccount_Page",
                        "Created account " + username_field.getText() + ".");

                saveAccount();
                FYS.getInstance().showPage(new NewAccount_Page());
            } else {
                JOptionPane.showMessageDialog(null, "The username you've chosen is already in use.",
                        "Duplicate Username", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_save_buttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    private void userlogs_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userlogs_buttonMouseClicked
        FYS.getInstance().showPage(new Logs_Page());
    }//GEN-LAST:event_userlogs_buttonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel account_type;
    private javax.swing.JRadioButton appmanager_radiobutton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel email;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel employee_id;
    private javax.swing.JTextField employeeid_field;
    private javax.swing.JLabel emptyfield_warning;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel first_name;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JLabel last_name;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JLabel location;
    private javax.swing.JComboBox location_combo;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel manageaccounts_button;
    private javax.swing.JRadioButton manager_radiobutton;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel newaccount_button;
    private javax.swing.JLabel password;
    private javax.swing.JTextField password_field;
    private javax.swing.JLabel phone_number;
    private javax.swing.JTextField phonenumber_field;
    private javax.swing.JLabel save_button;
    private javax.swing.JRadioButton sdworker_radiobutton;
    private javax.swing.JLabel search_button;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userlogs_button;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel welcomeuser;
    // End of variables declaration//GEN-END:variables
}
