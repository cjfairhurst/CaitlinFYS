package fys;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rollovers {
    
    /**
     * Sets the base appearance of menu buttons.
     * @param button 
     */
    public void menuBase (JLabel button) {
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_long.png"));
        button.setIcon(II);
    }
    
    /**
     * Sets the rollover appearance of menu buttons.
     * @param button 
     */
    public void menuRollover (JLabel button) {
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_long.png"));
        button.setIcon(II);
    }
    
    /**
     * Sets the base appearance of non-menu buttons.
     * @param button 
     */
    public void buttonBase (JLabel button) {
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_short.png"));
        button.setIcon(II);
    }
    
    /**
     * Sets the rollover appearance of non-menu buttons.
     * @param button 
     */
    public void buttonRollover (JLabel button) {
        ImageIcon II = new ImageIcon(getClass().getResource("Images/button_rollover_short.png"));
        button.setIcon(II);
    }
    
}
