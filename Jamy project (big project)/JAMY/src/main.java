import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Font;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;

public class main {


public static void jamy_init(){
     JFrame window = new JFrame("jamy");
        JButton AddButton = new JButton("Add project");
        JButton FindButton = new JButton("find project");
        JButton ShowButton = new JButton("show projects");
        JButton EditButton = new JButton("edit project");
        JButton DeleteButton = new JButton("Delete Project");

        AddButton.addActionListener(e ->{
        ProjectHandler.AddProject();
        });

        FindButton.addActionListener(e ->{
        ProjectHandler.loadProject();
        });

        ShowButton.addActionListener(e->{
            ProjectHandler.showProjects();
        });

        EditButton.addActionListener(e->{
            ProjectHandler.editProject();
        });

        DeleteButton.addActionListener(e->{
            ProjectHandler.DeleteProject();
        });
            JPanel panel = new JPanel();

            panel.add(AddButton);
            panel.add(FindButton);
            panel.add(ShowButton);
            panel.add(EditButton);
            panel.add(DeleteButton);


            window.add(panel);

            JPanel topBar = new JPanel();
            topBar.setPreferredSize(new Dimension(600, 70));
            JLabel title = new JLabel("JAMY");
            title.setFont(new Font("Arial", Font.BOLD, 28));

            topBar.add(title);
            title.setForeground(Color.WHITE);
            title.setFont(new Font("Arial", Font.BOLD, 28));
            topBar.setBackground(new Color(35, 45, 65));



window.add(topBar, BorderLayout.NORTH);
window.add(panel, BorderLayout.CENTER);

            window.setSize(600, 500);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            ImageIcon icon = new ImageIcon("assets\\logo_001.png");
            window.setIconImage(icon.getImage());
}
    




    public static void main(String[] args) throws Exception{
                if (args.length == 0) {
            ProcessBuilder process = new ProcessBuilder(
                "powershell",
                "-Command",
                "Start-Process java -ArgumentList 'main admin' -Verb RunAs"
            );

            process.start();
            return;
    }
    jamy_init();
    }
}