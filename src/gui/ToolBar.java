package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ToolBar extends JPanel implements ActionListener {
	
	private JButton addButton;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton printButton;
    private StringListener textgetter;
    
    public ToolBar(){
    
       setBorder(BorderFactory.createEtchedBorder());
        addButton = new JButton("Add");
        saveButton = new JButton("Save");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        printButton = new JButton("Print");
        
        addButton.addActionListener(this);
        saveButton.addActionListener(this);
        editButton.addActionListener(this);
        printButton.addActionListener(this);
        deleteButton.addActionListener(this);
        
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        add(addButton);
        add(saveButton);
        add(editButton);
        add(deleteButton);
        add(printButton);
        
    }

    public void stringSetter(StringListener textgetter){
    
        this.textgetter = textgetter;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        JButton clicked = (JButton)e.getSource();
        
        if(clicked == addButton){
        
            System.out.println("ADD Button is clicked");
        }
        
        else if(clicked == saveButton){
        
            System.out.println("Save Button is clicked");
        }
        
        else if(clicked == editButton){
        
            System.out.println("Edit Button is clicked");
        }
        
        else if(clicked == deleteButton){
            
            System.out.println("Delete Button is clicked");
        }
        else if(clicked == printButton){
            
            System.out.println("Print Button is clicked");
        }
    }

}
