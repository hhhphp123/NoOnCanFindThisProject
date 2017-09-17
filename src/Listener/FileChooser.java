package Listener;

/**
 * Created by hasee on 2017/9/16.
 */
import javax.swing.*;
import java.io.File;

@SuppressWarnings("serial")
public class FileChooser extends JFrame{
    public FileChooser(){
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if(file.isDirectory()){
            System.out.println("文件夹:"+file.getAbsolutePath());
        }else if(file.isFile()){
            System.out.println("文件:"+file.getAbsolutePath());
        }
        System.out.println(jfc.getSelectedFile().getName());

    }




}
