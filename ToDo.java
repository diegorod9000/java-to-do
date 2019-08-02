import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    //private JPanel buttons;
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
        newCheck.setLocation(0, 0);
        addButton.setLocation(100, 0);
        addButton.addActionListener(checker);
        newCheck.setVisible(true);
        checkPanel.add(newCheck);
        checkPanel.add(addButton);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }
        
    //     // for (int x=0;x<deletes.size();x++)
    //     //     if (src==deletes.get(x))
    //     //     {
    //     //         delete(x);
    //     //     }
    // }

    // public void delete (int x)
    // {
    //     frame.remove(boxes.get(x));
    //     frame.remove(deletes.get(x));
    //     deletes.remove(x);
    //     boxes.remove(x);
    //     frame.pack();
    // }

    private void trash(JCheckBox bruh)
    {
        JButton deleter=new JButton("delete");
        deleter.setLocation(bruh.getX()+500, bruh.getY());
        deleter.setSize(1,1);
        checkPanel.add(deleter);
        deletes.add(deleter);
    }

    private void addBox(String input)
    {
        int x =boxes.size();
        boxes.add(new JCheckBox(input));
        boxes.get(x).setActionCommand(input);
        boxes.get(x).addActionListener(checker);
        checkPanel.add(boxes.get(x));
        trash(boxes.get(x));
        frame.remove(checkPanel);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }
    public static void main(String[] args)
    {
        ToDo x=new ToDo();
    }
}