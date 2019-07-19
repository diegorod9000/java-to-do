import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
class ToDo
{
    private JFrame frame;
    //private JPanel buttons;
    private JPanel checkPanel;
    private ArrayList <JCheckBox> boxes;
    private ArrayList <JButton> deletes;
    private ItemListener checker;
    public ToDo()
    {
        // Create the Window
        frame=new JFrame("ToDo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,50,50);
        frame.setVisible(true);
        checkPanel=new JPanel(new GridLayout(0, 1));
        boxes=new ArrayList<JCheckBox>();
        deletes=new ArrayList<JButton>();
        checker=new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
            }
        };
    }

    public void trash(JCheckBox bruh)
    {
        JButton deleter=new JButton("delete");
        deleter.setLocation(bruh.getX()+500, bruh.getY());
        deleter.setSize(1,1);
        checkPanel.add(deleter);
        //frame.remove(buttons);
        //frame.add(buttons, BorderLayout.LINE_END);
        deletes.add(deleter);
    }

    public void addBox(String input)
    {
        int x =boxes.size();
        boxes.add(new JCheckBox(input));
        boxes.get(x).setActionCommand(input);
        boxes.get(x).addItemListener(checker);
        checkPanel.add(boxes.get(x));
        trash(boxes.get(x));
        frame.remove(checkPanel);
        frame.add(checkPanel, BorderLayout.LINE_START);
        frame.pack();
    }
    public static void main(String[] args)
    {
        ToDo x=new ToDo();
        x.addBox("YEET");
        x.addBox("dsfasd");
        x.addBox("YEdsfsd");
        x.addBox("dsfasdfsd");
        x.addBox("tjrryjudtf");
    }
}