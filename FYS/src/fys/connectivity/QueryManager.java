package fys.connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import fys.FYS;
import fys.TrackUser;
import fys.appmanager.NewAccount_Page;
import fys.manager.CaseData_Page;
import fys.sdworker.NewCase_Page;
import java.sql.Array;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QueryManager {

    private final Dbmanager dbmanager;
    private PreparedStatement prdstmt;
    private ResultSet rs;
    int count;

    public QueryManager(Dbmanager dbmanager) {
        this.dbmanager = dbmanager;
    }

    /**
     * Checks the input against the database to see if logging in is possible.
     *
     * @param username
     * @param password
     * @return true/false Whether the input was found in the database.
     */
    public boolean login(String username, String password) {
        boolean login = false;
        FYS.getDbmanager().openConnection();
        String loginquery = "SELECT * FROM Employee WHERE username=? AND password=?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(loginquery);
            prdstmt.setString(1, username);
            prdstmt.setString(2, password);

            rs = prdstmt.executeQuery();

            if (rs.next()) {
                String employeeFunction = rs.getString("function");
                TrackUser.setCurrentUser(username);
                FYS.getQueryManager().createLog(TrackUser.getCurrentUser(), "Login_Page", "Logged in.");

                switch (employeeFunction) {
                    case "appmanager":
                        FYS.getInstance().showPage(new NewAccount_Page());
                        break;
                    case "manager":
                        FYS.getInstance().showPage(new CaseData_Page());
                        break;
                    default:
                        FYS.getInstance().showPage(new NewCase_Page());
                        break;
                }

                login = true;
            } else {
                JOptionPane.showMessageDialog(null, "The username or password was incorrect. Please try again.", "Login Error", JOptionPane.INFORMATION_MESSAGE);
                login = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured while attempting to log in.", "Login Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
        return login;
    }

    // -------------------------------- LOG QUERIES --------------------------------------
    /**
     * Returns logs from the database based on the chosen search terms.
     *
     * @param searchTerm
     * @param toDate
     * @param searchType
     * @return rs to be processed by the updateTable method
     */
    public ResultSet getLogData(String searchTerm, String toDate, String searchType) {
        FYS.getDbmanager().openConnection();
        String getLog = "";

        switch (searchType) {
            case "username":
                getLog = "SELECT username AS 'Username', page AS 'Page', action AS 'Action', date AS 'Timestamp' FROM log WHERE username = ? ORDER BY date DESC LIMIT 1000";
                break;
            case "date":
                getLog = "SELECT username AS 'Username', page AS 'Page', action AS 'Action', date AS 'Timestamp' FROM log WHERE date BETWEEN ? AND ? ORDER BY date DESC LIMIT 1000";
                break;
        }

        try {
            switch (searchType) {
                case "username":
                    prdstmt = FYS.getDbmanager().getConnection().prepareStatement(getLog);
                    prdstmt.setString(1, searchTerm);
                    break;
                case "date":
                    prdstmt = FYS.getDbmanager().getConnection().prepareStatement(getLog);
                    prdstmt.setString(1, searchTerm);
                    prdstmt.setString(2, toDate);
                    break;
            }

            rs = prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving user log data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }

        return rs;
    }

    /**
     * Returns the most recent 1000 logs from the database.
     *
     * @return rs to be processed by the updateTable method
     */
    public ResultSet getAllLogs() {
        try {
            FYS.getDbmanager().openConnection();
            String getAllLogs = "SELECT username AS 'Username', page AS 'Page', action AS 'Action', date AS 'Timestamp' FROM log ORDER BY date DESC LIMIT 1000";

            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(getAllLogs);
            rs = prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving user log data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }

        return rs;
    }

    /**
     * Creates a log in the database based on the passed arguments.
     *
     * @param username
     * @param page
     * @param action
     */
    public void createLog(String username, String page, String action) {
        FYS.getDbmanager().openConnection();
        String createLog = "INSERT INTO log (username, page, action) VALUES (?, ?, ?)";

        try {

            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(createLog);
            prdstmt.setString(1, username);
            prdstmt.setString(2, page);
            prdstmt.setString(3, action);

            prdstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured logging this action.", "Logging Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // --------------------------------- GRAPH QUERY -------------------------------------
    /**
     * Gets baggage data based on the chosen search terms.
     *
     * @param caseStatus
     * @param startDate
     * @param endDate
     * @return rs to be processed by the updateTable method
     * @throws SQLException
     */
    public int getGraphData(String caseStatus, String startDate, String endDate) throws SQLException {
        try {
            FYS.getDbmanager().openConnection();

            String getGraph = "SELECT COUNT(*) FROM baggage WHERE status = ? AND date BETWEEN ? AND ?";

            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(getGraph);
            prdstmt.setString(1, caseStatus);
            prdstmt.setString(2, startDate);
            prdstmt.setString(3, endDate);

            prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving baggage data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return count = ((Number) rs.getObject(1)).intValue();
    }

    // ---------------------------- SERVICE DESK WORKER/MANAGER QUERIES ------------------------------------------
    /**
     * Saves a new client case into the database.
     *
     * @param typeCase
     * @param firstName
     * @param lastName
     * @param email
     * @param telephoneNumber
     * @param streetAddress
     * @param zipcode
     * @param city
     * @param country
     * @param shippingStreetAddress
     * @param shippingZipcode
     * @param shippingCity
     * @param shippingCountry
     * @param baggageID
     * @param flightNumber
     * @param brand
     * @param color
     * @param description
     * @param caseStatus
     * @throws java.sql.SQLException
     */
    public void saveCase(String typeCase, String firstName, String lastName, String email, String telephoneNumber,
            String streetAddress, String zipcode, String city, String country, String shippingStreetAddress,
            String shippingZipcode, String shippingCity, String shippingCountry, String baggageID, String flightNumber,
            String brand, String color, String description, String caseStatus) throws SQLException {
        FYS.getDbmanager().openConnection();
        String addCase = "";

        switch (typeCase) {
            case "client": {
                addCase = "INSERT INTO client (first_name, last_name, email, telephone_number, street_address, zipcode, city, country, shipping_street_address, shipping_zipcode, shipping_city, shipping_country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                break;
            }
            case "baggage":
                addCase = "INSERT INTO baggage (baggage_id, flight_number, brand, color, description, case_status) VALUES (?, ?, ?, ?, ?, ?)";
                break;
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(addCase);

            switch (typeCase) {
                case "client":
                    prdstmt.setString(1, firstName);
                    prdstmt.setString(2, lastName);
                    prdstmt.setString(3, email);
                    prdstmt.setString(4, telephoneNumber);
                    prdstmt.setString(5, streetAddress);
                    prdstmt.setString(6, zipcode);
                    prdstmt.setString(7, city);
                    prdstmt.setString(8, country);
                    prdstmt.setString(9, shippingStreetAddress);
                    prdstmt.setString(10, shippingZipcode);
                    prdstmt.setString(11, shippingCity);
                    prdstmt.setString(12, shippingCountry);
                    break;

                case "baggage":
                    prdstmt.setString(1, baggageID);
                    prdstmt.setString(2, flightNumber);
                    prdstmt.setString(3, brand);
                    prdstmt.setString(4, color);
                    prdstmt.setString(5, description);
                    prdstmt.setString(6, caseStatus);
                    break;
            }

            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The case was successfully saved.", "Case Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the case was not saved.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
    }

    /**
     * Checks the database if a username already exists.
     *
     * @param username
     * @return true/false
     */
    public boolean checkUniqueUsername(String username) {
        boolean isUnique = true;

        try {
            FYS.getDbmanager().openConnection();
            String checkUsername = "SELECT * FROM employee WHERE username = ?";

            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(checkUsername);
            prdstmt.setString(1, username);

            rs = prdstmt.executeQuery();

            if (rs.next()) {
                isUnique = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured. Please try again.", "Unknown Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return isUnique;
    }

    /**
     * Gets case data from the database.
     *
     * @param typeCase
     * @return rs to be processed by the updateTable method
     */
    public ResultSet fillTableCase(String typeCase) {
        FYS.getDbmanager().openConnection();
        String tabledata = "";

        switch (typeCase) {
            case "client":
                tabledata = "SELECT client_id AS 'Client ID', first_name AS 'First Name', "
                        + "last_name AS 'Last Name', email AS 'Email', telephone_number AS 'Phone Number',"
                        + " street_address AS 'Street Address', zipcode AS 'Zipcode', city AS 'City', country AS 'Country' FROM client";
                break;
            case "baggage":
                tabledata = "SELECT baggage_dbnumber AS 'Database ID', baggage_id AS 'Baggage ID', "
                        + "flight_number AS 'Flight Number', brand AS 'Brand', color AS 'Color', "
                        + "description AS 'Description', owner AS 'Owner', case_status AS 'Case Status' FROM baggage";
                break;
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(tabledata);
            rs = prdstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving case data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Deletes the selected baggage/client case.
     *
     * @param typeCase
     * @param selectedRow
     */
    public void deleteCase(String typeCase, String selectedRow) {
        FYS.getDbmanager().openConnection();
        String deleteaccount = "";

        switch (typeCase) {
            case "client":
                deleteaccount = "DELETE FROM client WHERE client_id = ?";
                break;
            case "baggage":
                deleteaccount = "DELETE FROM baggage WHERE baggage_dbnumber = ?";
                break;
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(deleteaccount);
            prdstmt.setString(1, selectedRow);
            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The case was successfully deleted.", "Case Deleted", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the case was not deleted.", "Deletion Error", JOptionPane.INFORMATION_MESSAGE);
        }
        FYS.getDbmanager().closeConnection();
    }

    /**
     * Selects data from database to be processed by another method and then
     * viewed on the page.
     *
     * @param typeCase
     * @param selectedRow
     * @return rs
     */
    public ResultSet viewCase(String typeCase, String selectedRow) {
        FYS.getDbmanager().openConnection();
        String viewaccount = "";

        switch (typeCase) {
            case "client":
                viewaccount = "SELECT * FROM client WHERE client_id = ?";
                break;
            case "baggage":
                viewaccount = "SELECT * FROM baggage WHERE baggage_dbnumber = ?";
                break;
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(viewaccount);
            prdstmt.setString(1, selectedRow);
            rs = prdstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving case data from the database. The case cannot be viewed.", "View Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Edits a case based on the type of case and the user input.
     *
     * @param typeCase
     * @param firstName
     * @param lastName
     * @param email
     * @param telephoneNumber
     * @param streetAddress
     * @param zipcode
     * @param city
     * @param country
     * @param shippingStreetAddress
     * @param shippingZipcode
     * @param shippingCity
     * @param shippingCountry
     * @param baggageID
     * @param flightNumber
     * @param brand
     * @param color
     * @param description
     * @param caseStatus
     * @param selectedRow
     * @throws SQLException
     */
    public void editCase(String typeCase, String firstName, String lastName, String email, String telephoneNumber, String streetAddress, String zipcode, String city, String country, String shippingStreetAddress, String shippingZipcode, String shippingCity, String shippingCountry, String baggageID, String flightNumber, String brand, String color, String description, String caseStatus, String selectedRow) throws SQLException {
        FYS.getDbmanager().openConnection();
        String editCase = "";

        switch (typeCase) {
            case "client": {
                editCase = "UPDATE client SET first_name = ?, last_name = ?, email = ?, telephone_number = ?, street_address = ?, zipcode = ?, city = ?, country = ?, shipping_street_address = ?, shipping_zipcode = ?, shipping_city = ?, shipping_country = ? WHERE client_id = ?";
                break;
            }
            case "baggage":
                editCase = "UPDATE baggage SET baggage_id = ?, flight_number = ?, brand = ?, color = ?, description = ?, case_status = ? WHERE baggage_dbnumber = ?";
                break;
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(editCase);

            switch (typeCase) {
                case "client":
                    prdstmt.setString(1, firstName);
                    prdstmt.setString(2, lastName);
                    prdstmt.setString(3, email);
                    prdstmt.setString(4, telephoneNumber);
                    prdstmt.setString(5, streetAddress);
                    prdstmt.setString(6, zipcode);
                    prdstmt.setString(7, city);
                    prdstmt.setString(8, country);
                    prdstmt.setString(9, shippingStreetAddress);
                    prdstmt.setString(10, shippingZipcode);
                    prdstmt.setString(11, shippingCity);
                    prdstmt.setString(12, shippingCountry);
                    prdstmt.setString(13, selectedRow);
                    break;

                case "baggage":
                    prdstmt.setString(1, baggageID);
                    prdstmt.setString(2, flightNumber);
                    prdstmt.setString(3, brand);
                    prdstmt.setString(4, color);
                    prdstmt.setString(5, description);
                    prdstmt.setString(6, caseStatus);
                    prdstmt.setString(7, selectedRow);

                    break;
            }

            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The case was successfully updated.", "Case Updated", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the case was not updated.", "Update Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
    }

    /**
     * Gets data from the database based on the search type and term.
     *
     * @param searchType
     * @param searchTerm
     * @return rs to be processed by the updateTable method
     */
    public ResultSet fillTableSearch(String searchType, String searchTerm) {
        FYS.getDbmanager().openConnection();
        String searchresults = "";
        switch (searchType) {
            case "baggage_id": {
                searchresults = "SELECT baggage_dbnumber AS 'Database ID', baggage_id AS 'Baggage ID', "
                        + "flight_number AS 'Flight Number', brand AS 'Brand', color AS 'Color', "
                        + "description AS 'Description', owner AS 'Owner', case_status AS 'Case Status' FROM baggage WHERE baggage_id = ?";
                break;
            }
            case "flight_number": {
                searchresults = "SELECT baggage_dbnumber AS 'Database ID', baggage_id AS 'Baggage ID', "
                        + "flight_number AS 'Flight Number', brand AS 'Brand', color AS 'Color', "
                        + "description AS 'Description', owner AS 'Owner', case_status AS 'Case Status' FROM baggage WHERE flight_number = ?";
                break;
            }
            case "first_name": {
                searchresults = "SELECT client_id AS 'Client ID', first_name AS 'First Name', "
                        + "last_name AS 'Last Name', email AS 'Email', telephone_number AS 'Phone Number',"
                        + " street_address AS 'Street Address', zipcode AS 'Zipcode', city AS 'City', country AS 'Country' FROM client WHERE first_name = ?";
                break;
            }
            case "last_name": {
                searchresults = "SELECT client_id AS 'Client ID', first_name AS 'First Name', "
                        + "last_name AS 'Last Name', email AS 'Email', telephone_number AS 'Phone Number',"
                        + " street_address AS 'Street Address', zipcode AS 'Zipcode', city AS 'City', country AS 'Country' FROM client WHERE last_name = ?";
                break;
            }
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(searchresults);
            prdstmt.setString(1, searchTerm);

            rs = prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving case data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Selects case table based on a selected time period.
     *
     * @param fromDate
     * @param toDate
     * @return rs to be processed by the updateTable method
     */
    public ResultSet fillTableDate(String fromDate, String toDate) {
        FYS.getDbmanager().openConnection();
        String casedate = "SELECT baggage_dbnumber AS 'Database ID', baggage_id AS 'Baggage ID', "
                        + "flight_number AS 'Flight Number', brand AS 'Brand', color AS 'Color', "
                        + "description AS 'Description', owner AS 'Owner', case_status AS 'Case Status' FROM baggage WHERE date BETWEEN ? AND ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(casedate);
            prdstmt.setString(1, toDate);
            prdstmt.setString(2, fromDate);

            rs = prdstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving case data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Connects a client case to a baggage case.
     *
     * @param selectedClientRow
     * @param selectedBaggageRow
     */
    public void connectCase(String selectedClientRow, String selectedBaggageRow) {
        FYS.getDbmanager().openConnection();
        String connectcase = "UPDATE baggage SET owner = ? WHERE baggage_dbnumber = ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(connectcase);
            prdstmt.setString(1, selectedClientRow);
            prdstmt.setString(2, selectedBaggageRow);

            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The cases were successfully connected.", "Connected Cases", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the cases were not connected.", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
    }

    /**
     * Checks if a baggage case is already connected to a client case.
     *
     * @param selectedRow
     * @return true/false
     */
    public boolean checkConnection(String selectedRow) {
        FYS.getDbmanager().openConnection();
        boolean isConnected = false;
        String checkConnection = "SELECT owner FROM baggage WHERE baggage_dbnumber = ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(checkConnection);
            prdstmt.setString(1, selectedRow);

            rs = prdstmt.executeQuery();

            if (rs.next()) {
                isConnected = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured while checking for connections.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }

        return isConnected;
    }

    /**
     * ???
     *
     * @param fromDate
     * @param toDate
     * @param found
     * @param lost
     * @param resolved
     */
    public void graphData(String fromDate, String toDate, Array found, Array lost, Array resolved) {
        FYS.getDbmanager().openConnection();
        String graphData = "SELECT baggage_dbnumber AS 'Database ID', baggage_id AS 'Baggage ID', "
                        + "flight_number AS 'Flight Number', brand AS 'Brand', color AS 'Color', "
                        + "description AS 'Description', owner AS 'Owner', case_status AS 'Case Status' FROM baggage BETWEEN ? AND ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(graphData);
            prdstmt.setString(1, fromDate);
            prdstmt.setString(2, toDate);

            rs = prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving case data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ---------------------- APPLICATION MANAGER QUERIES -------------------------------
    /**
     * Saves the input as a new account in the database.
     *
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param phoneNumber
     * @param employeeFunction
     */
    public void saveAccount(String employeeID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String employeeFunction, String location) {
        FYS.getDbmanager().openConnection();
        String addAccount = "INSERT INTO employee (employee_id, first_name, last_name, email, telephone_number, username, password, function, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(addAccount);
            prdstmt.setString(1, employeeID);
            prdstmt.setString(2, firstName);
            prdstmt.setString(3, lastName);
            prdstmt.setString(4, email);
            prdstmt.setString(5, phoneNumber);
            prdstmt.setString(6, username);
            prdstmt.setString(7, password);
            prdstmt.setString(8, employeeFunction);
            prdstmt.setString(9, location);

            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The account was successfully saved.", "Account Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the case was not saved.", "Save Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
    }

    /**
     * Gets employee data from the database.
     *
     * @return rs to be processed by the updateTable method
     */
    public ResultSet fillTableMA() {
        FYS.getDbmanager().openConnection();
        String tabledata = "SELECT employee_id AS 'Employee ID', first_name AS 'First Name', last_name AS 'Last Name', username AS 'Username', function AS 'Function', location AS 'Location' FROM employee";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(tabledata);
            rs = prdstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving account data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Gets results from the database based on the chosen search terms.
     *
     * @param searchType
     * @param searchTerm
     * @return rs to be processed by the updateTable method
     */
    public ResultSet fillTableMAS(String searchType, String searchTerm) {
        FYS.getDbmanager().openConnection();
        String searchresults = "";
        switch (searchType) {
            case "employee_id": {
                searchresults = "SELECT employee_id AS 'Employee ID', first_name AS 'First Name', last_name AS 'Last Name', username AS 'Username', function AS 'Function', location AS 'Location' FROM employee WHERE employee_id = ?";
                break;
            }
            case "username": {
                searchresults = "SELECT employee_id AS 'Employee ID', first_name AS 'First Name', last_name AS 'Last Name', username AS 'Username', function AS 'Function', location AS 'Location' FROM employee WHERE username = ?";
                break;
            }
            case "first_name": {
                searchresults = "SELECT employee_id AS 'Employee ID', first_name AS 'First Name', last_name AS 'Last Name', username AS 'Username', function AS 'Function', location AS 'Location' FROM employee WHERE first_name = ?";
                break;
            }
            case "last_name": {
                searchresults = "SELECT employee_id AS 'Employee ID', first_name AS 'First Name', last_name AS 'Last Name', username AS 'Username', function AS 'Function', location AS 'Location' FROM employee WHERE last_name = ?";
                break;
            }
        }

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(searchresults);
            prdstmt.setString(1, searchTerm);

            rs = prdstmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured retrieving account data from the database.", "Database Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Deletes an account based on the selected row in a table.
     *
     * @param selectedRow
     */
    public void deleteAccountMA(String selectedRow) {
        FYS.getDbmanager().openConnection();
        String deleteaccount = "DELETE FROM employee WHERE employee_id = ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(deleteaccount);
            prdstmt.setString(1, selectedRow);
            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The account was successfully deleted.", "Account Deleted", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the account was not deleted.", "Deletion Error", JOptionPane.INFORMATION_MESSAGE);
        }
        FYS.getDbmanager().closeConnection();
    }

    /**
     * Gets data from a selected row to be processed by another method and
     * viewed in the page.
     *
     * @param selectedRow
     * @return
     */
    public ResultSet viewAccount(String selectedRow) {
        FYS.getDbmanager().openConnection();
        String viewaccount = "SELECT * FROM employee WHERE employee_id = ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(viewaccount);
            prdstmt.setString(1, selectedRow);
            rs = prdstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the account cannot be viewed.", "View Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return rs;
    }

    /**
     * Updates an existing account with new input.
     *
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param email
     * @param phoneNumber
     * @param employeeFunction
     * @param location
     * @param selectedRow
     */
    public void editAccount(String employeeID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String employeeFunction, String location, String selectedRow) {
        FYS.getDbmanager().openConnection();
        String updateAccount = "UPDATE employee SET employee_id = ?, first_name = ?, last_name = ?, username = ?, password = ?, email = ?, telephone_number = ?, function = ?, location = ? WHERE employee_id = ?";

        try {
            prdstmt = FYS.getDbmanager().getConnection().prepareStatement(updateAccount);
            prdstmt.setString(1, employeeID);
            prdstmt.setString(2, firstName);
            prdstmt.setString(3, lastName);
            prdstmt.setString(4, username);
            prdstmt.setString(5, password);
            prdstmt.setString(6, email);
            prdstmt.setString(7, phoneNumber);
            prdstmt.setString(8, employeeFunction);
            prdstmt.setString(9, location);
            prdstmt.setString(10, selectedRow);

            prdstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The account was successfully updated.", "Updated Account", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occured and the account was not updated.", "Update Error", JOptionPane.INFORMATION_MESSAGE);
        }

        FYS.getDbmanager().closeConnection();
    }
}
