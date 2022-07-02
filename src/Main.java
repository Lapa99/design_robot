import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws AWTException {
        int layerX = 1395;
        int layerY = 491;
        int overlayOptionsX = 1120;
        int overlayOptionsY = 195;
        int strokeX= 209;
        int strokeY= 490;
        int folderWithFinishedItemX = 209;
        int folderWithFinishedItemY = 405;
        int saveX = 1073;
        int saveY = 960;
        int sourceFolderX = 213;
        int sourceFolderY = 251;
        int searchStringX = 445;
        int searchStringY = 811;
        int value = 45; // количество элементов

        Robot robot = new Robot();
        robot.setAutoDelay(500);
        for (int i = 1; i < value; i++) {
            if (i < 9) {
                openElement(sourceFolderX, sourceFolderY, searchStringX, searchStringY, robot);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_O);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_O);
                robot.keyPress(0x60 + i);
                robot.keyRelease(0x60 + i);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                robot.mouseMove(layerX, layerY);
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

                click(overlayOptionsX, overlayOptionsY, strokeX, strokeY, robot);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_S);

                click(folderWithFinishedItemX, folderWithFinishedItemY, saveX, saveY, robot);

                System.out.println("Item " + i + " saved successfully");
                System.out.println("Proceeding to the next element, boss");
            } else {
                for (int j = 1; j < 5; j++) {
                    for (int k = 0; k < 9; k++) {
                        openElement(sourceFolderX, sourceFolderY, searchStringX, searchStringY, robot);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_O);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyRelease(KeyEvent.VK_O);
                        robot.keyPress(0x60 + j);
                        robot.keyRelease(0x60 + j);
                        robot.keyPress(0x60 + k);
                        robot.keyRelease(0x60 + k);

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);

                        robot.mouseMove(layerX, layerY);
                        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

                        click(overlayOptionsX, overlayOptionsY, strokeX, strokeY, robot);

                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_S);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        robot.keyRelease(KeyEvent.VK_S);

                        click(folderWithFinishedItemX, folderWithFinishedItemY, saveX, saveY, robot);

                        System.out.println("Item " + j + k +" saved successfully");
                        System.out.println("Proceeding to the next element, boss");
                    }
                }
            }
        }
    }

    private static void openElement(int sourceFolderX, int sourceFolderY, int searchStringX, int searchStringY, Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_O);
        robot.mouseMove(sourceFolderX, sourceFolderY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(searchStringX, searchStringY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private static void click(int folderWithFinishedItemX, int folderWithFinishedItemY, int saveX, int saveY, Robot robot) {
        robot.mouseMove(folderWithFinishedItemX, folderWithFinishedItemY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(saveX, saveY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
