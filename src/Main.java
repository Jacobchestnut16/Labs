public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        RobotUtil rob = new RobotUtil("maze.txt", Delay.SLOW);
        rob.moveEndForward();
        rob.turnLeft();
        rob.moveEndForward();
    }




/*
    //public static RobotUtil rob = new RobotUtil("maze.txt", Delay.MEDIUM);

    //sort();
    int y = 0;
        while (!Robot.onDark()){
        moveForwardUntilPoint();
        if (rob.onLight()) {
            decideTurn();
            rob.moveForward();
        }
    }

    // rob = new RobotUtil("maze1.txt", Delay.MEDIUM);

        while (!Robot.onDark()){
        y++;
        moveForwardUntilPoint();
        if (rob.onLight()) {
            decideTurn();
            rob.moveForward();
        }
    }

    public static void decideTurn(){
        if (!rob.isLeftClear() && !rob.isForwardClear() && !rob.isRightClear()){
            rob.turnAround();
            System.err.println("Turning Around");
        }
        else if (rob.isRightClear()){
            rob.turnRight();
            System.err.println("Turning Right");
        }else{
            rob.turnLeft();
            System.err.println("Turning Left");
        }
    }

    public static void moveForwardUntilPoint(){
        while (rob.isForwardClear() && !rob.isRightClear()){
            System.err.println("Moving");
            rob.moveForward();
        }
    }


 */


}