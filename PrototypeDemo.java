abstract class ImageBuffer implements Cloneable {
    public ImageBuffer clone() throws CloneNotSupportedException {
        return (ImageBuffer) super.clone();
    }
    protected void printMessage(String m) { System.out.println(m); }
}

class GrayscaleImage extends ImageBuffer {
    @Override
    public ImageBuffer clone() throws CloneNotSupportedException {
        printMessage("Duplicating grayscale image buffer...");
        return (GrayscaleImage) super.clone();
    }
}

class ColorImage extends ImageBuffer {
    @Override
    public ImageBuffer clone() throws CloneNotSupportedException {
        printMessage("Duplicating color image buffer...");
        return (ColorImage) super.clone();
    }
}

class BufferFactory {
    private GrayscaleImage bwTemplate = new GrayscaleImage();
    private ColorImage rgbTemplate = new ColorImage();

    public ImageBuffer generateBuffer(String type) throws CloneNotSupportedException {
        if ("bw".equalsIgnoreCase(type)) {
            return bwTemplate.clone();
        } else if ("color".equalsIgnoreCase(type)) {
            return rgbTemplate.clone();
        }
        return null;
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        BufferFactory factory = new BufferFactory();
        ImageBuffer[] roverCameras = new ImageBuffer[4];

        try {
            roverCameras[0] = factory.generateBuffer("bw");
            roverCameras[1] = factory.generateBuffer("color");
            roverCameras[2] = factory.generateBuffer("bw");
            roverCameras[3] = factory.generateBuffer("color");
        } catch (CloneNotSupportedException ex) {
            System.out.println("Cloning failed!");
        }
    }
}