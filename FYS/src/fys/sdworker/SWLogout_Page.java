package fys.sdworker;

import fys.FYS;
import fys.Login_Page;
import fys.TrackUser;
import javax.swing.ImageIcon;

/**
 * This class enables service-desk-workers to log out.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class SWLogout_Page extends javax.swing.JPanel {

    /**
     * Initiates the page, hides the context-aware manual and sets a welcome text.
     */
    public SWLogout_Page() {
        initComponents();

        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");

        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
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
        logout_button = new javax.swing.JLabel();
        newcase_button = new javax.swing.JLabel();
        updatecase_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        smalllogout_button = new javax.swing.JLabel();
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
        manualText.setText("<html>\nIf you wish to log out, please click on 'Log Out'\nand you will be returned to the login page.\nOtherwise, click on one of the buttons in the menu\nbar to navigate to another page without logging out.");
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
        logout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
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

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("Log Out");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Are you sure you wish to log out?");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        smalllogout_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        smalllogout_button.setForeground(new java.awt.Color(255, 255, 255));
        smalllogout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        smalllogout_button.setText("Log Out");
        smalllogout_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smalllogout_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        smalllogout_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smalllogout_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                smalllogout_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                smalllogout_buttonMouseExited(evt);
            }
        });
        add(smalllogout_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 400, -1, -1));

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
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
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

    }//GEN-LAST:event_logout_buttonMouseEntered

    private void logout_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseExited

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

    }//GEN-LAST:event_logout_buttonMouseClicked

    private void smalllogout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smalllogout_buttonMouseClicked
        FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "SWLogout_Page", "Logged out.");
        FYS.getInstance().showPage(new Login_Page());
    }//GEN-LAST:event_smalllogout_buttonMouseClicked

    private void smalllogout_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smalllogout_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        smalllogout_button.setIcon(II);
    }//GEN-LAST:event_smalllogout_buttonMouseEntered

    private void smalllogout_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smalllogout_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        smalllogout_button.setIcon(II);
    }//GEN-LAST:event_smalllogout_buttonMouseExited

    private void newcase_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcase_buttonMouseClicked
        FYS.getInstance().showPage(new NewCase_Page());
    }//GEN-LAST:event_newcase_buttonMouseClicked

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel newcase_button;
    private javax.swing.JLabel search_button;
    private javax.swing.JLabel smalllogout_button;
    private javax.swing.JLabel title;
    private javax.swing.JLabel updatecase_button;
    private javax.swing.JLabel welcomeuser;
    // End of variables declaration//GEN-END:variables
}
