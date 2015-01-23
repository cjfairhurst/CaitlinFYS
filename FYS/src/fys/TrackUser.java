package fys;

/**
 * This class stores the username of a user, we use it to store the currently logged in user.
 *
 * @author Caitlin Fairhurst (500703510)
 * @author Lars Cornelissen (500683862)
 * @author Floris van Lent (500717249)
 * @version 1.0
 */
public class TrackUser {

    private static String currentUser;

    /**
     * @return the username of the currently logged in user.
     */
    public static String getCurrentUser() {
        return TrackUser.currentUser;
    }

    /**
     * Sets a username as the currently logged in user.
     *
     * @param username
     */
    public static void setCurrentUser(String username) {
        TrackUser.currentUser = username;
    }
}
