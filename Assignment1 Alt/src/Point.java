
public class Point {

    int x;
    int y;

    public Point(int xinput, int yinput) throws InvalidParameterException {

        setX(xinput);
        setY(yinput);

    }

    public void setX(int xinput) throws InvalidParameterException {

        if (xinput < 0) {
            throw new InvalidParameterException();
        }
        else {
            x = xinput;
        }

    }

    public int getX(){
        return x;
    }
    
    public void setY(int yinput) throws InvalidParameterException {

        if (yinput < 0) {
            throw new InvalidParameterException();
        }
        else {
            y = yinput;
        }
    }
    
    public int getY(){
        return y;
    }
    public String toString() {
        String result = "(" + x + "," + y + ")";
        return result;
    }

}
