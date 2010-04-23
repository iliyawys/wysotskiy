/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base_form;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author insane
 */
public class Form extends JDialog {

    private JPanel contentPanel;
    private TrayIcon trayIcon;
    private SystemTray systemTray = SystemTray.getSystemTray();

    Form() throws IOException, AWTException {
        setTitle("title name");

        getContentPane().setLayout(new BorderLayout());
        seeIcon();
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) d.getWidth() - 500, (int) d.getHeight() - 450);
    }

    private void initComponents() {
        contentPanel = new JPanel();


        //getContentPane().add(contentPanel);
    }

    private void seeIcon() throws IOException, AWTException {
//popup for icon
        PopupMenu popupMenu = new PopupMenu();
        //PopupMenu popupNewMenu = new PopupMenu();
        MenuItem popupExit = new MenuItem("Exit");
        //popupMenu.add(popupExit);
        popupMenu.add(popupExit);
        //Icon
        trayIcon = new TrayIcon(ImageIO.read(getClass().getResource("ico.gif")), "fuck..");
        trayIcon.setImageAutoSize(true);
        trayIcon.setPopupMenu(popupMenu);
        systemTray.add(trayIcon);
        //Icon view listers
        trayIcon.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(true);
            }
        });
        trayIcon.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!isVisible()) {
                    setVisible(true);
                }
            }
        });
        //Listers Icon popup
        popupExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) throws IOException, AWTException {
        Form vf = new Form();
        vf.setVisible(true);
    }
}
