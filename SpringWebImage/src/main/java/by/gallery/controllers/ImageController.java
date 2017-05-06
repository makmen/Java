package by.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMakas on 03.03.2017.
 */
@Controller
public class ImageController {

    private String pathRoot = "D:\\need\\buffer\\train_Java\\SpringWebImage\\web\\resources\\images\\tmp";
    private int NumImageRow = 3;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showImage(Model model) {
        ModelAndView modelAndView = new ModelAndView("image/layout");
        List<String> listImages = new ArrayList<String>();
        List<String[]> listArray = new ArrayList<String[]>();

        File root = new File(pathRoot);
        if(root.exists() && root.isDirectory()) {
            for(File item : root.listFiles()){
                if(item.isFile()){
                    listImages.add( item.getName() );
                }
            }
        }

        String[] row = new String[NumImageRow];
        int i = 0, numImageFilled = listImages.size();
        do {
            for (int j = 0, length = (numImageFilled > NumImageRow) ? NumImageRow : numImageFilled; j < length; j++) {
                row[j] = "/resources/images/tmp/" + listImages.get(i++);
            }
            listArray.add( row );
            numImageFilled -= NumImageRow;
            row = new String[NumImageRow];
        } while (numImageFilled > 0);

        model.addAttribute("listImages", listImages);
        model.addAttribute("listArray", listArray);
        model.addAttribute("template", "showimage.jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView addImage(Model model) {
        ModelAndView modelAndView = new ModelAndView("image/layout");
        model.addAttribute("template", "uploadimage.jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView addImage(@RequestParam("file") MultipartFile file,
                                 Model model) {
        System.out.println("file = [" + file + "]");
        if (!file.isEmpty()) {
            try {
                /*byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(
                        new File(name + "-uploaded")
                    )
                );
                stream.write(bytes);
                stream.close();
                model.addAttribute("success", "Вы удачно загрузили " + name + " в " + name + "-uploaded !");*/
            } catch (Exception e) {
                //model.addAttribute("error", "Вам не удалось загрузить " + name + " => " + e.getMessage());
            }
        } else {
           // model.addAttribute("error", "Вам не удалось загрузить " + name + " потому что файл пустой." );
        }

        ModelAndView modelAndView = new ModelAndView("image/layout");
        model.addAttribute("template", "uploadimage.jsp");

        return modelAndView;
    }




}
