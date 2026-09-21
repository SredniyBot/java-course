package edu.course.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.Test;

class CourseMenuTest {
  @Test
  void filteringAndRenderingUseTheSameCatalog() throws Exception {
    SwingUtilities.invokeAndWait(
        () -> {
          CourseMenu menu = new CourseMenu(Launcher.games(), entry -> {});
          assertEquals(25, menu.visibleGames());
          menu.setQuery("UTF-8");
          assertEquals(1, menu.visibleGames());
          menu.setQuery("star-courier");
          assertEquals(1, menu.visibleGames());
          menu.setQuery("нет такой игры");
          assertEquals(0, menu.visibleGames());
          menu.setQuery("");
          assertEquals(25, menu.visibleGames());
          menu.setSize(1100, 820);
          menu.doLayout();
          BufferedImage image = new BufferedImage(1100, 820, BufferedImage.TYPE_INT_RGB);
          var g = image.createGraphics();
          try {
            menu.paint(g);
          } finally {
            g.dispose();
          }
        });
  }
}
