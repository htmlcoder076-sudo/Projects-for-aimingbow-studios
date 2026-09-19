// im too lazy to ick out the imports so i just copied it :) maye its useful later
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
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;



public class ProjectHandler{
    // this is the save method
    public static void Save(String name, String deadline, Status status){
		try(FileWriter file = new FileWriter("data\\" + name + ".txt")){
			file.write(name + "|" + deadline + "|" + status );
		}
		catch(IOException e){
			System.out.print("there was a problem writing to the file. the error: {" + e + "}");
		}

	}
    





    // this is the load method
	public static void loadProject() {

        String name = JOptionPane.showInputDialog(null, "Project name:");

        try {
            BufferedReader reader =
                new BufferedReader(new FileReader("data\\" + name + ".txt"));

            String info = reader.readLine();
            String[] data = info.split("\\|");
            reader.close();
        
            JFrame wind = new JFrame("project details");
            JLabel nameLabel = new JLabel("name: " + data[0]);
            nameLabel.setBounds(25, 30, 300, 40);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));

            JLabel deadlineLabel = new JLabel("deadline: " + data[1]);
            deadlineLabel.setBounds(25, 100, 300, 40);
            deadlineLabel.setFont(new Font("Arial", Font.PLAIN, 24));

            JLabel statusLabel = new JLabel("status: " + data[2]);
            statusLabel.setBounds(25, 170, 300, 40);
            statusLabel.setFont(new Font("Arial", Font.PLAIN, 24));


            wind.setSize(350, 425);
            wind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            wind.setVisible(true);
            wind.setLayout(null);
            wind.add(nameLabel);
            wind.add(deadlineLabel);
            wind.add(statusLabel);


        } catch (IOException e) {
            System.out.println("Project not found.");
        }
    }





    // this is the edit method
    public static void editProject(){
String name = JOptionPane.showInputDialog(null, "Project name:");

String[] data = null;

try {
    BufferedReader reader = new BufferedReader(
        new FileReader("data\\" + name + ".txt")
    );

    String info = reader.readLine();
    data = info.split("\\|");

    reader.close();

} catch (IOException e) {
    JOptionPane.showMessageDialog(
        null,
        "Error has occurred. The error: {" + e + "}"
    );
    return;
}

target targetMsg = (target) JOptionPane.showInputDialog(
    null,
    "What is the target to change?",
    "Project target to change",
    JOptionPane.QUESTION_MESSAGE,
    null,
    target.values(),
    target.values()[0]
);

String newProperty;

if (targetMsg == target.status) {
    Status newStatus = (Status) JOptionPane.showInputDialog(
        null,
        "What is the status?",
        "Project Status",
        JOptionPane.QUESTION_MESSAGE,
        null,
        Status.values(),
        Status.QUEUED
    );

    newProperty = newStatus.toString();

} else {
    newProperty = JOptionPane.showInputDialog(
        null,
        "What is the new " + targetMsg + "?"
    );
}
try(FileWriter change = new FileWriter("data\\" + name + ".txt")){
    if (targetMsg == target.name) {
    change.write(newProperty + "|" + data[1] + "|" + data[2]);
}

if (targetMsg == target.deadline) {
    change.write(data[0] + "|" + newProperty + "|" + data[2]);
}

if (targetMsg == target.status) {
    change.write(data[0] + "|" + data[1] + "|" + newProperty);
}


}
catch(IOException e){
    JOptionPane.showMessageDialog(null, "an error happened. it is: {" + e + "} | please enter something in the new property prompt.");
}


    }







    // this is the show project method
        public static void showProjects(){
    File folder = new File("data");
    File[] files = folder.listFiles();

    String html = "<html><ul>";

    for (File file : files){
        String name = file.getName();
        html += "<li>" + name + "</li>";
    }

    html += "</ul></html>";

    JFrame window = new JFrame("projects");

    JLabel list = new JLabel(html);
        list.setBounds(20, 20, 450, 350);
    window.add(list);
            list.setFont(new Font("Arial", Font.PLAIN, 24));

    window.setLayout(null);

    window.setSize(500, 400);
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    window.setVisible(true);
    window.setLayout(new BorderLayout());

}




        

        // add project emthod.
        public static void AddProject(){
        String name = JOptionPane.showInputDialog(null, "type in the name of project: ");
        String deadline = JOptionPane.showInputDialog(null, "type in the deadline of project: ");
        Status status = (Status) JOptionPane.showInputDialog(
            null,
            "What is the status?",
            "Project Status",
            JOptionPane.QUESTION_MESSAGE,
            null,
            Status.values(),
            Status.QUEUED
        );
        Project project = new Project(name, deadline, status);

        JOptionPane.showMessageDialog(null,project.getInfo());
        FileHandler.Save(project.name, project.deadline, project.status);
        project.projects.add(project);
    }



    public static void DeleteProject(){
        String name = JOptionPane.showInputDialog(null, "Project name:");
        File file = new File("data\\" + name + ".txt");



        boolean Deleted = file.delete();
        if (Deleted){
            JOptionPane.showMessageDialog(null,"deletion succesful.");
        }
        else if (!Deleted){
            JOptionPane.showMessageDialog(null, "something went wrong.");
JOptionPane.showMessageDialog(
    null,
    "Exists: " + file.exists() +
    "\nPath: " + file.getAbsolutePath() +
    "\nIs file: " + file.isFile() +
    "\nParent exists: " + file.getParentFile().exists()
);
        }
    }
}