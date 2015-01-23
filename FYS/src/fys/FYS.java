package fys;

import fys.connectivity.Dbmanager;
import fys.connectivity.QueryManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;

/**
 * This class initializes the database and the query manager and also makes sure all other classes
 * in the 'fys' package have access to basic functionality like updating tables.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class FYS {

    /**
     * The width of the application-frame in pixels.
     */
    public static final int FRAME_WIDTH = 1290;

    /**
     * The height of the application-frame in pixels.
     */
    public static final int FRAME_HEIGHT = 760;

    /**
     * The name to be used by the JFrame constructor.
     */
    public static final String NAME = "FYS Application";

    private JFrame container;
    private static final FYS instance = new FYS();
    private static Dbmanager dbManager;
    private static QueryManager queryManager;

    /**
     * Starts the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        final FYS application = FYS.getInstance();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    application.initialize();
                    application.start();
                } catch (Exception e) {
                    System.out.println("Application FYS failed to launch.");
                    JOptionPane.showMessageDialog(null, "The Application failed to launch.",
                            "Launch Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * Initializes the database and the query manager, making it possible for the application to
     * communicate with the database using the query manager.
     */
    public void initialize() {
        dbManager = new Dbmanager();
        dbManager.openConnection();
        queryManager = new QueryManager(dbManager);
    }

    /**
     * Creates a container frame in which all screens will be contained and sets the default close
     * operation.
     */
    public void start() {
        container = new JFrame(NAME);
        container.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        container.getContentPane();
        showPage(new Login_Page());
        container.setVisible(true);

        container.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {
                shutdown();
            }
        });
    }

    /**
     * Allows access to methods in the query manager.
     *
     * @return queryManager
     */
    public static QueryManager getQueryManager() {
        return getInstance().queryManager;
    }

    /**
     * Allows access to the database.
     *
     * @return dbManager
     */
    public static Dbmanager getDbmanager() {
        return dbManager;
    }

    /**
     * Empties the current screen and calls the shutdown method.
     */
    public void exit() {
        container.setVisible(false);
        shutdown();
    }

    /**
     * Disposes the application screen and shuts down the connection with the database.
     */
    private void shutdown() {
        container.dispose();
        dbManager.closeConnection();
    }

    /**
     * Removes any panel currently shown in the container and replaces it with a new one.
     *
     * @param panel
     */
    public void showPage(JPanel panel) {
        container.getContentPane().removeAll();
        container.getContentPane().add(panel);
        container.getContentPane().validate();
        container.getContentPane().repaint();
    }

    /**
     * Allows access to all methods contained with the FYS class.
     *
     * @return instance
     */
    public static FYS getInstance() {
        return instance;
    }

    /**
     * Updates a table with results from a query.
     *
     * @param table
     * @param rs
     */
    public void updateTable(JTable table, ResultSet rs) {
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
}
