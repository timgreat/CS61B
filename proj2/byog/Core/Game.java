package byog.Core;

import byog.SaveDemo.World;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.io.*;
import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
        
    }


    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input)  {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().

        TETile[][] finalWorldFrame = null;
        int seed=Integer.valueOf(input.substring(1,5));

        RandomUtils rt=new RandomUtils();

        ter.initialize(WIDTH, HEIGHT);
        boolean flag=false;
        for(int i=0;i<input.length();i++){
            char index=input.charAt(i);
            switch (index){
                case 'n':
                    String s="";
                    for(int j=i+1;j<input.length();j++){
                        char mid=input.charAt(j);
                        if(mid>='0'&&mid<='9')
                            s=s+mid;
                        else{
                            i=j-1;
                            break;
                        }
                    }
                    generateWorld(finalWorldFrame,Integer.valueOf(s));
                    try {
                        wait(10000);
                    }catch (InterruptedException e){
                        System.out.println(e);
                        System.exit(0);
                    }
                    break;
                case 'l':
                    finalWorldFrame=loadWorld();
                    break;
                case 'q':
                    saveWorld(finalWorldFrame);
                    break;
                default:
            }
            ter.renderFrame(finalWorldFrame);
        }
        return finalWorldFrame;
    }

    private void generateWorld(TETile[][] world,int seed){
        // initialize tiles
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        Random r=new Random(seed);
        int roomNum=RandomUtils.uniform(r,1,30);
        int hallwaysNum=RandomUtils.uniform(r,1,20);

    }
    private TETile[][] loadWorld(){
        File f = new File("./world.ser");
        try {
            FileInputStream fs = new FileInputStream(f);
            ObjectInputStream os = new ObjectInputStream(fs);
            TETile[][] loadWorld = (TETile[][]) os.readObject();
            os.close();
            return loadWorld;
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            System.exit(0);
        }
        TETile[][] world=new TETile[WIDTH][HEIGHT];
        generateWorld(world,0);
        return world;
    }
    private void saveWorld(TETile[][] world){
        File f = new File("./world.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(world);
            os.close();
        }  catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
