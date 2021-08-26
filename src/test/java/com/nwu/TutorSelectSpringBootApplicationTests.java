package com.nwu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

@SpringBootTest
class TutorSelectSpringBootApplicationTests {


    @Test
    void contextLoads() {

        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();

        String desktopPath = desktopDir.getAbsolutePath();

        System.out.println(desktopPath);

    }

}
