class Image {
    public Image() {}
    public Image(String fileName) {}
}

interface BlurFilter { Image apply(Image img); }
interface EdgeDetectFilter { Image apply(Image img); }
interface SharpenFilter { Image apply(Image img); }

class BlurFilter3x3 implements BlurFilter {
    public Image apply(Image img) {
        System.out.println("Applying 3x3 blur kernel");
        return new Image();
    }
}

class EdgeDetectFilter3x3 implements EdgeDetectFilter {
    public Image apply(Image img) {
        System.out.println("Applying 3x3 edge detection");
        return new Image();
    }
}

class SharpenFilter3x3 implements SharpenFilter {
    public Image apply(Image img) {
        System.out.println("Applying 3x3 sharpen kernel");
        return new Image();
    }
}

interface FilterFactory {
    BlurFilter createBlurFilter();
    EdgeDetectFilter createEdgeDetectFilter();
    SharpenFilter createSharpenFilter();
}

class FilterFactory3x3 implements FilterFactory {
    public BlurFilter createBlurFilter() { return new BlurFilter3x3(); }
    public EdgeDetectFilter createEdgeDetectFilter() { return new EdgeDetectFilter3x3(); }
    public SharpenFilter createSharpenFilter() { return new SharpenFilter3x3(); }
}

class PhotoBooth {
    private BlurFilter blurFilter;
    private EdgeDetectFilter edgeFilter;
    private SharpenFilter sharpenFilter;

    public PhotoBooth(FilterFactory factory) {
        blurFilter = factory.createBlurFilter();
        edgeFilter = factory.createEdgeDetectFilter();
        sharpenFilter = factory.createSharpenFilter();
    }

    public Image blurImage(Image img) { return blurFilter.apply(img); }
    public Image detectEdges(Image img) { return edgeFilter.apply(img); }
    public Image sharpenImage(Image img) { return sharpenFilter.apply(img); }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        FilterFactory3x3 factory = new FilterFactory3x3();
        PhotoBooth booth = new PhotoBooth(factory);
        
        Image myPhoto = new Image("portrait.jpg");
        myPhoto = booth.sharpenImage(myPhoto);
        myPhoto = booth.detectEdges(myPhoto);
        myPhoto = booth.blurImage(myPhoto);
    }
}