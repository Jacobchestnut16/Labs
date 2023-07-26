public class RobotUtil {
    //Constructors
    public RobotUtil(){

    }
    public RobotUtil(String map){
        Robot.load(map);
        mapSet = true;
    }
    public RobotUtil(String map, int delay){
        Robot.load(map);
        mapSet = true;
        Robot.setDelay(delay);
    }
    public RobotUtil(String map, Delay delay){
        Robot.load(map);
        mapSet = true;
        Robot.setDelay(delay.getSpeed());
    }
    //variables inside the class are private so that only the class can access them
    private boolean mapSet = false;
    public void SetMap(String map){
        Robot.load(map);
        mapSet = true;
    }

    public void setDelay(int delay){
        if (mapSet){
            Robot.setDelay(delay);
        }
    }
    public void setDelay(Delay delay){
        Robot.setDelay(delay.getSpeed());
    }





    public boolean moveForward(){
        boolean check = isForwardClear();
        if (check)
            Robot.move();
        else
            System.err.println("Error: Met a wall");

        return check;

    }
    public boolean moveBackward(){
        boolean check = isBackwardClear();
        Robot.turnLeft();
        Robot.turnLeft();
        if (check)
            Robot.move();
        else
            System.err.println("Error: Met a wall");

        Robot.turnLeft();
        Robot.turnLeft();
        return check;

    }
    public boolean moveLeft(){
        boolean check = isLeftClear();
        Robot.turnLeft();
        if (check)
            Robot.move();
        else
            System.err.println("Error: Met a wall");

        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
        return check;

    }
    public boolean moveRight(){
        boolean check = isRightClear();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
        if (check)
            Robot.move();
        else
            System.err.println("Error: Met a wall");

        Robot.turnLeft();
        return check;
    }


    public boolean isForwardClear(){
        return Robot.frontIsClear();
    }
    public boolean isBackwardClear(){
        Robot.turnLeft();
        Robot.turnLeft();
        boolean clear = Robot.frontIsClear();
        Robot.turnLeft();
        Robot.turnLeft();
        return clear;
    }
    public boolean isLeftClear(){
        Robot.turnLeft();
        boolean clear = Robot.frontIsClear();
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
        return clear;
    }
    public boolean isRightClear(){
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
        boolean clear = Robot.frontIsClear();
        Robot.turnLeft();
        return clear;
    }

    public void moveEndForward(){
        while (isForwardClear()){
            moveForward();
        }
    }

    public void moveEndBackward(){
        while (isBackwardClear()){
            moveBackward();
        }
    }
    public void moveEndRight(){
        while (isRightClear()){
            moveRight();
        }
    }
    public void moveEndLeft(){
        while (isLeftClear()){
            moveLeft();
        }
    }

    public void moveForward(int l){
        for (int i = 0; i < l; i++) {
            moveForward();
        }
    }

    public void moveBackward(int l){
        for (int i = 0; i < l; i++) {
            moveBackward();
        }
    }

    public void moveLeft(int l){
        for (int i = 0; i < l; i++) {
            moveLeft();
        }
    }

    public void moveRight(int l){
        for (int i = 0; i < l; i++) {
            moveRight();
        }
    }

    public void turnRight(){
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public void turnLeft(){
        Robot.turnLeft();
    }

    public void turnAround(){
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public boolean onDark(){
        return Robot.onDark();
    }

    public boolean onLight(){
        return !Robot.onDark();
    }

    public void makeDark(){
        if (onLight())
            Robot.makeDark();
    }

    public void makeLight(){
        if (onDark()){
            Robot.makeLight();
        }
    }

    public void changeSquare(){
        if (onLight())
            Robot.makeDark();
        else
            Robot.makeLight();
    }

    public void CLOSE(){
        System.out.println("Finished");
        System.exit(0);
    }


    public void PAUSE(){
        System.out.println("Paused");
        while (true){
            try{
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };

                runnable.run();
            }catch (Exception ignored){}
        }
    }

}

enum Delay{
    FASTER (0.00005),
    FAST (0.0005),
    MEDIUM (0.005),
    SLOW (0.05),
    SLOWER (0.5);

    private double speed;

    public double getSpeed(){
        return this.speed;
    }

    private Delay(double speed){
        this.speed = speed;
    }
}
