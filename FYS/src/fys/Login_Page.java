package fys;

import javax.swing.ImageIcon;

/**
 * This class enables users to log in with a username and password.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class Login_Page extends javax.swing.JPanel {

    /**
     * Initiates the page and hides the context-aware manual.
     */
    public Login_Page() {
        initComponents();

        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        manual_panel = new javax.swing.JPanel();
        exitManual = new javax.swing.JLabel();
        manualTitle = new javax.swing.JLabel();
        manualText = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        call_manual = new javax.swing.JLabel();
        login_button = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        password = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        manualText.setText("<html>\nFill in your username and password in the given fields, then click on\n'Log In'. \n<br>\n<br>\nIf you can't remember your username or password, or you're having\ntrouble logging in, please contact the Application Manager.");
        manualText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        manualText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        manual_panel.add(manualText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 520));

        main_panel.add(manual_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 290, 600));

        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        main_panel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 70));

        call_manual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        call_manual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                call_manualMouseClicked(evt);
            }
        });
        main_panel.add(call_manual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 22, 30, 30));

        login_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login_button.setForeground(new java.awt.Color(255, 255, 255));
        login_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        login_button.setText("Log In");
        login_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_buttonMouseExited(evt);
            }
        });
        main_panel.add(login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("Log In");
        main_panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        username.setForeground(new java.awt.Color(153, 0, 0));
        username.setText("Username");
        main_panel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, -1, -1));

        username_field.setForeground(new java.awt.Color(153, 0, 0));
        username_field.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        main_panel.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 520, 20));
        main_panel.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 520, -1));

        password.setForeground(new java.awt.Color(153, 0, 0));
        password.setText("Password");
        main_panel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, -1));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        main_panel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));

        add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void call_manualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_call_manualMouseClicked
        if (manual_panel.isVisible()) {
            manual_panel.setVisible(false);
            manual_panel.setEnabled(false);
        } else {
            manual_panel.setVisible(true);
            manual_panel.setEnabled(true);
        }
    }//GEN-LAST:event_call_manualMouseClicked

    private void login_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        login_button.setIcon(II);
    }//GEN-LAST:event_login_buttonMouseEntered

    private void login_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        login_button.setIcon(II);
    }//GEN-LAST:event_login_buttonMouseExited

    private void login_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseClicked
        String username = username_field.getText();
        String password = new String(password_field.getPassword());

        FYS.getQueryManager().login(username, password);
    }//GEN-LAST:event_login_buttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel login_button;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel title;
    private javax.swing.JLabel username;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
