package Listener;

/**
 * Created by hasee on 2017/9/16.
 */

import javax.swing.*;
import java.io.File;


@SuppressWarnings("serial")
public class FileSave extends JFrame{

    public FileSave()  {


        String fileName = null;
        JFileChooser jfc=new JFileChooser();
        int select = jfc.showSaveDialog(this);
        File file = null;
        if(select == jfc.APPROVE_OPTION){
            file =jfc.getSelectedFile();   //如果这里并没有选取中任何的文件，下面的fileChooser.getName(file)将会返回手输入的文件名
        }
        fileName = jfc.getName(file);
        if(fileName==null|| fileName.trim().length()==0){
           JOptionPane.showMessageDialog(jfc, "文件名为空！");
        }

        if(file.isFile()){
            fileName = file.getName();
        }
        //否则是个文件夹
        file = jfc.getCurrentDirectory();//获得当前目录

        String path = file.getPath()+java.io.File.separator+fileName;
        file =new File(path);

        if(file.exists()) {  //若选择已有文件----询问是否要覆盖
            int i = JOptionPane.showConfirmDialog(this, "该文件已经存在，确定要覆盖吗？");
            if(i == JOptionPane.YES_OPTION)   ;
            else return ;
        }

//        try {
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//            bw.write(contentArea.getText());
//            bw.flush();
//        } catch (FileNotFoundException e1) {
//            JOptionPane.showMessageDialog(MyMenuEditor.this, "文件保存出错"+e1.getMessage());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }finally{
//            try {
//                if(bw!=null) bw.close();
//            } catch (IOException e1) {
//            }
//        }

//        if(file.isDirectory()){
//            System.out.println("文件夹:"+file.getAbsolutePath());
//        }else if(file.isFile()){
//            System.out.println("文件:"+file.getAbsolutePath());
//        }
//        System.out.println(jfc.getSelectedFile().getName());


    }




}
