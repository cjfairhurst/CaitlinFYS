package fys.manager;

import fys.FYS;
import fys.TrackUser;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GraphicData_Page extends javax.swing.JPanel {

    String fromDate = "";
    String toDate = "";

    public GraphicData_Page() {
        initComponents();
        welcomeuser.setText("Welcome " + TrackUser.getCurrentUser() + ".");
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
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
        title = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        call_manual = new javax.swing.JLabel();
        logout_button = new javax.swing.JLabel();
        casedata_button = new javax.swing.JLabel();
        graphicdata_button = new javax.swing.JLabel();
        search_button = new javax.swing.JLabel();
        view_button = new javax.swing.JLabel();
        generategraph_button = new javax.swing.JLabel();
        fromdate = new javax.swing.JLabel();
        fromday_combo = new javax.swing.JComboBox();
        frommonth_combo = new javax.swing.JComboBox();
        fromyear_combo = new javax.swing.JComboBox();
        timeperiod = new javax.swing.JLabel();
        timeperiod_combo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        casedate_table = new javax.swing.JTable();
        graph = new javax.swing.JPanel();
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
        manualText.setText("<html>\nUse the drop-down fields to select the dates you wish to view, then click on 'View'.\nThe table will fill with all cases created between the two dates you choose.\nA graph will also be generated based on this data, showing all 'Found', 'Lost', and\n'Resolved' baggage between the selected dates.");
        manualText.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        manualText.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        manual_panel.add(manualText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 520));

        add(manual_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 290, 600));

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(153, 0, 0));
        title.setText("Graphic Data");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        casedata_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        casedata_button.setForeground(new java.awt.Color(153, 0, 0));
        casedata_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_long.png"))); // NOI18N
        casedata_button.setText("Case Data");
        casedata_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        casedata_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        casedata_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                casedata_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                casedata_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                casedata_buttonMouseExited(evt);
            }
        });
        add(casedata_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 101, 250, -1));

        graphicdata_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        graphicdata_button.setForeground(new java.awt.Color(153, 0, 0));
        graphicdata_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_rollover_long.png"))); // NOI18N
        graphicdata_button.setText("Graphic Data");
        graphicdata_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        graphicdata_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        graphicdata_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphicdata_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                graphicdata_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                graphicdata_buttonMouseExited(evt);
            }
        });
        add(graphicdata_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 101, 250, -1));

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
        add(view_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        generategraph_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        generategraph_button.setForeground(new java.awt.Color(255, 255, 255));
        generategraph_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/button_short.png"))); // NOI18N
        generategraph_button.setText("Generate Graph");
        generategraph_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generategraph_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generategraph_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generategraph_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                generategraph_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                generategraph_buttonMouseExited(evt);
            }
        });
        add(generategraph_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, -1, -1));

        fromdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fromdate.setForeground(new java.awt.Color(153, 0, 0));
        fromdate.setText("From Date:");
        add(fromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        fromday_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        fromday_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromday_comboActionPerformed(evt);
            }
        });
        add(fromday_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        frommonth_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        add(frommonth_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        fromyear_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        add(fromyear_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        timeperiod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeperiod.setForeground(new java.awt.Color(153, 0, 0));
        timeperiod.setText("Time Period:");
        add(timeperiod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        timeperiod_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Month", "Year" }));
        add(timeperiod_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        casedate_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(casedate_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 260));

        graph.setBackground(new java.awt.Color(255, 255, 255));
        graph.setLayout(new java.awt.BorderLayout());
        add(graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 670, 420));

        background.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        background.setForeground(new java.awt.Color(153, 0, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fys/Images/background.png"))); // NOI18N
        background.setOpaque(true);
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1280, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void casedata_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casedata_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));//Create a rollover effect for the button by changing the background icon.
        casedata_button.setIcon(II);//Sets the new background icon.
    }//GEN-LAST:event_casedata_buttonMouseEntered

    private void casedata_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casedata_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        casedata_button.setIcon(II);
    }//GEN-LAST:event_casedata_buttonMouseExited

    private void graphicdata_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicdata_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        graphicdata_button.setIcon(II);
    }//GEN-LAST:event_graphicdata_buttonMouseEntered

    private void graphicdata_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicdata_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        graphicdata_button.setIcon(II);
    }//GEN-LAST:event_graphicdata_buttonMouseExited

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

    private void view_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseEntered

    private void view_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        view_button.setIcon(II);
    }//GEN-LAST:event_view_buttonMouseExited

    private void graphicdata_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicdata_buttonMouseClicked
        FYS.getInstance().showPage(new GraphicData_Page());
    }//GEN-LAST:event_graphicdata_buttonMouseClicked

    private void casedata_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casedata_buttonMouseClicked
        FYS.getInstance().showPage(new CaseData_Page());
    }//GEN-LAST:event_casedata_buttonMouseClicked

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        FYS.getInstance().showPage(new ManSearch_Page());
    }//GEN-LAST:event_search_buttonMouseClicked

    private void logout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_buttonMouseClicked
        FYS.getInstance().showPage(new ManLogout_Page());
    }//GEN-LAST:event_logout_buttonMouseClicked

    private void view_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_buttonMouseClicked
        boolean fromDateFilled = !fromyear_combo.getSelectedItem().toString().equals("Year") && !frommonth_combo.getSelectedItem().toString().equals("Month") && !fromday_combo.getSelectedItem().toString().equals("Day");

        if (fromDateFilled) {
            int getMonth = Integer.parseInt(frommonth_combo.getSelectedItem().toString());
            int getYear = Integer.parseInt(fromyear_combo.getSelectedItem().toString());
            int calculateMonth = getMonth - 1;
            int calculateYear = getYear - 1;
            String calculatedMonth;

            if (timeperiod_combo.getSelectedItem().equals("Month")) {
                if (calculateMonth < 1) {
                    calculateMonth = 12;
                } else {
                    calculateYear = getYear;
                }
            }

            if (calculateMonth < 10) {
                calculatedMonth = "0" + Integer.toString(calculateMonth);
            } else {
                calculatedMonth = Integer.toString(calculateMonth);
            }

            String calculatedYear = Integer.toString(calculateYear);

            if (timeperiod_combo.getSelectedItem().equals("Day")) {
                fromDate = fromyear_combo.getSelectedItem().toString() + "-" + frommonth_combo.getSelectedItem().toString() + "-" + fromday_combo.getSelectedItem().toString() + " 00:00:00";
                toDate = fromyear_combo.getSelectedItem().toString() + "-" + frommonth_combo.getSelectedItem().toString() + "-" + fromday_combo.getSelectedItem().toString() + " 23:59:59";
            } else if (timeperiod_combo.getSelectedItem().equals("Month")) {
                fromDate = fromyear_combo.getSelectedItem().toString() + "-" + frommonth_combo.getSelectedItem().toString() + "-" + fromday_combo.getSelectedItem().toString() + " 00:00:00";
                toDate = calculatedYear + "-" + calculatedMonth + "-" + fromday_combo.getSelectedItem().toString() + " 00:00:00";
            } else if (timeperiod_combo.getSelectedItem().equals("Year")) {
                fromDate = fromyear_combo.getSelectedItem().toString() + "-" + frommonth_combo.getSelectedItem().toString() + "-" + fromday_combo.getSelectedItem().toString() + " 00:00:00";
                toDate = calculatedYear + "-" + frommonth_combo.getSelectedItem().toString() + "-" + fromday_combo.getSelectedItem().toString() + " 00:00:00";
            }

            FYS.getInstance().updateTable(casedate_table, FYS.getQueryManager().fillTableDate(fromDate, toDate));
            FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "GraphicData_Page", "Viewed Baggage Case graphic data.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a date first.", "Date Not Selected", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_view_buttonMouseClicked

    private void fromday_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromday_comboActionPerformed

    }//GEN-LAST:event_fromday_comboActionPerformed

    private void exitManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitManualMouseClicked
        manual_panel.setVisible(false);
        manual_panel.setEnabled(false);
    }//GEN-LAST:event_exitManualMouseClicked

    private void generategraph_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generategraph_buttonMouseClicked
        final int Resolved = 0;
        final int Found = 1;
        final int Lost = 2;
        String graphname = "Baggage Overview";

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] totalResolved = {1, 3, 2, 5, 4, 7, 6, 9, 12, 11, 1, 13};
        int[] totalFound = {2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
        int[] totalLost = {3, 2, 5, 4, 7, 5, 9, 1, 11, 6, 8, 1};

        Graph baggageGraph = new Graph(graphname);

        baggageGraph.addSeries(totalResolved, "Resolved", months);
        baggageGraph.addSeries(totalFound, "Found", months);
        baggageGraph.addSeries(totalLost, "Lost", months);

        baggageGraph.createChart("Baggage Overview", "Date", "Number of Cases", 600, 400, Color.WHITE, graph);

        baggageGraph.setSeriesThickness(Resolved, 2);
        baggageGraph.setSeriesThickness(Lost, 2);
        baggageGraph.setSeriesThickness(Found, 2);
        baggageGraph.setSeriesColor(Resolved, Color.GREEN);
        baggageGraph.setSeriesColor(Lost, Color.RED);
        baggageGraph.setSeriesColor(Found, Color.BLUE);
        baggageGraph.setGraphBackgroudColors(Color.WHITE, Color.GRAY);

        baggageGraph.setVisible(true);
    }//GEN-LAST:event_generategraph_buttonMouseClicked

    private void generategraph_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generategraph_buttonMouseEntered
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        generategraph_button.setIcon(II);
    }//GEN-LAST:event_generategraph_buttonMouseEntered

    private void generategraph_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generategraph_buttonMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        generategraph_button.setIcon(II);
    }//GEN-LAST:event_generategraph_buttonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel call_manual;
    private javax.swing.JLabel casedata_button;
    private javax.swing.JTable casedate_table;
    private javax.swing.JLabel exitManual;
    private javax.swing.JLabel fromdate;
    private javax.swing.JComboBox fromday_combo;
    private javax.swing.JComboBox frommonth_combo;
    private javax.swing.JComboBox fromyear_combo;
    private javax.swing.JLabel generategraph_button;
    private javax.swing.JPanel graph;
    private javax.swing.JLabel graphicdata_button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logout_button;
    private javax.swing.JLabel manualText;
    private javax.swing.JLabel manualTitle;
    private javax.swing.JPanel manual_panel;
    private javax.swing.JLabel search_button;
    private javax.swing.JLabel timeperiod;
    private javax.swing.JComboBox timeperiod_combo;
    private javax.swing.JLabel title;
    private javax.swing.JLabel view_button;
    private javax.swing.JLabel welcomeuser;
    // End of variables declaration//GEN-END:variables
}
