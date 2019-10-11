package algorithms.dynamic_programming.PaintFill;



public class PaintFill {

    public boolean paintFill(PixelColor[][] screen, int r, int c, PixelColor ocolor) {
        if (screen[r][c] == ocolor) {
            return false;
        }
        return paintFill(screen, r, c, screen[r][c], ocolor);
    }

    private boolean paintFill(PixelColor[][] screen, int r, int c, PixelColor ocolor, PixelColor ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }
        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            paintFill(screen, r-1,c,ocolor,ncolor);
            paintFill(screen, r+1,c,ocolor,ncolor);
            paintFill(screen, r,c-1,ocolor,ncolor);
            paintFill(screen, r,c+1,ocolor,ncolor);

        }
        return true;
    }

    public PixelColor[][] getTestScreen() {
        return new PixelColor[][] {
                {PixelColor.Black, PixelColor.Black, PixelColor.Black, PixelColor.Black, PixelColor.Black},
                {PixelColor.Black, PixelColor.White, PixelColor.White, PixelColor.White, PixelColor.Black},
                {PixelColor.Black, PixelColor.White, PixelColor.White, PixelColor.White, PixelColor.Black},
                {PixelColor.Black, PixelColor.White, PixelColor.White, PixelColor.White, PixelColor.Black},
                {PixelColor.Black, PixelColor.White, PixelColor.White, PixelColor.White, PixelColor.Black},
                {PixelColor.Black, PixelColor.Black, PixelColor.Black, PixelColor.Black, PixelColor.Black}
        };
    }

    public String screenToString(PixelColor[][] screen) {
        StringBuilder sb = new StringBuilder();
        for (PixelColor[] rc : screen) {
            for (PixelColor cc : rc) {
                sb.append(colorToString(cc));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String colorToString(PixelColor color) {
        switch (color) {
            case Black:
                return "Black";
            case White:
                return "White";
            case Red:
                return "Red";
            case Green:
                return "Green";
            case Blue:
                return "Blue";
        }
        return "INVALID_COLOR";
    }
}