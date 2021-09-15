package game.model;

import javafx.scene.image.Image;
import game.utils.ImageUtil;

public class AssistantNode extends Node {
    // Retrieve the image 
    public static int HEIGHT = 40;
    public static int WIDTH = 40;
    private static String IMG_PATH = "image/IMG_9928.png";

    public static AssistantNode createNode(int x,int y){
        return new AssistantNode(x,y, ImageUtil.getImage(IMG_PATH));
    }

    public AssistantNode(int x, int y, Image image) {
        super(x, y, image);
    }

    public AssistantNode(int x, int y) {
        super(x, y);
    }
}
