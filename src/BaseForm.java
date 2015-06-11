import java.awt.*;
import java.awt.event.*;

public class BaseForm {
    
    protected MainForm parent;
    protected Frame mainFrame;
    
    public BaseForm( MainForm _parent, String _titolo ) {
        parent = _parent;        
        mainFrame = new Frame(_titolo);
        
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               mainFrame.dispose();
            }        
         });
    }
    
    public void Show() {
        mainFrame.setVisible(true);
    }
}
