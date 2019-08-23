import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
class ToDo
{
    private JFrame frame;
    private JPanel checkPanel;
    private ArrayList <JCheckBox> boxes;
    private ArrayList <JButton> deletes;
    private JButton addButton;
    private JTextField newCheck;
    private ActionListener checker;
    public ToDo()
    {
        // Create the Window
        checker=new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object src= e.getSource();
        
                if(src==addButton)
                    if (!newCheck.getText().equals(""))
                        addBox(newCheck.getText());
                for (int x=0; x<deletes.size();x++)
                    if(deletes.get(x)==src)
                        delete(x);
            }
        };
        frame=new JFrame("ToDo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,50,50);
        frame.setVisible(true);
        checkPanel=new JPanel(new GridLayout(0, 2));
        boxes=new ArrayList<JCheckBox>();
        deletes=new ArrayList<JButton>();
        
        addButton=new JButton("add");
        newCheck=new JTextField();
        addButton.addActionListener(checker);
        addButton.setLocation(100, 0);
        newCheck.setLocation(0, 0);
        newCheck.setVisible(true);
        checkPanel.add(newCheck);
        checkPanel.add(addButton);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }

    public void delete (int x)
    {
        checkPanel.remove(deletes.get(x));
        checkPanel.remove(boxes.get(x));
        boxes.remove(x);
        deletes.remove(x);
        frame.remove(checkPanel);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }

    private void addDeleteButton(JCheckBox checkbox)
    {
        JButton deleter=new JButton("delete");
        deleter.setLocation(checkbox.getX()+500, checkbox.getY());
        deleter.setSize(1,1);
        deleter.addActionListener(checker);
        checkPanel.add(deleter);
        deletes.add(deleter);
    }

    private void addBox(String input)
    {
        int x =boxes.size();
        boxes.add(new JCheckBox(input));
        boxes.get(x).setActionCommand(input);
        checkPanel.add(boxes.get(x));
        addDeleteButton(boxes.get(x));
        frame.remove(checkPanel);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }
    public static void main(String[] args)
    {
        ToDo x=new ToDo();
    }
}